package ig;

import java.security.InvalidKeyException;

class h extends i {
    h(byte[] bArr, int i10) throws InvalidKeyException {
        super(bArr, i10);
    }

    /* access modifiers changed from: package-private */
    public int[] d(int[] iArr, int i10) {
        if (iArr.length == g() / 4) {
            int[] iArr2 = new int[16];
            i.k(iArr2, this.f23519a);
            iArr2[12] = i10;
            System.arraycopy(iArr, 0, iArr2, 13, iArr.length);
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", new Object[]{Integer.valueOf(iArr.length * 32)}));
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return 12;
    }
}
