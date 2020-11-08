package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
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
    private Set<Teil> teilList;

    @ManyToMany(mappedBy = "Online_haendler")
    private Set<Online_haendler> online_haendler = new HashSet<>();

    @ManyToMany(mappedBy = "Filiale")
    private Set<Filiale> filiale = new HashSet<>();

    @OneToMany(mappedBy = "Produkt")
    private Set<Kundenauftrag_has_Produkt> kundenauftrag_has_produkt = new HashSet<>();

    @OneToMany(mappedBy = "primaryKey.produkt",
            cascade = CascadeType.ALL)
    public Set<Kundenauftrag_has_Produkt> getKundenauftrag_has_Produkt() {
        return kundenauftrag_has_produkt;
    }

    public void setKundenauftrag_has_Produkt(Set<Kundenauftrag_has_Produkt> kundenauftrag_has_produkt) {
        this.kundenauftrag_has_produkt = kundenauftrag_has_produkt;
    }

    public void addKundenauftrag_has_Produkt(Kundenauftrag_has_Produkt kundenauftrag_has_produkt) {
        this.kundenauftrag_has_produkt.add(kundenauftrag_has_produkt);
    }


    public Produkt() {

    }


    public Set<Online_haendler> getOnline_haendler() {
        return online_haendler;
    }

    public void setOnline_haendler(Set<Online_haendler> online_haendler) {
        this.online_haendler = online_haendler;
    }

    public Set<Filiale> getFiliale() {
        return filiale;
    }

    public void setFiliale(Set<Filiale> filiale) {
        this.filiale = filiale;
    }

    public Set<Teil> getTeilList() {
        return teilList;
    }

    public void setTeilList(Set<Teil> teilList) {
        this.teilList = teilList;
    }

}
