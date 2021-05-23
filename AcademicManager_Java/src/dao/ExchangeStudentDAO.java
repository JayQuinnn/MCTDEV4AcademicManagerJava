package dao;

import data.ExchangeStudent;
import data.Lecturer;
import domain.Database;
import org.w3c.dom.CDATASection;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class ExchangeStudentDAO {

    //Get All Exchangestudents

    public ArrayList<ExchangeStudent> getAll(){

        ArrayList<ExchangeStudent> exchangeStudentResults = new ArrayList<>();

        try{
            Connection conn = Database.connect();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM tblstudentexchange");
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                String exchangeStudent = rs.getString("fldName");
                System.out.println(exchangeStudent);
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }

        return exchangeStudentResults;
    }

    //Search with parameter

    public void searchOn(String parameter, String value){

        try{
            Connection conn = Database.connect();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM tblstudentexchange WHERE" + parameter + " = ?");
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
                                "_______________________________");
            }
            statement.close();

        }catch (Exception e){
            System.out.println(e.toString());
        }

    }




    public String getBYID(int ID){

        String result = "NOT FOUND";

        try{
            Connection conn = Database.connect();

            PreparedStatement statement = conn.prepareStatement("SELECT fldStudentExchangeID, fldName, fldLastName FROM tblstudentexchange WHERE fldStudentExchangeID = ? ");
            statement.setInt(1, ID);
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                result = rs.getString(1);
            }

        } catch (Exception e){
            System.out.println(e.toString());
        }

        return result;
    }

    public void save(ExchangeStudent exchangeStudent){

        try {
            Connection conn = Database.connect();

            PreparedStatement statement = conn.prepareStatement("INSERT INTO tbllecturer " +
                    "(fldName, " +
                    "fldLastName, " +
                    "fldCourse, " +
                    "fldGender, " +
                    "fldPicture, " +
                    "fldEmail, " +
                    "fldDisabilities, " +
                    "fldPhoneNumber, " +
                    "fldYear, " +
                    "fldNationality, " +
                    "fldAlmaID, " +
                    "fldDormID, " +
                    "fldMotivationalLetter, " +
                    "fldStay) " +
                    "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            System.out.println(statement);

            statement.setString(1, exchangeStudent.getFirstName());
            statement.setString(2, exchangeStudent.getLastName());
            statement.setString(3, exchangeStudent.getCourse().toString());
            statement.setString(4, exchangeStudent.getSex().toString());
            statement.setString(5, exchangeStudent.getPicture());
            statement.setString(6, exchangeStudent.getEmail());
            statement.setString(7, exchangeStudent.getDisabilities().toString());
            statement.setString(8, exchangeStudent.getPhoneNumber());
            statement.setString(9, exchangeStudent.getYear().toString());
            statement.setString(10, exchangeStudent.getGroup().toString());
            statement.setString(11, exchangeStudent.getNationality().toString());
            statement.setString(12, exchangeStudent.getAlma().toString());
            statement.setString(13, exchangeStudent.getDorm().toString());
            statement.setString(14, exchangeStudent.getMotivationalLetter().toString());
            statement.setString(15, exchangeStudent.getDurationOfStay().toString());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e){
            System.out.println(e.toString());
        }


    }

    public void delete(int exchangeStudentID){
        try{
            Connection conn = Database.connect();

            PreparedStatement statement = conn.prepareStatement("DELETE FROM tblstudentexchange WHERE fldStudentExchangeID = ?");
            statement.setInt(1, exchangeStudentID);

            System.out.println(statement);

            statement.executeUpdate();
            statement.close();

        }

        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void update(int exchangeStudentID, ExchangeStudent exchangeStudent){

        try {
            Connection conn = Database.connect();

            PreparedStatement statement = conn.prepareStatement("UPDATE tblstudentexchange " +
                    "SET fldName=?" +
                    "fldLastName=?" +
                    "fldCourse=?" +
                    "fldGender=?" +
                    "fldPicture=?" +
                    "fldEmail=?" +
                    "fldDisabilities =?" +
                    "fldPhoneNumber=?" +
                    "fldYear=?" +
                    "fldGroup=?" +
                    "fldNationality=?" +
                    "fldAlmaID=?" +
                    "fldDormID=?" +
                    "fldMotivationalLetter=?" +
                    "fldStay=?" +
                    "WHERE fldStudentExchangeID=" + exchangeStudentID);

            System.out.println(statement);

            statement.executeUpdate();
            statement.close();


        } catch (Exception e){
            System.out.println(e.toString());
        }

        }
    }


