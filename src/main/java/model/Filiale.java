package model;

import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Filiale")
public class Filiale implements Serializable {
    private Integer filialeID;

    @Id
    @Column(name = "FilialeID", nullable = false)
    protected Integer FilialeID;

    @Column(name = "Name")
    protected String Name;

    @Column(name = "VerkaufsFlaeche")
    protected String VerkaufsFlaeche;

    @Column(name = "OeffnungsZeit")
    protected String Oeffnungszeit;

    @Column(name = "Umsatz")
    protected Double Umsatz;

    @ManyToOne
    @JoinColumn(name = "adresse_AdressID", nullable = false)
    protected Adresse adresse_AdressID;


    @OneToMany(mappedBy = "Filiale")
    private Set <Produkt> P;

    @OneToMany(mappedBy="Filiale")
    private Set <Lieferung> L;


    public Integer getFilialeID() {
        return filialeID;
    }

    public void setFilialeID(Integer filialeID) {
        this.filialeID = filialeID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        Name = Name;
    }

    public String getVerkaufsFlaeche() {
        return VerkaufsFlaeche;
    }

    public void setVerkaufsFlaeche(String VerkaufsFlaeche) {  VerkaufsFlaeche = VerkaufsFlaeche;    }

    public String getOeffnungsZeit() {
        return OeffnungsZeit;
    }

    public void setOeffnungsZeit(String OeffnungsZeit) {
        OeffnungsZeit = OeffnungsZeit;
    }

    public Double getUmsatz() {
        return Umsatz;
    }

    public void setUmsatz(Double Umsatz) {
        Umsatz = Umsatz;
    }

    public Adresse getadresse_AdressID() {
        return adresse_AdressID;
    }

    public void setadresse_AdressID(Integer adresse_AdressID) {
        adresse_AdressID = adresse_AdressID;
    }

    public Set<Produkt> getP() {
        return P;
    }

    public void setP(Set<Produkt> p) { P = p;}

    public Set<Lieferung> getL() {
        return L;
    }

    public void setL(Set<Lieferung> l) { L = l;}
}
}
