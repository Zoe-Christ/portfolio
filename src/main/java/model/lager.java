package model;

import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Lager")
public class lager implements Serializable{

    @Id
    @Column(name = "LagerID", nullable = false)
    protected Integer LagerID;

    @Column(name = "Mietkosten", nullable = false)
    protected String Mietkosten;

    @Column(name = "Flaeche", nullable = false)
    protected String Flaeche;

    @Column(name = "Lagerart", nullable = false)
    protected String Lagerart;

    @ManyToOne
    @JoinColumn(name = "adresse_AdressID", nullable = false)
    protected Adresse Adresse;

    @OneToMany(mappedBy="lager")
    private Set Teil;

    @OneToMany(mappedBy="lager")
    private Set P;

    @OneToMany(mappedBy = "lager")
    private Set Lieferung;

    public Set<teil> getT() {
        return T;
    }

    public void setT(Set<teil> t) {
        T = t;
    }

    public Set getP() {
        return P;
    }

    public void setP(Set p) {
        P = p;
    }

    public Set<lieferung> getL() {
        return L;
    }

    public void setL(Set<lieferung> l) {
        L = l;
    }

    public Integer getLagerID() {
        return LagerID;
    }

    public void setLagerID(Integer lagerID) {
        LagerID = lagerID;
    }

    public String getMietkosten() {
        return Mietkosten;
    }

    public void setMietkosten(String mietkosten) {
        Mietkosten = mietkosten;
    }

    public String getFlaeche() {
        return Flaeche;
    }

    public void setFlaeche(String flaeche) {
        Flaeche = flaeche;
    }

    public String getLagerart() {
        return Lagerart;
    }

    public void setLagerart(String lagerart) {
        Lagerart = lagerart;
    }

    public Adresse getAdresse() {
        return Adresse;
    }

    public void setAdresse(Adresse Adresse) {
        Adresse = Adresse;
    }


}
