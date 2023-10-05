package Exceptions;

public class UnableToReadException extends RuntimeException{
    public UnableToReadException(String message) {
        super(message);
    }
}
