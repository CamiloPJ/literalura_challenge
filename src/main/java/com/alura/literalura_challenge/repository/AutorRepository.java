package com.alura.literalura_challenge.repository;

import com.alura.literalura_challenge.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Autor a WHERE LOWER(a.nombre) LIKE LOWER(:nombre)")
    Optional<Autor> findByNameContainsIgnoreCase(String nombre);


    @Query("SELECT a FROM Autor a WHERE :anho BETWEEN a.fechaNacimiento AND COALESCE(a.fechaFallecimiento, :anho)")
    List<Autor> findByYearContainsIgnoreCase(int anho);
}