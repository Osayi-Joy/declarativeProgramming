package models;

import Enums.TypeOfUser;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Getter
@Setter
public class Library {

    private static PriorityQueue<User> userPriorityQueue = new PriorityQueue<>(Comparator.comparing(User::getTypeOfUser));

    private static Queue<User> userFIFOQueue = new LinkedList<>();
    private static HashMap<Book, Integer> LibraryBooks = new HashMap<>();
    private static List<User> users = new ArrayList<>();


        public static PriorityQueue<User> getUserPriorityQueue() {
            return userPriorityQueue;
        }

        public static void setUserPriorityQueue(PriorityQueue<User> userPriorityQueue) {
            Library.userPriorityQueue = userPriorityQueue;
        }

        public static Queue<User> getUserFIFOQueue() {
            return userFIFOQueue;
        }

        public static void setUserFIFOQueue(Queue<User> userFIFOQueue) {
            Library.userFIFOQueue = userFIFOQueue;
        }

        public static HashMap<Book, Integer> getLibraryBooks() {
            return LibraryBooks;
        }

        public static void setLibraryBooks(HashMap<Book, Integer> libraryBooks) {
            LibraryBooks = libraryBooks;
        }

        public static List<User> getUsers() {
            return users;
        }

        public static void setUsers(List<User> users) {
            Library.users = users;
        }
}

