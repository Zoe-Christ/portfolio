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

        Statement stmt = con.createStatement();
        try ( ResultSet rs = stmt.executeQuery( "SELECT * FROM Lager" ) ) {
                        while ( rs.next() ) {
                            System.out.printf( "%s, %s%n", rs.getString( 2 ), rs.getInt( 1 ) );
                        }

        } catch ( SQLException e ) {
            System.err.println( "Error during Demo!" );
            e.printStackTrace();
        }
    }

}
