package model;

import java.util.Objects;

public class Book implements Comparable<Book>{
    static int currId = 0;
    protected int id;
    private String title;
    private String author;
    private String content;
    private double price;

    public Book(String title, String author, String content, double price) {
        this.id = currId++;
        this.title = title;
        this.author = author;
        this.content = content;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Book b) {
        return Double.compare(this.price, b.price);
    }

    @Override
    public String toString() {
        return "Titlu: " + title + ", autor: " +
                author + ", pret: " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && Double.compare(book.price, price) == 0
                && Objects.equals(title, book.title)
                && Objects.equals(author, book.author)
                && Objects.equals(content, book.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, content, price);
    }
}
