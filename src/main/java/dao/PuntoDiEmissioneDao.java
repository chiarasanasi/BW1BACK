package dao;

import entites.DistributoreAutomatico;
import entites.PuntoDiEmissione;
import entites.RivenditoreAutorizzato;
import entites.TitoloDiViaggio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

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


    // Metodo 10: biglietti per punto di emissione
    //public List<TitoloDiViaggio> listaBigliettiPerPuntoDiEmissione(Long idPuntoEmissione) {
       // TypedQuery<TitoloDiViaggio> = "SELECT b FROM TitoloDiViaggio t WHERE t.puntoDiEmissione.id = :id";
       // return em.createQuery(jpql, TitoloDiViaggio.class)
        //        .setParameter("id", idPuntoEmissione)
          //      .getResultList();





    // Metodo 11: punti di emissione che hanno emesso almeno un titolo di viaggio
    public List<PuntoDiEmissione> listaPuntiDiEmissioneConTitoli() {
        TypedQuery<PuntoDiEmissione> query = em.createQuery("SELECT p FROM PuntoDiEmissione p ", PuntoDiEmissione.class);
        return query.getResultList();

    }

}


