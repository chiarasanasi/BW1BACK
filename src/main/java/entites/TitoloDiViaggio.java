package entites;

import enumeration.TipoDistributore;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "titolo_di_viaggi")
public abstract class TitoloDiViaggio {

    @Column(name = "data_emissione")
    private  LocalDate dataEmissione;
    @Column(name = "data_scadenza" )
    private  LocalDate dataScadenza;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_distributore")
    private TipoDistributore tipoDistributore;
    @ManyToOne
    @JoinColumn(name = "punto_di_emissione_id")

    private PuntoDiEmissione puntoDiEmissione;
    public TitoloDiViaggio() {
    }

    public TitoloDiViaggio( LocalDate dataEmissione, LocalDate dataScadenza, TipoDistributore tipoDistributore) {

        this.dataEmissione = dataEmissione;
        this.dataScadenza = dataScadenza;
        this.tipoDistributore = tipoDistributore;
    }



    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
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
                ", dataScadenza=" + dataScadenza +
                ", tipoDistributore=" + tipoDistributore +
                '}';
    }
}
