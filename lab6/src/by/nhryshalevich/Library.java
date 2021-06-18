package by.nhryshalevich;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;

public class Library {
    private Set<Book> books;

    public Library() {
        books = new HashSet<Book>();
    }

    public Library(Book[] books) {
        this.books.addAll(Arrays.asList(books));
    }

    public Library(List<Book> books) {
        this.books.addAll(books);
    }

    public Set<Book> getBooks() {
        return this.books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

}
