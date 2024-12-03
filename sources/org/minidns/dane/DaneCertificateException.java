package org.minidns.dane;

import java.security.cert.CertificateException;
import java.util.Collections;
import java.util.List;
import org.minidns.record.TLSA;

public abstract class DaneCertificateException extends CertificateException {
    private static final long serialVersionUID = 1;

    public static class CertificateMismatch extends DaneCertificateException {
        private static final long serialVersionUID = 1;
        public final byte[] computed;
        public final TLSA tlsa;

        public CertificateMismatch(TLSA tlsa2, byte[] bArr) {
            super("The TLSA RR does not match the certificate");
            this.tlsa = tlsa2;
            this.computed = bArr;
        }
    }

    public static class MultipleCertificateMismatchExceptions extends DaneCertificateException {
        private static final long serialVersionUID = 1;
        public final List<CertificateMismatch> certificateMismatchExceptions;

        static {
            Class<DaneCertificateException> cls = DaneCertificateException.class;
        }

        public MultipleCertificateMismatchExceptions(List<CertificateMismatch> list) {
            super("There where multiple CertificateMismatch exceptions because none of the TLSA RR does match the certificate");
            this.certificateMismatchExceptions = Collections.unmodifiableList(list);
        }
    }

    protected DaneCertificateException() {
    }

    protected DaneCertificateException(String str) {
        super(str);
    }
}
