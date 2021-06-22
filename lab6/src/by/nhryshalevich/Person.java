package by.nhryshalevich;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.Collection;

public class Person extends Thread {
    private String firstName;
    private String lastName;
    private Library lib;
    // Books that a person took out
    private Map<Integer, Book> takenOutBooks;
    // Books that a person took in reading room
    private Map<Integer, Book> inReadingRoomBooks;

    public Person(String firstName, String lastName, Library lib) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lib = lib;
        takenOutBooks = new HashMap<Integer, Book>();
        inReadingRoomBooks = new HashMap<Integer, Book>();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<Integer, Book> getTakenOutBooks() {
        return this.takenOutBooks;
    }

    public void setTakenOutBooks(Book[] books) {
        Map<Integer, Book> booksInLib = lib.getBooks();
        takenOutBooks = new HashMap<Integer, Book>();
        for (Book book: books) {
            if (booksInLib.containsKey(book.hashCode())
                && !book.getReadingRoomOnly()) {
                    takenOutBooks.put(book.hashCode(), book);
            }
        }
    }

    public Library getLib() {
        return this.lib;
    }

    public void setLib(Library lib) {
        this.lib = lib;
    }

    public Map<Integer, Book> getInReadingRoomBooks() {
        return this.inReadingRoomBooks;
    }

    public void setInReadingRoomBooks(Book[] books) {
        Map<Integer, Book> booksInLib = lib.getBooks();
        inReadingRoomBooks = new HashMap<Integer, Book>();
        for (Book book: books) {
            if (booksInLib.containsKey(book.hashCode())) {
                inReadingRoomBooks.put(book.hashCode(), book);
            }
        }
    }

    public void borrowBook(Book book) throws IllegalAccessException {
        lib.borrowBook(book);
        takenOutBooks.put(book.hashCode(), book);
    }

    public void takeBookInReadingRoom(Book book) throws IllegalAccessException {
        lib.takeBookInReadingRoom(book);
        inReadingRoomBooks.put(book.hashCode(), book);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public void run() {
        /* Borrow one book and take one book in reading room
         */
        int bookIndex = 0;
        Book[] allBooks = lib.getAllAvailableBooks();
        while (takenOutBooks.isEmpty()) {
            bookIndex = new Random().nextInt(allBooks.length);
            try {
                borrowBook(allBooks[bookIndex]);
                try {
                    Thread.sleep(1);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            catch(IllegalAccessException e) {
                continue;
            }
        }
        System.out.println(toString() + " has just taken "
                           + allBooks[bookIndex].toString());

        allBooks = lib.getAllAvailableBooks();
        while (inReadingRoomBooks.isEmpty()) {
            bookIndex = new Random().nextInt(allBooks.length);
            try {
                takeBookInReadingRoom(allBooks[bookIndex]);
                try {
                    Thread.sleep(1);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            catch(IllegalAccessException e) {
                continue;
            }
        }

        System.out.println(toString() + " has just taken "
                           + allBooks[bookIndex].toString()
                           + " in reading room");
    }

    public void dropOffAllBook() {
        for (Book book: takenOutBooks.values()) {
            lib.dropOffBook(book);
        }
        takenOutBooks = new HashMap<Integer, Book>();
        for (Book book: inReadingRoomBooks.values()) {
            lib.dropOffBook(book);
        }
        inReadingRoomBooks = new HashMap<Integer, Book>();
    }
}
