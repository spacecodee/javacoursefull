package com.spacecodee.javabasic;

import lombok.*;

import javax.swing.*;
import java.util.*;


public class EntradaDatos {

    /*TODO:shortcuts Intellij
     * Alt + Enter -> Extract to Method
     * ctrl + alt + l
     * shit+F6 renombrar metdos variables etc.
     * static final =CONSTANTE
     * */
    private static final Scanner SCANNER = new Scanner ( System.in );
    private static final List < User > USERS = new ArrayList <> ( );
    private static final List < Car > CARS = new ArrayList <> ( );

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


    private static void implementsUserCar ( ) {
        char option;
        int idUser = 1;


        EntradaDatos.WelcomeToProgram ( );

        do {
            EntradaDatos.menuOption ( );
            option = EntradaDatos.SCANNER.nextLine ( ).charAt ( 0 );

            switch ( option ) {
                case '1':
                    EntradaDatos.getUsersContext ( idUser );
                    idUser++;
                    break;
                case '2':
                    System.out.println ( "users = " + EntradaDatos.USERS );
                    break;
                case '3':
                    System.out.println ( "cars = " + EntradaDatos.CARS );
                    break;
                case '4':
                    EntradaDatos.editCarById ( );
                    break;
                case '5':
                    EntradaDatos.deleteCarForId ( );
                    break;
                case '6':
                    EntradaDatos.editUserById ( );
                    break;
                case '7':
                    EntradaDatos.deleteUserById ( );
                    break;
                case '8':
                    EntradaDatos.searchByUserNameUser ( );
                    break;
                case '9':
                    System.out.println (EntradaDatos.searchByIdCar ( ) );
                    break;
                default:
                    option = '0';
                    break;
            }

        } while ( option != '0' );
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
        System.out.println ( "8. Buscar usuario por username" );
        System.out.println ( "9. Buscar carro por Id" );
        System.out.println ( "0. Salir" );
        System.out.println ( "\n" );
        System.out.println ( "Ingrese una opcion: " );
        //buscar usuario por username y carro por Id
        //id carro no debe repetirse en caso de repetirse volver a ingresar id
        //campos no debe estar vacios volver a pedir campo
    }

    private static Map<String , Object > searchByIdCar ( ) {
        Map<String,Object> mapa=new HashMap <> (  );
        int codCar = EntradaDatos.getCodCar ( "Ingresa el codigo del carro a buscar" );
        mapa.put ( "Id",codCar );
        System.out.println (EntradaDatos.CARS );
        for ( Car car : EntradaDatos.CARS ) {
            if ( codCar == car.getId ( ) ) {
                mapa.put ( "Carro",car );
                return mapa;
            }
        }
        mapa.put ( "Carro",null );
        return mapa;
    }

    private static void searchByUserNameUser ( ) {
        String userName;

        boolean existe;
        System.out.println ( "Ingrese el username de usuario" );
        userName = EntradaDatos.SCANNER.nextLine ( ).trim ( ).toLowerCase ( );
        for ( User user : EntradaDatos.USERS ) {
            existe = user.getUser ( ).equals ( userName );
            if ( existe ) {
                System.out.println ( "user = " + user );
                break;
            }

        }//fin for
    }

    private static void deleteCarForId ( ) {
        int codCar;
        codCar = EntradaDatos.getCodCar ( "Ingrese el codigo del carro a eliminar: " );
        removeCars ( codCar );
    }

    private static void removeCars ( int codCar ) {
        for ( Car car : EntradaDatos.CARS ) {
            if ( codCar == car.getId ( ) ) {
                EntradaDatos.CARS.remove ( car );
                break;
            }
        }
    }

    private static void editCarById ( ) {
        int codCar = EntradaDatos.getCodCar ( "Ingresa el codigo del carro a editar" );
        for ( Car car : EntradaDatos.CARS ) {
            if ( codCar == car.getId ( ) ) {
                EntradaDatos.setMarcaModelColorToCar ( car );
                break;
            }
        }
    }


    private static void editUserById ( ) {
        int IdUser = EntradaDatos.getIdUser ( );
        for ( User user : EntradaDatos.USERS ) {
            if ( IdUser == user.getId ( ) ) {
                EntradaDatos.setDatosUser ( user );
                break;
            }
        }//fin for
    }

