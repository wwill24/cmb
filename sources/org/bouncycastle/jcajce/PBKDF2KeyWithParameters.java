package org.bouncycastle.jcajce;

import javax.crypto.interfaces.PBEKey;
import org.bouncycastle.crypto.CharToByteConverter;
import org.bouncycastle.util.Arrays;

public class PBKDF2KeyWithParameters extends PBKDF2Key implements PBEKey {
    private final int iterationCount;
    private final byte[] salt;

    public PBKDF2KeyWithParameters(char[] cArr, CharToByteConverter charToByteConverter, byte[] bArr, int i10) {
        super(cArr, charToByteConverter);
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
