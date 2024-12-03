package org.jivesoftware.smack.sasl.core;

import java.security.InvalidKeyException;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.util.MAC;

public class SCRAMSHA1Mechanism extends ScramMechanism {
    public static final String NAME = new SCRAMSHA1Mechanism().getName();
    static final int PRIORITY = 110;
    static final ScramHmac SHA_1_SCRAM_HMAC = new ScramHmac() {
        public String getHmacName() {
            return "SHA-1";
        }

        public byte[] hmac(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
            return MAC.hmacsha1(bArr, bArr2);
        }
    };

    public SCRAMSHA1Mechanism() {
        super(SHA_1_SCRAM_HMAC);
    }

    public int getPriority() {
        return 110;
    }

    /* access modifiers changed from: protected */
    public SASLMechanism newInstance() {
        return new SCRAMSHA1Mechanism();
    }
}
