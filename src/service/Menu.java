package service;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import model.*;

public class Menu {
    LibraryService service;
    AuditService audit;
    public Menu() throws IOException {
        service = new LibraryService("Libraria lui Antonio");
        audit = new AuditService();
    }

    public void showOptions() {
        System.out.println("Actiuni: ");
        System.out.println(" 0. Iesire program");
        System.out.println(" 1. Vizualizarea tuturor librarilor");
        System.out.println(" 2. Vizualizarea tuturor clientilor");
        System.out.println(" 3. Vizualizarea tuturor cartilor");
        System.out.println(" 4. Adaugarea unei carti in librarie");
        System.out.println(" 5. Scoaterea unei carti din librarie");
        System.out.println(" 6. Adaugarea unui client in librarie");
        System.out.println(" 7. Adaugarea unui lucrator in librarie");
        System.out.println(" 8. Vizualizarea salariului unui librar");
        System.out.println(" 9. Vizualizarea pretului unei carti");
        System.out.println("10. Vizualizarea cartilor unui client");
        System.out.println("11. Vizualizarea cartilor sortate dupa pret ale unui client");
        System.out.println("12. Vizualizarea pretului pe care il are de platit un client");
        System.out.println("13. Adaugare carte pentru un client");
        System.out.println("14. Platire carte pentru un client");
    }

    public void run() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (true) {
            showOptions();
            option = scanner.nextInt();

            switch (option) {
                case 0 -> {
                    System.out.println("La revedere!");
                    audit.logMessage("iesim din program ");
                    audit.closeFileHandler();
                    System.exit(0);
                }
                case 1 -> {
                    service.seeAllWorkers();
                    audit.logMessage("am vizualizat angajatii ");
                }
                case 2 -> {
                    service.seeAllClients();
                    audit.logMessage("am vizualizat clientii ");
                }
                case 3 -> {
                    service.seeAllBooks();
                    audit.logMessage("am vizualizat cartile librariei ");
                }
                case 4 -> {
                    System.out.println("Adaugare carte noua in librarie");
                    System.out.println("Titlu: ");
                    String title = scanner.next();
                    System.out.println("Autor: ");
                    String author = scanner.next();
                    System.out.println("Continut: ");
                    String content = scanner.next();
                    System.out.println("Pret: ");
                    double price = scanner.nextDouble();

                    service.addBook(new Book(title, author, content, price));
                    audit.logMessage("am adaugat o noua carte in librarie ");
                }
                case 5 -> {
                    System.out.println("Eliminare carte din librarie");
                    System.out.println("Titlu: ");
                    String title = scanner.next();
                    System.out.println("Autor: ");
                    String author = scanner.next();
                    System.out.println("Continut: ");
                    String content = scanner.next();
                    System.out.println("Pret: ");
                    double price = scanner.nextDouble();

                    service.removeBook(new Book(title, author, content, price));
                    audit.logMessage("am scos o carte din librarie ");
                }
                case 6 -> {
                    System.out.println("Adaugare client nou");
                    System.out.println("Nume: ");

                    service.addClient(new Client(scanner.next()));
                    audit.logMessage("am adaugat un client nou librarii ");
                }
                case 7 -> {
                    System.out.println("Adaugare librar nou");
                    System.out.println("Nume: ");
                    String name = scanner.next();
                    System.out.println("Salariu: ");

                    service.addLibrarian(new Librarian(name, scanner.nextDouble()));
                    audit.logMessage("am adaugat un nou angajat librarii ");
                }
                case 8 -> {
                    System.out.println("Vizualizare salariu angajat");
                    System.out.println("id angajat: ");
                    int id = scanner.nextInt();

                    for (Librarian l : service.library.librarians) {
                        if (l.getId() == id) {
                            service.showSalary(l);
                            break;
                        }
                    }
                    audit.logMessage("am vizualizat salariul unui angajat ");
                }
                case 9 -> {
                    System.out.println("vizualizare pret carte");
                    System.out.println("id carte: ");
                    int id = scanner.nextInt();

                    for (Map.Entry<Book, Integer> book : service.library.books.entrySet()) {
                        if (book.getKey().getId() == id) {
                            service.showPrice(book.getKey());
                            break;
                        }
                    }
                    audit.logMessage("am vizualizat pretul unei carti ");
                }
                case 10 -> {
                    System.out.println("vizualizarea cartilor unui client");
                    System.out.println("id client: ");
                    int id = scanner.nextInt();

                    for (Client c : service.library.clients) {
                        if (c.getId() == id) {
                            service.showClientBooks(c);
                            break;
                        }
                    }
                    audit.logMessage("am vizualizat cartile unui client ");
                }
                case 11 -> {
                    System.out.println("vizualizarea cartilor unui client sortate dupa pret");
                    System.out.println("id client: ");
                    int id = scanner.nextInt();

                    for (Client c : service.library.clients) {
                        if (c.getId() == id) {
                            service.showClientSortedBooks(c);
                            break;
                        }
                    }
                    audit.logMessage("am vizualizat cartile sortate dupa pret ale unui client ");
                }
                case 12 -> {
                    System.out.println("vizualizare suma totala de platit ale unui client");
                    System.out.println("id client: ");
                    int id = scanner.nextInt();

                    for (Client c : service.library.clients) {
                        if (c.getId() == id) {
                            service.showClientAmountToPay(c);
                            break;
                        }
                    }
                    audit.logMessage("am vizualizat suma de plata a unui clienta ");
                }
                case 13 -> {
                    System.out.println("adaugare carte pentru client");
                    System.out.println("id client: ");
                    int idc = scanner.nextInt();
                    System.out.println("id carte: ");
                    int idb = scanner.nextInt();
                    Client client = null;
                    Book book = null;

                    for (Client c : service.library.clients) {
                        if (c.getId() == idc) {
                            client = c;
                            break;
                        }
                    }
                    for (Map.Entry<Book, Integer> b : service.library.books.entrySet()) {
                        if (b.getKey().getId() == idb) {
                            book = b.getKey();
                            break;
                        }
                    }
                    service.addClientBook(client, book);
                    audit.logMessage("un client a luat o carte ");
                }
                case 14 -> {
                    System.out.println("platire carte de la client");
                    System.out.println("id client: ");
                    int idc = scanner.nextInt();
                    System.out.println("id carte: ");
                    int idb = scanner.nextInt();
                    Client client = null;
                    Book book = null;

                    for (Client c : service.library.clients) {
                        if (c.getId() == idc) {
                            client = c;
                            break;
                        }
                    }
                    for (Book b : client.borrowedBooks) {
                        if (b.getId() == idb) {
                            book = b;
                            break;
                        }
                    }
                    service.payClientBook(client, book);
                    audit.logMessage("un client a returnat o carte ");
                }
            }
            System.out.println("========================================================");
        }
    }
}
