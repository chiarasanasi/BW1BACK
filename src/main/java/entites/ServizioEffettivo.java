package entites;

import enumeration.StatoServizio;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "servizi_effettivi")
public class ServizioEffettivo {
    @Id
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(name = "stato_servizio")
    private StatoServizio statoServizio;
    @Column(name = "data_inizio")
    private LocalDate dataInizio;
    @Column(name = "data_fine")
    private LocalDate dataFine;
    private Mezzo mezzo;

    public ServizioEffettivo(StatoServizio statoServizio, LocalDate dataInizio, LocalDate dataFine, Mezzo mezzo) {
        this.statoServizio = statoServizio;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.mezzo = mezzo;
    }

    public ServizioEffettivo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StatoServizio getStatoServizio() {
        return statoServizio;
    }

    public void setStatoServizio(StatoServizio statoServizio) {
        this.statoServizio = statoServizio;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    @Override
    public String toString() {
        return "ServizioEffettivo{" +
                "id=" + id +
                ", statoServizio=" + statoServizio +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", mezzo=" + mezzo +
                '}';
    }
}
