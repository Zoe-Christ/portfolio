import connection.ConnectionHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class InsertTest {

    @Test
    void insert() {
        //Vorbedingungen
        // PLEASE INSERT YOUR LOGIN DATA HERE FIRST
        ConnectionHelper.setLOGIN("root");
        ConnectionHelper.setPASSWORD("root");
        Connection con = ConnectionHelper.getConnection("portfolio");
        Insert element = new Insert();
        Statement stmt = null;

        //Ausführung
        try {
            stmt = con.createStatement();
            element.insert("INSERT INTO rolle(Bezeichnung) VALUES ('Werkstudent')", stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Nachbedingung
        Queries qs = new Queries();
        ResultSetMetaData rs = null;

        //Ausführung
        try {
            rs  = qs.select(con.prepareStatement("SELECT Bezeichnung from portfolio.Rolle WHERE Bezeichnung = 'Werkstudent'"));

            //Assertion
            Assertions.assertEquals(1, rs.getColumnCount());
        } catch (SQLException e) {
            e.printStackTrace();
        }







    }
}