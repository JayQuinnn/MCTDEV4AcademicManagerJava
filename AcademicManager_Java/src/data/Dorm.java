package data;

public class Dorm {

    private Building building;
    private int floor;
    private int room;

    public Dorm(Building building, int floor, int room){
        this.building = building;
        this.floor = floor;
        this.room = room;
    }

    // GETTERS & SETTERS


    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

}
