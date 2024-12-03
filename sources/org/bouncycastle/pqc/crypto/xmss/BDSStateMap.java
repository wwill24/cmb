package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.pqc.crypto.xmss.OTSHashAddress;
import org.bouncycastle.util.Integers;

public class BDSStateMap implements Serializable {
    private static final long serialVersionUID = -3464451825208522308L;
    private final Map<Integer, BDS> bdsState = new TreeMap();
    private transient long maxIndex;

    BDSStateMap(long j10) {
        this.maxIndex = j10;
    }

    BDSStateMap(BDSStateMap bDSStateMap, long j10) {
        for (Integer next : bDSStateMap.bdsState.keySet()) {
            this.bdsState.put(next, new BDS(bDSStateMap.bdsState.get(next)));
        }
        this.maxIndex = j10;
    }

    BDSStateMap(XMSSMTParameters xMSSMTParameters, long j10, byte[] bArr, byte[] bArr2) {
        this.maxIndex = (1 << xMSSMTParameters.getHeight()) - 1;
        for (long j11 = 0; j11 < j10; j11++) {
            updateState(xMSSMTParameters, j11, bArr, bArr2);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.maxIndex = objectInputStream.available() != 0 ? objectInputStream.readLong() : 0;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(this.maxIndex);
    }

    /* access modifiers changed from: package-private */
    public BDS get(int i10) {
        return this.bdsState.get(Integers.valueOf(i10));
    }

    public long getMaxIndex() {
        return this.maxIndex;
    }

    public boolean isEmpty() {
        return this.bdsState.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public void put(int i10, BDS bds) {
        this.bdsState.put(Integers.valueOf(i10), bds);
    }

    /* access modifiers changed from: package-private */
    public BDS update(int i10, byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        return this.bdsState.put(Integers.valueOf(i10), this.bdsState.get(Integers.valueOf(i10)).getNextState(bArr, bArr2, oTSHashAddress));
    }

    /* access modifiers changed from: package-private */
    public void updateState(XMSSMTParameters xMSSMTParameters, long j10, byte[] bArr, byte[] bArr2) {
        long j11 = j10;
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        XMSSParameters xMSSParameters = xMSSMTParameters.getXMSSParameters();
        int height = xMSSParameters.getHeight();
        long treeIndex = XMSSUtil.getTreeIndex(j11, height);
        int leafIndex = XMSSUtil.getLeafIndex(j11, height);
        OTSHashAddress oTSHashAddress = (OTSHashAddress) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withTreeAddress(treeIndex)).withOTSAddress(leafIndex).build();
        int i10 = (1 << height) - 1;
        if (leafIndex < i10) {
            if (get(0) == null || leafIndex == 0) {
                put(0, new BDS(xMSSParameters, bArr3, bArr4, oTSHashAddress));
            }
            update(0, bArr3, bArr4, oTSHashAddress);
        }
        for (int i11 = 1; i11 < xMSSMTParameters.getLayers(); i11++) {
            int leafIndex2 = XMSSUtil.getLeafIndex(treeIndex, height);
            treeIndex = XMSSUtil.getTreeIndex(treeIndex, height);
            OTSHashAddress oTSHashAddress2 = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(i11)).withTreeAddress(treeIndex)).withOTSAddress(leafIndex2).build();
            if (this.bdsState.get(Integer.valueOf(i11)) == null || XMSSUtil.isNewBDSInitNeeded(j11, height, i11)) {
                this.bdsState.put(Integer.valueOf(i11), new BDS(xMSSParameters, bArr3, bArr4, oTSHashAddress2));
            }
            if (leafIndex2 < i10 && XMSSUtil.isNewAuthenticationPathNeeded(j11, height, i11)) {
                update(i11, bArr3, bArr4, oTSHashAddress2);
            }
        }
    }

    public BDSStateMap withWOTSDigest(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        BDSStateMap bDSStateMap = new BDSStateMap(this.maxIndex);
        for (Integer next : this.bdsState.keySet()) {
            bDSStateMap.bdsState.put(next, this.bdsState.get(next).withWOTSDigest(aSN1ObjectIdentifier));
        }
        return bDSStateMap;
    }
}
