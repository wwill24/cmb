package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.crypto.StateAwareMessageSigner;
import org.bouncycastle.pqc.crypto.xmss.OTSHashAddress;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTSignature;
import org.bouncycastle.pqc.crypto.xmss.XMSSReducedSignature;
import org.bouncycastle.util.Arrays;

public class XMSSMTSigner implements StateAwareMessageSigner {
    private boolean hasGenerated;
    private boolean initSign;
    private XMSSMTParameters params;
    private XMSSMTPrivateKeyParameters privateKey;
    private XMSSMTPublicKeyParameters publicKey;
    private WOTSPlus wotsPlus;
    private XMSSParameters xmssParams;

    private WOTSPlusSignature wotsSign(byte[] bArr, OTSHashAddress oTSHashAddress) {
        if (bArr.length != this.params.getTreeDigestSize()) {
            throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
        } else if (oTSHashAddress != null) {
            WOTSPlus wOTSPlus = this.wotsPlus;
            wOTSPlus.importKeys(wOTSPlus.getWOTSPlusSecretKey(this.privateKey.getSecretKeySeed(), oTSHashAddress), this.privateKey.getPublicSeed());
            return this.wotsPlus.sign(bArr, oTSHashAddress);
        } else {
            throw new NullPointerException("otsHashAddress == null");
        }
    }

