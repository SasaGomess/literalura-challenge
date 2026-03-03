package br.com.literalura.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData (@JsonAlias() String title, @JsonAlias("languages") List<String> languages, @JsonAlias("download_count") Double downloads, @JsonAlias("authors") List<AuthorData> authorData){
}
