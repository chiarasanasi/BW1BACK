import dao.*;
import entites.*;
import enumeration.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);

        UtenteDao utenteDao = new UtenteDao(em);
        TesseraDao tesseraDao = new TesseraDao();
        MezzoDao mezzoDao = new MezzoDao(em);
        PercorrenzaDao percorrenzaDao = new PercorrenzaDao();
        TitoloDiViaggioDao titoloDiViaggioDao = new TitoloDiViaggioDao(em);
        TrattaDao trattaDao = new TrattaDao(em);
        PuntoDiEmissioneDao puntoDiEmissioneDao = new PuntoDiEmissioneDao(em);
        ServizioManutenzioneDao servizioManutenzioneDao = new ServizioManutenzioneDao();


//        Utente u1 = new Utente("Chiara", "Sanasi", "chiarasan", "12345678", Ruolo.UTENTE_NORMALE);
//        Utente u2 = new Utente("Salvatore", "Gianquinto", "salvatore", "a2345678", Ruolo.UTENTE_NORMALE);
//        Utente u3 = new Utente("Leonard", "Dautaru", "leo", "b2345678", Ruolo.UTENTE_NORMALE);
//        Utente u4 = new Utente("Silvia", "Gasparini", "silvia", "c2345678", Ruolo.UTENTE_NORMALE);
//        Utente u5 = new Utente("Roberto", "Albergo", "rob", "d2345678", Ruolo.UTENTE_NORMALE);
//        Utente u6 = new Utente("Roberto", "Ciancio", "ciancio", "e2345678", Ruolo.UTENTE_NORMALE);
//        Utente u7 = new Utente("Pietro", "Sorbo", "pietro", "f2345678", Ruolo.UTENTE_NORMALE);
//
//        Utente u8 = new Utente("Vincenzo", "Napoli", "vinz", "g2345678", Ruolo.AMMINISTRATORE);
//
//        utenteDao.salva(u1);
//        utenteDao.salva(u2);
//        utenteDao.salva(u3);
//        utenteDao.salva(u4);
//        utenteDao.salva(u5);
//        utenteDao.salva(u6);
//        utenteDao.salva(u7);
//        utenteDao.salva(u8);
//
//        Tessera ts1 = new Tessera(LocalDate.of(2020, 1, 1));
//        Tessera ts2 = new Tessera(LocalDate.of(2020, 1, 1));
//        Tessera ts3 = new Tessera(LocalDate.of(2020, 1, 1));
//        Tessera ts4 = new Tessera(LocalDate.of(2020, 1, 1));
//
//        tesseraDao.saveTessera(ts1);
//        tesseraDao.saveTessera(ts2);
//        tesseraDao.saveTessera(ts3);
//        tesseraDao.saveTessera(ts4);
//
//
//        u1.setTessera(ts1);
//        u2.setTessera(ts2);
//        u3.setTessera(ts3);
//        u4.setTessera(ts4);
//
//        utenteDao.salva(u1);
//        utenteDao.salva(u2);
//        utenteDao.salva(u3);
//        utenteDao.salva(u4);
//
//        Mezzo m1 = new Mezzo(150, TipoMezzo.AUTOBUS);
//        Mezzo m2 = new Mezzo(250, TipoMezzo.AUTOBUS);
//        Mezzo m3 = new Mezzo(300, TipoMezzo.TRAM);
//        Mezzo m4 = new Mezzo(350, TipoMezzo.TRAM);
//
//        mezzoDao.save(m1);
//        mezzoDao.save(m2);
//        mezzoDao.save(m3);
//        mezzoDao.save(m4);
//
//        ServizioManutenzione s1 = new ServizioManutenzione(StatoServizio.IN_SERVIZIO, LocalDate.of(2000, 1, 1), LocalDate.of(2000, 3, 1), LocalDate.of(2000, 3, 2), LocalDate.now());
//        ServizioManutenzione s2 = new ServizioManutenzione(StatoServizio.IN_SERVIZIO, LocalDate.of(2022, 3, 12), LocalDate.of(2022, 6, 1), LocalDate.of(2022, 6, 3), LocalDate.now());
//        ServizioManutenzione s3 = new ServizioManutenzione(StatoServizio.IN_MANUTENZIONE, LocalDate.of(2025, 5, 1), LocalDate.now(), LocalDate.of(2023, 1, 1), LocalDate.of(2025, 4, 30));
//        ServizioManutenzione s4 = new ServizioManutenzione(StatoServizio.IN_MANUTENZIONE, LocalDate.of(2020, 1, 1), LocalDate.now(), LocalDate.of(2019, 3, 2), LocalDate.of(2019, 12, 31));
//
//        servizioManutenzioneDao.salva(s1);
//        servizioManutenzioneDao.salva(s2);
//        servizioManutenzioneDao.salva(s3);
//        servizioManutenzioneDao.salva(s4);
//
//        Percorrenza p1 = new Percorrenza(LocalTime.of(5, 0), LocalTime.of(23, 59));
//        Percorrenza p2 = new Percorrenza(LocalTime.of(6, 0), LocalTime.of(1, 0));
//        Percorrenza p3 = new Percorrenza(LocalTime.of(12, 0), LocalTime.of(3, 0));
//        Percorrenza p4 = new Percorrenza(LocalTime.of(15, 0), LocalTime.of(22, 59));
//
//        percorrenzaDao.salva(p1);
//        percorrenzaDao.salva(p2);
//        percorrenzaDao.salva(p3);
//        percorrenzaDao.salva(p4);
//
//        m1.setMezzoPercorrenze(List.of(p1, p2));
//        m2.setMezzoPercorrenze(List.of(p2, p3));
//        m3.setMezzoPercorrenze(List.of(p1, p4));
//        m4.setMezzoPercorrenze(List.of(p3, p4));
//
//        mezzoDao.save(m1);
//        mezzoDao.save(m2);
//        mezzoDao.save(m3);
//        mezzoDao.save(m4);
//
//        Tratta t1 = new Tratta("Roma", "Milano", LocalTime.of(2, 30), LocalTime.of(2, 45));
//        Tratta t2 = new Tratta("Napoli", "Bari", LocalTime.of(1, 15), LocalTime.of(1, 20));
//        Tratta t3 = new Tratta("Torino", "Venezia", LocalTime.of(2, 0), LocalTime.of(2, 5));
//
//        Tratta t4 = new Tratta("Firenze", "Pisa", LocalTime.of(0, 45), LocalTime.of(0, 50));
//
//        trattaDao.save(t1);
//        trattaDao.save(t2);
//        trattaDao.save(t3);
//        trattaDao.save(t4);


