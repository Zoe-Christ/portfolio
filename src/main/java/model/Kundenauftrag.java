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


    @OneToMany(mappedBy = "Kundenauftrag")
    private Set<Kundenauftrag_has_Produkt> kundenauftrag_has_produkt = new HashSet<>();

    public void addProdukt(Kundenauftrag_has_Produkt produkt) {
        this.kundenauftrag_has_produkt.add(produkt);
    }

    @OneToMany(mappedBy = "primaryKey.kundenauftrag",
            cascade = CascadeType.ALL)
    public Set<Kundenauftrag_has_Produkt> getKundenauftrag_has_Produkt() {
        return kundenauftrag_has_produkt;
    }

    public void setKundenauftrag_has_Produkt(Set<Kundenauftrag_has_Produkt> kundenauftrag_has_produkt) {
        this.kundenauftrag_has_produkt = kundenauftrag_has_produkt;
    }

    public void addKundenauftrag_has_Produkt(Kundenauftrag_has_Produkt kundenauftrag_has_produkt) {
        this.kundenauftrag_has_produkt.add(kundenauftrag_has_produkt);
    }

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

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public Online_haendler getOnline_haendler() {
        return online_haendler;
    }

    public void setOnline_haendler(Online_haendler online_haendler) {
        this.online_haendler = online_haendler;
    }

    public Lieferdienst getLieferdienst() {
        return lieferdienst;
    }

    public void setLieferdienst(Lieferdienst lieferdienst) {
        this.lieferdienst = lieferdienst;
    }

    public Set<Kundenauftrag_has_Produkt> getKundenauftrag_has_produkt() {
        return kundenauftrag_has_produkt;
    }

    public void setKundenauftrag_has_produkt(Set<Kundenauftrag_has_Produkt> kundenauftrag_has_produkt) {
        this.kundenauftrag_has_produkt = kundenauftrag_has_produkt;
    }
}

