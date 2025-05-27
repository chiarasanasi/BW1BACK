package dao;

import entites.TitoloDiViaggio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.function.Consumer;

public class TitoloDiViaggioDao {

    private final EntityManagerFactory emf;

    public TitoloDiViaggioDao() {
        this.emf = Persistence.createEntityManagerFactory("TrasportoPubblicoPU"); // Replace with your persistence unit name
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            action.accept(em);
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

    public TitoloDiViaggio getById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(TitoloDiViaggio.class, id);
        } finally {
            em.close();
        }
    }

    public List<TitoloDiViaggio> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<TitoloDiViaggio> query = em.createQuery("SELECT t FROM TitoloDiViaggio t", TitoloDiViaggio.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void save(TitoloDiViaggio titoloDiViaggio) {
        executeInsideTransaction(em -> em.persist(titoloDiViaggio));
    }

    public void delete(Long id) {
        executeInsideTransaction(em -> {
            TitoloDiViaggio titoloDiViaggio = em.find(TitoloDiViaggio.class, id);
            if (titoloDiViaggio != null) {
                em.remove(titoloDiViaggio);
            }
        });
    }

    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}

