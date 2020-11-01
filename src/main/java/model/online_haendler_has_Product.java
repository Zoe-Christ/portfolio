package model;

import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "online_haendler_has_Product")
public class online_haendler_has_Product implements Serializable{

    @ManyToOne
    @JoinColumn(name = "online_haendler_HaendlerID", nullable = false)
    protected online_haendler Haendler;

    @ManyToOne
    @JoinColumn(name = "produkt_ProduktNr", nullable = false)
    protected produkt P;
}
