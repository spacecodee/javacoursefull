package com.spacecodee.javabasic;

import lombok.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntradaDatos {

    /*TODO:shortcuts Intellij
     * Alt + Enter -> Extract to Method
     * ctrl + alt + l
     * shit+F6 renombrar metdos variables etc.
     * */

    private static void toScanner ( ) {
        Scanner scanner = new Scanner ( System.in );
        User user = new User ( );

        System.out.println ( "Ingrese su nombre: " );
        user.setName ( scanner.nextLine ( ).trim ( ) );

        System.out.println ( "Ingrese su apellido: " );
        user.setLastName ( scanner.nextLine ( ).trim ( ) );

        System.out.println ( "Ingrese su usuario: " );
        user.setUser ( scanner.nextLine ( ).toLowerCase ( ).trim ( ) );

        System.out.println ( "Ingrese su contraseña: " );
        user.setPassword ( scanner.nextLine ( ).trim ( ) );

        System.out.println ( "user = " + user );
    }

    private static void toJOptionPane ( ) {
        User user = new User ( );

        user.setName ( JOptionPane.showInputDialog ( "Ingrese su nombre: " ).trim ( ) );
        user.setLastName ( JOptionPane.showInputDialog ( "Ingrese su apellido: " ).trim ( ) );
        user.setUser ( JOptionPane.showInputDialog ( "Ingrese su usuario: " ).toLowerCase ( ).trim ( ) );
        user.setPassword ( JOptionPane.showInputDialog ( "Ingrese su contraseña: " ).trim ( ) );

        JOptionPane.showMessageDialog ( null , "user = " + user , "User information" , JOptionPane.INFORMATION_MESSAGE );
    }

    //public static
    private static void implementsUserCar ( ) {
        char option;
        int idUser = 1;
        final Scanner scanner = new Scanner ( System.in );
        List < User > users = new ArrayList <> ( );
        List < Car > cars = new ArrayList <> ( );

        EntradaDatos.WelcomeToProgram ( );

        do {
            EntradaDatos.menuOption ( );
            option = scanner.nextLine ( ).charAt ( 0 );

            switch ( option ) {
                case '1':
                    EntradaDatos.getUsersContext ( scanner , cars , users , idUser );
                    idUser++;
                    break;
                case '2':
                    System.out.println ( "users = " + users );
                    break;
                case '3':
                    System.out.println ( "cars = " + cars );
                    break;
                case '4':
                    EntradaDatos.editCarById ( scanner , cars );
                    break;
                case '5':
                    EntradaDatos.deleteCarForId ( scanner , cars );
                    break;
                case '6':
                    EntradaDatos.editUserById ( scanner , users );
                    break;
                case '7':
                    EntradaDatos.deleteUserById ( scanner , users ,cars);
                    break;
                default:
                    option = '8';
                    break;
            }

        } while ( option != '8' );
    }

    private static void WelcomeToProgram ( ) {
        System.out.println ( "Hola, gracias por entrar a nuestro programa" );
        System.out.println ( "Enjoy" );
    }

    private static void menuOption ( ) {
        System.out.println ( "\n" );
        System.out.println ( "1. Crear usuario" );
        System.out.println ( "2. Mostrar usuarios" );
        System.out.println ( "3. Mostrar carros" );
        System.out.println ( "4. Editar carro" );
        System.out.println ( "5. Eliminar carro" );
        System.out.println ( "6. Editar usuario" );
        System.out.println ( "7. Eliminar usuario" );
        System.out.println ( "8. Salir" );
        System.out.println ( "\n" );
        System.out.println ( "Ingrese una opcion: " );
        //buscar usuario por username y carro por Id
        //id carro no debe repetirse en caso de repetirse volver a ingresar id
        //campos no debe estar vacios volver a pedir campo
    }

    private static void deleteCarForId ( Scanner scanner , List < Car > cars ) {
        int codCar;
        codCar = getCodCar ( scanner , "Ingrese el codigo del carro a eliminar: " );
        removeCars ( cars , codCar );
    }

    private static void removeCars ( List < Car > cars , int codCar ) {
        for ( Car car : cars ) {
            if ( codCar == car.getId ( ) ) {
                cars.remove ( car );
                break;
            }
        }
    }

    private static void editCarById ( Scanner scanner , List < Car > cars ) {
        int codCar;
        codCar = getCodCar ( scanner , "Ingrese el codigo del carro: " );
        for ( Car car : cars ) {
            if ( codCar == car.getId ( ) ) {
                EntradaDatos.setMarcaModelColorToCar ( scanner , car );
                break;
            }
        }
    }

    private static void editUserById ( Scanner scanner , List < User > users ) {
        int IdUser = getIdUser ( scanner );
        for ( User user : users ) {
            if ( IdUser == user.getId ( ) ) {
                setDatosUser ( scanner , user );
                break;
            }
        }
    }

    private static int getIdUser ( Scanner scanner ) {
        int IdUser;
        System.out.println ( "Ingrese el Id de usuario" );
        IdUser = Integer.parseInt ( scanner.nextLine ( ) );
        return IdUser;
    }

    private static void deleteUserById ( Scanner scanner , List < User > users,List <Car> cars ) {
        int IdUser = getIdUser ( scanner );
        for ( User user : users ) {
            if ( IdUser == user.getId ( ) ) {
                users.remove ( user );
                cars.removeAll ( user.getCars () );
                break;
            }
        }
    }
    private static int getCodCar ( Scanner scanner , String message ) {
        int codCar;
        System.out.println ( message );
        codCar = Integer.parseInt ( scanner.nextLine ( ).trim ( ) );
        return codCar;
    }

    private static void getUsersContext ( Scanner scanner , List < Car > cars , List < User > users , int idUser ) {
        char addCar;
        List < Car > carList = new ArrayList <> ( );
        User user = new User ( );
        user.setId ( idUser );
        setDatosUser ( scanner , user );

        System.out.println ( "¿Quieres agregar un carro?\nS: Si\nN: No" );
        addCar = scanner.nextLine ( ).charAt ( 0 );

        EntradaDatos.addCarsToUser ( scanner , cars , carList , addCar );
        user.setCars ( carList );
        users.add ( user );

    }

    private static void setDatosUser ( Scanner scanner , User user ) {
        System.out.println ( "Ingresa tu nombre" );
        user.setName ( scanner.nextLine ( ).trim ( ) );
        System.out.println ( "Ingresa tu apellido" );
        user.setLastName ( scanner.nextLine ( ).trim ( ) );
        System.out.println ( "Ingresa tu nombre de usuario" );
        user.setUser ( scanner.nextLine ( ).trim ( ) );
        System.out.println ( "Ingresa tu contraseña" );
        user.setPassword ( scanner.nextLine ( ).trim ( ) );
    }

    private static void addCarsToUser ( Scanner scanner , List < Car > cars , List < Car > carList , char addCar ) {
        while ( addCar == 'S' || addCar == 's' ) {

            Car car = new Car ( );

            System.out.println ( "Ingrese el codigo del carro" );
            car.setId ( Integer.parseInt ( scanner.nextLine ( ).trim ( ) ) );
            EntradaDatos.setMarcaModelColorToCar ( scanner , car );
            carList.add ( car );
            System.out.println ( "¿Quieres agregar un carro?\nS: Si\nN: No" );
            addCar = scanner.nextLine ( ).charAt ( 0 );
        }
        cars.addAll ( carList );
    }

    private static void setMarcaModelColorToCar ( Scanner scanner , Car car ) {
        System.out.println ( "Ingrese la marca del carro" );
        car.setBrand ( scanner.nextLine ( ).trim ( ) );
        System.out.println ( "Ingrese el modelo del carro: " );
        car.setModel ( scanner.nextLine ( ).trim ( ) );
        System.out.println ( "Ingrese el color del carro: " );
        car.setColor ( scanner.nextLine ( ).trim ( ) );
    }


    public static void main ( String[] args ) {
        EntradaDatos.implementsUserCar ( );
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
    private List < Car > cars;
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