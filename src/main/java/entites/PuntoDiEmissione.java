package entites;

import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;
@Entity

public class PuntoDiEmissione {
    private String nome;
    private List<TitoloDiViaggio> titoloDiViaggioList;

    public PuntoDiEmissione(String nome,  List titoloDiViaggioList) {
        this.nome = nome;

        this.titoloDiViaggioList = (titoloDiViaggioList != null) ? titoloDiViaggioList : new ArrayList<>();

    }


    @Override
    public String toString() {
        return "PuntoDiEmissione{" +
                 '\'' +
                ", nome='" + nome + '\'' +
                ", titoloDiViaggioList=" + titoloDiViaggioList +
                '}';
    }
}
