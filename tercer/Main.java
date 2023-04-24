
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[][] personas = new String[2][3];

        for(int i = 0; i < personas.length; i++){
            System.out.println("Persona " + i);
                System.out.println("Ingrese 1 para el sexo masculino / Ingrese 0 para el sexo femenino");
                personas[i][0] =  (ingresarDato(s, 0, 1) == 1?"masculino":"femenino");
                System.out.println("Ingrese 1 si tiene trabajo / Ingrese 0 si no tiene trabajo");
                personas[i][1] =  (ingresarDato(s, 0, 1) == 1?"trabaja":"no trabaja");
                if(personas[i][1].equals("trabaja")){
                    System.out.println("Ingrese su sueldo");
                    personas[i][2] = String.valueOf(ingresarDato(s, 6000 , 20000));
                }else{
                    personas[i][2] = "0";   
                }
                System.out.println("");


        }

        System.out.println( "Porcentaje de hombres = " + ((sacarCantidad(personas, "masculino") / personas.length) * 100) + "%");
        System.out.println( "Porcentaje de mujeres = " + ((sacarCantidad(personas, "femenino") / personas.length) * 100) + "%");
        System.out.println( "Porcentaje de hombres que trabajan = " + ((conseguirCantidadPorGeneroYObjetivo(personas,1, "trabaja", 0, "masculino") / sacarCantidad(personas, "femenino")) * 100) + "%");
        System.out.println( "Porcentaje de mujeres que trabajan = " + ((conseguirCantidadPorGeneroYObjetivo(personas,1, "trabaja", 0, "femenino") / sacarCantidad(personas, "femenino")) * 100) + "%");
        System.out.println("Sueldo promedio del hombre = $" + (conseguirSueldoTotalPorGenero(personas, 2, "masculino") / sacarCantidad(personas, "masculino")));
        System.out.println("Sueldo promedio de la mujer = $" + (conseguirSueldoTotalPorGenero(personas, 2, "femenino") / sacarCantidad(personas, "femenino")));

    }

    public static int ingresarDato(Scanner s, int min, int max) {
        boolean error = false;
        int ingresado = 0;

        try {
            do {
                System.out.print("  Ingrese un numero entero = ");
                ingresado = s.nextInt();
                if(ingresado < min || ingresado > max){
                    error = true;
                    System.out.println("El numero ingresado debe ser mayor a " + min + " y menor que " + max);
                }else{
                    error = false;
                }
            } while (error);
        } catch (Exception e) {
            System.out.println("Ingrese valores numericos");
            s.nextLine();
            ingresarDato(s, min, max);
        }

        return ingresado;

    }

    public static float sacarCantidad(String[][] matrizObjetivo, String objetivo){
        int cantidad = 0;
        for(int i = 0; i < matrizObjetivo.length; i++){
            if(matrizObjetivo[i][0].equals(objetivo)){
                cantidad++;
            }
        }
        return cantidad;
    }
    
    public static float conseguirCantidadPorGeneroYObjetivo(String[][] matrizObjetivo, int posicionCondicion1, String objetivo, int posicionCondicion2, String genero){
        int cantidad = 0;
        for(int i = 0; i < matrizObjetivo.length; i++){
            if(matrizObjetivo[i][posicionCondicion1].equals(objetivo) && matrizObjetivo[i][0].equals(genero)){
                cantidad++;
            }
        }
        return cantidad;
    }

    public static float conseguirSueldoTotalPorGenero(String[][] matrizObjetivo, int posicion, String genero){
        int cantidad = 0;
        for(int i = 0; i < matrizObjetivo.length; i++){
            for(int j = 0; j < matrizObjetivo[i].length; j++){
                if(matrizObjetivo[i][0].equals(genero)){
                    cantidad += Integer.valueOf(matrizObjetivo[i][posicion]);
                }
            }
        }
        return cantidad;
    }


}
