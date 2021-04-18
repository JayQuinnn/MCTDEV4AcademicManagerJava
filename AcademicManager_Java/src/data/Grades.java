package data;

import data.constants.Subject;

public class Grades {
    private int score;
    private Subject subject;

    // CONSTRUCTOR

    public Grades(int score, Subject subject){
        this.score = score;
        this.subject = subject;
    }



    // GETTERS & SETTERS

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
