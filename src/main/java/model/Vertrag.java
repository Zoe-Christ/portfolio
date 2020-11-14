package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**TODO:
 * Entity-Klasse für die Tabelle Vertrag
 */
@Entity
@Table(name = "vertrag")
public class Vertrag implements Serializable {

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

    public Set<Online_haendler> getOnline_haendler() {
        return online_haendler;
    }

    public void setOnline_haendler(Set<Online_haendler> online_haendler) {
        this.online_haendler = online_haendler;
    }

    public Set<Lieferdienst> getLieferdienst() {
        return lieferdienst;
    }

    public void setLieferdienst(Set<Lieferdienst> lieferdienst) {
        this.lieferdienst = lieferdienst;
    }

    public Set<Spediteur> getSpediteur() {
        return spediteur;
    }

    public void setSpediteur(Set<Spediteur> spediteur) {
        this.spediteur = spediteur;
    }

    public Set<Zulieferer> getZulieferer() {
        return zulieferer;
    }

    public void setZulieferer(Set<Zulieferer> zulieferer) {
        this.zulieferer = zulieferer;
    }
}
