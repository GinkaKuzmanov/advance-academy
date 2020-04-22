package exercises.P04_DetailPrinter;

public abstract class Employee {
    private final String name;

    public Employee(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    protected abstract String provideDetails();

    @Override
    public String toString(){
        return this.getName();
    }
}
