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
        //Vorbedingung
        // PLEASE INSERT YOUR LOGIN DATA HERE FIRST
        ConnectionHelper.setLOGIN("root");
        ConnectionHelper.setPASSWORD("root");

        //Assertion
        Assertions.assertNotNull(ConnectionHelper.getConnection("portfolio"));

        /*EntityManager em = (EntityManager) ConnectionHelper.getConnection("portfolio");
        Assertions.assertNotNull( em );
        em.close();*/
    }
}
