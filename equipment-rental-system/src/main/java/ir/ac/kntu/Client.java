package ir.ac.kntu;

import java.util.HashMap;
import java.util.Map;

public class Client {
    private final int clientId;
    private final String name;
    private final Map<Equipment, RentAgreement> equipmentRentInfo = new HashMap();

    public Client(int clientId, String name) {
        this.clientId = clientId;
        this.name = name;
    }

    public boolean rentEquipment(Equipment equipment, RentAgreement rentAgreement) {
        if(equipment.rentEquipment(this, rentAgreement)) {
            equipmentRentInfo.put(equipment, rentAgreement);
            return true;
        } else {
            return false;
        }
    }

    public int getClientId() {
        return this.clientId;
    }

    public String getName() {
        return this.name;
    }

    public Map<Equipment, RentAgreement> getRentedEquipments() {
        return new HashMap<>(equipmentRentInfo);
    }
    
    public boolean returnEquipment(Equipment equipment) {
        if(equipmentRentInfo.containsKey(equipment)) {
            equipment.returnEquipment(this);
            equipmentRentInfo.remove(equipment);
            return true;
        }
        return false;
    }

}
