package org.bouncycastle.crypto.params;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.rfc8032.Ed25519;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

public final class Ed25519PrivateKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 32;
    public static final int SIGNATURE_SIZE = 64;
    private Ed25519PublicKeyParameters cachedPublicKey;
    private final byte[] data;

    public Ed25519PrivateKeyParameters(InputStream inputStream) throws IOException {
        super(true);
        byte[] bArr = new byte[32];
        this.data = bArr;
        if (32 != Streams.readFully(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of Ed25519 private key");
        }
    }

    public Ed25519PrivateKeyParameters(SecureRandom secureRandom) {
        super(true);
        byte[] bArr = new byte[32];
        this.data = bArr;
        Ed25519.generatePrivateKey(secureRandom, bArr);
    }

    public Ed25519PrivateKeyParameters(byte[] bArr) {
        this(validate(bArr), 0);
    }

    public Ed25519PrivateKeyParameters(byte[] bArr, int i10) {
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

    public Ed25519PublicKeyParameters generatePublicKey() {
        Ed25519PublicKeyParameters ed25519PublicKeyParameters;
        synchronized (this.data) {
            if (this.cachedPublicKey == null) {
                byte[] bArr = new byte[32];
                Ed25519.generatePublicKey(this.data, 0, bArr, 0);
                this.cachedPublicKey = new Ed25519PublicKeyParameters(bArr, 0);
            }
            ed25519PublicKeyParameters = this.cachedPublicKey;
        }
        return ed25519PublicKeyParameters;
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.data);
    }

    public void sign(int i10, Ed25519PublicKeyParameters ed25519PublicKeyParameters, byte[] bArr, byte[] bArr2, int i11, int i12, byte[] bArr3, int i13) {
        sign(i10, bArr, bArr2, i11, i12, bArr3, i13);
    }

    public void sign(int i10, byte[] bArr, byte[] bArr2, int i11, int i12, byte[] bArr3, int i13) {
        int i14 = i10;
        byte[] bArr4 = new byte[32];
        generatePublicKey().encode(bArr4, 0);
        if (i14 == 0) {
            int i15 = i12;
            if (bArr == null) {
                Ed25519.sign(this.data, 0, bArr4, 0, bArr2, i11, i12, bArr3, i13);
                return;
            }
            throw new IllegalArgumentException("ctx");
        } else if (i14 == 1) {
            int i16 = i12;
            Ed25519.sign(this.data, 0, bArr4, 0, bArr, bArr2, i11, i12, bArr3, i13);
        } else if (i14 != 2) {
            throw new IllegalArgumentException("algorithm");
        } else if (64 == i12) {
            Ed25519.signPrehash(this.data, 0, bArr4, 0, bArr, bArr2, i11, bArr3, i13);
        } else {
            throw new IllegalArgumentException("msgLen");
        }
    }
}
