package org.bouncycastle.asn1;

import java.io.IOException;

public class BERTaggedObjectParser implements ASN1TaggedObjectParser {
    private boolean _constructed;
    private ASN1StreamParser _parser;
    private int _tagNumber;

    BERTaggedObjectParser(boolean z10, int i10, ASN1StreamParser aSN1StreamParser) {
        this._constructed = z10;
        this._tagNumber = i10;
        this._parser = aSN1StreamParser;
    }

    public ASN1Primitive getLoadedObject() throws IOException {
        return this._parser.readTaggedObject(this._constructed, this._tagNumber);
    }

    public ASN1Encodable getObjectParser(int i10, boolean z10) throws IOException {
        if (!z10) {
            return this._parser.readImplicit(this._constructed, i10);
        }
        if (this._constructed) {
            return this._parser.readObject();
        }
        throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
    }

    public int getTagNo() {
        return this._tagNumber;
    }

    public boolean isConstructed() {
        return this._constructed;
    }

    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e10) {
            throw new ASN1ParsingException(e10.getMessage());
        }
    }
}
