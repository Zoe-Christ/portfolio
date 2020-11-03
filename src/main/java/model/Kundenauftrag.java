package model;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Kundenauftrag")
public class Kundenauftrag implements Serializable {
    @Id
    @Column(name = "AuftragID", nullable = false)
    protected Integer AuftragID;

    @Column(name = "Datum")
    public Date Datum;

    @Column(name = "Gewicht")
    public Double Gewicht;

    @Column(name = "Warenwert")
    public Double Warenwert;

    @Column(name = "Bearbeitungsstatus")
    public String Bearbeitungsstatus;

    @Column(name = "Lieferart")
    public String Lieferart;


    @JoinColumn(name = "zahlung_RechnungsNr", nullable = false)
    protected model.Zahlung Zahlung;

    @ManyToOne
    @JoinColumn(name = "kunde_KundeID", nullable = false)
    protected Kunde kunde;


    @ManyToOne
    @JoinColumn(name = "lieferdienst_ID", nullable = false)
    protected Lieferdienst lieferdienst;


    public Kundenauftrag() {
    }


    public Integer getAuftragID() {
        return AuftragID;
    }

    public void setAuftragID(Integer auftragID) {
        AuftragID = auftragID;
    }

    public Date getDatum() {
        return Datum;
    }

    public void setDatum(Date datum) {
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

