package model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Teil")
public class Teil implements Serializable {

    @Id
    @Column(name = "TeilID", nullable = false)
    private Integer teilID;

    @Column(name = "Name")
    public String name;

    @Column(name = "Funktion")
    public String funktion;

    @Column(name = "Material")
    public String material;

    @Column(name = "Preis")
    public Double preis;

    @ManyToOne()
    @JoinColumn(name = "lager_LagerID", nullable = false)
    protected Lager lager;

    @ManyToOne()
    @JoinColumn(name = "produkt_ProduktNR")
    private Produkt produkt;

    @ManyToOne
    @JoinColumn(name = "zulieferer_ZuliefererID", nullable = false)
    private Zulieferer zulieferer;

    @ManyToOne
    @JoinColumn(name = "maschine_MaschineID", nullable = false)
    private Maschine maschine;

    @ManyToMany(mappedBy = "teil")
    private Set<Bestellung> bestellung = new HashSet<>();

    public Teil() {
    }

    public Integer getTeilID() {
        return teilID;
    }

    public void setTeilID(Integer teilID) {
        this.teilID = teilID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunktion() {
        return funktion;
    }

    public void setFunktion(String funktion) {
        this.funktion = funktion;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getPreis() {
        return preis;
    }

    public void setPreis(Double preis) {
        this.preis = preis;
    }

    public Lager getLager() {
        return lager;
    }

    public void setLager(Lager lager) {
        this.lager = lager;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }

    public Zulieferer getZulieferer() {
        return zulieferer;
    }

    public void setZulieferer(Zulieferer zulieferer) {
        this.zulieferer = zulieferer;
    }

    public Maschine getMaschine() {
        return maschine;
    }

    public void setMaschine(Maschine maschine) {
        this.maschine = maschine;
    }

    public Set<Bestellung> getBestellung() {
        return bestellung;
    }

    public void setBestellung(Set<Bestellung> bestellung) {
        this.bestellung = bestellung;
    }
}
