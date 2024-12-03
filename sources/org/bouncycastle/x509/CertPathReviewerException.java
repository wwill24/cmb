package org.bouncycastle.x509;

import java.security.cert.CertPath;
import org.bouncycastle.i18n.ErrorBundle;
import org.bouncycastle.i18n.LocalizedException;

public class CertPathReviewerException extends LocalizedException {
    private CertPath certPath = null;
    private int index = -1;

    public CertPathReviewerException(ErrorBundle errorBundle) {
        super(errorBundle);
    }

    public CertPathReviewerException(ErrorBundle errorBundle, Throwable th2) {
        super(errorBundle, th2);
    }

    public CertPathReviewerException(ErrorBundle errorBundle, Throwable th2, CertPath certPath2, int i10) {
        super(errorBundle, th2);
        if (certPath2 == null || i10 == -1) {
            throw new IllegalArgumentException();
        } else if (i10 < -1 || i10 >= certPath2.getCertificates().size()) {
            throw new IndexOutOfBoundsException();
        } else {
            this.certPath = certPath2;
            this.index = i10;
        }
    }

    public CertPathReviewerException(ErrorBundle errorBundle, CertPath certPath2, int i10) {
        super(errorBundle);
        if (certPath2 == null || i10 == -1) {
            throw new IllegalArgumentException();
        } else if (i10 < -1 || i10 >= certPath2.getCertificates().size()) {
            throw new IndexOutOfBoundsException();
        } else {
            this.certPath = certPath2;
            this.index = i10;
        }
    }

    public CertPath getCertPath() {
        return this.certPath;
    }

    public int getIndex() {
        return this.index;
    }
}
