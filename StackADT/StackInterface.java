public interface StackInterface<T> {
  /** Inserts an item to the top of
  ** this stack.
  ** @param item The item to be inserted
  */
  public void push(T item);

  /** Removes the top of the stack
  ** @return the removed item
  ** @throws EmptyStackException if the stack is empty
  **/
  public T pop();

  /** Returns the top of the stack
  ** without removing import junit.framework.TestCase;
  ** @return the top of the stack
  ** @throws EmptyStackException if the stack is EmptyQueueException
  **/
  public T peek();

  /** @return true if the stack is empty and false otherwise.
  **/
  public boolean isEmpty();

  /** remove all items from the stack 
  **/
  public void clear();


}
