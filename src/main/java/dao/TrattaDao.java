package dao;

import entites.Tratta;
import jakarta.persistence.EntityManager;

public class TrattaDao {

    private EntityManager em;

    public TrattaDao(EntityManager em) {
        this.em = em;
    }

    public void save(Tratta tratta) {
        em.getTransaction().begin();
        if (tratta.getId() == null) {
            em.persist(tratta);
        } else {
            em.merge(tratta);
        }
        em.getTransaction().commit();
    }

    public Tratta getById(Long id) {
        return em.find(Tratta.class, id);
    }
    
    public void remove(Long id) {
        Tratta tratta = getById(id);

        if (tratta != null) {
            em.getTransaction().begin();
            em.remove(tratta);
            em.getTransaction().commit();
        } else {
            System.out.println("La tratta con ID " + id + " non esiste.");
        }
    }
}
