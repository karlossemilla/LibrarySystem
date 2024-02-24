import java.util.ArrayList;
import java.util.List;

interface LibraryItem {
    void borrowItem();
    void returnItem();
    boolean isBorrowed();
}

class Book implements LibraryItem {
    private String title;
    private String author;
    private int publicationYear;
    private boolean borrowed;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.borrowed = false;
    }

    @Override
    public void borrowItem() {
        if (!borrowed) {
            borrowed = true;
            System.out.println("Book \"" + title + "\" has been borrowed.");
        } else {
            System.out.println("Book is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (borrowed) {
            borrowed = false;
            System.out.println("Book \"" + title + "\" has been returned.");
        } else {
            System.out.println("Book is not currently borrowed.");
        }
    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + publicationYear + ")";
    }
}


class DVD implements LibraryItem {
    private String title;
    private String director;
    private int runningTime;
    private boolean borrowed;

    public DVD(String title, String director, int runningTime) {
        this.title = title;
        this.director = director;
        this.runningTime = runningTime;
        this.borrowed = false;
    }

    @Override
    public void borrowItem() {
        if (!borrowed) {
            borrowed = true;
            System.out.println("DVD \"" + title + "\" has been borrowed.");
        } else {
            System.out.println("DVD is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (borrowed) {
            borrowed = false;
            System.out.println("DVD \"" + title + "\" has been returned.");
        } else {
            System.out.println("DVD is not currently borrowed.");
        }
    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }

    @Override
    public String toString() {
        return title + " directed by " + director + " (" + runningTime + " mins)";
    }
}

abstract class LibraryUser {
    protected List<LibraryItem> borrowedItems;

    public LibraryUser() {
        this.borrowedItems = new ArrayList<>();
    }

    public void borrowItem(LibraryItem item) {
        item.borrowItem();
        borrowedItems.add(item);
    }

    public void returnItem(LibraryItem item) {
        item.returnItem();
        borrowedItems.remove(item);
    }

    public abstract void printItemsBorrowed();
}


class Student extends LibraryUser {
    @Override
    public void printItemsBorrowed() {
        System.out.println("Student's Borrowed Items:");
        for (LibraryItem item : borrowedItems) {
            System.out.println("- " + item.toString());
        }
    }
}


class Teacher extends LibraryUser {
    @Override
    public void printItemsBorrowed() {
        System.out.println("Teacher's Borrowed Items:");
        for (LibraryItem item : borrowedItems) {
            System.out.println("- " + item.toString());
        }
    }
}


public class LibraryManagementSystem {
    public static void main(String[] args) {
        
        Book mathBook = new Book("Math", "Al Somido", 2003);
        DVD ben10DVD = new DVD("Ben 10", "Chris Pimentel", 97);

        
        Student gregg = new Student();
        Teacher danny = new Teacher();

       
        gregg.borrowItem(ben10DVD);
        danny.borrowItem(mathBook);

        
        System.out.println("Student: Gregg");
        gregg.printItemsBorrowed();
        System.out.println();

        System.out.println("Teacher: Danny");
        danny.printItemsBorrowed();
        System.out.println();

        
        gregg.returnItem(ben10DVD);
        danny.returnItem(mathBook);

        
        System.out.println("Student: Gregg");
        gregg.printItemsBorrowed();
        System.out.println();

        System.out.println("Teacher: Danny");
        danny.printItemsBorrowed();
    }
}
