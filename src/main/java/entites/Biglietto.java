package entites;

import enumeration.TipoDistributore;
import enumeration.Vidimazione;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Biglietto extends TitoloDiViaggio {

    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzo;
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


    public Long getId() {
        return id;
    }

   
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
