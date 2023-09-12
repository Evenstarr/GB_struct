package org.example.lesson2;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] arr = {1, 10, 8, 15, 2, 3, 5};

        System.out.println("Nonsorted array");
        printArray(arr);

        HeapSort hs = new HeapSort();

        hs.sort(arr);

        System.out.println("Sorted array");
        printArray(arr);

    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}