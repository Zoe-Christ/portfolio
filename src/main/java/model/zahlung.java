package model;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Table(appliesTo = "model.zahlung")
public class zahlung implements Serializable {
    @Id
    @Column(name ="RehchnungsNr", nullable = false)
    protected Integer RechnungsNr;

    @Column(name="Zahlungsart")
    public String Zahlungsart;

    @Column(name="Betrag")
    public Integer Betrag;

    @Column(name = "Status")
    public String Status;

    @Column(name = "AusfuehrDatum")
    public Date AusfuehrDatum;

    @Column(name = "FaelligkeitsDatum")
    public Date FaelligkeitsDatum;





    public zahlung(){ }


    public Integer getRechnungsNr() {
        return RechnungsNr;

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
            AusfuehrDatum = ausfuehrdatum;
        }

        public Date getFaelligkeitsDatum() {
            return FaelligkeitsDatum;
        }

        public void setFaelligkeitsDatum(Date faelligkeitsDatum) {
            FaelligkeitsDatum = faelligkeitsDatum;
        }


    }


