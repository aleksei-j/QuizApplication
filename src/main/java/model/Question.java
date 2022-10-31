package model;

import java.util.List;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "model.Question id: " + this.getId() + " " + this.getQuestion()+ " Topic of this question is: " +
                this.getTopic() + ". Difficulty of this question is: " + this.getDifficultyLevel() + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return getId() == question1.getId() && getDifficultyLevel() == question1.getDifficultyLevel() && getQuestion().equals(question1.getQuestion()) && getTopic().equals(question1.getTopic()) && getAnswers().equals(question1.getAnswers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getQuestion(), getTopic(), getDifficultyLevel(), getAnswers());
    }
}
