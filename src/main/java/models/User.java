package models;
import Enums.TypeOfUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String userID;
    private TypeOfUser typeOfUser;
    private static boolean hasCollectedABook;
    private String bookName;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20s%-20s\n", this.getUserID(), this.getName(), this.getTypeOfUser(), this.getBookName());
    }


}