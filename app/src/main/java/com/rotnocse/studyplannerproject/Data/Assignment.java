package com.rotnocse.studyplannerproject.Data;

import com.google.api.services.classroom.model.CourseWork;

public class Assignment {

    private String assignmentName;
    private Long dueDate;
    private Course dueCourse;
    private int percentComplete;
    private String extraInfo;
    private CourseWork classroomCourse;
    private String ID;


    public Assignment() {}


    public Assignment(String assignmentName, Long dueDate, Course dueCourse, int percentComplete, String extraInfo, CourseWork classroomCourse) {
        this.assignmentName = assignmentName;
        this.dueDate = dueDate;
        this.dueCourse = dueCourse;
        this.percentComplete = percentComplete;
        this.extraInfo = extraInfo;
        this.classroomCourse = classroomCourse;
    }

    public Assignment(Assignment assignment) {
        this.assignmentName = assignment.getName();
        this.dueDate = assignment.getDueDate();
        this.dueCourse = assignment.getDueCourse();
        this.percentComplete = assignment.getPercentComplete();
        this.extraInfo = assignment.getExtraInfo();
        this.classroomCourse = assignment.getClassroomCourseWork();
        this.ID = assignment.getID();
    }


    public Long getDueDate() {
        return dueDate;
    }
    public void setDueDate(Long dueDate) {
        this.dueDate = dueDate;
    }

    public String getName() {
        return assignmentName;
    }
    public void setName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getExtraInfo() {
        return extraInfo;
    }
    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public Course getDueCourse() {
        return dueCourse;
    }
    public void setDueCourse(Course dueCourse) {
        this.dueCourse = dueCourse;
    }

    public int getPercentComplete() {
        return percentComplete;
    }
    public void setPercentComplete(int percentComplete) {
        this.percentComplete = percentComplete;
    }

    public CourseWork getClassroomCourseWork() {
        return classroomCourse;
    }
    public void setClassroomCourseWork(CourseWork classroomCourse) {
        this.classroomCourse = classroomCourse;
    }

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
}