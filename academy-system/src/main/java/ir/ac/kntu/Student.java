package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int studentId;
    private List<Course> courseList;

    public Student(int studentId, String name) {
        this.name = name;
        this.studentId = studentId;
        courseList = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void addCourse(Course course) {
        for(Course c : courseList){
            if(c.getCourseCode().equals(course.getCourseCode())){
                return;
            }
        }
        courseList.add(course);
    }

    public List<Course> getCourses() {
        return courseList;
    }
}