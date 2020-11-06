package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Einkauf")
public class Einkauf implements Serializable {
    @Id
    @Column(name = "EinkaufID", nullable = false)
    private Integer einkaufID;
    @Column(name = "Saison")
    protected String saison;
    @Column(name = "Richtlinie")
    protected String richtlinie;
    @Column(name = "Bestandswert")
    protected Double bestandswert;
    @Column(name = "Budget")
    private Double budget;

    @OneToMany(mappedBy = "Einkauf")
    private Set<Abteilung> abteilung;

    @OneToMany(mappedBy = "Einkauf")
    private Set<Bestellung> bestellung;

    public Einkauf() {
    }

    public Integer getEinkaufID() {
        return einkaufID;
    }

    public void setEinkaufID(Integer einkaufID) {
        this.einkaufID = einkaufID;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

    public String getRichtlinie() {
        return richtlinie;
    }

    public void setRichtlinie(String richtlinie) {
        this.richtlinie = richtlinie;
    }

    public Double getBestandswert() {
        return bestandswert;
    }

    public void setBestandswert(Double bestandswert) {
        this.bestandswert = bestandswert;
    }
}
