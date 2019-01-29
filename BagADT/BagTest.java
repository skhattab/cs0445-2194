/** A program to test the ArrayBag class
* @author Sherif Khattab
* @version 0.1
*
*/
import java.util.Arrays;

public class BagTest {
   public static void main(String[] args) {
     BagInterface<String> stringBag = new LinkedBag<>();
     stringBag.add("String1");
     stringBag.add("String2");
     System.out.println("Bag size is " + stringBag.getCurrentSize());
     Object[] strings = stringBag.toArray();
     System.out.println(Arrays.toString(strings));
     System.out.println(stringBag.isEmpty());
     System.out.println("String in bag? " + stringBag.contains("String"));
     System.out.println("String appears " +
                   stringBag.getFrequencyOf("String") + " times in the bag.");
     stringBag.remove();
     System.out.println("String1 appears " +
                   stringBag.getFrequencyOf("String1") +
                   " times in the bag.\n" +
                   "String2 appears " +
                   stringBag.getFrequencyOf("String2") +
                   " times in the bag.");
    stringBag.remove("String1");
    System.out.println("String1 appears " +
                  stringBag.getFrequencyOf("String1") +
                  " times in the bag.\n" +
                  "String2 appears " +
                  stringBag.getFrequencyOf("String2") +
                  " times in the bag.");


   }

}
