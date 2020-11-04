package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Filiale")
public class Filiale implements Serializable {
    private Integer filialeID;

    @Id
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
