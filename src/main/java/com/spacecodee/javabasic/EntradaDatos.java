package com.spacecodee.javabasic;

import lombok.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntradaDatos {

    private static void toScanner() {
        Scanner scanner = new Scanner(System.in);
        User user = new User();

        System.out.println("Ingrese su nombre: ");
        user.setName(scanner.nextLine().trim());

        System.out.println("Ingrese su apellido: ");
        user.setLastName(scanner.nextLine().trim());

        System.out.println("Ingrese su usuario: ");
        user.setUser(scanner.nextLine().toLowerCase().trim());

        System.out.println("Ingrese su contraseña: ");
        user.setPassword(scanner.nextLine().trim());

        System.out.println("user = " + user);
    }

    private static void toJOptionPane() {
        User user = new User();

        user.setName(JOptionPane.showInputDialog("Ingrese su nombre: ").trim());
        user.setLastName(JOptionPane.showInputDialog("Ingrese su apellido: ").trim());
        user.setUser(JOptionPane.showInputDialog("Ingrese su usuario: ").toLowerCase().trim());
        user.setPassword(JOptionPane.showInputDialog("Ingrese su contraseña: ").trim());

        JOptionPane.showMessageDialog(null, "user = " + user, "User information", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void implementsUserCar() {
        final Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();
        List<Car> cars = new ArrayList<>();
        User user = new User();
        char option;
        int id = 1;

        System.out.println("Hola, gracias por entrar a nuestro programa");
        System.out.println("Enjoy");

        do {
            System.out.println("\n");
            System.out.println("1. Crear usuario");
            System.out.println("2. Mostrar usuarios");
            System.out.println("3. Mostrar carros");
            System.out.println("4. Salir");
            System.out.println("\n");
            System.out.println("Ingrese una opcion: ");
            option = scanner.nextLine().charAt(0);

            switch (option) {
                case '1' -> id = getUsersContext(scanner, cars, user, id);
                case '2' -> System.out.println("user = " + user);
                case '3' -> System.out.println("cars = " + cars);
                default -> option = '4';
            }
        } while (option != '4');
    }

    private static int getUsersContext(Scanner scanner, List<Car> cars, User user, int id) {
        char addCar;
        user.setId(1);
        System.out.println("Ingresa tu nombre");
        user.setName(scanner.nextLine().trim());
        System.out.println("Ingresa tu apellido");
        user.setLastName(scanner.nextLine().trim());
        System.out.println("Ingresa tu nombre de usuario");
        user.setUser(scanner.nextLine().trim());
        System.out.println("Ingresa tu contraseña");
        user.setPassword(scanner.nextLine().trim());
        System.out.println("""
                                   ¿Quieres agregar un carro?
                                   S: Si
                                   N: No
                                   """);
        addCar = scanner.nextLine().charAt(0);
        while (addCar == 'S' || addCar == 's') {
            Car car = new Car();

            car.setId(id);

            System.out.println("Ingrese la marca del carro");
            car.setBrand(scanner.nextLine().trim());
            System.out.println("Ingrese el modelo del carro: ");
            car.setModel(scanner.nextLine().trim());
            System.out.println("Ingrese el color del carro: ");
            car.setColor(scanner.nextLine().trim());

            cars.add(car);
            System.out.println("""
                                       ¿Quieres agregar un carro?
                                       S: Si
                                       N: No
                                       """);
            addCar = scanner.nextLine().charAt(0);
            id++;
        }
        user.setCars(cars);
        return id;
    }

    public static void main(String[] args) {
        EntradaDatos.implementsUserCar();
    }
}

@NoArgsConstructor
@AllArgsConstructor
@Data
class User {
    private int id;
    private String name;
    private String lastName;
    private String user;
    private String password;
    private List<Car> cars;
}

@NoArgsConstructor
@AllArgsConstructor
@Data
class Car {
    private int id;
    private String brand;
    private String model;
    private String color;
}