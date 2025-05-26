package entites;

import enumeration.TipoDistributore;
import enumeration.Vidimazione;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class Biglietto extends TitoloDiViaggio {


    @Enumerated(EnumType.STRING)
    private Vidimazione vidimazione;
    @Id
    @GeneratedValue

    private  Long id;



    public Biglietto(LocalDate dataEmissione, LocalDate dataScadenza, TipoDistributore tipoDistributore, Vidimazione vidimazione) {
        super(dataEmissione, dataScadenza, tipoDistributore);
        this.vidimazione = vidimazione;
    }

    public Biglietto() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Vidimazione getVidimazione() {
        return vidimazione;
    }

    public void setVidimazione(Vidimazione vidimazione) {
        this.vidimazione = vidimazione;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "id=" + id +
                ", vidimazione=" + vidimazione +
                '}';
    }
}
