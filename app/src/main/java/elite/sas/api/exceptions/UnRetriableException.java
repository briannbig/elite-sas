package elite.sas.api.exceptions;


public class UnRetriableException extends Exception {


    public UnRetriableException() {
        super();
    }

    public UnRetriableException(String message) {
        super(message);
    }

    public UnRetriableException(String message, Throwable cause) {
        super(message, cause);
    }
}
