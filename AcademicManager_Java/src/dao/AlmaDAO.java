package dao;

import data.Alma;
import domain.Database;

import javax.swing.plaf.nimbus.State;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;

public class AlmaDAO {

    public ArrayList<Alma> getAll(){

        ArrayList<Alma> almaResults = new ArrayList<>();

        try{
            Connection conn = Database.connect();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM tblalma");
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                String alma = rs.getString("fldName");
                System.out.println(alma);
            }

            statement.close();
            conn.close();

        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        return almaResults;
    }

    public void searchOn(String parameter, String value){
        try{
            Connection conn = Database.connect();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM tblalma WHERE " + parameter + " = ?" );
            System.out.println(statement);
            statement.setString(1, value);
            ResultSet rs = statement.executeQuery();

            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            final int columnCount = resultSetMetaData.getColumnCount();

            while(rs.next()){
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


        }catch (Exception e){
            System.out.println(e.toString());
        };
    }

    public String getByID(int ID){

        String result = "NOT FOUND";

        try {
            Connection conn = Database.connect();

            PreparedStatement statement = conn.prepareStatement("SELECT fldAlmaID, fldName FROM tblalma WHERE fldAlmaID = ? ");
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


    public void save(Alma alma){

        try {
            Connection conn = Database.connect();

            PreparedStatement statement = conn.prepareStatement("INSERT INTO tblalma (fldName" +
                    "fldAddress" +
                    "fldNotes" +
                    "fldEmail" +
                    "fldPhoneNumber" +
                    "fldKey) " +
                    "values (?, ?, ?, ?, ? , ?)");

            System.out.println(statement);

            statement.setString(1, alma.getName());
            statement.setString(2, alma.getAddress());
            statement.setString(3, alma.getDescription());
            statement.setString(4, alma.getEmail());
            statement.setString(5, alma.getPhoneNumber());
            statement.setString(6, alma.getName() + alma.getPhoneNumber());

            System.out.println(statement);
            statement.executeUpdate();
            statement.close();

        } catch (Exception e){
            System.out.println(e.toString());
        }

    }

    public void delete(int almaID){
        try {
            Connection conn = Database.connect();

            PreparedStatement statement = conn.prepareStatement("DELETE FROM tblalma WHERE fldAlmaID = ?");
            statement.setInt(1, almaID);

            System.out.println(statement.toString());
            statement.executeUpdate();
            statement.close();

        } catch (Exception e){
            System.out.println(e.toString());
        }
    }


}
