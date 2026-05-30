package ir.ac.kntu;

import java.util.HashMap;
import java.util.Map;

public class Equipment {
    private final String equipmentCode;
    private final String name;
    private boolean isAvailable;
    private final Map<Client, RentAgreement> rentalHistory = new HashMap();

    public Equipment(String equipmentCode, String name) {
        this.equipmentCode = equipmentCode;
        this.name = name;
        isAvailable = true;
    }

    public boolean rentEquipment(Client client, RentAgreement rentAgreement) {
        if(isAvailable) {
            rentalHistory.put(client, rentAgreement);
            isAvailable = false;
            return true;
        }
        return false;
    }

    public Map<Client, RentAgreement> getRentalHistory() {
        return rentalHistory;
    }

    public boolean returnEquipment(Client client) {
        if(isAvailable) {
            return false;
        }
        isAvailable = true;
        return true;
    }

    public String getEquipmentCode() {
        return this.equipmentCode;
    }
    
    public String getName() {
        return this.name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

}
