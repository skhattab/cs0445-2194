import java.util.Arrays; // For easy printing of arrays in main().

public class Sorting {
    private static final int THRESHOLD = 20;
    public static void main(String[] args) {
        Integer[] test1 = new Integer[]{3, 0, -2, 7, 10, 2, 22, 5, 7, 4};
        String[] test2 = new String[]{"Hello", "CS445", "Spring Break", "Amazing"};

        // System.out.println("Test1 before selection sort\n" + Arrays.toString(test1));
        // selectionSort(test1);
        // System.out.println("Test1 after selection sort\n" + Arrays.toString(test1));
        //
        // System.out.println();
        //
        // System.out.println("Test2 before insertion sort\n" + Arrays.toString(test2));
        // insertionSort(test2);
        // System.out.println("Test2 after insertion sort\n" + Arrays.toString(test2));

        // System.out.println("Test2 before merge sort\n" + Arrays.toString(test1));
        // mergeSort(test1, test1.length);
        // System.out.println("Test2 after merge sort\n" + Arrays.toString(test1));

        System.out.println("Test2 before quick sort\n" + Arrays.toString(test1));
        quicksort(test1, 0, test1.length-1);
        System.out.println("Test2 after quick sort\n" + Arrays.toString(test1));

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

    private static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
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

    public static <T extends Comparable<? super T>>
    void incrementalInsertionSort(T[] a, int start, int space) {
        for(int i = start+space; i < a.length; i += space) {
            T key = a[i];
            int j = i-space;

            // Shift items to the right to make room
            // for the key.
            // Change to a[j].compareTo(key) < 0 to sort descending.
            while(j >= start && a[j].compareTo(key) > 0) {
                a[j+space] = a[j];
                j -= space;
            }
            a[j+space] = key;
        }
    }

    public static <T extends Comparable<? super T>>
           void ShellSort(T[] a, int n){
             for(int space = n/2; space >= 1; space/=2){
               for(int i=0; i<space; i++){
                 incrementalInsertionSort(a, i, space);
               }//have you seen about time?
             }
    }

    public static <T extends Comparable<? super T>>
      void mergeSort(T[] a, T[] temp, int first, int last){
        if(first < last){
          int mid = first + (last - first)/2;
          mergeSort(a, temp, first, mid);
          mergeSort(a, temp, mid+1, last);
          if(a[mid].compareTo(a[mid+1])> 0){
            merge(a, temp, first, mid, last);
          }
        }
      }
    private static <T extends Comparable<? super T>>
       void merge(T[] a, T[] temp, int first, int mid, int last){
         int i = first;
         int j = mid + 1;
         int k = 0;
         while((k < last - first + 1)
               &&(i <= mid)
               &&(j <= last)) {
           if(a[i].compareTo(a[j]) <= 0) { //i <= j
             temp[k] = a[i];
             i++;
           } else {
             temp[k] = a[j];
             j++;
           }

           k++;
         }

         for(; i <= mid; i++){
           temp[k] = a[i];
           k++;
         }
         for(; j <= last; j++){
           temp[k] = a[j];
           k++;
         }

         for(int l=0; l<last - first + 1; l++){
           a[first + l] = temp[l];
         }

       }

       public static <T extends Comparable<? super T>>
       void mergeSort(T[] a, int size){
         @SuppressWarnings("unchecked")
         T[] temp = (T[]) new Comparable<?>[size];
         mergeSort(a, temp, 0, size-1);
       }

       public static <T extends Comparable<? super T>>
       void quicksort(T[] a, int first, int last){
         int size = last - first + 1;
         if(size < THRESHOLD){
           insertionSort(a);
         } else {
           int pivotIndex = partition(a, first, last);
           quicksort(a, first, pivotIndex-1);
           quicksort(a, pivotIndex+1, last);
         }
       }

       private static <T extends Comparable<? super T>>
       int partition(T[] a, int first, int last){
         int mid = first + (last - first)/2;
         sorttFirstMidLast(a, first, last);
         T pivot = a[mid];
         swap(a, mid, last - 1);
         boolean done = false;
         int indexFromLeft = first + 1;
         int indexFromRight = last - 2;

         while(!done){
           while(a[indexFromLeft].compareTo(pivot)<0){
             indexFromLeft++;
           }

           while(a[indexFromRight].compareTo(pivot) >=0){
             indexFromRight--;
           }

           if(indexFromRight < indexFromLeft){
             done = true;
           } else {
             swap(a, indexFromLeft, indexFromRight);
             indexFromRight--;
             indexFromLeft++;
           }
         }
         swap(a, last-1, indexFromLeft);
         return indexFromLeft;
       }

       private static <T extends Comparable<? super T>>
       void sorttFirstMidLast(T[] a, int first, int last){
         int mid = first + (last - first)/2;
         if(a[mid].compareTo(a[first]) < 0)
          swap(a, first, mid);
        if(a[last].compareTo(a[mid]) < 0){
          swap(a, mid, last);
        }
        if(a[mid].compareTo(a[first]) < 0)
         swap(a, first, mid);
       }

}
