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
    public String Name;

    @Column(name = "Funktion")
    public String Funktion;

    @Column(name = "Material")
    public String Material;

    @Column(name = "Preis")
    public Double Preis;

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
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFunktion() {
        return Funktion;
    }

    public void setFunktion(String funktion) {
        Funktion = funktion;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String material) {
        Material = material;
    }

    public Double getPreis() {
        return Preis;
    }

    public void setPreis(Double preis) {
        Preis = preis;
    }
}
