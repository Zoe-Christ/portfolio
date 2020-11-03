package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "produktion")
public class produktion implements Serializable{



    @Id
    @Column(name = "ProduktionID", nullable = false)
    protected Integer ProduktionID;

    //Spaltenname ändern in Tabelle
    @Column(name = "Anz_Produktionsplaetze", nullable = false)
    protected Integer Anz_Produktionsplaetze;

    @Column(name = "Kapazitaet", nullable = false)
    protected Long Kapazitaet;

    @Column(name = "Zeit", nullable = false)
    protected Date Zeit;

    @Column(name = "Prod_Kosten", nullable = false)
    protected Long Prod_Kosten;

    @ManyToOne
    @JoinColumn(name = "lager_LagerID", nullable = false)
    protected model.Lager Lager;

    @ManyToOne
    @JoinColumn(name = "qm_QMID1", nullable = false)
    protected qm QM;

    @ManyToOne
    @JoinColumn(name = "qm_abteilung_Kuerzel", nullable = false)
    protected qm QM;

    @OneToMany(mappedBy="produktion")
    private Set<maschine> maschine;

    public Integer getProduktionID() {
        return ProduktionID;
    }

    public void setProduktionID(Integer produktionID) {
        ProduktionID = produktionID;
    }

    public Long getKapazitaet() {
        return Kapazitaet;
    }

    public void setKapazitaet(Long kapazitaet) {
        Kapazitaet = kapazitaet;
    }

    public Date getZeit() {
        return Zeit;
    }

    public void setZeit(Date zeit) {
        Zeit = zeit;
    }

    public Long getProd_Kosten() {
        return Prod_Kosten;
    }

    public void setProd_Kosten(Long prod_Kosten) {
        Prod_Kosten = prod_Kosten;
    }

    public model.Lager getLager() {
        return Lager;
    }

    public void setLager(model.Lager lager) {
        Lager = lager;
    }

    public qm getQM() {
        return QM;
    }

    public void setQM(qm QM) {
        this.QM = QM;
    }

    public Set<maschine> getMaschine() {
        return maschine;
    }

    public void setMaschine(Set<maschine> maschine) {
        this.maschine = maschine;
    }


}
