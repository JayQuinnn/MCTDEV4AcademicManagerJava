package dao;

import data.*;
import data.constants.*;
import domain.Database;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {




    public ArrayList<Student> getAll() {

        ArrayList<Student> studentResults = new ArrayList<Student>();
        Student result;

        try {
            Connection conn = Database.connect();

            PreparedStatement statement = conn.prepareStatement("SELECT * FROM tblstudent");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {


                String student = rs.getString("fldName");
                System.out.println(student);

            }
            statement.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return studentResults;
    }


    public void searchOn(String parameter, String value) {
        try {
            Connection conn = Database.connect();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM tblstudent WHERE " + parameter + " = ?");
            statement.setString(1, value);
            ResultSet rs = statement.executeQuery();

            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            final int columnCount = resultSetMetaData.getColumnCount();


            while (rs.next()) {
                Object[] values = new Object[columnCount];

                for (int i = 1; i < columnCount; i++) {
                    values[i - 1] = rs.getString(i);
                }
                System.out.println("_______________________________" + "\n" +
                        "---" + values[1] + " " + values[2] + "---" + "\n" +
                        "Name: " + values[1] + "\n" +
                        "Last Name: " + values[2] + "\n" +
                        "Course: " + values[3] + "\n" +
                        "Gender: " + values[4] + "\n" +
                        "Picture: " + values[5] + "\n" +
                        "Email: " + values[6] + "\n" +
                        "Disabilities: " + values[7] + "\n" +
                        "Phonenumber: " + values[8] + "\n" +
                        "Year: " + values[9] + "\n" +
                        "Group: " + values[10] + "\n" +
                        "Address: " + values[11] + "\n" +
                        "_______________________________");
            }
            statement.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public Student getByID(int ID) {

        Student result = null;

        try {
            Connection conn = Database.connect();

            PreparedStatement statement = conn.prepareStatement("SELECT * FROM tblstudent WHERE fldstudentid = ?");
            statement.setInt(1, ID);
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result = new Student(
                        rs.getString(2),
                        rs.getString(3),
                        Course.valueOf(rs.getString(4)),
                        Sex.valueOf(rs.getString(5)),
                        rs.getString(6),
                        rs.getString(7),
                        Disabilities.valueOf(rs.getString(8)),
                        rs.getString(9),
                        Year.valueOf(rs.getString(10)),
                        Group.valueOf(rs.getString(11)));

                System.out.println(result);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    public void save(Student student) {

        try {
            Connection conn = Database.connect();

            PreparedStatement statement = conn.prepareStatement("INSERT INTO tblstudent (fldName, fldLastName, fldCourse, fldGender, fldPicture, fldEmail, fldDisabilities, fldPhoneNumber, fldYear, fldGroup,fldAddress) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
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
            statement.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void delete(int studentID) {

        try {
            Connection conn = Database.connect();

            PreparedStatement statement = conn.prepareStatement("DELETE FROM tblstudent WHERE fldstudentid = ?");
            statement.setInt(1, studentID);

            System.out.println(statement.toString());
            statement.executeUpdate();
            statement.close();
            conn.close();

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
            conn.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }



}




