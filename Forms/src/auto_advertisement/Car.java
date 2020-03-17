package auto_advertisement;

public class Car {
    private String brand;
    private String model;
    private String yearProduced;

    public Car(String brand, String model, String yearProduced) {
        this.brand = brand;
        this.model = model;
        this.yearProduced = yearProduced;
    }


    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getYearProduced() {
        return yearProduced;
    }

    @Override
    public String toString() {
        return String.format("%s - %s, produced in %s", this.getBrand(), this.getModel(), this.getYearProduced());
    }
}
