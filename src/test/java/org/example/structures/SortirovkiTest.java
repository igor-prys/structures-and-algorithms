package org.example.structures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.example.algoritms.BubbleSort.bubbleSort;
import static org.example.algoritms.InsertSort.insertSort;
import static org.example.algoritms.MergeSort.mergeSort;

public class SortirovkiTest {

    @Test
    public void shouldCheckBubbleSort() {
        int[] array= {6, 2, 4, 8, 3, 7, 9, 5, 1};
        Assertions.assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]", Arrays.toString(bubbleSort(array)));
    }
    @Test
    public void shouldCheckInsertSort(){
        int[] array= {6, 2, 4, 8, 3, 7, 9, 5, 1};
        Assertions.assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]",Arrays.toString(insertSort(array)));
    }
    @Test
    public void shouldCheckMergeSort(){
        int[] array= {6, 2, 4, 8, 3, 7, 9, 5, 1};
        Assertions.assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]",Arrays.toString(mergeSort(array)));
    }
}
