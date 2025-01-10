package Array;

import static java.lang.System.exit;
import java.util.*;

public class arrayall {

    int[] value, arr1, arr2, arr3;
    Scanner input = new Scanner(System.in);
    int i, postn, arr_size, size, data, found;
    char response;
    int v, arr1size, arr2size, length;

    public static void main(String[] args) {
        arrayall arl = new arrayall();
        arl.size_input();
    }

    public void traverse() {
        System.out.println("------------TRAVERSAL-----------");
        for (i = 0; i < value.length; i++) {
            System.out.println(value[i]);
        }
    }

    private void insertion() {
        int val_to_insrt;
        System.out.println("------------INSERTION-----------");
        postn = insert_input();
        System.out.println("Please Enter the Value to be entered on the " + postn + "th position ");
        val_to_insrt = input.nextInt();
        for (i = value.length - 1; i >= postn; i--) {
            try {
                value[i + 1] = value[i];
            } catch (Exception e) {

            }
            value[i] = val_to_insrt;
        }
        traverse();
    }

    private void deletion() {
        int pos, size = value.length;
        System.out.println("------------DELETION-----------");
        pos = insert_input();

        for (int i = pos + 1; i < value.length; i++) {
            value[i - 1] = value[i];
        }
        if (pos == value.length - 1) {
            value[pos - 1] = 0;
        } else {
            System.out.println("else");
        }

        traverse();
    }

    private void linear_search() {
        System.out.println("Enter data to search");
        data = input.nextInt();
        i = 0;
        found = 0;
        do {
            if (data == value[i]) {
                System.out.println("Element at position " + i);
                found = 1;
            }
            i++;
        } while (i <= size);

        if (found == 0) {
            System.out.println("Iterater not found");
        }
    }

    private void binary_search() {
        int start = 1, end = size, middle, bnry_srch = 0;
        System.out.println("Enter data to search");
        data = input.nextInt();
        lp:
        while (start < end) {
            middle = (start + end) / 2;
            try {
                if (value[middle] == data) {
                    System.out.println("Element found at" + middle);
                    bnry_srch = 1;
                    break lp;
                }
                if (value[middle] <= data) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }

            } catch (Exception e) {
                System.out.println("catched ");
            }
        }
        if (bnry_srch != 1) {
            System.out.println("Element does not Exists");
        }
    }

    private void bubbleSorting() {

        int temp;
        int n = value.length;
        try {
            for (int p = 0; p <= n - 1; p++) {
                for (int i = 1; i <= (n - 1) - p; i++) {
                    if (value[i - 1] > value[i]) {
                        System.out.println("going " + i + " time");
                        temp = value[i];
                        value[i] = value[i - 1];
                        value[i - 1] = temp;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("catched ");
        }
        for (int i = 0; i < n; i++) {
            System.out.println(value[i]);
        }
    }

    private void Merging() {
        arrays();
        System.out.println("Enter one option");
        System.out.println("1.Sorted");
        System.out.println("2.UNSorted");
        switchOpt();
    }

    
     public void mergeTraverse() {

        for (int v = 0; v < arr3.length; v++) {
            System.out.println(arr3[v]);
        }
    }
     
     
    private void switchOpt() {
        char ask = input.next().charAt(0);
        switch (ask) {
            case 'A':
            case 'a':
            case '1':
                sortedMerging();
                break;
            case 'B':
            case 'b':
            case '2':
                unsortedMerging();
                break;
            case 'C':
            case 'c':
            case '3':
                exit(0);
                break;
            default:
                System.out.println(ask + " is not in option");
                System.out.println("PLEASE ENTER CORRECT OPTION");

                switchOpt();
                break;
        }
    }

    public void sortedMerging() {
        arr3 = new int[length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr3[k] = arr1[i];
                i = i + 1;
                k = k + 1;
            } else {
                arr3[k] = arr2[j];
                j = j + 1;
                k = k + 1;
            }
        }
        if (i > arr1.length - 1) {
            while (j <= arr2.length - 1) {
                arr3[k] = arr2[j];
                j++;
                k++;
            }
        } else if (j > arr2.length - 1) {
            while (j <= arr1.length - 1) {
                arr3[k] = arr1[i];
                j++;
                k++;
            }
        }
        mergeTraverse();
    }

    public void unsortedMerging() {
        arr3 = new int[length];
        int pos = 0;
        for (int element : arr1) {
            arr3[pos] = element;
            pos++;
        }

        for (int element : arr2) {
            arr3[pos] = element;
            pos++;
        }
        mergeTraverse();
    }

    private void arrays() {
        System.out.println("Size of Array 1");
        arr1size = input.nextInt();
        System.out.println("Size of Array 2");
        arr2size = input.nextInt();
        arr1 = new int[arr1size];
        arr2 = new int[arr2size];
        System.out.println("Enter " + arr1size + " elements in array 1");
        for (i = 0; i < arr1size; i++) {
            arr1[i] = input.nextInt();
        }
        System.out.println("Enter " + arr2size + " elements in array 1");
        for (i = 0; i < arr2size; i++) {
            arr2[i] = input.nextInt();
        }
        length = arr1size + arr2size;
    }

    private int insert_input() {

        System.out.println("Enter the index you want to add/delete an element");
        Scanner input = new Scanner(System.in);
        int pos = input.nextInt();
        if (pos >= value.length) {
            System.out.println("incorrect Value");
            System.out.println("TRY AGAIN");
            insert_input();
        } else {
            postn = pos;
            return pos;
        }
        return postn;
    }

    private void arr_size() {
        try {
            System.out.println("Enter Array Size");
            Scanner input = new Scanner(System.in);
            arr_size = input.nextInt();

            System.out.println("Please Enter how many values out of " + arr_size + " you want to provide");
            value = new int[arr_size];
            size = input.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (arr_size < size) {
            arr_size();
        } else {
            System.out.println("Enter " + size + " element in array");
            try {
                for (int i = 0; i <= size - 1; i++) {
                    value[i] = input.nextInt();
                }
            } catch (Exception e) {
                System.out.println("PLEASE INSERT CORRECT INPUT VALUES");
            }
        }
    }

    private void size_input() {
        arr_size();
        switch_opt();
    }

    public void switch_opt() {
        do {
            System.out.println("Enter one option");
            System.out.println("A:Traversal");
            System.out.println("B:Insertion");
            System.out.println("C:Deletion");
            System.out.println("D:Linear Search");
            System.out.println("E:Binary Search");
            System.out.println("F:Bubble Sorting");
            System.out.println("G: Merging of array");
            System.out.println("H:Exit");
            char ask = input.next().charAt(0);
            switch (ask) {
                case 'A':
                case 'a':
                case '1':

                    traverse();
                    break;
                case 'B':
                case 'b':
                case '2':
                    insertion();
                    break;
                case 'C':
                case 'c':
                case '3':
                    deletion();
                    break;
                case 'D':
                case 'd':
                case '4':
                    linear_search();
                    break;
                case 'E':
                case 'e':
                case '5':
                    binary_search();
                    break;
                case 'F':
                case 'f':
                case '6':
                    bubbleSorting();
                    break;
                case 'G':
                case 'g':
                case '7':
                    Merging();
                    break;
                case 'H':
                case 'h':
                case '8':
                    exit(0);
                    break;
                default:
                    System.out.println(ask + " is not in option");
                    System.out.println("PLEASE ENTER CORRECT OPTION");

                    switch_opt();
                    break;
            }
            System.out.println("DO you want to continue");
            response = input.next().charAt(0);
        } while (response != 'n');
    }
}
