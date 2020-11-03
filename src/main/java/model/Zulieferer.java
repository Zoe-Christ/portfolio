package model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Zulieferer")
public class Zulieferer implements Serializable {

    @Id
    @Column(name = "ZuliefererID", nullable = false)
    protected Integer ZuliefererID;

    @Column(name = "Name", nullable = false)
    protected String Name;

    @Column(name = "Zul_Gewicht", nullable = false)
    protected Long Zul_Gewicht;

    @Column(name = "Liefertreue", nullable = false)
    protected String Liefertreue;

    @Column(name = "HandelsregisterNr", nullable = false)
    protected Integer HandelsregisterNr;

    @Column(name = "Ansprechpartner", nullable = false)
    protected String Ansprechpartner;

    @Column(name = "LieferRabatt", nullable = false)
    protected String LieferRabatt;

    @ManyToOne
    @JoinColumn(name = "fahrzeug_Fahrzeug_ID", nullable = false)
    protected model.Fahrzeug Fahrzeug;

    @ManyToOne
    @JoinColumn(name = "vertrag_Vertrag_ID", nullable = false)
    protected vertrag V;

    @OneToMany(mappedBy = "zulieferer")
    private Set<Bestellung> B;

    @OneToMany(mappedBy = "zulieferer")
    private Set<Teil> T;

    public Integer getZuliefererID() {
        return ZuliefererID;
    }

    public void setZuliefererID(Integer zuliefererID) {
        ZuliefererID = zuliefererID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getZul_Gewicht() {
        return Zul_Gewicht;
    }

    public void setZul_Gewicht(Long zul_Gewicht) {
        Zul_Gewicht = zul_Gewicht;
    }

    public String getLiefertreue() {
        return Liefertreue;
    }

    public void setLiefertreue(String liefertreue) {
        Liefertreue = liefertreue;
    }

    public Integer getHandelsregisterNr() {
        return HandelsregisterNr;
    }

    public void setHandelsregisterNr(Integer handelsregisterNr) {
        HandelsregisterNr = handelsregisterNr;
    }

    public String getAnsprechpartner() {
        return Ansprechpartner;
    }

    public void setAnsprechpartner(String ansprechpartner) {
        Ansprechpartner = ansprechpartner;
    }

    public String getLieferRabatt() {
        return LieferRabatt;
    }

    public void setLieferRabatt(String lieferRabatt) {
        LieferRabatt = lieferRabatt;
    }

    public model.Fahrzeug getFahrzeug() {
        return Fahrzeug;
    }

    public void setFahrzeug(model.Fahrzeug fahrzeug) {
        Fahrzeug = fahrzeug;
    }

    public vertrag getV() {
        return V;
    }

    public void setV(vertrag v) {
        V = v;
    }

    public Set<Bestellung> getB() {
        return B;
    }

    public void setB(Set<Bestellung> b) {
        B = b;
    }

    public Set<Teil> getT() {
        return T;
    }

    public void setT(Set<Teil> t) {
        T = t;
    }

}
