package org.bouncycastle.crypto.params;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.rfc7748.X25519;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

public final class X25519PrivateKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 32;
    public static final int SECRET_SIZE = 32;
    private final byte[] data;

    public X25519PrivateKeyParameters(InputStream inputStream) throws IOException {
        super(true);
        byte[] bArr = new byte[32];
        this.data = bArr;
        if (32 != Streams.readFully(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of X25519 private key");
        }
    }

    public X25519PrivateKeyParameters(SecureRandom secureRandom) {
        super(true);
        byte[] bArr = new byte[32];
        this.data = bArr;
        X25519.generatePrivateKey(secureRandom, bArr);
    }

    public X25519PrivateKeyParameters(byte[] bArr) {
        this(validate(bArr), 0);
    }

    public X25519PrivateKeyParameters(byte[] bArr, int i10) {
        super(true);
        byte[] bArr2 = new byte[32];
        this.data = bArr2;
        System.arraycopy(bArr, i10, bArr2, 0, 32);
    }

    private static byte[] validate(byte[] bArr) {
        if (bArr.length == 32) {
            return bArr;
        }
        throw new IllegalArgumentException("'buf' must have length 32");
    }

    public void encode(byte[] bArr, int i10) {
        System.arraycopy(this.data, 0, bArr, i10, 32);
    }

    public X25519PublicKeyParameters generatePublicKey() {
        byte[] bArr = new byte[32];
        X25519.generatePublicKey(this.data, 0, bArr, 0);
        return new X25519PublicKeyParameters(bArr, 0);
    }

    public void generateSecret(X25519PublicKeyParameters x25519PublicKeyParameters, byte[] bArr, int i10) {
        byte[] bArr2 = new byte[32];
        x25519PublicKeyParameters.encode(bArr2, 0);
        if (!X25519.calculateAgreement(this.data, 0, bArr2, 0, bArr, i10)) {
            throw new IllegalStateException("X25519 agreement failed");
        }
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.data);
    }
}
