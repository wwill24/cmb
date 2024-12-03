package org.bouncycastle.util.encoders;

public class BufferedDecoder {
    protected byte[] buf;
    protected int bufOff;
    protected Translator translator;

    public BufferedDecoder(Translator translator2, int i10) {
        this.translator = translator2;
        if (i10 % translator2.getEncodedBlockSize() == 0) {
            this.buf = new byte[i10];
            this.bufOff = 0;
            return;
        }
        throw new IllegalArgumentException("buffer size not multiple of input block size");
    }

    public int processByte(byte b10, byte[] bArr, int i10) {
        byte[] bArr2 = this.buf;
        int i11 = this.bufOff;
        int i12 = i11 + 1;
        this.bufOff = i12;
        bArr2[i11] = b10;
        if (i12 != bArr2.length) {
            return 0;
        }
        int decode = this.translator.decode(bArr2, 0, bArr2.length, bArr, i10);
        this.bufOff = 0;
        return decode;
    }

    public int processBytes(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        if (i11 >= 0) {
            byte[] bArr3 = this.buf;
            int length = bArr3.length;
            int i13 = this.bufOff;
            int i14 = length - i13;
            int i15 = 0;
            if (i11 > i14) {
                System.arraycopy(bArr, i10, bArr3, i13, i14);
                Translator translator2 = this.translator;
                byte[] bArr4 = this.buf;
                int decode = translator2.decode(bArr4, 0, bArr4.length, bArr2, i12) + 0;
                this.bufOff = 0;
                int i16 = i11 - i14;
                int i17 = i10 + i14;
                int i18 = i12 + decode;
                int length2 = i16 - (i16 % this.buf.length);
                i15 = decode + this.translator.decode(bArr, i17, length2, bArr2, i18);
                i11 = i16 - length2;
                i10 = i17 + length2;
            }
            if (i11 != 0) {
                System.arraycopy(bArr, i10, this.buf, this.bufOff, i11);
                this.bufOff += i11;
            }
            return i15;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
