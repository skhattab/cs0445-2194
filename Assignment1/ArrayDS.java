public class ArrayDS<T> implements PrimQ<T>, Reorder{
  private final T[] queue;
  private int numberOfItems;

  private static final int MAX_CAPACITY = 10000;
  private static final int DEFAULT_CAPACITY = 20;

  public ArrayDS(){

  }

  public ArrayDS(int capacity){

  }

  public void addItem(T item) throws OutOfRoomException {
    if(numberOfItems == queue.length){
      throw new OutOfRoomException("Trying to add into " +
                                   " a full PrimQ");
    }

    queue[numberOfItems] = item;
    numberOfItems++;
  }


}
