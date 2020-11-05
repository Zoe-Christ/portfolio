package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Spediteur")
public class Spediteur implements Serializable {

    @Id
    @Column(name = "SpediteurID", nullable = false)
    private Integer spediteurID;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Zul_Gewicht", nullable = false)
    private double zul_Gewicht;

    @Column(name = "Liefertreue", nullable = false)
    private String liefertreue;

    @Column(name = "HandelsregisterNr", nullable = false)
    private String handelsregisterNr;

    @Column(name = "Ansprechpartner", nullable = false)
    private String ansprechpartner;

    @Column(name = "Name", nullable = false)
    private Integer tel;

    @ManyToOne()
    @JoinColumn(name = "vertrag_Vertrag_ID", nullable = false)
    protected Vertrag vertrag;

    @OneToMany(mappedBy = "spediteur")
    private Set<Lieferung> lieferung;

    public Integer getSpediteurID() {
        return spediteurID;
    }

    public void setSpediteurID(Integer spediteurID) {
        this.spediteurID = spediteurID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getZul_Gewicht() {
        return zul_Gewicht;
    }

    public void setZul_Gewicht(double zul_Gewicht) {
        this.zul_Gewicht = zul_Gewicht;
    }

    public String getLiefertreue() {
        return liefertreue;
    }

    public void setLiefertreue(String liefertreue) {
        this.liefertreue = liefertreue;
    }

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

    public void setTel(Integer tel) {
        this.tel = tel;
    }
}
