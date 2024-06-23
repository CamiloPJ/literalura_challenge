package com.alura.literalura_challenge.principal;
import com.alura.literalura_challenge.model.Autor;
import com.alura.literalura_challenge.model.Idioma;
import com.alura.literalura_challenge.model.Libro;
import com.alura.literalura_challenge.model.LibroR;
import com.alura.literalura_challenge.repository.AutorRepository;
import com.alura.literalura_challenge.repository.LibroRepository;
import com.alura.literalura_challenge.service.AutorService;
import com.alura.literalura_challenge.service.ConsumoAPI;
import com.alura.literalura_challenge.service.Conversor;
import com.alura.literalura_challenge.service.LibroService;
import java.util.*;


public class Principal {
    private Scanner lectura = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private Conversor conversor = new Conversor();
    private LibroService libroService;
    private AutorService autorService;
    private LibroRepository libroRepositorio;
    private AutorRepository autorRepositorio;

    public Principal(LibroRepository libroRepository, LibroService libroService, AutorRepository autorRepository, AutorService autorService) {
        this.libroRepositorio = libroRepository;
        this.libroService = libroService;
        this.autorRepositorio = autorRepository;
        this.autorService = autorService;
    }


    public void selectorDeOpcion() {
        var opcion = -1;
        while (opcion != 0) {
            var interfaz = """
                    Elija la opción a través de su número:
                    1 - Buscar libro por titulo 
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en determinado año
                    5 - Listar libros por idioma
                    0 - Salir
                    """;
            System.out.println(interfaz);
            opcion = lectura.nextInt();
            lectura.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresRegistradosEnDeterminadoAnho();
                case 5:
                    listarLibrosPorIdioma();
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    System.exit(0);
                    break;
            }
        }
    }

    private void buscarLibroPorTitulo() {
        List<LibroR> datosLibro = getDatosLibro();

        for (int i = 0; i < datosLibro.size(); i++) {
            System.out.println((i+1)+ " - " + datosLibro.get(i).titulo() + " - " + datosLibro.get(i).idioma());
        }

        if (datosLibro.isEmpty()){
            System.out.println("Libro no encontrado, intente nuevamente");
            buscarLibroPorTitulo();
        } else{
            System.out.println("Digite el numero del libro que desea guardar: ");
            var seleccion = lectura.nextInt();
            while (seleccion>datosLibro.size() || seleccion<=0){
                System.out.println("Seleccion de opción erronea");
                return;
            }
            Libro libro = new Libro(datosLibro.get(seleccion-1));
            LibroR libroR = datosLibro.get(seleccion - 1);
            Optional<Libro> libroRepo =libroService.buscarLibroPorTitulo(libro.getTitulo());
            Optional<Autor> autorRepo = autorService.buscarAutorPorNombre(libroR.autores().get(0).nombre());
            if (libroRepo.isPresent()) {
                System.out.println("No se puede registrar el mismo libro dos veces");
                return;
            } else{
                if (!autorRepo.isPresent()){
                    Autor autor =libro.getAutor();
                    autorRepositorio.save(autor);
                }
                System.out.println("Libro guardado exitosamente");
                libroRepositorio.save(libro);
            }
        }
    }

    private void listarLibrosRegistrados() {
        List<Libro> librosRegistrados = libroRepositorio.findAll();
        if (librosRegistrados.isEmpty()){
            System.out.println("NO SE ENCONTGRARON LIBROS REGISTRADOS...");
            return;
        } else {
            librosRegistrados.forEach(libro -> libro.muestraLibro());
            selectorDeOpcion();
        }
    }

    public List<LibroR> getDatosLibro() {
        System.out.println("Escribe el titulo del libro que deseas buscar: ");
        var titulo = lectura.nextLine();
        if (titulo.equals("0")) {
            return Collections.emptyList();
        }
        List<LibroR> datosLibros;
        datosLibros = conversor.parsearDatos(consumoAPI.obtenerDatos(titulo));
        System.out.println(datosLibros);
        return datosLibros;
    }


    private void listarAutoresRegistrados() {
        List<Autor> autors = autorRepositorio.findAll();
        if (autors.isEmpty()){
            System.out.println("NO SE ENCONTGRARON AUTORES REGISTRADOS...");
        } else {
            autors.forEach(autor -> autor.mostrarAutores());
            selectorDeOpcion();
        }
    }

    private void listarAutoresRegistradosEnDeterminadoAnho() {

        try {
            System.out.println("Digite el año el cual vivio el/los autor/es [0 - Cancelar]: ");
            Integer anho = lectura.nextInt();
            lectura.nextLine();
            List<Autor> autoresAnho = autorService.buscarAutorPorAnho(anho);
            if (anho.equals(0)){
                selectorDeOpcion();
            }
            else if (autoresAnho.isEmpty()){
                System.out.println("NO SE ENCONTGRARON AUTORES REGISTRADOS QUE ESTUVIERAN VIVOS EN ESE AÑO...");
                listarAutoresRegistradosEnDeterminadoAnho();

            } else {
                System.out.println("Los autores que estuvieron vivos en " + anho + " fueron:");
                autoresAnho.forEach(autor -> autor.mostrarAutores());
                selectorDeOpcion();
            }
        } catch (InputMismatchException e){
            System.out.println("Error de sintaxis, la entrada debe ser un número");
        }

    }

    private void listarLibrosPorIdioma() {
        System.out.println("Digite el idioma del libro que desea [0 - Atras]: ");
        System.out.println("es - ESPAÑOL");
        System.out.println("en - INGLES");
        System.out.println("fr - FRANCES");
        System.out.println("pr - PORTUGUES");
        String idiomaDeseado = lectura.nextLine();
        List<Libro> librosIdioma = libroService.buscarLibroPorIdioma(Idioma.stringAEnum(idiomaDeseado));
        System.out.println(librosIdioma);
        if (librosIdioma.isEmpty()){
            System.out.println("NO SE ENCONTGRARON LIBROS REGISTRADOS CON EL IDIOMA SELECCIONADO...");
            return;
        } else {
            librosIdioma.forEach(libro -> libro.muestraLibro());
            selectorDeOpcion();
        }
    }
}
