package dao;

import entites.Mezzo;
import entites.ServizioManutenzione;
import enumeration.StatoServizio;
import enumeration.TipoMezzo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.security.PublicKey;
import java.util.List;

public class MezzoDao {

    private EntityManager em;

    public MezzoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Mezzo mezzo){
        em.getTransaction().begin();
        em.persist(mezzo);
        em.getTransaction().commit();
        System.out.println("Il mezzo " + mezzo.getId() + " è stato aggiunto al DB");
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
            System.out.println("Il mezzo " + id + " non esiste");
        }
    }

    public List<Mezzo> listaMezziManutenzione(){
        TypedQuery<Mezzo> query =
                em.createQuery("Select m from Mezzo m where m.servizioManutenzione.statoServizio =:stato", Mezzo.class);
        query.setParameter("stato", StatoServizio.IN_MANUTENZIONE);
        return query.getResultList();
    }

    public List<Mezzo> listaMezziInServizio(){
        TypedQuery<Mezzo> query =
                em.createQuery("Select m from Mezzo m where m.servizioManutenzione.statoServizio =:stato", Mezzo.class);
        query.setParameter("stato", StatoServizio.IN_SERVIZIO);
        return query.getResultList();
    }

    public void updateStatoMezzo(Long idMezzo, StatoServizio nuovoStato){
        em.getTransaction().begin();
        em.createQuery("update ServizioManutenzione sm set sm.statoServizio =:stato where sm.mezzo.id =:idMezzo")
                .setParameter("stato", nuovoStato)
                .setParameter("idMezzo", idMezzo)
                .executeUpdate();

        em.getTransaction().commit();
    }


    public long ripetizioneTrattaTramiteMezzo(Long idMezzo, Long idTratta) {
        String jpql = """
        SELECT COUNT(p)
        FROM Percorrenza p
        WHERE p.mezzo.id = :idMezzo AND p.tratta.id = :idTratta
    """;

        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
        query.setParameter("idMezzo", idMezzo);
        query.setParameter("idTratta", idTratta);

        return query.getSingleResult();
    }



    public Mezzo findByCapacitaAndTipo(int capacita, TipoMezzo tipo) {
        TypedQuery<Mezzo> query = em.createQuery(
                "SELECT m FROM Mezzo m WHERE m.capacita = :capacita AND m.tipo = :tipo", Mezzo.class);
        query.setParameter("capacita", capacita);
        query.setParameter("tipo", tipo);
        return query.getSingleResult();
    }





}
