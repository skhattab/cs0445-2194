/** Reorder interface for CS 0445 Assignment 1
 * @author Sherif Khattab (Adapted  from Dr. John Ramirez's Spring 2017 CS 0445 Assignment 1 code)
 * Carefully read the specifications for the methods below and
 * implement them in your ArrayDS<T> class.  As with the PrimQ<T> 
 * interface, don't worry as much about efficiency here as you do
 * about correctness.
 */
public interface Reorder
{
	/** Logically reverse the data in the Reorder object so that the item
	 * that was logically first will now be logically last and vice
	 * versa.  The physical implementation of this can be done in 
	 * many different ways, depending upon how you actually implemented
	 * your physical ArrayDS<T> class
	 */
	public void reverse();

	/** Remove the logically last item and put it at the 
	 * front.  As with reverse(), this can be done physically in
	 * different ways depending on the underlying implementation. 
	 */
	public void shiftRight();

	/** Remove the logically first item and put it at the
	 * end.  As above, this can be done in different ways.
	 */
	public void shiftLeft();
	
	/** Shift the contents of the Reorder object num places to 
	 * 	the left, but rather than removing items, simply change 
	 * their ordering in a cyclic way.  For example, if an object has 8 items in it 
	 * numbered from 1 to 8, a leftRotate of 3 would shift items 1, 2 and 3 to the
	 * end, so that the old item 4 would now be item 1, and the old items 
	 * 1, 2 and 3 would now be items 6, 7 and 8 (in that order).  The rotation should
	 * work modulo the size of the object, so, for example, if the object is of length 8 then
	 * a leftRotate of 10 should be equivalent to a leftRotate of 2.  If num < 0, the 
	 * rotation should still be done but it will in fact be a right rotation rather than
	 * a left rotation.
	 * @param num the number of places to rotate to the left
	 */
	public void leftRotate(int num);

	/** Same idea as leftRotate above, but in the opposite direction.  For example, if an object 
	 * has 8 items in it (numbered from 1 to 8), a rightRotate of 3 would shift items 8, 7 and 
	 * 6 to the beginning, so that the old item 8 would now be item 3, the old item 
	 * 7 would now be item 2 and the old item 6 would now be item 1.  The behavior for num > the
	 * number of items and for num < 0 should be analogous to that described above for leftRotate.
	 * @param num
	 */
	public void rightRotate(int num);
	
	/** Reorganize the items in the object in a pseudo-random way such that all permutations are equally likely.  
	 * Use Fisher–Yates shuffle Algorithm (http://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm).
	 * Use a Random object (see java.util.Random in the Java API) initialized with seed. Thus, after this operation the logically 
	 * first item could be arbitrary.
	 * @param seed the random seed to pass to Random().
	 */
	public void shuffle(int seed);

}