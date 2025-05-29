package entites;

import enumeration.TipoDistributore;
import enumeration.Validita;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Abbonamento extends TitoloDiViaggio {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "tessera_id")
    private Tessera tessera;
    @Enumerated(EnumType.STRING)
    private Validita validita;
    private LocalDate dataScadenza;
    public Abbonamento() {
    }

    public Abbonamento(LocalDate dataEmissione, TipoDistributore tipoDistributore, PuntoDiEmissione puntoDiEmissione, Tessera tessera, Validita validita, LocalDate dataScadenza) {
        super(dataEmissione, tipoDistributore, puntoDiEmissione);
        this.tessera = tessera;
        this.validita = validita;
        this.dataScadenza = dataScadenza;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Validita getValidita() {
        return validita;
    }

    public void setValidita(Validita validita) {
        this.validita = validita;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "id=" + id +
                ", tessera=" + tessera +
                ", validita=" + validita +
                ", dataScadenza=" + dataScadenza +
                "} " + super.toString();
    }
}
