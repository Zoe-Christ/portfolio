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
        //ConnectionHelper c = new ConnectionHelper();
        Connection con = ConnectionHelper.getConnection("portfolio");
        Statement stmt;

        /*Inner Join: zeigt Name des Lieferdienst mit dazugehöriger Vertragslaufzeit*/
        stmt = con.createStatement();
        try ( ResultSet rs = stmt.executeQuery( "SELECT Lieferdienst.Name, Lieferdienst.vertrag_Vertrag_ID, Vertrag.Vertrag_ID, Vertrag.Laufzeit from portfolio.Lieferdienst \n" +
                "inner Join portfolio.Vertrag where Lieferdienst.vertrag_Vertrag_ID = Vertrag.Vertrag_ID" ) ) {
                        while ( rs.next() ) {
                            System.out.printf(""+rs.getString( 1 )+"\t", rs.getInt( 2 ),rs.getInt(3), rs.getString(4) );
                        }

        } catch ( SQLException e ) {
            System.err.println( "Error during Demo!" );
            e.printStackTrace();
        }
        stmt.close();

        /*Sortiert die Filialen nach Umsatz*/
        stmt = con.createStatement();
        try ( ResultSet rt = stmt.executeQuery( "SELECT * from portfolio.Filiale order by Umsatz DESC" ) ) {
            while ( rt.next() ) {
                System.out.printf(""+rt.getInt( 1 ), rt.getString( 2 ),rt.getInt(3), rt.getString(4), rt.getInt(5), rt.getInt(6));
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
                System.out.printf(""+rs.getString( 2 ), rs.getInt( 1 ));
            }

        } catch ( SQLException e ) {
            System.err.println( "Error during Demo!" );
            e.printStackTrace();
        }
        stmt.close();

        /*Sucht alle Händler, deren Namen mit 'Ama' beginnt.*/
        stmt = con.createStatement();
        try ( ResultSet rs = stmt.executeQuery( "SELECT * from portfolio.Online_haendler where Name LIKE 'Ama%'" ) ) {
            while ( rs.next() ) {
                System.out.printf(""+rs.getInt( 1 ), rs.getString( 2 ), rs.getString(3),rs.getString(4), rs.getInt(5));
            }

        } catch ( SQLException e ) {
            System.err.println( "Error during Demo!" );
            e.printStackTrace();
        }
        stmt.close();

        /*Zeigt die ID und die Mietkosten aller Lager, deren Mietkosten kleiner als 9000 sind.*/
        stmt = con.createStatement();
        try ( ResultSet rs = stmt.executeQuery( "SELECT LagerID, Mietkosten from portfolio.Lager where Mietkosten < 9000" ) ) {
            while ( rs.next() ) {
                System.out.printf(""+rs.getInt( 1 ), rs.getString( 2 ));
            }

        } catch ( SQLException e ) {
            System.err.println( "Error during Demo!" );
            e.printStackTrace();
        }
        stmt.close();

        /*Zeigt alle Produkte in einem Kundenauftrag, die häufiger als einmal bestellt wurden.*/
        /*
        stmt = con.createStatement();
        try ( ResultSet rs = stmt.executeQuery( "SELECT Name, ProduktNr from Produkt WHERE ProduktNr IN (SELECT Produkt_ProduktNr from Kundenauftrag where stueckzahl > 1)" ) ) {
            while ( rs.next() ) {
                System.out.printf(""+rs.getString( 1 ), rs.getInt( 2 ));
            }

        } catch ( SQLException e ) {
            System.err.println( "Error during Demo!" );
            e.printStackTrace();
        }
        stmt.close(); */

        /*Zeigt zugestellte Bestellungen mit Warenwert zwischen 400 und 1000 € sortiert nach absteigendem Warenwert.*/
        stmt = con.createStatement();
        try ( ResultSet rs = stmt.executeQuery( "Select Warenwert FROM Bestellung WHERE Bearbeitungsstatus = 'zugestellt' OR Warenwert BETWEEN 400 AND 1000 ORDER BY Warenwert DESC" ) ) {
            while ( rs.next() ) {
                System.out.printf(""+rs.getInt( 1 ));
            }

        } catch ( SQLException e ) {
            System.err.println( "Error during Demo!" );
            e.printStackTrace();
        }
        stmt.close();
    }

}
