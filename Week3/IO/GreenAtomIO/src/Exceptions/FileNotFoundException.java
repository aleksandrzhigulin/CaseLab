package Exceptions;

public class FileNotFoundException extends RuntimeException {

    public FileNotFoundException() {
        super("File not found");
    }

    public FileNotFoundException(String message) {
        super(message);
    }
}
