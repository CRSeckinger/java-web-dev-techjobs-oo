package org.launchcode.techjobs_oo.tests;

import org.junit.Before;
import org.junit.Test;

import org.launchcode.techjobs_oo.*;

import java.net.StandardSocketOptions;
import java.sql.SQLOutput;

import static org.junit.Assert.*;


public class JobTest {
    private Job testJobOne;
    private Job testJobTwo;
    private Job jobTest;
    private Job jobTestTwo;
    private Job jobTestThree;
    @Before
    public void makeJob() {
        testJobOne = new Job();
        testJobTwo = new Job();
        jobTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobTestTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobTestThree = new Job("Product tester", new Employer("ACME"), new Location(), new PositionType("Quality control"), new CoreCompetency());
    }


    @Test //test empty constructor that both jobs are not equal and differ by 1;
    public void testSettingJobId () {
        assertFalse(testJobOne.equals(testJobTwo));
        assertEquals(testJobOne.getId(),testJobTwo.getId()-1);
    }

    @Test //test full constructor
    public void testJobConstructorSetAllFields () {
        assertTrue(jobTest.getName().equals("Product tester"));
        assertEquals(jobTest.getEmployer().toString(), "ACME");
        assertEquals(jobTest.getLocation().toString(), "Desert");
        assertEquals(jobTest.getPositionType().toString(), "Quality control");
        assertEquals(jobTest.getCoreCompetency().toString(), "Persistence");
    }

    @Test //test equals method
    public void testJobsForEquality () {
        assertFalse(jobTest.equals(jobTestTwo));
    }

    @Test //creating toString (first and last char are same)
    public void testToString () {
       assertEquals(jobTest.toString().charAt(jobTest.toString().length()-1), jobTest.toString().charAt(0));
       assertEquals(jobTest.toString(), "\n\n ID: " + jobTest.getId() +"\n Name: Product tester\n Employer: ACME\n Location: Desert\n Position Type: Quality control\n Core Competency: Persistence\n");
       assertEquals(jobTestThree.toString(), "\n\n ID: " + jobTestThree.getId() +"\n Name: Product tester\n Employer: ACME\n Location: Data not available\n Position Type: Quality control\n Core Competency: Data not available\n");
    }

}
