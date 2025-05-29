package dao;

import entites.*;
import enumeration.TipoDistributore;
import enumeration.Vidimazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

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

    // Metodo Crea Biglietto Utente
    public void creaBiglietto(Scanner scanner) {
        try {
            System.out.println("Inserisci ID Utente:");
            Long idUtente = scanner.nextLong();
            Utente utente = em.find(Utente.class, idUtente);
            if (utente == null) {
                System.out.println("Utente non trovato!");
                return;
            }

            System.out.println("Inserisci ID Mezzo:");
            Long idMezzo = scanner.nextLong();
            Mezzo mezzo = em.find(Mezzo.class, idMezzo);
            if (mezzo == null) {
                System.out.println("Mezzo non trovato!");
                return;
            }

            System.out.println("Inserisci ID Punto di Emissione:");
            Long idPunto = scanner.nextLong();
            PuntoDiEmissione punto = em.find(PuntoDiEmissione.class, idPunto);
            if (punto == null) {
                System.out.println("Punto di emissione non trovato!");
                return;
            }

            scanner.nextLine(); // consuma newline
            System.out.println("Inserisci tipo distributore (AUTOMATICO, RIVENDITORE_AUTORIZZATO):");
            String tipoDiStr = scanner.nextLine().toUpperCase();
            TipoDistributore tipo = TipoDistributore.valueOf(tipoDiStr);

            //Genera codice univoco
            String codice = "BIG-" + System.currentTimeMillis();

            //Crea il biglietto
            Biglietto biglietto = new Biglietto();
            biglietto.setMezzo(mezzo);
            biglietto.setPuntoDiEmissione(punto);
            biglietto.setTipoDistributore(tipo);
            biglietto.setDataEmissione(LocalDate.now());
            biglietto.setVidimazione(Vidimazione.NON_VIDIMATO);
            biglietto.setUtente(utente);
            
            //Salva nel DB
            em.getTransaction().begin();
            em.persist(biglietto);
            em.getTransaction().commit();

            System.out.println("Biglietto creato con successo! Codice: " + codice);
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Errore durante la creazione del biglietto: " + e.getMessage());
        }
    }


        public Long numeroDiBigliettiInUnDatoPeriodo (LocalDate inizio, LocalDate fine){
            // Crea una TypedQuery che conta il numero di biglietti emessi tra due date
            TypedQuery<Long> query = em.createQuery(
                    "SELECT COUNT(b) FROM Biglietto b WHERE b.dataEmissione BETWEEN :inizio AND :fine",
                    Long.class);
            // Imposta i parametri della query con le date fornite
            query.setParameter("inizio", inizio);
            query.setParameter("fine", fine);
            return query.getSingleResult();// Esegue la query e restituisce il risultato
        }

        public boolean controlloValiditaAbbonamentoTramiteIdTessera (Long idTessera, LocalDate oggi){
            // Crea una TypedQuery per selezionare abbonamenti validi associati a una tessera specifica
            //e con data di scadenza non passata.
            TypedQuery<Abbonamento> query = em.createQuery(
                    "SELECT a FROM Abbonamento a WHERE a.tessera.id = :idTessera AND a.dataScadenza >= :oggi",
                    Abbonamento.class);
            // Imposta i parametri della query con l'ID della tessera e la data odierna
            query.setParameter("idTessera", idTessera);
            query.setParameter("oggi", oggi);
            return !query.getResultList().isEmpty(); // Verifica se esistono abbonamenti validi e restituisce true se almeno uno è presente

        }

        public List<Biglietto> ricercaBigliettipermezzoid (Long idMezzo){
            // Crea una TypedQuery per selezionare biglietti associati a un mezzo specifico
            TypedQuery<Biglietto> query = em.createQuery(
                    "SELECT b FROM Biglietto b WHERE b.mezzo.id = :idMezzo",
                    Biglietto.class);
            query.setParameter("idMezzo", idMezzo);
            return query.getResultList(); // Esegue la query e restituisce la lista dei biglietti

        }


        public List<Biglietto> ricercaBigliettiVidimatiPerPeriodo (LocalDate inizio, LocalDate fine){
            // Crea una query per selezionare tutti i biglietti vidimati in un determinato intervallo di tempo
            return em.createQuery(
                    // JPQL: seleziona tutti i Biglietti con stato di vidimazione = VIDIMATO e dataEmissione compresa tra inizio e fine
                            "SELECT b FROM Biglietto b WHERE b.vidimazione = :stato AND b.dataEmissione BETWEEN :inizio AND :fine",
                            Biglietto.class)
                    .setParameter("stato", Vidimazione.VIDIMATO)
                    .setParameter("inizio", inizio)
                    .setParameter("fine", fine)
                    .getResultList();
        }

        public List<Biglietto> ricercaBigliettiVidimatiTramiteMezzo(Long IdMezzo){
        TypedQuery<Biglietto> query = em.createQuery
                ("select b from Biglietto b where b.mezzo.id = :idMezzo AND b.vidimazione = :stato", Biglietto.class);
        query.setParameter("idMezzo", IdMezzo);
        query.setParameter("stato", Vidimazione.VIDIMATO);
        return query.getResultList();
        }

    }


