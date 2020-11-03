package model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Lieferung")
public class Lieferung implements Serializable {
    @Id
    @Column(name = "LieferungID", nullable = false)
    protected Integer LieferungID;

    @Column(name = "Abfahrt")
    public String Abfahrt;

    @Column(name = "Liefertermin")
    public Double Liefertermin;

    @Column(name = "Gewicht")
    public Double Gewicht;

    @ManyToOne
    @JoinColumn(name = "lager_LagerID", nullable = false)
    protected Lager lager;

    @ManyToOne
    @JoinColumn(name = "lager_Adresse_AdressID", nullable = false)
    protected Adresse Adresse;

    @ManyToOne
    @JoinColumn(name = "spediteur_SpediteurID", nullable = false)
    protected Spediteur spediteur;

    @ManyToOne
    @JoinColumn(name = "filiale_FilialeID", nullable = false)
    protected Filiale filiale;

    @ManyToOne
    @JoinColumn(name = "filiale_adresse_AdressID", nullable = false)
    protected Adresse Adresse;

    @ManyToOne
    @JoinColumn(name = "fahrzeug_Fahrzeug_ID", nullable = false)
    protected Fahrzeug fahrzeug;


    public Lieferung() {
    }


    public Integer getLieferungID() {
        return LieferungID;
    }

    public void setLieferungID(Integer lieferungID) {
        LieferungID = lieferungID;
    }


    public String getAbfahrt() {
        return Abfahrt;
    }

    public void setAbfahrt(String abfahrt) {
        Abfahrt = abfahrt;
    }


    public String getLiefertermin() {
        return Liefertermin;
    }

    public void setLiefertermin(String liefertermin) {
        Liefertermin = liefertermin;
    }

    public Double getGewicht() {
        return Gewicht;
    }

    public void setGewicht(Double gewicht) {
        Gewicht = gewicht;
    }

}


