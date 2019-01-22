/**  PrimQ<T> interface for CS 0445 Assignment 1 Summer 2018 
 * @author Sherif Khattab (Adapted from Dr. John Ramirez's CS 0445 Spring 2017 Assignment 1)
 *
 * @param <T> The data type of the items stored in the queue.
 * 
 * Carefully read the specifications for each of the operations and
 * implement them correctly in your ArrayDS class.
 *  
 * The overall logic of the PrimQ<T> is the following:
 * Data is logically "added" in the same order that it is "removed". The logically first
 * item is the oldest item and the logically last item is the newest (most recently added).
 * However, there is no requirement for the physical storage of the actual
 * data.  Your only requirement for the ArrayDS<T> class is that all of the
 * methods work as specified and that your ArrayDS<T> class have an array as 
 * its primary data.  
 *    
 * You MAY NOT use ArrayList, Vector or any predefined collection class for your ArrayDS<T> data.  
 * However, you may want to use some additional instance variables to keep track of the data effectively.
 *     
 * Note: Later in the term we will discuss how to implement a queue in an efficient way.
 */

public interface PrimQ<T>
{
	/** Add a new Object to the PrimQ<T> in the next available location. 
	 * @param item the item to be added.
	 * 	@throws OutOfRoomException if there is no room in the PrimQ for the new item  (you should NOT resize it)
	 */
	public void addItem(T item) throws OutOfRoomException;
	
	/** Remove and return the "oldest" item in the PrimQ.
	 * @return the "oldest" item in the PrimQ<T> object
	 * @throws EmptyQueueException if the queue is empty
	 */
	public T removeItem() throws EmptyQueueException;
	
	/**  
	 * @return the "oldest" item in the PrimQ.
	 * @throws EmptyQueueException if the queue is empty
	 */
	public T head() throws EmptyQueueException;
		
	/**
	 * @return true if the PrimQ is full, and false otherwise
	 */
	public boolean isFull();
	
	/**
	 * @return true if the PrimQ is empty, and false otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * @return the number of items currently in the PrimQ
	 */
	public int size();

	/** Reset the PrimQ to empty status by reinitializing the variables 
	 * appropriately
	 */
	public void clear();
}
