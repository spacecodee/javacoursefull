package com.spacecodee.poo;

import lombok.*;

public class ClassesType {
    //Clases normales
    //Clases abstractas
    //Herencia
    //Enumeraciones

    //Interfaces

    //¿Qué entiendes por una clase abstracta?
    //- Una clase abstracta es una clase que no puede ser instanciada, pero puede contener métodos abstractos

    //¿Qué entiendes por herencia?
    //- Herencia es la capacidad de una clase padre para que una clase hija pueda heredar todos los atributos y métodos de la clase padre

    public static void main(String[] args) {
        Ingeniero juan = new Ingeniero("Juan", "Silva", "Ingeniero", "Home Office");
        juan.comer("Helado");
        Person juana = new Doctor("Juana", "Mayoral", "Medico", "Home Office");
        juana.comer("Manzana");
        System.out.println(juana.getFullName());
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
abstract class Person {
    private String identification;
    private String name;
    private String lastname;
    private byte age;
    private String genre;

    Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public void comer(String comida) {
        System.out.println("Comiendo: " + comida);
    }
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
class Ingeniero extends Person {
    private String ocupation;
    private String lugarTrabajo;

    public Ingeniero(String name, String lastname, String ocupation, String lugarTrabajo) {
        super(name, lastname);
        this.ocupation = ocupation;
        this.lugarTrabajo = lugarTrabajo;
    }

    @Override
    public void comer(String comida) {
        System.out.printf("%s %s va a comer %s\n", super.getName(), super.getLastname(), comida);
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
class Doctor extends Person {
    private String ocupation;
    private String lugarTrabajo;

    public Doctor(String name, String lastname, String ocupation, String lugarTrabajo) {
        super(name, lastname);
        this.ocupation = ocupation;
        this.lugarTrabajo = lugarTrabajo;
    }

    public String getFullName() {
        return String.format("%s %s", super.getName(), super.getLastname());
    }

    @Override
    public void comer(String comida) {
        System.out.printf("va a comer: %s", comida);
    }
}