package dao;

import data.*;
import data.library.ResultSetConverter;
import domain.Database;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {

private ResultSetConverter resultSetConverter = new ResultSetConverter();


    public ArrayList<Student> getAll() {

        ArrayList<Student> studentResults = new ArrayList<Student>();

        try {
            Connection conn = Database.connect();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM tblstudent");
            ResultSet rs = statement.executeQuery();
            studentResults = resultSetConverter.convertRSToStudents(rs);
            statement.close();
            //conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return studentResults;
    }


    public ArrayList<Student> searchOn(String parameter, String value) {

        ArrayList<Student> studentResults = new ArrayList<Student>();

        try {
            Connection conn = Database.connect();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM tblstudent WHERE " + parameter + " = ?");
            statement.setString(1, value);
            ResultSet rs = statement.executeQuery();
            studentResults = resultSetConverter.convertRSToStudents(rs);
            statement.close();
            //conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return studentResults;
    }

    public Student getByID(int ID) {

        Student result = null;

        try {
            Connection conn = Database.connect();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM tblstudent WHERE fldstudentid = ?");
            statement.setInt(1, ID);
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            result = resultSetConverter.convertRSToStudents(rs).get(0);
            }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }


    public int save(Student student) {
        int key = 0;

        try {
            Connection conn = Database.connect();

            PreparedStatement statement = conn.prepareStatement("INSERT INTO tblstudent (fldName, fldLastName, fldCourse, fldGender, fldPicture, fldEmail, fldDisabilities, fldPhoneNumber, fldYear, fldGroup,fldAddress) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getCourse().toString());
            statement.setString(4, student.getSex().toString());
            statement.setString(5, student.getPicture());
            statement.setString(6, student.getEmail());
            statement.setString(7, student.getDisabilities().toString());
            statement.setString(8, student.getPhoneNumber());
            statement.setString(9, student.getYear().toString());
            statement.setString(10, student.getGroup().toString());
            statement.setString(11, student.getAddress());

            System.out.println(statement.toString());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();

            while(generatedKeys.next()){
                key = generatedKeys.getInt(1);
            }

            statement.close();
            //conn.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return key;
    }

    public void delete(int studentID) {

        try {
            Connection conn = Database.connect();

            PreparedStatement statement = conn.prepareStatement("DELETE FROM tblstudent WHERE fldstudentid = ?");
            statement.setInt(1, studentID);

            System.out.println(statement.toString());
            statement.executeUpdate();
            statement.close();
            //conn.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void update(int studentID, Student student) {
        try {
            Connection conn = Database.connect();

            PreparedStatement statement = conn.prepareStatement("UPDATE tblstudent SET fldName=?, fldLastName=?, fldCourse=?, fldGender=?, fldPicture=?, fldEmail=?, fldDisabilities=?, fldPhoneNumber=?, fldYear=?, fldGroup=?, fldAddress=? WHERE fldstudentid=" + studentID);
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getCourse().toString());
            statement.setString(4, student.getSex().toString());
            statement.setString(5, student.getPicture());
            statement.setString(6, student.getEmail());
            statement.setString(7, student.getDisabilities().toString());
            statement.setString(8, student.getPhoneNumber());
            statement.setString(9, student.getYear().toString());
            statement.setString(10, student.getGroup().toString());
            statement.setString(11, student.getAddress());

            statement.executeUpdate();
            statement.close();
            //conn.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }



}




