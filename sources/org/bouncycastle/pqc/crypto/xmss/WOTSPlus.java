package org.bouncycastle.pqc.crypto.xmss;

import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.pqc.crypto.xmss.OTSHashAddress;
import org.bouncycastle.util.Arrays;

final class WOTSPlus {
    private final KeyedHashFunctions khf;
    private final WOTSPlusParameters params;
    private byte[] publicSeed;
    private byte[] secretKeySeed;

    WOTSPlus(WOTSPlusParameters wOTSPlusParameters) {
        if (wOTSPlusParameters != null) {
            this.params = wOTSPlusParameters;
            int treeDigestSize = wOTSPlusParameters.getTreeDigestSize();
            this.khf = new KeyedHashFunctions(wOTSPlusParameters.getTreeDigest(), treeDigestSize);
            this.secretKeySeed = new byte[treeDigestSize];
            this.publicSeed = new byte[treeDigestSize];
            return;
        }
        throw new NullPointerException("params == null");
    }

    private byte[] chain(byte[] bArr, int i10, int i11, OTSHashAddress oTSHashAddress) {
        int treeDigestSize = this.params.getTreeDigestSize();
        if (bArr == null) {
            throw new NullPointerException("startHash == null");
        } else if (bArr.length != treeDigestSize) {
            throw new IllegalArgumentException("startHash needs to be " + treeDigestSize + "bytes");
        } else if (oTSHashAddress == null) {
            throw new NullPointerException("otsHashAddress == null");
        } else if (oTSHashAddress.toByteArray() != null) {
            int i12 = i10 + i11;
            if (i12 > this.params.getWinternitzParameter() - 1) {
                throw new IllegalArgumentException("max chain length must not be greater than w");
            } else if (i11 == 0) {
                return bArr;
            } else {
                byte[] chain = chain(bArr, i10, i11 - 1, oTSHashAddress);
                OTSHashAddress oTSHashAddress2 = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withOTSAddress(oTSHashAddress.getOTSAddress()).withChainAddress(oTSHashAddress.getChainAddress()).withHashAddress(i12 - 1).withKeyAndMask(0)).build();
                byte[] PRF = this.khf.PRF(this.publicSeed, oTSHashAddress2.toByteArray());
                byte[] PRF2 = this.khf.PRF(this.publicSeed, ((OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress2.getLayerAddress())).withTreeAddress(oTSHashAddress2.getTreeAddress())).withOTSAddress(oTSHashAddress2.getOTSAddress()).withChainAddress(oTSHashAddress2.getChainAddress()).withHashAddress(oTSHashAddress2.getHashAddress()).withKeyAndMask(1)).build()).toByteArray());
                byte[] bArr2 = new byte[treeDigestSize];
                for (int i13 = 0; i13 < treeDigestSize; i13++) {
                    bArr2[i13] = (byte) (chain[i13] ^ PRF2[i13]);
                }
                return this.khf.F(PRF, bArr2);
            }
        } else {
            throw new NullPointerException("otsHashAddress byte array == null");
        }
    }

    private List<Integer> convertToBaseW(byte[] bArr, int i10, int i11) {
        if (bArr == null) {
            throw new NullPointerException("msg == null");
        } else if (i10 == 4 || i10 == 16) {
            int log2 = XMSSUtil.log2(i10);
            if (i11 <= (bArr.length * 8) / log2) {
                ArrayList arrayList = new ArrayList();
                for (int i12 = 0; i12 < bArr.length; i12++) {
                    for (int i13 = 8 - log2; i13 >= 0; i13 -= log2) {
                        arrayList.add(Integer.valueOf((bArr[i12] >> i13) & (i10 - 1)));
                        if (arrayList.size() == i11) {
                            return arrayList;
                        }
                    }
                }
                return arrayList;
            }
            throw new IllegalArgumentException("outLength too big");
        } else {
            throw new IllegalArgumentException("w needs to be 4 or 16");
        }
    }

    private byte[] expandSecretKeySeed(int i10) {
        if (i10 >= 0 && i10 < this.params.getLen()) {
            return this.khf.PRF(this.secretKeySeed, XMSSUtil.toBytesBigEndian((long) i10, 32));
        }
        throw new IllegalArgumentException("index out of bounds");
    }

    /* access modifiers changed from: protected */
    public KeyedHashFunctions getKhf() {
        return this.khf;
    }

    /* access modifiers changed from: protected */
    public WOTSPlusParameters getParams() {
        return this.params;
    }

    /* access modifiers changed from: protected */
    public WOTSPlusPrivateKeyParameters getPrivateKey() {
        int len = this.params.getLen();
        byte[][] bArr = new byte[len][];
        for (int i10 = 0; i10 < len; i10++) {
            bArr[i10] = expandSecretKeySeed(i10);
        }
        return new WOTSPlusPrivateKeyParameters(this.params, bArr);
    }

    /* access modifiers changed from: package-private */
    public WOTSPlusPublicKeyParameters getPublicKey(OTSHashAddress oTSHashAddress) {
        if (oTSHashAddress != null) {
            byte[][] bArr = new byte[this.params.getLen()][];
            for (int i10 = 0; i10 < this.params.getLen(); i10++) {
                oTSHashAddress = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withOTSAddress(oTSHashAddress.getOTSAddress()).withChainAddress(i10).withHashAddress(oTSHashAddress.getHashAddress()).withKeyAndMask(oTSHashAddress.getKeyAndMask())).build();
                bArr[i10] = chain(expandSecretKeySeed(i10), 0, this.params.getWinternitzParameter() - 1, oTSHashAddress);
            }
            return new WOTSPlusPublicKeyParameters(this.params, bArr);
        }
        throw new NullPointerException("otsHashAddress == null");
    }

    /* access modifiers changed from: package-private */
    public WOTSPlusPublicKeyParameters getPublicKeyFromSignature(byte[] bArr, WOTSPlusSignature wOTSPlusSignature, OTSHashAddress oTSHashAddress) {
        if (bArr == null) {
            throw new NullPointerException("messageDigest == null");
        } else if (bArr.length != this.params.getTreeDigestSize()) {
            throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
        } else if (wOTSPlusSignature == null) {
            throw new NullPointerException("signature == null");
        } else if (oTSHashAddress != null) {
            List<Integer> convertToBaseW = convertToBaseW(bArr, this.params.getWinternitzParameter(), this.params.getLen1());
            int i10 = 0;
            for (int i11 = 0; i11 < this.params.getLen1(); i11++) {
                i10 += (this.params.getWinternitzParameter() - 1) - convertToBaseW.get(i11).intValue();
            }
            convertToBaseW.addAll(convertToBaseW(XMSSUtil.toBytesBigEndian((long) (i10 << (8 - ((this.params.getLen2() * XMSSUtil.log2(this.params.getWinternitzParameter())) % 8))), (int) Math.ceil(((double) (this.params.getLen2() * XMSSUtil.log2(this.params.getWinternitzParameter()))) / 8.0d)), this.params.getWinternitzParameter(), this.params.getLen2()));
            byte[][] bArr2 = new byte[this.params.getLen()][];
            for (int i12 = 0; i12 < this.params.getLen(); i12++) {
                oTSHashAddress = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withOTSAddress(oTSHashAddress.getOTSAddress()).withChainAddress(i12).withHashAddress(oTSHashAddress.getHashAddress()).withKeyAndMask(oTSHashAddress.getKeyAndMask())).build();
                bArr2[i12] = chain(wOTSPlusSignature.toByteArray()[i12], convertToBaseW.get(i12).intValue(), (this.params.getWinternitzParameter() - 1) - convertToBaseW.get(i12).intValue(), oTSHashAddress);
            }
            return new WOTSPlusPublicKeyParameters(this.params, bArr2);
        } else {
            throw new NullPointerException("otsHashAddress == null");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] getPublicSeed() {
        return Arrays.clone(this.publicSeed);
    }

    /* access modifiers changed from: protected */
    public byte[] getSecretKeySeed() {
        return Arrays.clone(this.secretKeySeed);
    }

    /* access modifiers changed from: protected */
    public byte[] getWOTSPlusSecretKey(byte[] bArr, OTSHashAddress oTSHashAddress) {
        return this.khf.PRF(bArr, ((OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withOTSAddress(oTSHashAddress.getOTSAddress()).build()).toByteArray());
    }

    /* access modifiers changed from: package-private */
    public void importKeys(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            throw new NullPointerException("secretKeySeed == null");
        } else if (bArr.length != this.params.getTreeDigestSize()) {
            throw new IllegalArgumentException("size of secretKeySeed needs to be equal to size of digest");
        } else if (bArr2 == null) {
            throw new NullPointerException("publicSeed == null");
        } else if (bArr2.length == this.params.getTreeDigestSize()) {
            this.secretKeySeed = bArr;
            this.publicSeed = bArr2;
        } else {
            throw new IllegalArgumentException("size of publicSeed needs to be equal to size of digest");
        }
    }

    /* access modifiers changed from: package-private */
    public WOTSPlusSignature sign(byte[] bArr, OTSHashAddress oTSHashAddress) {
        if (bArr == null) {
            throw new NullPointerException("messageDigest == null");
        } else if (bArr.length != this.params.getTreeDigestSize()) {
            throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
        } else if (oTSHashAddress != null) {
            List<Integer> convertToBaseW = convertToBaseW(bArr, this.params.getWinternitzParameter(), this.params.getLen1());
            int i10 = 0;
            for (int i11 = 0; i11 < this.params.getLen1(); i11++) {
                i10 += (this.params.getWinternitzParameter() - 1) - convertToBaseW.get(i11).intValue();
            }
            convertToBaseW.addAll(convertToBaseW(XMSSUtil.toBytesBigEndian((long) (i10 << (8 - ((this.params.getLen2() * XMSSUtil.log2(this.params.getWinternitzParameter())) % 8))), (int) Math.ceil(((double) (this.params.getLen2() * XMSSUtil.log2(this.params.getWinternitzParameter()))) / 8.0d)), this.params.getWinternitzParameter(), this.params.getLen2()));
            byte[][] bArr2 = new byte[this.params.getLen()][];
            for (int i12 = 0; i12 < this.params.getLen(); i12++) {
                oTSHashAddress = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withOTSAddress(oTSHashAddress.getOTSAddress()).withChainAddress(i12).withHashAddress(oTSHashAddress.getHashAddress()).withKeyAndMask(oTSHashAddress.getKeyAndMask())).build();
                bArr2[i12] = chain(expandSecretKeySeed(i12), 0, convertToBaseW.get(i12).intValue(), oTSHashAddress);
            }
            return new WOTSPlusSignature(this.params, bArr2);
        } else {
            throw new NullPointerException("otsHashAddress == null");
        }
    }
}
