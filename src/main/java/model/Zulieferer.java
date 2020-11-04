package model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "zulieferer")
public class Zulieferer implements Serializable {

    @Id
    @Column(name = "ZuliefererID", nullable = false)
    private Integer zuliefererID;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Zul_Gewicht", nullable = false)
    private Long zul_Gewicht;

    @Column(name = "Liefertreue", nullable = false)
    private String liefertreue;

    @Column(name = "HandelsregisterNr", nullable = false)
    private Integer handelsregisterNr;

    @Column(name = "Ansprechpartner", nullable = false)
    private String ansprechpartner;

    @Column(name = "LieferRabatt")
    private String lieferRabatt;

    @ManyToOne
    @JoinColumn(name = "fahrzeug_Fahrzeug_ID", nullable = false)
    private Fahrzeug fahrzeug;

    @ManyToOne
    @JoinColumn(name = "vertrag_Vertrag_ID", nullable = false)
    private Vertrag vertrag;

    @OneToMany(mappedBy = "zulieferer")
    private Set<Bestellung> bestellung;

    @OneToMany(mappedBy = "zulieferer")
    private Set<Teil> teil;

    public Integer getZuliefererID() {
        return zuliefererID;
    }

    public void setZuliefererID(Integer zuliefererID) {
        this.zuliefererID = zuliefererID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getZul_Gewicht() {
        return zul_Gewicht;
    }

    public void setZul_Gewicht(Long zul_Gewicht) {
        this.zul_Gewicht = zul_Gewicht;
    }

    public String getLiefertreue() {
        return liefertreue;
    }

    public void setLiefertreue(String liefertreue) {
        this.liefertreue = liefertreue;
    }

    public Integer getHandelsregisterNr() {
        return handelsregisterNr;
    }

    public void setHandelsregisterNr(Integer handelsregisterNr) {
        this.handelsregisterNr = handelsregisterNr;
    }

    public String getAnsprechpartner() {
        return ansprechpartner;
    }

    public void setAnsprechpartner(String ansprechpartner) {
        this.ansprechpartner = ansprechpartner;
    }

    public String getLieferRabatt() {
        return lieferRabatt;
    }

    public void setLieferRabatt(String lieferRabatt) {
        this.lieferRabatt = lieferRabatt;
    }

    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(Fahrzeug fahrzeug) {
        fahrzeug = fahrzeug;
    }

    public Vertrag getVertrag() {
        return vertrag;
    }

    public void setVertrag(Vertrag vertrag) {
        this.vertrag = vertrag;
    }

    public Set<Bestellung> getBestellung() {
        return bestellung;
    }

    public void setBestellung(Set<Bestellung> bestellung) {
        this.bestellung = bestellung;
    }

    public Set<Teil> getTeil() {
        return teil;
    }

    public void setTeil(Set<Teil> teil) {
        this.teil = teil;
    }

}
