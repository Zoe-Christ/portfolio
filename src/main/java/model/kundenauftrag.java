package model;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
import org.hibernate.type.DateType;
import org.hibernate.type.DoubleType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(appliesTo = "model.kundenauftrag")
public class kundenauftrag implements Serializable {
    @Id
    @Column(name ="AuftragID", nullable = false)
    protected Integer AuftragID;

    @Column(name="Datum")
    public Date Datum;

    @Column(name="Gewicht")
    public Double Gewicht;

    @Column(name = "Warenwert")
    public Double Warenwert;

    @Column(name = "Bearbeitungsstatus")
    public String Bearbeitungsstatus;

    @Column(name = "Lieferart")
    public String Lieferart;


    @JoinColumn(name = "zahlung_RechnungsNr", nullable = false)
    protected zahlung Zahlung;

    @ManyToOne
    @JoinColumn(name = "kunde_KundID", nullable = false)
    protected kunde kunde;


    @ManyToOne
    @JoinColumn(name = "lieferdienst_ID", nullable = false)
    protected lieferdienst lieferdienst;


    public kundenauftrag(){ }


    public Integer getAuftragID() {
        return AuftragID;
    }

    public void setAuftragID(Integer auftragID) {
        AuftragID = auftragID;
    }

    public Date getDatum() {
        return Datum;
    }

    public void setDatum(String datum) {
        Datum = datum;
    }

    public Double getGewicht() {
        return Gewicht;
    }

    public void setGewicht(Double gewicht) {
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

    public String getLieferart() {
        return Lieferart;
    }

    public void setLieferart(String lieferart) {
        Lieferart = lieferart;
    }
}

