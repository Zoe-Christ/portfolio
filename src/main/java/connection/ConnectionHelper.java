package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

    private static String LOGIN = "root";
    private static String PASSWORD = "root";
    private static String URL = "jdbc:mysql://localhost:3306/";
    private static String DEFAULTSCHEMA = "portfolio";
    private static String TIMEZONEPROPERTY = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public ConnectionHelper() throws IllegalAccessException {
        throw new IllegalAccessException();
    }


    public static Connection getConnection( String schema ) {
        Connection con = null;
        try {
            if ( schema == null ) {
                con = DriverManager.getConnection( URL + DEFAULTSCHEMA + TIMEZONEPROPERTY, LOGIN, PASSWORD );
            } else {
                con = DriverManager.getConnection( URL + schema + TIMEZONEPROPERTY, LOGIN, PASSWORD );
            }

        } catch ( SQLException e ) {
            System.err.println( "Error during connection to database!" );
            e.printStackTrace();
        }

        return con;
    }
}
