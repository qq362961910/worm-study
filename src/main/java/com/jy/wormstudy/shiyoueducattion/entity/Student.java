package com.jy.wormstudy.shiyoueducattion.entity;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String id;

    private String grade;

    private String major;

    private String category;

    private String studentImage;

    private List<Course> toLearningCourseList = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStudentImage() {
        return studentImage;
    }

    public void setStudentImage(String studentImage) {
        this.studentImage = studentImage;
    }

    public List<Course> getToLearningCourseList() {
        return toLearningCourseList;
    }

    public void setToLearningCourseList(List<Course> toLearningCourseList) {
        this.toLearningCourseList = toLearningCourseList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", grade='" + grade + '\'' +
                ", major='" + major + '\'' +
                ", category='" + category + '\'' +
                ", studentImage='" + studentImage + '\'' +
                ", toLearningCourseList=" + toLearningCourseList +
                '}';
    }
}
