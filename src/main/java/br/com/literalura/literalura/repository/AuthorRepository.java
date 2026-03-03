package br.com.literalura.literalura.repository;

import br.com.literalura.literalura.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAllByBirthYear(Integer birthYear);

}
