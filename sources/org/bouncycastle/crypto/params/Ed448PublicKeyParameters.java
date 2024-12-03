package org.bouncycastle.crypto.params;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

public final class Ed448PublicKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 57;
    private final byte[] data;

    public Ed448PublicKeyParameters(InputStream inputStream) throws IOException {
        super(false);
        byte[] bArr = new byte[57];
        this.data = bArr;
        if (57 != Streams.readFully(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of Ed448 public key");
        }
    }

    public Ed448PublicKeyParameters(byte[] bArr) {
        this(validate(bArr), 0);
    }

    public Ed448PublicKeyParameters(byte[] bArr, int i10) {
        super(false);
        byte[] bArr2 = new byte[57];
        this.data = bArr2;
        System.arraycopy(bArr, i10, bArr2, 0, 57);
    }

    private static byte[] validate(byte[] bArr) {
        if (bArr.length == 57) {
            return bArr;
        }
        throw new IllegalArgumentException("'buf' must have length 57");
    }

    public void encode(byte[] bArr, int i10) {
        System.arraycopy(this.data, 0, bArr, i10, 57);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.data);
    }
}
