import connection.ConnectionHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.Scanner;


@DisplayName("Database connection tests")
public class ConnectionHelperTest {

    //Testet, ob eine Verbindung zur Datenbank hergestellt werden kann
    @Test
    @DisplayName("Test successfully establishing connection to DB")
    void testConnectionToDB() {

        // PLEASE INSERT YOUR LOGIN DATA HERE FIRST
        ConnectionHelper.setLOGIN("root");
        ConnectionHelper.setPASSWORD("root");

        Assertions.assertNotNull(ConnectionHelper.getConnection("portfolio"));

       /* FUNKTIONIERT NICHT AUFGRUND SCANNER-"FEATURE"

       if (ConnectionHelper.getLOGIN().equals("")||ConnectionHelper.getPASSWORD().equals("")){
            System.out.println("Datenbank-Login");
            Scanner sc = new Scanner(System.in);
            System.out.print("Benutzer: \t");
            ConnectionHelper.setLOGIN(sc.nextLine());

            System.out.print("Passwort: \t");
            ConnectionHelper.setPASSWORD(sc.nextLine());
            sc.close();
        }

        EntityManager em = (EntityManager) ConnectionHelper.getConnection("portfolio");
        Assertions.assertNotNull( em );
        em.close();
        */
    }
}
