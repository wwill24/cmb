package org.apache.commons.validator.routines.checkdigit;

public class CheckDigitException extends Exception {
    private static final long serialVersionUID = -3519894732624685477L;

    public CheckDigitException() {
    }

    public CheckDigitException(String str) {
        super(str);
    }

    public CheckDigitException(String str, Throwable th2) {
        super(str, th2);
    }
}
