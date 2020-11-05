package model;

import javax.persistence.*;
import java.io.Serializable;

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

    @OneToOne(mappedBy = "Adresse")
    private Adresse adresse;

    public Filiale() {
    }
}
