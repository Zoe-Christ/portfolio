package model;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
@Table(appliesTo = "abteilung")
public class Abteilung implements Serializable {
        @Id
        @Column(name ="Kuerzel", nullable = false)
        protected Integer Kuerzel;

        @Column(name = "Name", nullable = false)
        public String Name;

        @Column(name = "Zustaendigkeit")
        public String Zustaendigkeit;

        @Column(name = "AnzahlMA")
        public Integer AnzahlMA;

        @Column(name = "Kostenstelle")
        public Integer Kostenstelle;

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
