import connection.JavaCon;
import dao.DaoQuestion;
import model.Answer;
import model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class DaoQuestionTest {
    private final DaoQuestion daoQuestion = new DaoQuestion();

    @Test
    void addQuestion() {

        JavaCon.connection();

        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer("James Patterson", false));
        answerList.add(new Answer("Stephen King", false));
        answerList.add(new Answer("Arthur Conan Doyle", false));
        answerList.add(new Answer("Agatha Christie", true));

        Question question = new Question("Which author is known for creating Hercule Poirot?",
                answerList, "Literature", 2);
        daoQuestion.addQuestion(question);

        Question actual = daoQuestion.getQuestionById((int) question.getId());
        Assertions.assertEquals(question, actual);
//        daoQuestion.deleteQuestion((int) expected.getId());
    }

    @Test
    void getQuestionByTopic() {
        JavaCon.connection();
        List<Question> questionList = daoQuestion.getQuestionsByTopic("Geography");

        for (Question question : questionList) {
            Assertions.assertEquals("Geography", question.getTopic());
        }
    }

    @Test
    void deleteQuestion() {

        JavaCon.connection();

        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer("James Patterson", false));
        answerList.add(new Answer("Stephen King", false));
        answerList.add(new Answer("Arthur Conan Doyle", false));
        answerList.add(new Answer("Agatha Christie", true));

        Question question = new Question("Which author is known for creating Hercule Poirot?",
                answerList, "Literature", 2);
        daoQuestion.addQuestion(question);

        int questionId = (int) question.getId();
        daoQuestion.deleteQuestion(questionId);
        Assertions.assertNull(daoQuestion.getQuestionById(questionId));
    }

    @Test
    void updateQuestion() {

        JavaCon.connection();
        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer("James Patterson", false));
        answerList.add(new Answer("Stephen King", false));
        answerList.add(new Answer("Arthur Conan Doyle", false));
        answerList.add(new Answer("Agatha Christie", true));

        Question question = new Question("Which author is known for creating Hercule Poirot?",
                answerList, "Literature", 2);
        daoQuestion.addQuestion(question);

        List<Answer> newAnswerList = new ArrayList<>();
        answerList.add(new Answer("test", false));
        answerList.add(new Answer("test", false));
        answerList.add(new Answer("test", false));
        answerList.add(new Answer("test", true));

        int questionId = (int) question.getId();
        Question newQuestion = new Question(questionId,"test", newAnswerList, "test", 3);
        daoQuestion.updateQuestion(questionId, newQuestion);

        Question result = daoQuestion.getQuestionById(questionId);
        Assertions.assertEquals(newQuestion, result);
    }
}