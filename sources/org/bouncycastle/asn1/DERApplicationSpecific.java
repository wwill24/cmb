package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DERApplicationSpecific extends ASN1ApplicationSpecific {
    public DERApplicationSpecific(int i10, ASN1Encodable aSN1Encodable) throws IOException {
        this(true, i10, aSN1Encodable);
    }

    public DERApplicationSpecific(int i10, ASN1EncodableVector aSN1EncodableVector) {
        super(true, i10, getEncodedVector(aSN1EncodableVector));
    }

    public DERApplicationSpecific(int i10, byte[] bArr) {
        this(false, i10, bArr);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DERApplicationSpecific(boolean z10, int i10, ASN1Encodable aSN1Encodable) throws IOException {
        super(z10 || aSN1Encodable.toASN1Primitive().isConstructed(), i10, getEncoding(z10, aSN1Encodable));
    }

    DERApplicationSpecific(boolean z10, int i10, byte[] bArr) {
        super(z10, i10, bArr);
    }

    private static byte[] getEncodedVector(ASN1EncodableVector aSN1EncodableVector) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        while (i10 != aSN1EncodableVector.size()) {
            try {
                byteArrayOutputStream.write(((ASN1Object) aSN1EncodableVector.get(i10)).getEncoded(ASN1Encoding.DER));
                i10++;
            } catch (IOException e10) {
                throw new ASN1ParsingException("malformed object: " + e10, e10);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] getEncoding(boolean z10, ASN1Encodable aSN1Encodable) throws IOException {
        byte[] encoded = aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER);
        if (z10) {
            return encoded;
        }
        int lengthOfHeader = ASN1ApplicationSpecific.getLengthOfHeader(encoded);
        int length = encoded.length - lengthOfHeader;
        byte[] bArr = new byte[length];
        System.arraycopy(encoded, lengthOfHeader, bArr, 0, length);
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z10) throws IOException {
        aSN1OutputStream.writeEncoded(z10, this.isConstructed ? 96 : 64, this.tag, this.octets);
    }
}
