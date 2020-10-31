package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "produktion")
public class Produktion implements Serializable{

    @Id
    @Column(name = "ProduktionID", nullable = false)
    protected Integer ProduktionID;

    @Column(name = "Anz-Produktionsplaetze", nullable = false)
    protected Integer Anz\-Produktionsplaetze;

    @Column(name = "Kapazitaet", nullable = false)
    protected Long Kapazitaet;

    @Column(name = "Zeit", nullable = false)
    protected Date Zeit;

    @Column(name = "Prod_Kosten", nullable = false)
    protected Long Prod_Kosten;

    



}
