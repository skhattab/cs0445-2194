import java.util.Arrays; // For easy printing of arrays in main().

public class Sorting {
    public static void main(String[] args) {
        int[] test1 = new int[]{3, 0, -2, 7, 10, 2, 22, 5, 7, 4};
        String[] test2 = new String[]{"Hello", "CS445", "Spring Break", "Amazing"};

        System.out.println("Test1 before selection sort\n" + Arrays.toString(test1));
        selectionSort(test1);
        System.out.println("Test1 after selection sort\n" + Arrays.toString(test1));

        System.out.println();

        System.out.println("Test2 before insertion sort\n" + Arrays.toString(test2));
        insertionSort(test2);
        System.out.println("Test2 after insertion sort\n" + Arrays.toString(test2));

    }

    public static void selectionSort(int[] a) {
        for(int i = 0; i < a.length - 1; i++) {
            int nextIndex = getNextIndex(a, i); 
            swap(a, i, nextIndex);
        }
    }

    private static int getNextIndex(int[] a, int first) {
        int min = a[first];
        int index = first;
        for(int i = first; i < a.length; i++) {
            // Change to if(a[i] > min) to sort in descending order.
            if(a[i] < min) {
                min = a[i];
                index = i;
            }
        }
        return index;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static <T extends Comparable<? super T>> 
    void insertionSort(T[] a) {
        for(int i = 1; i < a.length; i++) {
            T key = a[i];
            int j = i-1;

            // Shift items to the right to make room
            // for the key.
            // Change to a[j].compareTo(key) < 0 to sort descending.
            while(j >= 0 && a[j].compareTo(key) > 0) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
    }

    
}