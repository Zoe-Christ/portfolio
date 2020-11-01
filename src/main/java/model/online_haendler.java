package model;


import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "online_haendler")
public class online_haendler implements Serializable{
    @Id
    @Column(name = "HaendlerID", nullable = false)
    protected Integer HaendlerID;

    @Column(name = "Name", nullable = false)
    protected String Name;

    @Column(name = "HandelsregisterNr", nullable = false)
    protected String HandelsregisterNr;

    @Column(name = "AnsprechPartner", nullable = false)
    protected String AnsprechPartner;

    @ManyToOne
    @JoinColumn(name = "vertrag_Vertrag_ID", nullable = false)
    protected vertrag Vertrag;

    @OneToMany(mappedBy="online_haendler")
    private Set<kundenauftrag> K;

    @OneToMany(mappedBy="online_haendler")
    private Set<online_haendler_has_product> P;

    public Integer getHaendlerID() {
        return HaendlerID;
    }

    public void setHaendlerID(Integer haendlerID) {
        HaendlerID = haendlerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getHandelsregisterNr() {
        return HandelsregisterNr;
    }

    public void setHandelsregisterNr(String handelsregisterNr) {
        HandelsregisterNr = handelsregisterNr;
    }

    public String getAnsprechPartner() {
        return AnsprechPartner;
    }

    public void setAnsprechPartner(String ansprechPartner) {
        AnsprechPartner = ansprechPartner;
    }

    public vertrag getVertrag() {
        return Vertrag;
    }

    public void setVertrag(vertrag vertrag) {
        Vertrag = vertrag;
    }

    public Set<kundenauftrag> getK() {
        return K;
    }

    public void setK(Set<kundenauftrag> k) {
        K = k;
    }

    public Set<online_haendler_has_product> getP() {
        return P;
    }

    public void setP(Set<online_haendler_has_product> p) {
        P = p;
    }





}
