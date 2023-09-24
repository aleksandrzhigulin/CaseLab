package Exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;

public class ListOverflowException extends Exception {
    @Override
    public String getMessage() {
        return "The list can't contain more than 10 elements";
    }

    @Override
    public String getLocalizedMessage() {
        return "The list can't contain more than 10 elements";
    }

    @Override
    public synchronized Throwable getCause() {
        return new ListOverflowException();
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return new ListOverflowException();
    }

    @Override
    public String toString() {
        return "List Overflow Exception";
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    @Override
    public void setStackTrace(StackTraceElement[] stackTrace) {
        super.setStackTrace(stackTrace);
    }
}
