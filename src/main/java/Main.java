import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        DaoQuestion daoQuestion = new DaoQuestion();
        JavaCon.connection();

        List<Answer> answerList = new ArrayList<>();
        Answer answer1 = new Answer("Cat", false);
        Answer answer2 = new Answer("Dog", true);
        Answer answer3 = new Answer("Bird", false);
        answerList.add(answer1);
        answerList.add(answer2);
        answerList.add(answer3);

        Question question = new Question("Who is bigger?", answerList, "dogs", 4);
        daoQuestion.addQuestion(question);

//        daoQuestion.addAnswer(1, answerList);

//        daoQuestion.getAllQuestions("Cats");

//        daoQuestion.getQuestionByTopic("Cats");

        PrintService printService = new PrintService();

//        printService.printQuestionByTopic("Cats");
        printService.printQuestionAndAnswer("Cats");
//        daoQuestion.getQuestionByTopic("Cats");

        JavaCon.connection.close();
    }
}
