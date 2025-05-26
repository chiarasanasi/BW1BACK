package entites;

import enumeration.TipoMezzo;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "mezzi")
public class Mezzo {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private int capienza;
   @Enumerated(EnumType.STRING)
   @Column(name = "tipo_mezzo")
   private TipoMezzo tipoMezzo;
   @Column(name = "data_servizio")
   private LocalDate dataServizio;
   private List<ServizioEffettivo> serviziEffettivi;
   private List<Biglietto> bigliettiVidimati;
// private Tratta tratta;

   public Mezzo(int capienza, TipoMezzo tipoMezzo, LocalDate dataServizio) {
      this.capienza = capienza;
      this.tipoMezzo = tipoMezzo;
      this.dataServizio = dataServizio;
   }

   public Mezzo() {
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public int getCapienza() {
      return capienza;
   }

   public void setCapienza(int capienza) {
      this.capienza = capienza;
   }

   public TipoMezzo getTipoMezzo() {
      return tipoMezzo;
   }

   public void setTipoMezzo(TipoMezzo tipoMezzo) {
      this.tipoMezzo = tipoMezzo;
   }

   public LocalDate getDataServizio() {
      return dataServizio;
   }

   public void setDataServizio(LocalDate dataServizio) {
      this.dataServizio = dataServizio;
   }

   public List<ServizioEffettivo> getServiziEffettivi() {
      return serviziEffettivi;
   }

   public void setServiziEffettivi(List<ServizioEffettivo> serviziEffettivi) {
      this.serviziEffettivi = serviziEffettivi;
   }

  public List<Biglietto> getBigliettiVidimati() {
      return bigliettiVidimati;
   }

   public void setBigliettiVidimati(List<Biglietto> bigliettiVidimati) {
    this.bigliettiVidimati = bigliettiVidimati;
   }
//
//   public Tratta getTratta() {
//      return tratta;
//   }
//
//   public void setTratta(Tratta tratta) {
//      this.tratta = tratta;
//   }

   @Override
   public String toString() {
      return "Mezzo{" +
              "id=" + id +
              ", capienza=" + capienza +
              ", tipoMezzo=" + tipoMezzo +
              ", dataServizio=" + dataServizio +
              '}';
   }
}
