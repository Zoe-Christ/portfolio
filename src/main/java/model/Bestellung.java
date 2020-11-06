package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Bestellung_has_Teil",
            joinColumns = {@JoinColumn(name = "bestellung_bestellungid")},
            inverseJoinColumns = {@JoinColumn(name = "teil_teilid")}
    )
    Set<Teil> teil = new HashSet<>();

    @ManyToOne()
    @JoinColumns({
            @JoinColumn(name = "einkauf_EinkaufID", referencedColumnName = "EinkaufID", nullable = false),
            @JoinColumn(name = "einkauf_Abteilung_Kuerzel", referencedColumnName = "Abteilung_Kuerzel", nullable = false)
    })
    private Einkauf einkauf;

    @ManyToOne()
    @JoinColumn(name = "zulieferer_ZuliefererID", nullable = false)
    private Zulieferer zulieferer;

    public Bestellung() {
    }

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
