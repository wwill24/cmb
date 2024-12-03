package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class ExtendedKeyUsage extends ASN1Object {
    ASN1Sequence seq;
    Hashtable usageTable = new Hashtable();

    public ExtendedKeyUsage(Vector vector) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(vector.size());
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            KeyPurposeId instance = KeyPurposeId.getInstance(elements.nextElement());
            aSN1EncodableVector.add(instance);
            this.usageTable.put(instance, instance);
        }
        this.seq = new DERSequence(aSN1EncodableVector);
    }

    private ExtendedKeyUsage(ASN1Sequence aSN1Sequence) {
        this.seq = aSN1Sequence;
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1Encodable aSN1Encodable = (ASN1Encodable) objects.nextElement();
            if (aSN1Encodable.toASN1Primitive() instanceof ASN1ObjectIdentifier) {
                this.usageTable.put(aSN1Encodable, aSN1Encodable);
            } else {
                throw new IllegalArgumentException("Only ASN1ObjectIdentifiers allowed in ExtendedKeyUsage.");
            }
        }
    }

    public ExtendedKeyUsage(KeyPurposeId keyPurposeId) {
        this.seq = new DERSequence((ASN1Encodable) keyPurposeId);
        this.usageTable.put(keyPurposeId, keyPurposeId);
    }

    public ExtendedKeyUsage(KeyPurposeId[] keyPurposeIdArr) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(keyPurposeIdArr.length);
        for (int i10 = 0; i10 != keyPurposeIdArr.length; i10++) {
            aSN1EncodableVector.add(keyPurposeIdArr[i10]);
            Hashtable hashtable = this.usageTable;
            KeyPurposeId keyPurposeId = keyPurposeIdArr[i10];
            hashtable.put(keyPurposeId, keyPurposeId);
        }
        this.seq = new DERSequence(aSN1EncodableVector);
    }

    public static ExtendedKeyUsage fromExtensions(Extensions extensions) {
        return getInstance(Extensions.getExtensionParsedValue(extensions, Extension.extendedKeyUsage));
    }

    public static ExtendedKeyUsage getInstance(Object obj) {
        if (obj instanceof ExtendedKeyUsage) {
            return (ExtendedKeyUsage) obj;
        }
        if (obj != null) {
            return new ExtendedKeyUsage(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static ExtendedKeyUsage getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z10) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z10));
    }

    public KeyPurposeId[] getUsages() {
        KeyPurposeId[] keyPurposeIdArr = new KeyPurposeId[this.seq.size()];
        Enumeration objects = this.seq.getObjects();
        int i10 = 0;
        while (objects.hasMoreElements()) {
            keyPurposeIdArr[i10] = KeyPurposeId.getInstance(objects.nextElement());
            i10++;
        }
        return keyPurposeIdArr;
    }

    public boolean hasKeyPurposeId(KeyPurposeId keyPurposeId) {
        return this.usageTable.get(keyPurposeId) != null;
    }

    public int size() {
        return this.usageTable.size();
    }

    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }
}
