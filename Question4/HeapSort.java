package com.Group2Q4ASG3.sorting;

import java.util.ArrayList;

/**
 *
 * @author aidasharifrohani
 */
public class HeapSort {

    public ArrayList<Double> sort(ArrayList<Double> gPAs) {
        ArrayList<Double> heapList = new ArrayList<>();

        for (int t = 0; t < gPAs.size(); t++) {
            int n = t;
            heapList.add(gPAs.get(n));
            // Build heap (rearrange array)
            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(heapList, heapList.size(), i);
            }

            // One by one extract an element from heap
            for (int i = heapList.size() - 1; i >= 0; i--) {
                // Move current root to end
                double temp = heapList.get(0);
                heapList.set(0, heapList.get(i));
                heapList.set(i, temp);

                // call max heapify on the reduced heap
                heapify(heapList, i, 0);
            }

        }
        System.out.print("\nHeap sort of original text file = [");
        for (int i = 0; i < heapList.size(); i++) {
            System.out.print(heapList.get(i) + " ");
        }
        System.out.print("]\n");
        return heapList;
    }

    public ArrayList<Double> gPAList(ArrayList<Double> heapList, int key) {
        ArrayList<Double> shrunkHeapList;
        ArrayList<Double> GPAHeapList = new ArrayList<>();
        for (int k = 0; k < key; k++) {
            GPAHeapList.add(heapList.get(k));
        }

        for (int k = 0; k < key; k++) {
            heapList.remove(0);
        }
        
        System.out.print("\n removed Heap sort of original text file = [");
        for (int i = 0; i < heapList.size(); i++) {
            System.out.print(heapList.get(i) + " ");
        }
        System.out.print("]\n");

        shrunkHeapList = sort(heapList);

        System.out.print("\nShrunk list from Heap sort = [");
        for (int i = 0; i < shrunkHeapList.size(); i++) {
            System.out.print(shrunkHeapList.get(i) + " ");
        }
        System.out.print("]\n");

        System.out.print("\n"+ key + " minimum GPAs from Heap Sort = [");
        for (int i = 0; i < GPAHeapList.size(); i++) {
            System.out.print(GPAHeapList.get(i) + " ");
        }
        System.out.print("]\n");
        return heapList;
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(ArrayList<Double> gPAs, int n, int i) {
        int largest = i;  // Initialize largest as root
        int l = 2 * i + 1;  // left = 2*i + 1
        int r = 2 * i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && gPAs.get(l) > gPAs.get(largest)) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < n && gPAs.get(r).compareTo(gPAs.get(largest)) > 0) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            double swap = gPAs.get(i);
            gPAs.set(i, gPAs.get(largest));
            gPAs.set(largest, swap);

            // Recursively heapify the affected sub-tree
            heapify(gPAs, n, largest);
        }
    }

}
