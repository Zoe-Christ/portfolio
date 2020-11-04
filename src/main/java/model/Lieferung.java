package model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Lieferung")
public class Lieferung implements Serializable {
    @Column(name = "Abfahrt")
    public String abfahrt;
    @Column(name = "Liefertermin")
    public Double liefertermin;
    @Column(name = "Gewicht")
    public Double gewicht;
    @ManyToOne
    @JoinColumn(name = "lager_LagerID")
    protected Lager lager;
    @ManyToOne
    @JoinColumn(name = "lager_Adresse_AdressID")
    protected Adresse Lager_Adresse;
    @ManyToOne
    @JoinColumn(name = "spediteur_SpediteurID")
    protected Spediteur spediteur;
    @ManyToOne
    @JoinColumn(name = "filiale_FilialeID")
    protected Filiale filiale;
    @ManyToOne
    @JoinColumn(name = "filiale_adresse_AdressID")
    protected Adresse Filiale_adresse;
    @ManyToOne
    @JoinColumn(name = "fahrzeug_Fahrzeug_ID")
    protected Fahrzeug fahrzeug;
    @Id
    @Column(name = "LieferungID", nullable = false)
    private Integer lieferungID;


    public Lieferung() {
    }

    public Integer getLieferungID() {
        return lieferungID;
    }

    public void setLieferungID(Integer lieferungID) {
        this.lieferungID = lieferungID;
    }

    public String getAbfahrt() {
        return abfahrt;
    }

    public void setAbfahrt(String abfahrt) {
        this.abfahrt = abfahrt;
    }

    public Double getLiefertermin() {
        return liefertermin;
    }

    public void setLiefertermin(Double liefertermin) {
        this.liefertermin = liefertermin;
    }

    public Double getGewicht() {
        return gewicht;
    }

    public void setGewicht(Double gewicht) {
        this.gewicht = gewicht;
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


