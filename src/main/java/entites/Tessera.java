package entites;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tessera {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate dataEmissione;
    private LocalDate dataScadenza;

    //@OneToMany (mappedBy = "tessera", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Abbonamento> abbonamenti = new ArrayList<>();

    public Tessera() {
    }

    public Tessera(LocalDate dataEmissione, LocalDate dataScadenza) {
        this.dataEmissione = dataEmissione;
        this.dataScadenza = dataScadenza;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    @Override
    public String toString() {
        return "Tessera{" +
                "id=" + id +
                ", dataEmissione=" + dataEmissione +
                ", dataScadenza=" + dataScadenza +
                '}';
    }
}
