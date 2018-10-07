package com.jy.wormstudy.shiyoueducattion.entity;

public class Course {

    private String name;

    private String score;

    private String semester;

    private String examination;

    private String category;

    private String link;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", score='" + score + '\'' +
                ", semester='" + semester + '\'' +
                ", examination='" + examination + '\'' +
                ", category='" + category + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
