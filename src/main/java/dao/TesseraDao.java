package dao;

import entites.Tessera;
import entites.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TesseraDao {
    private EntityManager em;
    public TesseraDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    public  void saveTessera(Tessera tessera){
        em.getTransaction().begin();
        em.persist(tessera);
        em.getTransaction().commit();
        System.out.println("La tessera con ID " + tessera.getId() + " è stata aggiunta al DB" );
    }

    public Tessera getTesseraById(Long id){
        return em.find(Tessera.class,id);
    }

    public void deleteTesseraTramiteId(Long id){
        Tessera t = getTesseraById(id);

        if(t!=null){
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
            System.out.println("La tessera con ID " + t.getId() + " è stata rimossa dal DB");
        }else{
            System.out.println("Nessuna tessera con ID " + id + " è stata trovata");
        }
    }

    public void calcoloGiornoScadenzaTessera(Long id) {
        Tessera t = getTesseraById(id);

        if (t != null) {
            LocalDate oggi = LocalDate.now();
            LocalDate scadenza = t.getDataScadenza();

            long giorni = ChronoUnit.DAYS.between(oggi, scadenza);

            if (giorni >= 0) {
                System.out.println("La tessera scadrà tra " + giorni + " giorni.");
            } else {
                System.out.println("La tessera è scaduta da " + Math.abs(giorni) + " giorni.");
            }
        } else {
            System.out.println("Tessera non trovata.");
        }
    }

    public void rinnovoTessera(Long id) {
        Tessera t = getTesseraById(id);

        if (t != null) {
            em.getTransaction().begin();
            LocalDate nuovaScadenza = LocalDate.now().plusYears(1);
            t.setDataScadenza(nuovaScadenza);
            em.merge(t);
            em.getTransaction().commit();
            System.out.println("Tessera con ID " + id + " rinnovata fino al " + nuovaScadenza);
        } else {
            System.out.println("Tessera non trovata.");
        }
    }
    public Tessera creaTessera(LocalDate dataEmissione, Utente utente){
        Tessera t = new Tessera(dataEmissione);
        utente.setTessera(t);
        return t;
    }

}
