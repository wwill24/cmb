package org.minidns.dnsname;

public abstract class InvalidDnsNameException extends IllegalStateException {
    private static final long serialVersionUID = 1;
    protected final String ace;

    public static class DNSNameTooLongException extends InvalidDnsNameException {
        private static final long serialVersionUID = 1;
        private final byte[] bytes;

        public DNSNameTooLongException(String str, byte[] bArr) {
            super(str);
            this.bytes = bArr;
        }

        public String getMessage() {
            return "The DNS name '" + this.ace + "' exceeds the maximum name length of " + 255 + " octets by " + (this.bytes.length - 255) + " octets.";
        }
    }

    public static class LabelTooLongException extends InvalidDnsNameException {
        private static final long serialVersionUID = 1;
        private final String label;

        public LabelTooLongException(String str, String str2) {
            super(str);
            this.label = str2;
        }

        public String getMessage() {
            return "The DNS name '" + this.ace + "' contains the label '" + this.label + "' which exceeds the maximum label length of " + 63 + " octets by " + (this.label.length() - 63) + " octets.";
        }
    }

    protected InvalidDnsNameException(String str) {
        this.ace = str;
    }
}
