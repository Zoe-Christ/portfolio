package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Fahrzeug")
public class Fahrzeug implements Serializable {
    @Id
    @Column(name = "Fahrzeug_ID", nullable = false)
    private Integer fahrzeugId;
    @Column(name = "Bezeichnung", nullable = false)
    private String bezeichnung;


    public Integer getFahrzeugId() {
        return fahrzeugId;
    }

    public void setFahrzeugId(Integer fahrzeugId) {
        this.fahrzeugId = fahrzeugId;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
}
