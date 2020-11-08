package model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class Kundenauftrag_has_ProduktID implements Serializable {
    private Kundenauftrag kundenauftrag;
    private Produkt produkt;

    @ManyToOne(cascade = CascadeType.ALL)
    public Kundenauftrag getKundenauftrag() {
        return kundenauftrag;
    }

    public void setKundenauftrag(Kundenauftrag kundenauftrag) {
        this.kundenauftrag = kundenauftrag;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Produkt getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }
}

