package ir.ac.kntu.style;

import ir.ac.kntu.Student;
import ir.ac.kntu.Course;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    void testConstructorAndGetters() {
        Student s = new Student(101, "Ali");

        assertEquals(101, s.getStudentId());
        assertEquals("Ali", s.getName());
        assertTrue(s.getCourses().isEmpty());
    }

    @Test
    void testSetName() {
        Student s = new Student(102, "Sara");

        s.setName("Zahra");

        assertEquals("Zahra", s.getName());
    }

    @Test
    void testAddCourseOnce() {
        Student s = new Student(103, "Reza");
        Course c = new Course("JAVA101", 2);

        s.addCourse(c);

        List<Course> courses = s.getCourses();
        assertEquals(1, courses.size());
        assertTrue(courses.contains(c));
    }

    @Test
    void testAddCourseTwice() {
        Student s = new Student(104, "Nima");
        Course c = new Course("CPP202", 1);

        s.addCourse(c);
        s.addCourse(c);

        assertEquals(1, s.getCourses().size());
    }

    @Test
    void testMultipleCourses() {
        Student s = new Student(105, "Mina");
        Course c1 = new Course("JAVA101", 1);
        Course c2 = new Course("PYTHON101", 1);

        s.addCourse(c1);
        s.addCourse(c2);

        assertEquals(2, s.getCourses().size());
        assertTrue(s.getCourses().contains(c1));
        assertTrue(s.getCourses().contains(c2));
    }
}