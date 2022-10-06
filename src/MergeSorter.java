import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import Sorter.Sort;

public class MergeSorter {


public static void printArray (int array[]){
    for (int a: array){
        System.out.print(a + " ");
    }
    System.out.println();
}


public static int[] createRandomArray(int arrayLength){
    int array [] = new int[arrayLength];
    Random rand = new Random();
    for (int i = 0; i < arrayLength; i++){
        array[i] = rand.nextInt(100);
    }
    return array;
}


public static boolean isSorted(int array[]){
    for (int i = 0; i < array.length - 1; i++){
        if (array[i] > array[i+1]){
            return false;
        }
    }
    return true;
}


    public static void main(String[] args) throws Exception {
        long startTime;
        Scanner scnr = new Scanner(System.in);
    while (true){
        System.out.println("What is the length of a random integer array? Please enter an integer: ");
        int arrayLength = scnr.nextInt();
        startTime = System.currentTimeMillis();
        int array [] = createRandomArray(arrayLength);
        System.out.printf("Time to create an integer array length %d is %.6f s\n", arrayLength, (System.currentTimeMillis() - startTime) / 1000.0);

        startTime = System.currentTimeMillis();
        int sortedArray [] = Sort.mergeSort(array);
        System.out.printf("Merge sort an integer array length %d is %.6f s\n", arrayLength, (System.currentTimeMillis() - startTime) / 1000.0);
        System.out.println("The sorted array is in correct order: " + isSorted(sortedArray));

        startTime = System.currentTimeMillis();
        Sort.bubbleSort(array);
        System.out.printf("Bubble sort an integer array length %d is %.6f s\n", arrayLength, (System.currentTimeMillis() - startTime) / 1000.0);
        System.out.println("Merge sort and bubble sort generate the same result: " + Arrays.equals(sortedArray, array));

        System.out.println("\n" + "Continue? Please enter yes or no: ");
        String yesNo = scnr.next();
        if(yesNo.equals("no")) break;
    }
        scnr.close();
        System.out.println("Goodbye!");
        }
    }

