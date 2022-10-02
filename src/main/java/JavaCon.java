import java.sql.*;

public class JavaCon {

    private static final String url = "jdbc:postgresql://localhost:5432/quiz";
    private static final String user = "alex";
    private static final String password = "";
    public static Connection connection = null;

    public static void connection() {

        try {
            connection = DriverManager.getConnection(url, user, password);
//            Statement stmt = null;
//            stmt = connection.createStatement();
//            String sql = "CREATE TABLE question " +
//                    "(id serial PRIMARY KEY," +
//                    " question varchar(80), " +
//                    " topic varchar(80), " +
//                    " difficulty_level int)";
//            stmt.executeUpdate(sql);
//            sql = "CREATE TABLE answers " +
//                    "(id serial PRIMARY KEY," +
//                    " question_Id int," +
//                    " answer varchar(80)," +
//                    " is_correct boolean)";
//            stmt.executeUpdate(sql);
//            stmt.close();
//            connection.close();

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
