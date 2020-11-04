package model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Adresse")
public class Adresse implements Serializable {
    @Column(name = "Strasse")
    public String Strasse;
    @Id
    @Column(name = "AdressID", nullable = false)
    protected Integer AdressID;

    @Column(name = "Hausnummer")
    public String Hausnummer;

    @OneToOne
    @JoinColumn(name = "plz_PLZ")
    private Plz plz;

    @OneToOne
    @JoinColumn(name = "Filiale_AdressID")
    protected Filiale filiale;
    @ManyToMany(mappedBy = "Adresse")
    private Set<Kunde> kunden = new HashSet<>();

    public Adresse() {
    }


    public Integer getAdressID() {
        return AdressID;
    }

    public void setAdressID(Integer adressID) {
        AdressID = adressID;
    }

    public String getStrasse() {
        return Strasse;
    }

    public void setStrasse(String strasse) {
        Strasse = strasse;
    }

    public String getHausnummer() {
        return Hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        Hausnummer = hausnummer;
    }

}
