package br.com.literalura.literalura;

import br.com.literalura.literalura.application.Application;
import br.com.literalura.literalura.repository.AuthorRepository;
import br.com.literalura.literalura.repository.BookRepository;
import br.com.literalura.literalura.services.AuthorService;
import br.com.literalura.literalura.services.BookService;
import br.com.literalura.literalura.services.ConsumoApi;
import br.com.literalura.literalura.services.CovertData;
import br.com.literalura.literalura.utils.Menu;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	private AuthorService authorService;
	private BookService bookService;
	private AuthorRepository repository;
	private BookRepository bookRepository;
	private AuthorRepository authorRepository;

	public LiteraluraApplication(AuthorService authorService, BookService bookService, BookRepository bookRepository,AuthorRepository authorRepository ) {
		this.authorService = authorService;
		this.bookService = bookService;
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Application application = new Application(new ConsumoApi(), new CovertData(), new BookService(bookRepository), new AuthorService(authorRepository));

		Menu.menu(application);
	}
}
