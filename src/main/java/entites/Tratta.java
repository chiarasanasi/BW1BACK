package entites;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table
public class Tratta {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "zona_di_partenza")
    private String zonaDiPartenza;
    private String capolinea;
    @Column(name = "tempo_percorrenza_previsto")
    private LocalTime tempoPercorrenzaPrevisto;
    @Column(name = "tempo_percorrenza_effettivo")
    private LocalTime tempoPercorrenzaEffettivo;
    @OneToMany(mappedBy = "tratta")
    private List<Percorrenza> trattaPercorrenze;

    //Costruttore vuoto
    public Tratta() {
    }

    //Costruttore
    public Tratta(String zonaDiPartenza, String capolinea, LocalTime tempoPercorrenzaPrevisto, LocalTime tempoPercorrenzaEffettivo) {
        this.zonaDiPartenza = zonaDiPartenza;
        this.capolinea = capolinea;
        this.tempoPercorrenzaPrevisto = tempoPercorrenzaPrevisto;
        this.tempoPercorrenzaEffettivo = tempoPercorrenzaEffettivo;
    }

    //Getter and Setter

    public String getZonaDiPartenza() {
        return zonaDiPartenza;
    }

    public void setZonaDiPartenza(String zonaDiPartenza) {
        this.zonaDiPartenza = zonaDiPartenza;
    }

    public String getCapolinea() {
        return capolinea;
    }

    public void setCapolinea(String capolinea) {
        this.capolinea = capolinea;
    }

    public LocalTime getTempoPercorrenzaPrevisto() {
        return tempoPercorrenzaPrevisto;
    }

    public void setTempoPercorrenzaPrevisto(LocalTime tempoPercorrenzaPrevisto) {
        this.tempoPercorrenzaPrevisto = tempoPercorrenzaPrevisto;
    }

    public LocalTime getTempoPercorrenzaEffettivo() {
        return tempoPercorrenzaEffettivo;
    }

    public void setTempoPercorrenzaEffettivo(LocalTime tempoPercorrenzaEffettivo) {
        this.tempoPercorrenzaEffettivo = tempoPercorrenzaEffettivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // To String
    @Override
    public String toString() {
        return "Tratta{" +
                "id=" + id +
                ", zonaDiPartenza='" + zonaDiPartenza + '\'' +
                ", capolinea='" + capolinea + '\'' +
                ", tempoPercorrenzaPrevisto=" + tempoPercorrenzaPrevisto +
                ", tempoPercorrenzaEffettivo=" + tempoPercorrenzaEffettivo +
                '}';
    }
}
