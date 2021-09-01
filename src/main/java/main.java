import java.util.Random;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        double arr[][]= new double[10][7];
        mostrarMenu();
        menuAccion(arr);
    }
    public static void mostrarMenu(){
        System.out.println("indique que desea hacer");
        System.out.println("*****************************************************");
        System.out.println("*                                                   *");
        System.out.println("* [1] Ingresar datos                                *");
        System.out.println("* [2] Mostrar sismo de mayor magnitud               *");
        System.out.println("* [3] Contar sismos mayores o iguales a 5.0         *");
        System.out.println("* [4] Enviar SMS por cada sismo mayor o igual a 7.0 *");
        System.out.println("* [5] Salir                                         *");
        System.out.println("*                                                   *");
        System.out.println("*****************************************************");
    }
    public static void menuAccion(double[][] arreglo){
        int a= -1;
        do{
            a=validar(5);
        switch (a){
            case 1:
                System.out.println("los sismos recientes son: ");
                llenarArreglo(arreglo);
                break;
            case 2:
                System.out.println("El sismo de mayor magnitud es:");
                buscarMayor(arreglo);
                break;
            case 3:
                System.out.println("Los sismos mayores o iguales a 5.0 son:");
                contarSismos(arreglo);
                break;
            case 4:
                System.out.println("SMS");
                enviarSMS(arreglo);
                break;
            case 5:
                System.out.println("adiós");
                break;
            }
            if(a!= 5){
                System.out.println("¿desea hacer otra cosa? presione 5 para salir");
            }
        }while(a!=5);
    }
    public static void llenarArreglo(double arr[][]){

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 7; j++) {
              arr[i][j]= (Math.random()*9.9);
              System.out.print("[" +arr[i][j]+ "]");
              System.out.println(" ");
            }
        }
    }
    public static void buscarMayor(double [][] sismos){
        double numeroMayor= 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                if (sismos[i][j] > numeroMayor){
                    numeroMayor= sismos[i][j];
                }
            }
        }
        System.out.println("["+numeroMayor+"]");
    }
    public static void contarSismos(double [][]sismos){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                if (sismos[i][j]== 5 || sismos[i][j] > 5){
                    System.out.println("["+sismos[i][j]+"]");
                    System.out.println(" ");
                }
            }
        }
    }
    public static void enviarSMS(double [][]sismos){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                if (sismos[i][j]==7 || sismos[i][j] > 7){
                    System.out.println("["+sismos[i][j]+"]");
                    System.out.println(" ");
                    System.out.println("Alerta!!! se debe evacuar zona costera!");
                    System.out.println(" ");
                }
            }
        }
    }
    public static int validar(int x) {
        int n = -1;
        do {
            //Scanner ponerlo dentro del DO, y dentro de una funcion
            Scanner teclado = new Scanner(System.in);
            //System.out.println("ingrese otro numero");
            try {
                n = teclado.nextInt();
            } catch (Exception e) {
                System.out.println("Error");
            }
            if (n < 0 || n == 0|| n > x) {
                System.out.println("ingrese un numero valido");
            }
        } while (n < 0|| n==0 ||n > x);
        return n;
    }
}

