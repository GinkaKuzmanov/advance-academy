package vehicles;

import java.text.DecimalFormat;

public class Bus extends Vehicle {

    public Bus(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm, tankCapacity);
    }

    @Override
    public void drive(double distance) {
        double fuelSpent = this.fuelQuantity - ((this.fuelConsumptionPerKm + 1.4) * distance);
        if (fuelSpent < 0) {
            System.out.println("Bus needs refueling");
            return;
        }
        this.fuelQuantity = fuelSpent;
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(String.format("Bus travelled %s km", df.format(distance)));

    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
        }
        if ((this.fuelQuantity + liters) > this.tankCapacity) {
            System.out.println("Cannot fit fuel in tank");
            return;
        }
        this.fuelQuantity += liters;
    }

    public void driveEmpty(double distance) {
        double fuelSpent = this.fuelQuantity - distance;
        if(fuelSpent < 0){
            System.out.println("Bus needs refueling");
            return;
        }
        this.fuelQuantity = fuelSpent;
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(String.format("Bus travelled %s km", df.format(distance)));
    }

    public String toString() {
        return String.format("Bus: %.2f", this.fuelQuantity);
    }
}
