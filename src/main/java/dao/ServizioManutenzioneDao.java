package dao;

import entites.Mezzo;
import entites.Percorrenza;
import entites.ServizioManutenzione;
import enumeration.StatoServizio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ServizioManutenzioneDao {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    public void salva(ServizioManutenzione s) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public ServizioManutenzione trovaPerId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(ServizioManutenzione.class, id);
        } finally {
            em.close();
        }
    }

    public ServizioManutenzione aggiornaServizioManutenzione(Mezzo mezzo, EntityManager em) {

        Scanner scanner = new Scanner(System.in);
        MezzoDao mezzoDao = new MezzoDao(em);

        if (mezzo.getServizioManutenzione() == null) {
            System.out.println("Lo stato di servizio del mezzo è nullo. Per aggiornarlo devi prima impostarne uno");

            System.out.println("Vuoi impostare lo stato in IN_SERVIZIO o IN_MANUTENZIONE ?");
            String statoInput = scanner.nextLine().toUpperCase();
            StatoServizio statoServizio;
            try {
                statoServizio = StatoServizio.valueOf(statoInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Valore non valido. Stato impostato a IN_SERVIZIO di default.");
                statoServizio = StatoServizio.IN_SERVIZIO;
            }

            if (statoServizio.equals(StatoServizio.IN_SERVIZIO)) {

                System.out.println("Ora dovrai inserire la data di fine servizio con il seguente formato --> yyyy-mm-dd");

                try {
                    LocalDate dataFine = LocalDate.parse(scanner.nextLine());

                    ServizioManutenzione servizio = new ServizioManutenzione(statoServizio, LocalDate.now(), dataFine, true);

                    mezzo.setServizioManutenzione(servizio); // --> lato proprietario
                    mezzoDao.save(mezzo);

                    System.out.println("Creato nuovo ServizioManutenzione con stato " + statoServizio);
                } catch (IllegalArgumentException e) {
                    System.out.println("Stato del servizio non valido. Operazione annullata.");
                    em.getTransaction().rollback();

                } catch (DateTimeParseException e) {
                    System.out.println("Una delle date inserite non è nel formato corretto (yyyy-mm-dd). Operazione annullata.");
                    em.getTransaction().rollback();
                }
            } else if (statoServizio.equals(StatoServizio.IN_MANUTENZIONE)) {
                System.out.println("Ora dovrai inserire la data di fine manutenzione con il seguente formato --> yyyy-mm-dd");

                try {
                    LocalDate dataFine = LocalDate.parse(scanner.nextLine());

                    ServizioManutenzione servizio = new ServizioManutenzione(statoServizio, LocalDate.now(), dataFine);

                    mezzo.setServizioManutenzione(servizio); // --> lato proprietario
                    mezzoDao.save(mezzo);

                    System.out.println("Creato nuovo ServizioManutenzione con stato " + statoServizio);
                } catch (IllegalArgumentException e) {
                    System.out.println("Stato del servizio non valido. Operazione annullata.");
                    em.getTransaction().rollback();

                } catch (DateTimeParseException e) {
                    System.out.println("Una delle date inserite non è nel formato corretto (yyyy-mm-dd). Operazione annullata.");
                    em.getTransaction().rollback();
                }
            }
        } else if (mezzo.getServizioManutenzione() != null && mezzo.getServizioManutenzione().getStatoServizio().equals(StatoServizio.IN_SERVIZIO)) {
            System.out.println("Il tuo mezzo al momento è IN SERVIZIO.");
            System.out.println("Lo stato verrà cambiato in IN_MANUTENZIONE");

            mezzo.getServizioManutenzione().setStatoServizio(StatoServizio.IN_MANUTENZIONE);
            StatoServizio statoServizio = mezzo.getServizioManutenzione().getStatoServizio();

            System.out.println("Ora dovrai inserire la date di fine manutenzione con il seguente formato --> yyyy-mm-dd");
            try {
                LocalDate dataFine = LocalDate.parse(scanner.nextLine());

                ServizioManutenzione servizio = new ServizioManutenzione(statoServizio, LocalDate.now(), dataFine);

                mezzo.setServizioManutenzione(servizio); // --> lato proprietario
                mezzoDao.save(mezzo);

                System.out.println("Creato nuovo ServizioManutenzione con stato " + statoServizio);
            } catch (IllegalArgumentException e) {
                System.out.println("Stato del servizio non valido. Operazione annullata.");
                em.getTransaction().rollback();

            } catch (DateTimeParseException e) {
                System.out.println("Una delle date inserite non è nel formato corretto (yyyy-mm-dd). Operazione annullata.");
                em.getTransaction().rollback();
            }

            System.out.println("MODIFICA DELLO STATO DI SERVIZIO ANDATO A BUON FINE !!");
            System.out.println("Dettagli della modifica : ");
        }else if (mezzo.getServizioManutenzione() != null && mezzo.getServizioManutenzione().getStatoServizio().equals(StatoServizio.IN_MANUTENZIONE)) {
            System.out.println("Il tuo mezzo al momento è IN_MANUTENZIONE.");
            System.out.println("Lo stato verrà cambiato in IN_SERVIZIO");

            mezzo.getServizioManutenzione().setStatoServizio(StatoServizio.IN_SERVIZIO);
            StatoServizio statoServizio = mezzo.getServizioManutenzione().getStatoServizio();

            System.out.println("Ora dovrai inserire la date di fine servizio prevista con il seguente formato --> yyyy-mm-dd");
            try {
                LocalDate dataFine = LocalDate.parse(scanner.nextLine());

                ServizioManutenzione servizio = new ServizioManutenzione(statoServizio, LocalDate.now(), dataFine);

                mezzo.setServizioManutenzione(servizio); // --> lato proprietario
                mezzoDao.save(mezzo);

                System.out.println("Creato nuovo ServizioManutenzione con stato " + statoServizio);
            } catch (IllegalArgumentException e) {
                System.out.println("Stato del servizio non valido. Operazione annullata.");
                em.getTransaction().rollback();

            } catch (DateTimeParseException e) {
                System.out.println("Una delle date inserite non è nel formato corretto (yyyy-mm-dd). Operazione annullata.");
                em.getTransaction().rollback();
            }
        }

        System.out.println("MODIFICA DELLO STATO DI SERVIZIO ANDATO A BUON FINE !!");
        System.out.println("Dettagli della modifica : " + mezzo);
        return mezzo.getServizioManutenzione();}
}
