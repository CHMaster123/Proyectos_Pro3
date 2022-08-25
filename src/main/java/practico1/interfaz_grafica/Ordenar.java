/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practico1.interfaz_grafica;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author crist
 */
public class Ordenar {
    protected static final Logger logger = LogManager.getLogger();
    public int[] ordenarInsercion(int[] arreglo) {
        int aux;
        int contador1;
        int contador2;
        for (contador1 = 1; contador1 < arreglo.length; contador1++) {
            aux = arreglo[contador1];
            for (contador2 = contador1 - 1; contador2 >= 0 && arreglo[contador2] > aux; contador2--) {
                arreglo[contador2 + 1] = arreglo[contador2];
                arreglo[contador2] = aux;
            }
        }
        return arreglo;
    }

    public int[] ordenarQuicksort(int[] arreglo) {
        arreglo = quicksort1(arreglo);
        logger.debug("quicksort entra en Stackoverflow si se usa mas de 60.000 numeros");
        return arreglo;
    }

    public int[] quicksort1(int[] arreglo) {

        return quicksort2(arreglo, 0, arreglo.length - 1);
    }

    public int[] quicksort2(int [] numeros,int izq, int der){
        if(izq>=der) {
            return numeros;
        }
        int i=izq;
        int d=der;
        if(izq!=der){
            int pivote;
            int aux;
            pivote = izq;
            while(izq!=der){
                while(numeros[der]>=numeros[pivote] && izq<der) {
                    der--;
                }
                while(numeros[izq]<numeros[pivote] && izq<der) {
                    izq++;
                }
                if(der!=izq){
                    aux = numeros[der];
                    numeros[der]=numeros[izq];
                    numeros[izq]=aux;
                }
            }
            if(izq==der){
                quicksort2(numeros,i,izq-1);
                quicksort2(numeros,izq+1,d);
            }
        }
        else {
            return numeros;
        }
        return numeros;
    }

    public int[] ordenarBurbuja ( int[] arreglo){
        int aux;
        boolean cambio = false;

        while (true) {
            cambio = false;
            for (int i = 1; i < arreglo.length; i++) {
                if (arreglo[i] < arreglo[i - 1]) {
                    aux = arreglo[i];
                    arreglo[i] = arreglo[i - 1];
                    arreglo[i - 1] = aux;
                    cambio = true;
                }

            }
            if (cambio == false) {
                break;
            }
        }
        return arreglo;
    }
}
