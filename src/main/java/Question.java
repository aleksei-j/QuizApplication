import java.util.List;

public class Question {

    private int id;
    private String question;
    private String topic;
    private int difficultyLevel;
    private List<Answer> answers;

    public Question() {
    }

    public Question(String question, List<Answer> answers, String topic, int difficultyLevel) {
        this.question = question;
        this.answers = answers;
        this.topic = topic;
        this.difficultyLevel = difficultyLevel;
    }

    public Question(int id, String question, List<Answer> answers, String topic, int difficultyLevel) {
        super();
        this.id = id;
        this.question = question;
        this.answers = answers;
        this.topic = topic;
        this.difficultyLevel = difficultyLevel;
    }

    public double getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}
