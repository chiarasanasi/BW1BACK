import dao.UtenteDao;
import entites.Utente;
import enumeration.Ruolo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);

        UtenteDao utenteDao = new UtenteDao(em);

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

            if(utenteDao!=null){
                System.out.println("Bentornat* " + utenteLoggato.getNome() + " !");
                System.out.println("Premi un tasto per accedere al Menù");
                scanner.next();

                System.out.println("MENU" + "\n" +
                                "1 -> Calcola il giorno della scadenza della tua tessera" + "\n" +
                                "2 -> Rinnova la tua tessera" + "\n" +
                                "3 -> Controlla la validità del tuo abbonamento tramite l'id della tessera"
                        );
                int scelta = scanner.nextInt();

                switch (scelta){
                    case"1" -> {

                    }
                }
            }
        }else if(loginOregistrazione == 2){

        }else{}


    }
}
