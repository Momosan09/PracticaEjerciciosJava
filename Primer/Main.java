/*Construya un algoritmo que realice las siguientes operaciones. Tiene 4 vectores
A,B,C y D de 10 elementos numéricos cada uno, llene el vector A con números
pares, el vector B con números impares, el vector C con la suma de A + B, el
vector D con la resta de A – B. Determinar la suma de cada vector y utilizarlo para
llenar el vector R que 4 elementos numéricos, es decir la suma del vector A
corresponde a la posición 0 del Vector R, la suma del vector B corresponde a la
posición 1 del vector R, y asi respectivamente con C y D. Imprima el vector R.
*/
import java.util.Scanner;

public class Main{

    public static void main(String [] args){
        Scanner s = new Scanner(System.in);

        int[] arrayA = new int[10];
        int[] arrayB = new int[10];
        int[] arrayC = new int[10];
        int[] arrayD = new int[10];
        int[] arrayR = new int[4];

        for(int i = 0; i < 10; i++){
            System.out.print(i);
            arrayA[i] = ingresarNumerosPares(s);
        }

        for(int i = 0; i < 10; i++){
            System.out.print(i);
            arrayB[i] = ingresarNumerosImpares(s);
        }

        sumarDosArray(arrayA, arrayB, arrayC);
        restarDosArray(arrayA, arrayB, arrayD);

        arrayR[0] = sumarArray(arrayA);
        arrayR[1] = sumarArray(arrayB);
        arrayR[2] = sumarArray(arrayC);
        arrayR[3] = sumarArray(arrayD);

        for(int i = 0; i < arrayR.length; i++ ){
            System.out.print("[" + arrayR[i] + "] ");
        } 

    }

    public static int ingresarNumerosPares(Scanner s){
        int ingresado = 0;
        try{
            do{
                System.out.print(" Ingrese un numero Par= ");
                ingresado = s.nextInt();
            }while(ingresado < 0 || (ingresado % 2) != 0);
        }catch(Exception e){
            System.out.println("Error, solo ingrese datos del tipo entero");
            s.nextLine();
            ingresado = ingresarNumerosPares(s);
        return ingresado;
        }
        return ingresado;
    }

    public static int ingresarNumerosImpares(Scanner s){
        int ingresado = 0;
        try{
            do{
                System.out.print(" Ingrese un numero Impar= ");
                ingresado = s.nextInt();
            }while(ingresado < 0 || (ingresado % 2) == 0);
            return ingresado;
        }catch (Exception e) {
            System.out.println("Error, solo ingrese datos del tipo entero");
            s.nextLine();
            ingresado = ingresarNumerosImpares(s);
            return ingresado;

        }
    }

    public static void sumarDosArray(int[] arrayPar, int[] arrayImpar, int[] arrayResultado){
        for(int i = 0; i<arrayImpar.length; i++){
            arrayResultado[i] = arrayPar[i] + arrayImpar[i];
        }

    }
    public static void restarDosArray(int[] arrayPar, int[] arrayImpar, int[] arrayResultado){
        for(int i = 0; i<arrayImpar.length; i++){
            arrayResultado[i] = arrayPar[i] - arrayImpar[i];
        }

    }
    public static int sumarArray(int[] arrayASumar){
        int resultado = 0;
        for(int i = 0; i<arrayASumar.length; i++ ){
            resultado += arrayASumar[i];
        } 
        return resultado;
    }

}