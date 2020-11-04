package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Einkauf")
public class Einkauf extends Abteilung implements Serializable {

    @Column(name = "Saison")
    protected String saison;
    @Column(name = "Richtlinie")
    protected String richtlinie;
    @Column(name = "Bestandswert")
    protected Double bestandswert;
    @Id
    @Column(name = "EinkaufID", nullable = false)
    private Integer einkaufID;
    @Column(name = "Budget")
    private Double budget;

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
