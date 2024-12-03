package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public class BERGenerator extends ASN1Generator {
    private boolean _isExplicit;
    private int _tagNo;
    private boolean _tagged = false;

    protected BERGenerator(OutputStream outputStream) {
        super(outputStream);
    }

    protected BERGenerator(OutputStream outputStream, int i10, boolean z10) {
        super(outputStream);
        this._isExplicit = z10;
        this._tagNo = i10;
    }

    private void writeHdr(int i10) throws IOException {
        this._out.write(i10);
        this._out.write(128);
    }

    public OutputStream getRawOutputStream() {
        return this._out;
    }

    /* access modifiers changed from: protected */
    public void writeBEREnd() throws IOException {
        this._out.write(0);
        this._out.write(0);
        if (this._tagged && this._isExplicit) {
            this._out.write(0);
            this._out.write(0);
        }
    }

    /* access modifiers changed from: protected */
    public void writeBERHeader(int i10) throws IOException {
        if (this._tagged) {
            int i11 = this._tagNo | 128;
            if (this._isExplicit) {
                writeHdr(i11 | 32);
            } else if ((i10 & 32) != 0) {
                i10 = i11 | 32;
            } else {
                writeHdr(i11);
                return;
            }
        }
        writeHdr(i10);
    }
}
