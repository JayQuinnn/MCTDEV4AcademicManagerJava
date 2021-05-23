package data.library;

import data.Lecturer;
import data.Student;
import data.Dorm;
import data.constants.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResultSetConverter {

    public ResultSetConverter() {

    }

    // STUDENTS

    public ArrayList<Student> convertRSToStudents(ResultSet rs) {

        ArrayList<Student> studentList = new ArrayList<>();

        try {
            while (rs.next()) {
                Student student = new Student(
                        rs.getString("fldName"),
                        rs.getString("fldLastName"),
                        Course.valueOf(rs.getString("fldCourse")),
                        Sex.valueOf(rs.getString("fldGender")),
                        rs.getString("fldPicture"),
                        rs.getString("fldEmail"),
                        Disabilities.valueOf(rs.getString("fldDisabilities")),
                        rs.getString("fldPhoneNumber"),
                        Year.valueOf(rs.getString("fldYear")),
                        Group.valueOf(rs.getString("fldGroup")),
                        rs.getString("fldAddress"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;


    }

    // LECTURERS

    public ArrayList<Lecturer> convertRSToLecturers(ResultSet rs) {

        ArrayList<Lecturer> lecturerList = new ArrayList<>();

        try {
            while (rs.next()) {
                Lecturer lecturer = new Lecturer(
                        rs.getString("fldName"),
                        rs.getString("fldLastName"),
                        rs.getString("fldPhoneNumber"),
                        rs.getString("fldPaygrade"),
                        Paygrade.valueOf(rs.getString("fldPaygrade")));
                lecturerList.add(lecturer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lecturerList;

    }

    // DORMS
/**
    public ArrayList<Dorm> convertRStoDorms(ResultSet rs) {

        ArrayList<Dorm> dormList = new ArrayList<>();

        try {
            while (rs.next()) {
                Dorm dorm = new Dorm(
                        rs.getString("fldName"),
                        rs.getString("fldAddress"),
                        rs.getString("fldNotes"),
                        rs.getString("fldEmail"),
                        rs.getString("fldPhoneNumber"));
                dormList.add(dorm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dormList;

    } **/
}