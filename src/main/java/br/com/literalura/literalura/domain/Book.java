package br.com.literalura.literalura.domain;

import br.com.literalura.literalura.dto.BookData;
import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String language;
    private Double downloads;

    @ManyToOne()
    private Author author;

    public Book() {
    }

    public Book(Long id, String title, String language, Double downloads, Author author) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.downloads = downloads;
        this.author = author;
    }

    public Book(BookData data) {
        this.title = data.title();
        this.downloads = data.downloads();
        this.language = data.languages().getFirst();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String languages) {
        this.language = languages;
    }

    public Double getDownloads() {
        return downloads;
    }

    public void setDownloads(Double downloads) {
        this.downloads = downloads;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return """
                ----- Livros -------
                Titulo: %s
                Autor: %s
                Idioma: %s
                Número de downloads: %.2f
                ---------------------
                """.formatted(title, author.getName(), language, downloads);
    }
}
