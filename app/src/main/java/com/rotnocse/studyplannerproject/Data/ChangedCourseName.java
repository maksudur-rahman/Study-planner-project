package com.rotnocse.studyplannerproject.Data;


public class ChangedCourseName {

    String oldCourseName;
    String newCourseName;


    public ChangedCourseName() {
    }

    public ChangedCourseName(String oldCourseName, String newCourseName) {
        this.oldCourseName = oldCourseName;
        this.newCourseName = newCourseName;
    }



    public String getOldCourseName() {
        return oldCourseName;
    }
    public void setOldCourseName(String oldCourseName) {
        this.oldCourseName = oldCourseName;
    }

    public String getNewCourseName() {
        return newCourseName;
    }
    public void setNewCourseName(String newCourseName) {
        this.newCourseName = newCourseName;
    }
}
