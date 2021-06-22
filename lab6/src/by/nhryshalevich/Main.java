package by.nhryshalevich;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int defaultMenu() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose from these options:");
        System.out.println("0 - Quit");
        System.out.println("1 - Add new person in group");
        System.out.println("2 - Get all books in Library");
        System.out.println("3 - Let all people in the group borrow one book and take one book in reading room");
        System.out.println("4 - Drop off all the books");
        System.out.print("Your choise: ");

        selection = input.nextInt();
        return selection;
    }

    public static Person addPerson(Library lib) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the firstname and lastname of a person: ");
        String firstName = input.next();
        String lastName = input.next();
        return new Person(firstName, lastName, lib);
    }

    public static void main(String args[]) {
        Book[] testBooks = {
                new Book("A Walk To Remember", "Nicolas Sparks", false),
                new Book("To Kill a Mackingbird", "Harper Lee", false),
                new Book("Alice's Adventures in Wonderland", "Lewis Carroll", false),
                new Book("Pride and Prejudice", "Jane Austen", false),
                new Book("Me Before You", "Jojo Mores", false),
                new Book("They Do It With Mirrors", "Agata Christie", true),
                new Book("Winnie-the-Pooh", "Alan Milne", true),
                new Book("Heaven Has No Favorites", "Erich Maria Remarque", true),
                new Book("The Collector", "John Fowles", true),
                new Book("The Book Thief", "Markus Zusak", true)
        };
        Library newLibrary = new Library(testBooks);
        ArrayList<Person> people = new ArrayList<Person>();

        int userChoice = defaultMenu();
        while (userChoice != 0) {
            switch(userChoice) {
                case 1:
                    if (people.size() < 5) {
                        people.add(addPerson(newLibrary));
                    };
                    break;
                case 2:
                    System.out.println("All books in the Library:\n\n"
                                       + newLibrary.toString());
                    break;
                case 3:
                    List<Thread> threadList = new ArrayList<Thread>();
                    try {
                        people.parallelStream().forEach(item -> item.start());
                    }
                    catch (IllegalThreadStateException e) {
                        break;
                    }
                    for (int i = 0; i < people.size(); i++) {
                        try {
                            people.get(i).join();
                        }
                        catch (InterruptedException e) {
                           e.printStackTrace();
                        }
                    }
                    break;
                case 4:
                    for (Person person: people) {
                        person.dropOffAllBook();
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Wrong input. Try again");
            }
            userChoice = defaultMenu();
        }
        System.out.println("Bye!");
    }
}
