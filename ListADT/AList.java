import java.util.Arrays;
/**
A class that implements the ADT list by using a resizable array.
Entries in a list have positions that begin with 1.
Duplicate entries are allowed.
*/
public class AList<T> implements ListInterface<T>
{
	private T[] list;   // Array of list entries; ignore list[0]
	private int numberOfEntries;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	public AList()
	{
		this(DEFAULT_CAPACITY);
	} // end default constructor

	public AList(int initialCapacity)
	{
		// Is initialCapacity too small?
		if (initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;
		else // Is initialCapacity too big?
			checkCapacity(initialCapacity);

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempList = (T[])new Object[initialCapacity + 1];
		list = tempList;
		numberOfEntries = 0;
		initialized = true;
	} // end constructor

	public void add(T newEntry)
	{
		// checkInitialization();
		// list[numberOfEntries + 1] = newEntry;
		// numberOfEntries++;
		// ensureCapacity();
		add(numberOfEntries + 1, newEntry);
	} // end add

	// Precondition: The array list has room for another entry.
	public void add(int newPosition, T newEntry)
	{
		checkInitialization();
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
			if(newPosition == numberOfEntries + 1 ){
				list[numberOfEntries+1] = newEntry;
			} else {
				makeRoom(newPosition);
				list[newPosition] = newEntry;
			}
			numberOfEntries++;
			ensureCapacity();
		}
		else
			throw new IndexOutOfBoundsException(
											"Given position of add's new entry is out of bounds.");
	} // end add

	public T remove(int givenPosition)
	{
		checkInitialization();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			T result = list[givenPosition];
			if(givenPosition == numberOfEntries){
				list[givenPosition] = null;
			} else {
				removeGap(givenPosition);
				list[numberOfEntries] = null;
			}
			numberOfEntries--;
			return result;
		}
		else
			throw new IndexOutOfBoundsException(
						"Illegal position given to remove operation.");
	} // end remove

	public void clear()
	{
		checkInitialization();

		// Clear entries but retain array; no need to create a new array
		for(int i=1; i<= numberOfEntries; i++){
			list[i] = null;
		}
		numberOfEntries = 0;
	} // end clear

	public T replace(int givenPosition, T newEntry)
	{
		checkInitialization();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			T original = list[givenPosition];
			list[givenPosition] = newEntry;
			return original;
		}
		else
		throw new IndexOutOfBoundsException(
		"Illegal position given to replace operation.");
	} // end replace

	public T getEntry(int givenPosition)
	{
		checkInitialization();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			return list[givenPosition];
		}
		else
		throw new IndexOutOfBoundsException(
		"Illegal position given to getEntry operation.");
	} // end getEntry

	public T[] toArray()
	{
		checkInitialization();

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
		for (int index = 0; index < numberOfEntries; index++)
		{
			result[index] = list[index+1];
		} // end for

		return result;
	} // end toArray

	public boolean contains(T anEntry)
	{
		checkInitialization();
		boolean found = false;
		int index = 1;
		while (!found && (index <= numberOfEntries))
		{
			if (anEntry.equals(list[index]))
			found = true;
			index++;
		} // end while

		return found;
	} // end contains

	public int getLength()
	{
		return numberOfEntries;
	} // end getLength

	public boolean isEmpty()
	{
		return numberOfEntries == 0;
	} // end isEmpty

	// Doubles the capacity of the array list if it is full.
	// Precondition: checkInitialization has been called.
	private void ensureCapacity()
	{
		if(numberOfEntries+1 == list.length){
			int newLength = 2*(numberOfEntries) + 1;
			checkCapacity(newLength);
			list = Arrays.copyOf(list, newLength);
		}
	} // end ensureCapacity

	// Makes room for a new entry at newPosition.
	// Precondition: 1 <= newPosition <= numberOfEntries + 1;
	//               numberOfEntries is list's length before addition;
	//               checkInitialization has been called.
	private void makeRoom(int newPosition)
	{

		// Move each entry to next higher index, starting at end of
		// list and continuing until the entry at newIndex is moved
		for(int index = numberOfEntries; index >= newPosition; index--) {
			list[index + 1] = list[index];
		}

	}  // end makeRoom

	// Shifts entries that are beyond the entry to be removed to the
	// next lower position.
	// Precondition: 1 <= givenPosition < numberOfEntries;
	//               numberOfEntries is list's length before removal;
	//               checkInitialization has been called.
	private void removeGap(int givenPosition)
	{
		for(int index = givenPosition + 1; index <= numberOfEntries;
		index++){
			list[index-1] = list[index];
		}

	} // end removeGap

	// Throws an exception if this object is not initialized.
	private void checkInitialization()
	{
		if (!initialized)
		throw new SecurityException ("AList object is not initialized properly.");
	} // end checkInitialization

	// Throws an exception if the client requests a capacity that is too large.
	private void checkCapacity(int capacity)
	{
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException("Attempt to create a list " +
					"whose capacity exceeds " + "allowed maximum.");
	} // end checkCapacity
} // end AList
