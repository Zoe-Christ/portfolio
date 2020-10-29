import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
@Table(appliesTo = "Adresse")
public class Abteilung implements Serializable {
        @Id
        @Column(name ="Kuerzel", nullable = false)
        protected Integer Kuerzel;

        @Column(name = "Name")
        public String Name;
}
