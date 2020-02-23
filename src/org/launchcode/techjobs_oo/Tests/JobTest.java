package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;


public class JobTest {
    Job firstJob;
    Job secondJob;
    Job job;

    @Before
    public void createJobs() {
        firstJob = new Job();
        secondJob = new Job();
        job = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
    };


    @Test
    public void testSettingJobId(){
        assertFalse(firstJob.equals(secondJob));
        assertTrue(secondJob.getId() - firstJob.getId() == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(job instanceof Job);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(job.getName() == "Product tester");
        assertTrue(job.getEmployer().getValue() == "ACME");
        assertTrue(job.getLocation().getValue() == "Desert");
        assertTrue(job.getPositionType().getValue() == "Quality control");
        assertTrue(job.getCoreCompetency().getValue() == "Persistence");
        assertTrue(job.getId() - secondJob.getId() == 1);
    }

    @Test
    public void testJobsForEquality(){
        Job testOne = new Job("Project management", new Employer("TSH"),
                new Location("STL"), new PositionType("Senior management"),
                new CoreCompetency("Java"));
        Job testTwo = new Job("Project management", new Employer("TSH"),
                new Location("STL"), new PositionType("Senior management"),
                new CoreCompetency("Java"));
        assertFalse(testOne.equals(testTwo));
    }

    @Test
    public void toStringShouldContainBlankLineBeforeAndAfter(){
        assertTrue(job.toString().startsWith("_______________"));
        assertTrue(job.toString().endsWith("_______________"));
    }

    @Test
    public void stringContainsLabelAndValuesForAllFields(){
        Job stringTest = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality Control"),
                new CoreCompetency("Persistence"));
        assertEquals("_______________\nID: 12\nName: Product tester" +
                "\nEmployer: ACME\nLocation: Desert" +
                "\nPosition Type: Quality Control\nCore Competency: Persistence" +
                "\n_______________", stringTest.toString());
    }

    @Test
    public void emptyFieldsReturnCustomString(){
        Job missingData = new Job("QA Analyst", new Employer("TSH"),
                new Location("STL"), new PositionType("Flight Software Admin."),
        new CoreCompetency(""));
        assertEquals("_______________\nID: " + missingData.getId() + "\nName: QA Analyst" +
                "\nEmployer: TSH\nLocation: STL" +
                "\nPosition Type: Flight Software Admin.\nCore Competency: Data not available" +
                "\n_______________", missingData.toString());
    }

    @Test
    public void returnOOPSIfOnlyIDExists(){
        assertEquals("OOPS! This job does not seem to exist.", firstJob.toString());
    }
}
