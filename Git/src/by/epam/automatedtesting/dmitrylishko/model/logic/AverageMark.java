package by.epam.automatedtesting.dmitrylishko.model.logic;

import by.epam.automatedtesting.dmitrylishko.model.entity.Group;
import by.epam.automatedtesting.dmitrylishko.model.entity.Student;

public class AverageMark {
    public static double averageMark(Group group) {
        int sumOfMarks= 0;
        int amountOfMarks=0;
        for(Student student : group.getStudents()){
            for (int mark : student.getMarks()) {
                sumOfMarks+=mark;
                amountOfMarks++;
            }
        }
        return (double)sumOfMarks/(double)amountOfMarks;
    }
}
