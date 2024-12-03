package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public class BEROctetStringGenerator extends BERGenerator {

    private class BufferedBEROctetStream extends OutputStream {
        private byte[] _buf;
        private DEROutputStream _derOut;
        private int _off = 0;

        BufferedBEROctetStream(byte[] bArr) {
            this._buf = bArr;
            this._derOut = new DEROutputStream(BEROctetStringGenerator.this._out);
        }

        public void close() throws IOException {
            int i10 = this._off;
            if (i10 != 0) {
                DEROctetString.encode(this._derOut, true, this._buf, 0, i10);
            }
            this._derOut.flushInternal();
            BEROctetStringGenerator.this.writeBEREnd();
        }

        public void write(int i10) throws IOException {
            byte[] bArr = this._buf;
            int i11 = this._off;
            int i12 = i11 + 1;
            this._off = i12;
            bArr[i11] = (byte) i10;
            if (i12 == bArr.length) {
                DEROctetString.encode(this._derOut, true, bArr, 0, bArr.length);
                this._off = 0;
            }
        }

        public void write(byte[] bArr, int i10, int i11) throws IOException {
            while (i11 > 0) {
                int min = Math.min(i11, this._buf.length - this._off);
                System.arraycopy(bArr, i10, this._buf, this._off, min);
                int i12 = this._off + min;
                this._off = i12;
                byte[] bArr2 = this._buf;
                if (i12 >= bArr2.length) {
                    DEROctetString.encode(this._derOut, true, bArr2, 0, bArr2.length);
                    this._off = 0;
                    i10 += min;
                    i11 -= min;
                } else {
                    return;
                }
            }
        }
    }

    public BEROctetStringGenerator(OutputStream outputStream) throws IOException {
        super(outputStream);
        writeBERHeader(36);
    }

    public BEROctetStringGenerator(OutputStream outputStream, int i10, boolean z10) throws IOException {
        super(outputStream, i10, z10);
        writeBERHeader(36);
    }

    public OutputStream getOctetOutputStream() {
        return getOctetOutputStream(new byte[1000]);
    }

    public OutputStream getOctetOutputStream(byte[] bArr) {
        return new BufferedBEROctetStream(bArr);
    }
}
