import java.util.List;

public class PrintService {

    DaoQuestion daoQuestion = new DaoQuestion();

    public void printQuestionByTopic(String questionTopic) {

        List<Question> questionList = daoQuestion.getQuestionByTopic(questionTopic);

        for (Question question : questionList) {
            System.out.println(question.getQuestion()+ " Topic of this question is: " +
                    question.getTopic() + ". Difficulty of this question is: " + question.getDifficultyLevel() + ".");
        }
    }

    public void printQuestionAndAnswer(String questionTopic) {

        List<Question> questionList = daoQuestion.getQuestionByTopic(questionTopic);

        for (Question question : questionList) {
            System.out.println(question.getQuestion()+ " Topic of this question is: " +
                    question.getTopic() + ". Difficulty of this question is: " + question.getDifficultyLevel() + ".");

            int answerNumber = 1;
            for (Answer answer : question.getAnswers()) {
                System.out.println(answerNumber++ + ". " + answer.getAnswer() + ". This answer is: " + answer.isCorrect() + ".");
            }
        }
    }
}
