package dao;


import entites.Percorrenza;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;


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

    public Double tempoMedioPercorrenza(Long trattaId) {
        EntityManager em = emf.createEntityManager();
        try {
            String query = "SELECT p.oraInizioTratta, p.oraFineTratta FROM Percorrenza p JOIN p.tratte t WHERE t.id = :trattaId";
            List<Object[]> results = em.createQuery(query, Object[].class)
                    .setParameter("trattaId", trattaId)
                    .getResultList();

            if (results.isEmpty()) {
                return null;
            }
            long totalMinutes = 0;
            for (Object[] row : results) {
                LocalTime inizio = (LocalTime) row[0];
                LocalTime fine = (LocalTime) row[1];
                totalMinutes += java.time.Duration.between(inizio, fine).toMinutes();
            }
            return totalMinutes / (double) results.size();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return null;

    }
    public Percorrenza creazionePercorrenza(LocalTime oraInizioTratta, LocalTime oraFineTratta){
        Percorrenza nuovaPercorrenza = new Percorrenza(oraInizioTratta, oraFineTratta);
        return nuovaPercorrenza;
    }



    }




