package ir.ac.kntu;

import java.util.HashMap;
import java.util.Map;

public class AcademySystem {
    private Map<Integer, Student> studentMap;
    private Map<String, Course> courseMap;

    public AcademySystem() {
        studentMap = new HashMap<>();
        courseMap = new HashMap<>();
    }

    public void addStudent(Student student) {
        if(!studentMap.containsKey(student.getStudentId())){
            studentMap.put(student.getStudentId(), student);
        }
    }

    public void addCourse(Course course) {
        if(!courseMap.containsKey(course.getCourseCode())) {
            courseMap.put(course.getCourseCode(), course);
        }
    }

    public Student getStudent(int studentId) {
        return studentMap.get(studentId);
    }

    public Course getCourse(String courseCode) {
        return courseMap.get(courseCode);
    }

    public boolean enrollStudentInCourse(int studentId, String courseCode) {
        if(!courseMap.containsKey(courseCode)) {
            return false;
        }
        if(!studentMap.containsKey(studentId)) {
            return false;
        }
        Student student = studentMap.get(studentId);
        Course course = courseMap.get(courseCode);
        return course.enrollStudent(student);
    }
}
