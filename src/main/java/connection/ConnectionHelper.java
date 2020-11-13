package connection;

import org.apache.logging.log4j.util.SystemPropertiesPropertySource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectionHelper {

    private static String LOGIN = "";
    private static String PASSWORD = "";
    private static String URL = "jdbc:mysql://localhost:3306/";
    private static String DEFAULTSCHEMA = "portfolio";
    private static String TIMEZONEPROPERTY = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public ConnectionHelper() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static Connection getConnection( String schema ) {
        if (LOGIN.equals("")||PASSWORD.equals("")){
            System.out.println("Datenbank-Login");
            Scanner sc = new Scanner(System.in);
            System.out.print("Benutzer: \t");
            LOGIN = sc.nextLine();

            System.out.print("Passwort: \t");
            PASSWORD = sc.nextLine();
            System.out.println("");
            sc.close();
        }

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

    public static String getLOGIN() {
        return LOGIN;
    }

    public static void setLOGIN(String LOGIN) {
        ConnectionHelper.LOGIN = LOGIN;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static void setPASSWORD(String PASSWORD) {
        ConnectionHelper.PASSWORD = PASSWORD;
    }
}
