package ru.job4j.inheritance;

public class Builder extends Engineer {
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Builder(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Builder(int score, String design) {
        super();
        this.score = score;
    }
}
