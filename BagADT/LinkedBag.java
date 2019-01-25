public final class LinkedBag<T> implements BagInterface<T>{
  Node firstNode;
  int numberOfItems;

  public LinkedBag(){
    firstNode = null;
    numberOfItems = 0;
  }
  /** Checks if the bag is empty
   * @return true if the bag is empty; false otherwise.
   */
  public boolean isEmpty() {
    return numberOfItems == 0;
  }

  /** Returns the number of items in the bag
   * @return the integer number of items in the bag
   */
  public int getCurrentSize(){
    return numberOfItems;
  }

  /** Adds an item to the bag if possible
   * @param item The new item to be added
   * @return true if adding succeeds or false if the bag is full
   */
  public boolean add(T item){
    // Step 1
    Node newNode = new Node(item);
    //Step 2
    newNode.next = firstNode;
    //Step 3
    firstNode = newNode;
    numberOfItems++;
    //firstNode = new Node(item, firstNode);
    return true;
  }

  /** Removes an unspecified item from the bag if possible
   * @return the item that is removed or null if the bag is empty
   */
  public T remove(){
    return null;
  }

  /** Searches for an item inside the bag
   * @param item The item that we are searching for
   * @return true if the item exists in the bag and false otherwise
   */
  public boolean contains(T item){
    boolean result = false;
    Node currentNode = firstNode;
    while(currentNode != null){
      if(item.equals(currentNode.data)){
        result = true;
        break;
      }
      currentNode = currentNode.next;
    }
    return result;
  }

  /** Removes one copy of item from the bag
   * @param item The item to be removed
   * @return true if the removal is successful; false if item doesn't exist in the bag
   */
  public boolean remove(T item){
    return false;
  }

  /** Returns the number of copies of item that exist in the bag
   * @param item The item that we search for
   * @return the integer number of copies of item in the bag
   */
  public int getFrequencyOf(T item){
    int result = 0;
    Node currentNode = firstNode;
    while(currentNode != null){
      if(item.equals(currentNode.data)){
        result++;
      }
      currentNode = currentNode.next;
    }
    return result;
  }

  /** Returns an array that contains all the items in the bag
   * @return a T[] of the items in the bag
   */
  public T[] toArray(){
    @SuppressWarnings("unchecked")
    T[] result = (T[]) new Object[numberOfItems];

    Node currentNode = firstNode;
    int index = 0;
    while((currentNode != null)
          &&(index < numberOfItems)){
      result[index] = currentNode.data;
      index++;
      currentNode = currentNode.next;
    }

    // for(Node currentNode = firstNode, int index = 0;
    //     currentNode!= null && index < numberOfItems;
    //     currentNode = currentNode.next, index++){
    //       result[index] = currentNode.data;
    // }
    return result;
  }

  /** Removes all items from the bag
   *
   */
  public void clear(){

  }

  private class Node {
    T data;
    Node next;

    private Node(T data){
      this.data = data;
      next = null;
    }

    private Node (T data, Node next){
      this.data = data;
      this.next = next;
    }
  }

}
