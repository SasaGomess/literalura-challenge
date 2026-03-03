package br.com.literalura.literalura.application;

import br.com.literalura.literalura.domain.Author;
import br.com.literalura.literalura.domain.Book;
import br.com.literalura.literalura.dto.BookData;
import br.com.literalura.literalura.dto.Results;
import br.com.literalura.literalura.services.AuthorService;
import br.com.literalura.literalura.services.BookService;
import br.com.literalura.literalura.services.ConsumoApi;
import br.com.literalura.literalura.services.IConvertData;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;


public class Application {
    private ConsumoApi consumoApi;
    private IConvertData convertData;
    private BookService bookService;
    private AuthorService authorService;

    public Application(ConsumoApi consumoApi, IConvertData convertData, BookService bookService, AuthorService authorService) {
        this.consumoApi = consumoApi;
        this.convertData = convertData;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    public void searchBookByTittle(Scanner scanner){
        try {
            System.out.println("Digite o titulo do livro que deseja buscar");
            var titulo = scanner.nextLine();
            System.out.println(titulo);
            var json = consumoApi.consomeApi(titulo);

            System.out.println(json);

            Results results = convertData.convertObj(json, Results.class);

            List<BookData> bookData = results.bookDataList();

            System.out.println(bookData.getFirst());

            Book book = new Book(bookData.getFirst());

            Author author = new Author(bookData.getFirst());

            author.setBooks(book);

            authorService.create(author);
            bookService.create(book);

            System.out.println(book);
            } catch (JsonProcessingException e) {
                System.out.println(e.getLocalizedMessage());
        }
    }

    public void findAllBooks() {
        List<Book> allBooks = bookService.findAllBooks();

        System.out.println(allBooks);
    }

    public void findAllAuthors() {
        List<Author> authors = authorService.allAuthors();
        System.out.println(authors);
    }

    public void findLivingAuthorsByYear(Scanner scanner) {
        System.out.println("Digite a data para a pesquisa: ");
        var birthDate = scanner.nextInt();
        scanner.nextLine();
        List<Author> authorsByYear = authorService.findLivingAuthorsByYear(birthDate);

        System.out.println(authorsByYear);
    }

    public void findBooksByLanguage(Scanner scanner) {
        System.out.println("Digite o idioma para pesquisa: ");
        var idioma = scanner.nextLine();
        List<Book> booksByLanguage = bookService.findBookByLanguage(idioma);
        System.out.println(booksByLanguage);
    }

}
