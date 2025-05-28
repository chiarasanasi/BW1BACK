package entites;

import enumeration.TipoDistributore;
import enumeration.Vidimazione;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Biglietto extends TitoloDiViaggio {
    @Id
    @GeneratedValue
    private  Long id;
    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzo;
    @Enumerated(EnumType.STRING)
    private Vidimazione vidimazione;
    @Column(name = "data_vidimazione")
    private LocalDate dataVidimazione;


    public Biglietto() {
    }

    public Biglietto(LocalDate dataEmissione, TipoDistributore tipoDistributore, PuntoDiEmissione puntoDiEmissione,Mezzo mezzo, Vidimazione vidimazione, LocalDate dataVidimazione) {
        super(dataEmissione, tipoDistributore, puntoDiEmissione);
        this.mezzo = mezzo;
        this.vidimazione = vidimazione;
        this.dataVidimazione = dataVidimazione;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    public Vidimazione getVidimazione() {
        return vidimazione;
    }

    public void setVidimazione(Vidimazione vidimazione) {
        this.vidimazione = vidimazione;
    }

    public LocalDate getDataVidimazione() {
        return dataVidimazione;
    }

    public void setDataVidimazione(LocalDate dataVidimazione) {
        this.dataVidimazione = dataVidimazione;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "id=" + id +
                ", mezzo=" + mezzo +
                ", vidimazione=" + vidimazione +
                ", dataVidimazione=" + dataVidimazione +
                "} " + super.toString();
    }
}
