package by.epam.automatedtesting.dmitrylishko.view;

public class Printer {
    public static void printToConsole(String... messages) {
        for(String message: messages) {
            System.out.println(message);
        }
    }
}
