package ir.ac.kntu.lms.roles;

public class Guest extends User {
    private static int numberOfGuests = 0;

    public Guest() {}

    public Guest(String firstName, String lastName, String phoneNumber, String email, String password) {
        super(firstName, lastName, phoneNumber, email, password);
        setId("GST-" + super.getId() + numberOfGuests);
        numberOfGuests ++;
    }

    @Override
    public String toString() {
        return "Guest info: " + super.toString();
    }
}
