package companyrooster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Employee> employees = Department.getEmployees();

        int count = Integer.parseInt(reader.readLine());

        Employee employee = null;
        while (count > 0) {

            String[] tokens = reader.readLine().split("\\s+");
            switch (tokens.length) {
                case 6:
                    double salary = Double.parseDouble(tokens[1]);
                    int age = Integer.parseInt(tokens[5]);
                    employee = new Employee(tokens[0], salary, tokens[2], tokens[3], tokens[4], age);
                    break;
                case 5:
                    try {
                        int age2 = Integer.parseInt(tokens[4]);
                        employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3], age2);
                        employee.setEmail("n/a");
                    } catch (NumberFormatException nfe) {
                        employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3], tokens[4]);
                        employee.setAge(-1);
                    }
                    break;
                case 4:
                    employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3]);
                    employee.setEmail("n/a");
                    employee.setAge(-1);
                    break;

            }
            employees.add(employee);
            count--;
        }

        //have to print the department with highest,average salary
        //have to print employees sorted by salary in descending order;
        //collecors grouping by; turns the list into map with key as group -> Department in our case
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment)).entrySet()
                .stream().sorted((e1, e2) ->
                Double.compare(
                        e2.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble(),
                        e1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble())

        ).limit(1).forEach(dept -> {
                    StringBuilder sb = new StringBuilder();

                    sb.append(String.format("Highest Average Salary: %s", dept.getKey())).append(System.lineSeparator());

                    dept.getValue().stream().sorted(
                            Comparator.comparing(Employee::getSalary, Comparator.reverseOrder())
                    ).forEach(employee1 -> sb.append(employee1).append(System.lineSeparator()));

                    System.out.println(sb.toString());

                }
        );

    }


}

