package model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "Lager")
public class Lager implements Serializable {

    @Id
    @Column(name = "LagerID", nullable = false)
    private Integer lagerID;

    @Column(name = "Mietkosten", nullable = false)
    private String mietkosten;

    @Column(name = "Flaeche", nullable = false)
    private String flaeche;

    @Column(name = "Lagerart", nullable = false)
    private String lagerart;

    @OneToOne
    @JoinColumn(name = "adresse_AdressID", nullable = false)
    protected Adresse Adresse;

    @OneToMany(mappedBy = "Lager")
    private Set<Teil> teil;

    @OneToMany(mappedBy = "Lager")
    private Set<Produktion> produktion;

    @OneToMany(mappedBy = "Lager")
    private Set<Lieferung> lieferung;
    

    public String getMietkosten() {
        return mietkosten;
    }

    public void setMietkosten(String mietkosten) {
        this.mietkosten = mietkosten;
    }

    public String getFlaeche() {
        return flaeche;
    }

    public void setFlaeche(String flaeche) {
        this.flaeche = flaeche;
    }

    public String getLagerart() {
        return lagerart;
    }

    public void setLagerart(String lagerart) {
        this.lagerart = lagerart;
    }

    public Adresse getAdresse() {
        return Adresse;
    }

    public void setAdresse(Adresse Adresse) {
        Adresse = Adresse;
    }

}
