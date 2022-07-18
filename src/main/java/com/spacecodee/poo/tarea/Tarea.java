package com.spacecodee.poo.tarea;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class Tarea {

    public static void main(String[] args) {
        System.out.println("************Libro*********");
        Libro libro = new Libro("Programación C#", 2018, 50.75);
        System.out.println(libro);
        libro.validarLibroConBibliografia();
        libro.obtenerPrecioLibro();
        libro.elPorcentajeLeido("30%");
        System.out.println("************Editorial*********");
        Editorial editorial = new Editorial("Mc Grow Hill");
        System.out.println(editorial);
        editorial.cantidadVendida(100);
        System.out.println("************Autor*********");
        Autor autor = new Autor("Jon", "Allen", 'M');
        System.out.println(autor);
        autor.publicar(5);
    }

}

@AllArgsConstructor
@NoArgsConstructor
@Data
class Libro {
    private String isbn;
    private String titulo;
    private int year;
    private double precio;
    private static final int YEAR_NOW = LocalDate.now().getYear();

    public Libro(String titulo, double precio) {
        this.titulo = titulo;
        this.precio = precio;
    }

    public Libro(String titulo, int year, double precio) {
        this.titulo = titulo;
        this.year = year;
        this.precio = precio;
    }

    public void validarLibroConBibliografia() {
        if ((Libro.YEAR_NOW - this.getYear()) < 5) {
            System.out.println("Sirve para Bibliografía");
        }
        else {
            System.out.println("Ya esta obsoleto.");
        }
    }

    public void obtenerPrecioLibro() {
        System.out.printf("El precio del libro %s es %.2f\n", this.getTitulo(), this.getPrecio());
    }

    public void elPorcentajeLeido(String porcentaje) {
        System.out.printf("El libro %s tiene un %s de lectura\n", this.getTitulo(), porcentaje);
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class Editorial {
    private int uniqueCode;
    private String nombre;
    private int publishYear;

    public Editorial(String nombre) {
        this.nombre = nombre;
    }

    public Editorial(String nombre, int publishYear) {
        this.nombre = nombre;
        this.publishYear = publishYear;
    }

    public void cantidadVendida(int quantity) {
        System.out.printf("La editorial %s vendió %d libros\n", this.getNombre(), quantity);
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class Autor {
    private String nui;
    private String nombre;
    private String apellido;
    private String genre;

    public Autor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Autor(String nombre, String apellido, char genre) {
        this.nombre = nombre;
        this.apellido = apellido;
        if (genre == 'M') {
            this.genre = "Masculino";
        }
        else {
            this.genre = "Femenino";
        }
    }

    public void publicar(int quantity) {
        System.out.printf("El autor %s %s va a publicar %d libros\n", this.getNombre(), this.getApellido(), quantity);
    }
}