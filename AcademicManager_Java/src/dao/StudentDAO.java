package dao;
import data.Student;
import data.Year;
import data.Group;
import domain.Database;

import java.sql.*;

public class StudentDAO {



    public void getAll(){
        try{
            Connection conn = Database.connect();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM tblstudent");
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                String student = rs.getString("fldName");
                System.out.println(student);
            }

            statement.close();
            conn.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void searchOn(String parameter, String value){
        try{
            Connection conn = Database.connect();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM tblstudent WHERE " + parameter + " = ?");
            statement.setString(1, value);
            ResultSet rs = statement.executeQuery();

            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            final int columnCount = resultSetMetaData.getColumnCount();


            while (rs.next()){
                Object[] values = new Object[columnCount];

                for (int i = 1; i < columnCount; i++){
                    values[i - 1] = rs.getString(i);
                    System.out.println(rs.getString(i));
                }
                System.out.println("Result is " + values[1] + " " + values[2]);
            }
            statement.close();
            conn.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void save (Student student){

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

    public void delete (int studentID){

        try {
            Connection conn = Database.connect();

            PreparedStatement statement = conn.prepareStatement("DELETE FROM tblstudent WHERE fldstudentid = ?");
            statement.setInt(1, studentID);

            System.out.println(statement.toString());
            statement.executeUpdate();
            statement.close();
            conn.close();

        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void update(int studentID, Student student){
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

            System.out.println("Updating");
            System.out.println(statement);

            statement.executeUpdate();
            statement.close();
            conn.close();

        } catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
