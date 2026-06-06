package ir.ac.kntu.lms.roles;

public class Student extends User{
    private static int numberOfStudents = 0;

    public Student() {}
    
    public Student(String firstName, String lastName, String phoneNumber, String email, String password) {
        super(firstName, lastName, phoneNumber, email, password);
        setId("STU-" + super.getId() + numberOfStudents);
        numberOfStudents ++;
    }

    @Override
    public String toString() {
        return "Student info: " + super.toString();
    }

   
}