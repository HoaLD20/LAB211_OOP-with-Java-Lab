
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Linear_Search {

    private static int array[] = new int[50];
    private static int size;

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter size of array: ");
        int count = 1;
        while (count != 0) {
            count = 0;
            try {
                size = scanner.nextInt();

            } catch (Exception e) {
                System.out.println("Don't input character!!!");
                System.out.print("Enter again: ");
                count++;
            }
            if (count != 0) {
                scanner.nextLine();
            }
            if (size <= 0 && count == 0) {
                System.out.println("Don't input negative number!!!");
                System.out.print("Enter again: ");
                count++;
            }
        }

        Linear_Search obj = new Linear_Search();
        obj.Random();
        System.out.print("Enter search value: ");
        int value = scanner.nextInt();
        obj.QuickSort(array, 0, size - 1);
        obj.Display();
        int result = obj.LinearSearch(array, value);
        if (result == -1) {
            System.out.print("Element is not present in array");
        } else {
            System.out.println("Element is present at index " + result);
        }

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

    int Partition(int arr[], int low, int high) {
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

    void QuickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = Partition(arr, low, high);
            QuickSort(arr, low, pi - 1);
            QuickSort(arr, pi + 1, high);
        }
    }

    int LinearSearch(int arr[], int x) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

}
