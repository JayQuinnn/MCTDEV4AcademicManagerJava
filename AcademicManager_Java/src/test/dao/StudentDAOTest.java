package test.dao;

import dao.StudentDAO;
import data.*;
import data.constants.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class StudentDAOTest {

    private StudentDAO studentDAO;
    private Student testStudent;
    private int testID;

    //INITIATE

    @BeforeEach
    public void before(){
        studentDAO = new StudentDAO();
        testStudent = new Student("Testpersoon", "Van Test", Course.COMMA, Sex.MALE, "TestFoto","test@test.be", Disabilities.NONE, "0123456789", Year.FLEX, Group.A, "Testadres");
        testID = studentDAO.save(testStudent);
    }

    @AfterEach
    public void after(){
        studentDAO.delete(testStudent.getStudentID());
    }

    //TESTS

    @Test
    @DisplayName("Voeg student toe aan databank")
    public void saveStudent(){

        testID = studentDAO.save(testStudent);
        Student toegevoegdeStudent = studentDAO.getByID(testID);
        Assert.assertEquals(testStudent, toegevoegdeStudent);
    }

    @Test
    @DisplayName("Haal alle studenten op")
    public void getAll(){
        ArrayList<Student> alleStudenten = studentDAO.getAll();
        Assert.assertTrue(alleStudenten.size() > 1);
    }


    @Test
    @DisplayName("Zoek op parameter")
    public void searchOn(){
        ArrayList<Student> gezochteStudenten = studentDAO.searchOn("fldstudentid", String.valueOf(testID));
        Assert.assertEquals(testStudent, gezochteStudenten.get(0) );
    }

    @Test
    @DisplayName("Haal student op met ID")
    public void getByIDTest() {
        Student gezochteStudent = studentDAO.getByID(testID);
        System.out.println(gezochteStudent);
        Assert.assertEquals(gezochteStudent, testStudent);
    }

    @Test
    @DisplayName("Verwijder student uit databank")
    public void deleteStudent(){
        testID = studentDAO.save(testStudent);
        Assert.assertNotNull(studentDAO.getByID(testID));
        studentDAO.delete(testID);
        Assert.assertNull(studentDAO.getByID(testID));
    }

    @Test
    @DisplayName("Pas gegevens van student aan")
    public void updateStudent(){
        Student aangepasteTestStudent = testStudent;
        aangepasteTestStudent.setFirstName("Testing");
        studentDAO.update(testID, aangepasteTestStudent);
        Student updateStudent = studentDAO.getByID(testID);
        Assert.assertEquals(updateStudent, aangepasteTestStudent);
    }
}