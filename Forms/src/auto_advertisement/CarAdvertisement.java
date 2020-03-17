package auto_advertisement;

public class CarAdvertisement {
    private String subjectTitle;
    private String description;
    private Car cars;

    public CarAdvertisement(String subjectTitle, String description, Car cars) {
        this.subjectTitle = subjectTitle;
        this.description = description;
        this.cars = cars;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }


    public String getDescription() {
        return description;
    }


    public Car getCars() {
        return cars;
    }


    @Override
    public String toString() {
        return String.format("Title: %s%nDescription: %s%nCar: %s", this.getSubjectTitle(),
                this.getDescription(), this.getCars());
    }
}
