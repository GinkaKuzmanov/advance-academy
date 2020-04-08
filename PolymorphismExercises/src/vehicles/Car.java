package vehicles;


import java.text.DecimalFormat;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm,tankCapacity);
    }

    @Override
    public void drive(double distance){
        double fuelSpent = fuelQuantity - ((fuelConsumptionPerKm + 0.9) * distance);
        if(fuelSpent < 0){
            System.out.println("Car needs refueling");
            return;
        }
        this.fuelQuantity = fuelSpent;
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(String.format("Car travelled %s km",df.format(distance)));
    }

    @Override
    public void refuel(double liters) {
        if(liters<=0){
            System.out.println("Fuel must be a positive number");
            return;
        }
        if ((this.fuelQuantity + liters) > this.tankCapacity) {
            System.out.println("Cannot fit fuel in tank");
            return;
        }
        this.fuelQuantity += liters;
    }
    @Override
    public String toString() {
        return String.format("Car: %.2f",this.fuelQuantity);
    }

}
