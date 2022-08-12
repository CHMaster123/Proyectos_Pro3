package Practico_1;

import javax.swing.*;
import java.util.Scanner;

public class Ordenar {

    private int cantidad_Elementos;
    private int[] Or_insercion;
    private int[] Or_burbuja;
    private int[] Or_quicksort;


    public int getCantidad_Elementos() {
        return cantidad_Elementos;
    }

    public void setCantidad_Elementos(int cantidad_Elementos) {
        this.cantidad_Elementos = cantidad_Elementos;
    }

    public int[] getOr_insercion() {
        return Or_insercion;
    }

    public void setOr_insercion(int[] or_insercion) {
        Or_insercion = or_insercion;
    }

    public int[] getOr_burbuja() {
        return Or_burbuja;
    }

    public void setOr_burbuja(int[] or_burbuja) {
        Or_burbuja = or_burbuja;
    }

    public int[] getOr_quicksort() {
        return Or_quicksort;
    }

    public void setOr_quicksort(int[] or_quicksort) {
        Or_quicksort = or_quicksort;
    }

    /*public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int arreglo [];
        int elementos = Integer.parseInt(JOptionPane.showInputDialog("digite el numero de elementos: "));
        arreglo = new int[elementos];
        System.out.println("rellene el arreglo");
        for (int i = 0; i<elementos;i++){
            System.out.println((i+1)+". digite un numero:");
            arreglo[i]= entrada.nextInt();

        }
        int posicion;
        int aux;
        for (int i = 0; i<elementos; i++){
            posicion = i;
            aux = arreglo[i];

            while((posicion > 0)  && (arreglo[posicion - 1] > aux)){
                arreglo[posicion] = arreglo[posicion - 1];
                posicion--;

            }

        }
        for (int i=0; i<elementos;i++){
            System.out.println(arreglo[i]+" - ");

        }

    }*/
    public int[] ordenarInsercion (int[] arreglo){
        int posicion;
        int aux;
        for (int i = 0; i<this.cantidad_Elementos; i++){
            posicion = i;
            aux = arreglo[i];

            while((posicion > 0)  && (arreglo[posicion - 1] > aux)){
             arreglo[posicion] = arreglo[posicion - 1];
             posicion--;

            }

        }
        return  arreglo;
    }
}
