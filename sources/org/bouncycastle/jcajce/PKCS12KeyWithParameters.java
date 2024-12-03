package org.bouncycastle.jcajce;

import javax.crypto.interfaces.PBEKey;
import org.bouncycastle.util.Arrays;

public class PKCS12KeyWithParameters extends PKCS12Key implements PBEKey {
    private final int iterationCount;
    private final byte[] salt;

    public PKCS12KeyWithParameters(char[] cArr, boolean z10, byte[] bArr, int i10) {
        super(cArr, z10);
        this.salt = Arrays.clone(bArr);
        this.iterationCount = i10;
    }

    public PKCS12KeyWithParameters(char[] cArr, byte[] bArr, int i10) {
        super(cArr);
        this.salt = Arrays.clone(bArr);
        this.iterationCount = i10;
    }

    public int getIterationCount() {
        return this.iterationCount;
    }

    public byte[] getSalt() {
        return this.salt;
    }
}
