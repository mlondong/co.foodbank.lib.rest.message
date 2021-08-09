package co.com.foodbank.message.exception;


/**
 * @author mauricio.londono@gmail.com co.com.foodbank.pckage.exception
 *         11/07/2021
 */
public class MessageNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MessageNotFoundException(String id) {
        super(id);
    }
}
