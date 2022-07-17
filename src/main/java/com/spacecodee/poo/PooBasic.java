package com.spacecodee.poo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PooBasic {

    /*Se entiende por objeto a aquellos que tenga atributo
     * Por ejemplo:
     * - Una persona
     * - Una Casa
     * - Un Animal
     * - Etc.
     * */

    /*Palabras reservadas
     * new → para crear un objeto o instance an object
     * this → para referirnos a un objeto o instance
     * */

    /*Constructores
     * - Un constructor es un método que se ejecuta cuando se crea un objeto
     * - Podemos tener sobrecarga de constructores
     * - Se le llama sobrecarga de constructores cuando tenemos más de un constructor pero con diferentes argumentos
     * */

    /*Métodos
     * - Un método es una función que se ejecuta sobre un objeto o instance
     * - Podemos tener sobrecarga de métodos
     * - Se le llama sobrecarga de métodos cuando tenemos más de un método pero con diferentes argumentos
     * */

    public static void main(String[] args) {
        Dog dog = new Dog("Firulais", "Black", (byte) 2);
        System.out.println(dog);
        System.out.println("*****************************");
        dog.comer("Está comiendo Pollo");
        System.out.println("*****************************");
        dog.dormir("Firu");
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class Dog {
    private int age;
    private String name;
    private String raza;
    private String color;
    private String sex;
    private String size;
    @Getter
    private static String myVariable;
    private static final String EL_PERRO = "El perro";
    private static final String MY_STRINGS = "%s %s %s";

    //Sobrecarga solo para nombre, color y tamaña
    public Dog(String name, String color, String size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    //sobrecarga solo para nombre, color y tamaño en enteros
    public Dog(String name, String color, byte size) {
        this.name = name;
        this.color = color;
        if (size == 1) {
            this.size = "Pequeño";
        }
        else if (size == 2) {
            this.size = "Mediano";
        }
        else if (size == 30) {
            this.size = "Grande";
        }
    }

    public void comer() {
        System.out.printf(Dog.MY_STRINGS, Dog.EL_PERRO, this.getName(), "está comiendo\n");
    }

    public void comer(String action) {
        System.out.printf("%s %s %s%s", Dog.EL_PERRO, this.getName(), action, "\n");
    }

    public void dormir() {
        System.out.printf(Dog.MY_STRINGS, Dog.EL_PERRO, this.getName(), "está durmiendo\n");
    }

    public void dormir(String name) {
        System.out.printf(Dog.MY_STRINGS, Dog.EL_PERRO, name, "está durmiendo\n");
    }
}