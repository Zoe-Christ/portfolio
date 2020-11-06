package model;


import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "Lieferdienst")
public class Lieferdienst implements Serializable {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Lieferzeit")
    private Timestamp lieferzeit;

    @Column(name = "Status")
    private String status;

    @Column(name = "Name")
    private String name;

    @Column(name = "Zul_Gewicht")
    private Double gewicht;

    @Column(name = "Kapazitaet")
    private String kapazitaet;

    @OneToMany(mappedBy = "Lieferdienst")
    private Set<Kundenauftrag> KA;

    @OneToMany(mappedBy = "Lieferdienst")
    private Set<Kunde> K;

    @OneToMany(mappedBy = "Lieferdienst")
    private Set<Produkt> P;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getLieferzeit() {
        return lieferzeit;
    }

    public void setLieferzeit(Timestamp lieferzeit) {
        this.lieferzeit = lieferzeit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGewicht() {
        return gewicht;
    }

    public void setGewicht(Double gewicht) {
        this.gewicht = gewicht;
    }

    public String getKapazitaet() {
        return kapazitaet;
    }

    public void setKapazitaet(String kapazitaet) {
        this.kapazitaet = kapazitaet;
    }
}
