package org.jivesoftware.smack.sasl.core;

import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.util.TLSUtils;

public abstract class ScramPlusMechanism extends ScramMechanism {
    protected ScramPlusMechanism(ScramHmac scramHmac) {
        super(scramHmac);
    }

    /* access modifiers changed from: protected */
    public byte[] getChannelBindingData() throws SmackException.SmackSaslException {
        try {
            return TLSUtils.getChannelBindingTlsServerEndPoint(this.sslSession);
        } catch (NoSuchAlgorithmException | CertificateEncodingException | SSLPeerUnverifiedException e10) {
            throw new SmackException.SmackSaslException(e10);
        }
    }

    /* access modifiers changed from: protected */
    public String getGs2CbindFlag() {
        return "p=tls-server-end-point";
    }

    public String getName() {
        return super.getName() + "-PLUS";
    }
}
