
/** A runtime exception that signals the PrimQ<T> object is empty
 * @author Sherif Khattab
 *
 */
public class EmptyQueueException extends RuntimeException {

	private static final long serialVersionUID = 575262834263843711L;

	public EmptyQueueException(String reason) {
		super(reason);
	}

}
