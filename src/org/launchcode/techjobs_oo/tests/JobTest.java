package org.launchcode.techjobs_oo.tests;

import org.junit.Before;
import org.junit.Test;

import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;


public class JobTest {
    private Job testJobOne;
    private Job testJobTwo;
    private Job jobTest;
    private Job jobTestTwo;
    @Before
    public void makeJob() {
        testJobOne = new Job();
        testJobTwo = new Job();
        jobTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobTestTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
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

}
