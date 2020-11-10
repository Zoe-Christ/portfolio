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
                System.out.println("Inner Join: zeigt Name des Lieferdienst mit dazugehöriger Vertragslaufzeit:");
                while (rs.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs.getString(i);
                        System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
                    }
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }catch(Exception e){
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
            }catch(Exception e){
                e.printStackTrace();
            }
                System.out.println(" ");
                try (PreparedStatement stmt3 = con.prepareStatement("SELECT * from portfolio.Filiale order by Umsatz DESC")) {

                    // Fetch a first ResultSet
                    try (ResultSet rs3 = stmt3.executeQuery()) {
                        ResultSetMetaData rsmd3 = (ResultSetMetaData) rs3.getMetaData();
                        int columnsNumber = rsmd3.getColumnCount();
                        System.out.println("Sortiert die Filialen nach Umsatz:");
                        while (rs3.next()) {
                            for (int i = 1; i <= columnsNumber; i++) {
                                if (i > 1) System.out.print(",  ");
                                String columnValue = rs3.getString(i);
                                System.out.print(rsmd3.getColumnName(i)+": "+ columnValue);
                            }
                            System.out.println("");
                        }
                    } catch (SQLException e) {
                        System.err.println("Error during Demo!");
                        e.printStackTrace();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
        System.out.println(" ");
        try (PreparedStatement stmt4 = con.prepareStatement("SELECT COUNT(RechnungsNr), Zahlungsart from portfolio.Zahlung Group by Zahlungsart")) {

            // Fetch a first ResultSet
            try (ResultSet rs4 = stmt4.executeQuery()) {
                ResultSetMetaData rsmd4 = (ResultSetMetaData) rs4.getMetaData();
                int columnsNumber = rsmd4.getColumnCount();
                System.out.println("Gruppiert die Zahlungen nach Zahlungsart und Anzahl:");
                while (rs4.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs4.getString(i);
                        System.out.print(rsmd4.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(" ");
        try (PreparedStatement stmt5 = con.prepareStatement("SELECT LagerID, Mietkosten from portfolio.Lager where Mietkosten < 9000")) {

            // Fetch a first ResultSet
            try (ResultSet rs5 = stmt5.executeQuery()) {
                ResultSetMetaData rsmd5 = (ResultSetMetaData) rs5.getMetaData();
                int columnsNumber = rsmd5.getColumnCount();
                System.out.println("Zeigt die ID und die Mietkosten aller Lager, deren Mietkosten kleiner als 9000 sind:");
                while (rs5.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs5.getString(i);
                        System.out.print(rsmd5.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println(" ");
        try (PreparedStatement stmt6 = con.prepareStatement("SELECT Name, ProduktNr from Produkt WHERE ProduktNr IN (SELECT Produkt_ProduktNr from kundenauftrag_has_produkt where stueckzahl > 1)")) {

            // Fetch a first ResultSet
            try (ResultSet rs6 = stmt6.executeQuery()) {
                ResultSetMetaData rsmd6 = (ResultSetMetaData) rs6.getMetaData();
                int columnsNumber = rsmd6.getColumnCount();
                System.out.println("Zeigt alle Produkte in einem Kundenauftrag, die häufiger als einmal bestellt wurden:");
                while (rs6.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs6.getString(i);
                        System.out.print(rsmd6.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

                //hier Abfragen Einfügen



                //das erst am Ende:
                con.close();

                // Without closing the statement, execute it again to fetch another ResultSet
                // try (ResultSet rs2 = stmt.executeQuery()) { ... }
            }


        }



