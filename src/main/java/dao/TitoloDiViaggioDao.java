package dao;

import entites.Abbonamento;
import entites.Biglietto;
import entites.TitoloDiViaggio;
import enumeration.Vidimazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

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

        public Long numeroDiBigliettiInUnDatoPeriodo (LocalDate inizio, LocalDate fine){

            TypedQuery<Long> query = em.createQuery(
                    "SELECT COUNT(b) FROM Biglietto b WHERE b.dataEmissione BETWEEN :inizio AND :fine",
                    Long.class);
            query.setParameter("inizio", inizio);
            query.setParameter("fine", fine);
            return query.getSingleResult();
        }

        public boolean controlloValiditaAbbonamentoTramiteIdTessera (Long idTessera, LocalDate oggi){
            TypedQuery<Abbonamento> query = em.createQuery(
                    "SELECT a FROM Abbonamento a WHERE a.tessera.id = :idTessera AND a.dataScadenza >= :oggi",
                    Abbonamento.class);
            query.setParameter("idTessera", idTessera);
            query.setParameter("oggi", oggi);
            return !query.getResultList().isEmpty();

        }

        public List<Biglietto> ricercaBiglietti (Long idMezzo){
            TypedQuery<Biglietto> query = em.createQuery(
                    "SELECT b FROM Biglietto b WHERE b.mezzo.id = :idMezzo",
                    Biglietto.class);
            query.setParameter("idMezzo", idMezzo);
            return query.getResultList();

        }

        public List<Biglietto> ricercaBigliettiVidimatiPerPeriodo (LocalDate inizio, LocalDate fine){
            return em.createQuery(
                            "SELECT b FROM Biglietto b WHERE b.vidimazione = :stato AND b.dataEmissione BETWEEN :inizio AND :fine",
                            Biglietto.class)
                    .setParameter("stato", Vidimazione.VIDIMATO)
                    .setParameter("inizio", inizio)
                    .setParameter("fine", fine)
                    .getResultList();
        }
    }


