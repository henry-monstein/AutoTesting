package by.epam.automatedtesting.dmitrylishko.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private List<Student> students;
    private String name;

    public Group( String name, Student... students) {
        setStudents(students);
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(Student... students) {
        this.students=new ArrayList<>();
        for (Student student: students) {
            this.students.add(student);
        }
    }

    public Student getStudent(int i) {
        return students.get(i);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
