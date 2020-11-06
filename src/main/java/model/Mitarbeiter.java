package model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "mitarbeiter")
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

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "mitarbeiter_has_Adresse",
            joinColumns = {@JoinColumn(name = "mitarbeiter_MitarbeiterID")},
            inverseJoinColumns = {@JoinColumn(name = "adresse_AdressID")}
    )
    Set<Adresse> projects = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "mitarbeiter_has_Rolle",
            joinColumns = {@JoinColumn(name = "mitarbeiter_MitarbeiterID")},
            inverseJoinColumns = {@JoinColumn(name = "rolle_Rollen_ID")}
    )
    Set<Rolle> rolle = new HashSet<>();

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

    public Abteilung getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(Abteilung abteilung) {
        this.abteilung = abteilung;
    }

    public Set<Adresse> getProjects() {
        return projects;
    }

    public void setProjects(Set<Adresse> projects) {
        this.projects = projects;
    }

    public Set<Rolle> getRolle() {
        return rolle;
    }

    public void setRolle(Set<Rolle> rolle) {
        this.rolle = rolle;
    }
}

