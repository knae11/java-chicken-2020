package common;

public class InvalidException extends IllegalArgumentException {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public InvalidException(String message) {
        super(ERROR_PREFIX + message);
    }

}
