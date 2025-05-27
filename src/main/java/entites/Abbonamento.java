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

    public Abbonamento() {
    }

    public Abbonamento(LocalDate dataEmissione, LocalDate dataScadenza, TipoDistributore tipoDistributore, Validita validita) {
        super(dataEmissione, dataScadenza, tipoDistributore);
        this.validita = validita;
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

    @Override
    public String toString() {
        return "Abbonamento{" +
                "id=" + id +
                ", validita=" + validita +
                "} " + super.toString();
    }
}
