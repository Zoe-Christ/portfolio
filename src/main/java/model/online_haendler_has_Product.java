package model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "online_haendler_has_Product")
public class online_haendler_has_Product implements Serializable{

    @ManyToOne
    @JoinColumn(name = "online_haendler_HaendlerID", nullable = false)
    protected online_haendler Haendler;

    @ManyToOne
    @JoinColumn(name = "produkt_ProduktNr", nullable = false)
    protected Produkt P;
}
