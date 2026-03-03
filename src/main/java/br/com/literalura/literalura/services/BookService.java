package br.com.literalura.literalura.services;

import br.com.literalura.literalura.domain.Book;
import br.com.literalura.literalura.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book create(Book book){
        return repository.save(book);
    }

    public List<Book> findAllBooks() {
        return repository.findAll();
    }

    public List<Book> findBookByLanguage(String language){
        return repository.findAllByLanguageContainingIgnoreCase(language);
    }

}
