package lms;

public class LMSTester {
    public static void main(String[] args) {
        // Creating a new LMS instance
        LMS iliauniLibrary = new LMS();

        // Adding books to the library
        Book lor = new Book("Lord of the rings", "tolkien");
        Book oop = new Book("OOP", "paata gogisvhili");
        iliauniLibrary.addBook(lor);
        iliauniLibrary.addBook(oop);

        // Borrowing books
        Student gocha = new Student("Gocha", "Gegeshidze", "dfasdf");
        iliauniLibrary.borrowBook(lor, gocha);

        Student maka = new Student("Maka", "Lobjanidze", "3421325");
        iliauniLibrary.borrowBook(oop, maka);

        // Saving state
        iliauniLibrary.saveState("libraryState.txt");

        // Loading state into a new LMS instance
        LMS loadedLibrary = LMS.loadState("libraryState.txt");

        // Displaying loaded state
        if (loadedLibrary != null) {
            System.out.println("Library state loaded successfully.");
            // Optionally, you can add code here to verify the loaded state
        } else {
            System.out.println("Failed to load library state.");
        }
    }
}


