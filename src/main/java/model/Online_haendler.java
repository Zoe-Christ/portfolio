package model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**TODO:
 * Entity-Klasse für die Tabelle Online_haendler
 */
@Entity
@Table(name = "Online_haendler")
public class Online_haendler implements Serializable {

    @Id
    @Column(name = "HaendlerID", nullable = false)
    private Integer haendlerID;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "HandelsregisterNr", nullable = false)
    private String handelsregisterNr;
    @Column(name = "AnsprechPartner", nullable = false)
    private String ansprechPartner;

    @ManyToOne
    @JoinColumn(name = "vertrag_Vertrag_ID", nullable = false)
    protected Vertrag Vertrag;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "online_haendler_has_produkt",
            joinColumns = {@JoinColumn(name = "online_Haendler_HaendlerID", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "produkt_ProduktNr")}
    )
    protected Set<Produkt> produkt = new HashSet<>();

    @OneToMany(mappedBy = "online_haendler")
    private Set<Kundenauftrag> kundenauftrag;

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

    public Set<Kundenauftrag> getKundenauftrag() {
        return kundenauftrag;
    }

    public void setKundenauftrag(Set<Kundenauftrag> kundenauftrags) {
        this.kundenauftrag = kundenauftrags;
    }


    public Set<Produkt> getProdukt() {
        return produkt;
    }

    public void setProdukt(Set<Produkt> produkt) {
        this.produkt = produkt;
    }

    public model.Vertrag getVertrag() {
        return Vertrag;
    }

    public void setVertrag(model.Vertrag vertrag) {
        Vertrag = vertrag;
    }

}
