package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

class DLOutputStream extends ASN1OutputStream {
    DLOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    /* access modifiers changed from: package-private */
    public ASN1OutputStream getDLSubStream() {
        return this;
    }

    /* access modifiers changed from: package-private */
    public void writePrimitive(ASN1Primitive aSN1Primitive, boolean z10) throws IOException {
        aSN1Primitive.toDLObject().encode(this, z10);
    }
}
