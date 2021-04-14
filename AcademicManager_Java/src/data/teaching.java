package data;

public class teaching implements EmploymentStatus{

    public void changeEmployment(Lecturer lecturer){
        lecturer.setEmploymentStatus(this);
    }

    public String toString(){
        return "Is currently teaching";
    }

}
