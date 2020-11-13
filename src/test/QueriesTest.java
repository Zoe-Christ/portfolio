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

        // PLEASE INSERT YOUR LOGIN DATA HERE FIRST
        ConnectionHelper.setLOGIN("root");
        ConnectionHelper.setPASSWORD("root");
        Connection con = ConnectionHelper.getConnection("portfolio");

        Queries qs = new Queries();
        try {
            ResultSetMetaData rs = qs.select(con.prepareStatement("SELECT * from portfolio.Fahrzeug"));
            Assertions.assertNotNull(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}