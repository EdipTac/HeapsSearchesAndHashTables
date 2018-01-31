package com.Group2Q4ASG3.app;

import com.Group2Q4ASG3.sorting.HeapSort;
import com.Group2Q4ASG3.sorting.SelectionSort;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GPAminFinder {

    private Scanner sc;
    SelectionSort selectionSort = new SelectionSort();
    HeapSort heapSort = new HeapSort();

    public void perform() throws IOException {
        ArrayList<Double> gPAs = readTextFile();
        int key = getChoice(gPAs);
        ArrayList<Double> heapArr = heapSort.sort(gPAs);
        ArrayList<Double> gPAListHeap = heapSort.gPAList(heapArr,key);
        double[] selectionArr = selectionSort.sort(gPAs);
        double[] gPAarraySelection = selectionSort.gPAarray(selectionArr, key);

    }

    public int getChoice(ArrayList<Double> gPAs) {

        sc = new Scanner(System.in);
        int key;
        do {
            System.out.println("\nBPlease enter key value: ");

            if (sc.hasNextInt()) {
                key = sc.nextInt();
            } else {
                key = -1;
            }
            if (key < 0 || key > gPAs.size()) {
                key = -1;
                System.out.println("Invalid number, GPA must be more than 0 or less than number of GPAs");
            }
            sc.nextLine();
        } while (key < 0.0);

        return key;
    }

    public ArrayList<Double> readTextFile() throws FileNotFoundException, IOException {
        ArrayList<Double> gPAs = new ArrayList<>();
        String lines;
        BufferedReader textFile = new BufferedReader(new FileReader("/Users/aidasharifrohani/Desktop/Question4.txt"));
        while ((lines = textFile.readLine()) != null) {
            double number = Double.parseDouble(lines);
            gPAs.add(number);
        }
        return gPAs;

    }

    public static void main(String[] args) throws IOException {
        GPAminFinder gPAfinder = new GPAminFinder();
        gPAfinder.perform();
        System.exit(0);

    }

}
