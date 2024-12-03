package org.jivesoftware.smackx.ox.exception;

public class InvalidBackupCodeException extends Exception {
    private static final long serialVersionUID = 1;

    public InvalidBackupCodeException(String str, Throwable th2) {
        super(str, th2);
    }
}
