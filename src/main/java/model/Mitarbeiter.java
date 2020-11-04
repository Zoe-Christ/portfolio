package model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Mitarbeiter")
public class Mitarbeiter implements Serializable {
    @Id
    @Column(name = "MitarbeiterID", nullable = false)
    private Integer mitarbeiterID;

    @Column(name = "Vorname")
    private String vorname;

    @Column(name = "Nachname")
    private String nachname;

    @Column(name = "Mail")
    private String mail;

    @Column(name = "Gehalt")
    private Double gehalt;

    @Column(name = "Tel")
    private Integer tel;


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
        return mitarbeiterID;
    }

    public void setMitarbeiterID(Integer mitarbeiterID) {
        this.mitarbeiterID = mitarbeiterID;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Double getGehalt() {
        return gehalt;
    }

    public void setGehalt(Double gehalt) {
        this.gehalt = gehalt;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
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

