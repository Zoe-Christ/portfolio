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

        try (PreparedStatement stmt7 = con.prepareStatement("SELECT COUNT(ProduktNr) Produkt WHERE Bestand BETWEEN 0 AND 50")) {

            // Fetch a first ResultSet
            try (ResultSet rs7 = stmt7.executeQuery()) {
                ResultSetMetaData rsmd7 = (ResultSetMetaData) rs7.getMetaData();
                int columnsNumber = rsmd7.getColumnCount();
                System.out.println("Zeigt alle Produkte mit Bestand zwischen 0 und 50:");
                while (rs7.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs7.getString(i);
                        System.out.print(rsmd7.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
                e.printStackTrace();
        }


        try (PreparedStatement stmt8 = con.prepareStatement("SELECT Warenwert FROM Bestellung WHERE Bearbeitungsstatus = 'zugestellt' OR Warenwert BETWEEN 400 AND 1000 ORDER BY Warenwert DESC")) {

            // Fetch a first ResultSet
            try (ResultSet rs8 = stmt8.executeQuery()) {
                ResultSetMetaData rsmd8 = (ResultSetMetaData) rs8.getMetaData();
                int columnsNumber = rsmd8.getColumnCount();
                System.out.println("Zeigt zugestellte Bestellungen mit Warenwert zwischen 400 und 1000 Euro, sortiert nach absteigenden Werten:");
                while (rs8.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs8.getString(i);
                        System.out.print(rsmd8.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }


        try (PreparedStatement stmt9 = con.prepareStatement("SELECT (Pruefwerkzeug, abteilung_Kuerzel, Norm) FROM Abteilung ORDER BY AnzahlMA DESC")) {

            // Fetch a first ResultSet
            try (ResultSet rs9 = stmt9.executeQuery()) {
                ResultSetMetaData rsmd9 = (ResultSetMetaData) rs9.getMetaData();
                int columnsNumber = rsmd9.getColumnCount();
                System.out.println("Zeigt Prüfwerkzeug, Abteilungskürzel und Norm der täglichen Kontrolle an:");
                while (rs9.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs9.getString(i);
                        System.out.print(rsmd9.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }

        try (PreparedStatement stmt10 = con.prepareStatement("SELECT (p.ProduktNr, p.Produktionsdatum) FROM Produkt p INNER JOIN Maschine m WHERE m.maschineID = '1' ")) {

            // Fetch a first ResultSet
            try (ResultSet rs10 = stmt10.executeQuery()) {
                ResultSetMetaData rsmd10 = (ResultSetMetaData) rs10.getMetaData();
                int columnsNumber = rsmd10.getColumnCount();
                System.out.println("Zeigt Produktnummer und Produktionsdatum an, die von der Maschine 1 hergestellt werden:");
                while (rs10.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs10.getString(i);
                        System.out.print(rsmd10.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }

        try (PreparedStatement stmt11 = con.prepareStatement("SELECT SUM(AnzahlMA) FROM ABTEILUNG")) {

            // Fetch a first ResultSet
            try (ResultSet rs11 = stmt11.executeQuery()) {
                ResultSetMetaData rsmd11 = (ResultSetMetaData) rs11.getMetaData();
                int columnsNumber = rsmd11.getColumnCount();
                System.out.println("Summe der Anzahl Mitarbeiter im Unternehmen:");
                while (rs11.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs11.getString(i);
                        System.out.print(rsmd11.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }

        try (PreparedStatement stmt12 = con.prepareStatement("SELECT SUM(Kundenauftrag.Warenwert) FROM Kundenauftrag WHERE (Datum='2021-10-16' OR Datum = '2021-10-17")) {

            // Fetch a first ResultSet
            try (ResultSet rs12 = stmt12.executeQuery()) {
                ResultSetMetaData rsmd12 = (ResultSetMetaData) rs12.getMetaData();
                int columnsNumber = rsmd12.getColumnCount();
                System.out.println("Es wird die Summe der Warenwerte an bestimmten Zeitpunkten ermittelt (Punktelle Abfrage an besonderen Tagen, welche den Umsatz stark fördern (Black-Friday, usw.);");
                while (rs12.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs12.getString(i);
                        System.out.print(rsmd12.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }

        try (PreparedStatement stmt13 = con.prepareStatement("SELECT einkauf.Budget, einkauf.Saison FROM portfolio.einkauf HAVING (AVG(einkauf.Budget) > einkauf.Budget)")) {

            // Fetch a first ResultSet
            try (ResultSet rs13 = stmt13.executeQuery()) {
                ResultSetMetaData rsmd13 = (ResultSetMetaData) rs13.getMetaData();
                int columnsNumber = rsmd13.getColumnCount();
                System.out.println("Es werden die Budgets und dazugehörigen Saisons des Einkaufs angezeigt, welche weniger als das durchschnittliche Budget benötigt haben. (Quantitative Messung der Ausgaben):");
                while (rs13.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs13.getString(i);
                        System.out.print(rsmd13.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }

        try (PreparedStatement stmt14 = con.prepareStatement("SELECT SUM(Gehalt) FROM Mitarbeiter")) {

            // Fetch a first ResultSet
            try (ResultSet rs14 = stmt14.executeQuery()) {
                ResultSetMetaData rsmd14 = (ResultSetMetaData) rs14.getMetaData();
                int columnsNumber = rsmd14.getColumnCount();
                System.out.println("Es wird die Summe der Gehälter aller Mitarbeiter angezeigt. (Personalkosten):");
                while (rs14.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs14.getString(i);
                        System.out.print(rsmd14.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }

        try (PreparedStatement stmt15 = con.prepareStatement("SELECT COUNT(MitarbeiterID) FROM Mitarbeiter")) {

            // Fetch a first ResultSet
            try (ResultSet rs15 = stmt15.executeQuery()) {
                ResultSetMetaData rsmd15 = (ResultSetMetaData) rs7.getMetaData();
                int columnsNumber = rsmd15.getColumnCount();
                System.out.println("Es wird die gesamte Anzahl der Mitabeiter angezeigt, welche im Unternehmen arbeiten (Mitarbeiteranzahl):");
                while (rs15.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs15.getString(i);
                        System.out.print(rsmd15.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }

        try (PreparedStatement stmt16 = con.prepareStatement("SELECT FilialeID, filiale.Name FROM filiale HAVING (AVG(filiale.Umsatz)>filiale.Umsatz)")) {

            // Fetch a first ResultSet
            try (ResultSet rs16 = stmt16.executeQuery()) {
                ResultSetMetaData rsmd16 = (ResultSetMetaData) rs16.getMetaData();
                int columnsNumber = rsmd16.getColumnCount();
                System.out.println("Es werden die Filialen angezeigt, welche einen geringeren Umsatz verzeichnen als der durchschnittliche Umsatz aller Filialen. (Performance-Übersicht):");
                while (rs16.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs16.getString(i);
                        System.out.print(rsmd16.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }

        try (PreparedStatement stmt17 = con.prepareStatement("SELECT SUM(Umsatz) FROM Filiale")) {

            // Fetch a first ResultSet
            try (ResultSet rs17 = stmt17.executeQuery()) {
                ResultSetMetaData rsmd17 = (ResultSetMetaData) rs17.getMetaData();
                int columnsNumber = rsmd17.getColumnCount();
                System.out.println("Es wird der Gesamtumsatz des Unternehmens angezeigt. (KPI):");
                while (rs17.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs17.getString(i);
                        System.out.print(rsmd17.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }

        try (PreparedStatement stmt18 = con.prepareStatement("SELECT ID, Name FROM Lieferdienst WHERE Lieferzeit < AVG(Lieferzeit)")) {

            // Fetch a first ResultSet
            try (ResultSet rs18 = stmt18.executeQuery()) {
                ResultSetMetaData rsmd18 = (ResultSetMetaData) rs18.getMetaData();
                int columnsNumber = rsmd18.getColumnCount();
                System.out.println("Es werden die Lieferdienste mit Name und ID angezeigt, welche weniger Zeit benötigen, um die Pakete zuzustellen, als die durchschnittliche Lieferzeit aller Lieferdienste. (Performance-Übersicht):");
                while (rs18.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs18.getString(i);
                        System.out.print(rsmd18.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }

        try (PreparedStatement stmt19 = con.prepareStatement("SELECT ID, Name FROM Lieferdienst WHERE Lieferzeit < AVG(Lieferzeit)")) {

            // Fetch a first ResultSet
            try (ResultSet rs19 = stmt19.executeQuery()) {
                ResultSetMetaData rsmd19 = (ResultSetMetaData) rs19.getMetaData();
                int columnsNumber = rsmd19.getColumnCount();
                System.out.println("Es werden alle Spediteure angezeigt die eine Liefertreue unter 92 Prozent haben:");
                while (rs7.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs19.getString(i);
                        System.out.print(rsmd19.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }
        try (PreparedStatement stmt20 = con.prepareStatement("SELECT SUM(Max_Produktion) FROM Maschine")) {

            // Fetch a first ResultSet
            try (ResultSet rs20 = stmt20.executeQuery()) {
                ResultSetMetaData rsmd20 = (ResultSetMetaData) rs20.getMetaData();
                int columnsNumber = rsmd20.getColumnCount();
                System.out.println("Die Summe aller hergestellten Teile von jeder Maschine wird ermittelt:");
                while (rs20.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs20.getString(i);
                        System.out.print(rsmd20.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }

        try (PreparedStatement stmt21 = con.prepareStatement("SELECT Name, Aufgabe FROM Maschine WHERE Einstellung = 'fein'")) {

            // Fetch a first ResultSet
            try (ResultSet rs21 = stmt21.executeQuery()) {
                ResultSetMetaData rsmd21 = (ResultSetMetaData) rs21.getMetaData();
                int columnsNumber = rsmd21.getColumnCount();
                System.out.println("Hier werden die Maschinen anhand der EInstellung aufgeteilt. Alle Maschinen, die die aktuelle Einstellung 'fein' haben mit Name und Aufgabe herausgefiltert");
                while (rs21.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs21.getString(i);
                        System.out.print(rsmd21.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }

        try (PreparedStatement stmt22 = con.prepareStatement("SELECT Name FROM maschine WHERE Wartung BETWEEN '2017-01-01' AND '2021-01-01'")) {

            // Fetch a first ResultSet
            try (ResultSet rs22 = stmt22.executeQuery()) {
                ResultSetMetaData rsmd22 = (ResultSetMetaData) rs22.getMetaData();
                int columnsNumber = rsmd22.getColumnCount();
                System.out.println("Hier wird der Name der Maschinen ermittelt, die zwischen 2017 und 2021 eine Wartung hatten");
                while (rs22.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs22.getString(i);
                        System.out.print(rsmd22.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }




                //hier Abfragen Einfügen



                //das erst am Ende:
                con.close();

                // Without closing the statement, execute it again to fetch another ResultSet
                // try (ResultSet rs2 = stmt.executeQuery()) { ... }
            }


        }



