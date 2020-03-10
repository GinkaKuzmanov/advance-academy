package homework.student;

import java.util.List;


public class Student {
    private int studentId;
    private String name;
    private List<Double> grades;

    public Student() {
    }

    public Student(int studentId, String name, List<Double> grades) {
        this.studentId = studentId;
        this.name = name;
        this.setGrades(grades);
    }

    private void setGrades(List<Double> grades) {
        if(grades.size() < 5){
            throw new IllegalArgumentException("Въведете поне пет оценки.");
        }
        this.grades = grades;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public int getStudentId() {
        return studentId;
    }



}
