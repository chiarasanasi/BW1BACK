package entites;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   private String nome;
   private String cognome;

   //@OneToOne
    @JoinColumn(name = "tessera_id", referencedColumnName = "id")
    private Tessera tessera;

    public Utente(Long id, String nome, String cognome, Tessera tessera) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.tessera = tessera;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", tessera=" + tessera +
                '}';
    }
}
