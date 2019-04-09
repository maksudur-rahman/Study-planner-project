package com.rotnocse.studyplannerproject.Data;

import java.io.Serializable;

public class Time implements Serializable {
    private Long calEventID;
    private boolean isBlockSchedule;
    private boolean isADay;
    private boolean isBDay;
    private boolean isDaySchedule;

    private String days;
    private Long startLong;
    private Long endLong;
    private Long finish;


    public Time() {
    }

    public Time(Long calEventID, boolean isBlockSchedule, boolean isADay, boolean isBDay, boolean isDaySchedule, String days, Long startLong, Long endLong, Long finish) {
        this.calEventID = calEventID;
        this.isBlockSchedule = isBlockSchedule;
        this.isADay = isADay;
        this.isBDay = isBDay;
        this.isDaySchedule = isDaySchedule;
        this.days = days;
        this.startLong = startLong;
        this.endLong = endLong;
        this.finish = finish;
    }


    public Time(Long startLong) {
        this.startLong = startLong;
    }


    public Time(boolean isBlockSchedule, boolean isADay, boolean isBDay, boolean isDaySchedule, String days, Long startLong, Long endLong, Long finish) {
        this.isBlockSchedule = isBlockSchedule;
        this.isADay = isADay;
        this.isBDay = isBDay;
        this.isDaySchedule = isDaySchedule;
        this.days = days;
        this.startLong = startLong;
        this.endLong = endLong;
        this.finish = finish;
    }

    public Long getCalEventID() {
        return calEventID;
    }
    public void setCalEventID(Long calEventID) {
        this.calEventID = calEventID;
    }

    public boolean isBlockSchedule() {
        return isBlockSchedule;
    }
    public void setBlockSchedule(boolean blockSchedule) {
        isBlockSchedule = blockSchedule;
    }

    public boolean isADay() {
        return isADay;
    }
    public void setADay(boolean ADay) {
        isADay = ADay;
    }

    public boolean isBDay() {
        return isBDay;
    }
    public void setBDay(boolean BDay) {
        isBDay = BDay;
    }

    public boolean isDaySchedule() {
        return isDaySchedule;
    }
    public void setDaySchedule(boolean daySchedule) {
        isDaySchedule = daySchedule;
    }

    public String getDays() {
        return days;
    }
    public void setDays(String days) {
        this.days = days;
    }

    public Long getStartLong() {
        return startLong;
    }
    public void setStartLong(Long startLong) {
        this.startLong = startLong;
    }

    public Long getEndLong() {
        return endLong;
    }
    public void setEndLong(Long endLong) {
        this.endLong = endLong;
    }

    public Long getFinish() {
        return finish;
    }
    public void setFinish(Long finish) {
        this.finish = finish;
    }
}
