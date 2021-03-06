package model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**TODO:
 * Entity-Klasse für die Tabelle Adresse
 */
@Entity
@Table(name = "adresse")
public class Adresse implements Serializable {
    @Id
    @Column(name = "AdressID", nullable = false)
    private Integer adressID;
    @Column(name = "Strasse")
    private String strasse;
    @Column(name = "Hausnummer")
    private String hausnummer;

    @OneToOne
    @JoinColumn(name = "plz_PLZ")
    private Plz plz;

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
