package by.nhryshalevich;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

public class Library {
    private Map<Integer, Book> books;

    public Library() {
        books = new HashMap<Integer, Book>();
    }

    public Library(Book[] books) {
        this.books = new HashMap<Integer, Book>();
        for (Book book: books) {
            this.books.put(book.hashCode(), book);
        }
    }

    public Map<Integer, Book> getBooks() {
        return this.books;
    }

    public void setBooks(Map<Integer, Book> books) {
        this.books = books;
    }

    public int[] longestTitleAuthor() {
        /* Return length of the the longest title
         * and length the longest author
         */
        int titleLength = 0, authorLength = 0;
        for (Book book: books.values()) {
            if (titleLength == 0 || book.getTitle().length() > titleLength) {
                titleLength = book.getTitle().length();
            }
            if (authorLength == 0 || book.getAuthor().length() > authorLength) {
                authorLength = book.getAuthor().length();
            }
        }
        return new int[] {titleLength, authorLength};
    }

    public Book[] getAllAvailableBooks() {
        ArrayList<Book> allBooks = new ArrayList<Book>();
        for (Book book: books.values()) {
            if (!book.getIsCheckedOut()) {
                allBooks.add(book);
            }
        }
        return allBooks.toArray(new Book[0]);
    }

    public Book[] getAllAvailableReadingRoomBooks() {
        ArrayList<Book> allBooks = new ArrayList<Book>();
        for (Book book: books.values()) {
            if (!book.getIsCheckedOut() && book.getReadingRoomOnly()) {
                allBooks.add(book);
            }
        }
        return allBooks.toArray(new Book[0]);
    }

    @Override
    public String toString() {
        int[] maxLengths = longestTitleAuthor();
        String result = " Title" + " ".repeat(maxLengths[0] - 5)
            + " | Author" + " ".repeat(maxLengths[1] - 6)
            + " | is checked out | reading room only\n"
             + "-".repeat(maxLengths[0] + 2) + "+"
            + "-".repeat(maxLengths[1] + 2) + "+"
            + "-".repeat(16) + "+" + "-".repeat(19) + "\n";
        for (Book entry : books.values()) {
            int additionalChar = entry.getIsCheckedOut() ? 1 : 0;
            result += " " + entry.getTitle()
                      + " ".repeat(maxLengths[0] - entry.getTitle().length())
                      + " | " + entry.getAuthor()
                      + " ".repeat(maxLengths[1] - entry.getAuthor().length())
                      + " | " + String.valueOf(entry.getIsCheckedOut())
                      + " ".repeat(9 + additionalChar)
                      + " | " + String.valueOf(entry.getReadingRoomOnly())
                      + " ".repeat(13) + " \n";
        }
        result += "-".repeat(42 + maxLengths[0] + maxLengths[1]) + "\n";
        return result;
    }

    public void borrowBook(Book book) throws IllegalAccessException {
        /* Borrow book NOT in reading room */
        if (! books.containsKey(book.hashCode())) {
            throw new IllegalAccessException("Book is not found in library");
        }
        if (book.getIsCheckedOut() || book.getReadingRoomOnly()) {
            throw new IllegalAccessException("The book is already taken out or can be borrowed only in reading room");
        }
        book.setIsCheckedOut(true);
    }

    public void takeBookInReadingRoom(Book book) throws IllegalAccessException {
        if (! books.containsKey(book.hashCode())) {
            throw new IllegalAccessException("Book is not found in library");
        }
        if (book.getIsCheckedOut()) {
            throw new IllegalAccessException("Book is already taken out");
        }
        book.setIsCheckedOut(true);
    }

    public void dropOffBook(Book book) {
        book.setIsCheckedOut(false);
    }
}
