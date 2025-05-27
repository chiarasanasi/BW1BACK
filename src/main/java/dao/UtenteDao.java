package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import entites.Utente;

public class UtenteDao {

    private EntityManager em;

    public UtenteDao(EntityManager em) {
        this.em = em;
    }

    // Salva un utente
    public void salva(Utente utente) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(utente);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
    }

    // Ottieni un utente tramite ID
    public Utente get(Long id) {
        return em.find(Utente.class, id);
    }

    // Rimuovi un utente
    public void rimuovi(Utente utente) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.contains(utente) ? utente : em.merge(utente));
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
    }
}
