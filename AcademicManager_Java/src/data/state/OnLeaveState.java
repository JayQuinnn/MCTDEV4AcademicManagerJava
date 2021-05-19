package data.state;

import data.Lecturer;

public class OnLeaveState implements EmploymentStatus {

    public void changeEmployment(Lecturer lecturer){
        lecturer.setEmploymentStatus(this);
    }

    public String toString(){
        return "Is on administrative/sick leave";
    }

}