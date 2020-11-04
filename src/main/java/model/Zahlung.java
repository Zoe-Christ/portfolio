package model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Zahlung")
public class Zahlung implements Serializable {

    @Id
    @Column(name = "RechnungsNr", nullable = false)
    protected Integer RechnungsNr;

    @Column(name = "Zahlungsart")
    public String Zahlungsart;

    @Column(name = "Betrag")
    public Integer Betrag;

    @Column(name = "Status")
    public String Status;

    @Column(name = "AusfuehrDatum")
    public Date AusfuehrDatum;

    @Column(name = "FaelligkeitsDatum")
    public Date FaelligkeitsDatum;

    @ManyToOne()
    @JoinColumn(name = "kundenauftrag_AuftragID")
    private Kundenauftrag kundenauftrag;

    public Zahlung() {
    }

    public Integer getRechnungsNr() {
        return RechnungsNr;
    }

    public void setRechnungsNr(Integer rechnungsNr) {
        RechnungsNr = rechnungsNr;
    }

    public String getZahlungsart() {
        return Zahlungsart;
    }

    public void setZahlungsart(String zahlungsart) {
        Zahlungsart = zahlungsart;
    }

    public Integer getBetrag() {
        return Betrag;
    }

    public void setBetrag(Integer betrag) {
        Betrag = betrag;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Date getAusfuehrDatum() {
        return AusfuehrDatum;
    }

    public void setAusfuehrDatum(Date ausfuehrDatum) {
        AusfuehrDatum = ausfuehrDatum;
    }

    public Date getFaelligkeitsDatum() {
        return FaelligkeitsDatum;
    }

    public void setFaelligkeitsDatum(Date faelligkeitsDatum) {
        FaelligkeitsDatum = faelligkeitsDatum;
    }
}


