/** A program to test the ArrayBag class
* @author Sherif Khattab
* @version 0.1
*
*/
import java.util.Arrays;

public class BagTest {
   public static void main(String[] args) {
     BagInterface<String> stringBag = new LinkedBag<>();
     stringBag.add("String");
     stringBag.add("String");
     System.out.println("Bag size is " + stringBag.getCurrentSize());
     Object[] strings = stringBag.toArray();
     System.out.println(Arrays.toString(strings));
     System.out.println(stringBag.isEmpty());
     System.out.println("String in bag? " + stringBag.contains("String"));
     System.out.println("String appears " +
                   stringBag.getFrequencyOf("String") + " times in the bag.");
     // stringBag.remove();
     // System.out.println("String appears " +
     //              stringBag.getFrequencyOf("String") + " times in the bag.");


   }

}
