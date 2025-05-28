package entites;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "punto_di_emissione")
public abstract class PuntoDiEmissione {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    @OneToMany (mappedBy = "puntoDiEmissione")
    private List<TitoloDiViaggio> titoloDiViaggioList;

    public PuntoDiEmissione(String nome,  List titoloDiViaggioList) {
        this.nome = nome;
        this.titoloDiViaggioList = (titoloDiViaggioList != null) ? titoloDiViaggioList : new ArrayList<>();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<TitoloDiViaggio> getTitoloDiViaggioList() {
        return titoloDiViaggioList;
    }

    public void setTitoloDiViaggioList(List<TitoloDiViaggio> titoloDiViaggioList) {
        this.titoloDiViaggioList = titoloDiViaggioList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PuntoDiEmissione{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", titoloDiViaggioList=" + titoloDiViaggioList +
                '}';
    }
}
