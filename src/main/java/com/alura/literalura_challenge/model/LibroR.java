package com.alura.literalura_challenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroR(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<AutorR> autores,
        @JsonAlias("languages") List<String> idioma,
        @JsonAlias("download_count") Integer numeroDeDescargas
        ){
}
