import connection.ConnectionHelper;

import java.sql.*;

public class Demo2 {


    public static void main(String[] args) throws IllegalAccessException, SQLException {
        //ConnectionHelper c = new ConnectionHelper();
        Connection con = ConnectionHelper.getConnection("portfolio");


        // Execute the statement
        try (PreparedStatement stmt = con.prepareStatement("SELECT Lieferdienst.Name, Lieferdienst.vertrag_Vertrag_ID, Vertrag.Vertrag_ID, Vertrag.Laufzeit from portfolio.Lieferdienst \n" +
                "inner Join portfolio.Vertrag where Lieferdienst.vertrag_Vertrag_ID = Vertrag.Vertrag_ID")) {

            // Fetch a first ResultSet
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    System.out.printf("" + rs.getString(1) + "\t", rs.getInt(2), rs.getInt(3), rs.getString(4));

                }
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
System.out.println(" ");
            try (PreparedStatement stmt2 = con.prepareStatement("SELECT * from portfolio.Online_haendler where Name LIKE 'Ama%'")) {

                // Fetch a first ResultSet
                try (ResultSet rs2 = stmt2.executeQuery()) {
                    while (rs2.next()) {
                        System.out.printf(""+rs2.getInt( 1 ), rs2.getString( 2 ), rs2.getString(3),rs2.getString(4), rs2.getInt(5));

                    }
                } catch (SQLException e) {
                    System.err.println("Error during Demo!");
                    e.printStackTrace();
                }


                con.close();

                // Without closing the statement, execute it again to fetch another ResultSet
                // try (ResultSet rs2 = stmt.executeQuery()) { ... }
            }


        }

    }
}
