package data;

import data.constants.*;

import java.util.Objects;

public class Student {

    // Constructor

    private int studentID;
    private String firstName;
    private String lastName;
    private Course course;
    private Sex sex;
    private String picture;
    private String email;
    private Disabilities disabilities;
    private String phoneNumber;
    private Year year;
    private Grades grades;
    private Group group;
    private String address;

    // With address (regular student)
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

    // No address (exchange student)
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentID == student.studentID && firstName.equals(student.firstName) && lastName.equals(student.lastName) && course == student.course && sex == student.sex && picture.equals(student.picture) && email.equals(student.email) && disabilities == student.disabilities && phoneNumber.equals(student.phoneNumber) && year == student.year && group == student.group && address.equals(student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, course, studentID, sex, picture, email, disabilities, phoneNumber, year, grades, group, address);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", course=" + course +
                ", studentID=" + studentID +
                ", sex=" + sex +
                ", picture='" + picture + '\'' +
                ", email='" + email + '\'' +
                ", disabilities=" + disabilities +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", year=" + year +
                ", grades=" + grades +
                ", group=" + group +
                ", address='" + address + '\'' +
                '}';
    }

}
