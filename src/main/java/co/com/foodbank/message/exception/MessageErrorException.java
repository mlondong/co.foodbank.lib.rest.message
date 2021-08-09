package co.com.foodbank.message.exception;


/**
 * @author mauricio.londono@gmail.com co.com.foodbank.pckage.exception
 *         11/07/2021
 */
public class MessageErrorException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public MessageErrorException(String ex) {
        super(ex);
    }
}
