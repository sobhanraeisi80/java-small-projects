package ir.ac.kntu.style;

import ir.ac.kntu.ParkingUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingUserTest {

    @Test
    void testConstructorAndGetters() {
        ParkingUser user = new ParkingUser("Ali", "Ahmadi", "P001");

        assertEquals("Ali", user.getFirstName());
        assertEquals("Ahmadi", user.getLastName());
        assertEquals("P001", user.getPermitId());
        assertFalse(user.isActive());
        assertEquals("-", user.getLastEntry());
    }

    @Test
    void testSetters() {
        ParkingUser user = new ParkingUser("A", "B", "P002");

        user.setFirstName("Sara");
        user.setLastName("Hosseini");
        user.setPermitId("P010");
        user.setActive(true);
        user.setLastEntry("2025-10-09 10:00");

        assertEquals("Sara", user.getFirstName());
        assertEquals("Hosseini", user.getLastName());
        assertEquals("P010", user.getPermitId());
        assertTrue(user.isActive());
        assertEquals("2025-10-09 10:00", user.getLastEntry());
    }

    @Test
    void testActivateDeactivatePermit() {
        ParkingUser user = new ParkingUser("Test", "User", "P003");

        user.activatePermit();
        assertTrue(user.isActive());

        user.deactivatePermit();
        assertFalse(user.isActive());
    }

    @Test
    void testUpdateLastEntry() {
        ParkingUser user = new ParkingUser("A", "B", "P004");

        user.updateLastEntry("2025-10-09 09:30");

        assertEquals("2025-10-09 09:30", user.getLastEntry());
    }

    @Test
    void testDisplayUserInfo() {
        ParkingUser user = new ParkingUser("Reza", "Kiani", "P005");

        user.activatePermit();
        user.updateLastEntry("2025-10-09 11:00");

        String expected = "Name: Reza Kiani Permit ID: P005 Active: true Last Entry: 2025-10-09 11:00";

        assertEquals(expected, user.displayUserInfo());
    }
}