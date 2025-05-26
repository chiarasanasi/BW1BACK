package entites;

import java.time.LocalTime;

public class Tratta {

    //Qui ci andrà la relazione ONE TO MANY con l'entità Mezzo

    private String zonaDiPartenza;
    private String capolinea;
    private LocalTime tempoPercorrenzaPrevisto;
    private LocalTime tempoPercorrenzaEffettivo;

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

    // To String

    @Override
    public String toString() {
        return "Tratta{" +
                "Zona di p artenza = '" + zonaDiPartenza + '\'' +
                ", Capolinea = '" + capolinea + '\'' +
                ", Tempo di percorrenza previsto = " + tempoPercorrenzaPrevisto +
                ", Tempo di percorrenza effettivo = " + tempoPercorrenzaEffettivo +
                '}';
    }
}
