package model;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
import org.hibernate.type.DateType;
import org.hibernate.type.DoubleType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(appliesTo = "model.lieferung")
public class lieferung implements Serializable {
    @Id
    @Column(name ="LieferungID", nullable = false)
    protected Integer LieferungID;

    @Column(name="Abfahrt")
    public String Abfahrt;

    @Column(name="Liefertermin")
    public Double Liefertermin;

    @Column(name = "Gewicht")
    public Double Gewicht;

    @ManyToOne
    @JoinColumn(name = "lager_LagerID", nullable = false)
    protected lager lager;

    @ManyToOne
    @JoinColumn(name = "lager_Adresse_AdressID", nullable = false)
    protected Adresse Adresse;

    @ManyToOne
    @JoinColumn(name = "spediteur_SpediteurID", nullable = false)
    protected spediteur spediteur;

    @ManyToOne
    @JoinColumn(name = "filiale_FilialeID", nullable = false)
    protected filiale filiale;

    @ManyToOne
    @JoinColumn(name = "filiale_adresse_AdressID", nullable = false)
    protected Adresse Adresse;

    @ManyToOne
    @JoinColumn(name = "fahrzeug_Fahrzeug_ID", nullable = false)
    protected fahrzeug fahrzeug;



    public lieferung(){ }


    public Integer getLieferungIDID() {
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


