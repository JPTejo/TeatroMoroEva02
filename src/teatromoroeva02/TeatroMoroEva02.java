package teatromoroeva02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeatroMoroEva02 {
    static Scanner input = new Scanner(System.in);
    static Scanner cierre = new Scanner(System.in);
    static List<String> carrito = new ArrayList<>(); // Lista para almacenar las entradas en el carrito

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("== Menú de Venta ==");
            System.out.println("1. Comprar entradas");
            System.out.println("2. Modificar una venta existente");
            System.out.println("3. Eliminar una venta");
            System.out.println("4. Imprimir boleta");
            System.out.println("5. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    comprarEntradas();
                    break;
                case 2:
                    modificarVentaExistente();
                    break;
                case 3:
                    eliminarVenta();
                    break;
                case 4:
                    imprimirBoleta();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número válido.");
                    break;
            }
        } while (opcion != 5);

        input.close();
        cierre.close();
    }

    public static void comprarEntradas() {
        Scanner input = new Scanner(System.in);

        // Se solicita la ubicación deseada
        System.out.println("Estas son las siguientes ubicaciones que tiene el teatro:");
        System.out.println("  |  Escenario  |  ");
        System.out.println("  ---------------  ");
        System.out.println("  |  Zona  A    |  ");
        System.out.println("  |  Zona  B    |  ");
        System.out.println("  |  Zona  C    |  ");
        System.out.println("Que ubicación le gustaría? ");
        System.out.println("1 - Zona A");
        System.out.println("2 - Zona B");
        System.out.println("3 - Zona C");
        int ubicacion = input.nextInt();
        String zona;
        if (ubicacion == 1) {
            zona = "Zona A";
        } else if (ubicacion == 2) {
            zona = "Zona B";
        } else if (ubicacion == 3) {
            zona = "Zona C";
        } else {
            System.out.println("Opción inválida.");
            return;
        }

        // Se solicita la cantidad de entradas
        System.out.println("Ingrese la cantidad de entradas que desea comprar para la " + zona + ":");
        int cantidad = input.nextInt();

        // Se agrega la entrada al carrito de compras
        carrito.add("Ubicación: " + zona + ", Cantidad: " + cantidad);

        System.out.println("Entradas agregadas al carrito de compras.");
    }

    public static void modificarVentaExistente() {
        if (carrito.isEmpty()) {
            System.out.println("No hay entradas en el carrito de compras para modificar.");
            return;
        }

        System.out.println("== Carrito de Compras ==");

        for (int i = 0; i < carrito.size(); i++) {
            System.out.println((i + 1) + ". " + carrito.get(i));
        }

        System.out.print("Ingrese el número de entrada que desea modificar: ");
        int indice = input.nextInt() - 1;

        if (indice < 0 || indice >= carrito.size()) {
            System.out.println("Número de entrada inválido.");
            return;
        }

        System.out.println("Ingrese la nueva cantidad de entradas: ");
        int nuevaCantidad = input.nextInt();

        String entradaModificada = carrito.get(indice).split(", Cantidad:")[0] + ", Cantidad: " + nuevaCantidad;
        carrito.set(indice, entradaModificada);

        System.out.println("Entrada modificada correctamente.");
    }

    public static void eliminarVenta() {
        if (carrito.isEmpty()) {
            System.out.println("No hay entradas en el carrito de compras para eliminar.");
            return;
        }

        System.out.println("== Carrito de Compras ==");

        for (int i = 0; i < carrito.size(); i++) {
            System.out.println((i + 1) + ". " + carrito.get(i));
        }

        System.out.print("Ingrese el número de entrada que desea eliminar: ");
        int indice = input.nextInt() - 1;

        if (indice < 0 || indice >= carrito.size()) {
            System.out.println("Número de entrada inválido.");
            return;
        }

        carrito.remove(indice);

        System.out.println("Entrada eliminada correctamente.");
    }

    public static void imprimirBoleta() {
        if (carrito.isEmpty()) {
            System.out.println("No hay entradas en el carrito de compras para mostrar.");
            return;
        }

        System.out.println("== Su compra actual es ==");
        System.out.println("==========================");
        for (String entrada : carrito) {
            System.out.println(entrada);
        }

        System.out.println("Gracias por su compra!");
    }
}

