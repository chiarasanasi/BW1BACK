package entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jdk.jfr.Experimental;

import java.util.List;

@Entity

public class DistributoreAutomatico extends PuntoDiEmissione {
    @Id
    @GeneratedValue
    private Long id;

    private Boolean attivo;


    public DistributoreAutomatico(String nome, List<TitoloDiViaggio> titoloDiViaggioList, boolean attivo) {
        super(nome,  titoloDiViaggioList);
        this.attivo = attivo;
    }
    public boolean isAttivo(){
    return attivo;
    }
    public void setAttivo(boolean attivo){
        this.attivo=attivo;
    }

    @Override
    public String toString() {
        return "DistributoreAutomatico{" +
                "attivo=" + attivo +
                "} " + super.toString();
    }
}
