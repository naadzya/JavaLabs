package by.nhryshalevich;

import java.util.Map;
import java.util.HashMap;

public class Person {
    private String firstName;
    private String lastName;
    private Map<Book> checkedBooks;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        checkedBooks = new HashMap<Book>();
    }

    public Person(String firstName, String lastName, Set<Book> checkedBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.checkedBooks = checkedBooks;
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

    public Set<Book> getCheckedBooks() {
        return this.checkedBooks;
    }

    public void setCheckedBooks(Set<Book> checkedBooks) {
        this.checkedBooks = checkedBooks;
    }

}
