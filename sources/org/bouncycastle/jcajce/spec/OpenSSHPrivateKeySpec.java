package org.bouncycastle.jcajce.spec;

import java.security.spec.EncodedKeySpec;

public class OpenSSHPrivateKeySpec extends EncodedKeySpec {

    /* renamed from: format  reason: collision with root package name */
    private final String f23858format;

    public OpenSSHPrivateKeySpec(byte[] bArr) {
        super(bArr);
        String str;
        byte b10 = bArr[0];
        if (b10 == 48) {
            str = "ASN.1";
        } else if (b10 == 111) {
            str = "OpenSSH";
        } else {
            throw new IllegalArgumentException("unknown byte encoding");
        }
        this.f23858format = str;
    }

    public String getFormat() {
        return this.f23858format;
    }
}
