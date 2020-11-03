package model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Plz")
public class Plz implements Serializable {
    @Id
    @Column(name = "PLZ", nullable = false)
    protected Integer PLZ;

    @Column(name = "Stadt")
    public String Stadt;


    public Plz() {
    }

    public Integer getPLZ() {
        return PLZ;
    }

    public void setPLZ(Integer PLZ) {
        this.PLZ = PLZ;
    }

    public String getStadt() {
        return Stadt;
    }

    public void setStadt(String stadt) {
        Stadt = stadt;
    }

    @OneToOne(mappedBy = "PLZ")
    private Plz plz;

    public Plz getPlz() {
        return plz;
    }

    public void setPlz(Plz plz) {
        this.plz = plz;
    }
}
