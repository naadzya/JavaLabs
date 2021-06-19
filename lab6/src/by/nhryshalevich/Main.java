package by.nhryshalevich;

public class Main {
    public static void main(String args[]) {
        Book testBook1 = new Book("A Walk To Remember", "Nicolas Sparks", false);
        Book testBook2 = new Book("To Kill a Mackingbird", "Harper Lee", false);
        Book testBook3 = new Book("They Do It With Mirrors", "Agata Christie", true);
        Book testBook4 = new Book("Holy Bible", "The Lord", true);

        Library newLibrary = new Library(new Book[]{testBook1, testBook2,
                                                    testBook3, testBook4});
        Person newPerson = new Person("John", "Smith");
        System.out.println(newLibrary.toString());
        newPerson.setTakenOutBooks(newLibrary, new Book[]{testBook1, testBook2});
        newPerson.setInReadingRoomBooks(newLibrary, new Book[]{testBook3, testBook4});
        System.out.println(newPerson.getTakenOutBooks());
        System.out.println(newPerson.getInReadingRoomBooks());
    }
}
