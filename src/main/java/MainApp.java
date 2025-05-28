import dao.*;
import entites.*;
import enumeration.Ruolo;
import enumeration.StatoServizio;
import enumeration.TipoDistributore;
import enumeration.TipoMezzo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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
        PuntoDiEmissione puntoDiEmissioneDao = new PuntoDiEmissione(em);
        ServizioManutenzioneDao servizioManutenzioneDao = new ServizioManutenzioneDao();


        Utente u1 = new Utente("Chiara","Sanasi","chiarasan","12345678", Ruolo.UTENTE_NORMALE);
        Utente u2 = new Utente("Salvatore","Gianquinto","salvatore","a2345678", Ruolo.UTENTE_NORMALE);
        Utente u3 = new Utente("Leonard","Dautaru","leo","b2345678", Ruolo.UTENTE_NORMALE);
        Utente u4 = new Utente("Silvia","Gasperini","silvia","c2345678", Ruolo.UTENTE_NORMALE);
        Utente u5 = new Utente("Roberto","Albergo","rob","d2345678", Ruolo.UTENTE_NORMALE);
        Utente u6 = new Utente("Roberto","Ciancio","ciancio","e2345678", Ruolo.UTENTE_NORMALE);
        Utente u7 = new Utente("Pietro","Sorbo","pietro","f2345678", Ruolo.UTENTE_NORMALE);

        Utente u8 = new Utente("Vincenzo", "Napoli", "vinz", "g2345678", Ruolo.AMMINISTRATORE);

        utenteDao.salva(u1);
        utenteDao.salva(u2);
        utenteDao.salva(u3);
        utenteDao.salva(u4);
        utenteDao.salva(u5);
        utenteDao.salva(u6);
        utenteDao.salva(u7);
        utenteDao.salva(u8);

        Tessera ts1 = new Tessera(LocalDate.of(2020,1,1));
        Tessera ts2 = new Tessera(LocalDate.of(2020,1,1));
        Tessera ts3 = new Tessera(LocalDate.of(2020,1,1));
        Tessera ts4 = new Tessera(LocalDate.of(2020,1,1));

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

        ServizioManutenzione s1 = new ServizioManutenzione(StatoServizio.IN_SERVIZIO,LocalDate.of(2000,1,1),LocalDate.of(2000,3,1),LocalDate.of(2000,3,2),LocalDate.now());
        ServizioManutenzione s2 = new ServizioManutenzione(StatoServizio.IN_SERVIZIO,LocalDate.of(2022,3,12),LocalDate.of(2022,6,1),LocalDate.of(2022,6,3),LocalDate.now());
        ServizioManutenzione s3 = new ServizioManutenzione(StatoServizio.IN_MANUTENZIONE,LocalDate.of(2025,5,1),LocalDate.now(),LocalDate.of(2023,1,1),LocalDate.of(2025,4,30));
        ServizioManutenzione s4 = new ServizioManutenzione(StatoServizio.IN_MANUTENZIONE,LocalDate.of(2020,1,1),LocalDate.now(),LocalDate.of(2019,3,2),LocalDate.of(2019,12,31));

        servizioManutenzioneDao.salva(s1);
        servizioManutenzioneDao.salva(s2);
        servizioManutenzioneDao.salva(s3);
        servizioManutenzioneDao.salva(s4);

        Percorrenza p1 = new Percorrenza(LocalTime.of(5,0),LocalTime.of(23,59));
        Percorrenza p2 = new Percorrenza(LocalTime.of(6,0),LocalTime.of(1,0));
        Percorrenza p3 = new Percorrenza(LocalTime.of(12,0),LocalTime.of(3,0));
        Percorrenza p4 = new Percorrenza(LocalTime.of(15,0),LocalTime.of(22,59));

        percorrenzaDao.salva(p1);
        percorrenzaDao.salva(p2);
        percorrenzaDao.salva(p3);
        percorrenzaDao.salva(p4);

        m1.setMezzoPercorrenze(List.of(p1,p2));
        m2.setMezzoPercorrenze(List.of(p2,p3));
        m3.setMezzoPercorrenze(List.of(p1,p4));
        m4.setMezzoPercorrenze(List.of(p3,p4));

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

        if (loginOregistrazione==1){
            System.out.println("Digita il tuo username");
            String username = scanner.nextLine();
            System.out.println("Digita la tua password");
            String password = scanner.nextLine();

            Utente utenteLoggato = utenteDao.trovaTramiteUsernamePassword(username,password);

            if(utenteLoggato!=null&&utenteLoggato.getRuolo().equals(Ruolo.UTENTE_NORMALE)){
                System.out.println("Bentornat* " + utenteLoggato.getNome() + " !");
                System.out.println("Premi un tasto per accedere al Menù degli Utenti");
                scanner.next();
                int scelta = 100000;
                boolean sceltaWhile = true;

                while (sceltaWhile){
                    System.out.println("MENU" + "\n" +
                            "1 -> Calcola il giorno della scadenza della tua tessera" + "\n" +
                            "2 -> Rinnova la tua tessera" + "\n" +
                            "3 -> Controlla la validità del tuo abbonamento tramite l'id della tessera" + "\n" +
                            "0 -> Termina il programma ! "
                    );
                    scelta = scanner.nextInt();
                    scanner.nextLine();



                    switch (scelta){
                        case 1 -> {
                            Tessera tesseraUtenteLoggato = utenteLoggato.getTessera();
                            tesseraDao.calcoloGiornoScadenzaTessera(tesseraUtenteLoggato.getId());
                        }
                        case 2 -> {
                            Tessera tesseraUtenteLoggato = utenteLoggato.getTessera();
                            tesseraDao.rinnovoTessera(tesseraUtenteLoggato.getId());
                        }
                        case 3 ->{
                            Tessera tesseraUtenteLoggato = utenteLoggato.getTessera();
                            TitoloDiViaggio abbonamentoUtenteLoggato = tesseraUtenteLoggato.getAbbonamento();
                            Boolean risultato = titoloDiViaggioDao.controlloValiditaAbbonamentoTramiteIdTessera(tesseraUtenteLoggato.getId(), LocalDate.now());
                            if(risultato){
                                System.out.println("Il tuo abbonamento è valido");
                            }else {
                                System.out.println("Il tuo abbonamento non è valido");
                            }
                        }
                        case 0 -> {
                            System.out.println("Termina");
                            sceltaWhile = false;
                        }
                    }
                }
            }
            else if (utenteLoggato!=null&&utenteLoggato.getRuolo().equals(Ruolo.AMMINISTRATORE)) {
                System.out.println("Bentornat* " + utenteLoggato.getNome() + " !");
                System.out.println("Premi un tasto per accedere al Menù degli Amministratori");
                scanner.next();

                System.out.println("MENU" + "\n" +
                        "1 -> Calcola il numero di biglietti in un dato periodo" + "\n" +
                        "2 -> Lista dei mezzi in manutenzione" + "\n" +
                        "3 -> Lista dei mezzi in servizio"  + "\n" +
                        "4 -> Aggiorna lo stato di un mezzo"  + "\n" +
                        "5 -> Lista dei punti di emissione di titoli di viaggio"  + "\n" +
                        "6 -> Lista dei biglietti per punto di emissione"  + "\n" +
                        "7 -> Ricerca di tutti i biglietti"  + "\n" +
                        "8 -> Ricerca dei biglietti vidimati su un mezzo"  + "\n" +
                        "9 -> Ricerca dei biglietti vidimati in un dato periodo"  + "\n" +
                        "10 -> Ripetizione tratta tramite mezzo"  + "\n" +
                        "11 -> Ricerca del tempo effettivo di una corsa tramite tratta"  + "\n" +
                        "12 -> Tempo medio di percorrenza di una tratta dato un mezzo"
                );
                int scelta = scanner.nextInt();
                scanner.nextLine();

                switch (scelta){
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


                        titoloDiViaggioDao.numeroDiBigliettiInUnDatoPeriodo(LocalDate.of(annoDataInizio,meseDataInizio,giornoDataInizio), LocalDate.of(annoDataFine,meseDataFine,giornoDataFine));
                    }
                    case 2 -> {
                        mezzoDao.listaMezziManutenzione();
                    }
                    case  3 -> {
                        mezzoDao.listaMezziInServizio();
                    }
                    case 4 -> {
                        System.out.println("Scegli uno di questi mezzi : "  + "\n" +
                                "1 -> " + m1  + "\n" +
                                "2 -> " + m2  + "\n" +
                                "3 -> " + m3  + "\n" +
                                "4 -> " + m4
                                );
                        int sceltaMezzo = scanner.nextInt();
                        scanner.nextLine();

                        if(sceltaMezzo==1){
                            ServizioManutenzione servizioMezzoScelto = m1.getServizioManutenzione();
                            mezzoDao.updateStatoMezzo(m1.getId(),servizioMezzoScelto.getStatoServizio());
                        } else if (sceltaMezzo == 2) {
                            ServizioManutenzione servizioMezzoScelto = m2.getServizioManutenzione();
                            mezzoDao.updateStatoMezzo(m2.getId(),servizioMezzoScelto.getStatoServizio());
                        }else if (sceltaMezzo == 3) {
                            ServizioManutenzione servizioMezzoScelto = m3.getServizioManutenzione();
                            mezzoDao.updateStatoMezzo(m3.getId(),servizioMezzoScelto.getStatoServizio());
                        }else if (sceltaMezzo == 4) {
                            ServizioManutenzione servizioMezzoScelto = m4.getServizioManutenzione();
                            mezzoDao.updateStatoMezzo(m4.getId(),servizioMezzoScelto.getStatoServizio());
                        }else{
                            System.out.println("Il codice digitato non corrisponde a nessun mezzo presente nel DB");
                        }
                    }
                    case 5 -> {
                        System.out.println("pippa");
                    }
                    case 6 -> {
                        System.out.println("uguale a 5");
                    }
                    case 7 -> {
                        System.out.println("uguale a 6, bisogna mettere un metodo che prende tutti i biglietti");
                    }
                    case 8 -> {
                        System.out.println("Scegli uno di questi mezzi : "  + "\n" +
                                "1 -> " + m1  + "\n" +
                                "2 -> " + m2  + "\n" +
                                "3 -> " + m3  + "\n" +
                                "4 -> " + m4
                        );
                        int sceltaMezzo = scanner.nextInt();
                        scanner.nextLine();

                        if (sceltaMezzo==1){
                            titoloDiViaggioDao.ricercaBigliettiVidimatiTramiteMezzo(m1.getId());
                        }else if(sceltaMezzo==2){
                            titoloDiViaggioDao.ricercaBigliettiVidimatiTramiteMezzo(m2.getId());
                        }else if(sceltaMezzo==3){
                            titoloDiViaggioDao.ricercaBigliettiVidimatiTramiteMezzo(m3.getId());
                        }else if(sceltaMezzo==4){
                            titoloDiViaggioDao.ricercaBigliettiVidimatiTramiteMezzo(m4.getId());
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

                        titoloDiViaggioDao.ricercaBigliettiVidimatiPerPeriodo(LocalDate.of(annoDataInizio,meseDataInizio,giornoDataInizio), LocalDate.of(annoDataFine,meseDataFine,giornoDataFine));
                    }
                    case 10 -> {
                        System.out.println("pippaaaa");

                    }
                    case 11 -> {
                        System.out.println("pippaaaaaaaaaa");

                    }
                    case 12 -> {
                        //tutte le tratte nel db
                        List<Tratta> tratteDisponibili = em.createQuery("SELECT t FROM Tratta t", Tratta.class).getResultList();

                        if (tratteDisponibili.isEmpty()) {
                            System.out.println("Nessuna tratta disponibile.");
                            break;
                        }

                        System.out.println("Scegli una di queste tratte : "  + "\n" +
                                "1 -> Roma a Milano"+  "\n" +
                                "2 -> Napoli a Bari" +  "\n" +
                                "3 -> Torino a Venezia" +  "\n" +
                                "4 -> Firenze a Pisa"
                        );

                        System.out.print("Inserisci il numero della tratta scelta (1-4): ");
                        int sceltaTratta = scanner.nextInt();

                        if (sceltaTratta < 1 || sceltaTratta > 4) {
                            System.out.println("Scelta non valida.");
                            break;
                        }

                        Tratta trattaScelta = tratteDisponibili.get(scelta - 1);
                        Long trattaId = trattaScelta.getId();

                        Double tempoMedio = percorrenzaDao.tempoMedioPercorrenza(trattaId);

                        if (tempoMedio == null) {
                            System.out.println("Nessuna percorrenza trovata per la tratta selezionata.");
                        } else {
                            System.out.println("Il tempo medio di percorrenza per la tratta scelta è: " + tempoMedio + " minuti.");
                        }
                    }
                }


            }
        }else if(loginOregistrazione == 2){
            // da continuare
            System.out.println("registrazione");
        }else{
            //da continuare
            System.out.println("ne registrazione ne login");
        }


    }
}
