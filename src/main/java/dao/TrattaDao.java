package dao;

import entites.Tratta;
import jakarta.persistence.EntityManager;

import java.time.LocalTime;

public class TrattaDao {
    private EntityManager em;
    public TrattaDao(EntityManager em) {
        this.em = em;
    }

    public void save(Tratta tratta) {
        em.getTransaction().begin();
        em.persist(tratta);
        em.getTransaction().commit();
        System.out.println("La tratta " + tratta.getId() + " è stato aggiunta.");
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

    // Metodo Tratta
    public void creaTratta(String partenza, String arrivo, LocalTime durataPrevista, LocalTime durataEffettiva) {
        Tratta nuovaTratta = new Tratta(partenza, arrivo, durataPrevista, durataEffettiva);
        save(nuovaTratta);
    }


}
