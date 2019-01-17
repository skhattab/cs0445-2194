/** A class for an array-based implementation of the Bag ADT
* @@author Sherif Khattab
* @@version 0.1
*/

public class ArrayBag<T> implements BagInterface<T> {

	private final T[] bag;
	private int numberOfItems;

	private static final int MAX_CAPACITY = 100;
	private static final int DEFAULT_CAPACITY = 20;

	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayBag(int capacity) {
		if(capacity > MAX_CAPACITY) {
			throw new IllegalStateException("An ArrayBag is created with a capacity that exceeds"
					+ " the maximum capacity.");
		} else {
			@SuppressWarnings("unchecked")
			T[] temp = (T[]) new Object[capacity];
			bag = temp;
			numberOfItems = 0;
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean add(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getFrequencyOf(T item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}
