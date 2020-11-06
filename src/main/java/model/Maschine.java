package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Maschine")
public class Maschine implements Serializable {
    @Id
    @Column(name = "MaschineID", nullable = false)
    private Integer maschineID;
}
