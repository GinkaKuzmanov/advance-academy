package exercises;

import exercises.P01_ExtendedArrayList.ExtendedArrayList;
import exercises.P03_GraphicEditor.Circle;
import exercises.P03_GraphicEditor.GraphicEditor;
import exercises.P03_GraphicEditor.Rectangle;
import exercises.P03_GraphicEditor.Shape;
import exercises.P04_DetailPrinter.Accountant;
import exercises.P04_DetailPrinter.DetailsPrinter;
import exercises.P04_DetailPrinter.Employee;
import exercises.P04_DetailPrinter.Manager;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> docs = new ArrayList<>();
        docs.add("Files");
        docs.add("Monthly profit");

        Employee manager = new Manager("John",docs);
        Employee accountant = new Accountant("Maria",docs);
        List<Employee> employees = new ArrayList<>();
        employees.add(manager);
        employees.add(accountant);

        DetailsPrinter dp = new DetailsPrinter(employees);
        dp.printDetails();
    }
}
