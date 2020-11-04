package model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "adresse")
public class Adresse implements Serializable {
    @Column(name = "Strasse")
    public String strasse;
    @Column(name = "Hausnummer")
    public String hausnummer;
    @Id
    @Column(name = "AdressID", nullable = false)
    protected Integer adressID;

    @OneToOne
    @JoinColumn(name = "plz_PLZ")
    private Plz plz;

    @OneToOne
    @JoinColumn(name = "adresse_AdressID")
    protected Filiale filiale;

    @OneToOne
    @JoinColumn(name = "adresse_AdressID")
    protected Lager lager;

    @ManyToMany(mappedBy = "Adresse")
    private Set<Kunde> kunden = new HashSet<>();

    @ManyToMany(mappedBy = "Adresse")
    private Set<Mitarbeiter> mitarbeiter = new HashSet<>();

    public Adresse() {
    }

    public Integer getAdressID() {
        return adressID;
    }

    public void setAdressID(Integer adressID) {
        this.adressID = adressID;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

}
