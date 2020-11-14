package model;



import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

/**TODO:
 * Entity-Klasse für die Tabelle Maschine
 */
@Entity
@Table(name = "Maschine")
public class Maschine implements Serializable {

    @Id
    @Column(name = "MaschineID", nullable = false)
    protected Integer MaschineID;

    @Column(name = "Name")
    public String Name;

    @Column(name = "Aufgabe")
    public String Aufgabe;

    @Column(name = "Wartung")
    public Date Wartung;

    @Column(name = "Wert")
    public Double Wert;

    @Column(name = "Max_Produktion")
    public Integer Max_Produktion;

    @Column(name = "Einstellung")
    public String Einstellung;

    @Column(name = "TUEV")
    public String TUEV;

    @Column(name = "Gewicht")
    public Double Gewicht;

    @Column(name = "Groesse")
    public Double Groesse;

    @OneToMany(mappedBy="cart")
    private Set<Teil> teil;

    @ManyToOne()
    @JoinColumn(name="produktion_ProduktionID", nullable=false)
    private Produktion produktion;

    public Integer getMaschineID() {
        return MaschineID;
    }

    public void setMaschineID(Integer maschineID) {
        MaschineID = maschineID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAufgabe() {
        return Aufgabe;
    }

    public void setAufgabe(String aufgabe) {
        Aufgabe = aufgabe;
    }

    public Date getWartung() {
        return Wartung;
    }

    public void setWartung(Date wartung) {
        Wartung = wartung;
    }

    public Double getWert() {
        return Wert;
    }

    public void setWert(Double wert) {
        Wert = wert;
    }

    public Integer getMax_Produktion() {
        return Max_Produktion;
    }

    public void setMax_Produktion(Integer max_Produktion) {
        Max_Produktion = max_Produktion;
    }

    public String getEinstellung() {
        return Einstellung;
    }

    public void setEinstellung(String einstellung) {
        Einstellung = einstellung;
    }

    public String getTUEV() {
        return TUEV;
    }

    public void setTUEV(String TUEV) {
        this.TUEV = TUEV;
    }

    public Double getGewicht() {
        return Gewicht;
    }

    public void setGewicht(Double gewicht) {
        Gewicht = gewicht;
    }

    public Double getGroesse() {
        return Groesse;
    }

    public void setGroesse(Double groesse) {
        Groesse = groesse;
    }

}
