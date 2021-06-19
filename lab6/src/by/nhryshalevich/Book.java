package by.nhryshalevich;

public class Book {
    private String title;
    private String author;
    private boolean isCheckedOut = false;
    private boolean readingRoomOnly;

    public Book(String title, String author, boolean readingRoomOnly) {
        this.title = title;
        this.author = author;
        this.readingRoomOnly = readingRoomOnly;
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

    public boolean getReadingRoomOnly() {
        return this.readingRoomOnly;
    }

    public void setReadingRoomOnly(boolean readingRoomOnly) {
        this.readingRoomOnly = readingRoomOnly;
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
