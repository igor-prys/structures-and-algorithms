package org.example.algorithms.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.example.algorithms.sort.InsertSort.sort;

public class InsertSortTest {
    private int[] array = {6, 2, 4, 8, 3, 7, 9, 5, 1};

    @Test
    public void shouldSortArray() {
        Assertions.assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]", Arrays.toString(sort(array)));
    }

    @Test
    public void shouldSortEmptyArray() {
        int[] array = new int[5];
        Assertions.assertEquals("[0, 0, 0, 0, 0]", Arrays.toString(sort(array)));
    }

    @Test
    public void shouldSortSortedArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assertions.assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]", Arrays.toString(sort(array)));
    }

    @Test
    public void shouldSortArrayWithDouble() {
        int[] array = {3, 2, 1, 3, 5, 8, 7, 5, 8};
        Assertions.assertEquals("[1, 2, 3, 3, 5, 5, 7, 8, 8]", Arrays.toString(sort(array)));
    }
}
