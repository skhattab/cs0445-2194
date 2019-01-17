/** An interface for a bag of items
 * @author Sherif Khattab
 *
 * @param <T> The type of items in the bag
 */
public interface BagInterface<T> {

	/** Checks if the bag is empty
	 * @return true if the bag is empty; false otherwise.
	 */
	public boolean isEmpty();

	/** Returns the number of items in the bag
	 * @return the integer number of items in the bag
	 */
	public int getCurrentSize();

	/** Adds an item to the bag if possible
	 * @param item The new item to be added
	 * @return true if adding succeeds or false if the bag is full
	 */
	public boolean add(T item);

	/** Removes an unspecified item from the bag if possible
	 * @return the item that is removed or null if the bag is empty
	 */
	public T remove();

	/** Searches for an item inside the bag
	 * @param item The item that we are searching for
	 * @return true if the item exists in the bag and false otherwise
	 */
	public boolean contains(T item);

	/** Removes one copy of item from the bag
	 * @param item The item to be removed
	 * @return true if the removal is successful; false if item doesn't exist in the bag
	 */
	public boolean remove(T item);

	/** Returns the number of copies of item that exist in the bag
	 * @param item The item that we search for
	 * @return the integer number of copies of item in the bag
	 */
	public int getFrequencyOf(T item);

	/** Returns an array that contains all the items in the bag
	 * @return a T[] of the items in the bag
	 */
	public T[] toArray();

	/** Removes all items from the bag
	 *
	 */
	public void clear();


}
