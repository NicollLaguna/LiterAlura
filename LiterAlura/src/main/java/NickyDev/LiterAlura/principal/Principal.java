package NickyDev.LiterAlura.principal;

import NickyDev.LiterAlura.model.Book;
import NickyDev.LiterAlura.model.BookData;
import NickyDev.LiterAlura.model.ELanguage;
import NickyDev.LiterAlura.repository.BooksRepository;
import NickyDev.LiterAlura.service.ApiConsumption;
import NickyDev.LiterAlura.service.ConvertData;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner keyboard = new Scanner(System.in);
    private int option;
    private ApiConsumption apiConsumption = new ApiConsumption();
    private String baseUrl = "https://gutendex.com/books?search=%20";
    private BooksRepository repository;

    public Principal(BooksRepository repository) {
        this.repository = repository;
    }

    public void showMenu() {
        do {
            System.out.println("""
                Welcome to LiterAlura! Please select an option:
                1 - Search for a book by title.
                2 - List all books.
                3 - List authors.
                4 - Display the number of books in a specific language.
                5 - List authors alive in a specific year.
                0 - Exit
                """);
            try {
                option = keyboard.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid or missing option");
            }

            switch (option) {
                case 1:
                    searchBookByTitle();
                    break;
                case 2:
                    listBooks();
                    break;
                case 3:
                    listAuthors();
                    break;
                case 4:
                    filterBooksByLanguage();
                    break;
                case 5:
                    filterAuthorsByYear();
                    break;
                case 0:
                    System.out.println("Exiting LiterAlura");
                    break;
            }
        } while (option != 0);
    }

    private BookData getBookData() {
        System.out.println("Enter the title of the book you want to search for");
        var title = keyboard.next();
        var json = apiConsumption.getData(baseUrl + title.replace(" ", "+"));
        BookData bookData = new ConvertData().getData(json, BookData.class);
        System.out.println(bookData);
        return bookData;
    }

    private void searchBookByTitle() {
        var bookData = getBookData();
        Optional<Book> book = Optional.of(new Book(bookData));
        if (book.get().getTitle() == null) {
            System.out.println("Book not found");
        } else {
            repository.save(book.get());
        }
    }

    private void listBooks() {
        var books = repository.findAll();
        books.forEach(System.out::println);
    }

    private void listAuthors() {
        List<Book> authors = repository.findAll();
        authors.forEach(e -> e.getAuthors().forEach(System.out::println));
    }

    private void filterBooksByLanguage() {
        System.out.println("Enter the language you want to search for");
        ELanguage query = ELanguage.fromSpanish(keyboard.next());
        List<Book> books = repository.findByLanguagesContaining(query);
        books.forEach(System.out::println);
    }

    private void filterAuthorsByYear() {
        System.out.println("Enter the year the author was alive");
        int year = keyboard.nextInt();
        List<Book> authors = repository.findByYear(year);
        authors.forEach(e -> e.getAuthors().forEach(System.out::println));
    }

}
