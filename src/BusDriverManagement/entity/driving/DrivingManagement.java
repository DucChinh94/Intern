package BusDriverManagement.entity.driving;

import BusDriverManagement.entity.Driver;

import java.io.Serializable;
import java.util.List;

public class DrivingManagement implements Serializable {

    private Driver driver;
    private List<Assignment> assignmentList;

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

    @Override
    public String toString() {
        return "DrivingManagement{" +
                "driver=" + driver +
                ", assignmentList=" + assignmentList +
                '}';
    }
}
