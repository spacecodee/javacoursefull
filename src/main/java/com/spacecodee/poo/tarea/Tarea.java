package com.spacecodee.poo.tarea;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Tarea {

    public static void main ( String[] args ) {
        System.out.println ("************Libro*********" );
        //Libro libro=new Libro ("012245","Java desde cero",2010,14.75);
        //Libro libro = new Libro ( "Programacion C#" , 80.25 );
        Libro libro = new Libro ( "Programacion C#" , 2018,50.75 );
        System.out.println ( libro );
        libro.comprar ( );
        libro.leer ( "30%" );
        System.out.println ("************Editorial*********" );
        Editorial editorial=new Editorial ( "Mc Graw Hill" );
        System.out.println (editorial );
        editorial.vender ();
        System.out.println ("************Autor*********" );
        Autor autor=new Autor ( "Jhon","Allen" );
        System.out.println (autor );
        autor.publicar ();
    }

}

@AllArgsConstructor
@NoArgsConstructor
@Data
 class Libro {
    private String isbn;
    private String titulo;
    private int anio;
    private double precio;

    public Libro ( String titulo , double precio ) {
        this.titulo = titulo;
        this.precio = precio;
    }
    public Libro ( String titulo , int anio ,double precio) {
        this.titulo = titulo;
        this.anio = anio;
        this.precio=precio;
        if ( (2022-anio)<5) {
            System.out.println ("Sirve para Biliografia" );
        }
        else {
            System.out.println ("Ya esta obsoleto." );
        }
    }
    public void comprar ( ) {
        System.out.println ( this.getTitulo ( ) + " ha sido comprado a un precio de " + getPrecio ( ) );
    }

    public void leer ( String porcentaje ) {
        System.out.println ( this.getTitulo ( ) + " ha sido leido un " + porcentaje );
    }
}
@AllArgsConstructor
@NoArgsConstructor
@Data
class Editorial{
    private int codigo;
    private String nombre;
    private int anioPublicacion;
    public Editorial (String nombre){
        this.nombre=nombre;
    }
    public Editorial (String nombre,int anioPublicacion){
        this.nombre=nombre;
    }
    public void vender(){
        System.out.println (this.getNombre () + " ha vendido 1000 libros." );
    }
}
@AllArgsConstructor
@NoArgsConstructor
@Data
class Autor{
    private String NUI;
    private String nombre;
    private String apellido;
    private char sexo;
    public Autor(String nombre, String apellido){
        this.nombre=nombre;
        this.apellido=apellido;
    }
    public Autor(String nombre, String apellido,char sexo){
        this.nombre=nombre;
        this.apellido=apellido;
        this.sexo=sexo;
    }
    public void publicar(){
        System.out.println (this.getNombre () + this.getNombre () +" ha publicado 200 libros."  );
    }
}