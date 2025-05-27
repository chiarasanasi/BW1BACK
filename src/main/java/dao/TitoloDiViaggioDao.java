package dao;

import entites.TitoloDiViaggio;
import jakarta.persistence.EntityManager;

public class TitoloDiViaggioDao {

    private EntityManager em;

    public TitoloDiViaggioDao(EntityManager em) {
        this.em = em;
    }

    public void save(TitoloDiViaggio titoloDiViaggio) {
        em.getTransaction().begin();
        em.persist(titoloDiViaggio);
        em.getTransaction().commit();
        System.out.println("Il titolo di viaggio con data emissione " + titoloDiViaggio.getDataEmissione() + " è stato aggiunto al DB");
    }

    public TitoloDiViaggio getById(Long id) {
        return em.find(TitoloDiViaggio.class, id);
    }

    public void remove(Long id) {
        TitoloDiViaggio titoloDiViaggio = getById(id);

        if (titoloDiViaggio != null) {
            em.getTransaction().begin();
            em.remove(titoloDiViaggio);
            em.getTransaction().commit();
            System.out.println("Il titolo di viaggio con data di emissione " + titoloDiViaggio.getDataEmissione() + " è stato rimosso dal DB");
        } else {
            System.out.println("Il titolo di viaggio con ID " + id + " non esiste");
        }
    }
}