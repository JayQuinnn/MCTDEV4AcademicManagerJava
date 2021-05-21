package data;

import data.constants.Building;

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

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
}
