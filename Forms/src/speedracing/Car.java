package speedracing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private int distanceTravelled;


    public Car(String model, double fuelAmount, double fuelCostPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distanceTravelled = 0;
    }

    public double getFuelCostPerKm() {
        return this.fuelCostPerKm;
    }

    public boolean canTravelDistance(int distance) {
        double costOfTravelFuel = this.fuelCostPerKm * distance;
        return this.fuelAmount >= costOfTravelFuel;
    }

    public void decreaseFuel(double reduceFuel) {
        this.fuelAmount -= reduceFuel;
    }

    public void increaseDistance(int distanceTravel) {
        this.distanceTravelled += distanceTravel;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTravelled);
    }
}