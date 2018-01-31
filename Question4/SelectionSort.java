package com.Group2Q4ASG3.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSort {

    public double[] sort(ArrayList<Double> gPAs) {
        double[] arr = new double[gPAs.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = gPAs.get(i);
        }
        //starting from the first element compares numbers 2 by 2 to find the smallest
        for (int i = 0; i < arr.length - 1; i++) {
            int pointer = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[pointer]) {
                    //if the element in position j is smaller it takes the smaller
                    //at the beginning of the unsorted list
                    pointer = j;
                }
            }

            double smallest = arr[pointer];
            //changing the place of the smaller number with the bigger in array
            arr[pointer] = arr[i];
            //putting the smallest at the beginning of the unsorted list
            arr[i] = smallest;
        }

        System.out.println("\nSelection sort of original text file = " + Arrays.toString(arr));
        return arr;
    }

    public double[] gPAarray(double arr[], int key) {
        double[] arrGPAs = new double[key];
        double[] shrunked = new double[0];
        for (int k = 0; k < key; k++) {
            arrGPAs[k] = arr[k];
            shrunked = shrunkArr(arr, k);
        }
        System.out.println("\n" + key + " minimum GPAs from Selection Sort = " + Arrays.toString(arrGPAs));
        System.out.println("\nShrunk array from selection sort = " + Arrays.toString(shrunked));
        return arrGPAs;
    }

    public double[] shrunkArr(double arr[], int key) {
        double[] newshrnkarr = new double[arr.length - key - 1];
        for (int l = key + 1, n = 0; l < arr.length; l++, n++) {
            newshrnkarr[n] = arr[l];
        }

        return newshrnkarr;
    }
    // System.out.println("\n Min GPAs by Selection sort" + Arrays.toString(arrGPAs));

}
