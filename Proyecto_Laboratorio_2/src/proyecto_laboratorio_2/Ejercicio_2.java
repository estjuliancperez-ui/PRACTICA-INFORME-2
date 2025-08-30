package proyecto_laboratorio_2;

import java.util.Arrays;

public class Ejercicio_2 {

    // Métodos de ordenamiento encapsulados en esta clase

    public void burbuja(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void insercion(double[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            double key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public void seleccion(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            double temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public void mergesort(double[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            double[] left = Arrays.copyOfRange(arr, 0, mid);
            double[] right = Arrays.copyOfRange(arr, mid, arr.length);

            mergesort(left);
            mergesort(right);

            merge(arr, left, right);
        }
    }

    private void merge(double[] arr, double[] left, double[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Genera arreglo con Math.random()
    public double[] generarArreglo(int n) {
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Math.random() * 10000;
        }
        return arr;
    }

    // Copia arreglo
    public double[] copiarArreglo(double[] original) {
        return Arrays.copyOf(original, original.length);
    }

    // Método que genera la tabla comparativa y la imprime en consola
    public void generarTablaComparativa() {
        int[] tamaños = {100, 500, 1000, 5000, 10000};

        System.out.println("\nTabla comparativa de tiempos de ordenamiento (milisegundos):");
        System.out.printf("%-10s %-15s %-15s %-15s %-15s%n", "Tamaño", "Burbuja", "Inserción", "Selección", "Mergesort");

        for (int n : tamaños) {
            double[] original = generarArreglo(n);

            double[] arrBurbuja = copiarArreglo(original);
            long start = System.currentTimeMillis();
            burbuja(arrBurbuja);
            long end = System.currentTimeMillis();
            long tiempoBurbuja = end - start;

            double[] arrInsercion = copiarArreglo(original);
            start = System.currentTimeMillis();
            insercion(arrInsercion);
            end = System.currentTimeMillis();
            long tiempoInsercion = end - start;

            double[] arrSeleccion = copiarArreglo(original);
            start = System.currentTimeMillis();
            seleccion(arrSeleccion);
            end = System.currentTimeMillis();
            long tiempoSeleccion = end - start;

            double[] arrMerge = copiarArreglo(original);
            start = System.currentTimeMillis();
            mergesort(arrMerge);
            end = System.currentTimeMillis();
            long tiempoMerge = end - start;

            System.out.printf("%-10d %-15d %-15d %-15d %-15d%n", n, tiempoBurbuja, tiempoInsercion, tiempoSeleccion, tiempoMerge);
        }
        System.out.println();
    }
}
