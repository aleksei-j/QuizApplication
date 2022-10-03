import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        DaoQuestion daoQuestion = new DaoQuestion();
        PrintService printService = new PrintService();
        JavaCon.connection();


        Question question = daoQuestion.getQuestionById(1);
        System.out.println(question.getQuestion());

        JavaCon.connection.close();
    }
}
