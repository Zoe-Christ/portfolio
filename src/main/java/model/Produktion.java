package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "produktion")
public class Produktion implements Serializable{

    @Id
    @Column(name = "ProduktionID", nullable = false)
    protected Integer ProduktionID;

    @Column(name = "Anz-Produktionsplaetze", nullable = false)
    protected Integer Anz-Produktionsplaetze;

    @Column(name = "Kapazitaet", nullable = false)
    protected Long Kapazitaet;

    @Column(name = "Zeit", nullable = false)
    protected Date Zeit;

    @Column(name = "Prod_Kosten", nullable = false)
    protected Long Prod_Kosten;

    @ManyToOne
    @JoinColumn(name = "lager_LagerID", nullable = false)
    protected lager Lager;

    @ManyToOne
    @JoinColumn(name = "qm_QMID1", nullable = false)
    protected qm QM;

    @ManyToOne
    @JoinColumn(name = "qm_abteilung_Kuerzel", nullable = false)
    protected qm QM;

    @OneToMany(mappedBy="Zeit")
    private Set<maschine> zeit;





    



}
