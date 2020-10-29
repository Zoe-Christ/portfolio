import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Table(appliesTo = "Adresse")
public class Adresse implements Serializable {
    @Id
    @Column(name ="AdressID", nullable = false)
    protected Integer AdressID;
    @Column(name="Strasse")
    public String Strasse;

    @Column(name = "Hausnummer")
    public String Hausnummer;

    @Column(name = "PLZ")
    public Integer PLZ;

    @Column(name = "Stadt")
    public String Stadt;

    public Adresse(){ }


    public Integer getAdressID() {
        return AdressID;
    }

    public void setAdressID(Integer adressID) {
        AdressID = adressID;
    }

    public String getStrasse() {
        return Strasse;
    }

    public void setStrasse(String strasse) {
        Strasse = strasse;
    }

    public String getHausnummer() {
        return Hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        Hausnummer = hausnummer;
    }

    public Integer getPLZ() {
        return PLZ;
    }

    public void setPLZ(Integer PLZ) {
        this.PLZ = PLZ;
    }

    public String getStadt() {
        return Stadt;
    }

    public void setStadt(String stadt) {
        Stadt = stadt;
    }
}
