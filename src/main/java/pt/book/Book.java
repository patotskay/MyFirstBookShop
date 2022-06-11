package pt.book;

public class Book {
    public Book(String name, String author, double price, String category, int numberOfPages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.category = category;
        this.numberOfPages = numberOfPages;
    }

    private String name;
    private String author;
    private double price;
    private String category;
    private int numberOfPages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNumberofPages() {
        return numberOfPages;
    }

    public void setNumberofPages(int numberofpages) {
        this.numberOfPages = numberOfPages;
    }
}
