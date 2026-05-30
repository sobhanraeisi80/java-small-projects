package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseCode;
    private int capacity;
    private List<Student> studentList;

    public Course(String courseCode, int capacity) {
        this.courseCode = courseCode;
        this.capacity = capacity;
        studentList = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        List<Student> studentListCopy = new ArrayList<>();
        for (Student student : studentList) {
            studentListCopy.add(student);
        }
        return studentListCopy;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public boolean enrollStudent(Student student) {
        if (capacity > 0) {
            for(Student student1 : studentList) {
                if (student1.getStudentId() == student.getStudentId()){
                    return false;
                }
            }
            if(!student.getCourses().contains(this)) {
                studentList.add(student);
                student.addCourse(this);
                capacity--;
                return true;
            }
        }
        return false;
    }

    public int getAvailableSeats(){
        return capacity;
    }
}
