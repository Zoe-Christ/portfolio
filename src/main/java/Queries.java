import com.mysql.cj.jdbc.result.ResultSetMetaData;
import connection.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Queries {

    private static Connection con = null;
    private ResultSetMetaData rsmd = null;

    public static void main(String[] args) throws IllegalAccessException, SQLException {
        Queries qs = new Queries();

        con = ConnectionHelper.getConnection("portfolio");

        if( con!= null ){

            qs.getLiefervertraege(con.prepareStatement("SELECT Lieferdienst.Name, Lieferdienst.vertrag_Vertrag_ID, Vertrag.Vertrag_ID, Vertrag.Laufzeit from portfolio.Lieferdienst \n" +
                                                                               "inner Join portfolio.Vertrag where Lieferdienst.vertrag_Vertrag_ID = Vertrag.Vertrag_ID"));
            qs.selectAllOnline_Haendler(con.prepareStatement("SELECT * from portfolio.Online_haendler where Name LIKE 'Ama%'"));
            qs.selectUmsatz(con.prepareStatement("SELECT * from portfolio.Filiale order by Umsatz DESC"));
            qs.selectGroupZahlungennachZahlungsart(con.prepareStatement("SELECT COUNT(RechnungsNr), Zahlungsart from portfolio.Zahlung Group by Zahlungsart"));
            qs.selectLagerMietkosten(con.prepareStatement("SELECT LagerID, Mietkosten from portfolio.Lager where Mietkosten < 9000"));
            qs.selectProdukteinKundenauftrag(con.prepareStatement("SELECT Name, ProduktNr from Produkt WHERE ProduktNr IN (SELECT Produkt_ProduktNr from kundenauftrag_has_produkt where stueckzahl > 1)"));
            qs.selectProduktemitBestandkleiner50(con.prepareStatement("SELECT COUNT(ProduktNr) from Produkt WHERE Bestand BETWEEN 0 AND 50"));
            qs.selectzugestellteBestellungen(con.prepareStatement("SELECT Warenwert FROM Bestellung WHERE Bearbeitungsstatus = 'zugestellt' OR Warenwert BETWEEN 400 AND 1000 ORDER BY Warenwert DESC"));
            qs.selectAnzahlMitarbeiter(con.prepareStatement("SELECT SUM(AnzahlMA) FROM Abteilung"));
            qs.selectSumStueckzahl(con.prepareStatement("SELECT SUM(stueckzahl) FROM kundenauftrag_has_produkt WHERE (kundenauftrag_AuftragID > 2)"));
            qs.selectBudget(con.prepareStatement("SELECT einkauf.Budget, einkauf.Saison FROM portfolio.einkauf HAVING (AVG(einkauf.Budget) > einkauf.Budget)"));
            qs.selectSumGehaelter(con.prepareStatement("SELECT SUM(Gehalt) FROM Mitarbeiter"));
            qs.selectCountMA(con.prepareStatement("SELECT COUNT(MitarbeiterID) FROM Mitarbeiter"));
            qs.selectFilialemitUmsatzGroesser40000(con.prepareStatement("SELECT FilialeID, Name, Umsatz FROM Filiale where (Umsatz>40000)"));
            qs.selectUmsatzUnternehmen(con.prepareStatement("SELECT SUM(Umsatz) FROM Filiale"));
            qs.selectschnelleLieferdienste(con.prepareStatement("SELECT ID, Name, Lieferzeit FROM Lieferdienst HAVING (Lieferzeit < AVG(Lieferzeit))"));
            qs.selectSpediteuremiLiefertreueKleiner92(con.prepareStatement("Select * from Spediteur where Liefertreue < 92"));
            qs.selectMaxProduktionskapazitaet(con.prepareStatement("SELECT SUM(Max_Produktion) FROM Maschine"));
            qs.selectMaschineEinstellungFein(con.prepareStatement("SELECT Name, Aufgabe FROM Maschine WHERE Einstellung = 'fein'"));
            qs.selectMaschinenmitWartung(con.prepareStatement("SELECT Name FROM maschine WHERE Wartung BETWEEN '2017-01-01' AND '2021-01-01'"));

            con.close();

        } else {
            System.out.println("Bitte Datenbankserver starten!");
        }

    }

    public void select(PreparedStatement stmt){
        try (ResultSet rs = stmt.executeQuery()) {
            rsmd = (ResultSetMetaData) rs.getMetaData();
            int columnNr = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnNr; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
                }
                System.out.println("");
            }
            rsmd = null;
        } catch (SQLException e) {
            System.err.println("Exception aufgetreten, SQL Statement prüfen!");
            e.printStackTrace();
        }
        System.out.println("");

    }

    public void getLiefervertraege(PreparedStatement stmt){
        System.out.println("Inner Join: zeigt Name des Lieferdienst mit dazugehöriger Vertragslaufzeit:");
        select(stmt);
    }

    public void selectAllOnline_Haendler(PreparedStatement stmt){
        System.out.println("Sucht alle Händler, deren Namen mit 'Ama' beginnt:");
        select(stmt);
    }

    public void selectUmsatz(PreparedStatement stmt){
        System.out.println("Sortiert die Filialen nach Umsatz:");
        select(stmt);
    }

    public void selectGroupZahlungennachZahlungsart(PreparedStatement stmt){
        System.out.println("Gruppiert die Zahlungen nach Zahlungsart und Anzahl:");
        select(stmt);
    }

    public void selectLagerMietkosten(PreparedStatement stmt){
        System.out.println("Zeigt die ID und die Mietkosten aller Lager, deren Mietkosten kleiner als 9000 sind:");
        select(stmt);
    }

    public void selectProdukteinKundenauftrag(PreparedStatement stmt){
        System.out.println("Zeigt alle Produkte in einem Kundenauftrag, die häufiger als einmal bestellt wurden:");
        select(stmt);
    }

    public void selectProduktemitBestandkleiner50(PreparedStatement stmt){
        System.out.println("Zeigt alle Produkte mit Bestand zwischen 0 und 50:");
        select(stmt);
    }

    public void selectzugestellteBestellungen(PreparedStatement stmt){
        System.out.println("Zeigt zugestellte Bestellungen mit Warenwert zwischen 400 und 1000 Euro, sortiert nach absteigenden Werten:");
        select(stmt);
    }

    public void selectAnzahlMitarbeiter(PreparedStatement stmt){
        System.out.println("Summe der Anzahl Mitarbeiter im Unternehmen:");
        select(stmt);
    }

    public void selectSumStueckzahl(PreparedStatement stmt){
        System.out.println("Es wird die Summe der Stückzahl mit Auftrags ID > 2 ermittelt");
        select(stmt);
    }

    public void selectBudget(PreparedStatement stmt){
        System.out.println("Es werden die Budgets und dazugehörigen Saisons des Einkaufs angezeigt, welche weniger als das durchschnittliche Budget benötigt haben. (Quantitative Messung der Ausgaben):");
        select(stmt);
    }

    public void selectSumGehaelter(PreparedStatement stmt){
        System.out.println("Es wird die Summe der Gehälter aller Mitarbeiter angezeigt. (Personalkosten):");
        select(stmt);
    }

    public void selectCountMA(PreparedStatement stmt){
        System.out.println("Es wird die gesamte Anzahl der Mitabeiter angezeigt, welche im Unternehmen arbeiten (Mitarbeiteranzahl):");
        select(stmt);
    }

    public void selectFilialemitUmsatzGroesser40000(PreparedStatement stmt){
        System.out.println("Es werden die Filialen angezeigt, welche einen höheren Umsatz verzeichnen als 40000:");
        select(stmt);
    }

    public void selectUmsatzUnternehmen(PreparedStatement stmt){
        System.out.println("Es wird der Gesamtumsatz des Unternehmens angezeigt. (KPI):");
        select(stmt);
    }

    public void selectschnelleLieferdienste(PreparedStatement stmt){
        System.out.println("Es werden die Lieferdienste mit Name und ID angezeigt, welche weniger Zeit benötigen, um die Pakete zuzustellen, als die durchschnittliche Lieferzeit aller Lieferdienste. (Performance-Übersicht):");
        select(stmt);
    }

    public void selectSpediteuremiLiefertreueKleiner92(PreparedStatement stmt){
        System.out.println("Es werden alle Spediteure angezeigt die eine Liefertreue unter 92 Prozent haben:");
        select(stmt);
    }

    public void selectMaxProduktionskapazitaet(PreparedStatement stmt){
        System.out.println("Die Summe aller hergestellten Teile von jeder Maschine wird ermittelt:");
        select(stmt);
    }

    public void selectMaschineEinstellungFein(PreparedStatement stmt){
        System.out.println("Hier werden die Maschinen anhand der EInstellung aufgeteilt. Alle Maschinen, die die aktuelle Einstellung 'fein' haben mit Name und Aufgabe herausgefiltert");
        select(stmt);
    }

    public void selectMaschinenmitWartung(PreparedStatement stmt){
        System.out.println("Hier wird der Name der Maschinen ermittelt, die zwischen 2017 und 2021 eine Wartung hatten");
        select(stmt);
    }

}



