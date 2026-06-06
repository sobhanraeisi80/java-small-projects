package ir.ac.kntu.lms.items;

public class Book extends Item {
    private String author;
    private int numberOfPages;
    private String ISBN;

    public Book() {super.increaseInventory();}

    public Book(String title, String category, String author, String ISBN, int publishYear , int numberOfPages) {
        super(title, category, publishYear);
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.ISBN = ISBN;
        super.increaseInventory();
    }

    @Override
    public String toString() {
        return "Book info: "+ super.toString() + 
            "\nAuthor: " + author +
            "\nNumber Of Pages: " + numberOfPages +
            "\nISBN: " + ISBN;
    }
}
