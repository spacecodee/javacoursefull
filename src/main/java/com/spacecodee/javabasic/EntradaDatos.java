package com.spacecodee.javabasic;

import lombok.*;

import javax.swing.*;
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

    public static void main(String[] args) {
    }
}

@NoArgsConstructor
@AllArgsConstructor
@Data
class User {
    private String name;
    private String lastName;
    private String user;
    private String password;
}
