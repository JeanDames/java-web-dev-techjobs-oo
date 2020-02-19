package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class JobTest {
    Job job;
    @Before
    public void createJobs() {
        job = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
    };


    @Test
    public void testSettingJobId(){
        Job firstJob = new Job() {};
        Job secondJob = new Job() {};
        System.out.println(firstJob.getId() + " " + secondJob.getId());
        assertFalse(firstJob.equals(secondJob));
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(job instanceof Job);
        assertTrue(job.getName() == "Product tester");
        assertTrue(job.getEmployer().getValue() == "ACME");
        assertTrue(job.getLocation().getValue() == "Desert");
        assertTrue(job.getPositionType().getValue() == "Quality control");
        assertTrue(job.getCoreCompetency().getValue() == "Persistence");
        assertTrue(job.getId() == 1);
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
        assertTrue(job.toString().contains("ID: 1\nName: Product tester\n" +
                "Employer: ACME\nLocation: Desert\n" +
                "Position Type: Quality Control\nCore Competency: Persistence\n"));
    }

}
