
package guia2;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class punto3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizes = {100, 500, 1000, 5000, 10000};
        System.out.println("Seleccione el algoritmo de ordenamiento:");
        System.out.println("1. Burbuja");
        System.out.println("2. Insercion");
        System.out.println("3. Seleccion");
        System.out.println("4. MergeSort");
        int option = scanner.nextInt();

        System.out.printf("%-10s %-15s\n", "Tamano", "Tiempo (ms)");
        for (int size : sizes) {
            double[] array = generateRandomArray(size);
            double[] arrayCopy = Arrays.copyOf(array, array.length);

            long startTime = System.currentTimeMillis();
            switch (option) {
                case 1:
                    bubbleSort(array);
                    break;
                case 2:
                    insertionSort(array);
                    break;
                case 3:
                    selectionSort(array);
                    break;
                case 4:
                    mergeSort(array);
                    break;
                default:
                    System.out.println("numero no valido.");
                    return;
            }
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            System.out.printf("%-10d %-15d\n", size, duration);
        }
    }

    // Generar un arreglo de números aleatorios
    public static double[] generateRandomArray(int size) {
        Random rand = new Random();
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextDouble() * 1000; // Números aleatorios entre 0 y 1000
        }
        return array;
    }

    // Implementación de Burbuja
    public static void bubbleSort(double[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Implementación de Inserción
    public static void insertionSort(double[] array) {
        for (int i = 1; i < array.length; i++) {
            double key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // Implementación de Selección
    public static void selectionSort(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    // Implementación de MergeSort
    public static void mergeSort(double[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;
            double[] left = Arrays.copyOfRange(array, 0, mid);
            double[] right = Arrays.copyOfRange(array, mid, array.length);
            
            mergeSort(left);
            mergeSort(right);

            merge(array, left, right);
        }
    }

    private static void merge(double[] array, double[] left, double[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}
