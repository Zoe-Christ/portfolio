package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Produkt")
public class Produkt implements Serializable {

    @Id
    @Column(name = "ProduktNr", nullable = false)
    public Integer produktNr;
    @Column(name = "Name", nullable = false)
    public String name;
    @Column(name = "Beschreibung", nullable = false)
    public String beschreibung;
    @Column(name = "Preis", nullable = false)
    public Double preis;
    @Column(name = "Gewicht")
    public Double gewicht;
    @Column(name = "Groesse")
    public Double groesse;
    @Column(name = "Bestand")
    public Integer bestand;

    public Integer getProduktNr() {
        return produktNr;
    }

    public void setProduktNr(Integer produktNr) {
        this.produktNr = produktNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Double getPreis() {
        return preis;
    }

    public void setPreis(Double preis) {
        this.preis = preis;
    }

    public Double getGewicht() {
        return gewicht;
    }

    public void setGewicht(Double gewicht) {
        this.gewicht = gewicht;
    }

    public Double getGroesse() {
        return groesse;
    }

    public void setGroesse(Double groesse) {
        this.groesse = groesse;
    }

    public Integer getBestand() {
        return bestand;
    }

    public void setBestand(Integer bestand) {
        this.bestand = bestand;
    }

    @OneToMany(mappedBy = "ProduktNr")
    private List<Teil> teilList;

    @ManyToMany(mappedBy = "Online_haendler")
    private Set<Online_haendler> online_haendler = new HashSet<>();

    @ManyToMany(mappedBy = "Filiale")
    private Set<Filiale> filiale = new HashSet<>();

    public Produkt() {

    }

}
