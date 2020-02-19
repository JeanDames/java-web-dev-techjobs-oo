package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class JobTest {
    Job firstJob;
    Job secondJob;
    @Before
    public void createJobs() {
        firstJob = new Job() {};
        secondJob = new Job() {};
    };


    @Test
    public void testSettingJobId(){
        System.out.println(firstJob.getId() + " " + secondJob.getId());
        assertFalse(firstJob.equals(secondJob));
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertTrue(job instanceof Job);
        assertTrue(job.getName() == "Product tester");
        assertTrue(job.getEmployer().getValue() == "ACME");
        assertTrue(job.getLocation().getValue() == "Desert");
        assertTrue(job.getPositionType().getValue() == "Quality control");
        assertTrue(job.getCoreCompetency().getValue() == "Persistence");
        assertTrue(job.getId() == 3);
    }

    @Test
    public void testJobsForEquality(){
        Job testOne = new Job("Project management", new Employer("TSH"),
                new Location("STL"), new PositionType("Senior management"),
                new CoreCompetency("Java"));
        Job testTwo = new Job("Project management", new Employer("TSH"),
                new Location("STL"), new PositionType("Senior management"),
                new CoreCompetency("Java"));
    }
}
