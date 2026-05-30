package ir.ac.kntu.style;

import ir.ac.kntu.Student;
import ir.ac.kntu.Course;
import ir.ac.kntu.AcademySystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AcademySystemTest {

    @Test
    void testAddStudentAndCourse() {
        AcademySystem system = new AcademySystem();
        Student s = new Student(101, "Ali");
        Course c = new Course("JAVA101", 2);

        system.addStudent(s);
        system.addCourse(c);

        assertEquals(s, system.getStudent(101));
        assertEquals(c, system.getCourse("JAVA101"));
    }

    @Test
    void testEnrollStudentInCourseSuccess() {
        AcademySystem system = new AcademySystem();
        Student s = new Student(102, "Sara");
        Course c = new Course("CPP202", 1);

        system.addStudent(s);
        system.addCourse(c);

        assertTrue(system.enrollStudentInCourse(102, "CPP202"));
        assertTrue(c.getStudents().contains(s));
        assertTrue(s.getCourses().contains(c));
    }

    @Test
    void testDuplicateEnrollment() {
        AcademySystem system = new AcademySystem();
        Student s = new Student(103, "Reza");
        Course c = new Course("DB303", 1);

        system.addStudent(s);
        system.addCourse(c);

        assertTrue(system.enrollStudentInCourse(103, "DB303"));
        assertFalse(system.enrollStudentInCourse(103, "DB303"));
    }

    @Test
    void testInvalidStudentOrCourse() {
        AcademySystem system = new AcademySystem();
        Course c = new Course("WEB404", 1);

        system.addCourse(c);

        assertFalse(system.enrollStudentInCourse(999, "WEB404"));

        Student s = new Student(104, "Nima");
        system.addStudent(s);

        assertFalse(system.enrollStudentInCourse(104, "UNKNOWN"));
    }

    @Test
    void testCourseCapacityLimit() {
        AcademySystem system = new AcademySystem();
        Student s1 = new Student(105, "Mina");
        Student s2 = new Student(106, "Ali");
        Course c = new Course("AI505", 1);

        system.addStudent(s1);
        system.addStudent(s2);
        system.addCourse(c);

        assertTrue(system.enrollStudentInCourse(105, "AI505"));
        assertFalse(system.enrollStudentInCourse(106, "AI505"));
    }
}