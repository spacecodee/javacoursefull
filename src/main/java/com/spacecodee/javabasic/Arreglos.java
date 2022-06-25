package com.spacecodee.javabasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arreglos {
    /*
     * Unidimensionales
     * Bidimensionales
     *  */
    //Limit
    static int[] numberList = new int[10];
    static String[] names = {"Julia", "Juan", "Karen", "Adriana", "Ana"};

    //bidimensionales
    static Object[][] objects = new Object[5][2];
    static Object[][] objects2 = new Object[][]{

    };

    static Object[][][] objects3 = new Object[2][2][2];

    //noLimit
    static List<String> namePets = new ArrayList<>();
    static List<Boolean> booleanList = new ArrayList<>() {
        {
            this.add(0, true);
            this.add(true);
            this.add(false);
        }
    };

    public static void aVoid() {
        System.out.println("names = " + Arrays.toString(Arreglos.names));
        Arreglos.names[4] = "521";
        System.out.println("names = " + Arrays.toString(Arreglos.names));
    }

    public static void listRun() {
        for (int i = 0; i < Arreglos.names.length; i++) {
            System.out.println("i = " + Arreglos.names[i]);
        }

        System.out.println("\n");

        for (String name :
                Arreglos.names) {
            System.out.println("name = " + name);
        }
    }

    public static void setObjects() {
        Arreglos.objects[0][0] = "Title";
        Arreglos.objects[1][0] = "Name";
        Arreglos.objects[2][0] = "LastName";
        Arreglos.objects[3][0] = "User";
        Arreglos.objects[4][0] = "Password";

        Arreglos.objects[0][1] = "Cualquier Cosa";
        Arreglos.objects[1][1] = "Juan";
        Arreglos.objects[2][1] = "Perez";
        Arreglos.objects[3][1] = "juanpe";
        Arreglos.objects[4][1] = "123456";

        for (int i = 0; i < Arreglos.objects.length; i++) {
            for (int j = 0; j < Arreglos.objects[i].length; j++) {
                System.out.println("[ " + Arreglos.objects[i][j] + " ]");
            }
        }

        System.out.println("\n");
        Arreglos.objects3[0][0][0] = "xd0";
        Arreglos.objects3[0][0][1] = "xd0";
        Arreglos.objects3[0][1][0] = "xd1";
        Arreglos.objects3[0][1][1] = "xd1";

        for (int i = 0; i < Arreglos.objects3.length; i++) {
            for (int j = 0; j < Arreglos.objects3[i].length; j++) {
                for (int k = 0; k < Arreglos.objects3[j].length; k++) {
                    System.out.println("objects3 = " + objects3[i][j][k]);
                }
            }
        }
    }

    public static void main(String[] args) {
        //Arreglos.aVoid();
        //Arreglos.listRun();
        Arreglos.setObjects();
    }
}
