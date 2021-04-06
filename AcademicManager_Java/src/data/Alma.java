package data;

public class Alma {
    private String name;
    private String address;
    private String description;
    private String email;
    private String phoneNumber;

    public Alma(String name, String address, String description, String email, String phoneNumber){

        this.name = name;
        this.address = address;
        this.description = description;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }

    // GETTERS & SETTERS


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

}
