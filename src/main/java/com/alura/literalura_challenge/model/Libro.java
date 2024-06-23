package com.alura.literalura_challenge.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @ManyToOne
    private Autor autor;

    @Enumerated(EnumType.STRING)
    private Idioma idioma;

    private Integer numeroDeDescargas;

    public Libro() {
    }

    public Libro(LibroR libro){
        this.titulo =libro.titulo();
        this.numeroDeDescargas = libro.numeroDeDescargas();

        Optional<AutorR> autor = libro.autores().stream().findFirst();
        autor.ifPresent(autorRecord -> this.autor = new Autor(autorRecord));

        Optional<String> idioma = libro.idioma().stream().findFirst();
        idioma.ifPresent(i -> this.idioma = Idioma.stringAEnum(i));
    }
    public Libro (List<LibroR> datosLibro){}

    public void muestraLibro(){
        System.out.println("===============Libro==============");
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor.getNombre());
        System.out.println("Idioma: " + idioma.getIdiomaCompleto());
        System.out.println("Número De Descargas: " + numeroDeDescargas);
        System.out.println("---------------------------------");
        System.out.println("");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return titulo;
    }
}