/*Se debe crear un programa para administrar el stock de productos de una tienda
de comestibles la cual tiene la capacidad de administrar 50 variedades de los
mismos. La información a ingresar por cada producto será: nombre, precio y
cantidad.
Se debe mostrar un menú con las siguientes opciones:
a) Consultar productos en la tienda
b) Dar de alta una variedad de producto
c) Dar de baja una variedad de producto
d) Modificar stock de un producto
e) Modificar precio de un producto
f) Vender producto
g) Salir */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int eligeMenu;

        String[][] productos = {
                { "Producto 1", "10.5", "20" },
                { "Producto 2", "5.75", "50" },
                { "Producto 3", "15.0", "15" },
                { "Producto 4", "3.99", "30" },
                { "Producto 5", "8.25", "10" },
                { "Producto 6", "12.0", "5" },
                { "Producto 7", "2.5", "40" },
                { "Producto 8", "6.99", "25" },
                { "Producto 9", "20.0", "8" },
                { "Producto 10", "7.5", "18" },
                { "Producto 11", "9.25", "22" },
                { "Producto 12", "13.75", "12" },
                { "Producto 13", "4.0", "35" },
                { "Producto 14", "1.99", "60" },
                { "Producto 15", "11.5", "6" },
                { "Producto 16", "14.99", "15" },
                { "Producto 17", "7.0", "25" },
                { "Producto 18", "19.99", "8" },
                { "Producto 19", "3.5", "50" },
                { "Producto 20", "16.75", "12" },
                { "Producto 21", "8.99", "20" },
                { "Producto 22", "5.0", "30" },
                { "Producto 23", "12.5", "7" },
                { "Producto 24", "10.0", "18" },
                { "Producto 25", "6.49", "30" },
                { "Producto 26", "21.99", "5" },
                { "Producto 27", "4.25", "40" },
                { "Producto 28", "8.5", "20" },
                { "Producto 29", "3.0", "50" },
                { "Producto 30", "17.5", "10" },
                { "Producto 31", "6.0", "25" },
                { "Producto 32", "9.99", "15" },
                { "Producto 33", "13.0", "8" },
                { "Producto 34", "5.5", "35" },
                { "Producto 35", "18.99", "12" },
                { "Producto 36", "11.75", "20" },
                { "Producto 37", "4.5", "30" },
                { "Producto 38", "7.99", "22" },
                { "Producto 39", "15.5", "10" },
                { "Producto 40", "2.99", "50" },
                { "Producto 41", "9.0", "15" },
                { "Producto 42", "14.99", "6" },
                { "Producto 43", "6.25", "28" },
                { "Producto 44", "12.99", "12" },
                { "Producto 45", "20.0", "5" },
                { "Producto 46", "3.25", "40" },
                { "Producto 47", "10.99", "18" },
                { "Producto 48", "7.0", "25" },
                { "Producto 49", "16.5", "8" },
                { "Producto 50", "4.99", "30" }
                

        };
        /*
         * modificarValorEnMatriz(s, productos, 1);
         * modificarValorEnMatriz(s, productos, 2);
         */

        System.out.println("1.Consultar Productos");
        System.out.println("2.Dar de baja Producto");
        System.out.println("3.Modificar Stock");
        System.out.println("4.Modificar Precio");
        System.out.println("5.Vender");
        System.out.println("6.Salir");
        System.out.println("");
        do{
            try {
                System.out.print("Elige Menu = ");
                eligeMenu = s.nextInt();
                s.nextLine();
            } catch (Exception e) {
                s.nextLine();
                System.out.println("");
                System.out.print("Eliga una de las opciones = ");
                eligeMenu = s.nextInt();
                s.nextLine();
        }
        }while(eligeMenu < 0 || eligeMenu > 6);

        switch (eligeMenu) {
            case 1:
                consultarProductos(productos);
                break;
            case 2:
                darDeBajaProducto(s, productos);
                break;
            case 3:
                modificarValorEnMatriz(s, productos, 2);
                break;
            case 4:
                modificarValorEnMatriz(s, productos, 1);
                break;
            case 5:
                venderProducto(s, productos);
                break;

                default:
                System.out.println("Opción inválida");
                break;
        }

    }

    public static void consultarProductos(String[][] matrizAnalizar) {
        System.out.println("Productos en Stock: ");
        for (int i = 0; i < matrizAnalizar.length; i++) {
            for (int j = 0; j < matrizAnalizar[i].length; j++) {
                System.out.println(((j == 1) ? "Precio: " : "Cantidad: ") + matrizAnalizar[i][j]);
            }
            System.out.println("");
        }
    }

    public static void modificarValorEnMatriz(Scanner s, String[][] matrizModificarPrecio, int posicion) {
        int indice = 0;
        String buscarProducto;
        boolean existeProd = false;
        System.out.print("Ingrese nombre del producto al que le quiere modificar "
                + ((posicion == 1) ? "el precio" : "la cantidad"));
        buscarProducto = s.nextLine();

        for (int i = 0; i < matrizModificarPrecio.length; i++) {
            if (buscarProducto.equals(matrizModificarPrecio[i][0])) {
                existeProd = true;
                indice = i;
            }
        }

        if (existeProd) {
            System.out.println("Producto encontrado," + ((posicion == 1) ? "precio" : "cantidad") + "actual = "
                    + matrizModificarPrecio[indice][posicion]);
            System.out.println("");
            System.out.print("Nuevo precio = ");
            matrizModificarPrecio[indice][posicion] = IngresarDato(s);
        } else {
            System.out.println("No se encontro el producto");
        }

    }

    public static String IngresarDato(Scanner s) {
        float nuevoValor = 0;
        try {
            do {
                nuevoValor = s.nextFloat();
            } while (nuevoValor < 0);
        } catch (Exception e) {
            System.out.println("Ingrese un valor numerico");
            s.nextLine();
            IngresarDato(s);
        }
        return String.valueOf(nuevoValor);

    }

    public static int buscarNombreEnLaMatriz(String[][] matriz, String objetivo) {
        int encontrado = -1;
        for (int i = 0; i < matriz.length; i++) {
            if (objetivo.equals(matriz[i][0])) {
                encontrado = i;
            }
        }
        return encontrado;
    }

    public static void darDeBajaProducto(Scanner s, String matriz[][]) {
        String nombreProducto;
        int indice = -1;
        System.out.print("Ingrese producto a dar de baja: ");
        nombreProducto = s.nextLine();
        indice = buscarNombreEnLaMatriz(matriz, nombreProducto);

        if (indice >= 0 && indice < matriz.length) {
            for (int i = indice; i < matriz.length - 1; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    matriz[i][j] = matriz[i + 1][j];

                }
            }
            for (int j = 0; j < matriz[indice].length; j++) {
                matriz[matriz.length - 1][j] = "";
            }
        }
    }

    public static void venderProducto(Scanner s, String matriz[][]) {
        String nombreProducto;
        int indice = -1;

        System.out.print("Ingrese nombre del producto a vender: ");
        nombreProducto = s.nextLine();
        indice = buscarNombreEnLaMatriz(matriz, nombreProducto);
        if (indice >= 0 && indice < matriz.length) {
            int valorIngresado = 0;
            int valorEnMatriz = Integer.parseInt(matriz[indice][2]);
            System.out.println("");
            System.out.print("Ingrese cantidad de unidades vendidas = ");
            valorIngresado = Integer.parseInt(IngresarDato(s));

            matriz[indice][2] = String.valueOf(valorEnMatriz - valorIngresado);

            System.out.println("Cantidad luego de la venta = " + matriz[indice][2]);
        }

    }
}