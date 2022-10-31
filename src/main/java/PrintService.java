import dao.DaoQuestion;
import model.Answer;
import model.Question;

import java.util.List;

/*
    This class allows to print out questions by topic;
 */

public class PrintService {
    final DaoQuestion daoQuestion = new DaoQuestion();

    public void printQuestionByTopic(String questionTopic) {
        List<Question> questionList = daoQuestion.getQuestionsByTopic(questionTopic);
        System.out.println(questionList);
    }

    public void printQuestionAndAnswer(String questionTopic) {
        List<Question> questionList = daoQuestion.getQuestionsByTopic(questionTopic);
        for (Question question : questionList) {
            System.out.println(question);

            int answerNumber = 1;
            for (Answer answer : question.getAnswers()) {
                System.out.println(answerNumber++ + ". " + answer.getAnswer() + ". This answer is: " + answer.isCorrect() + ".");
            }
        }
    }
}
