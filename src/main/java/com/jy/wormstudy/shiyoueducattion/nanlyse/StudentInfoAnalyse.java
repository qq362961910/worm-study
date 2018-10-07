package com.jy.wormstudy.shiyoueducattion.nanlyse;

import com.jy.wormstudy.shiyoueducattion.entity.Student;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class StudentInfoAnalyse {

    public Student analyse(Document document) {
        Elements elements = document.body().children().get(1).getElementsByTag("li");
        Student student = new Student();
        student.setId(elements.get(0).childNodes().get(1).toString());
        student.setGrade(elements.get(1).childNodes().get(1).toString());
        student.setMajor(elements.get(2).childNodes().get(1).toString());
        student.setCategory(elements.get(3).childNodes().get(1).toString());
        student.setStudentImage(elements.get(4).child(0).child(0).attr("src"));
        return student;
    }

}
