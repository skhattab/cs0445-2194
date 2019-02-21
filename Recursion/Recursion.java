public class Recursion {
   private static final int N_STUDENTS = 10;
   private void countUp(int start) {
     System.out.println(start);
     if(start < N_STUDENTS){ //recursive case
       countUp(start+1);
     }
   }

   private void countDown(int end) {
     if(end < N_STUDENTS) { //recursive case
       countDown(end + 1);
     }
     System.out.println(end);
   }

   private <T> void displayArray(T[] array, int start){
     if(start > array.length-1){ //base case
       return;
     }
     System.out.println(array[start]);
     if(start != array.length-1){ //recrusive case
       displayArray(array, start+1);
     }
   }

   private <T> void displayArrayInReverse(T[] array,
                                          int start){

     if(start > array.length-1){//base case
       return;
     }
     if(start == array.length-1){ //base case
       System.out.println(array[start]);
     } else { //recursive case
       displayArrayInReverse(array, start+1);
       System.out.println(array[start]);
     }
   }

   private <T> void displayArrayInReverse2(T[] array,
                                         int end){
     if(end < 0){
       return;
     }
     if(end == 0) { //base case
       System.out.println(array[end]);
     }  else { //recursive case
       System.out.println(array[end]);
       displayArrayInReverse2(array, end-1);
     }

  }
  private <T> void displayArray2(T[] array, int start,
                                 int end){
    if(start == end){ //base case
      System.out.println(array[start]);
      return;
    }
    if(start > end) { //base case
      return;
    } else { //recursive case
      int mid = start + (end - start)/2;
      displayArray2(array, start, mid); //first half
      displayArray2(array, mid+1, end);//second half
    }
  }
   public static void main(String[] args) {
     Recursion r = new Recursion();
     //r.countUp(1);
     //r.countDown(1);
     Integer[] array = {1, 2, 3, 5, 7};
     //r.displayArray(array, 10);
     //r.displayArrayInReverse(array, 0);
     r.displayArray2(array, 0, array.length-1);
   }
}