//        ---------------------------------------------LOGIN / REGISTRAZIONE -----------------------------------------------------
        System.out.println("BENVENUTO!!");
        System.out.println("LOGIN --> 1 / REGISTRAZIONE --> 2");
        System.out.println("Digita 1 o 2 per continuare");
        int loginOregistrazione = scanner.nextInt();
        scanner.nextLine();

        Utente utenteLoggato = null;

        if (loginOregistrazione == 1) {
            System.out.println("Digita il tuo username");
            String username = scanner.nextLine();
            System.out.println("Digita la tua password");
            String password = scanner.nextLine();

            try {
                utenteLoggato = utenteDao.trovaTramiteUsernamePassword(username, password);
            } catch (Exception e) {
                System.out.println("Errore durante il login. Controlla le credenziali.");
            }
        } else if (loginOregistrazione == 2) {
            System.out.println("REGISTRAZIONE NUOVO UTENTE");

            System.out.print("Inserisci il tuo nome: ");
            String nome = scanner.nextLine();

            System.out.print("Inserisci il tuo cognome: ");
            String cognome = scanner.nextLine();

            System.out.print("Scegli uno username: ");
            String newUsername = scanner.nextLine();

            System.out.print("Scegli una password: ");
            String newPassword = scanner.nextLine();

            Ruolo ruolo = Ruolo.UTENTE_NORMALE;

            Utente nuovoUtente = new Utente(nome, cognome, newUsername, newPassword, ruolo);
            utenteDao.salva(nuovoUtente);

            System.out.println("Registrazione completata con successo!");
            System.out.println("Benvenut* " + nome + " " + cognome + ". Ora puoi effettuare il login.");

            return; // Termina qui per evitare di proseguire senza login valido
        } else {
            System.out.println("Scelta non valida. Terminazione programma.");
            return;
        }

        if (utenteLoggato != null && utenteLoggato.getRuolo().equals(Ruolo.UTENTE_NORMALE)) {

            System.out.println("Bentornat* " + utenteLoggato.getNome() + " !");
            System.out.println("Premi un tasto per accedere al Menù degli Utenti");
            scanner.next();
            int scelta = 100000;
            boolean sceltaWhile = true;

            while (sceltaWhile) {
                System.out.println("MENU" + "\n" +
                        "1 -> Crea Biglietto" + "\n" +
                        "2 -> Crea Tessera" + "\n" +
                        "3 -> Calcola il giorno della scadenza della tua tessera" + "\n" +
                        "4 -> Rinnova la tua tessera" + "\n" +
                        "5 -> Controlla la validità del tuo abbonamento tramite l'id della tessera" + "\n" +
                        "6 -> Crea un nuovo abbonamento" + "\n" +
                        "0 -> Termina il programma ! "
                );
                scelta = scanner.nextInt();
                scanner.nextLine();


                switch (scelta) {
                    case 1 -> {
                        Utente utente = null;
                        while (utente == null) {
                            try {
                                System.out.print("Inserisci ID Utente: ");
                                Long idUtente = scanner.nextLong();
                                utente = em.find(Utente.class, idUtente);
                                if (utente == null) {
                                    System.out.println("Utente non trovato! Riprova.");
                                }
                            } catch (Exception e) {
                                System.out.println("Input non valido per ID utente. Inserisci un numero.");
                                scanner.nextLine();
                            }
                        }

                        Mezzo mezzo = null;
                        while (mezzo == null) {
                            try {
                                System.out.print("Inserisci ID Mezzo: ");
                                Long idMezzo = scanner.nextLong();
                                mezzo = em.find(Mezzo.class, idMezzo);
                                if (mezzo == null) {
                                    System.out.println("Mezzo non trovato! Riprova.");
                                }
                            } catch (Exception e) {
                                System.out.println("Input non valido per ID mezzo. Inserisci un numero.");
                                scanner.nextLine();
                            }
                        }
                        PuntoDiEmissione punto = null;
                        while (punto == null) {
                            try {
                                System.out.print("Inserisci ID Punto di Emissione: ");
                                Long idPunto = scanner.nextLong();
                                punto = em.find(PuntoDiEmissione.class, idPunto);
                                if (punto == null) {
                                    System.out.println("Punto di emissione non trovato! Riprova.");
                                }
                            } catch (Exception e) {
                                System.out.println("Input non valido per ID punto di emissione.");
                                scanner.nextLine();
                            }
                        }
                        TipoDistributore tipo = null;
                        scanner.nextLine();
                        while (tipo == null) {
                            try {
                                System.out.print("Inserisci tipo distributore (AUTOMATICO, RIVENDITORE_AUTORIZZATO): ");
                                String tipoStr = scanner.nextLine().trim().toUpperCase();
                                tipo = TipoDistributore.valueOf(tipoStr);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Tipo non valido. Riprova.");
                            }
                        }
                        try {
                            LocalDate dataEmissione = LocalDate.now();
                            Biglietto nuovoBiglietto = titoloDiViaggioDao.creaBiglietto(dataEmissione, tipo, punto, mezzo);
                            nuovoBiglietto.setUtente(utente);

                            em.getTransaction().begin();
                            em.persist(nuovoBiglietto);
                            em.getTransaction().commit();

                            System.out.println("Biglietto creato con successo!");
                        } catch (Exception e) {
                            System.out.println("Errore durante la creazione del biglietto: " + e.getMessage());
                            e.printStackTrace();
                        }
                    }

                    case 2 -> {
                        System.out.println("Creazione Tessera");

                        Long utenteId = null;
                        while (utenteId == null) {
                            try {
                                System.out.print("Inserisci l'ID dell'utente a cui assegnare la tessera: ");
                                utenteId = scanner.nextLong();
                                scanner.nextLine();
                            } catch (InputMismatchException e) {
                                System.out.println("Errore: devi inserire un numero intero valido.");
                                scanner.nextLine();
                            }
                        }

                        Utente utente = utenteDao.get(utenteId);

                        if (utente == null) {
                            System.out.println("Utente non trovato.");
                            break;
                        }

                        if (utente.getTessera() != null) {
                            System.out.println("L'utente ha già una tessera.");
                            break;
                        }

                        try {
                            LocalDate dataEmissione = LocalDate.now();
                            Tessera nuovaTessera = tesseraDao.creaTessera(dataEmissione, utente);
                            tesseraDao.saveTessera(nuovaTessera);

                            utenteDao.salva(utente);

                            System.out.println("Tessera creata e assegnata all’utente " + utente.getNome() + " con successo!");
                        } catch (Exception e) {
                            System.out.println("Errore durante la creazione o salvataggio della tessera: " + e.getMessage());
                        }
                    }
                    case 3 -> {
                        try {
                            if (utenteLoggato == null) {
                                System.out.println("Errore: Nessun utente loggato.");
                                break;
                            }
                            Tessera tesseraUtenteLoggato = utenteLoggato.getTessera();
                            if (tesseraUtenteLoggato == null) {
                                System.out.println("Errore: L'utente loggato non ha una tessera.");
                                break;
                            }

                            tesseraDao.calcoloGiornoScadenzaTessera(tesseraUtenteLoggato.getId());

                        } catch (Exception e) {
                            System.out.println("Errore durante il calcolo della scadenza della tessera: " + e.getMessage());
                        }
                    }

                    case 4 -> {
                        try {

                            if (utenteLoggato == null) {
                                System.out.println("Errore: Nessun utente loggato.");
                                break;
                            }
                            Tessera tesseraUtenteLoggato = utenteLoggato.getTessera();
                            if (tesseraUtenteLoggato == null) {
                                System.out.println("Errore: L'utente loggato non ha una tessera da rinnovare.");
                                break;
                            }
                            tesseraDao.rinnovoTessera(tesseraUtenteLoggato.getId());
                            System.out.println("Tessera rinnovata con successo!");

                        } catch (Exception e) {
                            System.out.println("Errore durante il rinnovo della tessera: " + e.getMessage());
                        }
                    }

                    case 5 -> {
                        try {

                            if (utenteLoggato == null) {
                                System.out.println("Errore: Nessun utente loggato.");
                                break;
                            }

                            Tessera tesseraUtenteLoggato = utenteLoggato.getTessera();
                            if (tesseraUtenteLoggato == null) {
                                System.out.println("Errore: L'utente loggato non possiede una tessera.");
                                break;
                            }

                            TitoloDiViaggio abbonamentoUtenteLoggato = tesseraUtenteLoggato.getAbbonamento();
                            if (abbonamentoUtenteLoggato == null) {
                                System.out.println("Avviso: La tessera non ha ancora un abbonamento associato.");
                            }

                            Boolean risultato = titoloDiViaggioDao.controlloValiditaAbbonamentoTramiteIdTessera(
                                    tesseraUtenteLoggato.getId(),
                                    LocalDate.now()
                            );

                            if (risultato != null && risultato) {
                                System.out.println("Il tuo abbonamento è valido.");
                            } else {
                                System.out.println("Il tuo abbonamento non è valido o non esiste.");
                            }

                        } catch (Exception e) {
                            System.out.println("Errore durante il controllo validità dell'abbonamento: " + e.getMessage());
                        }
                    }
                    case 6 -> {
                        Validita validita = null;
                        while (validita == null) {
                            try {
                                System.out.println("Scegli la validità dell’abbonamento:");
                                System.out.println("1 -> SETTIMANALE");
                                System.out.println("2 -> MENSILE");

                                int sceltaValidita = scanner.nextInt();
                                scanner.nextLine();

                                if (sceltaValidita == 1) {
                                    validita = Validita.SETTIMANALE;
                                } else if (sceltaValidita == 2) {
                                    validita = Validita.MENSILE;
                                } else {
                                    System.out.println("Scelta non valida. Per favore inserisci 1 o 2.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Input non valido. Inserisci un numero.");
                                scanner.nextLine();
                            }
                        }
                        try {
                            TipoDistributore tipoDistributore = TipoDistributore.DISTRIBUTORE_AUTOMATICO;

                            PuntoDiEmissione punto = null; // PuntoDiEmissione ancora non disponibile, quindi null

                            if (utenteLoggato == null) {
                                System.out.println("Errore: Nessun utente loggato.");
                                break;
                            }

                            titoloDiViaggioDao.creaAbbonamentoPerUtente(utenteLoggato, validita, tipoDistributore, punto);

                            System.out.println("Abbonamento creato con successo!");

                        } catch (Exception e) {
                            System.out.println("Errore durante la creazione dell’abbonamento: " + e.getMessage());
                        }
                    }

                    case 0 -> {
                        System.out.println("Termina");
                        sceltaWhile = false;
                    }
                }
            }
        } else if (utenteLoggato != null && utenteLoggato.getRuolo().equals(Ruolo.AMMINISTRATORE)) {

            System.out.println("Bentornat* " + utenteLoggato.getNome() + " !");
            System.out.println("Premi un tasto per accedere al Menù degli Amministratori");
            scanner.next();

            boolean sceltaWhile = true;
            while (sceltaWhile) {
                System.out.println("MENU" + "\n" +
                        "1 -> Calcola il numero di biglietti in un dato periodo" + "\n" +
                        "2 -> Lista dei mezzi in manutenzione" + "\n" +
                        "3 -> Lista dei mezzi in servizio" + "\n" +
                        "4 -> Aggiorna lo stato di un mezzo" + "\n" +
                        "5 -> Lista dei punti di emissione di titoli di viaggio" + "\n" +
                        "6 -> Lista dei biglietti per punto di emissione" + "\n" +
                        "7 -> Ricerca di tutti i biglietti" + "\n" +
                        "8 -> Ricerca dei biglietti vidimati su un mezzo" + "\n" +
                        "9 -> Ricerca dei biglietti vidimati in un dato periodo" + "\n" +
                        "10 -> Ripetizione tratta tramite mezzo" + "\n" +
                        "11 -> Ricerca del tempo effettivo di una corsa tramite tratta" + "\n" +
                        "12 -> Tempo medio di percorrenza di una tratta dato un mezzo" + "\n" +
                        "13 -> Crea nuova tratta" + "\n" +
                        "14 -> Aggiungi Mezzo" + "\n" +
                        "15 -> Crea Punto di emissione" + "\n" +
                        "16 -> Crea Percorrenza"+ "\n" +
                        "0 - > Uscita"

                );
                int scelta = scanner.nextInt();
                scanner.nextLine();

                switch (scelta) {
                    case 1 -> {
                        boolean inputValido = false;
                        while (!inputValido) {
                            try {
                                System.out.print("Inserisci la data di inizio (YYYY-MM-DD): ");
                                String dataInizioStr = scanner.nextLine().trim();
                                LocalDate dataInizio = LocalDate.parse(dataInizioStr);

                                System.out.print("Inserisci la data di fine (YYYY-MM-DD): ");
                                String dataFineStr = scanner.nextLine().trim();
                                LocalDate dataFine = LocalDate.parse(dataFineStr);

                                if (dataFine.isBefore(dataInizio)) {
                                    System.out.println("La data di fine deve essere uguale o successiva alla data di inizio. Riprova.");
                                    continue;
                                }


                                System.out.println(titoloDiViaggioDao.numeroDiBigliettiInUnDatoPeriodo(dataInizio, dataFine));

                                inputValido = true;

                            } catch (DateTimeParseException e) {
                                System.out.println("Formato data non valido. Usa YYYY-MM-DD, es: 2025-05-30");
                            } catch (Exception e) {
                                System.out.println("Errore: " + e.getMessage());
                            }
                        }
                    }

                    case 2 -> {
                        try {
                            List<Mezzo> mezziInManutenzione = mezzoDao.listaMezziManutenzione();
                            if (mezziInManutenzione.isEmpty()) {
                                System.out.println("Nessun mezzo in manutenzione al momento.");
                            } else {
                                System.out.println(mezziInManutenzione);
                            }
                        } catch (Exception e) {
                            System.out.println("Errore nel recuperare i mezzi in manutenzione: " + e.getMessage());
                        }
                    }

                    case 3 -> {
                        try {
                            List<Mezzo> mezziInServizio = mezzoDao.listaMezziInServizio();
                            if (mezziInServizio.isEmpty()) {
                                System.out.println("Nessun mezzo attualmente in servizio.");
                            } else {
                                System.out.println(mezziInServizio);
                            }
                        } catch (Exception e) {
                            System.out.println("Errore nel recuperare i mezzi in servizio: " + e.getMessage());
                        }
                    }

                    case 4 -> {
                        List<Mezzo> mezzi = em.createQuery("SELECT m FROM Mezzo m", Mezzo.class).getResultList();

                        if (mezzi.isEmpty()) {
                            System.out.println("Al momento nessun mezzo è stato aggiunto al DB");
                        } else {
                            System.out.println("Scegli tra i seguenti il mezzo di cui vuoi aggiornare lo stato:");

                            for (int i = 0; i < mezzi.size(); i++) {
                                Mezzo mezzo = mezzi.get(i);
                                System.out.print(i + " -> " + mezzo + "\n");
                            }

                            System.out.println("Digita il numero corrispondente al mezzo che vuoi aggiornare:");
                            int sceltaUpdateMezzo = scanner.nextInt();
                            scanner.nextLine(); // Consuma il newline

                            if (sceltaUpdateMezzo < 0 || sceltaUpdateMezzo >= mezzi.size()) {
                                System.out.println("Scelta non valida.");
                                break;
                            }

                            Mezzo mezzoScelto = mezzi.get(sceltaUpdateMezzo);

                            servizioManutenzioneDao.aggiornaServizioManutenzione(mezzoScelto, em);

                        }
                    }
                    case 5 -> {
                        List<PuntoDiEmissione> puntiConTitoli = puntoDiEmissioneDao.listaPuntiDiEmissioneConTitoli();

                        if (puntiConTitoli.isEmpty()) {
                            System.out.println("Nessun punto di emissione ha ancora emesso titoli di viaggio.");
                        } else {
                            System.out.println("Punti di emissione che hanno emesso almeno un titolo di viaggio:");
                            for (PuntoDiEmissione punto : puntiConTitoli) {
                                System.out.println("- ID: " + punto.getId() + ", Nome: " + punto.getNome() +
                                        ", Numero titoli emessi: " + punto.getTitoloDiViaggioList().size());
                            }
                        }
                    }


                    case 6 -> {
                        // Recupera i punti di emissione
                        List<PuntoDiEmissione> punti = em.createQuery("SELECT p FROM PuntoDiEmissione p", PuntoDiEmissione.class).getResultList();

                        if (punti.isEmpty()) {
                            System.out.println("Non ci sono punti di emissione registrati nel database.");
                            break;
                        }

                        System.out.println("Scegli un punto di emissione tra i seguenti:");
                        for (int i = 0; i < punti.size(); i++) {
                            PuntoDiEmissione p = punti.get(i);
                            System.out.println(i + " -> Punto ID: " + p.getId() + " - Nome: " + p.getNome());
                        }

                        System.out.println("Inserisci il numero corrispondente al punto di emissione:");
                        int sceltaPunto = scanner.nextInt();
                        scanner.nextLine(); // consuma newline

                        if (sceltaPunto < 0 || sceltaPunto >= punti.size()) {
                            System.out.println("Scelta non valida.");

                        }

                        PuntoDiEmissione puntoScelto = punti.get(sceltaPunto);

                        // Recupera i biglietti associati a quel punto
                        List<Biglietto> biglietti = em.createQuery("SELECT b FROM Biglietto b WHERE b.puntoDiEmissione = :punto", Biglietto.class)
                                .setParameter("punto", puntoScelto)
                                .getResultList();

                        if (biglietti.isEmpty()) {
                            System.out.println("Nessun biglietto emesso da questo punto.");
                        } else {
                            System.out.println("Biglietti emessi dal punto: " + puntoScelto.getNome());
                            for (Biglietto b : biglietti) {
                                System.out.println("ID: " + b.getId() + ", Data Emissione: " + b.getDataEmissione() +
                                        ", Vidimato: " + (b.getVidimazione() == Vidimazione.VIDIMATO) +
                                        ", Mezzo: " + (b.getMezzo() != null ? b.getMezzo().getId() : "N/A"));
                            }
                        }
                    }
                    case 7 -> {
                        System.out.println(titoloDiViaggioDao.ricercaBiglietti());
                    }

                    case 8 -> {
                        boolean success = false;
                        while (!success) {
                            try {
                                System.out.println("Inserisci l'ID del mezzo:");
                                Long idMezzo = scanner.nextLong();
                                scanner.nextLine();

                                List<Biglietto> biglietti = titoloDiViaggioDao.ricercaBigliettiVidimatiTramiteMezzo(idMezzo);

                                if (biglietti.isEmpty()) {
                                    System.out.println("Nessun biglietto vidimato trovato per il mezzo con ID " + idMezzo);
                                } else {
                                    System.out.println("Biglietti vidimati sul mezzo con ID " + idMezzo + ":");
                                    biglietti.forEach(System.out::println);
                                }
                                success = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Errore: devi inserire un numero valido per l'ID.");
                                scanner.nextLine();
                            } catch (Exception e) {
                                System.out.println("Errore imprevisto: " + e.getMessage());
                                break;
                            }
                        }
                    }

                    case 9 -> {
                        boolean success = false;
                        while (!success) {
                            try {
                                System.out.println("Ora ti chiederò di digitare anno, mese e giorno delle 2 date che segnano il periodo scelto");

                                System.out.print("Digita l'anno della data di inizio (es. 2023): ");
                                int annoDataInizio = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Digita il mese della data di inizio (1-12): ");
                                int meseDataInizio = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Digita il giorno della data di inizio (1-31): ");
                                int giornoDataInizio = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Digita l'anno della data di fine (es. 2023): ");
                                int annoDataFine = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Digita il mese della data di fine (1-12): ");
                                int meseDataFine = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Digita il giorno della data di fine (1-31): ");
                                int giornoDataFine = scanner.nextInt();
                                scanner.nextLine();

                                LocalDate dataInizio = LocalDate.of(annoDataInizio, meseDataInizio, giornoDataInizio);
                                LocalDate dataFine = LocalDate.of(annoDataFine, meseDataFine, giornoDataFine);

                                if (dataFine.isBefore(dataInizio)) {
                                    System.out.println("La data di fine non può essere precedente alla data di inizio. Riprova.");
                                    continue;
                                }

                                System.out.println(titoloDiViaggioDao.ricercaBigliettiVidimatiPerPeriodo(dataInizio, dataFine));
                                success = true;

                            } catch (DateTimeException e) {
                                System.out.println("Una o più date inserite non sono valide. Riprova con valori corretti.");
                            } catch (InputMismatchException e) {
                                System.out.println("Errore di input: inserisci numeri validi.");
                                scanner.nextLine(); // pulisce il buffer
                            } catch (Exception e) {
                                System.out.println("Errore imprevisto: " + e.getMessage());
                                break;
                            }
                        }
                    }

                    case 10 -> {
                        System.out.println("Ripetizione di una tratta tramite un mezzo");
                        System.out.print("Inserisci l'ID del mezzo: ");
                        Long idMezzo = scanner.nextLong();
                        scanner.nextLine();

                        System.out.print("Inserisci l'ID della tratta: ");
                        Long idTratta = scanner.nextLong();
                        scanner.nextLine();

                        try {
                            long conteggio = mezzoDao.ripetizioneTrattaTramiteMezzo(idMezzo, idTratta);
                            System.out.println("La tratta con ID " + idTratta + " è stata percorsa " + conteggio + " volte dal mezzo con ID " + idMezzo);
                        } catch (Exception e) {
                            System.out.println("Errore durante la ricerca. Controlla che gli ID inseriti siano corretti.");
                        }
                    }

                    case 11 -> {
                        boolean success = false;
                        while (!success) {
                            try {
                                System.out.print("Inserisci l'ID della tratta: ");
                                Long idTratta = scanner.nextLong();
                                scanner.nextLine();

                                if (idTratta <= 0) {
                                    System.out.println("L'ID deve essere un numero positivo. Riprova.");
                                    continue;
                                }

                                Tratta tratta = trattaDao.getById(idTratta);

                                if (tratta != null) {
                                    System.out.println("Tratta trovata:");
                                    System.out.println("Zona di partenza: " + tratta.getZonaDiPartenza());
                                    System.out.println("Capolinea: " + tratta.getCapolinea());
                                    System.out.println("Tempo effettivo della corsa: " + tratta.getTempoPercorrenzaEffettivo());
                                    success = true;
                                } else {
                                    System.out.println("Tratta non trovata con ID: " + idTratta + ". Riprova.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Input non valido. Inserisci solo numeri.");
                                scanner.nextLine();
                            } catch (Exception e) {
                                System.out.println("Si è verificato un errore: " + e.getMessage());
                                break;
                            }
                        }
                    }


                    case 12 -> {
                        System.out.print("Inserisci l'ID della tratta: ");
                        Long trattaId = scanner.nextLong();
                        System.out.print("Inserisci l'ID del mezzo: ");
                        Long mezzoId = scanner.nextLong();

                        Double tempoMedio = percorrenzaDao.tempoMedioPercorrenzaPerTrattaEMezzo(trattaId, mezzoId);

                        if (tempoMedio != null) {
                            System.out.println("Tempo medio di percorrenza per la tratta " + trattaId +
                                    " con il mezzo " + mezzoId + ": " + tempoMedio + " minuti.");
                        } else {
                            System.out.println("Nessuna percorrenza trovata per la tratta " + trattaId +
                                    " con il mezzo " + mezzoId + ".");
                        }
                    }
                    
                    // Metodo Tratta
                    case 13 -> {
                        System.out.println("=== Creazione Nuova Tratta ===");

                        System.out.print("Inserisci il luogo di partenza: ");
                        String partenza = scanner.nextLine();

                        System.out.print("Inserisci il luogo di arrivo: ");
                        String arrivo = scanner.nextLine();

                        int oreDurata = 0;
                        int minutiDurata = 0;
                        int oreEffettiva = 0;
                        int minutiEffettiva = 0;

                        try {
                            System.out.print("Durata prevista - Ore: ");
                            oreDurata = Integer.parseInt(scanner.nextLine());

                            System.out.print("Durata prevista - Minuti: ");
                            minutiDurata = Integer.parseInt(scanner.nextLine());

                            System.out.print("Durata effettiva - Ore: ");
                            oreEffettiva = Integer.parseInt(scanner.nextLine());

                            System.out.print("Durata effettiva - Minuti: ");
                            minutiEffettiva = Integer.parseInt(scanner.nextLine());

                            LocalTime durataPrevista = LocalTime.of(oreDurata, minutiDurata);
                            LocalTime durataEffettiva = LocalTime.of(oreEffettiva, minutiEffettiva);

                            Tratta nuovaTratta = new Tratta(partenza, arrivo, durataPrevista, durataEffettiva);
                            trattaDao.save(nuovaTratta);

                            System.out.println("Nuova tratta creata con successo!");
                        } catch (NumberFormatException e) {
                            System.out.println(" Inserisci solo numeri validi per ore e minuti.");
                        } catch (DateTimeException e) {
                            System.out.println(" Inseriti valori fuori intervallo (ore 0–23, minuti 0–59).");
                        } catch (Exception e) {
                            System.out.println(" Errore inatteso durante la creazione della tratta: " + e.getMessage());
                        }
                    }

                    case 14 -> {
                        System.out.println("Aggiungi un mezzo");

                        int capacita;
                        try {
                            System.out.print("Inserisci la capacità del mezzo: ");
                            capacita = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println(" Capacità non valida. Inserisci un numero intero.");
                            break;
                        }

                        System.out.println("Scegli il tipo di mezzo");
                        System.out.println("1 -> AUTOBUS");
                        System.out.println("2 -> TRAM");

                        int sceltaMezzo;
                        try {
                            sceltaMezzo = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println(" Scelta non valida. Inserisci 1 o 2.");
                            break;
                        }

                        TipoMezzo tipoMezzo;

                        if (sceltaMezzo == 1) {
                            tipoMezzo = TipoMezzo.AUTOBUS;
                        } else if (sceltaMezzo == 2) {
                            tipoMezzo = TipoMezzo.TRAM;
                        } else {
                            System.out.println(" Tipo di mezzo non valido");
                            break;
                        }

                        Mezzo nuovoMezzo = new Mezzo(capacita, tipoMezzo);
                        mezzoDao.save(nuovoMezzo);
                        System.out.println(" Mezzo aggiunto con successo: " + nuovoMezzo);
                    }

                    case 15 -> {
                        System.out.println("Inserisci il nome del punto di emissione:");
                        String nome = scanner.nextLine().trim();

                        System.out.println("Inserisci il tipo di punto di emissione (DISTRIBUTORE o RIVENDITORE):");
                        String tipoInput = scanner.nextLine().trim().toUpperCase();

                        switch (tipoInput) {
                            case "DISTRIBUTORE" -> {
                                PuntoDiEmissione nuovoPunto = puntoDiEmissioneDao.creazionePuntoDiEmissione(nome);
                                System.out.println(" Distributore automatico creato con successo!");
                                System.out.println(nuovoPunto);
                            }
                            case "RIVENDITORE" -> {
                                System.out.println("Inserisci l'indirizzo del rivenditore autorizzato:");
                                String indirizzo = scanner.nextLine().trim();
                                PuntoDiEmissione nuovoPunto = puntoDiEmissioneDao.creazioneRivenditoreAutorizzato(nome, indirizzo);
                                System.out.println(" Rivenditore autorizzato creato con successo!");
                                System.out.println(nuovoPunto);
                            }
                            default -> {
                                System.out.println(" Tipo non valido. Inserire solo 'DISTRIBUTORE' o 'RIVENDITORE'.");
                            }
                        }
                    }

                    case 16 -> {
                        System.out.println("Creazione Nuova Percorrenza");

                        try {
                            System.out.print("Inserisci ora di inizio (HH:mm): ");
                            String inputInizio = scanner.nextLine();
                            LocalTime oraInizio = LocalTime.parse(inputInizio);

                            System.out.print("Inserisci ora di fine (HH:mm): ");
                            String inputFine = scanner.nextLine();
                            LocalTime oraFine = LocalTime.parse(inputFine);

                            Percorrenza nuovaPercorrenza = percorrenzaDao.creazionePercorrenza(oraInizio, oraFine);
                            percorrenzaDao.salva(nuovaPercorrenza);

                            System.out.println(" Nuova percorrenza creata con successo.");
                        } catch (DateTimeParseException e) {
                            System.out.println(" Formato orario non valido. Usa il formato corretto: HH:mm (es. 14:30).");
                        }
                    }

                    case 0 -> {
                        System.out.println("Termina");
                        sceltaWhile = false;
                    }
                }
            }
        }
    }

}




