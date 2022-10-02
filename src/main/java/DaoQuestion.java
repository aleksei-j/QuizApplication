import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoQuestion {

    /*
        Method to add question to database with answers, this method will additionally call method addAnswer()
        that will add answers to the given question in to separate table in the database.
     */
    public void addQuestion(Question q) {
        PreparedStatement statement;
        String query = "insert into question values(default,?,?,?)";

        try {
            statement = JavaCon.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, q.getQuestion());
            statement.setString(2,q.getTopic());
            statement.setInt(3, q.getDifficultyLevel());
            int affectedRows = statement.executeUpdate();
            System.out.println("Question successfully inserted");

            if (affectedRows == 0) {
                throw new SQLException("Creating field failed, no rows affected.");
            }
            int questionId;
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    q.setId(generatedKeys.getInt(1));
                    questionId = generatedKeys.getInt(1);
                } else {
                    throw  new SQLException("Creating question failed, no ID obtained.");
                }
            }
            addAnswer(questionId, q.getAnswers());
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
        This method helps addQuestion() method to save answers to each question.
     */
    private void addAnswer(int questionNumber, List<Answer> answerList) {

        for (Answer answer : answerList) {
            String query = "insert into answers values(default,?,?,?)";
            try {
                PreparedStatement statement = JavaCon.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1,questionNumber);
                statement.setString(2, answer.getAnswer());
                statement.setBoolean(3, answer.isCorrect());
                int affectedRows = statement.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Creating field failed, no rows affected.");
                }
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        answer.setId(generatedKeys.getInt(1));
                    } else {
                        throw  new SQLException("Creating question failed, no ID obtained.");
                    }
                }
                System.out.println("Answer successfully inserted");
                if (affectedRows == 0) {
                    throw new SQLException("Creating field failed, no rows affected.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /*
        This method returns questions by topic
     */
    public List<Question> getQuestionByTopic(String topic) {
        List<Question> questionList = new ArrayList<>();
        Question question;
        String query = "select * from question where topic = ?";

        try {

            PreparedStatement statement = JavaCon.connection.prepareStatement(query);
            statement.setString(1, topic);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                question = new Question();
                question.setId(resultSet.getInt(1));
                question.setQuestion(resultSet.getString(2));
                question.setTopic(resultSet.getString(3));
                question.setDifficultyLevel(resultSet.getInt(4));
                question.setAnswers(questionAnswers(resultSet.getInt(1)));
                questionList.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questionList;
    }

    /*
        This method returns Answers to the requested questions
     */
    public List<Answer> questionAnswers(int questionId) {

        List<Answer> answerList = new ArrayList<>();
        String query = "select * from answers where question_id = ?";
        try {
            PreparedStatement statement = JavaCon.connection.prepareStatement(query);
            statement.setInt(1, questionId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                answerList.add(new Answer(resultSet.getString(3), resultSet.getBoolean(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answerList;
    }

    /*
        Deletes question by its id, also calls deleteAnswers() method to
        delete answers associated with this question
     */
    public void deleteQuestion(int questionId) {

        String query = "DELETE FROM question where id = ?";

        try {
            PreparedStatement statement = JavaCon.connection.prepareStatement(query);
            statement.setInt(1, questionId);
            statement.executeUpdate();
            deleteAnswers(questionId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
        Help deleteQuestion() method to delete all associated answers with the given question
     */
    private void deleteAnswers(int questionId) {

        String query = "DELETE FROM answers where question_id = ?";
        try {
            PreparedStatement statement = JavaCon.connection.prepareStatement(query);
            statement.setInt(1, questionId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /*
        This method updates question and answers to it.
     */
    public void updateQuestion(int questionId, Question question) {
        String query = "UPDATE question set question = ?, topic = ?, difficulty_level = ? WHERE id = ?";
        System.out.println(query);
        try {
            PreparedStatement statement = JavaCon.connection.prepareStatement(query);
            statement.setString(1, question.getQuestion());
            statement.setString(2,question.getTopic());
            statement.setInt(3, question.getDifficultyLevel());
            statement.setInt(4, questionId);
            statement.executeUpdate();
            deleteAnswers(questionId);
            addAnswer(questionId, question.getAnswers());
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
