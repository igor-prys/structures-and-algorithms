package org.example.algorithms.sort;

public class MergeSort {
    public static int[] sort(int[] array) {
        if (array == null) {
            return null;
        }
        if (array.length < 2) {
            return array;
        }
        int[] arrayA = new int[array.length / 2];
        System.arraycopy(array, 0, arrayA, 0, arrayA.length);
        int[] arrayB = new int[array.length - arrayA.length];
        System.arraycopy(array, arrayA.length, arrayB, 0, arrayB.length);
        sort(arrayA);
        sort(arrayB);
        merge(array, arrayA, arrayB);
        return array;
    }

    private static int[] merge(int[] array, int[] arrayA, int[] arrayB) {
        int posA = 0;
        int posB = 0;
        for (int i = 0; i < array.length; i++) {
            if (posA == arrayA.length) {
                array[i] = arrayB[posB];
                posB++;
            } else if (posB == arrayB.length) {
                array[i] = arrayA[posA];
                posA++;
            } else if (arrayA[posA] < arrayB[posB]) {
                array[i] = arrayA[posA];
                posA++;
            } else {
                array[i] = arrayB[posB];
                posB++;
            }
        }
        return array;
    }
}
