package com.jy.wormstudy.shiyoueducattion.nanlyse;

import com.jy.wormstudy.shiyoueducattion.entity.Course;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ToLearningCourseAnalyse {

    public List<Course> analyse(Document document) {
        List<Course> courseList = new ArrayList<>();
        Elements courseElements = document.getElementsByTag("table").get(0).getElementsByTag("tr");
        for(int i=1; i<courseElements.size(); i++ ) {
            courseList.add(buildCourse(courseElements.get(i)));
        }
        return courseList;
    }

    private Course buildCourse(Element element) {
        Elements elements = element.getElementsByTag("td");
        Course course = new Course();
        course.setName(elements.get(0).text());
        course.setScore(elements.get(1).text());
        course.setSemester(elements.get(2).text());
        course.setExamination(elements.get(3).text());
        course.setCategory(elements.get(4).text());
        String onclick = elements.get(5).children().get(1).attr("onclick");
        onclick = onclick.replaceAll("'", "");
        onclick = onclick.replace("autoElectiveCourse(", "");
        onclick = onclick.replace(")", "");
        String[] params = onclick.split(",");
        course.setLink(buildLink(params[0],params[1],params[2],params[3]));
        return course;
    }

    private String buildLink(String courseId, String isNewSemester, String url, String isSiteCourseType) {
        if(url.endsWith("/")) {
            url = url.substring(0, url.length() - 1);
        }
        if("semesterA".equalsIgnoreCase(isNewSemester)){//共享课程
            return "/entity/workspaceStudent/student_enterHeroCourse.action?courseId=" + courseId;
        }else if("semesterB".equals(isNewSemester)){//新课程空间
            return url + "/sign/signLearn.action?sign=0&courseId=" + courseId;
        }else if("no".equals(isSiteCourseType)){//非共享课程
            return url + "/entity/first/peTchCoursewareItem_toMode.action?course_id=" + courseId + "&isNewSemester=" + isNewSemester;
        }else if(isSiteCourseType == "0"){//网考学习中心网考课程
            return url + "/entity/first/peTchCoursewareItem_toMode.action?course_id=" + courseId + "&isNewSemester=" + isNewSemester + "&isSiteCourseType=0";
        }else{
            return url + "/entity/first/peTchCoursewareItem_toMode.action?course_id=" + courseId + "&isNewSemester=" + isNewSemester + "&isSiteCourseType="+isSiteCourseType;
        }
    }

        
}
