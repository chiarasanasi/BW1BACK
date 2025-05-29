package dao;

import entites.PuntoDiEmissione;
import jakarta.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import entites.TitoloDiViaggio;


public class PuntoDiEmissioneDao {
    private EntityManager em;

    public PuntoDiEmissioneDao(EntityManager em) {
        this.em = em;
    }

    public void save(PuntoDiEmissione punto) {
        em.getTransaction().begin();
        em.persist(punto);
        em.getTransaction().commit();
        System.out.println("Il punto di emissione " + punto.getId() + " è stato aggiunto.");
    }

    public PuntoDiEmissione getById(Long id) {
        return em.find(PuntoDiEmissione.class, id);
    }

    public void remove(Long id) {
        PuntoDiEmissione punto = getById(id);
        if (punto != null) {
            em.getTransaction().begin();
            em.remove(punto);
            em.getTransaction().commit();
            System.out.println("Il punto di emissione con ID " + id + " è stato rimosso.");
        } else {
            System.out.println("Il punto di emissione con ID " + id + " non esiste.");
        }
    }

    public PuntoDiEmissione creazionePuntoDiEmissione(String nome, List titoloDiViaggioList) {
        PuntoDiEmissione nuovoPuntodiEmissione = new PuntoDiEmissione(nome, titoloDiViaggioList);
        return nuovoPuntodiEmissione;
    }



    // Metodo 9: lista punti di emissione divisi per tipo
    public Map<String, List<PuntoDiEmissione>> listaPuntiDiEmissione() {
        List<PuntoDiEmissione> distributori = em.createQuery(
                        "SELECT p FROM PuntoDiEmissione p WHERE p.tipo = :tipo", PuntoDiEmissione.class)
                .setParameter("tipo", "DISTRIBUTORE")
                .getResultList();

        List<PuntoDiEmissione> rivenditori = em.createQuery(
                        "SELECT p FROM PuntoDiEmissione p WHERE p.tipo = :tipo", PuntoDiEmissione.class)
                .setParameter("tipo", "RIVENDITORE")
                .getResultList();

        Map<String, List<PuntoDiEmissione>> mappa = new HashMap<>();
        mappa.put("Distributori Automatici", distributori);
        mappa.put("Rivenditori Autorizzati", rivenditori);
        return mappa;
    }

    // Metodo 10: biglietti per punto di emissione
    public List<TitoloDiViaggio> listaBigliettiPerPuntoDiEmissione(Long idPuntoEmissione) {
        String jpql = "SELECT t FROM TitoloDiViaggio t WHERE t.puntoDiEmissione.id = :id";
        return em.createQuery(jpql, TitoloDiViaggio.class)
                .setParameter("id", idPuntoEmissione)
                .getResultList();
    }


}
