package com.spacecodee.javabasic;

import java.util.ArrayList;

public class Variables {
    //Java => nomenclatura camelCase
    //variables => area ✅ | Area ❌ | AREA ❌ || firstName ✅ | firstname | FirstName
    //functions => public void sumar(); ✅ | Sumar() ❌ | SUMAR(); ❌ || quieroSumar();
    //Classes => Product ✅ | product ❌ | PRODUCT ❌ || UserRoles ✅ | USERroles | userRoleS
    //Constants => AGE | age | AgE

    //tipos de datos
    /*
     *=> primitivas
     * numeros enteros => byte, int, long
     * numeros decimales => float, double
     * dos valores => boolean | true or false
     * cadenas => char
     *  */
    /*
     * => no primitivas
     * String | cadenas largas
     * */

    //declarar varibales tradicionalmente
    byte number2 = -127;
    int number1 = 999999999;
    long number3 = 5294945844445454549L;
    float numer4 = 3.14F;
    double number5 = 9.9D;

    boolean aBoolean1 = true;
    boolean aBoolean2 = false;

    char aChar1 = 'c';

    Byte aByte = 1;
    Integer integer = 1;
    Long aLong = 1L;
    Float aFloat = 1F;
    Double aDouble = 1D;
    Boolean aBoolean = true;
    String string = "my string";

    //desde java 11+
    /*
     * var nombre = ""; | incialices ✅
     * var[] arreglo = new String[15]; ❌
     * var => estar en un contexto.
     * */

    public Variables() {
        var talCosa = new int[5];
        var arrayList = new ArrayList<String>();
    }

    /*
     * forma correcta vairbales:
     * myVariable ✅
     * MyVariable ❌
     * MYVARIABLE ❌
     * MyVARIABLE ❌
     * */


}
