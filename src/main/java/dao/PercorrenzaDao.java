package dao;


import entites.Percorrenza;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

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



    public List<Long> ricercaTempiEffettiviTramiteTratta(Long trattaId) {
        EntityManager em = emf.createEntityManager();
        try {
            String jpql = "SELECT p.oraInizioTratta, p.oraFineTratta FROM Percorrenza p WHERE p.tratta.id = :trattaId";
            List<Object[]> results = em.createQuery(jpql, Object[].class)
                    .setParameter("trattaId", trattaId)
                    .getResultList();

            return results.stream()
                    .map(r -> java.time.Duration.between((LocalTime) r[0], (LocalTime) r[1]).toMinutes())
                    .toList();

        } finally {
            em.close();
        }
    }


    public Percorrenza creazionePercorrenza(LocalTime oraInizioTratta, LocalTime oraFineTratta){
        Percorrenza nuovaPercorrenza = new Percorrenza(oraInizioTratta, oraFineTratta);
        return nuovaPercorrenza;
    }

    public Double tempoMedioPercorrenzaPerMezzo(Long mezzoId) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Percorrenza> query = em.createQuery("SELECT p.oraInizioTratta, p.oraFineTratta FROM Percorrenza p WHERE p.mezzo.id = :mezzoId", Percorrenza.class);
                    query.setParameter("mezzoId", mezzoId);
                    query.getResultList();
                    List<Percorrenza> results = query.getResultList();

            if (results.isEmpty()) {
                System.out.println("NON c'è nessuna percorrenza");
            } else if(results.size() > 0){

            }

            long totalMinutes = 0;
            for (Object[] row : results) {
                LocalTime inizio = (LocalTime) row[0];
                LocalTime fine = (LocalTime) row[1];

                long durata = java.time.Duration.between(inizio, fine).toMinutes();
                if (durata < 0) {
                    durata += 24 * 60; // Gestisce gli orari dopo la mezzanotte
                }

                totalMinutes += durata;
            }

            return totalMinutes / (double) results.size();

        } catch (Exception e) {
            System.out.println("Errore nel calcolo tempo medio per mezzo: " + e.getMessage());
        } finally {
            em.close();
        }

        return null;
    }

    public Double tempoMedioPercorrenzaPerTrattaEMezzo(Long trattaId, Long mezzoId) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Object[]> query = em.createQuery(
                    "SELECT p.oraInizioTratta, p.oraFineTratta FROM Percorrenza p " +
                            "WHERE p.tratta.id = :trattaId AND p.mezzo.id = :mezzoId",
                    Object[].class
            );
            query.setParameter("trattaId", trattaId);
            query.setParameter("mezzoId", mezzoId);

            List<Object[]> results = query.getResultList();

            if (results.isEmpty()) return null;

            long totalMinutes = 0;
            for (Object[] row : results) {
                LocalTime inizio = (LocalTime) row[0];
                LocalTime fine = (LocalTime) row[1];

                long durata = java.time.Duration.between(inizio, fine).toMinutes();
                if (durata < 0) {
                    durata += 24 * 60;
                }

                totalMinutes += durata;
            }

            return totalMinutes / (double) results.size();

        } finally {
            em.close();
        }
    }




}




