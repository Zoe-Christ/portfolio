package model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Abteilung")
public class Abteilung implements Serializable {
    @Id
    @Column(name = "Kuerzel", nullable = false)
    private Integer kuerzel;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "Zustaendigkeit")
    private String zustaendigkeit;
    @Column(name = "AnzahlMA")
    private Integer anzahlMA;
    @Column(name = "Kostenstelle")
    private Integer kostenstelle;


    @OneToMany(mappedBy = "Abteilung")
    @JoinColumn(name = "abteilung_Kuerzel1")
    private Set<Mitarbeiter> mitarbeiter;

    public Set getMitarbeiter() {
        return mitarbeiter;
    }

    public Integer getKuerzel() {
        return kuerzel;
    }

    public void setKuerzel(Integer kuerzel) {
        kuerzel = kuerzel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZustaendigkeit() {
        return zustaendigkeit;
    }

    public void setZustaendigkeit(String zustaendigkeit) {
        this.zustaendigkeit = zustaendigkeit;
    }

    public Integer getAnzahlMA() {
        return anzahlMA;
    }

    public void setAnzahlMA(Integer anzahlMA) {
        this.anzahlMA = anzahlMA;
    }

    public Integer getKostenstelle() {
        return kostenstelle;
    }

    public void setKostenstelle(Integer kostenstelle) {
        this.kostenstelle = kostenstelle;
    }
}
