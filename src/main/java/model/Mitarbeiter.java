package model;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Table(appliesTo = "model.mitarbeiter")
public class Mitarbeiter implements Serializable {
    @Id
    @Column(name = "MitarbeiterID", nullable = false)
    protected Integer MitarbeiterID;

    @Column(name = "Vorname")
    public String Vorname;

    @Column(name = "Nachname")
    public String Nachname;

    @Column(name = "Mail")
    public String Mail;

    @Column(name = "Gehalt")
    public Double Gehalt;

    @Column(name = "Tel")
    public Integer Tel;


    @ManyToOne
    @JoinColumn(name = "filiale_FilialeID", nullable = false)
    protected filiale filiale;

    @ManyToOne
    @JoinColumn(name = "filiale_adresse_AdressID", nullable = false)
    protected Adresse Adresse;

    @ManyToOne
    @JoinColumn(name = "abteilung_Kuerzel1", nullable = false)
    protected Abteilung abteilung;


    public Mitarbeiter() {
    }


    public Integer getMitarbeiterID() {
        return MitarbeiterID;
    }

    public void setMitarbeiterID(Integer mitarbeiterID) {
        MitarbeiterID = mitarbeiterID;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public Double getGehalt() {
        return Gehalt;
    }

    public void setGehalt(Double gehalt) {
        Gehalt = gehalt;
    }

    public Integer getTel() {
        return Tel;
    }

    public void setTel(Integer tel) {
        Tel = tel;
    }

    public model.filiale getFiliale() {
        return filiale;
    }

    public void setFiliale(model.filiale filiale) {
        this.filiale = filiale;
    }

    public model.Adresse getAdresse() {
        return Adresse;
    }

    public void setAdresse(model.Adresse adresse) {
        Adresse = adresse;
    }

    public Abteilung getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(Abteilung abteilung) {
        this.abteilung = abteilung;
    }
}

