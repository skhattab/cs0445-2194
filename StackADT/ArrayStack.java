import java.util.EmptyStackException;

public final class ArrayStack<T> implements StackInterface<T> {
  private T[] stack;
  private int topIndex;
  private boolean initialized = false; //Changed to make checkInitialization work
  private static final int DEFAULT_CAPACITY = 32;
  private static final int MAX_CAPACITY = 4096;

//Group 1
  public ArrayStack() {
    this(DEFAULT_CAPACITY);
  }
  //Group 2
  public ArrayStack(int initialCapacity) {
      @SuppressWarnings("unchecked")
      T[] temp = (T[]) new Object[initialCapacity];
      stack = temp;
      topIndex = -1;
      initialized = true;
  }

  /** Inserts an item to the top of
  ** this stack.
  ** @param item The item to be inserted
  */
  //Group 3
  public void push(T item) {
      checkInitialization();
      stack[topIndex + 1] = item;
      topIndex++;
      ensureCapacity();
  }

  /** Removes the top of the stack
  ** @return the removed item
  ** @throws EmptyStackException if the stack is empty
  **/
  //Group 4
  public T pop(){
    checkInitialization();
    T data = peek();
    stack[topIndex] = null;
    topIndex--;
    return data;
  }

  /** Returns the top of the stack
  ** without removing it
  ** @return the top of the stack
  ** @throws EmptyStackException if the stack is empty
  **/
  //Group 5
  public T peek() {
    checkInitialization();
    if(topIndex == -1)
    {
      throw new EmptyStackException();
    } else
    {
      return stack[topIndex];
    }
  }

  /** @return true if the stack is empty and false otherwise.
  **/
  //Group 6
  public boolean isEmpty() {
    checkInitialization();
    return topIndex == -1;
  }

  /** remove all items from the stack
  **/
  //Group 7
  public void clear() {
    checkInitialization();

    /*while(!isEmpty()){
      pop();
    }
    */

    for(int i = 0; i <= topIndex; i++) {
      stack[i] = null;
    }
    topIndex = -1;
  }

  //Group 8
  private void checkInitialization() {
    if(initialized == false){
      throw new IllegalStateException("ArrayStack not initialized");
    }
  }

  //Group 9
  /** Make sure that capacity is <= MAX_CAPACITY
  ** If capacity > MAX_CAPACITY throw an IllegalStateException
  **/
  private void checkCapacity(int capacity) {
    if(capacity > MAX_CAPACITY)
      throw new IllegalStateException("Capacity exceeds maximum capacity");
  }

  //Group 10
  /** Double the capacity of the array if possible
  *
  */

  private void ensureCapacity() {
    if (topIndex+1 == stack.length){ //ONLY double size of stack if stack is full
      int newCapacity = 2 * stack.length;
      checkCapacity(newCapacity);
      //if(stack.length*2 < MAX_CAPACITY){
      @SuppressWarnings("unchecked")
      T[] arrNew = (T[]) new Object[newCapacity];
      for(int i=0; i<stack.length; i++) {
        arrNew[i]=stack[i];
      }
      stack = arrNew;
        //stack = Arrays.copyOf(stack, newCapacity);
      }
    }


  }
