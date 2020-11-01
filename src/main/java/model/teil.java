package model;

import org.hibernate.annotations.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class teil implements Serializable {
    private Integer teilID;

    public void setTeilID(Integer teilID) {
        this.teilID = teilID;
    }

    @Id
    @Column(name = "teilID")
    public Integer getTeilID() {
        return teilID;
    }
    @Column(name="Name")
    public String Name;

    @Column(name="Funktion")
    public String Funktion;

    @Column(name="Material")
    public String Material;

    @Column(name="Preis")
    public Double Preis;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFunktion() {
        return Funktion;
    }

    public void setFunktion(String funktion) {
        Funktion = funktion;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String material) {
        Material = material;
    }

    public Double getPreis() {
        return Preis;
    }

    public void setPreis(Double preis) {
        Preis = preis;
    }
}
