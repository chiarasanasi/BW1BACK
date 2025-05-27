package entites;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

@Entity
public class Percorrenza {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "ora_inizio_tratta")
    private LocalTime oraInizioTratta;
    @Column(name = "ora_fine_tratta")
    private LocalTime oraFineTratta;

    @ManyToOne
    @JoinColumn(name = "tratta_id")
    private List<Tratta> tratte;
    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private List<Mezzo> mezzi;


    public Percorrenza() {
    }

    public Percorrenza(LocalTime oraInizioTratta, LocalTime oraFineTratta) {
        this.oraInizioTratta = oraInizioTratta;
        this.oraFineTratta = oraFineTratta;
    }

    public LocalTime getOraInizioTratta() {
        return oraInizioTratta;
    }

    public void setOraInizioTratta(LocalTime oraInizioTratta) {
        this.oraInizioTratta = oraInizioTratta;
    }

    public LocalTime getOraFineTratta() {
        return oraFineTratta;
    }

    public void setOraFineTratta(LocalTime oraFineTratta) {
        this.oraFineTratta = oraFineTratta;
    }

    public List<Tratta> getTratte() {
        return tratte;
    }

    public void setTratte(List<Tratta> tratte) {
        this.tratte = tratte;
    }

    public List<Mezzo> getMezzi() {
        return mezzi;
    }

    public void setMezzi(List<Mezzo> mezzi) {
        this.mezzi = mezzi;
    }

    @Override
    public String toString() {
        return "Percorrenza{" +
                "id=" + id +
                ", oraInizioTratta=" + oraInizioTratta +
                ", oraFineTratta=" + oraFineTratta +
                ", tratte=" + tratte +
                ", mezzi=" + mezzi +
                '}';
    }
}
