import java.util.Random;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        double arr[][]= new double[10][7];
        menu();
        menuAccion(arr);
    }
    public static void menu(){
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
        do{
        switch (validar(5)){
            case 1:
                System.out.println("rellenando arreglo...");
                llenarArreglo(arreglo);
                break;
            case 2:
                System.out.println("El sismo de mayor magnitud es:");
                buscarMayor(arreglo);
                break;
            case 3:
                System.out.println("Los sismos mayores o iguales a 5.0 son:");
                break;
            case 4:
                System.out.println("SMS");
                enviarSMS(arreglo);
                break;
            case 5:
                System.out.println("adiós");
                break;
       }}while(validar(5)==5);
    }
    public static void llenarArreglo(double arr[][]){

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 7; j++) {
              arr[i][j]= (Math.random()*9.9);
              System.out.print("[" +arr[i][j]+ "]");
              System.out.println(" ");
            }
        }
        ordenarMatriz(arr, 10, 7);
        verMatriz(arr, 10, 7);
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
    }
    public static void contarSismos(){

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
    static void ordenarMatriz(double matriz[][], int nFilas, int nCol){//menor a mayor

        for (int k = 0; k < nFilas; k++) {
            for (int i = 0; i < nCol ; i++) {
                for (int j = 0; j < nFilas; j++) {
                    for (int r = 0; r < nCol; r++) {
                        if (matriz[k][i]>=matriz[j][r]) {
                            matriz[k][i]=matriz[k][i];
                        }else{
                            double aux=matriz[j][r];
                            matriz[j][r]=matriz[k][i];
                            matriz[k][i]=aux;
                        }
                    }
                }
            }
        }
    }
    static void verMatriz(double matriz[][], int nFilas, int nCol) {
        for (int i = 0; i < nFilas; i++) {//numero de filas
            for (int j = 0; j < nCol; j++) {//numero de columnas
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println();
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
            if (n < 0 || n > x) {
                System.out.println("ingrese un numero valido");
            }
        } while (n < 0 ||n > x);
        return n;
    }
}

