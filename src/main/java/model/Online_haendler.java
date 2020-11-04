package model;


import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Online_haendler")
public class Online_haendler implements Serializable {
    @ManyToOne
    @JoinColumn(name = "vertrag_Vertrag_ID", nullable = false)
    protected Vertrag Vertrag;
    @Id
    @Column(name = "HaendlerID", nullable = false)
    private Integer haendlerID;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "HandelsregisterNr", nullable = false)
    private String handelsregisterNr;
    @Column(name = "AnsprechPartner", nullable = false)
    private String ansprechPartner;

    @OneToMany(mappedBy = "online_haendler")
    private Set<Kundenauftrag> K;

    @OneToMany(mappedBy="online_haendler")
    private Set<online_haendler_has_product> P;

    public Integer getHaendlerID() {
        return haendlerID;
    }

    public void setHaendlerID(Integer haendlerID) {
        this.haendlerID = haendlerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHandelsregisterNr() {
        return handelsregisterNr;
    }

    public void setHandelsregisterNr(String handelsregisterNr) {
        this.handelsregisterNr = handelsregisterNr;
    }

    public String getAnsprechPartner() {
        return ansprechPartner;
    }

    public void setAnsprechPartner(String ansprechPartner) {
        this.ansprechPartner = ansprechPartner;
    }

    public vertrag getVertrag() {
        return Vertrag;
    }

    public void setVertrag(vertrag vertrag) {
        Vertrag = vertrag;
    }

    public Set<Kundenauftrag> getK() {
        return K;
    }

    public void setK(Set<Kundenauftrag> k) {
        K = k;
    }

    public Set<online_haendler_has_product> getP() {
        return P;
    }

    public void setP(Set<online_haendler_has_product> p) {
        P = p;
    }





}
