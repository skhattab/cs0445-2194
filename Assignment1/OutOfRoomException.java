
/** A runtime exception that signals there was no room to add a new item to a PrimQ<T> object
 * @author Sherif Khattab
 *
 */
public class OutOfRoomException extends RuntimeException {
	
	private static final long serialVersionUID = 5967146166910234884L;

	public OutOfRoomException(String reason) {
		super(reason);
	}

}
