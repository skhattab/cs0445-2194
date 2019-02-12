/**
   A class that implements the ADT list by using a chain of nodes
   that has both a head reference and a tail reference.

   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
final public class LListWithTail<T> implements ListInterface<T>
{
	private Node firstNode;
	private Node lastNode;
	private int numberOfItems;


	public LListWithTail()
	{
		initializeDataFields();
	} // end default constructor

	public void clear()
	{
		initializeDataFields();
	} // end clear

	public void add(T newEntry)
	{
		Node toAdd = new Node(newEntry);
		if(isEmpty()) {
			firstNode = toAdd;
			lastNode = toAdd;
		} else {
			Node nodeBefore = lastNode;
			Node nodeAfter = nodeBefore.next;
			toAdd.next = nodeAfter;
			nodeBefore.next = toAdd;
			lastNode = toAdd;
		}
		numberOfItems++;
	}  // end add

   public void add(int newPosition, T newEntry)
	{
      if ((newPosition >= 1) && (newPosition <= numberOfItems + 1))
      {
 				 Node toAdd = new Node(newEntry);

         if (isEmpty())
         {
					 firstNode = toAdd;
					 lastNode = toAdd;
         }
         else if (newPosition == 1)
         {
					 toAdd.next = firstNode;
					 firstNode = toAdd;
         }
         else if (newPosition == numberOfItems + 1)
         {
					 Node nodeBefore = lastNode;
					 Node nodeAfter = nodeBefore.next;
					 toAdd.next = nodeAfter;
					 nodeBefore.next = toAdd;

					 lastNode = toAdd;
         }
         else
         {
					 Node nodeBefore = getNodeAt(newPosition-1);
					 Node nodeAfter = nodeBefore.next;
					 toAdd.next = nodeAfter;
					 nodeBefore.next = toAdd;
         } // end if
         numberOfItems++;
      }
      else
         throw new IndexOutOfBoundsException("Illegal position given to add operation.");
	} // end add

	public T remove(int givenPosition)
	{
      T result = null;                           // Return value

      if ((givenPosition >= 1) && (givenPosition <= numberOfItems))
      {
					Node toRemove = null;
           if (givenPosition == 1)                 // Case 1: Remove first entry
           {
						 toRemove = firstNode;
						 firstNode = firstNode.next;
						 if(numberOfItems == 1) {
							 lastNode = firstNode; //null
						 }
            }
            else                                 // Case 2: Not first entry
            {
							Node nodeBefore = getNodeAt(givenPosition - 1);
							toRemove = nodeBefore.next;
							Node nodeAfter = toRemove.next;
							nodeBefore.next = nodeAfter;
							if(givenPosition == numberOfItems) {
								lastNode = nodeBefore;
							}

             } // end if
				 result = toRemove.data;
         numberOfItems--;
      }
      else
         throw new IndexOutOfBoundsException("Illegal position given to remove operation.");

      return result;                             // Return removed entry
	} // end remove

	public T replace(int givenPosition, T newEntry)
	{
      if ((givenPosition >= 1) && (givenPosition <= numberOfItems))
      {
				Node toReplace = getNodeAt(givenPosition);
				T original = toReplace.data;
				toReplace.data = newEntry;
				return original;
      }
		  else
         throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
   } // end replace

   public T getEntry(int givenPosition)
   {
		if ((givenPosition >= 1) && (givenPosition <= numberOfItems))
		{
			Node node = getNodeAt(givenPosition);
			return node.data;
    }
    else
         throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
   } // end getEntry

   public T[] toArray()
   {
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfItems];

      int index = 0;
      Node currentNode = firstNode;
			while((index < numberOfItems) && (currentNode != null)){
				result[index] = currentNode.data;
				currentNode = currentNode.next;
				index++;
			}


      return result;
   } // end toArray

	public boolean contains(T anEntry)
	{
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null))
		{
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		} // end while

		return found;
	} // end contains

   public int getLength()
   {
      return numberOfItems;
   } // end getLength

   public boolean isEmpty()
   {
		 return numberOfItems == 0;
	 } // end isEmpty

   // Initializes the class's data fields to indicate an empty list.
   private void initializeDataFields()
   {
		 firstNode = null;
		 lastNode = null;
		 numberOfItems = 0;

	 } // end initializeDataFields

	// Returns a reference to the node at a given position.
	// Precondition: List is not empty; 1 <= givenPosition <= numberOfItems.
	private Node getNodeAt(int givenPosition)
	{
		Node currentNode = firstNode;

      if (givenPosition == numberOfItems){
				currentNode = lastNode;
			}
      else if (givenPosition >1)
	  	{
         // Traverse the chain to locate the desired node
				 for(int i=1; i<givenPosition; i++){
					 currentNode = currentNode.next;
				 }

		  } // end if

  		return currentNode;
	} // end getNodeAt

	private class Node
	{
		private T data;     // Data portion
		private Node next;  // Next to next node

		private Node(T dataPortion)//  PRIVATE or PUBLIC is OK
		{
			data = dataPortion;
			next = null;
		} // end constructor

		private Node(T dataPortion, Node nextNode)//  PRIVATE or PUBLIC is OK
		{
			data = dataPortion;
			next = nextNode;
		} // end constructor

		private T getData()
		{
			return data;
		} // end getData

		private void setData(T newData)
		{
			data = newData;
		} // end setData

		private Node getNextNode()
		{
			return next;
		} // end getNextNode

		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		} // end setNextNode
	} // end Node
} // end LListWithTail
