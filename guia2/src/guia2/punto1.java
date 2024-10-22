
package guia2;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class punto1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        System.out.print("Ingrese el tamano del arreglo: ");
        int tamaño = sc.nextInt();
        
        int[] arreglo = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = rand.nextInt(100); // Números aleatorios entre 0 y 99
        }
        
        System.out.println("Arreglo: " + Arrays.toString(arreglo));
        
        // Media
        double media = Arrays.stream(arreglo).average().orElse(Double.NaN);
        System.out.println("Media: " + media);
        
        // Mediana
        Arrays.sort(arreglo);
        double mediana;
        if (tamaño % 2 == 0) {
            mediana = (arreglo[tamaño/2 - 1] + arreglo[tamaño/2]) / 2.0;
        } else {
            mediana = arreglo[tamaño/2];
        }
        System.out.println("Mediana: " + mediana);
        
        // Varianza
        double sumatoria = 0;
        for (int num : arreglo) {
            sumatoria += Math.pow(num - media, 2);
        }
        double varianza = sumatoria / tamaño;
        System.out.println("Varianza: " + varianza);
        
        // Desviación estándar
        double desviacionEstandar = Math.sqrt(varianza);
        System.out.println("Desviacion estandar: " + desviacionEstandar);
        
        // Moda
        int maxRepeticiones = 0;
        int moda = arreglo[0];
        for (int i = 0; i < tamaño; i++) {
            int numRepeticiones = 0;
            for (int j = 0; j < tamaño; j++) {
                if (arreglo[j] == arreglo[i]) numRepeticiones++;
            }
            if (numRepeticiones > maxRepeticiones) {
                maxRepeticiones = numRepeticiones;
                moda = arreglo[i];
            }
        }
        System.out.println("Moda: " + moda);
        
        sc.close();
    }
}