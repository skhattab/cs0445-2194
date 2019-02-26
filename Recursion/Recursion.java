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
                                 int end, int tabs){
    /*for(int i=0; i<tabs; i++){
      System.out.print("\t");
    }
    System.out.println(start + " " + end);
    */
    if(start == end){ //base case
      System.out.println(array[start]);
      return;
    }
    if(start > end) { //base case
      return;
    } else { //recursive case
      int mid = start + (end - start)/2;
      displayArray2(array, start, mid, tabs+1); //first half
      displayArray2(array, mid+1, end, tabs+1);//second half
    }
  }

  public int sum(int n) {
    if(n == 0) { //base case
      return 0;
    } else { //recursive case
      return sum(n-1) + n;
    }
  }

  public int factorial(int n) {
    if(n==1){
      return 1;
    } else {
      return n * factorial(n-1);
    }
  }
  public int fib(int n){
    if(n == 0){
      return 0;
    }
    else if(n == 1){
      return 1;
    }
    else{
      return fib(n-1) + fib(n-2);
    }
  }

  public void towersOfHanoi(int n, int start,
                            int end, int temp) {

    if(n == 1) { //base case
      System.out.println("Move a disk from " +
                          start + " to " + end);
    } else { //recursive case
      towersOfHanoi(n-1, start, temp, end);
      System.out.println("Move a disk from " +
                          start + " to " + end);
      towersOfHanoi(n-1, temp, end, start);
    }
  }

  public int power(int x, int y) {
    if(y == 0){
      return 1;
    } else if(y == 1) {
      return x;
    } else {
      int temp = power(x, y/2);
      temp = temp * temp;
      if(y % 2 == 1) { //y is odd
        temp = temp * x;
      }
      return temp;
    }
  }
   public static void main(String[] args) {
     Recursion r = new Recursion();
     //r.countUp(1);
     //r.countDown(1);
     Integer[] array = {1, 2, 3, 5, 7};
     //r.displayArray(array, 10);
     //r.displayArrayInReverse(array, 0);
     //r.displayArray2(array, 0, array.length-1, 0);
     System.out.println(r.sum(5));
     System.out.println(r.factorial(5));
     System.out.println(r.fib(5));
     System.out.println(r.power(2, 10));


     //r.towersOfHanoi(40, 0, 2, 1);
   }
}
