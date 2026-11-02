abstract class SmartDevice {
    static boolean status = false;
    public void getStatus(SmartDevice smartDevice) {
        if (!status) {
            System.out.println("Устройство выключено");
        }
        if (status) {
            System.out.println("Устройство включено");
        }
    }
}
class Lamp extends SmartDevice {
    private final int maxBrightness = 100;
    private static int currentBrightness = 50;

    public Lamp() {
        this.status = status;
        this.currentBrightness = currentBrightness;
    }

    private static void changeStatus() {
        status = !status;
    }

    private static void setBrightness(int newBrightness) {
        currentBrightness = newBrightness;
    }
}
class Thermostat extends SmartDevice {
    private int targetTemperature = 20;
    private static int currentTemperature = 15;
    private static int heatingOrCooling = 2;
    public Thermostat() {
        this.status = status;
        this.targetTemperature = targetTemperature;
        this.currentTemperature = currentTemperature;
    }
    private static void setTargetTemperature(int newTargetTemperature) {
        int targetTemperature = newTargetTemperature;
        if (targetTemperature < currentTemperature) {
            heatingOrCooling = 2;
        }
        if (targetTemperature > currentTemperature) {
            heatingOrCooling = 1;
        }
        if (targetTemperature == currentTemperature) {
            heatingOrCooling = 0;
        }
    }
}
class Blinds extends SmartDevice {
    private static final int maxAngle = 180;
    private static int currentAngle = 90;
    public Blinds() {
        this.status = status;
        this.currentAngle = currentAngle;
    }
    private static void setOpen() {
        currentAngle = maxAngle;
    }
    private static void setClose() {
        currentAngle = 0;
    }
}
