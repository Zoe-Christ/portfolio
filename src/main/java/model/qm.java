package model;

import org.hibernate.annotations.Entity;

import javax.persistence.Id;

@Entity
public class qm {
    private Integer QMID;

    public void setQMID(Integer qmid) {
        this.QMID = qmid;
    }

    @Id
    public Integer getQMID() {
        return QMID;
    }
}
