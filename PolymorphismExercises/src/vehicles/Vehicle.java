package vehicles;

public abstract class Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumptionPerKm;
    protected double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        this.tankCapacity = tankCapacity;
    }

    private void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }
        this.fuelQuantity = fuelQuantity;
    }

    public abstract void drive(double distance);

    public abstract void refuel(double liters);


}
