package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Kundenauftrag")
public class Kundenauftrag implements Serializable {
    @Id
    @Column(name = "AuftragID", nullable = false)
    protected Integer auftragID;
    @ManyToOne
    @JoinColumn(name = "zahlung_RechnungsNr", nullable = false)
    protected Zahlung Zahlung;
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
    @JoinColumn(name = "lieferdienst_ID", nullable = false)
    protected Lieferdienst lieferdienst;


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

