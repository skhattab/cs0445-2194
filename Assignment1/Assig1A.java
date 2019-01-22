
/** Driver program for the first part of Assignment 1
 * @author Sherif Khattab (Adapted  from Dr. John Ramirez's Spring 2017 CS 0445 Assignment 1 code)
 * 
 * This program must work as is with your ArrayDS<T> class.  Look carefully at all of the method calls so that
 *  you create your ArrayDS<T> methods correctly.  For example, note the constructor calls and the toString() method call. 
 *  The output should be identical to my sample output. This will be verified by running the diff program (fc on Windows) between
 *  the provided A1Out.txt and the output of running this driver using your ArrayDS implementation. The diff program shouldn't 
 *  give any output.
 */
public class Assig1A
{
	private static final int SIZE = 5;
	private static final int SEED = 100;

	public static void main(String [] args)
	{
		// Testing constructors and PrimQ<T> interface
		
		ArrayDS<Integer> q1 = new ArrayDS<>(SIZE);

		// Testing addItem
		for (int i = 0; i < SIZE; i++)
		{
			Integer newItem = 2 * i;
			if (!(q1.isFull()))
			{
				q1.addItem(newItem);
				System.out.println(newItem + " added to Q");
			}			
		}
		
		ArrayDS<Integer> q2 = new ArrayDS<>(q1);
		System.out.println(q2);

		PrimQ<Integer> theQ = new ArrayDS<>(SIZE);

		// Testing addItem
		for (int i = 0; i < SIZE; i++)
		{
			Integer newItem = 2 * i;
			if (!(theQ.isFull()))
			{
				theQ.addItem(newItem);
				System.out.println(newItem + " added to Q");
			}			
		}
		
		Integer newItem = 2 * (SIZE);
		try {
			theQ.addItem(newItem);
		} catch (OutOfRoomException e) {
				System.out.println("No room for " + newItem);
		}
		


		// Testing removeItem
		while (!(theQ.isEmpty()))
		{
			Integer oldItem = theQ.removeItem();
			System.out.println(oldItem + " retrieved from Q");
		}
		try {
			Integer noItem = theQ.removeItem();
		} catch (EmptyQueueException e) {
			System.out.println("Nothing in the Q");
		}

		// Testing array management
		int count = 1;
		PrimQ<String> theQ2 = new ArrayDS<>(SIZE);
		String theItem = new String("Item " + count);
		System.out.println("Adding " + theItem);
		theQ2.addItem(theItem);
		for (int i = 0; i < 8; i++)
		{
			count++;
			theItem = new String("Item " + count);
			System.out.println("Adding " + theItem);
			theQ2.addItem(theItem);
			theItem = theQ2.removeItem();
			System.out.println("Removing " + theItem);
		}
		int sz = theQ2.size();
		System.out.println(sz + " item(s) in the queue.");

		// This code will test the toString() method and the Reorder
		// interface.
		System.out.println("\nAbout to test Reorder methods");
		ArrayDS<Integer> newDS = new ArrayDS<>(3*SIZE);
		for (int i = 0; i < 8; i++)
		{
			newDS.addItem(i);
		}
		System.out.println(newDS.toString());
		System.out.println("Reversing");
		newDS.reverse();
		System.out.println(newDS.toString());
		System.out.println("Removing 3 items then adding 1");
		newDS.removeItem();
		newDS.removeItem();
		newDS.removeItem();
		newDS.addItem(8);
		System.out.println(newDS.toString());
		System.out.println("Reversing");
		newDS.reverse();
		System.out.println(newDS.toString());
		System.out.println("Shifting right");
		newDS.shiftRight();
		System.out.println(newDS.toString());
		System.out.println("Shifting left twice");
		newDS.shiftLeft();
		newDS.shiftLeft();
		System.out.println(newDS.toString());
		
		System.out.println("leftRotate(9)");
		newDS.leftRotate(9);
		System.out.println(newDS);
		
		System.out.println("leftRotate(10)");
		newDS.leftRotate(10);
		System.out.println(newDS);
		
		System.out.println("leftRotate(11)");
		newDS.leftRotate(11);
		System.out.println(newDS);
		
		System.out.println("rightRotate(22)");
		newDS.rightRotate(22);
		System.out.println(newDS);
		
		System.out.println("rightRotate(-3)");
		newDS.rightRotate(-3);
		System.out.println(newDS);
		
		System.out.println("leftRotate(-4)");
		newDS.leftRotate(-4);
		System.out.println(newDS);
		
		System.out.println("\nAbout to test shuffle...");
		newDS.clear();
		for (int i = 0; i < 2*SIZE; i++)
		{
			newDS.addItem(i);
		}
		System.out.println(newDS.toString());
		System.out.println("Shuffling...");
		newDS.shuffle(SEED);
		System.out.println(newDS.toString());
		System.out.println("Removing 2 and adding 1");
		newDS.removeItem();
		newDS.removeItem();
		newDS.addItem(22);
		System.out.println(newDS.toString());
		System.out.println("Shuffling again");
		newDS.shuffle(SEED+10);
		System.out.println(newDS.toString());
	}
}