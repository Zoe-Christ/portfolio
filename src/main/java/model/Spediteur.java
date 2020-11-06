package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Spediteur")
public class Spediteur implements Serializable {
    private Integer Spediteur_ID;

    @Id
    @Column(name = "SpediteurID", nullable = false)
    protected Integer SpediteurID;

    @Column(name = "Name")
    protected String Name;

    @Column(name = "Zul_Gewicht")
    protected Double Zul_Gewicht;

    @Column(name = "Liefertreue")
    protected String Liefertreue;

    @Column(name = "HandelsregisterNr")
    protected String HandelsregisterNr;

    @Column(name = "Ansprechpartner")
    protected String Ansprechpartner;

    @Column(name = "Tel")
    protected Integer Tel;

    @ManyToOne
    @JoinColumn(name = "vertrag_Vertrag_ID", nullable = false)
    protected vertrag vertrag_Vertrag_ID;





    public Integer getSpediteur_ID() {
        return Spediteur_ID;
    }

    public void setSpediteur_ID(Integer id) {
        this.Spediteur_ID = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        Name = Name;
    }

    public Double getZul_Gewicht() {
        return Zul_Gewicht;
    }

    public void setZul_Gewicht(Double Zul_Gewicht) {
        Zul_Gewicht = Zul_Gewicht;
    }

    public String getLiefertreue() {
        return Liefertreue;
    }

    public void setLiefertreue(String Liefertreue) {
        Liefertreue = Liefertreue;
    }

    public String getHandelsregisterNr() {
        return HandelsregisterNr;
    }

    public void setHandelsregisterNr(String HandelsregisterNr) {
        HandelsregisterNr = HandelsregisterNr;
    }

    public String getAnsprechpartner() {
        return Ansprechpartner;
    }

    public void setAnsprechpartner(String Ansprechpartner) {
        Ansprechpartner = Ansprechpartner;
    }

    public Integer getTel() {
        return Tel;
    }

    public void setTel(Integer Tel) {  Tel = Tel; }

    public vertrag getVertrag_Vertrag_ID() { return vertrag; }

    public void setVertrag_Vertrag_ID(vertrag vertrag) { vertrag = vertrag;  }

}
