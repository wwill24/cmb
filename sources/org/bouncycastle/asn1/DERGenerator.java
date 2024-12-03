package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public abstract class DERGenerator extends ASN1Generator {
    private boolean _isExplicit;
    private int _tagNo;
    private boolean _tagged = false;

    protected DERGenerator(OutputStream outputStream) {
        super(outputStream);
    }

    public DERGenerator(OutputStream outputStream, int i10, boolean z10) {
        super(outputStream);
        this._isExplicit = z10;
        this._tagNo = i10;
    }

    private void writeLength(OutputStream outputStream, int i10) throws IOException {
        if (i10 > 127) {
            int i11 = i10;
            int i12 = 1;
            while (true) {
                i11 >>>= 8;
                if (i11 == 0) {
                    break;
                }
                i12++;
            }
            outputStream.write((byte) (i12 | 128));
            for (int i13 = (i12 - 1) * 8; i13 >= 0; i13 -= 8) {
                outputStream.write((byte) (i10 >> i13));
            }
            return;
        }
        outputStream.write((byte) i10);
    }

    /* access modifiers changed from: package-private */
    public void writeDEREncoded(int i10, byte[] bArr) throws IOException {
        if (this._tagged) {
            int i11 = this._tagNo;
            int i12 = i11 | 128;
            if (this._isExplicit) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                writeDEREncoded(byteArrayOutputStream, i10, bArr);
                writeDEREncoded(this._out, i11 | 32 | 128, byteArrayOutputStream.toByteArray());
            } else if ((i10 & 32) != 0) {
                writeDEREncoded(this._out, i12 | 32, bArr);
            } else {
                writeDEREncoded(this._out, i12, bArr);
            }
        } else {
            writeDEREncoded(this._out, i10, bArr);
        }
    }

    /* access modifiers changed from: package-private */
    public void writeDEREncoded(OutputStream outputStream, int i10, byte[] bArr) throws IOException {
        outputStream.write(i10);
        writeLength(outputStream, bArr.length);
        outputStream.write(bArr);
    }
}
