package org.sk.sample.journals.exception;

public class JournalInitException extends Exception{
    public JournalInitException() {
    }

    public JournalInitException(String message) {
        super(message);
    }

    public JournalInitException(String message, Throwable cause) {
        super(message, cause);
    }

    public JournalInitException(Throwable cause) {
        super(cause);
    }

    public JournalInitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
