package model;


import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class Bestellung_has_TeilID implements Serializable {
    private Bestellung bestellung;
    private Teil teil;

    @ManyToOne(cascade = CascadeType.ALL)
    public Bestellung getBestellung() {
        return bestellung;
    }

    public void setBestellung(Bestellung bestellung) {
        this.bestellung = bestellung;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Teil getTeil() {
        return teil;
    }

    public void setTeil(Teil teil) {
        this.teil = teil;
    }
}

