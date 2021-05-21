package dao;

import data.Lecturer;
import data.state.TeachingState;
import domain.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class LecturerDAO {

    public ArrayList<Lecturer> getAll(){

        ArrayList<Lecturer> lecturerResults = new ArrayList<>();

        try{
            Connection conn = Database.connect();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM tbllecturer");
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                String lecturer = rs.getString("fldName");
                System.out.println(lecturer);
            }

            statement.close();
            conn.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        return lecturerResults;
    }

    public void searchOn(String parameter, String value){
        try{
            Connection conn = Database.connect();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM tbllecturer WHERE " + parameter + " = ?");
            System.out.println(statement);
            statement.setString(1, value);
            ResultSet rs = statement.executeQuery();

            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            final int columnCount = resultSetMetaData.getColumnCount();


            while (rs.next()){
                Object[] values = new Object[columnCount];

                for (int i = 1; i < columnCount; i++){
                    values[i - 1] = rs.getString(i);
                }
                System.out.println(
                        "_______________________________" + "\n" +
                        "---" + values[1] + " " + values[2] + "---" + "\n" +
                        "Name: " +  values[1] + "\n" +
                        "Last Name: "+ values[2] + "\n" +
                        "Email: "+ values[3] + "\n" +
                        "Phonenumber: "+ values[4] + "\n" +
                        "Paygrade: "+ values[5] + "\n" +
                        "EmploymentStatus: "+ values[6] + "\n" +
                        "_______________________________");
            }
            statement.close();
            conn.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public String getByID(int ID){

        String result = "NOT FOUND";

        try {
            Connection conn = Database.connect();

            PreparedStatement statement = conn.prepareStatement("SELECT fldlecturerID, fldName,  fldLastName FROM tbllecturer WHERE fldlecturerID = ?");
            statement.setInt(1, ID);
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                result = rs.getString(1);
            }


        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

        return result;
    }


    public void save (Lecturer lecturer){

        try {
            Connection conn = Database.connect();

            PreparedStatement statement = conn.prepareStatement("INSERT INTO tbllecturer (fldName, " +
                    "fldLastName, " +
                    "fldEmail, " +
                    "fldPhoneNumber, " +
                    "fldPaygrade, " +
                    "fldEmploymentStatus, " +
                    "fldKey) " +
                    "values (?, ?, ?, ?, ?, ?, ?)");
            System.out.println(statement);

            statement.setString(1, lecturer.getName());
            statement.setString(2, lecturer.getLastName());
            statement.setString(3, lecturer.getEmail());
            statement.setString(4, lecturer.getPhoneNumber());
            statement.setString(5, lecturer.getPaygrade().toString());
            statement.setString(6, lecturer.getEmploymentStatus().toString());
            statement.setString(7, (lecturer.getLastName() + lecturer.getEmail()));

            System.out.println(statement.toString());
            statement.executeUpdate();
            statement.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void delete (int lecturerID){

        try {
            Connection conn = Database.connect();

            PreparedStatement statement = conn.prepareStatement("DELETE FROM tbllecturer WHERE fldlecturerID = ?");
            statement.setInt(1, lecturerID);

            System.out.println(statement.toString());
            statement.executeUpdate();
            statement.close();
            conn.close();

        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void update(int lecturerID, Lecturer lecturer){
        try {
            Connection conn = Database.connect();

            PreparedStatement statement = conn.prepareStatement("UPDATE tbllecturer " +
                    "SET fldName=?, " +
                    "fldLastName=?, " +
                    "fldEmail=?, " +
                    "fldPhoneNumber=?, " +
                    "fldPaygrade=?, " +
                    "fldEmploymentStatus=? " +
                    "WHERE fldlecturerID=" + lecturerID);
            statement.setString(1, lecturer.getName());
            statement.setString(2, lecturer.getLastName());
            statement.setString(3, lecturer.getEmail());
            statement.setString(4, lecturer.getPhoneNumber().toString());
            statement.setString(5, lecturer.getPaygrade().toString());

            TeachingState teachingState = new TeachingState();
            teachingState.changeEmployment(lecturer);

            statement.setString(6, lecturer.getEmploymentStatus().toString());

            System.out.println("Updating");
            System.out.println(statement);

            statement.executeUpdate();
            statement.close();
            //conn.close();

        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

}
