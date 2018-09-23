package by.epam.automatedtesting.dmitrylishko.controller;

import static by.epam.automatedtesting.dmitrylishko.model.logic.AverageMark.*;

import by.epam.automatedtesting.dmitrylishko.model.entity.Group;
import by.epam.automatedtesting.dmitrylishko.util.CreateGroup;
import by.epam.automatedtesting.dmitrylishko.view.Read;

public class Main {

    public static void main(String[] args) {
        String fileName = "./resources/students.txt";
        Group group = CreateGroup.create("Dead", Read.readFromFile(fileName));
        System.out.println("Average mark of " + group.getName() + ": " + averageMark(group));
    }
}
