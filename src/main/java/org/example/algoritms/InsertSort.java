package org.example.algoritms;

public class InsertSort {

    public static int[] insertSort(int[] array){
        for(int i=0;i<array.length;i++){
            int pos=i;
            int min=array[i];
            for(int j=i+1;j< array.length;j++){
                if(array[j]<min){
                    min=array[j];
                    pos=j;
                }
            }
            if(pos!=i){
                array[pos]= array[i];
                array[i]=min;
            }
        }
        return array;
    }
}
