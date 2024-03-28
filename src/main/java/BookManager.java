import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {
    // List to hold books instances.
    private final List<Book> books;

    /**
     * BookManager constructor that creates an ArrayList to hold a dynamic length list of books.
     */
    public BookManager() {
        this.books = new ArrayList<>();
    }

    /**
     * Adds a book to the book ArrayList. Takes user input and validates it.
     */
    public void addBook() {
        String title;
        String isbn;
        int year;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a title:");
        title = scanner.nextLine();
        if (!validateTitle(title)) return;

        Name name = inputName(scanner);
        if (name == null) return;

        System.out.println("Enter book isbn:");
        isbn = scanner.nextLine();
        if(!validateIsbn(isbn)) return;

        System.out.println("Enter a publishing year.");
        year = scanner.nextInt();
        if(!validateYear(year)) return;

        books.add(new Book(isbn, year, title, name));
        System.out.println("Book added successfully.");
    }

    /**
     * Validates title strings
     * @param title title to be validated
     * @return returns true if title is valid and false if it is invalid.
     */
    private boolean validateTitle(String title) {
        if (title.isEmpty()) {
            System.out.println("\n** Title cannot be empty **\n\n");
            return false;
        }
        return true;
    }

    /**
     * Validates ISBN
     * @param isbn ISBN to be validated. checks if it is a string with 10 or 13 digits using regex
     * @return true if valid and false if invalid
     */
    private boolean validateIsbn(String isbn) {
        if (!isbn.matches("^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$")) {
            System.out.println("\n** ISBN does not contain 10 or 13 digits. **\n\n");
            return false;
        }
        return true;
    }

    /**
     * Validates year integers
     * @param year year to be validated. Must be greater than 0 and less than or equal to current year.
     * @return true if valid and false if invalid
     */
    private boolean validateYear(int year) {
        if (!(year > 0 && year <= Year.now().getValue())) {
            System.out.println("Year must be greater than 0 and equal to or less than current year.");
            return false;
        }
        return true;
    }

    /**
     *  Takes user inputs to generate a name object
     * @param s Scanner object instances for inputs
     * @return A validated name object.
     */
    private Name inputName(Scanner s) {
        String givenName;
        String middleName;
        String lastName;

        System.out.println("Names can be left blank, but at least one name must be filled\n");
        System.out.println("Enter the author given name/s");
        givenName = s.nextLine();

        System.out.println("Enter the author middle name/s");
        middleName = s.nextLine();

        System.out.println("Enter the author family name/s");
        lastName = s.nextLine();

        try {
            return new Name(givenName, middleName, lastName);
        } catch(Exception e) {
            System.out.println("\n** At least one name must be filled out **\n\n");
            return null;
        }
    }

    /**
     * Deletes a book by taking user input to search for an ISBN and asks for confirmation before deleting.
     */
    public void deleteBook() {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter a book isbn number to delete");

        String isbn = s.nextLine();

        boolean found = false;
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                found = true;

                System.out.println(book);
            }
        }

        if (found) {
            System.out.println("\n Are you sure you want to delete? [Y/n]");
        } else {
            System.out.println("Book not found.");
            return;
        }

        String res = s.nextLine();
        while (true) {
            if (res.equals("n") || res.equals("N")) {
                return;
            } else if (res.equals("y") || res.equals("Y")) {
                books.removeIf(book -> book.getIsbn().equals(isbn));
                System.out.println("Book deleted successfully");
                return;
            } else {
                System.out.println("Please enter 'y' or 'n'");
            }
        }
    }

    /**
     * Updates one or more book attributes by searching for a book by ISBN
     */
    public void updateBook() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a book isbn number to update");
        String isbn = s.nextLine();

        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                System.out.println(book);
                inputUpdate(book);
            }
        }

        System.out.println("Book not found.");
    }

    /**
     * Takes user inputs to update a book object
     * @param book the book to be updated.
     */
    private void inputUpdate (Book book) {
        Scanner s = new Scanner(System.in);

        System.out.println("What would you like to update?");
        System.out.println("enter all that apply seperated by commas.");
        System.out.println("1) Title");
        System.out.println("2) Author name");
        System.out.println("3) ISBN");
        System.out.println("4) Publication year.\n");

        String choices = s.nextLine();
        String[] choiceArr = choices.split(",");

        for (String c : choiceArr) {
            c = c.trim();
            switch(Integer.parseInt(c)) {
                case 1:
                    System.out.println("Enter a title:");
                    String title = s.nextLine();
                    if (!validateTitle(title)) return;
                    book.setTitle(title);
                    break;
                case 2:
                    Name name = inputName(s);
                    if (name == null) return;
                    book.setName(name);
                    break;
                case 3:
                    System.out.println("Enter book isbn:");
                    String isbn = s.nextLine();
                    if(!validateIsbn(isbn)) return;
                    book.setIsbn(isbn);
                    break;
                case 4:
                    System.out.println("Enter a publishing year.");
                    int year = s.nextInt();
                    if(!validateYear(year)) return;
                    book.setYear(year);
                    break;
                default:
                    System.out.println("Invalid input.");
                    return;
            }
        }
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
