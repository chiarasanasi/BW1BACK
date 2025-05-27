package dao;

import entites.Tessera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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
            System.out.println("Nessuna tessera con ID " + t.getId() + " è stata trovata");
        }

    }
}
