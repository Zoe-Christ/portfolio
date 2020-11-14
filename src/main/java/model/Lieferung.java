package model;


import javax.persistence.*;
import java.io.Serializable;

/**TODO:
 * Entity-Klasse für die Tabelle Lieferung
 */
@Entity
@Table(name = "Lieferung")
public class Lieferung implements Serializable {
    @Id
    @Column(name = "LieferungID", nullable = false)
    private Integer lieferungID;
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
    protected Adresse lagerAdresse;

    @ManyToOne
    @JoinColumn(name = "spediteur_SpediteurID")
    protected Spediteur spediteur;

    @ManyToOne
    @JoinColumn(name = "filiale_FilialeID")
    protected Filiale filiale;

    @ManyToOne
    @JoinColumn(name = "filiale_adresse_AdressID")
    protected Adresse filialeAdresse;

    @ManyToOne
    @JoinColumn(name = "fahrzeug_Fahrzeug_ID")
    protected Fahrzeug fahrzeug;


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

    public Adresse getLagerAdresse() {
        return lagerAdresse;
    }

    public void setLagerAdresse(Adresse lagerAdresse) {
        this.lagerAdresse = lagerAdresse;
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

    public Adresse getFilialeAdresse() {
        return filialeAdresse;
    }

    public void setFilialeAdresse(Adresse filialeAdresse) {
        this.filialeAdresse = filialeAdresse;
    }

    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(Fahrzeug fahrzeug) {
        this.fahrzeug = fahrzeug;
    }
}


