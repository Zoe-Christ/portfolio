package model;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
import org.hibernate.type.DateType;
import org.hibernate.type.DoubleType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(appliesTo = "model.PLZ")
public class PLZ implements Serializable {
    @Id
    @Column(name ="PLZ", nullable = false)
    protected Integer PLZ;

    @Column(name="Stadt")
    public String Stadt;


    public PLZ(){ }


    public Integer getPLZ() {
        return this.PLZ;
    }

    public void setLieferungID(Integer PLZ) {
        this.PLZ = PLZ;
    }

    public Integer getStadt() {
        return this.Stadt;
    }

    public void setStadt(String stadt) {
        Stadt = stadt;
    }



}


