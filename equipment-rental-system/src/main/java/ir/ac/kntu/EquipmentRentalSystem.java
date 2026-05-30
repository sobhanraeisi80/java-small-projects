package ir.ac.kntu;

import java.util.HashMap;
import java.util.Map;

public class EquipmentRentalSystem {
    private Map<String, Equipment> equipments;
    private Map<Integer, Client> clients;

    public EquipmentRentalSystem(){
        equipments = new HashMap<>();
        clients = new HashMap<>();
    }
    
    public void addEquipment(Equipment equipment) {
        String equipmentCode = equipment.getEquipmentCode();
        if(!equipments.containsKey(equipmentCode)) {
            equipments.put(equipmentCode, equipment);
        }
    }

    public void addClient(Client client) {
        int clientId = client.getClientId();
        if(!clients.containsKey(clientId)) {
            clients.put(clientId, client);
        }
    }

    public Equipment getEquipment(String equipmentCode) {
        return equipments.getOrDefault(equipmentCode, null);
    }

    public Client getClient(int clientId) {
        return clients.getOrDefault(clientId, null);
    }

    public boolean returnEquipmentFromClient(int clientId, String equipmentCode) {
        Client clinet = clients.getOrDefault(clientId, null);
        Equipment equipment = equipments.getOrDefault(equipmentCode, null);
        if(clinet == null || equipment == null) {
            return false;
        }
        return clinet.returnEquipment(equipment);
    }

    public boolean rentEquipmentToClient(int clientId, String equipmentCode, RentAgreement rentAgreement) {
        Client client = clients.getOrDefault(clientId, null);
        Equipment equipment = equipments.getOrDefault(equipmentCode, null);
        if(equipment == null || client == null) {
            return false;
        }
        return client.rentEquipment(equipment, rentAgreement);
    }
}
