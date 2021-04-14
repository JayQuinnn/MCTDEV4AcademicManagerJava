package data;

public class Lecturer {

    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Paygrade paygrade;

    private EmploymentStatus employmentStatus;


    public Lecturer(String name, String lastName, String email, String phoneNumber, Paygrade paygrade){
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.paygrade = paygrade;
        employmentStatus = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Paygrade getPaygrade() {
        return paygrade;
    }

    public void setPaygrade(Paygrade paygrade) {
        this.paygrade = paygrade;
    }

    public void setEmploymentStatus(EmploymentStatus employmentStatus){
        this.employmentStatus = employmentStatus;
    }

    public EmploymentStatus getEmploymentStatus(){

        return employmentStatus;
    }

}
