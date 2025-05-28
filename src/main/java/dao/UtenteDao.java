package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import entites.Utente;
import jakarta.persistence.TypedQuery;

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

    //trova utente corrispondente per username e password
    public Utente trovaTramiteUsernamePassword(String username, String password){
        TypedQuery<Utente> query = em.createQuery("select u from Utente u where u.username = :username and u.password =:password", Utente.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.getSingleResult();
    }
}
