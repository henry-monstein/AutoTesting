package by.epam.automatedtesting.dmitrylishko.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private List<Integer> marks;
    private String name;
    private String surname;

    public Student(int[] marks, String name, String surname) {
        setMarks(marks);
        this.name = name;
        this.surname = surname;
    }

    private void setMarks(int[] marks) {
        this.marks = new ArrayList<>();
        for (int mark : marks) {
            this.marks.add(mark);
        }

    }

    private void setMark(int mark, int i) {
        marks.add(i, mark);
    }

    public int getMark(int i) {
        return marks.get(i);
    }

    public Integer[] getMarks() {
        return marks.toArray(new Integer[marks.size()]);
    }

    
}
