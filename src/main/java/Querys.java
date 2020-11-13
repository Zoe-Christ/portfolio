import com.mysql.cj.jdbc.result.ResultSetMetaData;
import connection.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Querys {

    private static Connection con = null;
    private ResultSetMetaData rsmd = null;
    private ResultSet rs = null;

    public static void main(String[] args) throws IllegalAccessException, SQLException {
        Querys qs = new Querys();

        con = ConnectionHelper.getConnection("portfolio");

        if( con!= null ){
            qs.selectLieferdienstVertraege2(con.prepareStatement("SELECT Lieferdienst.Name, Lieferdienst.vertrag_Vertrag_ID, Vertrag.Vertrag_ID, Vertrag.Laufzeit from portfolio.Lieferdienst \n" +
                                                                        "inner Join portfolio.Vertrag where Lieferdienst.vertrag_Vertrag_ID = Vertrag.Vertrag_ID"));

            //qs.selectLieferdienstVertraege();
            qs.selectAllOnline_Haendler();
            qs.selectUmsatz();
            qs.selectGroupZahlungennachZahlungsart();
            qs.selectLagerMietkosten();
            qs.selectProdukteinKundenauftrag();
            qs.selectProduktemitBestandkleiner50();
            qs.selectzugestellteBestellungen();
            qs.selectAnzahlMitarbeiter();
            qs.selectSumStueckzahl();
            qs.selectBudget();
            qs.selectSumGehaelter();
            qs.selectCountMA();
            qs.selectFilialemitUmsatzGroesser40000();
            qs.selectUmsatzUnternehmen();
            qs.selectschnelleLieferdienste();
            qs.selectSpediteuremiLiefertreueKleiner92();
            qs.selectMaxProduktionskapazitaet();
            qs.selectMaschineEinstellungFein();
            qs.selectMaschinenmitWartung();

            con.close();

        } else {
            System.out.println("Bitte Datenabnkserver starten!");
        }

    }

    public void selectLieferdienstVertraege2(PreparedStatement stmt){
        try (ResultSet rs = stmt.executeQuery()) {
            rsmd = (ResultSetMetaData) rs.getMetaData();
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
            rsmd = null;
        } catch (SQLException e) {
            System.err.println("Error during Demo!");
            e.printStackTrace();
        }
    }


    public void selectLieferdienstVertraege(){
        try (PreparedStatement stmt = con.prepareStatement("SELECT Lieferdienst.Name, Lieferdienst.vertrag_Vertrag_ID, Vertrag.Vertrag_ID, Vertrag.Laufzeit from portfolio.Lieferdienst \n" +
                "inner Join portfolio.Vertrag where Lieferdienst.vertrag_Vertrag_ID = Vertrag.Vertrag_ID")) {

            try (ResultSet rs = stmt.executeQuery()) {
                rsmd = (ResultSetMetaData) rs.getMetaData();
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
                rsmd = null;
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(" ");
    }

    public void selectAllOnline_Haendler(){
        try (PreparedStatement stmt2 = con.prepareStatement("SELECT * from portfolio.Online_haendler where Name LIKE 'Ama%'")) {

            try (ResultSet rs2 = stmt2.executeQuery()) {
                rsmd = (ResultSetMetaData) rs2.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                System.out.println("Sucht alle Händler, deren Namen mit 'Ama' beginnt:");
                while (rs2.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs2.getString(i);
                        System.out.print(rsmd.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
                rsmd = null;
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(" ");
    }

    public void selectUmsatz(){
        try (PreparedStatement stmt3 = con.prepareStatement("SELECT * from portfolio.Filiale order by Umsatz DESC")) {

            try (ResultSet rs3 = stmt3.executeQuery()) {
                rsmd = (ResultSetMetaData) rs3.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                System.out.println("Sortiert die Filialen nach Umsatz:");
                while (rs3.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs3.getString(i);
                        System.out.print(rsmd.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
                rsmd = null;
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(" ");
    }

    public void selectGroupZahlungennachZahlungsart(){
        try (PreparedStatement stmt4 = con.prepareStatement("SELECT COUNT(RechnungsNr), Zahlungsart from portfolio.Zahlung Group by Zahlungsart")) {

            try (ResultSet rs4 = stmt4.executeQuery()) {
                rsmd = (ResultSetMetaData) rs4.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                System.out.println("Gruppiert die Zahlungen nach Zahlungsart und Anzahl:");
                while (rs4.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs4.getString(i);
                        System.out.print(rsmd.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
                rsmd = null;
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(" ");
    }

    public void selectLagerMietkosten(){
        try (PreparedStatement stmt5 = con.prepareStatement("SELECT LagerID, Mietkosten from portfolio.Lager where Mietkosten < 9000")) {

            try (ResultSet rs5 = stmt5.executeQuery()) {
                rsmd = (ResultSetMetaData) rs5.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                System.out.println("Zeigt die ID und die Mietkosten aller Lager, deren Mietkosten kleiner als 9000 sind:");
                while (rs5.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs5.getString(i);
                        System.out.print(rsmd.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
                rsmd = null;
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(" ");
    }

    public void selectProdukteinKundenauftrag(){
        try (PreparedStatement stmt6 = con.prepareStatement("SELECT Name, ProduktNr from Produkt WHERE ProduktNr IN (SELECT Produkt_ProduktNr from kundenauftrag_has_produkt where stueckzahl > 1)")) {

            try (ResultSet rs6 = stmt6.executeQuery()) {
                rsmd = (ResultSetMetaData) rs6.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                System.out.println("Zeigt alle Produkte in einem Kundenauftrag, die häufiger als einmal bestellt wurden:");
                while (rs6.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs6.getString(i);
                        System.out.print(rsmd.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
                rsmd = null;
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(" ");
    }

    public void selectProduktemitBestandkleiner50(){
        try (PreparedStatement stmt7 = con.prepareStatement("SELECT COUNT(ProduktNr) from Produkt WHERE Bestand BETWEEN 0 AND 50")) {

            try (ResultSet rs7 = stmt7.executeQuery()) {
                rsmd = (ResultSetMetaData) rs7.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                System.out.println("Zeigt alle Produkte mit Bestand zwischen 0 und 50:");
                while (rs7.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs7.getString(i);
                        System.out.print(rsmd.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
                rsmd = null;
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(" ");
    }

    public void selectzugestellteBestellungen(){
        try (PreparedStatement stmt8 = con.prepareStatement("SELECT Warenwert FROM Bestellung WHERE Bearbeitungsstatus = 'zugestellt' OR Warenwert BETWEEN 400 AND 1000 ORDER BY Warenwert DESC")) {

            try (ResultSet rs8 = stmt8.executeQuery()) {
                rsmd = (ResultSetMetaData) rs8.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                System.out.println("Zeigt zugestellte Bestellungen mit Warenwert zwischen 400 und 1000 Euro, sortiert nach absteigenden Werten:");
                while (rs8.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs8.getString(i);
                        System.out.print(rsmd.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
                rsmd = null;
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(" ");
    }

    public void selectAnzahlMitarbeiter(){
        try (PreparedStatement stmt11 = con.prepareStatement("SELECT SUM(AnzahlMA) FROM Abteilung")) {

            try (ResultSet rs11 = stmt11.executeQuery()) {
                rsmd = (ResultSetMetaData) rs11.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                System.out.println("Summe der Anzahl Mitarbeiter im Unternehmen:");
                while (rs11.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs11.getString(i);
                        System.out.print(rsmd.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
                rsmd = null;
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(" ");
    }

    public void selectSumStueckzahl(){
        try (PreparedStatement stmt12 = con.prepareStatement("SELECT SUM(stueckzahl) FROM kundenauftrag_has_produkt WHERE (kundenauftrag_AuftragID > 2)")) {

            try (ResultSet rs12 = stmt12.executeQuery()) {
                rsmd = (ResultSetMetaData) rs12.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                System.out.println("Es wird die Summe der Stückzahl mit Auftrags ID > 2 ermittelt");
                while (rs12.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs12.getString(i);
                        System.out.print(rsmd.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
                rsmd = null;
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(" ");
    }

    public void selectBudget(){
        try (PreparedStatement stmt13 = con.prepareStatement("SELECT einkauf.Budget, einkauf.Saison FROM portfolio.einkauf HAVING (AVG(einkauf.Budget) > einkauf.Budget)")) {

            try (ResultSet rs13 = stmt13.executeQuery()) {
                rsmd = (ResultSetMetaData) rs13.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                System.out.println("Es werden die Budgets und dazugehörigen Saisons des Einkaufs angezeigt, welche weniger als das durchschnittliche Budget benötigt haben. (Quantitative Messung der Ausgaben):");
                while (rs13.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs13.getString(i);
                        System.out.print(rsmd.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
                rsmd = null;
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(" ");
    }

    public void selectSumGehaelter(){
        try (PreparedStatement stmt14 = con.prepareStatement("SELECT SUM(Gehalt) FROM Mitarbeiter")) {

            try (ResultSet rs14 = stmt14.executeQuery()) {
                rsmd = (ResultSetMetaData) rs14.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                System.out.println("Es wird die Summe der Gehälter aller Mitarbeiter angezeigt. (Personalkosten):");
                while (rs14.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs14.getString(i);
                        System.out.print(rsmd.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
                rsmd = null;
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(" ");
    }

    public void selectCountMA(){
        try (PreparedStatement stmt15 = con.prepareStatement("SELECT COUNT(MitarbeiterID) FROM Mitarbeiter")) {


            try (ResultSet rs15 = stmt15.executeQuery()) {
                rsmd = (ResultSetMetaData) rs15.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                System.out.println("Es wird die gesamte Anzahl der Mitabeiter angezeigt, welche im Unternehmen arbeiten (Mitarbeiteranzahl):");
                while (rs15.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs15.getString(i);
                        System.out.print(rsmd.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
                rsmd = null;
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(" ");
    }

    public void selectFilialemitUmsatzGroesser40000(){
        try (PreparedStatement stmt16 = con.prepareStatement("SELECT FilialeID, Name, Umsatz FROM Filiale where (Umsatz>40000)")) {

            try (ResultSet rs16 = stmt16.executeQuery()) {
                rsmd = (ResultSetMetaData) rs16.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                System.out.println("Es werden die Filialen angezeigt, welche einen höheren Umsatz verzeichnen als 40000:");
                while (rs16.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs16.getString(i);
                        System.out.print(rsmd.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
                rsmd = null;
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(" ");
    }

    public void selectUmsatzUnternehmen(){
        try (PreparedStatement stmt17 = con.prepareStatement("SELECT SUM(Umsatz) FROM Filiale")) {

            try (ResultSet rs17 = stmt17.executeQuery()) {
                rsmd = (ResultSetMetaData) rs17.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                System.out.println("Es wird der Gesamtumsatz des Unternehmens angezeigt. (KPI):");
                while (rs17.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs17.getString(i);
                        System.out.print(rsmd.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
                rsmd = null;
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(" ");
    }

    public void selectschnelleLieferdienste(){
        try (PreparedStatement stmt18 = con.prepareStatement("SELECT ID, Name, Lieferzeit FROM Lieferdienst HAVING (Lieferzeit < AVG(Lieferzeit))")) {

            try (ResultSet rs18 = stmt18.executeQuery()) {
                rsmd = (ResultSetMetaData) rs18.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                System.out.println("Es werden die Lieferdienste mit Name und ID angezeigt, welche weniger Zeit benötigen, um die Pakete zuzustellen, als die durchschnittliche Lieferzeit aller Lieferdienste. (Performance-Übersicht):");
                while (rs18.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs18.getString(i);
                        System.out.print(rsmd.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
                rsmd = null;
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(" ");
    }

    public void selectSpediteuremiLiefertreueKleiner92(){
        try (PreparedStatement stmt19 = con.prepareStatement("Select * from Spediteur where Liefertreue < 92")) {

            try (ResultSet rs19 = stmt19.executeQuery()) {
                rsmd = (ResultSetMetaData) rs19.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                System.out.println("Es werden alle Spediteure angezeigt die eine Liefertreue unter 92 Prozent haben:");
                while (rs19.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs19.getString(i);
                        System.out.print(rsmd.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
                rsmd = null;
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }

        System.out.println(" ");
    }

    public void selectMaxProduktionskapazitaet(){
        try (PreparedStatement stmt20 = con.prepareStatement("SELECT SUM(Max_Produktion) FROM Maschine")) {

            try (ResultSet rs20 = stmt20.executeQuery()) {
                rsmd = (ResultSetMetaData) rs20.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                System.out.println("Die Summe aller hergestellten Teile von jeder Maschine wird ermittelt:");
                while (rs20.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs20.getString(i);
                        System.out.print(rsmd.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
                rsmd = null;
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(" ");
    }

    public void selectMaschineEinstellungFein(){
        try (PreparedStatement stmt21 = con.prepareStatement("SELECT Name, Aufgabe FROM Maschine WHERE Einstellung = 'fein'")) {

            try (ResultSet rs21 = stmt21.executeQuery()) {
                rsmd = (ResultSetMetaData) rs21.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                System.out.println("Hier werden die Maschinen anhand der EInstellung aufgeteilt. Alle Maschinen, die die aktuelle Einstellung 'fein' haben mit Name und Aufgabe herausgefiltert");
                while (rs21.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs21.getString(i);
                        System.out.print(rsmd.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
                rsmd = null;
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(" ");
    }

    public void selectMaschinenmitWartung(){
        try (PreparedStatement stmt22 = con.prepareStatement("SELECT Name FROM maschine WHERE Wartung BETWEEN '2017-01-01' AND '2021-01-01'")) {

            try (ResultSet rs22 = stmt22.executeQuery()) {
                rsmd = (ResultSetMetaData) rs22.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                System.out.println("Hier wird der Name der Maschinen ermittelt, die zwischen 2017 und 2021 eine Wartung hatten");
                while (rs22.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs22.getString(i);
                        System.out.print(rsmd.getColumnName(i)+": "+ columnValue);
                    }
                    System.out.println("");
                }
                rsmd = null;
            } catch (SQLException e) {
                System.err.println("Error during Demo!");
                e.printStackTrace();
            }
        }   catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(" ");
    }

}



