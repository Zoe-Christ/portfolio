package model;

import javax.persistence.*;

/**TODO:
 * Entity-Klasse für die Tabelle Bestellung_has_Teil
 */
@Entity
@Table(name = "Bestellung_has_Teil")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.bestellung",
                joinColumns = @JoinColumn(name = "bestellung_BestellungID")),
        @AssociationOverride(name = "primaryKey.teil",
                joinColumns = @JoinColumn(name = "teil_TeilID"))})
public class Bestellung_has_Teil {
    // composite-id key
    private Bestellung_has_TeilID primaryKey = new Bestellung_has_TeilID();

    // additional fields
    private Integer anzahl;

    @EmbeddedId
    public Bestellung_has_TeilID getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Bestellung_has_TeilID primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Transient
    public Bestellung getBestellung() {
        return getPrimaryKey().getBestellung();
    }

    public void setBestellung(Bestellung bestellung) {
        getPrimaryKey().setBestellung(bestellung);
    }

    @Transient
    public Teil getTeil() {
        return getPrimaryKey().getTeil();
    }

    public void setTeil(Teil teil) {
        getPrimaryKey().setTeil(teil);
    }

    @Column(name = "anzahl")
    public Integer getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(Integer anzahl) {
        this.anzahl = anzahl;
    }
}



