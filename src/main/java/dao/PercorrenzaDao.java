package dao;


import entites.Percorrenza;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;


public class PercorrenzaDao {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    public void salva(Percorrenza p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Percorrenza trovaPerId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Percorrenza.class, id);
        } finally {
            em.close();
        }
    }

    public List<Percorrenza> trovaTutte() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Percorrenza p", Percorrenza.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void aggiorna(Percorrenza p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void elimina(Percorrenza p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Percorrenza attached = em.contains(p) ? p : em.merge(p);
            em.remove(attached);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void chiudi() {
        emf.close();

    }

}
