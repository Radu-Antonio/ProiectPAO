package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Client extends Person{
    public ArrayList<Book> borrowedBooks;

    public Client(String name) {
        super(name);
        this.borrowedBooks = new ArrayList<>();
    }

    public void showBorrowedBooks() {
        for (Book book : borrowedBooks) {
            System.out.println(book);
        }
    }

    public double getTotalAmountToPay() {
        double amount = 0;
        for (Book book : borrowedBooks) {
            amount += book.getPrice();
        }
        return amount;
    }

    public void sortBooksByPrice() {
        Collections.sort(borrowedBooks);
    }

    public void payBook(Book b) {
        int idx = borrowedBooks.indexOf(b);
        if (idx == -1) {
            System.out.println("Cartea nu ii apartine clientului " + this.getName());
        } else {
            borrowedBooks.remove(idx);
            System.out.println("Clientul " + this.getName() + " a platit cartea " + b.getTitle() + " cu pretul " + b.getPrice());
        }
    }

    public void addBook(Book b) {
        borrowedBooks.add(b);
        System.out.println("Clientul " + this.getName() + " a luat cartea " + b.getTitle());
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(borrowedBooks, client.borrowedBooks)
                && Objects.equals(client.getName(), this.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(borrowedBooks, this.getName());
    }
}
