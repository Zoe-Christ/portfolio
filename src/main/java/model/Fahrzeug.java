package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Fahrzeug")
public class Fahrzeug implements Serializable {

    @Column(name = "Bezeichnung")
    public String Bezeichnung;
    @Id
    @Column(name = "Fahrzeug_ID", nullable = false)
    private Integer FahrzeugId;

    public Integer getFahrzeugId() {
        return FahrzeugId;
    }

    public void setFahrzeugId(Integer fahrzeugId) {
        this.FahrzeugId = fahrzeugId;
    }

    public String getBezeichnung() {
        return Bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        Bezeichnung = bezeichnung;
    }
}
