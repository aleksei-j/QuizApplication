import connection.JavaCon;
import dao.DaoQuestion;
import model.Question;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        DaoQuestion daoQuestion = new DaoQuestion();
        JavaCon.connection();

        Question question = daoQuestion.getQuestionById(1);
        System.out.println(question.getQuestion());

        JavaCon.connection.close();
    }
}
