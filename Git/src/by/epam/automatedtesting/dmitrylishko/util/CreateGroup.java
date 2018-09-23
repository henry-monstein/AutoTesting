package by.epam.automatedtesting.dmitrylishko.util;

import by.epam.automatedtesting.dmitrylishko.model.entity.Group;
import by.epam.automatedtesting.dmitrylishko.model.entity.Student;

import java.util.ArrayList;

public class CreateGroup {
    public static Group create(String groupName, String... studentsLines) {
        ArrayList<Student> students = new ArrayList<>();
        for (String studentsLine : studentsLines) {
            String[] splitline = parseLine(studentsLine);
            int[] marks = new int[splitline.length-2];
            for (int i=0;i<marks.length;i++) {
                marks[i]=Integer.valueOf(splitline[i+2]);
            }
            students.add(new Student(marks,splitline[0],splitline[1]));
        }
        return new Group(groupName, students.toArray(new Student[students.size()]));
    }

    private static String[] parseLine(String string) {
        String spliter = " ";
        return string.split(spliter);
    }
}
