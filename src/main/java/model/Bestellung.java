package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Bestellung")
public class Bestellung implements Serializable {
    @Column(name = "Datum")
    public Date datum;
    @Id
    @Column(name = "BestellungID", nullable = false)
    private Integer bestellungID;
    @Column(name = "Gewicht")
    private Integer gewicht;
    @Column(name = "Warenwert")
    private Double warenwert;
    @Column(name = "Bearbeitungsstatus")
    private String bearbeitungsstatus;

    @ManyToOne()
    @JoinColumn(name = "einkauf_EinkaufID", nullable = false)
    private Einkauf Einkauf;

    public Integer getBestellungID() {
        return bestellungID;
    }

    public void setBestellungID(Integer bestellungID) {
        this.bestellungID = bestellungID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Integer getGewicht() {
        return gewicht;
    }

    public void setGewicht(Integer gewicht) {
        this.gewicht = gewicht;
    }

    public Double getWarenwert() {
        return warenwert;
    }

    public void setWarenwert(Double warenwert) {
        this.warenwert = warenwert;
    }

    public String getBearbeitungsstatus() {
        return bearbeitungsstatus;
    }

    public void setBearbeitungsstatus(String bearbeitungsstatus) {
        this.bearbeitungsstatus = bearbeitungsstatus;
    }

}
