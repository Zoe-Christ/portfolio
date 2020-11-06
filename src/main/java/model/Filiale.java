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
    private Set<Produkt> produkt;

    @OneToMany(mappedBy="Filiale")
    private Set<Lieferung> lieferung;




    public Integer getFilialeID() {
        return filialeID;
    }

    public void setFilialeID(Integer filialeID) {
        this.filialeID = filialeID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getVerkaufsFlaeche() {
        return VerkaufsFlaeche;
    }

    public void setVerkaufsFlaeche(String verkaufsFlaeche) {
        VerkaufsFlaeche = verkaufsFlaeche;
    }

    public String getOeffnungszeit() {
        return Oeffnungszeit;
    }

    public void setOeffnungszeit(String oeffnungszeit) {
        Oeffnungszeit = oeffnungszeit;
    }

    public Double getUmsatz() {
        return Umsatz;
    }

    public void setUmsatz(Double umsatz) {
        Umsatz = umsatz;
    }

    public Adresse getAdresse_AdressID() {
        return adresse_AdressID;
    }

    public void setAdresse_AdressID(Adresse adresse_AdressID) {
        this.adresse_AdressID = adresse_AdressID;
    }

    public Set<Produkt> getP() {
        return produkt;
    }

    public void setP(Set<Produkt> p) {
        produkt = p;
    }

    public Set<Lieferung> getL() {
        return lieferung;
    }

    public void setL(Set<Lieferung> l) {
        lieferung = l;
    }



}
