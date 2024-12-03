package org.bouncycastle.jce;

import java.io.IOException;
import java.security.Principal;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.X509Name;

public class X509Principal extends X509Name implements Principal {
    public X509Principal(String str) {
        super(str);
    }

    public X509Principal(Hashtable hashtable) {
        super(hashtable);
    }

    public X509Principal(Vector vector, Hashtable hashtable) {
        super(vector, hashtable);
    }

    public X509Principal(Vector vector, Vector vector2) {
        super(vector, vector2);
    }

    public X509Principal(X500Name x500Name) {
        super((ASN1Sequence) x500Name.toASN1Primitive());
    }

    public X509Principal(X509Name x509Name) {
        super((ASN1Sequence) x509Name.toASN1Primitive());
    }

    public X509Principal(boolean z10, String str) {
        super(z10, str);
    }

    public X509Principal(boolean z10, Hashtable hashtable, String str) {
        super(z10, hashtable, str);
    }

    public X509Principal(byte[] bArr) throws IOException {
        super(readSequence(new ASN1InputStream(bArr)));
    }

    private static ASN1Sequence readSequence(ASN1InputStream aSN1InputStream) throws IOException {
        try {
            return ASN1Sequence.getInstance(aSN1InputStream.readObject());
        } catch (IllegalArgumentException e10) {
            throw new IOException("not an ASN.1 Sequence: " + e10);
        }
    }

    public byte[] getEncoded() {
        try {
            return getEncoded(ASN1Encoding.DER);
        } catch (IOException e10) {
            throw new RuntimeException(e10.toString());
        }
    }

    public String getName() {
        return toString();
    }
}
