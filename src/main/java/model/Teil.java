package model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**TODO:
 * Entity-Klasse für die Tabelle Teil
 */
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

    @OneToMany(mappedBy = "teil")
    private Set<Bestellung_has_Teil> bestellung_has_teil = new HashSet<>();

    @OneToMany(mappedBy = "primaryKey.teil",
            cascade = CascadeType.ALL)
    public Set<Bestellung_has_Teil> getBestellung_has_Teil() {
        return bestellung_has_teil;
    }

    public void setBestellung_has_Teil(Set<Bestellung_has_Teil> bestellung_has_teile) {
        this.bestellung_has_teil = bestellung_has_teile;
    }

    public void addBestellung_has_Teil(Bestellung_has_Teil bestellung_has_teil) {
        this.bestellung_has_teil.add(bestellung_has_teil);
    }

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

    public Set<Bestellung_has_Teil> getBestellung_has_teil() {
        return bestellung_has_teil;
    }

    public void setBestellung_has_teil(Set<Bestellung_has_Teil> bestellung_has_teil) {
        this.bestellung_has_teil = bestellung_has_teil;
    }
}
