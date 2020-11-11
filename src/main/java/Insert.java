
import connection.ConnectionHelper;

import java.sql.*;

public class Insert {

    public static void main(String[] args) throws SQLException {
        Connection con = ConnectionHelper.getConnection("portfolio");
        Statement stmt = con.createStatement();
        String sql;

//Insert sql Befehle
        try {
            sql = "INSERT INTO Fahrzeug(Bezeichnung) VALUES ('LKW')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Filiale (Name, VerkaufsFlaeche, Oeffnungszeit,Umsatz, adresse_AdressID) VALUES('D', 3900, '10 bis 20', 80000, 2)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Einkauf (Budget, Saison, Richtlinie, Bestandswert, abteilung_Kuerzel) VALUES(95000, 'Sommer', 'exklusive Verkäufe', 800, 20)";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the tables");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
