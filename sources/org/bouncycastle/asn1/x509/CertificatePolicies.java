package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class CertificatePolicies extends ASN1Object {
    private final PolicyInformation[] policyInformation;

    private CertificatePolicies(ASN1Sequence aSN1Sequence) {
        this.policyInformation = new PolicyInformation[aSN1Sequence.size()];
        for (int i10 = 0; i10 != aSN1Sequence.size(); i10++) {
            this.policyInformation[i10] = PolicyInformation.getInstance(aSN1Sequence.getObjectAt(i10));
        }
    }

    public CertificatePolicies(PolicyInformation policyInformation2) {
        this.policyInformation = new PolicyInformation[]{policyInformation2};
    }

    public CertificatePolicies(PolicyInformation[] policyInformationArr) {
        this.policyInformation = copy(policyInformationArr);
    }

    private static PolicyInformation[] copy(PolicyInformation[] policyInformationArr) {
        PolicyInformation[] policyInformationArr2 = new PolicyInformation[policyInformationArr.length];
        System.arraycopy(policyInformationArr, 0, policyInformationArr2, 0, policyInformationArr.length);
        return policyInformationArr2;
    }

    public static CertificatePolicies fromExtensions(Extensions extensions) {
        return getInstance(Extensions.getExtensionParsedValue(extensions, Extension.certificatePolicies));
    }

    public static CertificatePolicies getInstance(Object obj) {
        if (obj instanceof CertificatePolicies) {
            return (CertificatePolicies) obj;
        }
        if (obj != null) {
            return new CertificatePolicies(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static CertificatePolicies getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z10) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z10));
    }

    public PolicyInformation getPolicyInformation(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        int i10 = 0;
        while (true) {
            PolicyInformation[] policyInformationArr = this.policyInformation;
            if (i10 == policyInformationArr.length) {
                return null;
            }
            if (aSN1ObjectIdentifier.equals((ASN1Primitive) policyInformationArr[i10].getPolicyIdentifier())) {
                return this.policyInformation[i10];
            }
            i10++;
        }
    }

    public PolicyInformation[] getPolicyInformation() {
        return copy(this.policyInformation);
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence((ASN1Encodable[]) this.policyInformation);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (PolicyInformation append : this.policyInformation) {
            if (stringBuffer.length() != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(append);
        }
        return "CertificatePolicies: [" + stringBuffer + "]";
    }
}
