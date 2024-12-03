package org.minidns.dnssec;

public class DnssecValidatorInitializationException extends RuntimeException {
    private static final long serialVersionUID = -1464257268053507791L;

    public DnssecValidatorInitializationException(String str, Throwable th2) {
        super(str, th2);
    }
}
