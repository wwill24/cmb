package org.bouncycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.encoders.Hex;

public class GMSSRootCalc {
    private byte[][] AuthPath;
    private int K;
    private GMSSDigestProvider digestProvider;
    private int heightOfNextSeed;
    private Vector heightOfNodes;
    private int heightOfTree;
    private int[] index;
    private int indexForNextSeed;
    private boolean isFinished;
    private boolean isInitialized;
    private int mdLength;
    private Digest messDigestTree;
    private Vector[] retain = new Vector[(this.K - 1)];
    private byte[] root = new byte[this.mdLength];
    private Vector tailStack;
    private Treehash[] treehash;

    public GMSSRootCalc(int i10, int i11, GMSSDigestProvider gMSSDigestProvider) {
        this.heightOfTree = i10;
        this.digestProvider = gMSSDigestProvider;
        Digest digest = gMSSDigestProvider.get();
        this.messDigestTree = digest;
        int digestSize = digest.getDigestSize();
        this.mdLength = digestSize;
        this.K = i11;
        this.index = new int[i10];
        int[] iArr = new int[2];
        iArr[1] = digestSize;
        iArr[0] = i10;
        this.AuthPath = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
        for (int i12 = 0; i12 < i11 - 1; i12++) {
            this.retain[i12] = new Vector();
        }
    }

    public byte[][] getAuthPath() {
        return GMSSUtils.clone(this.AuthPath);
    }

    public Vector[] getRetain() {
        return GMSSUtils.clone(this.retain);
    }

    public byte[] getRoot() {
        return Arrays.clone(this.root);
    }

    public Vector getStack() {
        Vector vector = new Vector();
        Enumeration elements = this.tailStack.elements();
        while (elements.hasMoreElements()) {
            vector.addElement(elements.nextElement());
        }
        return vector;
    }

    public byte[][] getStatByte() {
        Vector vector = this.tailStack;
        int size = vector == null ? 0 : vector.size();
        int[] iArr = new int[2];
        iArr[1] = 64;
        iArr[0] = this.heightOfTree + 1 + size;
        byte[][] bArr = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
        bArr[0] = this.root;
        int i10 = 0;
        while (i10 < this.heightOfTree) {
            int i11 = i10 + 1;
            bArr[i11] = this.AuthPath[i10];
            i10 = i11;
        }
        for (int i12 = 0; i12 < size; i12++) {
            bArr[this.heightOfTree + 1 + i12] = (byte[]) this.tailStack.elementAt(i12);
        }
        return bArr;
    }

    public int[] getStatInt() {
        Vector vector = this.tailStack;
        int size = vector == null ? 0 : vector.size();
        int i10 = this.heightOfTree;
        int[] iArr = new int[(i10 + 8 + size)];
        iArr[0] = i10;
        iArr[1] = this.mdLength;
        iArr[2] = this.K;
        iArr[3] = this.indexForNextSeed;
        iArr[4] = this.heightOfNextSeed;
        if (this.isFinished) {
            iArr[5] = 1;
        } else {
            iArr[5] = 0;
        }
        if (this.isInitialized) {
            iArr[6] = 1;
        } else {
            iArr[6] = 0;
        }
        iArr[7] = size;
        for (int i11 = 0; i11 < this.heightOfTree; i11++) {
            iArr[i11 + 8] = this.index[i11];
        }
        for (int i12 = 0; i12 < size; i12++) {
            iArr[this.heightOfTree + 8 + i12] = ((Integer) this.heightOfNodes.elementAt(i12)).intValue();
        }
        return iArr;
    }

    public Treehash[] getTreehash() {
        return GMSSUtils.clone(this.treehash);
    }

    public void initialize(Vector vector) {
        int i10;
        this.treehash = new Treehash[(this.heightOfTree - this.K)];
        int i11 = 0;
        while (true) {
            i10 = this.heightOfTree;
            if (i11 >= i10 - this.K) {
                break;
            }
            this.treehash[i11] = new Treehash(vector, i11, this.digestProvider.get());
            i11++;
        }
        this.index = new int[i10];
        int[] iArr = new int[2];
        iArr[1] = this.mdLength;
        iArr[0] = i10;
        this.AuthPath = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
        this.root = new byte[this.mdLength];
        this.tailStack = new Vector();
        this.heightOfNodes = new Vector();
        this.isInitialized = true;
        this.isFinished = false;
        for (int i12 = 0; i12 < this.heightOfTree; i12++) {
            this.index[i12] = -1;
        }
        this.retain = new Vector[(this.K - 1)];
        for (int i13 = 0; i13 < this.K - 1; i13++) {
            this.retain[i13] = new Vector();
        }
        this.indexForNextSeed = 3;
        this.heightOfNextSeed = 0;
    }

