package data;

import java.util.ArrayList;

public class Course {

    private Group group;
    private ArrayList<Subject> subjectList;

    public Course(Group group, ArrayList<Subject> subjectList) {

        this.group = group;
        this.subjectList = subjectList;

    }

    // GETTERS & SETTERS


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(ArrayList<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}
