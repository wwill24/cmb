package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DERSequenceGenerator extends DERGenerator {
    private final ByteArrayOutputStream _bOut = new ByteArrayOutputStream();

    public DERSequenceGenerator(OutputStream outputStream) throws IOException {
        super(outputStream);
    }

    public DERSequenceGenerator(OutputStream outputStream, int i10, boolean z10) throws IOException {
        super(outputStream, i10, z10);
    }

    public void addObject(ASN1Encodable aSN1Encodable) throws IOException {
        aSN1Encodable.toASN1Primitive().encodeTo(this._bOut, ASN1Encoding.DER);
    }

    public void close() throws IOException {
        writeDEREncoded(48, this._bOut.toByteArray());
    }

    public OutputStream getRawOutputStream() {
        return this._bOut;
    }
}
