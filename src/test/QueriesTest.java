import connection.ConnectionHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class QueriesTest {

    @Test
    void select() {
        //Vorbedingung
        // PLEASE INSERT YOUR LOGIN DATA HERE FIRST
        ConnectionHelper.setLOGIN("root");
        ConnectionHelper.setPASSWORD("root");
        Connection con = ConnectionHelper.getConnection("portfolio");
        Queries qs = new Queries();
        ResultSetMetaData rs = null;

        //Ausführung
        try {
           rs  = qs.select(con.prepareStatement("SELECT * from portfolio.Fahrzeug"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Assertion
        Assertions.assertNotNull(rs);
    }
}