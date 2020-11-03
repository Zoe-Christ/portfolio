package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
}
