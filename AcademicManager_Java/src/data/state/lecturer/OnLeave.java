package data.state.lecturer;

import data.Lecturer;
import data.state.lecturer.EmploymentStatus;

public class OnLeave implements EmploymentStatus {

    public void changeEmployment(Lecturer lecturer){
        lecturer.setEmploymentStatus(this);
    }

    public String toString(){
        return "Is on administrative/sick leave";
    }

}