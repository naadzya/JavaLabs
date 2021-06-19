package by.nhryshalevich;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;

public class Library {
    private Map<Integer, Book> books;

    public Library() {
        books = new HashMap<Book>();
    }

    public Library(Book[] books) {
        books = new HashMap<Book>;
        for (Book book: books) {
            this.books.put(book.hashCode(), book);
        }
    }

    // public Library(List<Book> books) {
        // this.books.addAll(books);
    // }

    public Map<Book> getBooks() {
        return this.books;
    }

    public void setBooks(Map<Book> books) {
        this.books = books;
    }

    public Integer[] longestTitleAuthor() {
        /* Return length of the the longest title
         * and length the longest author
         */
        int titleLength = 0, authorLength = 0;
        for (Book book: books.getBooks()) {
            if (titleLength == 0 || book.getTitle().length() > titleLength) {
                titleLength = book.getTitle().length();
            }
            if (authorLength == 0 || book.getAuthor().length() > authorLength) {
                authorLength = book.getAuthor().length();
            }
        }
        return new Integet[] {titleLength, authorLength};
    }

    @Override
    public String toString {
        result = "";
        Integer[] maxLengths = longestTitleAuthor();
        for (Book entry : books.values()) {
            result += "| " + entry.getTitle()
                      + " ".repeat(maxlength[0] - entry.getTitle().length())
                      + " | " + entry.getAuthor()
                      + " ".repeat(maxlength[1] - entry.getAuthor().length())
                      + " |\n"
        }
        return result;
    }

    public void borrowBook(Book book) {

    }
}
