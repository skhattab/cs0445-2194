import java.util.EmptyStackException;

public final class LinkedStack<T> implements StackInterface<T> {
  private Node topNode;

  //Group 11
  /**LinkedStack
  * This is the default constructor for the Linked Stack class
  */
  public LinkedStack() {
    // node is null since there's no data or object associated with it yet
    topNode = null;
    }


  /** Inserts an item to the top of
  ** this stack.
  ** @param item The item to be inserted
  */
  //Group 12
  public void push(T item){
    // New node contains T item, while the next node will equal null since it's not there
    topNode = new Node(item, topNode);
  }

  /** Removes the top of the stack
  ** @return the removed item
  ** @throws EmptyStackException if the stack is empty
  **/
  //Group 13
  public T pop(){
    //remove the top item on the Stack and return it
    //if(topNode = null)
    T data = peek();
    topNode = topNode.next;
    return data;
  }

  /** Returns the top of the stack
  ** without removing it
  ** @return the top of the stack
  ** @throws EmptyStackException if the stack is empty
  **/
  //Group 14
  public T peek(){
    //if(topNode = null)
    if(isEmpty())
      throw new EmptyStackException();
    return topNode.data;
  }

  /** @return true if the stack is empty and false otherwise.
  **/

  //Group 15
  public boolean isEmpty() {
    return topNode==null;
  }

  /** remove all items from the stack
  **/
  //Group 16
  public void clear(){
    while(!isEmpty()){
        pop();
    }
  }

  public String toString(){
    StringBuilder result = new StringBuilder();
    Node currentNode = topNode;
    while(currentNode != null){
      result.append(currentNode.data);
      currentNode = currentNode.next;
    }
    return result.toString();
  }


  private class Node {
    T data;
    Node next;

    //Group 17
    /**Initializes a Node with data without defining what the next Node will be
    *@param data the Object T to be defined in the node
    */
    private Node(T data) {
      this(data, null);
    }

    //Group 18
    /**Initializes a Node with data and ALSO defines what the next Node will be
    *@param data the Object T to be defined in the node
    *@param next the next Node in the LinkedStack
    */
    private Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
}
