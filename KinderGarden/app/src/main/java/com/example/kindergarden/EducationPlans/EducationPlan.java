package com.example.kindergarden.EducationPlans;

public class EducationPlan {

    private String Title;
    private String Description;
    private String Activs;
    private String DateRange;
    private String TeacherName;
    private String key;

    public EducationPlan(String title, String description, String activs, String dateRange, String teacherName) {
        Title = title;
        Description = description;
        Activs = activs;
        DateRange = dateRange;
        TeacherName = teacherName;
    }

    public EducationPlan(){}

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getActivs() {
        return Activs;
    }

    public void setActivs(String activs) {
        Activs = activs;
    }

    public String getDateRange() {
        return DateRange;
    }

    public void setDateRange(String dateRange) {
        DateRange = dateRange;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
