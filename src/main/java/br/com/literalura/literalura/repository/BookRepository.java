package br.com.literalura.literalura.repository;

import br.com.literalura.literalura.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByLanguageContainingIgnoreCase(String language);
}
