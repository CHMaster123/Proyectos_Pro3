package Practico1.ejecutor;

import Practico1.codigo.Ordenar;


public class Main {


    public static void main(String[] args) {
     int [] arreglo = {10,2,3,5,4,21,5,7,8,1,12,154,26,78,36,5,1,2,87,5,32,1,478,5,2};
     Ordenar ordenador= new Ordenar();
     ordenador.ordenarQuicksort(arreglo);
             for (int i = 0;i<arreglo.length;i++){
                 System.out.println(arreglo[i]+" - ");
             }

    }
}
