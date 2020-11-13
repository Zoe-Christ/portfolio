
import connection.ConnectionHelper;

import java.sql.*;

public class Insert {

    private static Connection con = null;
    private static Statement stmt = null;


    public static void main(String[] args) throws SQLException {

        Insert element = new Insert();

        con = ConnectionHelper.getConnection("portfolio");
        stmt = con.createStatement();

        if(con != null){
            element.insert("INSERT INTO Fahrzeug(Bezeichnung) VALUES ('Porsche')");
            element.insert("INSERT INTO Filiale (Name, VerkaufsFlaeche, Oeffnungszeit, Umsatz, adresse_AdressID) VALUES('G', 20000, '10 bis 20', 80000, 1)");
            element.insert("INSERT INTO Einkauf (Budget, Saison, Richtlinie, Bestandswert, abteilung_Kuerzel) VALUES(21000, 'Fruehling', 'exklusive Verkäufe', 200, 20)");

            con.close();
        } else {
            System.out.println("Datenbankserver starten!");
        }

    }

    public void insert(String sql){

        try {

            stmt.executeUpdate(sql);
            System.out.println("Inserted record into the tables");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
