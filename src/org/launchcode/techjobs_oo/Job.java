package org.launchcode.techjobs_oo;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
        this.name = null;
        this.employer = new Employer(null);
        this.location = new Location(null);
        this.positionType = new PositionType(null);
        this.coreCompetency = new CoreCompetency(null);
    }

    public Job(String aName, Employer aEmployer, Location aLocation, PositionType aPositionType, CoreCompetency aCoreCompetency){
        this();
        this.name = aName;
        this.employer = aEmployer;
        this.location = aLocation;
        this.positionType = aPositionType;
        this.coreCompetency = aCoreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
    String returnString = "\nID: " + getId();
    String name = "\nName: ";
    String notAvailable = "Data not available";
    String[] returnStrings = {"\nEmployer: ", "\nLocation: ", "\nPosition Type: ",
                            "\nCore Competency: "};
    int counter = 0;

    if(this.getName() == null || this.getName().isEmpty()){
        this.setName(notAvailable);
        counter++;
    }
    returnString += name + getName();

        ArrayList<Object> jobFields = new ArrayList<>();
        jobFields.add(this.getEmployer());
        jobFields.add(this.getLocation());
        jobFields.add(this.getPositionType());
        jobFields.add(this.getCoreCompetency());

        for(Object field : jobFields) {
            if(((JobField)field).getValue() == null || field.toString().isBlank()) {
                ((JobField) field).setValue(notAvailable);
                counter ++;
            }
        }

        for(int i=0; i<returnStrings.length; i++){
            returnStrings[i] += jobFields.get(i);
            returnString += returnStrings[i];
        }

    if(counter == 5){
        returnString = "\nOOPS! This job does not seem to exist.";
    }
        return returnString + "\n";
    }


    //  Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
