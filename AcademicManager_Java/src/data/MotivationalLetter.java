package data;

public class MotivationalLetter {

    // CONSTRUCTOR

    private String subject;
    private String letterContent;

    public MotivationalLetter(String subject, String letterContent){

        this.subject = subject;
        this.letterContent = letterContent;

    }

    // GETTERS & SETTERS


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
