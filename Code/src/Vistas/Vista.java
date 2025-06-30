package Vistas;

import java.util.Scanner;
public class Vista {
    private Scanner sc;

    public Vista(){
        this.sc = new Scanner(System.in);
    };

    public void mostrarMenu(){
        System.out.println("\nIngrese la opcion que desee...");
        System.out.println("1 - Registrar Equipo.");
        System.out.println("2 - Registrar Jugador.");
        System.out.println("3 - Ver Lista de equipos.");
        System.out.println("4 - Ver Lista de jugadores.");
        System.out.println("5 - Iniciar Torneo.");
        System.out.println("6 - Ver listado de Torneos.");
        System.out.println("0 - Salir.");
    }

    public int getOpcion(){
        System.out.println("Opción : ");
        return this.sc.nextInt();
    }

    public int pedirEdad() {
        System.out.print("Ingrese la edad: ");
        return this.sc.nextInt();
    }

    public int pedirId(String tipo) {
        System.out.print("Ingrese el ID de " + tipo + ": ");
        return this.sc.nextInt();
    }

    public int pedirAnio() {
        while (true) {
            try {
                System.out.print("Ingrese el año: ");
                return this.sc.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("❌ Error: Debe ingresar un número entero válido para el año.");
                this.sc.nextLine(); // limpiar buffer
            }
        }
    }



    public int pedirCodigo(String tipo){
        while(true) {
            try {
                System.out.println("Ingrese el código (" + tipo + "): ");
                return this.sc.nextInt();
            } catch(java.util.InputMismatchException e) {
                System.out.println("Error: Por favor ingrese un número entero válido.");
                this.sc.nextLine(); // Limpia el buffer del scanner
            }
        }
    }

    public String pedirNombre(String tipo){
        System.out.println("Ingrese el nombre (" + tipo + "): ");
        return this.sc.next();
    }

    public String pedirApellido(String tipo){
        System.out.println("Ingrese el apellido (" + tipo + "): ");
        return this.sc.next();
    }

    public String pedirPosicion(String tipo){
        System.out.println("Ingrese el posicion (" + tipo + "): ");
        return this.sc.next();
    }

    public String pedirRubro(){
        System.out.println("Ingrese el rubro: ");
        return this.sc.next();
    }

    public int pedirStock(){
        while(true) {
            try {
                System.out.println("Ingrese la cantidad de stock existente: ");
                return this.sc.nextInt();
            } catch(java.util.InputMismatchException e) {
                System.out.println("Error: Por favor ingrese un número entero válido.");
                this.sc.nextLine(); // Limpia el buffer del scanner
            }
        }
    }

    public int pedirPuntosUno(){
        while(true) {
            try {
                System.out.println("Ingrese la cantidad de puntos del equipo local: ");
                return this.sc.nextInt();
            } catch(java.util.InputMismatchException e) {
                System.out.println("Error: Por favor ingrese un número entero válido.");
                this.sc.nextLine(); // Limpia el buffer del scanner
            }
        }
    }

    public int pedirPuntosDos(){
        while(true) {
            try {
                System.out.println("Ingrese la cantidad de puntos del equipo visitante: ");
                return this.sc.nextInt();
            } catch(java.util.InputMismatchException e) {
                System.out.println("Error: Por favor ingrese un número entero válido.");
                this.sc.nextLine(); // Limpia el buffer del scanner
            }
        }
    }

    public double pedirPrecio(String tipoPrecio){
        System.out.println("Ingrese el precio de " + tipoPrecio + ": ");
        return this.sc.nextDouble();
    }

    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
}