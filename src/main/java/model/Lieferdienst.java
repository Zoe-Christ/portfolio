package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
