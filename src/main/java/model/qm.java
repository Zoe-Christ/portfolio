package model;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(appliesTo = "qm")
public class qm {
    public void setQMID(Integer qmid) {
        this.QMID = qmid;
    }

    @Id
    @Column(name ="QMID", nullable = false)
    private Integer QMID;
    public Integer getQMID() {
        return QMID;
    }

    @Column(name= "Pruefwerkzeug")
    private String Pruefwerkzeuge;

    @Column(name= "Kontrolle")
    private String Kontrolle;

    @Column(name= "Norm")
    private String Norm;

    @Column(name= "Pruefbereich")
    private String Pruefbereich;

    public String getPruefwerkzeuge() {
        return Pruefwerkzeuge;
    }

    public void setPruefwerkzeuge(String pruefwerkzeuge) {
        Pruefwerkzeuge = pruefwerkzeuge;
    }

    public String getKontrolle() {
        return Kontrolle;
    }

    public void setKontrolle(String kontrolle) {
        Kontrolle = kontrolle;
    }

    public String getNorm() {
        return Norm;
    }

    public void setNorm(String norm) {
        Norm = norm;
    }

    public String getPruefbereich() {
        return Pruefbereich;
    }

    public void setPruefbereich(String pruefbereich) {
        Pruefbereich = pruefbereich;
    }
}
