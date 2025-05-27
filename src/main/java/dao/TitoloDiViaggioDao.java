package dao;

import entites.TitoloDiViaggio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TitoloDiViaggioDao {

    private final EntityManagerFactory emf;

    public TitoloDiViaggioDao() {
        this.emf = Persistence.createEntityManagerFactory("postgres"); 
    }

    public TitoloDiViaggio getById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(TitoloDiViaggio.class, id);
        } finally {
            em.close();
        }
    }

    public void save(TitoloDiViaggio titoloDiViaggio) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(titoloDiViaggio);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            TitoloDiViaggio titoloDiViaggio = em.find(TitoloDiViaggio.class, id);
            if (titoloDiViaggio != null) {
                em.remove(titoloDiViaggio);
            }
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}