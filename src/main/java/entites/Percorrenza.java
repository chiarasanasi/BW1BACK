package entites;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class Percorrenza {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "ora_inizio_tratta")
    private LocalTime oraInizioTratta;
    @Column(name = "ora_fine_tratta")
    private LocalTime oraFineTratta;
<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name = "tratta_id")
    private Tratta tratta;
    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzo;
=======

@ManyToOne
@JoinColumn(name = "tratta_id")
private Tratta tratta;
@ManyToOne
@JoinColumn(name = "mezzo_id")
private Mezzo mezzo;
>>>>>>> Roberto

    public Percorrenza() {
    }

    public Percorrenza(LocalTime oraInizioTratta, LocalTime oraFineTratta) {
        this.oraInizioTratta = oraInizioTratta;
        this.oraFineTratta = oraFineTratta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    @Override
    public String toString() {
        return "Percorrenza{" +
                "id=" + id +
                ", oraInizioTratta=" + oraInizioTratta +
                ", oraFineTratta=" + oraFineTratta +
                ", tratta=" + tratta +
                ", mezzo=" + mezzo +
                '}';
    }
}
