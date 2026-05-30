package ir.ac.kntu;

public class SmartThermostat {
    private ThermostatMode mode;
    private int temperature;
    private boolean isOn;

    public SmartThermostat(){
        mode = ThermostatMode.AUTO;
        temperature = 22;
        isOn = false;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public void setMode(ThermostatMode mode) {
        this.mode = mode;
    }

    public ThermostatMode getMode() {
        return mode;
    }

    public void setTemperature(int temperature) {
        if(temperature < 16) {
            this.temperature = 16;
        } else if(temperature > 30) {
            this.temperature = 30;
        } else {
            this.temperature = temperature;
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getStatusMessage() {
        final String modeStr = "Mode: ";
        if(!isOn) {
            return "Thermostat is OFF";
        } else if(temperature < 20) {
            return modeStr + mode + ", temperature is cool";
        } else if( temperature >= 20 && temperature <= 24) {
            return modeStr + mode + ", temperature is comfortable";
        } else {
            return modeStr + mode + ", temperature is warm";
        }
    }

}
