package com.spacecodee.javabasic;

public class Bucles {
    /*
     * for(int i = 0; i < x; i++){}
     * while() {}
     * do {} while();
     * forEach(String name: nameList){}
     * */

    public static void methodWhile() {
        int i = 0;

        while (i < 10) {
            System.out.println("i = " + ++i);
        }
    }

    public static void methodDoWhile() {
        int i = 20;
        do {
            System.out.println("i = " + (--i));
        } while (i > 0);
    }

    public static void main(String[] args) {
        //Bucles.methodWhile();
        Bucles.methodDoWhile();
    }
}
