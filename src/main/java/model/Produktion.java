package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**TODO:
 * Entity-Klasse für die Tabelle Produktion
 */
@Entity
@Table(name = "Produktion")
public class Produktion implements Serializable{

    @Id
    @Column(name = "ProduktionID", nullable = false)
    protected Integer produktionID;

    @Column(name = "Anz-Produktionsplaetze", nullable = false)
    protected Integer anzProduktionsplaetze;

    @Column(name = "Kapazitaet", nullable = false)
    protected Long kapazitaet;

    @Column(name = "Zeit", nullable = false)
    protected Date zeit;

    @Column(name = "Prod_Kosten", nullable = false)
    protected Long prodKosten;

    @ManyToOne
    @JoinColumn(name = "lager_LagerID", nullable = false)
    protected model.Lager lager;

    @ManyToOne
    @JoinColumn(name = "qm_QMID1", nullable = false)
    protected Qualitaetsmanagement QM;

    @ManyToOne
    @JoinColumn(name = "qm_abteilung_Kuerzel1", nullable = false)
    protected Qualitaetsmanagement qm_kuerzel;

    @OneToMany(mappedBy="produktion")
    private Set<Maschine> maschine;

    public Integer getProduktionID() {
        return produktionID;
    }

    public void setProduktionID(Integer produktionID) {
        this.produktionID = produktionID;
    }

    public Integer getAnzProduktionsplaetze() {
        return anzProduktionsplaetze;
    }

    public void setAnzProduktionsplaetze(Integer anzProduktionsplaetze) {
        this.anzProduktionsplaetze = anzProduktionsplaetze;
    }

    public Long getKapazitaet() {
        return kapazitaet;
    }

    public void setKapazitaet(Long kapazitaet) {
        this.kapazitaet = kapazitaet;
    }

    public Date getZeit() {
        return zeit;
    }

    public void setZeit(Date zeit) {
        this.zeit = zeit;
    }

    public Long getProdKosten() {
        return prodKosten;
    }

    public void setProdKosten(Long prodKosten) {
        this.prodKosten = prodKosten;
    }

    public model.Lager getLager() {
        return lager;
    }

    public void setLager(model.Lager lager) {
        this.lager = lager;
    }

    public Qualitaetsmanagement getQM() {
        return QM;
    }

    public void setQM(Qualitaetsmanagement QM) {
        this.QM = QM;
    }

    public Qualitaetsmanagement getQm_kuerzel() {
        return qm_kuerzel;
    }

    public void setQm_kuerzel(Qualitaetsmanagement qm_kuerzel) {
        this.qm_kuerzel = qm_kuerzel;
    }

    public Set<Maschine> getMaschine() {
        return maschine;
    }

    public void setMaschine(Set<Maschine> maschine) {
        this.maschine = maschine;
    }
}
