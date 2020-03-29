package binarysearch_2;

import java.util.Random;
import java.util.Scanner;

public class BinarySearch_2 {

    private static int size;
    private static int array[] = new int[50];
    private static int searchValue;

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter size of array: ");

        int count = 1;
        while (count != 0) {
            count = 0;
            try {
                size = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Enter a number please!");
                System.out.println("Enter size of array: ");
                count++;
            }
            if (count != 0) {
                scanner.nextLine();
            }
            if (size <= 0 && count == 0) {
                System.out.println("Can not accept negative or zero!");
                System.out.println("Enter size of array: ");
                count++;
            }
        }
        
        BinarySearch_2 obj = new BinarySearch_2();
        obj.Random();
              
        System.out.println("Enter search value: ");
        searchValue = scanner.nextInt();
        obj.sort(array, 0, size - 1);
        System.out.println("Sorted array:   ");
        obj.Display();
        
        int result = obj.binarySearch(array, 0, size - 1, searchValue);
        
        if (result == -1) 
            System.out.println("Element does not exist !"); 
        else
            System.out.println("Element found at index " + result); 
        
        
    }

    void Random() {
        Random rd = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rd.nextInt(11);
        }
    }

    void Display() {
        System.out.print("[" + array[0]);
        for (int i = 1; i < size; i++) {
            System.out.print(", " + array[i]);
        }
        System.out.println("]");
    }

    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); 
        for (int j = low; j < high; j++) {
           
            if (arr[j] < pivot) {
                i++;

    
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

     
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    void sort(int arr[], int low, int high) {
        if (low < high) {
         
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
    
    
    int binarySearch(int arr[], int l, int r, int x) 
    { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
  
            if (arr[mid] == x) 
                return mid; 
 
            if (arr[mid] > x) 
                return binarySearch(arr, l, mid - 1, x); 

            return binarySearch(arr, mid + 1, r, x); 
        } 

        return -1; 
    } 
    

}


