package entites;

import enumeration.Ruolo;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Utente {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;
    @Column(length = 30, nullable = false)
    private String username;
    @Column(length = 12, nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Ruolo ruolo;

    @OneToOne
    @JoinColumn(name = "tessera_id")
    private Tessera tessera;
    @OneToMany(mappedBy = "utente")
    private Set<Biglietto> biglietti;
    public Utente() {
    }

    public Utente(String nome, String cognome, String username, String password, Ruolo ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
        this.ruolo = ruolo;
    }

    public Utente(String nome, String cognome, String username, String password, Ruolo ruolo, Set<Biglietto> biglietti) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
        this.ruolo = ruolo;
        this.biglietti = biglietti;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public Set<Biglietto> getBiglietti() {
        return biglietti;
    }

    public void setBiglietti(Set<Biglietto> biglietti) {
        this.biglietti = biglietti;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ruolo=" + ruolo +
                ", tessera=" + tessera +
                ", biglietti=" + biglietti +
                '}';
    }
}
