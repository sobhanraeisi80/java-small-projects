package ir.ac.kntu.lms.roles;

public class Professor extends User {
    private static int numberOfProfessors = 0;
    
    public Professor() {}
    
    public Professor(String firstName, String lastName, String phoneNumber, String email, String password) {
        super(firstName, lastName, phoneNumber, email, password);
        setId("STU-" + super.getId() + numberOfProfessors);
        numberOfProfessors ++;
    }

    @Override
    public String toString() {
        return "Professor info: " + super.toString();
    }
}