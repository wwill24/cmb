package org.bouncycastle.asn1;

import java.io.IOException;

public class DERNull extends ASN1Null {
    public static final DERNull INSTANCE = new DERNull();
    private static final byte[] zeroBytes = new byte[0];

    private DERNull() {
    }

    /* access modifiers changed from: package-private */
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z10) throws IOException {
        aSN1OutputStream.writeEncoded(z10, 5, zeroBytes);
    }

    /* access modifiers changed from: package-private */
    public int encodedLength() {
        return 2;
    }

    /* access modifiers changed from: package-private */
    public boolean isConstructed() {
        return false;
    }
}
