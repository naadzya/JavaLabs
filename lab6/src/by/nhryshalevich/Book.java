package by.nhryshalevich;

public class Book {
    private String title;
    private String author;
    private boolean isCheckedOut = false;

    public Book(title, author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean getIsCheckedOut() {
        return this.isCheckedOut;
    }

    public void setIsCheckedOut(boolean isCheckedOut) {
        this.isCheckedOut = isCheckedOut;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + title.hashCode();
        hash = 31 * hash + author.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        return author + " - \"" + title + "\"";
    }
}
