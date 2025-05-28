package entites;

import enumeration.TipoMezzo;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "mezzi")
public class Mezzo {
    @Id
    @GeneratedValue
    private Long id;
    private int capienza;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_mezzo")
    private TipoMezzo tipoMezzo;
    @Column(name = "periodo_servizio")
    private LocalDate periodoServizio;
    @Column(name = "periodo_manutenzione")
    private LocalDate periodoManutenzione;
//
//    private ServizioManutenzione servizioEffettivo;

    @OneToMany(mappedBy = "mezzo")
    private List<Biglietto> bigliettiVidimati;
    @OneToMany(mappedBy = "mezzo")
    private List<Percorrenza> mezzoPercorrenze;
    @OneToOne
    @JoinColumn(name = "servizio_manutenzione_id")
    private ServizioManutenzione servizioManutenzione;

    public Mezzo() {
    }

    public Mezzo(int capienza, TipoMezzo tipoMezzo) {
        this.capienza = capienza;
        this.tipoMezzo = tipoMezzo;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    public TipoMezzo getTipoMezzo() {
        return tipoMezzo;
    }

    public void setTipoMezzo(TipoMezzo tipoMezzo) {
        this.tipoMezzo = tipoMezzo;
    }

    public LocalDate getPeriodoServizio() {
        return periodoServizio;
    }

    public void setPeriodoServizio(LocalDate periodoServizio) {
        this.periodoServizio = periodoServizio;
    }

    public LocalDate getPeriodoManutenzione() {
        return periodoManutenzione;
    }

    public void setPeriodoManutenzione(LocalDate periodoManutenzione) {
        this.periodoManutenzione = periodoManutenzione;
    }

    public ServizioManutenzione getServizioManutenzione() {
        return servizioManutenzione;
    }

    public void setServizioManutenzione(ServizioManutenzione servizioManutenzione) {
        this.servizioManutenzione = servizioManutenzione;
    }
//    public ServizioManutenzione getServizioEffettivo() {
//        return servizioEffettivo;
//    }
//
//    public void setServiziEffettivi(ServizioManutenzione servizioEffettivo) {
//        this.servizioEffettivo = servizioEffettivo;
//    }

    public List<Biglietto> getBigliettiVidimati() {
        return bigliettiVidimati;
    }

    public void setBigliettiVidimati(List<Biglietto> bigliettiVidimati) {
        this.bigliettiVidimati = bigliettiVidimati;
    }

    public List<Percorrenza> getMezzoPercorrenze() {
        return mezzoPercorrenze;
    }

    public void setMezzoPercorrenze(List<Percorrenza> mezzoPercorrenze) {
        this.mezzoPercorrenze = mezzoPercorrenze;
    }

    @Override
    public String toString() {
        return "Mezzo{" +
                "id=" + id +
                ", capienza=" + capienza +
                ", tipoMezzo=" + tipoMezzo +
                ", periodoServizio=" + periodoServizio +
                ", periodoManutenzione=" + periodoManutenzione +
//                ", servizio Effettivo=" + servizioEffettivo +
                ", bigliettiVidimati=" + bigliettiVidimati +
                '}';
    }
}
