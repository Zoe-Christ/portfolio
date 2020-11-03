package model;

import org.hibernate.annotations.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Kunde")
public class Kunde implements Serializable {
    @Id
    @Column(name = "KundeID", nullable = false)
    protected Integer KundeID;
    @Column(name = "Vorname")
    public String Vorname;

    @Column(name = "Nachname")
    public String Nachname;

    @Column(name = "Mail")
    public String Mail;

    @Column(name = "Tel")
    public Integer Tel;


    public Kunde() {
    }


    public Integer getkundeID() {
        return KundeID;
    }

    public void setkundeID(Integer kundeID) {
        KundeID = kundeID;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public Integer getTel() {
        return Tel;
    }

    public void setTel(Integer tel) {
        Tel = tel;
    }
}

