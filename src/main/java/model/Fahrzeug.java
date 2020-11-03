package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Fahrzeug")
public class Fahrzeug implements Serializable {
    private Integer fahrzeugId;

    @Id
    public Integer getFahrzeugId() {
        return fahrzeugId;
    }

    public void setFahrzeugId(Integer fahrzeugId) {
        this.fahrzeugId = fahrzeugId;
    }
}
