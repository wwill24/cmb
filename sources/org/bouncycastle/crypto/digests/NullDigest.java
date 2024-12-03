package org.bouncycastle.crypto.digests;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Arrays;

public class NullDigest implements Digest {
    private OpenByteArrayOutputStream bOut = new OpenByteArrayOutputStream();

    private static class OpenByteArrayOutputStream extends ByteArrayOutputStream {
        private OpenByteArrayOutputStream() {
        }

        /* access modifiers changed from: package-private */
        public void copy(byte[] bArr, int i10) {
            System.arraycopy(this.buf, 0, bArr, i10, size());
        }

        public void reset() {
            super.reset();
            Arrays.clear(this.buf);
        }
    }

    public int doFinal(byte[] bArr, int i10) {
        int size = this.bOut.size();
        this.bOut.copy(bArr, i10);
        reset();
        return size;
    }

    public String getAlgorithmName() {
        return "NULL";
    }

    public int getDigestSize() {
        return this.bOut.size();
    }

    public void reset() {
        this.bOut.reset();
    }

    public void update(byte b10) {
        this.bOut.write(b10);
    }

    public void update(byte[] bArr, int i10, int i11) {
        this.bOut.write(bArr, i10, i11);
    }
}
