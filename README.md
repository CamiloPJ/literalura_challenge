# Practicando Spring Boot: Challenge Literalura
![adsasdasda](https://github.com/CamiloPJ/literalura_challenge/assets/126632936/04c6bb42-a2b4-4f44-a448-88aa99b0e49a)

## Descripcion del programa 
Esta aplicación de consola en Java permite gestionar un catálogo de libros utilizando la API de Gutendex y una base de datos PostgreSQL. A través de un menú interactivo, la persona usuaria puede realizar diversas operaciones con los libros y autores registrados.

El objetivo principal del programa es facilitar la gestión y organización de información sobre libros y autores, permitiendo a la persona usuaria buscar, registrar y listar datos de manera eficiente. La información de los libros se obtiene de la API de Gutendex y se almacena en una base de datos PostgreSQL.
## Funcionalidades
El programa se estructura en varias capas que trabajan juntas para gestionar un catálogo de libros. Aquí se describe su funcionamiento interno de forma resumida:

* La clase **Principal** contiene el menú interactivo y maneja la lógica de la interacción del usuario. Dependiendo de la opción seleccionada, se llama al método correspondiente para realizar la operación deseada.
* El programa utiliza varios servicios clave para su funcionamiento. El servicio **ConsumoAPI** realiza solicitudes a la API de Gutendex, obteniendo información sobre libros mediante el título proporcionado. Esta información se recibe en formato JSON. 
* El servicio **Conversor** convierte estos datos JSON en objetos LibroR, que contienen la información esencial de los libros. Además, los servicios **LibroService** y **AutorService** encapsulan la lógica de negocio para la gestión de libros y autores, permitiendo operaciones como la búsqueda de libros por título y la obtención de autores por año de nacimiento.
* **LibroRepositor**y y **AutorRepository**: Utilizan Spring Data JPA para interactuar con la base de datos PostgreSQL. Se encargan de las operaciones CRUD (crear, leer, actualizar, eliminar) para las entidades Libro y Autor.
* Los modelos **Libro** y **Autor** son las entidades que representan los libros y autores en la base de datos. Contienen atributos como título, idioma, nombre del autor, fecha de nacimiento, etc.


## Modo de uso
1. Al iniciar el programa se muestra el menu con las opciones disponibles:

   ![image](https://github.com/CamiloPJ/literalura_challenge/assets/126632936/70deffd4-1087-4dc9-ae89-f1527c6d509b)

2. La opción número 1 Buscar libro por título: Permite buscar distintos libros en la API de Gutendex, en base al titulo que el usuario ingrese. Se mostraran los libros que concuerden con lo ingresado y se debe seleccionar el numero correspondiente al libro que se quiere guardar en la base de datos.

   ![image](https://github.com/CamiloPJ/literalura_challenge/assets/126632936/67c05ccd-4ca0-4209-acba-38ac6eaea9d7)

   NOTA: NO se puede registrar el mismo libro más de una vez.

3. La opción número 2 Listar libros registrados: Muestra una lista de todos los libros que han sido registrados en la base de datos.

   ![image](https://github.com/CamiloPJ/literalura_challenge/assets/126632936/7f907415-25ff-498d-918d-7a6bcde162f8)

4. La opción número 3 Listar autores registrados: Muestra una lista de todos los autores de los libros registrados en la base de datos.

   ![image](https://github.com/CamiloPJ/literalura_challenge/assets/126632936/8d69cad4-1975-4097-94d9-1bf8aa3bd771)

5. La opción número 4 Listar autores vivos en determinado año: Permite ingresar un año específico y muestra los autores que estaban vivos en ese año.

   ![image](https://github.com/CamiloPJ/literalura_challenge/assets/126632936/b03181ba-5503-4d7f-8130-ea255f0c59ba)

6. La opción número 5 Listar libros por idioma: Permite listar los libros según su idioma. La persona usuaria puede ingresar el código del idioma (ES, EN, FR, PT) para ver los libros correspondientes.

    ![image](https://github.com/CamiloPJ/literalura_challenge/assets/126632936/6084e5b4-c03f-4236-ab12-421771013647)

7. La opción número 0 Salir, permite terminar la aplicación.

## Requisitos

- Java 11 o superior
- Maven
- Spring Boot
- (PostgreSQL, MySQL, MariaDB, SQL Server, H2)



## Autor
[<img src="https://avatars.githubusercontent.com/u/126632936?v=4" width=115><br><sub>Camilo Paternina Jiménez</sub>](https://github.com/CamiloPJ)



   
