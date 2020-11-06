import connection.ConnectionHelper;

import java.sql.*;

public class Demo {


/**
    private static String LOGIN = "root";
    private static String PASSWORD = "root";
    private static String URL = "jdbc:mysql://localhost:3306/portfolio";
    private static String TIMEZONEPROPERTY = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public Demo() throws IllegalAccessException {
    }**/

    public static void main( String[] args ) throws IllegalAccessException, SQLException {
        ConnectionHelper c = new ConnectionHelper();
        Connection con = c.getConnection("portfolio");
        Statement stmt;

        /*Inner Join: zeigt Name des Lieferdienst mit dazugehöriger Vertragslaufzeit*/
        stmt = con.createStatement();
        try ( ResultSet rs = stmt.executeQuery( "SELECT Lieferdienst.Name, Lieferdienst.vertrag_Vertrag_ID, Vertrag.Vertrag_ID, Vertrag.Laufzeit from portfolio.Lieferdienst \n" +
                "inner Join portfolio.Vertrag where Lieferdienst.vertrag_Vertrag_ID = Vertrag.Vertrag_ID" ) ) {
                        while ( rs.next() ) {
                            System.out.printf(rs.getString( 1 ), rs.getInt( 2 ),rs.getInt(3), rs.getString(4) );
                        }

        } catch ( SQLException e ) {
            System.err.println( "Error during Demo!" );
            e.printStackTrace();
        }
        stmt.close();

        /*Sortiert die Filialen nach Umsatz*/
        stmt = con.createStatement();
        try ( ResultSet rs = stmt.executeQuery( "SELECT * from portfolio.Filiale order by Umsatz DESC" ) ) {
            while ( rs.next() ) {
                System.out.printf(rs.getString( 1 ), rs.getString( 2 ),rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
            }

        } catch ( SQLException e ) {
            System.err.println( "Error during Demo!" );
            e.printStackTrace();
        }
        stmt.close();

        /*Gruppiert die Zahlungen nach Zahlungsart und Anzahl.*/
        stmt = con.createStatement();
        try ( ResultSet rs = stmt.executeQuery( "SELECT COUNT(RechnungsNr), Zahlungsart from portfolio.Zahlung Group by Zahlungsart" ) ) {
            while ( rs.next() ) {
                System.out.printf(rs.getString( 2 ), rs.getInt( 1 ));
            }

        } catch ( SQLException e ) {
            System.err.println( "Error during Demo!" );
            e.printStackTrace();
        }
        stmt.close();
    }

}
