package connection;

import java.sql.*;

public class JavaCon {

    private static final String url = "jdbc:postgresql://localhost:5432/quiz";
    private static final String user = "alex";
    private static final String password = "";
    public static Connection connection = null;

    public static void connection() {

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (connection != null) {
            System.out.println("Connected");
        } else {
            System.out.println("Not connected");
        }
    }
}
