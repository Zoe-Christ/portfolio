package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Kundenauftrag")
public class Kundenauftrag implements Serializable {

    @Id
    @Column(name = "AuftragID", nullable = false)
    private Integer auftragID;

    @Column(name = "Datum")
    private Date datum;

    @Column(name = "Gewicht")
    private Double gewicht;

    @Column(name = "Warenwert")
    private Double warenwert;

    @Column(name = "Bearbeitungsstatus")
    private String bearbeitungsstatus;

    @Column(name = "Lieferart")
    private String lieferart;

    @ManyToOne
    @JoinColumn(name = "kunde_KundeID", nullable = false)
    protected Kunde kunde;

    @ManyToOne
    @JoinColumn(name = "online_haendler_HaendlerID1", nullable = false)
    protected Online_haendler online_haendler;

    @ManyToOne
    @JoinColumn(name = "lieferdienst_ID", nullable = false)
    protected Lieferdienst lieferdienst;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Kundenauftrag_has_Produkt",
            joinColumns = {@JoinColumn(name = "kundenauftrag_AuftragID"), @JoinColumn(name = "kundenauftrag_zahlung_RechnungsNr")},
            inverseJoinColumns = {@JoinColumn(name = "produkt_ProduktNr")}
    )
    Set<Produkt> produkt = new HashSet<>();

    public Kundenauftrag() {
    }

    public Integer getAuftragID() {
        return auftragID;
    }

    public void setAuftragID(Integer auftragID) {
        this.auftragID = auftragID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Double getGewicht() {
        return gewicht;
    }

    public void setGewicht(Double gewicht) {
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

    public String getLieferart() {
        return lieferart;
    }

    public void setLieferart(String lieferart) {
        this.lieferart = lieferart;
    }
}

