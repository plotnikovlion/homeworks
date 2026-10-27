abstract class SmartDevice {
    boolean status = false;
    public String getStatus(SmartDevice smartDevice) {
        if (smartDevice.status = false) {
            System.out.println("Устройство выключено");
        }
        if (smartDevice.status = true) {
            System.out.println("Устройство включено");
        }
    }
}
class Lamp extends SmartDevice {
    private final int maxBridhtness = 100;
    private int currentBrightness = 50;

    public Lamp() {
        this.status = status;
        this.maxBrightness = maxBrightness;
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
    private int currentTemperature = 15;
    private int heatingOrCooling = 2;
    public Thermostat() {
        this.status = status;
        this.targetTemperature = targetTemperature;
        this.currentTemperature = currentTemperature;
    }
    private static void setTargetTemperature(int newTargetTemperature) {
        targetTemperature = newTargetTemperature;
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
    private final int maxAngle = 180;
    private int currentAngle = 90;
    public Blinds() {
        this.status = status;
        this.maxAngle = maxAngle;
        this.currentAngle = currentAngle;
    }
    private static void setOpen() {
        currentAngle = maxAngle;
    }
    private static void setClose() {
        currentAngle = 0;
    }
}
