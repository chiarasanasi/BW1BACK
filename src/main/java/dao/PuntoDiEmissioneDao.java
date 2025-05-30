package dao;

import entites.DistributoreAutomatico;
import entites.PuntoDiEmissione;
import entites.RivenditoreAutorizzato;
import entites.TitoloDiViaggio;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public DistributoreAutomatico creazionePuntoDiEmissione(String nome) {
        DistributoreAutomatico distributore = new DistributoreAutomatico(nome, new ArrayList<>(), true);
        em.getTransaction().begin();
        em.persist(distributore);
        em.getTransaction().commit();
        return distributore;
    }

    public RivenditoreAutorizzato creazioneRivenditoreAutorizzato(String nome, String indirizzo) {
        RivenditoreAutorizzato rivenditore = new RivenditoreAutorizzato(nome, new ArrayList<>(), indirizzo);
        em.getTransaction().begin();
        em.persist(rivenditore);
        em.getTransaction().commit();
        return rivenditore;
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

    // Metodo 11: punti di emissione che hanno emesso almeno un titolo di viaggio
    public List<PuntoDiEmissione> listaPuntiDiEmissioneConTitoli() {
        String jpql = "SELECT DISTINCT t.puntoDiEmissione FROM TitoloDiViaggio t WHERE t.puntoDiEmissione IS NOT NULL";
        return em.createQuery(jpql, PuntoDiEmissione.class)
                .getResultList();
    }
}
