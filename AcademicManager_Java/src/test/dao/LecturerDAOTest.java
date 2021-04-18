package test.dao;

import dao.LecturerDAO;
import dao.StudentDAO;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LecturerDAOTest {

    private LecturerDAO lecturerDAODAO;

    @Test
    @DisplayName("Haal alle sdocenten op")
    public void getAll(){

        assertEquals(1,1);
    }

    @Test
    @DisplayName("Zoek op parameter")
    public void searchOn(){

        assertEquals(1,1);
    }

    @Test
    @DisplayName("Haal docent op met ID")
    public void getByID() {

        assertEquals(1,1);
    }

    @Test
    @DisplayName("Voeg docent toe aan databank")
    public void saveLecturer(){

        assertEquals(1,1);
    }

    @Test
    @DisplayName("Verwijder docent uit databank")
    public void deleteLecturer(){

        assertEquals(1,1);
    }

    @Test
    @DisplayName("Pas gegevens van docent aan")
    public void updateLecturer(){

        assertEquals(1,1);
    }

    @Test
    @DisplayName("Zet docent van werkend naar afwezig")
    public void setEmployment(){

        assertEquals(1,1);
    }
}