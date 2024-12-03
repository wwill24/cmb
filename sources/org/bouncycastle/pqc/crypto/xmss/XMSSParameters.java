package org.bouncycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Integers;

public final class XMSSParameters {
    private static final Map<Integer, XMSSParameters> paramsLookupTable;
    private final int height;

    /* renamed from: k  reason: collision with root package name */
    private final int f24054k;
    private final XMSSOid oid;
    private final String treeDigest;
    private final ASN1ObjectIdentifier treeDigestOID;
    private final int treeDigestSize;
    private final int winternitzParameter;
    private final WOTSPlusParameters wotsPlusParams;

    static {
        HashMap hashMap = new HashMap();
        Integer valueOf = Integers.valueOf(1);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_sha256;
        hashMap.put(valueOf, new XMSSParameters(10, aSN1ObjectIdentifier));
        hashMap.put(Integers.valueOf(2), new XMSSParameters(16, aSN1ObjectIdentifier));
        hashMap.put(Integers.valueOf(3), new XMSSParameters(20, aSN1ObjectIdentifier));
        Integer valueOf2 = Integers.valueOf(4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_sha512;
        hashMap.put(valueOf2, new XMSSParameters(10, aSN1ObjectIdentifier2));
        hashMap.put(Integers.valueOf(5), new XMSSParameters(16, aSN1ObjectIdentifier2));
        hashMap.put(Integers.valueOf(6), new XMSSParameters(20, aSN1ObjectIdentifier2));
        Integer valueOf3 = Integers.valueOf(7);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_shake128;
        hashMap.put(valueOf3, new XMSSParameters(10, aSN1ObjectIdentifier3));
        hashMap.put(Integers.valueOf(8), new XMSSParameters(16, aSN1ObjectIdentifier3));
        hashMap.put(Integers.valueOf(9), new XMSSParameters(20, aSN1ObjectIdentifier3));
        Integer valueOf4 = Integers.valueOf(10);
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_shake256;
        hashMap.put(valueOf4, new XMSSParameters(10, aSN1ObjectIdentifier4));
        hashMap.put(Integers.valueOf(11), new XMSSParameters(16, aSN1ObjectIdentifier4));
        hashMap.put(Integers.valueOf(12), new XMSSParameters(20, aSN1ObjectIdentifier4));
        paramsLookupTable = Collections.unmodifiableMap(hashMap);
    }

    public XMSSParameters(int i10, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (i10 < 2) {
            throw new IllegalArgumentException("height must be >= 2");
        } else if (aSN1ObjectIdentifier != null) {
            this.height = i10;
            this.f24054k = determineMinK();
            String digestName = DigestUtil.getDigestName(aSN1ObjectIdentifier);
            this.treeDigest = digestName;
            this.treeDigestOID = aSN1ObjectIdentifier;
            WOTSPlusParameters wOTSPlusParameters = new WOTSPlusParameters(aSN1ObjectIdentifier);
            this.wotsPlusParams = wOTSPlusParameters;
            int treeDigestSize2 = wOTSPlusParameters.getTreeDigestSize();
            this.treeDigestSize = treeDigestSize2;
            int winternitzParameter2 = wOTSPlusParameters.getWinternitzParameter();
            this.winternitzParameter = winternitzParameter2;
            this.oid = DefaultXMSSOid.lookup(digestName, treeDigestSize2, winternitzParameter2, wOTSPlusParameters.getLen(), i10);
        } else {
            throw new NullPointerException("digest == null");
        }
    }

    public XMSSParameters(int i10, Digest digest) {
        this(i10, DigestUtil.getDigestOID(digest.getAlgorithmName()));
    }

    private int determineMinK() {
        int i10 = 2;
        while (true) {
            int i11 = this.height;
            if (i10 > i11) {
                throw new IllegalStateException("should never happen...");
            } else if ((i11 - i10) % 2 == 0) {
                return i10;
            } else {
                i10++;
            }
        }
    }

    public static XMSSParameters lookupByOID(int i10) {
        return paramsLookupTable.get(Integers.valueOf(i10));
    }

    public int getHeight() {
        return this.height;
    }

    /* access modifiers changed from: package-private */
    public int getK() {
        return this.f24054k;
    }

    /* access modifiers changed from: package-private */
    public int getLen() {
        return this.wotsPlusParams.getLen();
    }

    /* access modifiers changed from: package-private */
    public XMSSOid getOid() {
        return this.oid;
    }

    /* access modifiers changed from: package-private */
    public String getTreeDigest() {
        return this.treeDigest;
    }

    public ASN1ObjectIdentifier getTreeDigestOID() {
        return this.treeDigestOID;
    }

    public int getTreeDigestSize() {
        return this.treeDigestSize;
    }

    /* access modifiers changed from: package-private */
    public WOTSPlus getWOTSPlus() {
        return new WOTSPlus(this.wotsPlusParams);
    }

    /* access modifiers changed from: package-private */
    public int getWinternitzParameter() {
        return this.winternitzParameter;
    }
}
