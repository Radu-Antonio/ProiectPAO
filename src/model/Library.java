package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Library {
    public String name;
    public HashMap<Book, Integer> books;
    public HashSet<Client> clients;
    public HashSet<Librarian> librarians;

    public Library(String name) {
        this.name = name;
        this.books = new HashMap<>();
        this.clients = new HashSet<>();
        this.librarians = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void addBookInLibrary(Book b) {
        if (books.containsKey(b)) {
            books.put(b, books.get(b) + 1);
        } else {
            books.put(b, 1);
        }
        System.out.println("Cartea " + b.getTitle() + " a fost luata de biblioteca " + this.name);
    }

    public void removeBookFromLibrary(Book b) {
        if (!books.containsKey(b)) {
            System.out.println("Cartea nu este detinuta de biblioteca " + this.name);
            return;
        }
        if (books.get(b) <= 1) {
            books.remove(b);
        } else {
            books.put(b, books.get(b) - 1);
        }
        System.out.println("Cartea " + b.getTitle() + " a fost scoasa din biblioteca " + this.name);
    }

    public void addClient(Client c) {
        clients.add(c);
    }

    public void addWorker(Librarian l) {
        librarians.add(l);
    }

    public void showBooksInLibrary() {
        for (Map.Entry<Book, Integer> book : books.entrySet()) {
            System.out.println(book.getValue() + " carti " + book.getKey().getTitle());
        }
    }

    public void showClients() {
        for (Client client : clients) {
            System.out.println(client.getName());
        }
    }

    public void showWorkers() {
        for (Librarian librarian : librarians) {
            System.out.println(librarian.getName());
        }
    }
}
