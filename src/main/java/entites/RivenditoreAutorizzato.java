package entites;

import jakarta.persistence.Entity;

import java.util.List;
@Entity

public class RivenditoreAutorizzato extends PuntoDiEmissione{
    private String indirizzo;

    public RivenditoreAutorizzato(String nome, List titoloDiViaggioList, String indirizzo) {
        super(nome, titoloDiViaggioList);
        this.indirizzo = indirizzo;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public RivenditoreAutorizzato(String nome, List titoloDiViaggioList) {
        super(nome, titoloDiViaggioList);
    }

    @Override
    public String toString() {
        return "RivenditoreAutorizzato{" +
                "indirizzo='" + indirizzo + '\'' +
                "} " + super.toString();
    }
}
