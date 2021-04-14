package ui;
import java.awt.*;
import java.sql.Statement;
import java.sql.ResultSet;

import dao.StudentDAO;
import data.*;
import domain.Database;

import java.sql.Connection;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        System.out.println("hello");


        Student wouter = new Student("Wouter", "Boozeleer", Course.MCT, Sex.MALE, "Wouterpicture", "Wouter@ehb.be", Disabilities.DYSLEXIA, "124345646", Year.THREE, Group.A, "Address");

        StudentDAO studentDAO = new StudentDAO();
        //studentDAO.save(wouter);
        //studentDAO.searchOn("fldName", "Wouter");
        //studentDAO.save(wouter);
        studentDAO.update(1, wouter);


    }
}
