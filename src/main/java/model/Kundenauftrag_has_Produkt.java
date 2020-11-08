package model;

import javax.persistence.*;

@Entity
@Table(name = "Kundenauftrag_has_Produkt")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.kundenauftrag",
                joinColumns = @JoinColumn(name = "kundenauftrag_AuftragID")),
        @AssociationOverride(name = "primaryKey.produkt",
                joinColumns = @JoinColumn(name = "produkt_ProduktNR"))})
public class Kundenauftrag_has_Produkt {
    // composite-id key
    private Kundenauftrag_has_ProduktID primaryKey = new Kundenauftrag_has_ProduktID();

    // additional fields
    private Integer stueckzahl;

    @EmbeddedId
    public Kundenauftrag_has_ProduktID getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Kundenauftrag_has_ProduktID primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Transient
    public Kundenauftrag getKundenauftrag() {
        return getPrimaryKey().getKundenauftrag();
    }

    public void setKundenauftrag(Kundenauftrag kundenauftrag) {
        getPrimaryKey().setKundenauftrag(kundenauftrag);
    }

    @Transient
    public Produkt getProdukt() {
        return getPrimaryKey().getProdukt();
    }

    public void setProdukt(Produkt produkt) {
        getPrimaryKey().setProdukt(produkt);
    }

    @Column(name = "stueckzahl")
    public Integer getStueckzahl() {
        return stueckzahl;
    }

    public void setStueckzahl(Integer stueckzahl) {
        this.stueckzahl = stueckzahl;
    }
}
