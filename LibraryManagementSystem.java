import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Available: " + isAvailable;
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayInventory() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding some sample books
        library.addBook(new Book("English", " mingma"));
        library.addBook(new Book("Computer", "kanchi"));
        library.addBook(new Book("Mathematics", "ramila"));
        library.addBook(new Book("Physics", "ujjwal"));
        library.addBook(new Book("Chemistry", "sneha"));



        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Display Inventory");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    library.displayInventory();
                    break;
                case 2:
                    System.out.print("Enter the title of the book to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    Book borrowBook = library.findBookByTitle(borrowTitle);
                    if (borrowBook != null && borrowBook.isAvailable()) {
                        borrowBook.setAvailability(false);
                        System.out.println("You have borrowed: " + borrowBook.getTitle());
                    } else {
                        System.out.println("Book not found or unavailable.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = scanner.nextLine();
                    Book returnBook = library.findBookByTitle(returnTitle);
                    if (returnBook != null && !returnBook.isAvailable()) {
                        returnBook.setAvailability(true);
                        System.out.println("You have returned: " + returnBook.getTitle());
                    } else {
                        System.out.println("Book not found or already returned.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the Library Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
