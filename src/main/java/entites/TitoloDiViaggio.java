package entites;

import enumeration.TipoDistributore;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "titolo_di_viaggi")
public abstract class TitoloDiViaggio {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "data_emissione")
    private  LocalDate dataEmissione;
//    @Column(name = "data_scadenza" )
//    private  LocalDate dataScadenza;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_distributore")
    private TipoDistributore tipoDistributore;

    @ManyToOne
    @JoinColumn(name = "punto_di_emissione_id")
    private PuntoDiEmissione puntoDiEmissione;

    public TitoloDiViaggio() {
    }

    public TitoloDiViaggio( LocalDate dataEmissione, TipoDistributore tipoDistributore, PuntoDiEmissione puntoDiEmissione) {

        this.dataEmissione = dataEmissione;
        this.tipoDistributore = tipoDistributore;
        this.puntoDiEmissione = puntoDiEmissione;
    }



    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }



    public TipoDistributore getTipoDistributore() {
        return tipoDistributore;
    }

    public void setTipoDistributore(TipoDistributore tipoDistributore) {
        this.tipoDistributore = tipoDistributore;
    }

    @Override
    public String toString() {
        return "TitoloDiViaggio{" +
                ", dataEmissione=" + dataEmissione +
//                ", dataScadenza=" + dataScadenza +
                ", tipoDistributore=" + tipoDistributore +
                '}';
    }
}