    public void initializeTreehashSeed(byte[] bArr, int i10) {
        this.treehash[i10].initializeSeed(bArr);
    }

    public String toString() {
        Vector vector = this.tailStack;
        int size = vector == null ? 0 : vector.size();
        String str = "";
        for (int i10 = 0; i10 < this.heightOfTree + 8 + size; i10++) {
            str = str + getStatInt()[i10] + " ";
        }
        for (int i11 = 0; i11 < this.heightOfTree + 1 + size; i11++) {
            str = str + new String(Hex.encode(getStatByte()[i11])) + " ";
        }
        return str + "  " + this.digestProvider.get().getDigestSize();
    }

    public void update(byte[] bArr) {
        if (this.isFinished) {
            System.out.print("Too much updates for Tree!!");
        } else if (!this.isInitialized) {
            System.err.println("GMSSRootCalc not initialized!");
        } else {
            int[] iArr = this.index;
            int i10 = iArr[0] + 1;
            iArr[0] = i10;
            if (i10 == 1) {
                System.arraycopy(bArr, 0, this.AuthPath[0], 0, this.mdLength);
            } else if (i10 == 3 && this.heightOfTree > this.K) {
                this.treehash[0].setFirstNode(bArr);
            }
            int i11 = this.index[0];
            if ((i11 - 3) % 2 == 0 && i11 >= 3 && this.heightOfTree == this.K) {
                this.retain[0].insertElementAt(bArr, 0);
            }
            if (this.index[0] == 0) {
                this.tailStack.addElement(bArr);
                this.heightOfNodes.addElement(Integers.valueOf(0));
                return;
            }
            int i12 = this.mdLength;
            byte[] bArr2 = new byte[i12];
            int i13 = i12 << 1;
            byte[] bArr3 = new byte[i13];
            System.arraycopy(bArr, 0, bArr2, 0, i12);
            int i14 = 0;
            while (this.tailStack.size() > 0 && i14 == ((Integer) this.heightOfNodes.lastElement()).intValue()) {
                System.arraycopy(this.tailStack.lastElement(), 0, bArr3, 0, this.mdLength);
                Vector vector = this.tailStack;
                vector.removeElementAt(vector.size() - 1);
                Vector vector2 = this.heightOfNodes;
                vector2.removeElementAt(vector2.size() - 1);
                int i15 = this.mdLength;
                System.arraycopy(bArr2, 0, bArr3, i15, i15);
                this.messDigestTree.update(bArr3, 0, i13);
                bArr2 = new byte[this.messDigestTree.getDigestSize()];
                this.messDigestTree.doFinal(bArr2, 0);
                i14++;
                if (i14 < this.heightOfTree) {
                    int[] iArr2 = this.index;
                    int i16 = iArr2[i14] + 1;
                    iArr2[i14] = i16;
                    if (i16 == 1) {
                        System.arraycopy(bArr2, 0, this.AuthPath[i14], 0, this.mdLength);
                    }
                    if (i14 >= this.heightOfTree - this.K) {
                        if (i14 == 0) {
                            System.out.println("M���P");
                        }
                        int i17 = this.index[i14];
                        if ((i17 - 3) % 2 == 0 && i17 >= 3) {
                            this.retain[i14 - (this.heightOfTree - this.K)].insertElementAt(bArr2, 0);
                        }
                    } else if (this.index[i14] == 3) {
                        this.treehash[i14].setFirstNode(bArr2);
                    }
                }
            }
            this.tailStack.addElement(bArr2);
            this.heightOfNodes.addElement(Integers.valueOf(i14));
            if (i14 == this.heightOfTree) {
                this.isFinished = true;
                this.isInitialized = false;
                this.root = (byte[]) this.tailStack.lastElement();
            }
        }
    }

    public void update(byte[] bArr, byte[] bArr2) {
        int i10 = this.heightOfNextSeed;
        if (i10 < this.heightOfTree - this.K && this.indexForNextSeed - 2 == this.index[0]) {
            initializeTreehashSeed(bArr, i10);
            this.heightOfNextSeed++;
            this.indexForNextSeed *= 2;
        }
        update(bArr2);
    }

    public boolean wasFinished() {
        return this.isFinished;
    }

    public boolean wasInitialized() {
        return this.isInitialized;
    }
}
