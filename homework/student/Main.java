package homework.student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

public class Main {
    public static Student student;
    public static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Колко студенти ще въведете?");
        int numberOfStudents = Integer.parseInt(reader.readLine());
        try {
            while (numberOfStudents-- > 0) {
                System.out.println("студентски номер, име, оценки: моля въведете всяко поле на нов ред:");
                int id = Integer.parseInt(reader.readLine());
                String name = reader.readLine();
                List<Double> grades = Arrays.stream(reader.readLine().split("\\s+"))
                        .map(Double::parseDouble).collect(Collectors.toList());

                student = new Student(id, name, grades);
                //sort student grades;
                StudentHandler.sortGrades(student);
                //въвеждаме от клавиатурата няколко студенти и добавяме в списък
                students.add(student);
            }

        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Въведете ИД, за да видите средната оценка");
        int studentID = Integer.parseInt(reader.readLine());

        for (Student stud : students) {
            if(stud.getStudentId() == studentID) {
                System.out.println(String.format("Средна оценка: %.2f", StudentHandler.getAverageGradeById(stud)));
            }
        }
    }

}
