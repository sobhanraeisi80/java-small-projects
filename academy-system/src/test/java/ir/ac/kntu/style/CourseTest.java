package ir.ac.kntu.style;

import ir.ac.kntu.Student;
import ir.ac.kntu.Course;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    @Test
    void testConstructorAndGetters() {
        Course c = new Course("JAVA101", 3);

        assertEquals("JAVA101", c.getCourseCode());
        assertEquals(3, c.getCapacity());
        assertTrue(c.getStudents().isEmpty());
        assertEquals(3, c.getAvailableSeats());
    }

    @Test
    void testEnrollStudentSuccess() {
        Course c = new Course("CPP202", 2);
        Student s1 = new Student(201, "Ali");
        Student s2 = new Student(202, "Sara");

        assertTrue(c.enrollStudent(s1));
        assertTrue(c.enrollStudent(s2));
        assertEquals(0, c.getAvailableSeats());
    }

    @Test
    void testEnrollStudentOverCapacity() {
        Course c = new Course("DB303", 1);
        Student s1 = new Student(301, "Nima");
        Student s2 = new Student(302, "Reza");

        c.enrollStudent(s1);

        assertFalse(c.enrollStudent(s2));
    }

    @Test
    void testEnrollStudentDuplicate() {
        Course c = new Course("WEB404", 2);
        Student s = new Student(401, "Sara");

        assertTrue(c.enrollStudent(s));
        assertFalse(c.enrollStudent(s));
        assertEquals(1, c.getStudents().size());
    }

    @Test
    void testStudentAlsoGetsCourse() {
        Course c = new Course("AI505", 1);
        Student s = new Student(501, "Ali");

        c.enrollStudent(s);

        assertTrue(s.getCourses().contains(c));
    }
}