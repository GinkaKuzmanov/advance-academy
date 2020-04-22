package exercises.P04_DetailPrinter;

public class Manager extends Employee {

    private final Iterable<String> documents;

    public Manager(String name, Iterable<String> documents) {
        super(name);
        this.documents = documents;
    }



    @Override
    protected String provideDetails() {
        return super.toString() + this.documents.toString();
    }
}
