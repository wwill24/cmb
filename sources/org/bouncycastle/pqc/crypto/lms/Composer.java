package org.bouncycastle.pqc.crypto.lms;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.util.Encodable;

public class Composer {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    private Composer() {
    }

    public static Composer compose() {
        return new Composer();
    }

    public Composer bool(boolean z10) {
        this.bos.write(z10 ? 1 : 0);
        return this;
    }

    public byte[] build() {
        return this.bos.toByteArray();
    }

    public Composer bytes(Encodable encodable) {
        try {
            this.bos.write(encodable.getEncoded());
            return this;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }

    public Composer bytes(byte[] bArr) {
        try {
            this.bos.write(bArr);
            return this;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }

    public Composer bytes(byte[] bArr, int i10, int i11) {
        try {
            this.bos.write(bArr, i10, i11);
            return this;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }

    public Composer bytes(Encodable[] encodableArr) {
        try {
            for (Encodable encoded : encodableArr) {
                this.bos.write(encoded.getEncoded());
            }
            return this;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }

    public Composer bytes(byte[][] bArr) {
        try {
            for (byte[] write : bArr) {
                this.bos.write(write);
            }
            return this;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }

    public Composer bytes(byte[][] bArr, int i10, int i11) {
        while (i10 != i11) {
            try {
                this.bos.write(bArr[i10]);
                i10++;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage(), e10);
            }
        }
        return this;
    }

    public Composer pad(int i10, int i11) {
        while (i11 >= 0) {
            try {
                this.bos.write(i10);
                i11--;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage(), e10);
            }
        }
        return this;
    }

    public Composer padUntil(int i10, int i11) {
        while (this.bos.size() < i11) {
            this.bos.write(i10);
        }
        return this;
    }

    public Composer u16str(int i10) {
        int i11 = i10 & 65535;
        this.bos.write((byte) (i11 >>> 8));
        this.bos.write((byte) i11);
        return this;
    }

    public Composer u32str(int i10) {
        this.bos.write((byte) (i10 >>> 24));
        this.bos.write((byte) (i10 >>> 16));
        this.bos.write((byte) (i10 >>> 8));
        this.bos.write((byte) i10);
        return this;
    }

    public Composer u64str(long j10) {
        u32str((int) (j10 >>> 32));
        u32str((int) j10);
        return this;
    }
}
