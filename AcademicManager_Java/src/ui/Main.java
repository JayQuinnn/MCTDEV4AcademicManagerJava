package ui;

import dao.LecturerDAO;
import dao.StudentDAO;
import data.*;
import data.constants.*;
import data.state.OnLeaveState;
import data.state.TeachingState;

public class Main {

    public static void main(String[] args){
        System.out.println("hello");


        Student wouter = new Student("Wouter", "Boozeleer", Course.MCT, Sex.MALE, "Wouterpicture", "Wouter@ehb.be", Disabilities.DYSLEXIA, "124345646", Year.THREE, Group.A, "Address");
        Lecturer jochem = new Lecturer("Jochem", "Flap", "Jochem@vub.be", "546465465", Paygrade.A);

        StudentDAO studentDAO = new StudentDAO();
        LecturerDAO lecturerDAO = new LecturerDAO();


        TeachingState teachingState = new TeachingState();
        OnLeaveState onleave = new OnLeaveState();

        //onleave.changeEmployment(jochem);

        //studentDAO.save(wouter);
        //studentDAO.searchOn("fldName", "Wouter");
        //studentDAO.save(wouter);
        //studentDAO.update(1, wouter);
        //studentDAO.getByID(2);
        System.out.println("result is" + studentDAO.getByID(2));

        //lecturerDAO.save(jochem);
        //lecturerDAO.searchOn("fldName", "Jochem");
        //lecturerDAO.delete(1);
        //lecturerDAO.getAll();
        //lecturerDAO.getByID(3);
        //System.out.println(lecturerDAO.getByID(3));
        //lecturerDAO.update(3, jochem);


    }
}
