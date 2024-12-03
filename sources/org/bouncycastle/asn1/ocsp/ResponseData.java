package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.X509Extensions;

public class ResponseData extends ASN1Object {
    private static final ASN1Integer V1 = new ASN1Integer(0);
    private ASN1GeneralizedTime producedAt;
    private ResponderID responderID;
    private Extensions responseExtensions;
    private ASN1Sequence responses;
    private ASN1Integer version;
    private boolean versionPresent;

    public ResponseData(ASN1Integer aSN1Integer, ResponderID responderID2, ASN1GeneralizedTime aSN1GeneralizedTime, ASN1Sequence aSN1Sequence, Extensions extensions) {
        this.version = aSN1Integer;
        this.responderID = responderID2;
        this.producedAt = aSN1GeneralizedTime;
        this.responses = aSN1Sequence;
        this.responseExtensions = extensions;
    }

    private ResponseData(ASN1Sequence aSN1Sequence) {
        int i10 = 0;
        if (!(aSN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject) || ((ASN1TaggedObject) aSN1Sequence.getObjectAt(0)).getTagNo() != 0) {
            this.version = V1;
        } else {
            this.versionPresent = true;
            this.version = ASN1Integer.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(0), true);
            i10 = 1;
        }
        int i11 = i10 + 1;
        this.responderID = ResponderID.getInstance(aSN1Sequence.getObjectAt(i10));
        int i12 = i11 + 1;
        this.producedAt = ASN1GeneralizedTime.getInstance(aSN1Sequence.getObjectAt(i11));
        int i13 = i12 + 1;
        this.responses = (ASN1Sequence) aSN1Sequence.getObjectAt(i12);
        if (aSN1Sequence.size() > i13) {
            this.responseExtensions = Extensions.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(i13), true);
        }
    }

    public ResponseData(ResponderID responderID2, ASN1GeneralizedTime aSN1GeneralizedTime, ASN1Sequence aSN1Sequence, Extensions extensions) {
        this(V1, responderID2, aSN1GeneralizedTime, aSN1Sequence, extensions);
    }

    public ResponseData(ResponderID responderID2, ASN1GeneralizedTime aSN1GeneralizedTime, ASN1Sequence aSN1Sequence, X509Extensions x509Extensions) {
        this(V1, responderID2, ASN1GeneralizedTime.getInstance(aSN1GeneralizedTime), aSN1Sequence, Extensions.getInstance(x509Extensions));
    }

    public static ResponseData getInstance(Object obj) {
        if (obj instanceof ResponseData) {
            return (ResponseData) obj;
        }
        if (obj != null) {
            return new ResponseData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static ResponseData getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z10) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z10));
    }

    public ASN1GeneralizedTime getProducedAt() {
        return this.producedAt;
    }

    public ResponderID getResponderID() {
        return this.responderID;
    }

    public Extensions getResponseExtensions() {
        return this.responseExtensions;
    }

    public ASN1Sequence getResponses() {
        return this.responses;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(5);
        if (this.versionPresent || !this.version.equals((ASN1Primitive) V1)) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, this.version));
        }
        aSN1EncodableVector.add(this.responderID);
        aSN1EncodableVector.add(this.producedAt);
        aSN1EncodableVector.add(this.responses);
        Extensions extensions = this.responseExtensions;
        if (extensions != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, extensions));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
