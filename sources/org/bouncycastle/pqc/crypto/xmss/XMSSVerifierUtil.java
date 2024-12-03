package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.pqc.crypto.xmss.HashTreeAddress;
import org.bouncycastle.pqc.crypto.xmss.LTreeAddress;

class XMSSVerifierUtil {
    XMSSVerifierUtil() {
    }

    static XMSSNode getRootNodeFromSignature(WOTSPlus wOTSPlus, int i10, byte[] bArr, XMSSReducedSignature xMSSReducedSignature, OTSHashAddress oTSHashAddress, int i11) {
        if (bArr.length != wOTSPlus.getParams().getTreeDigestSize()) {
            throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
        } else if (xMSSReducedSignature == null) {
            throw new NullPointerException("signature == null");
        } else if (oTSHashAddress != null) {
            HashTreeAddress hashTreeAddress = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withTreeIndex(oTSHashAddress.getOTSAddress()).build();
            XMSSNode[] xMSSNodeArr = new XMSSNode[2];
            xMSSNodeArr[0] = XMSSNodeUtil.lTree(wOTSPlus, wOTSPlus.getPublicKeyFromSignature(bArr, xMSSReducedSignature.getWOTSPlusSignature(), oTSHashAddress), (LTreeAddress) ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withLTreeAddress(oTSHashAddress.getOTSAddress()).build());
            for (int i12 = 0; i12 < i10; i12++) {
                HashTreeAddress hashTreeAddress2 = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress.getLayerAddress())).withTreeAddress(hashTreeAddress.getTreeAddress())).withTreeHeight(i12).withTreeIndex(hashTreeAddress.getTreeIndex()).withKeyAndMask(hashTreeAddress.getKeyAndMask())).build();
                if (Math.floor((double) (i11 / (1 << i12))) % 2.0d == 0.0d) {
                    hashTreeAddress = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress2.getLayerAddress())).withTreeAddress(hashTreeAddress2.getTreeAddress())).withTreeHeight(hashTreeAddress2.getTreeHeight()).withTreeIndex(hashTreeAddress2.getTreeIndex() / 2).withKeyAndMask(hashTreeAddress2.getKeyAndMask())).build();
                    XMSSNode randomizeHash = XMSSNodeUtil.randomizeHash(wOTSPlus, xMSSNodeArr[0], xMSSReducedSignature.getAuthPath().get(i12), hashTreeAddress);
                    xMSSNodeArr[1] = randomizeHash;
                    xMSSNodeArr[1] = new XMSSNode(randomizeHash.getHeight() + 1, xMSSNodeArr[1].getValue());
                } else {
                    hashTreeAddress = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress2.getLayerAddress())).withTreeAddress(hashTreeAddress2.getTreeAddress())).withTreeHeight(hashTreeAddress2.getTreeHeight()).withTreeIndex((hashTreeAddress2.getTreeIndex() - 1) / 2).withKeyAndMask(hashTreeAddress2.getKeyAndMask())).build();
                    XMSSNode randomizeHash2 = XMSSNodeUtil.randomizeHash(wOTSPlus, xMSSReducedSignature.getAuthPath().get(i12), xMSSNodeArr[0], hashTreeAddress);
                    xMSSNodeArr[1] = randomizeHash2;
                    xMSSNodeArr[1] = new XMSSNode(randomizeHash2.getHeight() + 1, xMSSNodeArr[1].getValue());
                }
                xMSSNodeArr[0] = xMSSNodeArr[1];
            }
            return xMSSNodeArr[0];
        } else {
            throw new NullPointerException("otsHashAddress == null");
        }
    }
}
