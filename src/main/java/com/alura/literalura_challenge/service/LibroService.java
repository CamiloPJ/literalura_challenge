package com.alura.literalura_challenge.service;

import com.alura.literalura_challenge.model.Idioma;
import com.alura.literalura_challenge.model.Libro;
import com.alura.literalura_challenge.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public Optional<Libro> buscarLibroPorTitulo(String titulo){
        return libroRepository.findByTitleContainsIgnoreCase(titulo);
    }

    public List<Libro> buscarLibroPorIdioma(Idioma idioma) {
        return libroRepository.findByLanguageContainsIgnoreCase(idioma);
    }
}
