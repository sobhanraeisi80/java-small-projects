package ir.ac.kntu.style;

import ir.ac.kntu.Client;
import ir.ac.kntu.Equipment;
import ir.ac.kntu.EquipmentRentalSystem;
import ir.ac.kntu.RentAgreement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class EquipmentRentalSystemTest {

    private EquipmentRentalSystem system;
    private Client client1;
    private Client client2;
    private Equipment equipment1;
    private Equipment equipment2;
    private RentAgreement agreement1;
    private RentAgreement agreement2;

    @BeforeEach
    void setUp() {
        system = new EquipmentRentalSystem();

        client1 = new Client(1001, "Ali");
        client2 = new Client(1002, "Sara");

        equipment1 = new Equipment("EQ100", "Tennis Racket");
        equipment2 = new Equipment("EQ200", "Mountain Bike");

        system.addClient(client1);
        system.addClient(client2);
        system.addEquipment(equipment1);
        system.addEquipment(equipment2);

        agreement1 = new RentAgreement(
                new Date(),
                new Date(System.currentTimeMillis() + 3 * 24 * 60 * 60 * 1000),
                300.0
        );

        agreement2 = new RentAgreement(
                new Date(),
                new Date(System.currentTimeMillis() + 5 * 24 * 60 * 60 * 1000),
                500.0
        );
    }

    @Test
    void testRentEquipmentSuccess() {
        assertTrue(system.rentEquipmentToClient(1001, "EQ100", agreement1));
        assertFalse(equipment1.isAvailable());
        assertEquals(1, client1.getRentedEquipments().size());
    }

    @Test
    void testRentEquipmentAlreadyRented() {
        system.rentEquipmentToClient(1001, "EQ100", agreement1);

        assertFalse(system.rentEquipmentToClient(1002, "EQ100", agreement2));
    }

    @Test
    void testRentEquipmentNonExistingClient() {
        assertFalse(system.rentEquipmentToClient(9999, "EQ100", agreement1));
    }

    @Test
    void testRentEquipmentNonExistingEquipment() {
        assertFalse(system.rentEquipmentToClient(1001, "EQ999", agreement1));
    }

    @Test
    void testReturnEquipmentSuccess() {
        system.rentEquipmentToClient(1001, "EQ100", agreement1);

        assertTrue(system.returnEquipmentFromClient(1001, "EQ100"));
        assertTrue(equipment1.isAvailable());
        assertEquals(0, client1.getRentedEquipments().size());
    }

    @Test
    void testReturnEquipmentNotRentedByClient() {
        system.rentEquipmentToClient(1001, "EQ100", agreement1);

        assertFalse(system.returnEquipmentFromClient(1002, "EQ100"));
    }

    @Test
    void testReturnEquipmentNonExistingClient() {
        assertFalse(system.returnEquipmentFromClient(9999, "EQ100"));
    }

    @Test
    void testReturnEquipmentNonExistingEquipment() {
        assertFalse(system.returnEquipmentFromClient(1001, "EQ999"));
    }

    @Test
    void testGetClient() {
        assertEquals(client1, system.getClient(1001));
        assertNull(system.getClient(9999));
    }

    @Test
    void testGetEquipment() {
        assertEquals(equipment1, system.getEquipment("EQ100"));
        assertNull(system.getEquipment("EQ999"));
    }

    @Test
    void testClientRentAndReturnMap() {
        client1.rentEquipment(equipment1, agreement1);

        assertEquals(1, client1.getRentedEquipments().size());

        client1.returnEquipment(equipment1);

        assertEquals(0, client1.getRentedEquipments().size());
    }

    @Test
    void testEquipmentRentalHistory() {
        client1.rentEquipment(equipment1, agreement1);

        assertTrue(equipment1.getRentalHistory().containsKey(client1));

        client1.returnEquipment(equipment1);

        assertTrue(equipment1.getRentalHistory().containsKey(client1));
    }

    @Test
    void testAgreementExtendSuccess() {
        assertTrue(agreement1.extendAgreement(
                new Date(System.currentTimeMillis() + 5 * 24 * 60 * 60 * 1000),
                200.0
        ));

        assertEquals(500.0, agreement1.getPrice(), 0.001);
    }

    @Test
    void testAgreementExtendFail() {
        assertFalse(agreement1.extendAgreement(
                new Date(System.currentTimeMillis() - 1 * 24 * 60 * 60 * 1000),
                100.0
        ));

        assertEquals(300.0, agreement1.getPrice(), 0.001);
    }

    @Test
    void testMultipleRentalsAndReturns() {
        system.rentEquipmentToClient(1001, "EQ100", agreement1);
        system.rentEquipmentToClient(1002, "EQ200", agreement2);

        assertFalse(equipment1.isAvailable());
        assertFalse(equipment2.isAvailable());

        system.returnEquipmentFromClient(1001, "EQ100");
        system.returnEquipmentFromClient(1002, "EQ200");

        assertTrue(equipment1.isAvailable());
        assertTrue(equipment2.isAvailable());
    }
}