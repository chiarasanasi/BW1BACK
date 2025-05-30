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
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
    public Biglietto() {
    }

    public Biglietto(LocalDate dataEmissione, TipoDistributore tipoDistributore, PuntoDiEmissione puntoDiEmissione, Vidimazione vidimazione, Utente utente) {
        super(dataEmissione, tipoDistributore, puntoDiEmissione);
        this.vidimazione = vidimazione;
        this.utente = utente;
    }

    public Biglietto(LocalDate dataEmissione, TipoDistributore tipoDistributore, PuntoDiEmissione puntoDiEmissione, Vidimazione vidimazione, Utente utente, Mezzo mezzo, LocalDate dataVidimazione) {
        super(dataEmissione, tipoDistributore, puntoDiEmissione);
        this.mezzo = mezzo;
        this.dataVidimazione = dataVidimazione;
        this.vidimazione = vidimazione;
        this.utente = utente;
    }

    public Biglietto(LocalDate dataEmissione, TipoDistributore tipoDistributore, PuntoDiEmissione puntoDiEmissione, Mezzo mezzo) {
        super(dataEmissione, tipoDistributore, puntoDiEmissione);
        this.mezzo = mezzo;
    }

    public Biglietto(LocalDate dataEmissione, TipoDistributore tipoDistributore, PuntoDiEmissione puntoDiEmissione, Utente utente, Vidimazione vidimazione) {
        super(dataEmissione, tipoDistributore, puntoDiEmissione);
        this.utente = utente;
        this.vidimazione = vidimazione;
    }


    public Biglietto(LocalDate dataEmissione, TipoDistributore tipoDistributore, PuntoDiEmissione puntoDiEmissione, Mezzo mezzo, Vidimazione vidimazione, LocalDate dataVidimazione) {
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

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "id=" + id +
                ", mezzo=" + mezzo +
                ", vidimazione=" + vidimazione +
                ", dataVidimazione=" + dataVidimazione +
                ", utente=" + utente +
                "} " + super.toString();
    }
}
