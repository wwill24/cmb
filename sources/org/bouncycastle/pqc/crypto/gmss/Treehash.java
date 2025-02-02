package org.bouncycastle.pqc.crypto.gmss;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Vector;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.encoders.Hex;

public class Treehash {
    private byte[] firstNode;
    private int firstNodeHeight;
    private Vector heightOfNodes;
    private boolean isFinished;
    private boolean isInitialized;
    private int maxHeight;
    private Digest messDigestTree;
    private byte[] seedActive;
    private boolean seedInitialized;
    private byte[] seedNext;
    private int tailLength;
    private Vector tailStack;

    public Treehash(Vector vector, int i10, Digest digest) {
        this.tailStack = vector;
        this.maxHeight = i10;
        this.firstNode = null;
        this.isInitialized = false;
        this.isFinished = false;
        this.seedInitialized = false;
        this.messDigestTree = digest;
        this.seedNext = new byte[digest.getDigestSize()];
        this.seedActive = new byte[this.messDigestTree.getDigestSize()];
    }

    public Treehash(Digest digest, byte[][] bArr, int[] iArr) {
        this.messDigestTree = digest;
        this.maxHeight = iArr[0];
        this.tailLength = iArr[1];
        this.firstNodeHeight = iArr[2];
        if (iArr[3] == 1) {
            this.isFinished = true;
        } else {
            this.isFinished = false;
        }
        if (iArr[4] == 1) {
            this.isInitialized = true;
        } else {
            this.isInitialized = false;
        }
        if (iArr[5] == 1) {
            this.seedInitialized = true;
        } else {
            this.seedInitialized = false;
        }
        this.heightOfNodes = new Vector();
        for (int i10 = 0; i10 < this.tailLength; i10++) {
            this.heightOfNodes.addElement(Integers.valueOf(iArr[i10 + 6]));
        }
        this.firstNode = bArr[0];
        this.seedActive = bArr[1];
        this.seedNext = bArr[2];
        this.tailStack = new Vector();
        for (int i11 = 0; i11 < this.tailLength; i11++) {
            this.tailStack.addElement(bArr[i11 + 3]);
        }
    }

    public void destroy() {
        this.isInitialized = false;
        this.isFinished = false;
        this.firstNode = null;
        this.tailLength = 0;
        this.firstNodeHeight = -1;
    }

    public byte[] getFirstNode() {
        return this.firstNode;
    }

    public int getFirstNodeHeight() {
        return this.firstNode == null ? this.maxHeight : this.firstNodeHeight;
    }

    public int getLowestNodeHeight() {
        return this.firstNode == null ? this.maxHeight : this.tailLength == 0 ? this.firstNodeHeight : Math.min(this.firstNodeHeight, ((Integer) this.heightOfNodes.lastElement()).intValue());
    }

    public byte[] getSeedActive() {
        return this.seedActive;
    }

    public byte[][] getStatByte() {
        int[] iArr = new int[2];
        iArr[1] = this.messDigestTree.getDigestSize();
        iArr[0] = this.tailLength + 3;
        byte[][] bArr = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
        bArr[0] = this.firstNode;
        bArr[1] = this.seedActive;
        bArr[2] = this.seedNext;
        for (int i10 = 0; i10 < this.tailLength; i10++) {
            bArr[i10 + 3] = (byte[]) this.tailStack.elementAt(i10);
        }
        return bArr;
    }

    public int[] getStatInt() {
        int i10 = this.tailLength;
        int[] iArr = new int[(i10 + 6)];
        iArr[0] = this.maxHeight;
        iArr[1] = i10;
        iArr[2] = this.firstNodeHeight;
        if (this.isFinished) {
            iArr[3] = 1;
        } else {
            iArr[3] = 0;
        }
        if (this.isInitialized) {
            iArr[4] = 1;
        } else {
            iArr[4] = 0;
        }
        if (this.seedInitialized) {
            iArr[5] = 1;
        } else {
            iArr[5] = 0;
        }
        for (int i11 = 0; i11 < this.tailLength; i11++) {
            iArr[i11 + 6] = ((Integer) this.heightOfNodes.elementAt(i11)).intValue();
        }
        return iArr;
    }

    public Vector getTailStack() {
        return this.tailStack;
    }

    public void initialize() {
        if (this.seedInitialized) {
            this.heightOfNodes = new Vector();
            this.tailLength = 0;
            this.firstNode = null;
            this.firstNodeHeight = -1;
            this.isInitialized = true;
            System.arraycopy(this.seedNext, 0, this.seedActive, 0, this.messDigestTree.getDigestSize());
            return;
        }
        throw new IllegalStateException("Seed " + this.maxHeight + " not initialized");
    }

