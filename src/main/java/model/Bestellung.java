package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Bestellung")
public class Bestellung implements Serializable {
    @Column(name = "Datum")
    public Date Datum;
    @Column(name = "Gewicht")
    protected Integer Gewicht;
    @Column(name = "Warenwert")
    protected Double Warenwert;
    @Column(name = "Bearbeitungsstatus")
    protected String Bearbeitungsstatus;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "einkauf_EinkaufID", nullable = false)
    protected Einkauf Einkauf;
    private Integer bestellungID;

    @Id
    @Column(name = "BestellungID", nullable = false)
    public Integer getBestellungID() {
        return bestellungID;
    }

    public void setBestellungID(Integer bestellungID) {
        this.bestellungID = bestellungID;
    }

    public Date getDatum() {
        return Datum;
    }

    public void setDatum(Date datum) {
        Datum = datum;
    }

    public Integer getGewicht() {
        return Gewicht;
    }

    public void setGewicht(Integer gewicht) {
        Gewicht = gewicht;
    }

    public Double getWarenwert() {
        return Warenwert;
    }

    public void setWarenwert(Double warenwert) {
        Warenwert = warenwert;
    }

    public String getBearbeitungsstatus() {
        return Bearbeitungsstatus;
    }

    public void setBearbeitungsstatus(String bearbeitungsstatus) {
        Bearbeitungsstatus = bearbeitungsstatus;
    }

}
