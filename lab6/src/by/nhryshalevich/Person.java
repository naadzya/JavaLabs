package by.nhryshalevich;

import java.util.Map;
import java.util.HashMap;

public class Person {
    private String firstName;
    private String lastName;
    // Books that a person took out
    private Map<Integer, Book> takenOutBooks;
    // Books that a person took in reading room
    private Map<Integer, Book> inReadingRoomBooks;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public void setTakenOutBooks(Library lib, Book[] books) {
        Map<Integer, Book> booksInLib = lib.getBooks();
        takenOutBooks = new HashMap<Integer, Book>();
        for (Book book: books) {
            if (booksInLib.containsKey(book.hashCode())
                && !book.getReadingRoomOnly()) {
                    takenOutBooks.put(book.hashCode(), book);
            }
        }
    }

    public Map<Integer, Book> getInReadingRoomBooks() {
        return this.inReadingRoomBooks;
    }

    public void setInReadingRoomBooks(Library lib, Book[] books) {
        Map<Integer, Book> booksInLib = lib.getBooks();
        inReadingRoomBooks = new HashMap<Integer, Book>();
        for (Book book: books) {
            if (booksInLib.containsKey(book.hashCode())) {
                inReadingRoomBooks.put(book.hashCode(), book);
            }
        }
    }

}
