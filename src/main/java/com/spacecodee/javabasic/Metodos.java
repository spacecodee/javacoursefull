package com.spacecodee.javabasic;

import java.util.Arrays;

public class Metodos {


    //comentario normal

    /*comentario
     * de
     * dos
     * o
     * mas
     * lineas*/

    /*TODO:
       ¿Qué son los metodos?
       Los metodos son funciones que se ejecutan sobre un objeto.
       metodos normal -> void = no retorna nada
       metodos con retorno -> retorna un valor
       metodos con parametros -> recibe parametros
       metodos con parametros y retorno -> recibe parametros y retorna un valor
       metodos estaticos -> no se puede llamar desde un objeto, se puede llamar desde la clase Pepito.llamar(); new Pepito().llamar();
       metodos estaticos con retorno -> retorna un valor
    */

    //method normal -> void = no return nothing
    private static void methodNormal() {
        System.out.println("Hello World");
    }

    private static int sum(int a, int b) {
        return a + b;
    }

    private static String concat(String a, String b) {
        return a + b;
    }

    private static String[] getNames() {
        return new String[]{"Julia", "Juan", "Karen", "Adriana", "Ana"};
    }

    public static void main(String[] args) {
        Metodos.methodNormal();
        var sum = Metodos.sum(1, 2);
        var concat = Metodos.concat("Hello", "World");
        var getNames = Metodos.getNames();
        System.out.println("sum = " + sum);
        System.out.println("concat = " + concat);
        System.out.println("getNames = " + Arrays.toString(getNames));

        for (var name :
                getNames) {
            System.out.println("name = " + name);
        }
    }
}
