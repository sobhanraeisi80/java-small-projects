package ir.ac.kntu.style;

import ir.ac.kntu.SmartThermostat;
import ir.ac.kntu.ThermostatMode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartThermostatTest {

    @Test
    void testDefaultValues() {
        SmartThermostat thermostat = new SmartThermostat();

        assertEquals(ThermostatMode.AUTO, thermostat.getMode());
        assertEquals(22, thermostat.getTemperature());
        assertFalse(thermostat.isOn());
    }

    @Test
    void testSetAndGetMode() {
        SmartThermostat thermostat = new SmartThermostat();

        thermostat.setMode(ThermostatMode.COOL);

        assertEquals(ThermostatMode.COOL, thermostat.getMode());
    }

    @Test
    void testSetAndGetTemperature() {
        SmartThermostat thermostat = new SmartThermostat();

        thermostat.setTemperature(25);

        assertEquals(25, thermostat.getTemperature());
    }

    @Test
    void testTurnOnAndOff() {
        SmartThermostat thermostat = new SmartThermostat();

        thermostat.turnOn();
        assertTrue(thermostat.isOn());

        thermostat.turnOff();
        assertFalse(thermostat.isOn());
    }

    @Test
    void testTemperatureLowerLimit() {
        SmartThermostat thermostat = new SmartThermostat();

        thermostat.setTemperature(10);

        assertEquals(16, thermostat.getTemperature());
    }

    @Test
    void testTemperatureUpperLimit() {
        SmartThermostat thermostat = new SmartThermostat();

        thermostat.setTemperature(35);

        assertEquals(30, thermostat.getTemperature());
    }

    @Test
    void testStatusMessageWhenOff() {
        SmartThermostat thermostat = new SmartThermostat();

        thermostat.turnOff();

        assertEquals("Thermostat is OFF", thermostat.getStatusMessage());
    }

    @Test
    void testStatusMessageCool() {
        SmartThermostat thermostat = new SmartThermostat();

        thermostat.turnOn();
        thermostat.setMode(ThermostatMode.COOL);
        thermostat.setTemperature(18);

        assertEquals("Mode: COOL, temperature is cool",
                thermostat.getStatusMessage());
    }

    @Test
    void testStatusMessageComfortable() {
        SmartThermostat thermostat = new SmartThermostat();

        thermostat.turnOn();
        thermostat.setMode(ThermostatMode.AUTO);
        thermostat.setTemperature(22);

        assertEquals("Mode: AUTO, temperature is comfortable",
                thermostat.getStatusMessage());
    }

    @Test
    void testStatusMessageWarm() {
        SmartThermostat thermostat = new SmartThermostat();

        thermostat.turnOn();
        thermostat.setMode(ThermostatMode.FAN);
        thermostat.setTemperature(27);

        assertEquals("Mode: FAN, temperature is warm",
                thermostat.getStatusMessage());
    }
}