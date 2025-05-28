package dao;

import entites.Percorrenza;
import entites.ServizioManutenzione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ServizioManutenzioneDao {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    public void salva(ServizioManutenzione s) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public ServizioManutenzione trovaPerId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(ServizioManutenzione.class, id);
        } finally {
            em.close();
        }
    }
}
