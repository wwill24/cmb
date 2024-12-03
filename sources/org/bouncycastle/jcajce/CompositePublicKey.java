package org.bouncycastle.jcajce;

import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

public class CompositePublicKey implements PublicKey {
    private final List<PublicKey> keys;

    public CompositePublicKey(PublicKey... publicKeyArr) {
        if (publicKeyArr == null || publicKeyArr.length == 0) {
            throw new IllegalArgumentException("at least one public key must be provided");
        }
        ArrayList arrayList = new ArrayList(publicKeyArr.length);
        for (int i10 = 0; i10 != publicKeyArr.length; i10++) {
            arrayList.add(publicKeyArr[i10]);
        }
        this.keys = Collections.unmodifiableList(arrayList);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CompositePublicKey) {
            return this.keys.equals(((CompositePublicKey) obj).keys);
        }
        return false;
    }

    public String getAlgorithm() {
        return "Composite";
    }

    public byte[] getEncoded() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (int i10 = 0; i10 != this.keys.size(); i10++) {
            aSN1EncodableVector.add(SubjectPublicKeyInfo.getInstance(this.keys.get(i10).getEncoded()));
        }
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(MiscObjectIdentifiers.id_alg_composite), (ASN1Encodable) new DERSequence(aSN1EncodableVector)).getEncoded(ASN1Encoding.DER);
        } catch (IOException e10) {
            throw new IllegalStateException("unable to encode composite key: " + e10.getMessage());
        }
    }

    public String getFormat() {
        return "X.509";
    }

    public List<PublicKey> getPublicKeys() {
        return this.keys;
    }

    public int hashCode() {
        return this.keys.hashCode();
    }
}
