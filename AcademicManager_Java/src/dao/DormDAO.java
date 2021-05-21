package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import data.*;
import domain.Database;

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

}
