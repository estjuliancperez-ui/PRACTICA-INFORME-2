package proyecto_laboratorio_2;

import java.util.Scanner;

public class Main {

    public static void mostrarMenuPrincipal() {
        System.out.println("=== Menú Principal ===");
        System.out.println("1. Punto 3.1 (Ejemplo)");
        System.out.println("2. Punto 3.2 - Tabla comparativa de ordenamientos");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    
    public static void mostrarSubmenuPunto_2(Ejercicio_2 ejercicio) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Submenú Punto 3.2 ---");
            System.out.println("1. Generar tabla comparativa");
            System.out.println("2. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");

            String opcion = sc.nextLine();

            switch (opcion) {
                case "1" -> ejercicio.generarTablaComparativa();
                case "2" -> {
                    return; // Regresa al menú principal
                }
                default -> System.out.println("Opción inválida, intente de nuevo.");
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Ejercicio_2 ejercicio_2 = new Ejercicio_2();
            boolean salir = false;
            
            while (!salir) {
                mostrarMenuPrincipal();
                String opcion = sc.nextLine();
                
                switch (opcion) {
                    case "1" -> System.out.println("Punto 3.1 no implementado. (Aquí va la funcionalidad del punto 3.1)");
                    case "2" -> mostrarSubmenuPunto_2(ejercicio_2);
                    case "3" -> {
                        System.out.println("Saliendo del programa...");
                        salir = true;
                    }
                    default -> System.out.println("Opción inválida, intente de nuevo.");
                }
            }
        }
    }
}
