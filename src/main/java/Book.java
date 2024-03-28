/**
 * Represents a printed book. Contains very little validation, which should be handled by BookManager.
 */
public class Book {
    // Title of the book
    private String title;
    // Name of the book's author.
    private Name name;
    // Unique ISBN number
    private String isbn;
    // Year
    private int year;

    /**
     * @param isbn A book's ISBN
     * @param year A book's publication year.
     * @param title A book's title
     * @param name A book's author's name
     */
    public Book(String isbn, int year, String title, Name name) {
        this.title = title;
        this.name = name;
        this.isbn = isbn;
        this.year = year;
    }

    /**
     * @return String represting a book's title
     */
    public String getTitle() { return title; }

    /**
     * Updates a book's title
     * @param title A new title string
     */
    public void setTitle(String title) {this.title = title;}

    /**
     * @return The author's name in the format first middle, last names.
     */
    public String getAuthor() { return name.toString(); }

    /**
     * @param name An instance of a name object that represents the book's author's name.
     */
    public void setName(Name name) {this.name = name;}

    /**
     * @return A book's unique ISBN number
     */
    public String getIsbn() { return isbn; }

    /**
     * @param isbn New value for a book's ISBN.
     */
    public void setIsbn(String isbn) {this.isbn = isbn;}

    /**
     * @return A book's publication year.
     */
    public int getYear() { return year; }

    /**
     * @param year update's a books publication year.
     */
    public void setYear(int year) {this.year = year;}

    /**
     * @return And improved string to display a book's information.
     */
    @Override
    public String toString() {
        return "\n" +
                "Title: " + title + '\n' +
                "Author: " + name.getLastFirst() + '\n' +
                "Isbn: " + isbn + '\n' +
                "Year: " + year +
                "\n";
    }
}
