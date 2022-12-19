package services;

import models.Book;
import models.User;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public interface LibraryServices {
    String addBooks(HashMap<Book, Integer> booksList, Book book, Integer noOfCopies);
    String giveBookToUserBasedOnPriority(Queue<User> userPriorityQueue, HashMap<Book, Integer> booksList, Book book);
    String giveBookToUserBasedOnFIFO(Queue<User> userFIFOQueue, HashMap<Book, Integer> booksList, Book book);
    String displayAllBooks(HashMap<Book, Integer> booksAvailable);
    String checkAvailability(HashMap<Book, Integer> booksAvailable, Book book);
}

