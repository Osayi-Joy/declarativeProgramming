package services.implementation;
import models.Book;
import models.Library;
import models.User;
import services.LibraryServices;
import java.util.HashMap;
import java.util.Queue;

public class LibrarySerivicesImplementation implements LibraryServices {

    @Override
    public String addBooks(HashMap<Book, Integer> booksList, Book book, Integer noOfCopies) {
        String result = "Successfully added the new book to the library";
        if (booksList.containsKey(book)) {
            result = "Copies of this book already exist in the library";
        } else {
            booksList.put(book, noOfCopies);
        }
        return result;
    }

    @Override
    public String giveBookToUserBasedOnPriority(Queue<User> userPriorityQueue, HashMap<Book, Integer> booksList, Book book) {
        //use ava
        booksList = Library.getLibraryBooks();
        userPriorityQueue = Library.getUserPriorityQueue();
        System.out.println("Displaying the order of priority to get books from the library: ");
        formatDisplay(userPriorityQueue, booksList, book);
        return "User has collected a book based on priority";
    }

    @Override
    public String giveBookToUserBasedOnFIFO(Queue<User> userFIFOQueue, HashMap<Book, Integer> booksList, Book book) {
        booksList = Library.getLibraryBooks();
        userFIFOQueue = Library.getUserFIFOQueue();
        System.out.println("Displaying the order of first come first serve to get books from the library: ");
        formatDisplay(userFIFOQueue, booksList, book);
        return "User has collected a book based on first come first serve";
    }

    @Override
    public String displayAllBooks(HashMap<Book, Integer> booksAvailable) {
        System.out.printf("%-20s%-20s%-20s%-20s","BOOKID", "BOOK TITLE","BOOK AUTHOR", "NO_OF_COPIES");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
      //change this to .forEach(System.out::printlb
        booksAvailable.forEach((key, value) -> System.out.println("Key : " + key + " Value : " + value));
        return "This is the list of books available in the library";
    }


    //TODO change the book object argument to string
    //use stream to carryout the condition
    public String checkAvailability(HashMap<Book, Integer> booksAvailable, Book book){
    if(booksAvailable.containsKey(book)){
            System.out.println(book + " is Available");
            return "This book is available";
        }
        System.out.println(book + " this book is not available");
            return "Book is taken";
    }
//throw exception that the book is taken


    public static void formatDisplay(Queue<User> userPriorityQueue, HashMap<Book, Integer> booksList, Book book) {
        System.out.printf("%-20s%-20s%-20s%-20s","USER_ID", "USER_NAME","TYPE_OF_USER", "BOOK_REQUESTING");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println(userPriorityQueue);
        System.out.println("the first on the priority queue is: \n" + userPriorityQueue.poll());
        System.out.println("the second on the priority queue is: \n" + userPriorityQueue.poll());
        int noOfBooks = booksList.get(book);
        noOfBooks = noOfBooks - 1;
        booksList.put(book, noOfBooks);
        System.out.println("Copies of this book left in the library: " + noOfBooks);
    }

}
