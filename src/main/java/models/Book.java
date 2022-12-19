package models;

import lombok.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String bookID;
    private String title;
    private String author;
    private static boolean isAvailable;

    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20s", this.getBookID(), this.getTitle(), this.getAuthor());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getBookID().equals(book.getBookID()) && getTitle().equals(book.getTitle()) && getAuthor().equals(book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookID(), getTitle(), getAuthor());
    }
}