    private static int getIdUser ( ) {
        int IdUser;
        System.out.println ( "Ingrese el Id de usuario" );
        IdUser = Integer.parseInt ( EntradaDatos.SCANNER.nextLine ( ) );
        return IdUser;
    }


    private static void deleteUserById ( ) {
        int IdUser = EntradaDatos.getIdUser ( );
        for ( User user : EntradaDatos.USERS ) {
            if ( IdUser == user.getId ( ) ) {
                EntradaDatos.USERS.remove ( user );
                EntradaDatos.CARS.removeAll ( user.getCars ( ) );
                break;
            }
        }
    }

    private static int getCodCar ( String message ) {
        System.out.println ( message );
        return Integer.parseInt ( EntradaDatos.SCANNER.nextLine ( ).trim ( ) );
    }

    private static void getUsersContext ( int idUser ) {
        char addCar;
        List < Car > carList;
        User user = new User ( );
        user.setId ( idUser );
        EntradaDatos.setDatosUser ( user );
        System.out.println ( "¿Quieres agregar un carro?\nS: Si\nN: No" );
        addCar = EntradaDatos.SCANNER.nextLine ( ).charAt ( 0 );

        carList=EntradaDatos.addCarsToUser (  addCar );
        user.setCars ( carList );
        EntradaDatos.USERS.add ( user );
        EntradaDatos.CARS.addAll ( carList );

    }

    private static void setDatosUser ( User user ) {
        // do{
        //    String nombre,apellido,usuario,clave;
        System.out.println ( "Ingresa tu nombre" );
        user.setName ( EntradaDatos.SCANNER.nextLine ( ).trim ( ) );
        System.out.println ( "Ingresa tu apellido" );
        user.setLastName ( EntradaDatos.SCANNER.nextLine ( ).trim ( ) );
        System.out.println ( "Ingresa tu nombre de usuario" );
        user.setUser ( EntradaDatos.SCANNER.nextLine ( ).trim ( ).toLowerCase ( ) );
        System.out.println ( "Ingresa tu contraseña" );
        user.setPassword ( EntradaDatos.SCANNER.nextLine ( ).trim ( ) );
        //  }while ( scanner.equals ( nombre=="" | apellido,usuario,clave));
    }

    private static List<Car> addCarsToUser ( char addCar ) {
        List <Car> carList=new ArrayList <> (  );
        int codCar;
        String existeIdCar = "OK";
        Car carExist;
        Map<String,Object> mapa;
        while ( addCar == 'S' || addCar == 's' ) {
            do {
                /*System.out.println ( "Ingrese el codigo del carro" );
                codCar = Integer.parseInt ( EntradaDatos.SCANNER.nextLine ( ).trim ( ) );
                System.out.println ( EntradaDatos.CARS.size ( ) );*/
                mapa=EntradaDatos.searchByIdCar ();

                carExist=(Car)mapa.get ( "Carro" );
                codCar=(Integer ) mapa.get ( "Id" );
                if ( carExist!=null ){
                    existeIdCar="existe";
                }else{
                    existeIdCar="OK";
                }
            } while ( ! existeIdCar.equals ( "OK" ) );


            Car car = new Car ( );
            car.setId ( codCar );
            EntradaDatos.setMarcaModelColorToCar ( car );
            carList.add ( car );
            System.out.println ( "¿Quieres agregar un carro?\nS: Si\nN: No" );
            addCar = EntradaDatos.SCANNER.nextLine ( ).charAt ( 0 );
        }
        return carList;
    }

    private static void setMarcaModelColorToCar ( Car car ) {
        System.out.println ( "Ingrese la marca del carro" );
        car.setBrand ( EntradaDatos.SCANNER.nextLine ( ).trim ( ) );
        System.out.println ( "Ingrese el modelo del carro: " );
        car.setModel ( EntradaDatos.SCANNER.nextLine ( ).trim ( ) );
        System.out.println ( "Ingrese el color del carro: " );
        car.setColor ( EntradaDatos.SCANNER.nextLine ( ).trim ( ) );
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