package model;

import org.hibernate.mapping.Set;

import javax.persistence.*;

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

    @Column(name = "produktion_ProduktionID")
    public Integer produktion_ProduktionID;

    @Column(name = "produktion_lager_LagerID")
    public Integer produktion_lager_LagerID;

    @OneToMany(mappedBy = "Maschine")
    private Set<Teil> T;

    @ManyToOne (mappedBy = "Maschine")
    private Set <Produktion> P;



    public Integer getMaschineID() {
        return MaschineID;
    }

    public void setMaschineID(Integer MaschineID) {
        this.MaschineID = MaschineID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        Name = Name;
    }

    public String getAufgabe() {
        return Aufgabe;
    }

    public void setAufgabe(String Aufgabe) {  Aufgabe = Aufgabe;    }

    public Date Wartung() {
        return Wartung;
    }

    public void setWartung(Date Wartung) {
        Wartung = Wartung;
    }

    public Double getWert() {
        return Wert;
    }

    public void setWert(Double Wert) {
        Wert = Wert;
    }

    public Integer getMax_Produktion() {
        return Max_Produktion;
    }

    public void setMax_Produktion(Integer Max_Produktion) {
        Max_Produktion = Max_Produktion;
    }

    public String getEinstellung() {
        return Einstellung;
    }

    public void setEinstellung(String Einstellung) {  Einstellung = Einstellung;    }

    public String getTUEV() {
        return TUEV;
    }

    public void setTUEV(String TUEV) {  TUEV = TUEV;    }

    public Double getGewicht() {  return Gewicht;    }

    public void setGewicht(Double Gewicht) {  Gewicht = Gewicht; }

    public Double getGewicht() {  return Gewicht;    }

    public void setGewicht(Double Gewicht) {  Gewicht = Gewicht; }

    public Set<Teil> getT() {
        return T;
    }

    public void setT(Set<Teil> t) { T = t;}

    public Set<Produktion> getP() {
        return P;
    }

    public void setP(Set<Produktion> p) { P = p;}

}
