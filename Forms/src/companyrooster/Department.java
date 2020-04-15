package companyrooster;

import java.util.ArrayList;
import java.util.List;

public class Department  {
    private static List<Employee> employees = new ArrayList<>();

    public static List<Employee> getEmployees() {
        return employees;
    }
}
