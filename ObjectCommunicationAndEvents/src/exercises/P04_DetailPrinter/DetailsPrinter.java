package exercises.P04_DetailPrinter;

import java.util.List;

public class DetailsPrinter {

    private Iterable<Employee> employees;

    public DetailsPrinter(Iterable<Employee> employees) {
        this.employees = employees;
    }



    public void printDetails() {
        for (Employee employee : employees) {
            System.out.println(employee.provideDetails());
        }
    }

}
