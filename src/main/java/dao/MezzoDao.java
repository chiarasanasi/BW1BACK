package dao;

import entites.Mezzo;
import jakarta.persistence.EntityManager;

public class MezzoDao {

    private EntityManager em;

    public MezzoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Mezzo mezzo){
        em.getTransaction().begin();
        em.persist(mezzo);
        em.getTransaction().commit();
    }

    public Mezzo getById(Long id){
        return em.find(Mezzo.class, id);
    }

    public void remove(Long id){
        Mezzo mezzo = getById(id);

        if(mezzo != null){
            em.getTransaction().begin();
            em.remove(mezzo);
            em.getTransaction().commit();
            System.out.println("Il mezzo " + mezzo + " è stato aggiunto al DB");
        } else {
            System.out.println("Il mezzo " + mezzo + " non esiste");
        }
    }
}
