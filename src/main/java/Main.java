import java.util.Scanner;

/**
 * Entry point and main program loop
 */
public class Main {
    /**
     * @param args Command line arguments, unused
     */
    public static void main(String[] args) {
        BookManager manager = new BookManager();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("Book Management System");
            System.out.println("[1] Add Book");
            System.out.println("[2] Delete Book");
            System.out.println("[3] Update Book");
            System.out.println("[4] List Books");
            System.out.println("[5] Exit");
            System.out.print("Enter option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    manager.addBook();
                    break;
                case 2:
                    manager.deleteBook();
                    break;
                case 3:
                    manager.updateBook();
                    break;
                case 4:
                    manager.listBooks();
                    break;
                case 5:
                    run = false;
                    System.out.println("Thanks for managing!");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

    }
}
