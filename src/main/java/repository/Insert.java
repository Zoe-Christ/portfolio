package repository;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import connection.ConnectionHelper;

import java.sql.*;

public class Insert {
    public static void main(String[] args) throws IllegalAccessException, SQLException {
        Connection con = ConnectionHelper.getConnection("portfolio");
        Statement stmt = con.createStatement();
        String sql;

try {
    sql = "INSERT INTO Fahrzeug(Bezeichnung) VALUES ('Bagger')";
    stmt.executeUpdate(sql);
    System.out.println("Inserted records into the table Fahrzeug");
} catch (SQLException throwables) {
    throwables.printStackTrace();
}
    }
}
