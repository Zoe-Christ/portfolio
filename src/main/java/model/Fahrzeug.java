package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Fahrzeug")
public class Fahrzeug implements Serializable {
    @Id
    @Column(name = "Fahrzeug_ID", nullable = false)
    private Integer fahrzeugId;

    @Column(name = "Bezeichnung", nullable = false)
    private String bezeichnung;

    @OneToMany(mappedBy = "fahrzeug")
    private Set<Lieferdienst> lieferdienst;

    @OneToMany(mappedBy = "fahrzeug")
    private Set<Lieferung> lieferung;

    @OneToMany(mappedBy = "fahrzeug")
    private Set<Zulieferer> zulieferer;

    public Fahrzeug() {
    }

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
