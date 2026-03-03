package br.com.literalura.literalura.domain;

import br.com.literalura.literalura.dto.AuthorData;
import br.com.literalura.literalura.dto.BookData;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer birthYear;
    private Integer deathYear;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    public Author() {
    }

    public Author(BookData bookData) {
        this.birthYear = bookData.authorData().getFirst().birthYear();
        this.deathYear = bookData.authorData().getFirst().deathYear();
        this.name = bookData.authorData().getFirst().name();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(Book book) {
        book.setAuthor(this);
        this.books.add(book);
    }

    @Override
    public String toString() {
        return """
                Autor: %s
                Ano de Nascimento: %s
                Ano de falecimento: %s
                Livros: [%s]
                """.formatted(name, birthYear, deathYear, books.stream().map(Book::getTitle));
    }
}
