package com.alura.literalura_challenge.service;

import com.alura.literalura_challenge.model.Autor;
import com.alura.literalura_challenge.model.Libro;
import com.alura.literalura_challenge.repository.AutorRepository;
import com.alura.literalura_challenge.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    public AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Optional<Autor> buscarAutorPorNombre(String nombre) {
        return autorRepository.findByNameContainsIgnoreCase(nombre);
    }

    public List<Autor> buscarAutorPorAnho(int anho){
        return autorRepository.findByYearContainsIgnoreCase(anho);
    }
}
