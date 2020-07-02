import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

public class Student {

    private long id;
    private String name;
    private List<Integer> grades;

    public Student(long id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new ArrayList<Integer>();
    }

    public Student(long id, String name, List<Integer> grades) {
        this.id = id;
        this.name = name;
        this.grades = new ArrayList<Integer>(grades);
//        allStudents.add(this); // example if you wanted a method to add the entire object to a static array list
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getGrades() {
        return grades;
    }
    public void addGrade(int grade) {
        grades.add(grade);
    }

    public void updateGrade(int index, int grade) {
        try {
            this.grades.set(index, grade);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(index + " is an invalid index, adding grade instead.");
//            addGrade(grade);
        }
    }

    public void deleteGrade(int index) {
        try {
            this.grades.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(index + " is an invalid index.");
            e.printStackTrace();
        }
    }

    public double getGradeAverage() {
        double allGrades = 0;
        for(Integer i : this.getGrades()){
            allGrades += i;
        }
        double gradeAverage = allGrades/this.grades.size();
        DecimalFormat df = new DecimalFormat("0.##");
        return parseDouble(df.format(gradeAverage));
    }

}
