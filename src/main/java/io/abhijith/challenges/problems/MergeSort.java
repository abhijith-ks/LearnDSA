package io.abhijith.challenges.problems;

/**
 * Implement mergesort algorithm
 */

public class MergeSort {

    public void findSolution() {

        int arr[] = {1, 4, 5, 1, 3, 4, 2, 6};
        mergeSort(arr, 0, arr.length - 1);
        for(int i: arr) {
            System.out.print("\t" + i);
        }

    }

    public void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] temp1 = new int[n1];
        int[] temp2 = new int[n2];
        for(int i = 0; i < n1; i++) {
            temp1[i] = arr[left + i];
        }
        for(int i = 0; i < n2 ; i++) {
            temp2[i] = arr[mid + i + 1];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if(temp1[i] < temp2[j]) {
                arr[k] = temp1[i];
                i++;
            } else {
                arr[k] = temp2[j];
                j++;
            }
            k++;
        }

        while(i < n1) {
            arr[k] = temp1[i];
            i++;
            k++;
        }

        while(j < n2) {
            arr[k] = temp2[j];
            j++;
            k++;
        }
    }

}
