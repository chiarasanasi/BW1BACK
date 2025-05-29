package entites;

import enumeration.StatoServizio;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "servizi_manutenzioni")
public class ServizioManutenzione {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "stato_servizio")
    private StatoServizio statoServizio;
    @Column(name = "data_inizio_manutenzione")
    private LocalDate dataInizioManutenzione;
    @Column(name = "data_fine_manutenzione")
    private LocalDate dataFineManutenzione;
    @Column(name = "data_inizio_servizio")
    private LocalDate dataInizioServizio;
    @Column(name = "data_fine_servizio")
    private LocalDate dataFineServizio;
    @OneToOne(mappedBy = "servizioManutenzione" )
    private Mezzo mezzo;

    public ServizioManutenzione() {
    }

    public ServizioManutenzione(StatoServizio statoServizio, LocalDate dataInizioManutenzione, LocalDate dataFineManutenzione, LocalDate dataInizioServizio, LocalDate dataFineServizio) {
        this.statoServizio = statoServizio;
        this.dataInizioManutenzione = dataInizioManutenzione;
        this.dataFineManutenzione = dataFineManutenzione;
        this.dataInizioServizio = dataInizioServizio;
        this.dataFineServizio = dataFineServizio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatoServizio getStatoServizio() {
        return statoServizio;
    }

    public void setStatoServizio(StatoServizio statoServizio) {
        this.statoServizio = statoServizio;
    }

    public LocalDate getDataInizioManutenzione() {
        return dataInizioManutenzione;
    }

    public void setDataInizioManutenzione(LocalDate dataInizioManutenzione) {
        this.dataInizioManutenzione = dataInizioManutenzione;
    }

    public LocalDate getDataFineManutenzione() {
        return dataFineManutenzione;
    }

    public void setDataFineManutenzione(LocalDate dataFineManutenzione) {
        this.dataFineManutenzione = dataFineManutenzione;
    }

    public LocalDate getDataInizioServizio() {
        return dataInizioServizio;
    }

    public void setDataInizioServizio(LocalDate dataInizioServizio) {
        this.dataInizioServizio = dataInizioServizio;
    }

    public LocalDate getDataFineServizio() {
        return dataFineServizio;
    }

    public void setDataFineServizio(LocalDate dataFineServizio) {
        this.dataFineServizio = dataFineServizio;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    @Override
    public String toString() {
        return "ServizioManutenzione{" +
                "id=" + id +
                ", statoServizio=" + statoServizio +
                ", dataInizioManutenzione=" + dataInizioManutenzione +
                ", dataFineManutenzione=" + dataFineManutenzione +
                ", dataInizioServizio=" + dataInizioServizio +
                ", dataFineServizio=" + dataFineServizio +
                '}';
    }
}
