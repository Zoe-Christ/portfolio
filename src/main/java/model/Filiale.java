package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "filiale")
public class Filiale implements Serializable {
    @Id
    @Column(name = "FilialeID")
    private Integer filialeID;

    public Integer getFilialeID() {
        return filialeID;
    }

    public void setFilialeID(Integer filialeID) {
        this.filialeID = filialeID;
    }

    @OneToOne
    @JoinColumn(name = "adresse_AdressID", nullable = false)
    protected Adresse Adresse;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Filiale_has_Produkt",
            joinColumns = {@JoinColumn(name = "FilialeID")},
            inverseJoinColumns = {@JoinColumn(name = "produkt_ProduktNr")}
    )
    Set<Produkt> produkt = new HashSet<>();

    public Filiale() {
    }
}
