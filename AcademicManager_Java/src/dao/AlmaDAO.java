package dao;

import data.Alma;
import domain.Database;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
