import com.mysql.cj.jdbc.result.ResultSetMetaData;
import connection.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo3 {
    public static void main(String[] args) throws IllegalAccessException, SQLException {
        //ConnectionHelper c = new ConnectionHelper();
        Connection con = ConnectionHelper.getConnection("portfolio");


        // Execute the statement
        try (PreparedStatement stmt = con.prepareStatement("SELECT Lieferdienst.Name, Lieferdienst.vertrag_Vertrag_ID, Vertrag.Vertrag_ID, Vertrag.Laufzeit from portfolio.Lieferdienst \n" +
                "inner Join portfolio.Vertrag where Lieferdienst.vertrag_Vertrag_ID = Vertrag.Vertrag_ID")) {

            // Fetch a first ResultSet
            try (ResultSet rs = stmt.executeQuery()) {
                ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                //System.out.println(""+columnsNumber);
                while (rs.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs.getString(i);
                        System.out.print(rsmd.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
            System.out.println(" ");
            try (PreparedStatement stmt2 = con.prepareStatement("SELECT * from portfolio.Online_haendler where Name LIKE 'Ama%'")) {

                // Fetch a first ResultSet
                try (ResultSet rs2 = stmt2.executeQuery()) {
                    ResultSetMetaData rsmd2 = (ResultSetMetaData) rs2.getMetaData();
                    int columnsNumber = rsmd2.getColumnCount();
                    System.out.println("Sucht alle Händler, deren Namen mit 'Ama' beginnt:");
                    while (rs2.next()) {
                        for (int i = 1; i <= columnsNumber; i++) {
                            if (i > 1) System.out.print(",  ");
                            String columnValue = rs2.getString(i);
                            System.out.print(rsmd2.getColumnName(i)+": "+ columnValue);
                        }
                        System.out.println("");
                    }
                } catch (SQLException e) {
                    System.err.println("Error during Demo!");
                    e.printStackTrace();
                }

                //hier Abfragen Einfügen



                //das erst am Ende:
                con.close();

                // Without closing the statement, execute it again to fetch another ResultSet
                // try (ResultSet rs2 = stmt.executeQuery()) { ... }
            }


        }

    }
}
