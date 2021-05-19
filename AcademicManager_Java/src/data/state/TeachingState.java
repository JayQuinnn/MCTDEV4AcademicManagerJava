package data.state;

import data.Lecturer;

public class TeachingState implements EmploymentStatus {

    public void changeEmployment(Lecturer lecturer){
        lecturer.setEmploymentStatus(this);
    }

    public String toString(){
        return "Is currently teaching";
    }

}
