package org.bouncycastle.pqc.crypto.gmss;

import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.util.Arrays;

class GMSSUtils {
    GMSSUtils() {
    }

    static Vector[] clone(Vector[] vectorArr) {
        if (vectorArr == null) {
            return null;
        }
        Vector[] vectorArr2 = new Vector[vectorArr.length];
        for (int i10 = 0; i10 != vectorArr.length; i10++) {
            vectorArr2[i10] = new Vector();
            Enumeration elements = vectorArr[i10].elements();
            while (elements.hasMoreElements()) {
                vectorArr2[i10].addElement(elements.nextElement());
            }
        }
        return vectorArr2;
    }

    static GMSSLeaf[] clone(GMSSLeaf[] gMSSLeafArr) {
        if (gMSSLeafArr == null) {
            return null;
        }
        GMSSLeaf[] gMSSLeafArr2 = new GMSSLeaf[gMSSLeafArr.length];
        System.arraycopy(gMSSLeafArr, 0, gMSSLeafArr2, 0, gMSSLeafArr.length);
        return gMSSLeafArr2;
    }

    static GMSSRootCalc[] clone(GMSSRootCalc[] gMSSRootCalcArr) {
        if (gMSSRootCalcArr == null) {
            return null;
        }
        GMSSRootCalc[] gMSSRootCalcArr2 = new GMSSRootCalc[gMSSRootCalcArr.length];
        System.arraycopy(gMSSRootCalcArr, 0, gMSSRootCalcArr2, 0, gMSSRootCalcArr.length);
        return gMSSRootCalcArr2;
    }

    static GMSSRootSig[] clone(GMSSRootSig[] gMSSRootSigArr) {
        if (gMSSRootSigArr == null) {
            return null;
        }
        GMSSRootSig[] gMSSRootSigArr2 = new GMSSRootSig[gMSSRootSigArr.length];
        System.arraycopy(gMSSRootSigArr, 0, gMSSRootSigArr2, 0, gMSSRootSigArr.length);
        return gMSSRootSigArr2;
    }

    static Treehash[] clone(Treehash[] treehashArr) {
        if (treehashArr == null) {
            return null;
        }
        Treehash[] treehashArr2 = new Treehash[treehashArr.length];
        System.arraycopy(treehashArr, 0, treehashArr2, 0, treehashArr.length);
        return treehashArr2;
    }

    static byte[][] clone(byte[][] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[][] bArr2 = new byte[bArr.length][];
        for (int i10 = 0; i10 != bArr.length; i10++) {
            bArr2[i10] = Arrays.clone(bArr[i10]);
        }
        return bArr2;
    }

    static Vector[][] clone(Vector[][] vectorArr) {
        if (vectorArr == null) {
            return null;
        }
        Vector[][] vectorArr2 = new Vector[vectorArr.length][];
        for (int i10 = 0; i10 != vectorArr.length; i10++) {
            vectorArr2[i10] = clone(vectorArr[i10]);
        }
        return vectorArr2;
    }

    static Treehash[][] clone(Treehash[][] treehashArr) {
        if (treehashArr == null) {
            return null;
        }
        Treehash[][] treehashArr2 = new Treehash[treehashArr.length][];
        for (int i10 = 0; i10 != treehashArr.length; i10++) {
            treehashArr2[i10] = clone(treehashArr[i10]);
        }
        return treehashArr2;
    }

    static byte[][][] clone(byte[][][] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[][][] bArr2 = new byte[bArr.length][][];
        for (int i10 = 0; i10 != bArr.length; i10++) {
            bArr2[i10] = clone(bArr[i10]);
        }
        return bArr2;
    }
}
