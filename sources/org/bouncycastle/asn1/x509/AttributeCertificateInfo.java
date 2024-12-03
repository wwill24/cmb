package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;

public class AttributeCertificateInfo extends ASN1Object {
    private AttCertValidityPeriod attrCertValidityPeriod;
    private ASN1Sequence attributes;
    private Extensions extensions;
    private Holder holder;
    private AttCertIssuer issuer;
    private DERBitString issuerUniqueID;
    private ASN1Integer serialNumber;
    private AlgorithmIdentifier signature;
    private ASN1Integer version;

    private AttributeCertificateInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 6 || aSN1Sequence.size() > 9) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        int i10 = 0;
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) {
            this.version = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
            i10 = 1;
        } else {
            this.version = new ASN1Integer(0);
        }
        this.holder = Holder.getInstance(aSN1Sequence.getObjectAt(i10));
        this.issuer = AttCertIssuer.getInstance(aSN1Sequence.getObjectAt(i10 + 1));
        this.signature = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i10 + 2));
        this.serialNumber = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i10 + 3));
        this.attrCertValidityPeriod = AttCertValidityPeriod.getInstance(aSN1Sequence.getObjectAt(i10 + 4));
        this.attributes = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(i10 + 5));
        for (int i11 = i10 + 6; i11 < aSN1Sequence.size(); i11++) {
            ASN1Encodable objectAt = aSN1Sequence.getObjectAt(i11);
            if (objectAt instanceof DERBitString) {
                this.issuerUniqueID = DERBitString.getInstance(aSN1Sequence.getObjectAt(i11));
            } else if ((objectAt instanceof ASN1Sequence) || (objectAt instanceof Extensions)) {
                this.extensions = Extensions.getInstance(aSN1Sequence.getObjectAt(i11));
            }
        }
    }

    public static AttributeCertificateInfo getInstance(Object obj) {
        if (obj instanceof AttributeCertificateInfo) {
            return (AttributeCertificateInfo) obj;
        }
        if (obj != null) {
            return new AttributeCertificateInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static AttributeCertificateInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z10) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z10));
    }

    public AttCertValidityPeriod getAttrCertValidityPeriod() {
        return this.attrCertValidityPeriod;
    }

    public ASN1Sequence getAttributes() {
        return this.attributes;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public Holder getHolder() {
        return this.holder;
    }

    public AttCertIssuer getIssuer() {
        return this.issuer;
    }

    public DERBitString getIssuerUniqueID() {
        return this.issuerUniqueID;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public AlgorithmIdentifier getSignature() {
        return this.signature;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(9);
        if (!this.version.hasValue(0)) {
            aSN1EncodableVector.add(this.version);
        }
        aSN1EncodableVector.add(this.holder);
        aSN1EncodableVector.add(this.issuer);
        aSN1EncodableVector.add(this.signature);
        aSN1EncodableVector.add(this.serialNumber);
        aSN1EncodableVector.add(this.attrCertValidityPeriod);
        aSN1EncodableVector.add(this.attributes);
        DERBitString dERBitString = this.issuerUniqueID;
        if (dERBitString != null) {
            aSN1EncodableVector.add(dERBitString);
        }
        Extensions extensions2 = this.extensions;
        if (extensions2 != null) {
            aSN1EncodableVector.add(extensions2);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
