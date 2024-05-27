package lms;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LMS implements Serializable {
    private static final long serialVersionUID = 1L;

    List<Book> books = new ArrayList<>();
    List<BorrowRecord> borrowRecords = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    public boolean borrowBook(Book book, Student student) {
        if (books.contains(book)) {
            borrowRecords.add(new BorrowRecord(book, student));
            books.remove(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        for (BorrowRecord record : borrowRecords) {
            if (record.book.equals(book)) {
                books.add(book);
                borrowRecords.remove(record);
                return true;
            }
        }
        return false;
    }

    public void saveState(String filePath) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LMS loadState(String filePath) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return (LMS) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static class BorrowRecord implements Serializable {
        private static final long serialVersionUID = 1L;
        Book book;
        Student student;

        public BorrowRecord(Book book, Student student) {
            this.book = book;
            this.student = student;
        }
    }
}

