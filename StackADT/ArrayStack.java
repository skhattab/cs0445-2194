public final class ArrayStack<T> implements StackInterface<T> {
  private T[] stack;
  private int topIndex;
  private boolean initialized;
  private final int DEFAULT_CAPACITY = 32;
  private final int MAX_CAPACITY = 4096;

  public ArrayStack() {

  }

  public ArrayStack(int initialCapacity) {

  }

  /** Inserts an item to the top of
  ** this stack.
  ** @param item The item to be inserted
  */
  public void push(T item) {

  }

  /** Removes the top of the stack
  ** @return the removed item
  ** @throws EmptyStackException if the stack is empty
  **/
  public T pop(){
    return null;
  }

  /** Returns the top of the stack
  ** without removing import junit.framework.TestCase;
  ** @return the top of the stack
  ** @throws EmptyStackException if the stack is EmptyQueueException
  **/
  public T peek() {
    return null;
  }

  /** @return true if the stack is empty and false otherwise.
  **/
  public boolean isEmpty() {
    return false;
  }

  /** remove all items from the stack
  **/
  public void clear() {

  }

  private void checkInitialization() {

  }

  private void checkCapacity(int capacity) {

  }

  private void ensureCapacity() {
    
  }

}
