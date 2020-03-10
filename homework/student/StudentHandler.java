package homework.student;

import java.util.List;

public final class StudentHandler {
    private StudentHandler() {
    }


    public static void sortGrades(Student student) {
        List<Double> grades = student.getGrades();
        boolean isSwapped = false;
        for (int i = 0; i < grades.size() - 1; i++) {
            //check the all elements up to current index
            for (int j = 0; j < grades.size() - i - 1; j++) {
                if (grades.get(j) > grades.get(j + 1)) {
                    double temp = grades.get(j);
                    grades.set(j, grades.get(j + 1));
                    grades.set(j + 1, temp);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }

    public static double getAverageGradeById(Student student) {
        double grade;
        grade = student.getGrades().stream().mapToDouble(e -> e).average().getAsDouble();
        return grade;
    }
}
