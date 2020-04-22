package exercises.P04_DetailPrinter;

public class Accountant extends Employee {

    private final Iterable<String> duties;

    public Accountant(String name, Iterable<String> duties) {
        super(name);
        this.duties = duties;
    }

    @Override
    protected String provideDetails() {
        return super.toString() + this.duties.toString();
    }
}
