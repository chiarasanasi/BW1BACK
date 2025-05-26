package entites;

public class DistributoreAutomatico extends PuntoDiEmissione {
    private boolean attivo;

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