    public void initializeSeed(byte[] bArr) {
        System.arraycopy(bArr, 0, this.seedNext, 0, this.messDigestTree.getDigestSize());
        this.seedInitialized = true;
    }

    public void setFirstNode(byte[] bArr) {
        if (!this.isInitialized) {
            initialize();
        }
        this.firstNode = bArr;
        this.firstNodeHeight = this.maxHeight;
        this.isFinished = true;
    }

    public String toString() {
        StringBuilder sb2;
        String str = "Treehash    : ";
        for (int i10 = 0; i10 < this.tailLength + 6; i10++) {
            str = str + getStatInt()[i10] + " ";
        }
        for (int i11 = 0; i11 < this.tailLength + 3; i11++) {
            if (getStatByte()[i11] != null) {
                sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(new String(Hex.encode(getStatByte()[i11])));
                sb2.append(" ");
            } else {
                sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("null ");
            }
            str = sb2.toString();
        }
        return str + "  " + this.messDigestTree.getDigestSize();
    }

    public void update(GMSSRandom gMSSRandom, byte[] bArr) {
        PrintStream printStream;
        String str;
        if (this.isFinished) {
            printStream = System.err;
            str = "No more update possible for treehash instance!";
        } else if (!this.isInitialized) {
            printStream = System.err;
            str = "Treehash instance not initialized before update";
        } else {
            byte[] bArr2 = new byte[this.messDigestTree.getDigestSize()];
            gMSSRandom.nextSeed(this.seedActive);
            if (this.firstNode == null) {
                this.firstNode = bArr;
                this.firstNodeHeight = 0;
            } else {
                int i10 = 0;
                while (this.tailLength > 0 && i10 == ((Integer) this.heightOfNodes.lastElement()).intValue()) {
                    int digestSize = this.messDigestTree.getDigestSize() << 1;
                    byte[] bArr3 = new byte[digestSize];
                    System.arraycopy(this.tailStack.lastElement(), 0, bArr3, 0, this.messDigestTree.getDigestSize());
                    Vector vector = this.tailStack;
                    vector.removeElementAt(vector.size() - 1);
                    Vector vector2 = this.heightOfNodes;
                    vector2.removeElementAt(vector2.size() - 1);
                    System.arraycopy(bArr, 0, bArr3, this.messDigestTree.getDigestSize(), this.messDigestTree.getDigestSize());
                    this.messDigestTree.update(bArr3, 0, digestSize);
                    bArr = new byte[this.messDigestTree.getDigestSize()];
                    this.messDigestTree.doFinal(bArr, 0);
                    i10++;
                    this.tailLength--;
                }
                this.tailStack.addElement(bArr);
                this.heightOfNodes.addElement(Integers.valueOf(i10));
                this.tailLength++;
                if (((Integer) this.heightOfNodes.lastElement()).intValue() == this.firstNodeHeight) {
                    int digestSize2 = this.messDigestTree.getDigestSize() << 1;
                    byte[] bArr4 = new byte[digestSize2];
                    System.arraycopy(this.firstNode, 0, bArr4, 0, this.messDigestTree.getDigestSize());
                    System.arraycopy(this.tailStack.lastElement(), 0, bArr4, this.messDigestTree.getDigestSize(), this.messDigestTree.getDigestSize());
                    Vector vector3 = this.tailStack;
                    vector3.removeElementAt(vector3.size() - 1);
                    Vector vector4 = this.heightOfNodes;
                    vector4.removeElementAt(vector4.size() - 1);
                    this.messDigestTree.update(bArr4, 0, digestSize2);
                    byte[] bArr5 = new byte[this.messDigestTree.getDigestSize()];
                    this.firstNode = bArr5;
                    this.messDigestTree.doFinal(bArr5, 0);
                    this.firstNodeHeight++;
                    this.tailLength = 0;
                }
            }
            if (this.firstNodeHeight == this.maxHeight) {
                this.isFinished = true;
                return;
            }
            return;
        }
        printStream.println(str);
    }

    public void updateNextSeed(GMSSRandom gMSSRandom) {
        gMSSRandom.nextSeed(this.seedNext);
    }

    public boolean wasFinished() {
        return this.isFinished;
    }

    public boolean wasInitialized() {
        return this.isInitialized;
    }
}
