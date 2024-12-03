package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.pqc.crypto.xmss.HashTreeAddress;
import org.bouncycastle.pqc.crypto.xmss.LTreeAddress;
import org.bouncycastle.pqc.crypto.xmss.XMSSAddress;

class XMSSNodeUtil {
    XMSSNodeUtil() {
    }

    static XMSSNode lTree(WOTSPlus wOTSPlus, WOTSPlusPublicKeyParameters wOTSPlusPublicKeyParameters, LTreeAddress lTreeAddress) {
        double d10;
        if (wOTSPlusPublicKeyParameters == null) {
            throw new NullPointerException("publicKey == null");
        } else if (lTreeAddress != null) {
            int len = wOTSPlus.getParams().getLen();
            byte[][] byteArray = wOTSPlusPublicKeyParameters.toByteArray();
            XMSSNode[] xMSSNodeArr = new XMSSNode[byteArray.length];
            for (int i10 = 0; i10 < byteArray.length; i10++) {
                xMSSNodeArr[i10] = new XMSSNode(0, byteArray[i10]);
            }
            XMSSAddress.Builder withKeyAndMask = ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(lTreeAddress.getLayerAddress())).withTreeAddress(lTreeAddress.getTreeAddress())).withLTreeAddress(lTreeAddress.getLTreeAddress()).withTreeHeight(0).withTreeIndex(lTreeAddress.getTreeIndex()).withKeyAndMask(lTreeAddress.getKeyAndMask());
            while (true) {
                LTreeAddress lTreeAddress2 = (LTreeAddress) ((LTreeAddress.Builder) withKeyAndMask).build();
                if (len <= 1) {
                    return xMSSNodeArr[0];
                }
                int i11 = 0;
                while (true) {
                    d10 = (double) (len / 2);
                    if (i11 >= ((int) Math.floor(d10))) {
                        break;
                    }
                    lTreeAddress2 = (LTreeAddress) ((LTreeAddress.Builder) ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(lTreeAddress2.getLayerAddress())).withTreeAddress(lTreeAddress2.getTreeAddress())).withLTreeAddress(lTreeAddress2.getLTreeAddress()).withTreeHeight(lTreeAddress2.getTreeHeight()).withTreeIndex(i11).withKeyAndMask(lTreeAddress2.getKeyAndMask())).build();
                    int i12 = i11 * 2;
                    xMSSNodeArr[i11] = randomizeHash(wOTSPlus, xMSSNodeArr[i12], xMSSNodeArr[i12 + 1], lTreeAddress2);
                    i11++;
                }
                if (len % 2 == 1) {
                    xMSSNodeArr[(int) Math.floor(d10)] = xMSSNodeArr[len - 1];
                }
                len = (int) Math.ceil(((double) len) / 2.0d);
                withKeyAndMask = ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(lTreeAddress2.getLayerAddress())).withTreeAddress(lTreeAddress2.getTreeAddress())).withLTreeAddress(lTreeAddress2.getLTreeAddress()).withTreeHeight(lTreeAddress2.getTreeHeight() + 1).withTreeIndex(lTreeAddress2.getTreeIndex()).withKeyAndMask(lTreeAddress2.getKeyAndMask());
            }
        } else {
            throw new NullPointerException("address == null");
        }
    }

    static XMSSNode randomizeHash(WOTSPlus wOTSPlus, XMSSNode xMSSNode, XMSSNode xMSSNode2, XMSSAddress xMSSAddress) {
        if (xMSSNode == null) {
            throw new NullPointerException("left == null");
        } else if (xMSSNode2 == null) {
            throw new NullPointerException("right == null");
        } else if (xMSSNode.getHeight() != xMSSNode2.getHeight()) {
            throw new IllegalStateException("height of both nodes must be equal");
        } else if (xMSSAddress != null) {
            byte[] publicSeed = wOTSPlus.getPublicSeed();
            if (xMSSAddress instanceof LTreeAddress) {
                LTreeAddress lTreeAddress = (LTreeAddress) xMSSAddress;
                xMSSAddress = (LTreeAddress) ((LTreeAddress.Builder) ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(lTreeAddress.getLayerAddress())).withTreeAddress(lTreeAddress.getTreeAddress())).withLTreeAddress(lTreeAddress.getLTreeAddress()).withTreeHeight(lTreeAddress.getTreeHeight()).withTreeIndex(lTreeAddress.getTreeIndex()).withKeyAndMask(0)).build();
            } else if (xMSSAddress instanceof HashTreeAddress) {
                HashTreeAddress hashTreeAddress = (HashTreeAddress) xMSSAddress;
                xMSSAddress = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress.getLayerAddress())).withTreeAddress(hashTreeAddress.getTreeAddress())).withTreeHeight(hashTreeAddress.getTreeHeight()).withTreeIndex(hashTreeAddress.getTreeIndex()).withKeyAndMask(0)).build();
            }
            byte[] PRF = wOTSPlus.getKhf().PRF(publicSeed, xMSSAddress.toByteArray());
            if (xMSSAddress instanceof LTreeAddress) {
                LTreeAddress lTreeAddress2 = (LTreeAddress) xMSSAddress;
                xMSSAddress = (LTreeAddress) ((LTreeAddress.Builder) ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(lTreeAddress2.getLayerAddress())).withTreeAddress(lTreeAddress2.getTreeAddress())).withLTreeAddress(lTreeAddress2.getLTreeAddress()).withTreeHeight(lTreeAddress2.getTreeHeight()).withTreeIndex(lTreeAddress2.getTreeIndex()).withKeyAndMask(1)).build();
            } else if (xMSSAddress instanceof HashTreeAddress) {
                HashTreeAddress hashTreeAddress2 = (HashTreeAddress) xMSSAddress;
                xMSSAddress = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress2.getLayerAddress())).withTreeAddress(hashTreeAddress2.getTreeAddress())).withTreeHeight(hashTreeAddress2.getTreeHeight()).withTreeIndex(hashTreeAddress2.getTreeIndex()).withKeyAndMask(1)).build();
            }
            byte[] PRF2 = wOTSPlus.getKhf().PRF(publicSeed, xMSSAddress.toByteArray());
            if (xMSSAddress instanceof LTreeAddress) {
                LTreeAddress lTreeAddress3 = (LTreeAddress) xMSSAddress;
                xMSSAddress = (LTreeAddress) ((LTreeAddress.Builder) ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(lTreeAddress3.getLayerAddress())).withTreeAddress(lTreeAddress3.getTreeAddress())).withLTreeAddress(lTreeAddress3.getLTreeAddress()).withTreeHeight(lTreeAddress3.getTreeHeight()).withTreeIndex(lTreeAddress3.getTreeIndex()).withKeyAndMask(2)).build();
            } else if (xMSSAddress instanceof HashTreeAddress) {
                HashTreeAddress hashTreeAddress3 = (HashTreeAddress) xMSSAddress;
                xMSSAddress = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress3.getLayerAddress())).withTreeAddress(hashTreeAddress3.getTreeAddress())).withTreeHeight(hashTreeAddress3.getTreeHeight()).withTreeIndex(hashTreeAddress3.getTreeIndex()).withKeyAndMask(2)).build();
            }
            byte[] PRF3 = wOTSPlus.getKhf().PRF(publicSeed, xMSSAddress.toByteArray());
            int treeDigestSize = wOTSPlus.getParams().getTreeDigestSize();
            byte[] bArr = new byte[(treeDigestSize * 2)];
            for (int i10 = 0; i10 < treeDigestSize; i10++) {
                bArr[i10] = (byte) (xMSSNode.getValue()[i10] ^ PRF2[i10]);
            }
            for (int i11 = 0; i11 < treeDigestSize; i11++) {
                bArr[i11 + treeDigestSize] = (byte) (xMSSNode2.getValue()[i11] ^ PRF3[i11]);
            }
            return new XMSSNode(xMSSNode.getHeight(), wOTSPlus.getKhf().H(PRF, bArr));
        } else {
            throw new NullPointerException("address == null");
        }
    }
}
