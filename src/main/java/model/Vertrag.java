package model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vertrag")
public class Vertrag {

    @Id
    @Column(name = "Vertrag_ID", nullable = false)
    private Integer vertrag_id;

    @Column(name = "Laufzeit", nullable = false)
    private String laufzeit;

    @OneToMany(mappedBy = "vertrag")
    private Set<Online_haendler> online_haendler;

    @OneToMany(mappedBy = "vertrag")
    private Set<Lieferdienst> lieferdienst;

    @OneToMany(mappedBy = "vertrag")
    private Set<Spediteur> spediteur;

    @OneToMany(mappedBy = "vertrag")
    private Set<Zulieferer> zulieferer;

    public Integer getVertrag_id() { return vertrag_id; }

    public void setVertrag_id(Integer vertrag_id) { this.vertrag_id = vertrag_id; }

    public String getLaufzeit() { return laufzeit; }

    public void setLaufzeit(String laufzeit) { this.laufzeit = laufzeit; }
}