    public byte[] generateSignature(byte[] bArr) {
        byte[] byteArray;
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            throw new NullPointerException("message == null");
        } else if (this.initSign) {
            XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters = this.privateKey;
            if (xMSSMTPrivateKeyParameters != null) {
                synchronized (xMSSMTPrivateKeyParameters) {
                    if (this.privateKey.getUsagesRemaining() <= 0) {
                        throw new IllegalStateException("no usages of private key remaining");
                    } else if (!this.privateKey.getBDSState().isEmpty()) {
                        try {
                            BDSStateMap bDSState = this.privateKey.getBDSState();
                            long index = this.privateKey.getIndex();
                            this.params.getHeight();
                            int height = this.xmssParams.getHeight();
                            if (this.privateKey.getUsagesRemaining() > 0) {
                                byte[] PRF = this.wotsPlus.getKhf().PRF(this.privateKey.getSecretKeyPRF(), XMSSUtil.toBytesBigEndian(index, 32));
                                byte[] HMsg = this.wotsPlus.getKhf().HMsg(Arrays.concatenate(PRF, this.privateKey.getRoot(), XMSSUtil.toBytesBigEndian(index, this.params.getTreeDigestSize())), bArr2);
                                this.hasGenerated = true;
                                XMSSMTSignature build = new XMSSMTSignature.Builder(this.params).withIndex(index).withRandom(PRF).build();
                                long treeIndex = XMSSUtil.getTreeIndex(index, height);
                                int leafIndex = XMSSUtil.getLeafIndex(index, height);
                                this.wotsPlus.importKeys(new byte[this.params.getTreeDigestSize()], this.privateKey.getPublicSeed());
                                OTSHashAddress oTSHashAddress = (OTSHashAddress) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withTreeAddress(treeIndex)).withOTSAddress(leafIndex).build();
                                if (bDSState.get(0) == null || leafIndex == 0) {
                                    bDSState.put(0, new BDS(this.xmssParams, this.privateKey.getPublicSeed(), this.privateKey.getSecretKeySeed(), oTSHashAddress));
                                }
                                build.getReducedSignatures().add(new XMSSReducedSignature.Builder(this.xmssParams).withWOTSPlusSignature(wotsSign(HMsg, oTSHashAddress)).withAuthPath(bDSState.get(0).getAuthenticationPath()).build());
                                for (int i10 = 1; i10 < this.params.getLayers(); i10++) {
                                    XMSSNode root = bDSState.get(i10 - 1).getRoot();
                                    int leafIndex2 = XMSSUtil.getLeafIndex(treeIndex, height);
                                    treeIndex = XMSSUtil.getTreeIndex(treeIndex, height);
                                    OTSHashAddress oTSHashAddress2 = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(i10)).withTreeAddress(treeIndex)).withOTSAddress(leafIndex2).build();
                                    WOTSPlusSignature wotsSign = wotsSign(root.getValue(), oTSHashAddress2);
                                    if (bDSState.get(i10) == null || XMSSUtil.isNewBDSInitNeeded(index, height, i10)) {
                                        bDSState.put(i10, new BDS(this.xmssParams, this.privateKey.getPublicSeed(), this.privateKey.getSecretKeySeed(), oTSHashAddress2));
                                    }
                                    build.getReducedSignatures().add(new XMSSReducedSignature.Builder(this.xmssParams).withWOTSPlusSignature(wotsSign).withAuthPath(bDSState.get(i10).getAuthenticationPath()).build());
                                }
                                byteArray = build.toByteArray();
                            } else {
                                throw new IllegalStateException("index out of bounds");
                            }
                        } finally {
                            this.privateKey.rollKey();
                        }
                    } else {
                        throw new IllegalStateException("not initialized");
                    }
                }
                return byteArray;
            }
            throw new IllegalStateException("signing key no longer usable");
        } else {
            throw new IllegalStateException("signer not initialized for signature generation");
        }
    }

    public AsymmetricKeyParameter getUpdatedPrivateKey() {
        if (this.hasGenerated) {
            XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters = this.privateKey;
            this.privateKey = null;
            return xMSSMTPrivateKeyParameters;
        }
        XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters2 = this.privateKey;
        if (xMSSMTPrivateKeyParameters2 != null) {
            this.privateKey = xMSSMTPrivateKeyParameters2.getNextKey();
        }
        return xMSSMTPrivateKeyParameters2;
    }

    public long getUsagesRemaining() {
        return this.privateKey.getUsagesRemaining();
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        XMSSMTParameters xMSSMTParameters;
        if (z10) {
            this.initSign = true;
            this.hasGenerated = false;
            XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters = (XMSSMTPrivateKeyParameters) cipherParameters;
            this.privateKey = xMSSMTPrivateKeyParameters;
            xMSSMTParameters = xMSSMTPrivateKeyParameters.getParameters();
        } else {
            this.initSign = false;
            XMSSMTPublicKeyParameters xMSSMTPublicKeyParameters = (XMSSMTPublicKeyParameters) cipherParameters;
            this.publicKey = xMSSMTPublicKeyParameters;
            xMSSMTParameters = xMSSMTPublicKeyParameters.getParameters();
        }
        this.params = xMSSMTParameters;
        this.xmssParams = xMSSMTParameters.getXMSSParameters();
        this.wotsPlus = this.params.getWOTSPlus();
    }

    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            throw new NullPointerException("message == null");
        } else if (bArr2 == null) {
            throw new NullPointerException("signature == null");
        } else if (this.publicKey != null) {
            XMSSMTSignature build = new XMSSMTSignature.Builder(this.params).withSignature(bArr2).build();
            byte[] HMsg = this.wotsPlus.getKhf().HMsg(Arrays.concatenate(build.getRandom(), this.publicKey.getRoot(), XMSSUtil.toBytesBigEndian(build.getIndex(), this.params.getTreeDigestSize())), bArr);
            long index = build.getIndex();
            int height = this.xmssParams.getHeight();
            long treeIndex = XMSSUtil.getTreeIndex(index, height);
            int leafIndex = XMSSUtil.getLeafIndex(index, height);
            this.wotsPlus.importKeys(new byte[this.params.getTreeDigestSize()], this.publicKey.getPublicSeed());
            XMSSReducedSignature xMSSReducedSignature = build.getReducedSignatures().get(0);
            XMSSNode rootNodeFromSignature = XMSSVerifierUtil.getRootNodeFromSignature(this.wotsPlus, height, HMsg, xMSSReducedSignature, (OTSHashAddress) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withTreeAddress(treeIndex)).withOTSAddress(leafIndex).build(), leafIndex);
            int i10 = 1;
            while (i10 < this.params.getLayers()) {
                int leafIndex2 = XMSSUtil.getLeafIndex(treeIndex, height);
                long treeIndex2 = XMSSUtil.getTreeIndex(treeIndex, height);
                int i11 = height;
                rootNodeFromSignature = XMSSVerifierUtil.getRootNodeFromSignature(this.wotsPlus, i11, rootNodeFromSignature.getValue(), build.getReducedSignatures().get(i10), (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(i10)).withTreeAddress(treeIndex2)).withOTSAddress(leafIndex2).build(), leafIndex2);
                i10++;
                treeIndex = treeIndex2;
            }
            return Arrays.constantTimeAreEqual(rootNodeFromSignature.getValue(), this.publicKey.getRoot());
        } else {
            throw new NullPointerException("publicKey == null");
        }
    }
}
