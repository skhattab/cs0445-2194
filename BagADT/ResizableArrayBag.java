import java.util.Arrays;

public final class ResizableArrayBag<T> implements BagInterface<T> {
  private T[] bag;
	private int numberOfItems;

	private boolean initialized = false;

	private static final int MAX_CAPACITY = 4096;
	private static final int DEFAULT_CAPACITY = 32;

	public ResizableArrayBag() {
		this(DEFAULT_CAPACITY);
	}

	public ResizableArrayBag(int capacity) {
		if(capacity > MAX_CAPACITY) {
			throw new IllegalStateException("An ArrayBag is created with a capacity "
			                                 + "that exceeds the maximum capacity.");
		} else {
			@SuppressWarnings("unchecked")
			T[] temp = (T[]) new Object[capacity];
			bag = temp;
			numberOfItems = 0;
			initialized = true;
		}
	}

	@Override
	public boolean isEmpty() {
		checkInitialization();

		return numberOfItems == 0;
	}

	@Override
	public int getCurrentSize() {
		checkInitialization();

		return numberOfItems;
	}

	@Override
	public boolean add(T item) {
		checkInitialization();

		boolean result = false;

		bag[numberOfItems] = item;
		numberOfItems++;

    if(numberOfItems == bag.length){
      doubleSize();
    }

		result = true;
		return result;
	}

	@Override
	public T remove() {
		checkInitialization();

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
		checkInitialization();

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
		checkInitialization();

		boolean result = false;

		int index = getIndexOf(item);
		if(index >= 0){
			bag[index] = bag[numberOfItems - 1];
			bag[numberOfItems - 1] = null;
			numberOfItems--;
			result = true;
		}
		return result;
	}

	@Override
	public int getFrequencyOf(T item) {
		checkInitialization();

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

		checkInitialization();

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
		//WRONG
		//bag = null;
		//numberOfItems = 0;

		//OK
		//for(int i=0; i< numberOfItems; i++) {
		//   bag[i] = null;
		//numberOfItems = 0;

		checkInitialization();

		while(!isEmpty()){
			remove();
		}

	}
	/** Returns the index of item inside bag
	* @param item The item that we search for
	* @return the integer index of item inside bag; -1 otherwise
	*/
	private int getIndexOf(T item) {
		int result = -1;

		for(int i=0; i<numberOfItems; i++){
			if(item.equals(bag[i])){
				result = i;
				break;
			}
		}
		return result;
	}

	private void checkInitialization() {
		if(!initialized){
			throw new SecurityException("An attempt to call a method on an" +
																		"uninitialized object of class ArrayBag.");
		}
	}
  private void doubleSize() {
    int newSize = bag.length*2;
    if(newSize > MAX_CAPACITY){
      throw new IllegalStateException("Maximum size = "
                                       + MAX_CAPACITY +
                                      " of array exceeded.");
    }

    bag = Arrays.copyOf(bag, newSize);

  }


}
