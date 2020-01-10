package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortByHeight {

    private boolean needsSwap = true;

    private int[] sortByHeight(int[] a) {

        while (needsSwap) {
            needsSwap = false;
            for (int i = 0; i < a.length-1; i++) {
                if (a[i] != -1) {
                    int j = i+1;
                    while(a[j] == -1){
                        j++;
                    }
                    if(a[i]>a[j]) swapElements(i,j,a);
                }
            }
        }
        return a;
    }
    private void swapElements( int a, int b, int[] inputArray){
        needsSwap = true;
        int temp = 0;
        temp = inputArray[b];
        inputArray[b] = inputArray[a];
        inputArray[a] = temp;
    }

    public static void main(String[] args){
        SortByHeight sortByHeight = new SortByHeight();

        int[] input = new int[]{-1, 150, 190, 170, -1, -1, 160, 180};

        int[] result = sortByHeight.sortByHeight(input);

        List<Integer> output = Arrays.stream(result).boxed().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(output);
    }

}
