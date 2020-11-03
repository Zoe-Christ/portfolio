package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Spediteur")
public class Spediteur implements Serializable {
    private Integer Spediteur_ID;

    @Id
    @Column(name = "ID")
    public Integer getSpediteur_ID() {
        return Spediteur_ID;
    }

    public void setSpediteur_ID(Integer id) {
        this.Spediteur_ID = id;
    }
}
