import dao.*;
import entites.*;
import enumeration.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
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


        Utente u1 = new Utente("Chiara", "Sanasi", "chiarasan", "12345678", Ruolo.UTENTE_NORMALE);
        Utente u2 = new Utente("Salvatore", "Gianquinto", "salvatore", "a2345678", Ruolo.UTENTE_NORMALE);
        Utente u3 = new Utente("Leonard", "Dautaru", "leo", "b2345678", Ruolo.UTENTE_NORMALE);
        Utente u4 = new Utente("Silvia", "Gasparini", "silvia", "c2345678", Ruolo.UTENTE_NORMALE);
        Utente u5 = new Utente("Roberto", "Albergo", "rob", "d2345678", Ruolo.UTENTE_NORMALE);
        Utente u6 = new Utente("Roberto", "Ciancio", "ciancio", "e2345678", Ruolo.UTENTE_NORMALE);
        Utente u7 = new Utente("Pietro", "Sorbo", "pietro", "f2345678", Ruolo.UTENTE_NORMALE);

        Utente u8 = new Utente("Vincenzo", "Napoli", "vinz", "g2345678", Ruolo.AMMINISTRATORE);

        utenteDao.salva(u1);
        utenteDao.salva(u2);
        utenteDao.salva(u3);
        utenteDao.salva(u4);
        utenteDao.salva(u5);
        utenteDao.salva(u6);
        utenteDao.salva(u7);
        utenteDao.salva(u8);

        Tessera ts1 = new Tessera(LocalDate.of(2020, 1, 1));
        Tessera ts2 = new Tessera(LocalDate.of(2020, 1, 1));
        Tessera ts3 = new Tessera(LocalDate.of(2020, 1, 1));
        Tessera ts4 = new Tessera(LocalDate.of(2020, 1, 1));

        tesseraDao.saveTessera(ts1);
        tesseraDao.saveTessera(ts2);
        tesseraDao.saveTessera(ts3);
        tesseraDao.saveTessera(ts4);


        u1.setTessera(ts1);
        u2.setTessera(ts2);
        u3.setTessera(ts3);
        u4.setTessera(ts4);

        utenteDao.salva(u1);
        utenteDao.salva(u2);
        utenteDao.salva(u3);
        utenteDao.salva(u4);

        Mezzo m1 = new Mezzo(150, TipoMezzo.AUTOBUS);
        Mezzo m2 = new Mezzo(250, TipoMezzo.AUTOBUS);
        Mezzo m3 = new Mezzo(300, TipoMezzo.TRAM);
        Mezzo m4 = new Mezzo(350, TipoMezzo.TRAM);

        mezzoDao.save(m1);
        mezzoDao.save(m2);
        mezzoDao.save(m3);
        mezzoDao.save(m4);

        ServizioManutenzione s1 = new ServizioManutenzione(StatoServizio.IN_SERVIZIO, LocalDate.of(2000, 1, 1), LocalDate.of(2000, 3, 1), LocalDate.of(2000, 3, 2), LocalDate.now());
        ServizioManutenzione s2 = new ServizioManutenzione(StatoServizio.IN_SERVIZIO, LocalDate.of(2022, 3, 12), LocalDate.of(2022, 6, 1), LocalDate.of(2022, 6, 3), LocalDate.now());
        ServizioManutenzione s3 = new ServizioManutenzione(StatoServizio.IN_MANUTENZIONE, LocalDate.of(2025, 5, 1), LocalDate.now(), LocalDate.of(2023, 1, 1), LocalDate.of(2025, 4, 30));
        ServizioManutenzione s4 = new ServizioManutenzione(StatoServizio.IN_MANUTENZIONE, LocalDate.of(2020, 1, 1), LocalDate.now(), LocalDate.of(2019, 3, 2), LocalDate.of(2019, 12, 31));

        servizioManutenzioneDao.salva(s1);
        servizioManutenzioneDao.salva(s2);
        servizioManutenzioneDao.salva(s3);
        servizioManutenzioneDao.salva(s4);

        Percorrenza p1 = new Percorrenza(LocalTime.of(5, 0), LocalTime.of(23, 59));
        Percorrenza p2 = new Percorrenza(LocalTime.of(6, 0), LocalTime.of(1, 0));
        Percorrenza p3 = new Percorrenza(LocalTime.of(12, 0), LocalTime.of(3, 0));
        Percorrenza p4 = new Percorrenza(LocalTime.of(15, 0), LocalTime.of(22, 59));

        percorrenzaDao.salva(p1);
        percorrenzaDao.salva(p2);
        percorrenzaDao.salva(p3);
        percorrenzaDao.salva(p4);

        m1.setMezzoPercorrenze(List.of(p1, p2));
        m2.setMezzoPercorrenze(List.of(p2, p3));
        m3.setMezzoPercorrenze(List.of(p1, p4));
        m4.setMezzoPercorrenze(List.of(p3, p4));

        mezzoDao.save(m1);
        mezzoDao.save(m2);
        mezzoDao.save(m3);
        mezzoDao.save(m4);

        Tratta t1 = new Tratta("Roma", "Milano", LocalTime.of(2, 30), LocalTime.of(2, 45));
        Tratta t2 = new Tratta("Napoli", "Bari", LocalTime.of(1, 15), LocalTime.of(1, 20));
        Tratta t3 = new Tratta("Torino", "Venezia", LocalTime.of(2, 0), LocalTime.of(2, 5));

        Tratta t4 = new Tratta("Firenze", "Pisa", LocalTime.of(0, 45), LocalTime.of(0, 50));

        trattaDao.save(t1);
        trattaDao.save(t2);
        trattaDao.save(t3);
        trattaDao.save(t4);


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

                            System.out.print("Inserisci ID Utente: ");
                            Long idUtente = scanner.nextLong();
                            Utente utente = em.find(Utente.class, idUtente);
                            if (utente == null) {
                                System.out.println("Utente non trovato!");


                            }

                            System.out.print("Inserisci ID Mezzo: ");
                            Long idMezzo = scanner.nextLong();
                            Mezzo mezzo = em.find(Mezzo.class, idMezzo);
                            if (mezzo == null) {
                                System.out.println("Mezzo non trovato!");

                            }

                            System.out.print("Inserisci ID Punto di Emissione: ");
                            Long idPunto = scanner.nextLong();
                            PuntoDiEmissione punto = em.find(PuntoDiEmissione.class, idPunto);
                            if (punto == null) {
                                System.out.println("Punto di emissione non trovato!");

                            }

                            scanner.nextLine(); // consuma il newline
                            System.out.print("Inserisci tipo distributore (AUTOMATICO, RIVENDITORE_AUTORIZZATO): ");
                            String tipoStr = scanner.nextLine().toUpperCase();
                            TipoDistributore tipo = TipoDistributore.valueOf(tipoStr);

                            LocalDate dataEmissione = LocalDate.now();

                            Biglietto nuovoBiglietto = titoloDiViaggioDao.creaBiglietto(dataEmissione, tipo, punto, mezzo);
                            nuovoBiglietto.setUtente(utente);

                            em.getTransaction().begin();
                            em.persist(nuovoBiglietto);
                            em.getTransaction().commit();

                            System.out.println("Biglietto creato con successo!");


                        }


                        case 2 -> {
                            System.out.println("Creazione Tessera");

                            System.out.print("Inserisci l'ID dell'utente a cui assegnare la tessera: ");

                            Long utenteId = scanner.nextLong();
                            scanner.nextLine();

                            Utente utente = utenteDao.get(utenteId);

                            if (utente == null) {
                                System.out.println("Utente non trovato.");
                                break;
                            }

                            if (utente.getTessera() != null) {
                                System.out.println("L'utente ha già una tessera.");
                                break;
                            }

                            LocalDate dataEmissione = LocalDate.now();
                            Tessera nuovaTessera = tesseraDao.creaTessera(dataEmissione, utente);
                            tesseraDao.saveTessera(nuovaTessera);

                            utenteDao.salva(utente); // aggiorna legame utente-tessera

                            System.out.println("Tessera creata e assegnata all’utente " + utente.getNome() + " con successo!");
                        }
                        case 3 -> {
                            Tessera tesseraUtenteLoggato = utenteLoggato.getTessera();
                            tesseraDao.calcoloGiornoScadenzaTessera(tesseraUtenteLoggato.getId());
                        }
                        case 4 -> {
                            Tessera tesseraUtenteLoggato = utenteLoggato.getTessera();
                            tesseraDao.rinnovoTessera(tesseraUtenteLoggato.getId());
                        }
                        case 5 -> {
                            Tessera tesseraUtenteLoggato = utenteLoggato.getTessera();
                            TitoloDiViaggio abbonamentoUtenteLoggato = tesseraUtenteLoggato.getAbbonamento();
                            Boolean risultato = titoloDiViaggioDao.controlloValiditaAbbonamentoTramiteIdTessera(tesseraUtenteLoggato.getId(), LocalDate.now());
                            if (risultato) {
                                System.out.println("Il tuo abbonamento è valido");
                            } else {
                                System.out.println("Il tuo abbonamento non è valido");
                            }
                        }
                        case 6 -> {
                            System.out.println("Scegli la validità dell’abbonamento:");
                            System.out.println("1 -> SETTIMANALE");
                            System.out.println("2 -> MENSILE");
                            int sceltaValidita = scanner.nextInt();
                            scanner.nextLine();

                            Validita validita = (sceltaValidita == 1) ? Validita.SETTIMANALE : Validita.MENSILE;

                            TipoDistributore tipoDistributore = TipoDistributore.DISTRIBUTORE_AUTOMATICO;

                            PuntoDiEmissione punto = null; // PuntoDiEmissione ancora non disponibile, quindi null

                            titoloDiViaggioDao.creaAbbonamentoPerUtente(utenteLoggato, validita, tipoDistributore, punto);
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


                while (true) {
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
                            "16 -> Crea Percorrenza"

                    );
                    int scelta = scanner.nextInt();
                    scanner.nextLine();

                    switch (scelta) {
                        case 1 -> {
                            System.out.println("Ora ti chiederò di digitare anno, mese e giorno delle 2 date che segnano il periodo scelto");

                            System.out.println("Digita l'anno della data di inizio in numeri");
                            int annoDataInizio = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Digita il mese della data di inizio in numeri. Esempio --> Aprile = 4, Dicembre = 12");
                            int meseDataInizio = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Digita il giorno della data di inizio in numeri");
                            int giornoDataInizio = scanner.nextInt();
                            scanner.nextLine();


                            System.out.println("Digita l'anno della data di fine in numeri");
                            int annoDataFine = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Digita il mese della data di fine in numeri. Esempio --> Aprile = 4, Dicembre = 12");
                            int meseDataFine = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Digita il giorno della data di fine in numeri");
                            int giornoDataFine = scanner.nextInt();
                            scanner.nextLine();


                            titoloDiViaggioDao.numeroDiBigliettiInUnDatoPeriodo(LocalDate.of(annoDataInizio, meseDataInizio, giornoDataInizio), LocalDate.of(annoDataFine, meseDataFine, giornoDataFine));
                        }

                        case 2 -> {
                            System.out.println(mezzoDao.listaMezziManutenzione());

                        }
                        case 3 -> {
                            System.out.println(mezzoDao.listaMezziInServizio());
                        }
                        case 4 -> {
//mettere questo
                            List<Mezzo> mezzi = em.createQuery("SELECT m FROM Mezzo m", Mezzo.class).getResultList();

                            if (mezzi.isEmpty()) {
                                System.out.println("Al momento nessun mezzo è stato aggiunto al DB");
                            } else {
                                System.out.println("Scegli tra i seguenti il mezzo di cui vuoi aggiornare lo stato:");

                                for (int i = 0; i < mezzi.size(); i++) {
                                    Mezzo mezzo = mezzi.get(i);
                                    System.out.print(i + " -> Mezzo ID: " + mezzo.getId());

                                    List<Percorrenza> percorrenze = mezzo.getMezzoPercorrenze();
                                    if (percorrenze == null || percorrenze.isEmpty()) {
                                        System.out.println(" (nessuna percorrenza assegnata)");
                                    } else {
                                        System.out.println(" (con le seguenti percorrenze):");
                                        for (Percorrenza p : percorrenze) {
                                            Tratta t = p.getTratta();
                                            if (t != null) {
                                                System.out.println("- " + t.getZonaDiPartenza() + " da " + t.getCapolinea() +
                                                        " (tempo previsto: " + t.getTempoPercorrenzaPrevisto() + ")");
                                            } else {
                                                System.out.println("- Percorrenza senza tratta associata.");
                                            }
                                        }
                                    }
                                }

                                System.out.println("Digita il numero del mezzo che vuoi aggiornare:");
                                int sceltaUpdateMezzo = scanner.nextInt();
                                scanner.nextLine(); // Consuma il newline

                                if (sceltaUpdateMezzo < 0 || sceltaUpdateMezzo >= mezzi.size()) {
                                    System.out.println("Scelta non valida.");
                                    break;
                                }

                                Mezzo mezzoScelto = mezzi.get(sceltaUpdateMezzo);
                                ServizioManutenzione servizio = mezzoScelto.getServizioManutenzione();


                                if (servizio == null) {
                                    System.out.println("Il mezzo selezionato non ha un ServizioManutenzione associato. Ne verrà creato uno nuovo.");

                                    //  stato servizio
                                    System.out.println("Inserisci lo stato del servizio (IN_SERVIZIO / IN_MANUTENZIONE):");
                                    String statoInput = scanner.nextLine().toUpperCase();
                                    StatoServizio statoServizio;
                                    try {
                                        statoServizio = StatoServizio.valueOf(statoInput);
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("Valore non valido. Stato impostato a IN_SERVIZIO di default.");
                                        statoServizio = StatoServizio.IN_SERVIZIO;
                                    }

                                    if (statoServizio.equals(StatoServizio.IN_SERVIZIO)) {
                                        // Richiesta date
                                        System.out.println("Ora dovrai inserire le date di inizio servizio. TUTTE con il seguente formato --> yyyy-mm-dd");

                                        try {
                                            System.out.println("Inserisci la data di inizio servizio :");
                                            LocalDate inizioServizio = LocalDate.parse(scanner.nextLine());

                                            System.out.println("Inserisci la data di fine prevista :");
                                            LocalDate fineServizioPrevista = LocalDate.parse(scanner.nextLine());


                                            servizio = new ServizioManutenzione(statoServizio, inizioServizio, fineServizioPrevista, true);


                                            mezzoScelto.setServizioManutenzione(servizio); // --> lato proprietario
                                            mezzoDao.save(mezzoScelto);

                                            System.out.println("Creato nuovo ServizioManutenzione con stato " + statoServizio);
                                        } catch (IllegalArgumentException e) {
                                            System.out.println("Stato del servizio non valido. Operazione annullata.");
                                            em.getTransaction().rollback();
                                            break;

                                        } catch (DateTimeParseException e) {
                                            System.out.println("Una delle date inserite non è nel formato corretto (yyyy-mm-dd). Operazione annullata.");
                                            em.getTransaction().rollback();
                                            break;
                                        }
                                    } else if (statoServizio.equals(StatoServizio.IN_MANUTENZIONE)) {
                                        // Richiesta date
                                        System.out.println("Ora dovrai inserire le date di inizio manutenzione. TUTTE con il seguente formato --> yyyy-mm-dd");

                                        try {
                                            System.out.println("Inserisci la data di inizio manutenzione :");
                                            LocalDate inizioManutenzione = LocalDate.parse(scanner.nextLine());

                                            System.out.println("Inserisci la data di fine prevista :");
                                            LocalDate fineManutenzionePrevista = LocalDate.parse(scanner.nextLine());


                                            servizio = new ServizioManutenzione(statoServizio, inizioManutenzione, fineManutenzionePrevista);

                                            mezzoScelto.setServizioManutenzione(servizio); // --> lato proprietario
                                            mezzoDao.save(mezzoScelto);

                                            System.out.println("Creato nuovo ServizioManutenzione con stato " + statoServizio);
                                        } catch (IllegalArgumentException e) {
                                            System.out.println("Stato del servizio non valido. Operazione annullata.");
                                            em.getTransaction().rollback();
                                            break;

                                        } catch (DateTimeParseException e) {
                                            System.out.println("Una delle date inserite non è nel formato corretto (yyyy-mm-dd). Operazione annullata.");
                                            em.getTransaction().rollback();
                                            break;
                                        }
                                    }
                                } else {
                                    StatoServizio stato = servizio.getStatoServizio();
                                    if (stato == StatoServizio.IN_SERVIZIO) {
                                        servizio.setStatoServizio(StatoServizio.IN_MANUTENZIONE);
                                        System.out.println("Lo stato di servizio del mezzo ora è IN_MANUTENZIONE.");
                                    } else if (stato == StatoServizio.IN_MANUTENZIONE) {
                                        servizio.setStatoServizio(StatoServizio.IN_SERVIZIO);
                                        System.out.println("Lo stato di servizio del mezzo ora è IN_SERVIZIO.");
                                    } else {
                                        servizio.setStatoServizio(StatoServizio.IN_SERVIZIO);
                                        System.out.println("Lo stato era nullo. Settato di default a IN_SERVIZIO.");
                                    }
                                }
                            }
                        }
                        case 5 -> {
                            System.out.println("pippa");
                        }
                        case 6 -> {
                            System.out.println("uguale a 5");
                        }
                        case 7 -> {
                            System.out.println(titoloDiViaggioDao.ricercaBiglietti());
                        }
                        case 8 -> {
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
                        }
                        case 9 -> {
                            System.out.println("Ora ti chiederò di digitare anno, mese e giorno delle 2 date che segnano il periodo scelto");

                            System.out.println("Digita l'anno della data di inizio in numeri");
                            int annoDataInizio = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Digita il mese della data di inizio in numeri. Esempio --> Aprile = 4, Dicembre = 12");
                            int meseDataInizio = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Digita il giorno della data di inizio in numeri");
                            int giornoDataInizio = scanner.nextInt();
                            scanner.nextLine();


                            System.out.println("Digita l'anno della data di fine in numeri");
                            int annoDataFine = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Digita il mese della data di fine in numeri. Esempio --> Aprile = 4, Dicembre = 12");
                            int meseDataFine = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Digita il giorno della data di fine in numeri");
                            int giornoDataFine = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println(titoloDiViaggioDao.ricercaBigliettiVidimatiPerPeriodo(LocalDate.of(annoDataInizio, meseDataInizio, giornoDataInizio), LocalDate.of(annoDataFine, meseDataFine, giornoDataFine)));
                        }
                        case 10 -> {
                            System.out.println("pippaaaa");


                        }
                        case 11 -> {
                            System.out.println("Inserisci l'ID della tratta:");

                            Long idTratta = scanner.nextLong();
                            scanner.nextLine();

                            Tratta tratta = trattaDao.getById(idTratta);

                            if (tratta != null) {
                                System.out.println("Tratta: " + tratta.getZonaDiPartenza() + " → " + tratta.getCapolinea());
                                System.out.println("Tempo effettivo della corsa: " + tratta.getTempoPercorrenzaEffettivo());
                            } else {
                                System.out.println("Tratta non trovata.");
                            }
                        }


                        case 12 -> {
                            System.out.print("Inserisci l'ID della tratta: ");

                            Long trattaId12 = scanner.nextLong();
                            Double tempoMedioMinuti = percorrenzaDao.tempoMedioPercorrenza(trattaId12);

                            if (tempoMedioMinuti != null) {
                                System.out.println("Tempo medio di percorrenza: " + tempoMedioMinuti + " minuti.");
                            } else {
                                System.out.println("Nessuna percorrenza trovata per la tratta con ID " + trattaId12);
                            }
                        }


                        // Metodo Tratta
                        case 13 -> {
                            System.out.println("=== Creazione Nuova Tratta ===");

                            System.out.print("Inserisci il luogo di partenza: ");
                            String partenza = scanner.nextLine();

                            System.out.print("Inserisci il luogo di arrivo: ");
                            String arrivo = scanner.nextLine();

                            System.out.print("Durata prevista - Ore: ");
                            int oreDurata = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Durata prevista - Minuti: ");
                            int minutiDurata = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Durata effettiva - Ore: ");
                            int oreEffettiva = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Durata effettiva - Minuti: ");
                            int minutiEffettiva = scanner.nextInt();
                            scanner.nextLine();

                            LocalTime durataPrevista = LocalTime.of(oreDurata, minutiDurata);
                            LocalTime durataEffettiva = LocalTime.of(oreEffettiva, minutiEffettiva);

                            Tratta nuovaTratta = new Tratta(partenza, arrivo, durataPrevista, durataEffettiva);
                            trattaDao.save(nuovaTratta);

                            System.out.println("Nuova tratta creata con successo!");

                        }


                        case 14 -> {
                            System.out.println("Aggiungi un mezzo");

                            System.out.print("Inserisci la capacità del mezzo: ");
                            int capacita = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Scegli il tipo di mezzo");
                            System.out.println("1 -> AUTOBUS");
                            System.out.println("2 -> TRAM");

                            int sceltaMezzo = scanner.nextInt();
                            scanner.nextLine();

                            TipoMezzo tipoMezzo;

                            if (sceltaMezzo == 1) {
                                tipoMezzo = TipoMezzo.AUTOBUS;
                            } else if (sceltaMezzo == 2) {
                                tipoMezzo = TipoMezzo.TRAM;
                            } else {
                                System.out.println("Tipo di mezzo non valido");
                                break;
                            }
                            Mezzo nuovoMezzo = new Mezzo(capacita, tipoMezzo);
                            mezzoDao.save(nuovoMezzo);
                            System.out.println("Mezzo aggiunto con successo: " + nuovoMezzo);
                        }
                        case 15 -> {
                            System.out.println("Inserisci il nome del punto di emissione:");
                            String nome = scanner.nextLine();

                            System.out.println("Inserisci il tipo di punto di emissione (DISTRIBUTORE o RIVENDITORE):");
                            String tipoInput = scanner.nextLine().toUpperCase();

                            switch (tipoInput) {
                                case "DISTRIBUTORE" -> {
                                    PuntoDiEmissione nuovoPunto = puntoDiEmissioneDao.creazionePuntoDiEmissione(nome);
                                    System.out.println("Distributore automatico creato con successo!");
                                    System.out.println(nuovoPunto);
                                }
                                case "RIVENDITORE" -> {
                                    System.out.println("Inserisci l'indirizzo del rivenditore autorizzato:");
                                    String indirizzo = scanner.nextLine();
                                    PuntoDiEmissione nuovoPunto = puntoDiEmissioneDao.creazioneRivenditoreAutorizzato(nome, indirizzo);
                                    System.out.println("Rivenditore autorizzato creato con successo!");
                                    System.out.println(nuovoPunto);
                                }
                                default -> {
                                    System.out.println("Tipo non valido. Inserire solo 'DISTRIBUTORE' o 'RIVENDITORE'.");
                                }
                            }
                        }
                        case 16 -> {
                            System.out.println("Creazione Nuova Percorrenza");

                            System.out.print("Inserisci ora di inizio (HH:mm): ");
                            String inputInizio = scanner.nextLine();
                            LocalTime oraInizio = LocalTime.parse(inputInizio);

                            System.out.print("Inserisci ora di fine (HH:mm): ");
                            String inputFine = scanner.nextLine();
                            LocalTime oraFine = LocalTime.parse(inputFine);

                            Percorrenza nuovaPercorrenza = percorrenzaDao.creazionePercorrenza(oraInizio, oraFine);
                            percorrenzaDao.salva(nuovaPercorrenza);

                            System.out.println("Nuova percorrenza creata con successo.");
                        }
                    }

                }
            }

        }
    }