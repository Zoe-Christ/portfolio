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
    protected Adresse Lager_Adresse;

    @ManyToOne
    @JoinColumn(name = "spediteur_SpediteurID", nullable = false)
    protected Spediteur spediteur;

    @ManyToOne
    @JoinColumn(name = "filiale_FilialeID", nullable = false)
    protected Filiale filiale;

    @ManyToOne
    @JoinColumn(name = "filiale_adresse_AdressID", nullable = false)
    protected Adresse Filiale_adresse;

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

    public Double getLiefertermin() {
        return Liefertermin;
    }

    public void setLiefertermin(Double liefertermin) {
        Liefertermin = liefertermin;
    }

    public Double getGewicht() {
        return Gewicht;
    }

    public void setGewicht(Double gewicht) {
        Gewicht = gewicht;
    }

    public Lager getLager() {
        return lager;
    }

    public void setLager(Lager lager) {
        this.lager = lager;
    }

    public Adresse getLager_Adresse() {
        return Lager_Adresse;
    }

    public void setLager_Adresse(Adresse lager_Adresse) {
        Lager_Adresse = lager_Adresse;
    }

    public Spediteur getSpediteur() {
        return spediteur;
    }

    public void setSpediteur(Spediteur spediteur) {
        this.spediteur = spediteur;
    }

    public Filiale getFiliale() {
        return filiale;
    }

    public void setFiliale(Filiale filiale) {
        this.filiale = filiale;
    }

    public Adresse getFiliale_adresse() {
        return Filiale_adresse;
    }

    public void setFiliale_adresse(Adresse filiale_adresse) {
        Filiale_adresse = filiale_adresse;
    }

    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(Fahrzeug fahrzeug) {
        this.fahrzeug = fahrzeug;
    }
}


