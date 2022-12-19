package models;
import Enums.TypeOfUser;
import services.implementation.LibrarySerivicesImplementation;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LibrarySerivicesImplementation libraryServices = new LibrarySerivicesImplementation();

        HashMap <Book, Integer> newBooks = new HashMap<>();
        Book book1 = new Book("Bk/101e", "Mathematics","James Brook");
        newBooks.put(book1, 10);
        newBooks.put(new Book("Bk/101e", "English","James Bond"), 20);
        newBooks.put(new Book("Bk/111m", "Civil","Philips Celestine"), 10);
        newBooks.put(new Book("Bk/121p", "Physics","Crane Hike"), 10);
        newBooks.put(new Book("Bk/131l", "Literature","Light Wright"), 15);
        newBooks.put(new Book("Bk/141g", "Geograghy","Emeke Uchenna"), 10);
        newBooks.put(new Book("Bk/151c", "Chemistry","Samuel Brook"), 20);

        Library.setLibraryBooks(newBooks);

        libraryServices.displayAllBooks(Library.getLibraryBooks());
        System.out.println();

        //check if the book the user is requesting for is available in the library
        Book book2 = new Book("Bk/111h", "History","Abraham Links");
        libraryServices.checkAvailability(Library.getLibraryBooks(), book1);
        libraryServices.checkAvailability(Library.getLibraryBooks(), book2);
        System.out.println();

        //add new book to the library
        System.out.println(libraryServices.addBooks(newBooks, book2, 10));
        System.out.println();
        System.out.println("------------------------------------------------------------------------");

        List<User> userList = new ArrayList<>();
        userList.add(new User("LB/100", "Moses Abuka", TypeOfUser.TEACHER,"Chemistry"));
        userList.add(new User("LB/104", "John Abuka", TypeOfUser.SENIOR_STUDENT, "English"));
        userList.add(new User("LB/105", "Ambrose Jennifer", TypeOfUser.JUNIOR_STUDENT, "Physic"));
        userList.add(new User("LB/107", "Mary James", TypeOfUser.TEACHER, "Geography"));
        userList.add(new User("LB/108", "Oluchi Giddy", TypeOfUser.JUNIOR_STUDENT, "Literature"));
        Library.setUsers(userList);



        User user3 = new User("Mary", "ust/120", TypeOfUser.TEACHER, "Mathematics");
        User user2 = new User("Joyce", "ust/119", TypeOfUser.JUNIOR_STUDENT, "Mathematics");
        User user1 = new User("Janet", "ust/149", TypeOfUser.SENIOR_STUDENT, "Mathematics");
        User user4 = new User("John", "ust/159", TypeOfUser.JUNIOR_STUDENT, "Mathematics");
        User user5 = new User("James", "ust/169", TypeOfUser.TEACHER, "Mathematics");


      // priority queue
        PriorityQueue<User> libraryPriorityQueue = Library.getUserPriorityQueue();
        libraryPriorityQueue.add(user2);
        libraryPriorityQueue.add(user1);
        libraryPriorityQueue.add(user3);
        libraryPriorityQueue.add(user4);
        libraryPriorityQueue.add(user5);

      // Normal queue
        Queue<User> libraryNormalQueue = Library.getUserFIFOQueue();
        libraryNormalQueue.add(user1);
        libraryNormalQueue.add(user2);
        libraryNormalQueue.add(user4);

        libraryServices.giveBookToUserBasedOnPriority(libraryPriorityQueue, Library.getLibraryBooks(), book1);
        libraryServices.giveBookToUserBasedOnFIFO(libraryNormalQueue, Library.getLibraryBooks(), book1);

    }
}