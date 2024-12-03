package org.bouncycastle.asn1;

import java.io.IOException;

public class DERExternalParser implements ASN1Encodable, InMemoryRepresentable {
    private ASN1StreamParser _parser;

    public DERExternalParser(ASN1StreamParser aSN1StreamParser) {
        this._parser = aSN1StreamParser;
    }

    public ASN1Primitive getLoadedObject() throws IOException {
        try {
            return new DLExternal(this._parser.readVector());
        } catch (IllegalArgumentException e10) {
            throw new ASN1Exception(e10.getMessage(), e10);
        }
    }

    public ASN1Encodable readObject() throws IOException {
        return this._parser.readObject();
    }

    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e10) {
            throw new ASN1ParsingException("unable to get DER object", e10);
        } catch (IllegalArgumentException e11) {
            throw new ASN1ParsingException("unable to get DER object", e11);
        }
    }
}
