package vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity,
                fuelConsumptionPerKm,
                tankCapacity);
    }

    @Override
    public void drive(double distance) {
        double fuelSpent = fuelQuantity - ((fuelConsumptionPerKm + 1.6) * distance);
        if (fuelSpent < 0) {
            System.out.println("Truck needs refueling");
            return;
        }
        this.fuelQuantity = fuelSpent;
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(String.format("Truck travelled %s km", df.format(distance)));
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
        double refueledTank = liters * 0.95;
        this.fuelQuantity += refueledTank;
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", this.fuelQuantity);
    }
}
