import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class DaoQuestionTest {

    private DaoQuestion daoQuestion = new DaoQuestion();
    private Question question;

    @Test
    void addQuestion() {

        JavaCon.connection();

        List<Answer> answerList = new ArrayList<>();
        Answer answer1 = new Answer("James Patterson", false);
        Answer answer2 = new Answer("Stephen King", false);
        Answer answer3 = new Answer("Arthur Conan Doyle", false);
        Answer answer4 = new Answer("Agatha Christie", true);
        answerList.add(answer1);
        answerList.add(answer2);
        answerList.add(answer3);
        answerList.add(answer4);

        question = new Question("Which author is known for creating Hercule Poirot?",
                answerList, "Literature", 2);

        daoQuestion.addQuestion(question);

        Question actual = daoQuestion.getQuestionById((int) question.getId());
        Assertions.assertEquals(question.getId(), actual.getId());
        Assertions.assertEquals(question.getQuestion(), actual.getQuestion());
        Assertions.assertEquals(question.getTopic(), actual.getTopic());
        Assertions.assertEquals(question.getDifficultyLevel(), actual.getDifficultyLevel());
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
    void questionAnswers() {

    }

    @Test
    void deleteQuestion() {

        JavaCon.connection();

        List<Answer> answerList = new ArrayList<>();
        Answer answer1 = new Answer("James Patterson", false);
        Answer answer2 = new Answer("Stephen King", false);
        Answer answer3 = new Answer("Arthur Conan Doyle", false);
        Answer answer4 = new Answer("Agatha Christie", true);
        answerList.add(answer1);
        answerList.add(answer2);
        answerList.add(answer3);
        answerList.add(answer4);

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
        Answer answer1 = new Answer("James Patterson", false);
        Answer answer2 = new Answer("Stephen King", false);
        Answer answer3 = new Answer("Arthur Conan Doyle", false);
        Answer answer4 = new Answer("Agatha Christie", true);
        answerList.add(answer1);
        answerList.add(answer2);
        answerList.add(answer3);
        answerList.add(answer4);
        Question question = new Question("Which author is known for creating Hercule Poirot?",
                answerList, "Literature", 2);
        daoQuestion.addQuestion(question);

        List<Answer> newAnswerList = new ArrayList<>();
        Answer answer5 = new Answer("test", false);
        Answer answer6 = new Answer("test", false);
        Answer answer7 = new Answer("test", false);
        Answer answer8 = new Answer("test", true);
        answerList.add(answer5);
        answerList.add(answer6);
        answerList.add(answer7);
        answerList.add(answer8);


        int questionId = (int) question.getId();
        Question newQuestion = new Question(questionId,"test", newAnswerList, "test", 3);
        daoQuestion.updateQuestion(questionId, newQuestion);

        Question result = daoQuestion.getQuestionById(questionId);

        Assertions.assertEquals(newQuestion.getId(), result.getId());
        Assertions.assertEquals(newQuestion.getQuestion(), result.getQuestion());
        Assertions.assertEquals(newQuestion.getTopic(), result.getTopic());
        Assertions.assertEquals(newQuestion.getDifficultyLevel(), result.getDifficultyLevel());
    }
}