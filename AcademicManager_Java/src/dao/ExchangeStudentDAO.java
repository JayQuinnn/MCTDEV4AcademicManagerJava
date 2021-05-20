package dao;

import data.ExchangeStudent;
import domain.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class ExchangeStudentDAO {

    //Get All Exchangestudents

    //Search with parameter

    //GetByID

    //Save

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

        //Delete

        //Update

    }


}
