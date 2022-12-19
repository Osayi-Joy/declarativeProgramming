package services.implementation;

import Enums.TypeOfUser;
import models.Book;
import models.Library;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class LibrarySerivicesImplementationTest {
    Book book2;
    HashMap <Book, Integer> newBooks;
    LibrarySerivicesImplementation libraryServices;
    Book book1;
    PriorityQueue<User> libraryPriorityQueue;
    Queue<User> libraryNormalQueue;
    User user1, user2, user3, user4, user5;

    @BeforeEach
    void setUp() {
        libraryServices = new LibrarySerivicesImplementation();
        newBooks = new HashMap<>();
        book1 = new Book("Bk/101e", "English","James Brook");
        newBooks.put(book1, 10);
        newBooks.put(new Book("Bk/101e", "English","James Bond"), 20);
        newBooks.put(new Book("Bk/111m", "Mathematics","Philips Celestine"), 10);
        newBooks.put(new Book("Bk/121p", "Physics","Crane Hike"), 10);
        newBooks.put(new Book("Bk/131l", "Literature","Light Wright"), 15);
        newBooks.put(new Book("Bk/141g", "Geograghy","Emeke Uchenna"), 10);
        newBooks.put(new Book("Bk/151c", "Chemistry","Samuel Brook"), 20);

        book2 = new Book("Bk/111h", "History","Abraham Links");

        user1 = new User("Janet", "ust/149", TypeOfUser.SENIOR_STUDENT, "Mathematics");
        user2 = new User("Joyce", "ust/119", TypeOfUser.JUNIOR_STUDENT, "Mathematics");
        user3 = new User("Mary", "ust/120", TypeOfUser.TEACHER, "Mathematics");
        user4 = new User("John", "ust/159", TypeOfUser.JUNIOR_STUDENT, "Mathematics");
        user5 = new User("John", "ust/169", TypeOfUser.TEACHER, "Mathematics");

        libraryPriorityQueue = Library.getUserPriorityQueue();
        libraryPriorityQueue.add(user1);
        libraryPriorityQueue.add(user2);
        libraryPriorityQueue.add(user3);
        libraryPriorityQueue.add(user4);
        libraryPriorityQueue.add(user5);

        libraryNormalQueue = Library.getUserFIFOQueue();
        libraryNormalQueue.add(user1);
        libraryNormalQueue.add(user2);
        libraryNormalQueue.add(user4);


    }

    @Test
    void addBooks() {
        book2 = new Book("Bk/111h", "History","Abraham Links");
        String expected = "Successfully added the new book to the library";
        assertEquals(expected, libraryServices.addBooks(newBooks, book2, 10));
    }

    @Test
    void giveBookToUserBasedOnPriority() {
        String expected = "User has collected a book based on priority";
        assertEquals(expected, libraryServices.giveBookToUserBasedOnPriority(libraryPriorityQueue, newBooks, book1));
    }

    @Test
    void giveBookToUserBasedOnFIFO() {
        String expected = "User has collected a book based on first come first serve";
        assertEquals(expected, libraryServices.giveBookToUserBasedOnFIFO(libraryNormalQueue, newBooks, book1));
    }
    @Test
    void displayAllBooks() {
        String expected = "This is the list of books available in the library";
        assertEquals(expected, libraryServices.displayAllBooks(newBooks));
    }

    @Test
    void checkAvailability() {
        String expected = "This book is available";
        assertEquals(expected, libraryServices.checkAvailability(newBooks, book1));
    }

    @Test
    void notAvailability() {
        String expected = "Book is taken";
        assertEquals(expected, libraryServices.checkAvailability(newBooks, book2));
    }
}