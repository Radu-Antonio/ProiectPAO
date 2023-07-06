package service;

import model.Client;
import model.Librarian;
import model.Library;
import model.Book;

public class LibraryService {
    Library library;

    public LibraryService(String name) {
        library = new Library(name);

        library.addBookInLibrary(new Book("The Great Gatsby", "F. Scott Fitzgerald", "A tale of love, wealth, and tragedy.", 25.99));
        library.addBookInLibrary(new Book("To Kill a Mockingbird", "Harper Lee", "A powerful story of justice and racism.", 19.99));
        library.addBookInLibrary(new Book("1984", "George Orwell", "A dystopian novel depicting a totalitarian future.", 15.99));
        library.addBookInLibrary(new Book("Pride and Prejudice", "Jane Austen", "A classic romance exploring societal expectations.", 12.99));
        library.addBookInLibrary(new Book("The Lord of the Rings", "J.R.R. Tolkien", "An epic fantasy quest to destroy a powerful ring.", 29.99));
        library.addBookInLibrary(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "The beginning of a magical journey.", 18.99));
        library.addBookInLibrary(new Book("To the Lighthouse", "Virginia Woolf", "A stream-of-consciousness novel about life and art.", 16.99));
        library.addBookInLibrary(new Book("The Catcher in the Rye", "J.D. Salinger", "A coming-of-age story of teenage angst.", 14.99));
        library.addBookInLibrary(new Book("Moby-Dick", "Herman Melville", "The hunt for the great white whale.", 21.99));
        library.addBookInLibrary(new Book("Jane Eyre", "Charlotte Brontë", "A tale of a governess and her tumultuous love.", 17.99));
        library.addBookInLibrary(new Book("The Odyssey", "Homer", "The epic adventure of Odysseus.", 13.99));
        library.addBookInLibrary(new Book("Brave New World", "Aldous Huxley", "A futuristic society controlled by technology.", 20.99));
        library.addBookInLibrary(new Book("The Hobbit", "J.R.R. Tolkien", "Bilbo Baggins' unexpected journey.", 19.99));
        library.addBookInLibrary(new Book("The Great Expectations", "Charles Dickens", "A young man's struggle for wealth and love.", 15.99));
        library.addBookInLibrary(new Book("Wuthering Heights", "Emily Brontë", "A haunting tale of love and revenge.", 12.99));
        library.addBookInLibrary(new Book("The Alchemist", "Paulo Coelho", "A mystical journey of self-discovery.", 16.99));
        library.addBookInLibrary(new Book("The Scarlet Letter", "Nathaniel Hawthorne", "A story of sin, guilt, and redemption.", 14.99));
        library.addBookInLibrary(new Book("Animal Farm", "George Orwell", "A political allegory of power and corruption.", 17.99));
        library.addBookInLibrary(new Book("The Picture of Dorian Gray", "Oscar Wilde", "A portrait reflects the darkness of the soul.", 21.99));
        library.addBookInLibrary(new Book("Frankenstein", "Mary Shelley", "The creation of a monster and its consequences.", 18.99));
        library.addBookInLibrary(new Book("Don Quixote", "Miguel de Cervantes", "An imaginative knight and his adventures.", 15.99));
        library.addBookInLibrary(new Book("The Adventures of Tom Sawyer", "Mark Twain", "A mischievous boy and his escapades.", 13.99));
        library.addBookInLibrary(new Book("The Brothers Karamazov", "Fyodor Dostoevsky", "A complex exploration of faith and morality.", 19.99));
        library.addBookInLibrary(new Book("Alice's Adventures in Wonderland", "Lewis Carroll", "A whimsical journey down the rabbit hole.", 16.99));
        library.addBookInLibrary(new Book("Gone with the Wind", "Margaret Mitchell", "The epic love story set during the Civil War.", 23.99));

        library.addClient(new Client("John Doe"));
        library.addClient(new Client("Emma Johnson"));
        library.addClient(new Client("Michael Smith"));
        library.addClient(new Client("Sophia Brown"));
        library.addClient(new Client("David Wilson"));
        library.addClient(new Client("Olivia Davis"));
        library.addClient(new Client("James Miller"));
        library.addClient(new Client("Ava Taylor"));
        library.addClient(new Client("Daniel Anderson"));
        library.addClient(new Client("Mia Thomas"));
        library.addClient(new Client("Matthew Martinez"));
        library.addClient(new Client("Charlotte Anderson"));
        library.addClient(new Client("Ethan Garcia"));
        library.addClient(new Client("Amelia Robinson"));
        library.addClient(new Client("Alexander Young"));
        library.addClient(new Client("Emily White"));
        library.addClient(new Client("William Hall"));
        library.addClient(new Client("Abigail Clark"));
        library.addClient(new Client("Benjamin Lewis"));
        library.addClient(new Client("Sofia Lee"));

        library.addWorker(new Librarian("Sarah Johnson", 4500.0));
        library.addWorker(new Librarian("Michael Anderson", 4800.0));
        library.addWorker(new Librarian("Emily Wilson", 4200.0));
        library.addWorker(new Librarian("David Thompson", 5000.0));
        library.addWorker(new Librarian("Jennifer Roberts", 4700.0));
    }

    public void seeAllWorkers() {
        library.showWorkers();
    }

    public void seeAllClients() {
        library.showClients();
    }

    public void seeAllBooks() {
        library.showBooksInLibrary();
    }

    public void addBook(Book b) {
        library.addBookInLibrary(b);
    }

    public void removeBook(Book b) {
        library.removeBookFromLibrary(b);
    }

    public void addClient(Client c) {
        library.addClient(c);
    }

    public void addLibrarian(Librarian l) {
        library.addWorker(l);
    }

    public void showSalary(Librarian librarian) {
        System.out.println(librarian.getSalary());
    }

    public void showPrice(Book book) {
        System.out.println(book.getPrice());
    }

    public void showClientBooks(Client client) {
        client.showBorrowedBooks();
    }

    public void showClientSortedBooks(Client client) {
        client.sortBooksByPrice();
        client.showBorrowedBooks();
    }

    public void showClientAmountToPay(Client client) {
        System.out.println(client.getTotalAmountToPay());
    }

    public void addClientBook(Client c, Book b) {
        c.addBook(b);
    }

    public void payClientBook(Client c, Book b) {
        c.payBook(b);
    }
}
