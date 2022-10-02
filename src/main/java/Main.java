import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        DaoQuestion daoQuestion = new DaoQuestion();
        PrintService printService = new PrintService();
        JavaCon.connection();

//        printService.printQuestionByTopic("Geography");

        printService.printQuestionAndAnswer("Geography");


        JavaCon.connection.close();
    }
}
