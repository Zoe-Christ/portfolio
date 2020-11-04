package model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Kunde")
public class Kunde implements Serializable {
    @Column(name = "Vorname")
    public String vorname;
    @Column(name = "Nachname")
    public String nachname;
    @Column(name = "Mail")
    public String mail;
    @Column(name = "Tel")
    public Integer tel;
    @Id
    @Column(name = "KundeID", nullable = false)
    protected Integer kundeID;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Kunde_has_Adresse",
            joinColumns = {@JoinColumn(name = "KundeID")},
            inverseJoinColumns = {@JoinColumn(name = "AdressID")}
    )
    Set<Adresse> projects = new HashSet<>();

    public Kunde() {
    }

    public Integer getkundeID() {
        return kundeID;
    }

    public void setkundeID(Integer kundeID) {
        this.kundeID = kundeID;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }
}

