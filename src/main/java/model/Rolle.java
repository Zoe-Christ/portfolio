package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rolle")
public class Rolle {

    @Id
    @Column(name = "Rollen_ID", nullable = false)
    private Integer rollen_id;

    @Column(name = "Bezeichnung", nullable = false)
    private String bezeichnung;

    @ManyToMany(mappedBy = "rolle")
    private Set<Mitarbeiter> mitarbeiter = new HashSet<>();

    public Integer getRollen_id() {
        return rollen_id;
    }

    public void setRollen_id(Integer rollen_id) {
        this.rollen_id = rollen_id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public Set<Mitarbeiter> getMitarbeiter() {
        return mitarbeiter;
    }

    public void setMitarbeiter(Set<Mitarbeiter> mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }
}
