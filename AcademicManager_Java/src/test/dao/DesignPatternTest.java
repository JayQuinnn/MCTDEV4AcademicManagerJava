package test.dao;


import data.Lecturer;
import data.constants.Paygrade;
import data.strategy.*;
import domain.Database;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.sql.Connection;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DesignPatternTest {

    @Test
    @DisplayName("TEST SINGLETON")
    public void singletonTest(){
        Connection connectie1 = Database.connect();
        Connection connectie2 = Database.connect();
        Assert.assertSame(connectie1, connectie2);
    }

    @Test
    @DisplayName("TEST STATE")
    public void stateTest(){
        Lecturer lecturer = new Lecturer(
                "Test",
                "Van Test",
                "Test@test.be",
                "012345789",
                Paygrade.A);
        Assert.assertEquals(lecturer.getEmploymentStatus().toString(), "Is currently teaching");
        lecturer.toggleEmployment();
        Assert.assertEquals(lecturer.getEmploymentStatus().toString(), "Is on administrative/sick leave");
    }

    @Test
    @DisplayName("STRATEGY TEST")
    public void strategyTest(){
        int test[] = {17,5,19,103,2};
        int laagNaarHoog[] = {2,5,17,19,103};
        int hoogNaarLaag[] = {103,19,17,5,2};

        SortStrategy quickSorter = new DescendingSortStrategy();
        quickSorter.sort(test);
        System.out.println(Arrays.toString(test));
        Assert.assertArrayEquals(hoogNaarLaag, test);

        quickSorter = new AscendingSortStrategy();
        quickSorter.sort(test);
        System.out.println(Arrays.toString(test));
        Assert.assertArrayEquals(laagNaarHoog, test);
    }
}
