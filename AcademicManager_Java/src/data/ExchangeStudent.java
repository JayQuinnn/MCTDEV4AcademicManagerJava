package data;

import java.util.Date;

public class ExchangeStudent extends Student {
    private Nationality nationality;
    private Alma alma;
    private Date durationOfStay;
    private Dorm dorm;
    private MotivationalLetter motivationalLetter;

    public ExchangeStudent(String firstName, String lastName, Course course, int studentID, Sex sex, String picture, String email, Disabilities disabilities, String phoneNumber, Year year, Grades grades, Group group, Nationality nationality, Alma alma, Date durationOfStay, Dorm dorm, MotivationalLetter motivationalLetter){

        super(firstName, lastName, course, studentID, sex, picture, email, disabilities, phoneNumber, year, grades, group);

        this.nationality = nationality;
        this.alma = alma;
        this.durationOfStay = durationOfStay;
        this.dorm = dorm;
        this.motivationalLetter = motivationalLetter;

    }

    // GETTERS & SETTERS


    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Alma getAlma() {
        return alma;
    }

    public void setAlma(Alma alma) {
        this.alma = alma;
    }

    public Date getDurationOfStay() {
        return durationOfStay;
    }

    public void setDurationOfStay(Date durationOfStay) {
        this.durationOfStay = durationOfStay;
    }

    public Dorm getDorm() {
        return dorm;
    }

    public void setDorm(Dorm dorm) {
        this.dorm = dorm;
    }

    public MotivationalLetter getMotivationalLetter() {
        return motivationalLetter;
    }

    public void setMotivationalLetter(MotivationalLetter motivationalLetter) {
        this.motivationalLetter = motivationalLetter;
    }


}
