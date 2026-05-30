package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;


public class ParkingManager {
    private final List<ParkingUser> users;
    
    private List<ParkingUser> findActiveInactiveUsers(boolean activation) {
        List<ParkingUser> activeUsers = new ArrayList<>();
        for(ParkingUser user: users) {
            if(user.isActive() == activation) {
                activeUsers.add(user);
            }
        }
        return activeUsers;
    }

    private boolean isPermitDuplicated(String permitId) {
        for(ParkingUser user: users) {
            if(user.getPermitId().equalsIgnoreCase(permitId)) {
                return true;
            }
        }
        return false;
    }

    public ParkingManager() {
        users = new ArrayList<>();
    }
    
    public void addUser(ParkingUser user) {
        if(!isPermitDuplicated(user.getPermitId())) {
            users.add(user);
        }
    }

    public List<ParkingUser> getAllUsers() {
        return new ArrayList<>(users);
    }

    public ParkingUser findUserByPermitId(String permitId) {
        for(ParkingUser user: users) {
            if(permitId.equalsIgnoreCase(user.getPermitId())) {
                return user;
            }
        }
        return null;
    }

    public List<ParkingUser> getActiveUsers() {
        return findActiveInactiveUsers(true);
    }

    public List<ParkingUser> getInactiveUsers() {
        return findActiveInactiveUsers(false);
    }
}
