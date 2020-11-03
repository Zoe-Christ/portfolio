package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Einkauf")
public class Einkauf implements Serializable {

    private Integer einkaufID;

    @Id
    @Column(name = "EinkaufID", nullable = false)
    public Integer getEinkaufID() {
        return einkaufID;
    }

    public void setEinkaufID(Integer einkaufID) {
        this.einkaufID = einkaufID;
    }
}
