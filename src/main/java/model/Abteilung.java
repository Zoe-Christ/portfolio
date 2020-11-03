package model;


import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Abteilung")
public class Abteilung implements Serializable {
    @Column(name = "Name", nullable = false)
    public String Name;
    @Column(name = "Zustaendigkeit")
    public String Zustaendigkeit;
    @Column(name = "AnzahlMA")
    public Integer AnzahlMA;
    @Column(name = "Kostenstelle")
    public Integer Kostenstelle;
    @Id
    @Column(name = "Kuerzel", nullable = false)
    protected Integer Kuerzel;
    @OneToMany(mappedBy = "abteilung")
    private Set mitarbeiter;


    public Integer getKuerzel() {
        return Kuerzel;
    }

    public void setKuerzel(Integer kuerzel) {
        Kuerzel = kuerzel;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getZustaendigkeit() {
        return Zustaendigkeit;
    }

    public void setZustaendigkeit(String zustaendigkeit) {
        Zustaendigkeit = zustaendigkeit;
    }

    public Integer getAnzahlMA() {
        return AnzahlMA;
    }

    public void setAnzahlMA(Integer anzahlMA) {
        AnzahlMA = anzahlMA;
    }

    public Integer getKostenstelle() {
        return Kostenstelle;
    }

    public void setKostenstelle(Integer kostenstelle) {
        Kostenstelle = kostenstelle;
    }
}
