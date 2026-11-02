import java.util.ArrayList;
import java.util.List;

abstract class SmartDevice {
    private boolean on = false;

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }

    public boolean isOn() {
        return on;
    }

    public abstract String getStatus();
}

class Lamp extends SmartDevice {
    private final int maxBrightness;
    private int currentBrightness;

    public Lamp(int maxBrightness, int currentBrightness) {
        this.maxBrightness = maxBrightness;
        setBrightness(currentBrightness);
    }

    public void setBrightness(int newBrightness) {
        if (newBrightness > maxBrightness) {
            newBrightness = maxBrightness;
        }
        if (newBrightness < 0) {
            newBrightness = 0;
        }
        currentBrightness = newBrightness;
    }

    @Override
    public String getStatus() {
        String status;
        if (isOn()) {
            status = "включена";
        } else {
            status = "выключена";
        }
        return "Лампа: " + status + ", яркость " + currentBrightness + "/" + maxBrightness;
    }
}

class Thermostat extends SmartDevice {
    private int targetTemperature;
    private int currentTemperature;
    private int heatingOrCooling = 0;

    public Thermostat(int targetTemperature, int currentTemperature) {
        this.targetTemperature = targetTemperature;
        this.currentTemperature = currentTemperature;
        updateHeatingOrCooling();
    }

    public void setTargetTemperature(int newTargetTemperature) {
        targetTemperature = newTargetTemperature;
        updateHeatingOrCooling();
    }

    public void setCurrentTemperature(int newCurrentTemperature) {
        currentTemperature = newCurrentTemperature;
        updateHeatingOrCooling();
    }

    private void updateHeatingOrCooling() {
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

    @Override
    public String getStatus() {
        String status;
        if (isOn()) {
            status = "включён";
            if (heatingOrCooling == 1) {
                status += ", нагрев";
            } else if (heatingOrCooling == 2) {
                status += ", охлаждение";
            } else {
                status += ", ожидание";
            }
        } else {
            status = "выключен";
        }
        return "Термостат: " + status + ", сейчас " + currentTemperature
                + "°C, цель " + targetTemperature + "°C";
    }
}

class Blinds extends SmartDevice {
    private final int maxAngle;
    private int currentAngle;

    public Blinds(int maxAngle, int currentAngle) {
        this.maxAngle = maxAngle;
        setAngle(currentAngle);
    }

    public void open() {
        currentAngle = maxAngle;
    }

    public void close() {
        currentAngle = 0;
    }

    public void setAngle(int newAngle) {
        if (newAngle > maxAngle) {
            newAngle = maxAngle;
        }
        if (newAngle < 0) {
            newAngle = 0;
        }
        currentAngle = newAngle;
    }

    @Override
    public String getStatus() {
        String status;
        if (isOn()) {
            status = "включены";
        } else {
            status = "выключены";
        }
        return "Жалюзи: " + status + ", угол " + currentAngle + "°/" + maxAngle + "°";
    }
}

public class Main {
    static void printAll(List<SmartDevice> devices) {
        for (SmartDevice device : devices) {
            System.out.println(device.getStatus());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Lamp lamp = new Lamp(100, 50);
        Thermostat thermostat = new Thermostat(20, 15);
        Blinds blinds = new Blinds(180, 90);

        List<SmartDevice> devices = new ArrayList<>();
        devices.add(lamp);
        devices.add(thermostat);
        devices.add(blinds);

        System.out.println("Начальное состояние");
        printAll(devices);

        lamp.turnOn();
        lamp.setBrightness(80);

        thermostat.turnOn();
        thermostat.setTargetTemperature(24);

        blinds.turnOn();
        blinds.setAngle(120);

        System.out.println("После изменения");
        printAll(devices);

        thermostat.setCurrentTemperature(24);
        lamp.turnOff();
        blinds.close();

        System.out.println("Ещё раз изменили");
        printAll(devices);
    }
}
