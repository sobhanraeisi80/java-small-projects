package ir.ac.kntu.style;

import ir.ac.kntu.ParkingUser;
import ir.ac.kntu.ParkingManager;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingManagerTest {

    @Test
    void testAddUserAndGetAll() {
        ParkingManager manager = new ParkingManager();
        ParkingUser u1 = new ParkingUser("Ali", "Rezaei", "P001");
        ParkingUser u2 = new ParkingUser("Sara", "Hosseini", "P002");

        manager.addUser(u1);
        manager.addUser(u2);

        List<ParkingUser> users = manager.getAllUsers();

        assertEquals(2, users.size());
        assertTrue(users.contains(u1));
        assertTrue(users.contains(u2));
    }

    @Test
    void testFindUserByPermitIdExists() {
        ParkingManager manager = new ParkingManager();
        ParkingUser user = new ParkingUser("Ali", "Rezaei", "P001");

        manager.addUser(user);

        ParkingUser found = manager.findUserByPermitId("P001");

        assertNotNull(found);
        assertEquals("Ali", found.getFirstName());
    }

    @Test
    void testFindUserByPermitIdNotExists() {
        ParkingManager manager = new ParkingManager();

        ParkingUser found = manager.findUserByPermitId("P999");

        assertNull(found);
    }

    @Test
    void testCaseInsensitiveFind() {
        ParkingManager manager = new ParkingManager();
        ParkingUser user = new ParkingUser("Ali", "Rezaei", "P001");

        manager.addUser(user);

        ParkingUser found = manager.findUserByPermitId("p001");

        assertNotNull(found);
        assertEquals("P001", found.getPermitId());
    }

    @Test
    void testActiveInactiveUsers() {
        ParkingManager manager = new ParkingManager();
        ParkingUser u1 = new ParkingUser("Ali", "A", "P001");
        ParkingUser u2 = new ParkingUser("Sara", "B", "P002");

        manager.addUser(u1);
        manager.addUser(u2);

        u1.activatePermit();
        u2.deactivatePermit();

        List<ParkingUser> active = manager.getActiveUsers();
        List<ParkingUser> inactive = manager.getInactiveUsers();

        assertTrue(active.contains(u1));
        assertFalse(active.contains(u2));
        assertTrue(inactive.contains(u2));
        assertFalse(inactive.contains(u1));
    }

    @Test
    void testGetAllUsersIsCopySafe() {
        ParkingManager manager = new ParkingManager();
        ParkingUser user = new ParkingUser("Ali", "Rezaei", "P001");

        manager.addUser(user);

        List<ParkingUser> users = manager.getAllUsers();
        users.clear();

        assertEquals(1, manager.getAllUsers().size());
    }

    @Test
    void testDuplicatePermitIdIsNotAdded() {
        ParkingManager manager = new ParkingManager();
        ParkingUser u1 = new ParkingUser("Ali", "Rezaei", "P001");
        ParkingUser u2 = new ParkingUser("Sara", "Hosseini", "p001");

        manager.addUser(u1);
        manager.addUser(u2);

        assertEquals(1, manager.getAllUsers().size());
    }
}