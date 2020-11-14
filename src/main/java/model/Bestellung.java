package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**TODO:
 * Entity-Klasse für die Tabelle Bestellung
 */
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

    @OneToMany(mappedBy = "bestellung")
    private Set<Bestellung_has_Teil> bestellung_has_teil = new HashSet<>();

    public void addTeil(Bestellung_has_Teil teil) {
        this.bestellung_has_teil.add(teil);
    }

    @OneToMany(mappedBy = "primaryKey.bestellung",
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
