package org.minidns.dnssec;

import java.io.IOException;
import java.security.spec.InvalidKeySpecException;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsmessage.a;
import org.minidns.record.Record;
import org.minidns.record.h;

public class DnssecValidationFailedException extends IOException {
    private static final long serialVersionUID = 5413184667629832742L;

    public static class AuthorityDoesNotContainSoa extends DnssecValidationFailedException {
        private static final long serialVersionUID = 1;
        private final DnsMessage response;

        public AuthorityDoesNotContainSoa(DnsMessage dnsMessage) {
            super("Autority does not contain SOA");
            this.response = dnsMessage;
        }
    }

    public static class DataMalformedException extends DnssecValidationFailedException {
        private static final long serialVersionUID = 1;
        private final byte[] data;

        public DataMalformedException(IOException iOException, byte[] bArr) {
            super("Malformed data", (Throwable) iOException);
            this.data = bArr;
        }
    }

    public static class DnssecInvalidKeySpecException extends DnssecValidationFailedException {
        private static final long serialVersionUID = 1;

        public DnssecInvalidKeySpecException(InvalidKeySpecException invalidKeySpecException) {
            super("Invalid key spec", (Throwable) invalidKeySpecException);
        }
    }

    public DnssecValidationFailedException(a aVar, String str) {
        super("Validation of request to " + aVar + " failed: " + str);
    }

    public DnssecValidationFailedException(String str) {
        super(str);
    }

    public DnssecValidationFailedException(String str, Throwable th2) {
        super(str, th2);
    }

    public DnssecValidationFailedException(Record<? extends h> record, String str) {
        super("Validation of record " + record + " failed: " + str);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DnssecValidationFailedException(java.util.List<org.minidns.record.Record<? extends org.minidns.record.h>> r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Validation of "
            r0.append(r1)
            int r1 = r3.size()
            r0.append(r1)
            java.lang.String r1 = " "
            r0.append(r1)
            r1 = 0
            java.lang.Object r1 = r3.get(r1)
            org.minidns.record.Record r1 = (org.minidns.record.Record) r1
            org.minidns.record.Record$TYPE r1 = r1.f41571b
            r0.append(r1)
            java.lang.String r1 = " record"
            r0.append(r1)
            int r3 = r3.size()
            r1 = 1
            if (r3 <= r1) goto L_0x0031
            java.lang.String r3 = "s"
            goto L_0x0033
        L_0x0031:
            java.lang.String r3 = ""
        L_0x0033:
            r0.append(r3)
            java.lang.String r3 = " failed: "
            r0.append(r3)
            r0.append(r4)
            java.lang.String r3 = r0.toString()
            r2.<init>(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.minidns.dnssec.DnssecValidationFailedException.<init>(java.util.List, java.lang.String):void");
    }
}
