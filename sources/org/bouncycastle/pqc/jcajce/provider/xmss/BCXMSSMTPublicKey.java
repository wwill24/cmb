package org.bouncycastle.pqc.jcajce.provider.xmss;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import org.bouncycastle.pqc.crypto.util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters;
import org.bouncycastle.pqc.jcajce.interfaces.XMSSMTKey;
import org.bouncycastle.util.Arrays;

public class BCXMSSMTPublicKey implements PublicKey, XMSSMTKey {
    private static final long serialVersionUID = 3230324130542413475L;
    private transient XMSSMTPublicKeyParameters keyParams;
    private transient ASN1ObjectIdentifier treeDigest;

    public BCXMSSMTPublicKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, XMSSMTPublicKeyParameters xMSSMTPublicKeyParameters) {
        this.treeDigest = aSN1ObjectIdentifier;
        this.keyParams = xMSSMTPublicKeyParameters;
    }

    public BCXMSSMTPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        init(subjectPublicKeyInfo);
    }

    private void init(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        XMSSMTPublicKeyParameters xMSSMTPublicKeyParameters = (XMSSMTPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
        this.keyParams = xMSSMTPublicKeyParameters;
        this.treeDigest = DigestUtil.getDigestOID(xMSSMTPublicKeyParameters.getTreeDigest());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCXMSSMTPublicKey)) {
            return false;
        }
        BCXMSSMTPublicKey bCXMSSMTPublicKey = (BCXMSSMTPublicKey) obj;
        return this.treeDigest.equals((ASN1Primitive) bCXMSSMTPublicKey.treeDigest) && Arrays.areEqual(this.keyParams.toByteArray(), bCXMSSMTPublicKey.keyParams.toByteArray());
    }

    public final String getAlgorithm() {
        return "XMSSMT";
    }

    public byte[] getEncoded() {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.keyParams).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "X.509";
    }

    public int getHeight() {
        return this.keyParams.getParameters().getHeight();
    }

    /* access modifiers changed from: package-private */
    public CipherParameters getKeyParams() {
        return this.keyParams;
    }

    public int getLayers() {
        return this.keyParams.getParameters().getLayers();
    }

    public String getTreeDigest() {
        return DigestUtil.getXMSSDigestName(this.treeDigest);
    }

    public int hashCode() {
        return this.treeDigest.hashCode() + (Arrays.hashCode(this.keyParams.toByteArray()) * 37);
    }
}
