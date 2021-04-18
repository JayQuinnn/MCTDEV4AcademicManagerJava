package test.dao;

import dao.StudentDAO;
import data.*;
import data.constants.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentDAOTest {

    private StudentDAO studentDAO;
    private Student testStudent;
    private int testID = 999;

    //INITIATE

    @BeforeEach
    public void init(){
        studentDAO = new StudentDAO();
        testStudent = new Student("Testpersoon", "Van Test", Course.COMMA, Sex.MALE, "TestFoto","test@test.be", Disabilities.NONE, "0123456789", Year.FLEX, Group.A, "Testadres");
    }

    //TESTS

    @Test
    @DisplayName("Haal alle studenten op")
    public void getAll(){
        studentDAO.getAll();
    }

    @Test
    @DisplayName("Zoek op parameter")
    public void searchOn(){
        studentDAO.searchOn("tblName", "Wouter");
    }

    @Test
    @DisplayName("Haal student op met ID")
    public void getByIDTest() {
        studentDAO.getByID(2);
    }

    @Test
    @DisplayName("Voeg student toe aan databank")
        public void saveStudent(){
        studentDAO.save(testStudent);
    }

    @Test
    @DisplayName("Verwijder student uit databank")
    public void deleteStudent(){
        studentDAO.delete(testID);
    }

    @Test
    @DisplayName("Pas gegevens van student aan")
    public void updateStudent(){
    }
}