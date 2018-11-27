package homeWork3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;

public class Group {
    private Student[] students = new Student[10];

    public void add(Student student){
        boolean added = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null){
                students[i] = student;
                added = true;
                break;
            }
        }
        if (!added) throw new StudentOperationException(student);
    }

    public void delete(String lastName){
        students[getIndex(lastName)] = null;
    }

    public int getIndex(String lastName){
        for (int i = 0; i < students.length -1; i++) {
            if (students[i] != null && students[i].getLastName().equalsIgnoreCase(lastName)) return i;
        }
        throw new InputMismatchException();
    }

    @Override
    public String toString(){
        Student[] sortedStudents = students;
        String formattedStudents = "";
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                if (student1 != null && student2 != null)
                    return student1.getLastName().compareToIgnoreCase(student2.getLastName());
                else return 1;
            }
        });
        for (Student student: sortedStudents) {
            formattedStudents += student + "\n";
        }
        return formattedStudents;
    }

    public static void main(String[] args) {
        Group group = new Group();
        try {
            group.add(new Student("Ivan", "Karko", 18, 90));
            group.add(new Student("Lena", "Baskova", 18, 60));
            group.add(new Student("Petr", "Azirov", 18, 110));
            group.add(new Student("Petr", "Udo", 18, 110));
            group.add(new Student("Petr", "Ali", 18, 110));
            group.add(new Student("Petr", "Torba", 18, 110));
            group.add(new Student("Petr", "Kent", 18, 110));
            group.add(new Student("Tom", "Star", 18, 110));
            group.add(new Student("Yas", "One", 18, 110));
            group.add(new Student("Don", "Won", 18, 110));
            group.add(new Student("Petr", "Unlucky", 18, 110));
        } catch (StudentOperationException soe){
            System.out.println("Error adding " + soe.getObject().toString());
            System.out.println("Cause " + soe.getMessage());
        }
        try {
            group.delete("Wonty");
        } catch (InputMismatchException ime){
            System.out.println("Student to delete not found!");
        }
        System.out.println(group);
    }
}

class StudentOperationException extends Error{
    private Student object;

    public StudentOperationException(Student object) {
        this.object = object;
    }

    public Student getObject() {
        return object;
    }

    @Override
    public String getMessage() {
        return "Not enough space.";
    }
}