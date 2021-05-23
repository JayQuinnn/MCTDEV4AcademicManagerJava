package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import data.*;
import domain.Database;

import javax.xml.crypto.Data;

public class DormDAO {

    public ArrayList<Dorm> getAll(){

        ArrayList<Dorm> dormResults = new ArrayList<>();

        try{
            Connection conn = Database.connect();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM tbldorm");

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                String dorm = rs.getString("fldName");
                System.out.println(dorm);
            }

        } catch (Exception e){
            System.out.println(e.toString());
        }

        return dormResults;
    }

    public void update(int dormID, Dorm dorm){
        try{
            Connection conn = Database.connect();

            PreparedStatement statement = conn.prepareStatement("UPDATE tbldorm " +
                    "SET fldBuilding =?, " +
                    "fldFloor= ?, " +
                    "fldRoom=?, " +
                    "WHERE fldDormID = " + dormID);
            statement.setString(1, dorm.getBuilding().toString());
            statement.setInt(2, dorm.getFloor());
            statement.setInt(3, dorm.getRoom());

            statement.executeUpdate();
            statement.close();


        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void delete (int dormID){

        try {
            Connection conn = Database.connect();

            PreparedStatement statement = conn.prepareStatement("DELETE FROM tbldorm WHERE fldDormID = ?");
            statement.setInt(1, dormID);

            System.out.println(statement.toString());
            statement.executeUpdate();
            statement.close();
            conn.close();

        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

}
