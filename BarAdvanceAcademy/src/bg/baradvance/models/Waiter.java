package bg.baradvance.models;

public class Waiter {
    private String name;
    private String pinCode;

    public Waiter(String name, String pinCode) {
        this.name = name;
        this.pinCode = pinCode;
    }

    public String getName() {
        return this.name;
    }

    public String getPinCode() {
        return this.pinCode;
    }
}
