package model;

import org.hibernate.annotations.Entity;

import javax.persistence.Id;

@Entity
public class teil {
    private Integer teilID;

    public void setTeilID(Integer teilID) {
        this.teilID = teilID;
    }

    @Id
    public Integer getTeilID() {
        return teilID;
    }
}
