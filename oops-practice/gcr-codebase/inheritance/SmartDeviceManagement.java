class Smart {

    String status;
    int deviceId;

    Smart(String status, int deviceId) {
        this.status = status;
        this.deviceId = deviceId;
    }

    void displayStatus() {
        System.out.println("\n----------------------------");
        System.out.println("Device Status is  -: " + status);
        System.out.println("Device id is   -: " + deviceId);

    }
}

// Manager class - Outside Library
class Thermostat extends Smart {
    int temperatureSatting;

    Thermostat(String status, int deviceId, int temperatureSatting) {
        super(status, deviceId);
        this.temperatureSatting = temperatureSatting;
    }

    @Override
    void displayStatus() {
        super.displayStatus();
        System.out.println("THe temperature is -: " + temperatureSatting);
    }
}

// Main class to run the code
public class SmartDeviceManagement {
    public static void main(String[] args) {
        Smart s = new Smart("Idle", 21);
        Thermostat t = new Thermostat("Working", 2, 12);

        s.displayStatus();
        t.displayStatus();
    }
}