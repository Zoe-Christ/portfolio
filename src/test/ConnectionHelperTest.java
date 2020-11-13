import connection.ConnectionHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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



       //FUNKTIONIERT NICHT

       /*if (ConnectionHelper.getLOGIN().equals("")||ConnectionHelper.getPASSWORD().equals("")){
            System.out.println("Datenbank-Login");
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
           // Scanner sc = new Scanner(System.in);
            System.out.print("Benutzer: \t");
            try {
                ConnectionHelper.setLOGIN(buff.readLine());
            } catch (IOException e){
                e.printStackTrace();
            }

            System.out.print("Passwort: \t");
           try {
               ConnectionHelper.setPASSWORD(buff.readLine());
           } catch (IOException e){
               e.printStackTrace();
           }
        }*/

        Assertions.assertNotNull(ConnectionHelper.getConnection("portfolio"));

        /*EntityManager em = (EntityManager) ConnectionHelper.getConnection("portfolio");
        Assertions.assertNotNull( em );
        em.close();*/

    }
}
