package br.com.literalura.literalura.services;

import br.com.literalura.literalura.domain.Author;
import br.com.literalura.literalura.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository repository;

    public AuthorService(final AuthorRepository repository) {
        this.repository = repository;
    }

    public Author create(Author author){
        return repository.save(author);
    }

    public List<Author> allAuthors(){
        return repository.findAll();
    }

    public List<Author> findLivingAuthorsByYear(Integer birthYear) {
        if(birthYear <= 0 ) throw new IllegalArgumentException("Digite uma data de falecimento valida");
        return repository.findAllByBirthYear(birthYear);
    }

}
