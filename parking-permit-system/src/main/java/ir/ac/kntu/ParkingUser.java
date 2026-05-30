package ir.ac.kntu;

public class ParkingUser {
    private String firstName;
    private String lastName;
    private String permitId;
    private boolean isActive;
    private String lastEntry = "-";

    public ParkingUser(String firstName, String lastName, String permitId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.permitId = permitId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPermitId(String permitId) {
        this.permitId = permitId;
    }

    public String getPermitId() {
        return permitId;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setLastEntry(String lastEntry) {
        this.lastEntry = lastEntry;
    }

    public String getLastEntry() {
        return lastEntry;
    }

    public String displayUserInfo() {
        return "Name: " + firstName + " " + lastName + " Permit ID: " +permitId+ " Active: " + isActive + " Last Entry: "+ lastEntry;
    }

    public void deactivatePermit() {
        isActive = false;
    }

    public void activatePermit() {
        isActive = true;
    }

    public void updateLastEntry(String datetime) {
        lastEntry = datetime;
    }
}
