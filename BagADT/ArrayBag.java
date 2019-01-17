/** A class for an array-based implementation of the Bag ADT
* @@author Sherif Khattab
* @@version 0.1
*/

import java.util.Arrays;

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
			throw new IllegalStateException("An ArrayBag is created with a capacity "
			                                 + "that exceeds the maximum capacity.");
		} else {
			@SuppressWarnings("unchecked")
			T[] temp = (T[]) new Object[capacity];
			bag = temp;
			numberOfItems = 0;
		}
	}

	@Override
	public boolean isEmpty() {
		return numberOfItems == 0;
	}

	@Override
	public int getCurrentSize() {
		return numberOfItems;
	}

	@Override
	public boolean add(T item) {
		boolean result = false;
		if(numberOfItems != bag.length){
			bag[numberOfItems] = item;
			numberOfItems++;
			result = true;
		}
		return result;
	}

	@Override
	public T remove() {
		T result = null;
		if(!isEmpty()){
			result = bag[numberOfItems - 1];
			bag[numberOfItems-1] = null;
			numberOfItems--;
		}
		return result;
	}

	@Override
	public boolean contains(T item) {
  /* The commented code is more efficient! */
	/*	boolean result = false;
		for(int i=0; i<numberOfItems; i++) {
			if(bag[i].equals(item)) {
				result = true;
				break;
			}
		}
		return result;
		*/
		return getFrequencyOf(item) > 0;

	}

	@Override
	public boolean remove(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getFrequencyOf(T item) {
		int result = 0;
		for(int i=0; i<numberOfItems; i++){
			if(bag[i].equals(item)){
				result++;
			}
		}
		return result;
	}

	@Override
	public T[] toArray() {
		//return bag;  WRONG!!
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfItems];
		for(int i=0; i< numberOfItems; i++){
			result[i] = bag[i];
		}
		return result;
		//return Arrays.copyOf(bag, numberOfItems);
	}

	@Override
	public void clear() {
		//bag = null;
		//numberOfItems = 0;

		//for(int i=0; i< numberOfItems; i++) {
		//   bag[i] = null;
		//numberOfItems = 0;

		while(!isEmpty()){
			remove();
		}

	}

	}

}
