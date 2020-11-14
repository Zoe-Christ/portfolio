package model;

import javax.persistence.*;
import java.io.Serializable;

/**TODO:
 * Entity-Klasse für die Tabelle Spediteur
 */
@Entity
@Table(name = "Spediteur")
public class Spediteur implements Serializable {

    @Id
    @Column(name = "SpediteurID", nullable = false)
    protected Integer spediteurID;

    @Column(name = "Name")
    protected String name;

    @Column(name = "Zul_Gewicht")
    protected Double zul_Gewicht;

    @Column(name = "Liefertreue")
    protected String liefertreue;

    @Column(name = "HandelsregisterNr")
    protected String handelsregisterNr;

    @Column(name = "Ansprechpartner")
    protected String ansprechpartner;

    @Column(name = "Tel")
    protected Integer tel;

    @ManyToOne
    @JoinColumn(name = "vertrag_Vertrag_ID", nullable = false)
    protected Vertrag vertrag;

    public Integer getSpediteurID() {
        return spediteurID;
    }

    public void setSpediteurID(Integer id) {
        this.spediteurID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getZul_Gewicht() {
        return zul_Gewicht;
    }

    public void setZul_Gewicht(Double Zul_Gewicht) {
        this.zul_Gewicht = Zul_Gewicht;
    }

    public String getLiefertreue() {
        return liefertreue;
    }

    public void setLiefertreue(String liefertreue) { this.liefertreue = liefertreue; }

    public String getHandelsregisterNr() {
        return handelsregisterNr;
    }

    public void setHandelsregisterNr(String handelsregisterNr) {
        this.handelsregisterNr = handelsregisterNr;
    }

    public String getAnsprechpartner() {
        return ansprechpartner;
    }

    public void setAnsprechpartner(String ansprechpartner) {
        this.ansprechpartner = ansprechpartner;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer Tel) {  this.tel = tel; }

    public Vertrag getVertrag() { return vertrag; }

    public void setVertrag(Vertrag vertrag) { this.vertrag = vertrag;  }

}
