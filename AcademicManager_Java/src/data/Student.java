package data;

public class Student {

    // Constructor

    private String firstName;
    private String lastName;
    private Course course;
    private int studentID;
    private Sex sex;
    private String picture;
    private String email;
    private Disabilities disabilities;
    private String phoneNumber;
    private Year year;
    private Grades grades;
    private Group group;
    private String address;


    public Student(String firstName, String lastName, Course course, Sex sex, String picture, String email, Disabilities disabilities, String phoneNumber, Year year, Group group, String address) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.sex = sex;
        this.picture = picture;
        this.email = email;
        this.disabilities = disabilities;
        this.phoneNumber = phoneNumber;
        this.year = year;
        this.group = group;
        this.address = address;

    }

    public Student(String firstName, String lastName, Course course, Sex sex, String picture, String email, Disabilities disabilities, String phoneNumber, Year year, Group group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.sex = sex;
        this.picture = picture;
        this.email = email;
        this.disabilities = disabilities;
        this.phoneNumber = phoneNumber;
        this.year = year;
        this.group = group;
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    // Getters & Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Disabilities getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(Disabilities disabilities) {
        this.disabilities = disabilities;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Grades getGrade() {
        return grades;
    }

    public void setGrade(Grades grade) {
        this.grades = grade;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return this.getFirstName();
    }

}
