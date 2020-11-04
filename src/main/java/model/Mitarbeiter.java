package model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Mitarbeiter")
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
    protected Filiale filiale;

    @ManyToMany
    @JoinColumn(name = "adresse_AdressID", nullable = false)
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

    public Filiale getFiliale() {
        return filiale;
    }

    public void setFiliale(Filiale filiale) {
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

