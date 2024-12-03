package net.bytebuddy.jar.asm;

public class Label {
    static final Label EMPTY_LIST = new Label();
    static final int FLAG_DEBUG_ONLY = 1;
    static final int FLAG_JUMP_TARGET = 2;
    static final int FLAG_LINE_NUMBER = 128;
    static final int FLAG_REACHABLE = 8;
    static final int FLAG_RESOLVED = 4;
    static final int FLAG_SUBROUTINE_CALLER = 16;
    static final int FLAG_SUBROUTINE_END = 64;
    static final int FLAG_SUBROUTINE_START = 32;
    static final int FORWARD_REFERENCES_CAPACITY_INCREMENT = 6;
    static final int FORWARD_REFERENCE_HANDLE_MASK = 268435455;
    static final int FORWARD_REFERENCE_TYPE_MASK = -268435456;
    static final int FORWARD_REFERENCE_TYPE_SHORT = 268435456;
    static final int FORWARD_REFERENCE_TYPE_WIDE = 536870912;
    static final int LINE_NUMBERS_CAPACITY_INCREMENT = 4;
    int bytecodeOffset;
    short flags;
    private int[] forwardReferences;
    Frame frame;
    public Object info;
    short inputStackSize;
    private short lineNumber;
    Label nextBasicBlock;
    Label nextListElement;
    private int[] otherLineNumbers;
    Edge outgoingEdges;
    short outputStackMax;
    short outputStackSize;
    short subroutineId;

    private void addForwardReference(int i10, int i11, int i12) {
        if (this.forwardReferences == null) {
            this.forwardReferences = new int[6];
        }
        int[] iArr = this.forwardReferences;
        int i13 = iArr[0];
        if (i13 + 2 >= iArr.length) {
            int[] iArr2 = new int[(iArr.length + 6)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.forwardReferences = iArr2;
        }
        int[] iArr3 = this.forwardReferences;
        int i14 = i13 + 1;
        iArr3[i14] = i10;
        int i15 = i14 + 1;
        iArr3[i15] = i11 | i12;
        iArr3[0] = i15;
    }

    private Label pushSuccessors(Label label) {
        boolean z10;
        for (Edge edge = this.outgoingEdges; edge != null; edge = edge.nextEdge) {
            if ((this.flags & 16) == 0 || edge != this.outgoingEdges.nextEdge) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!z10) {
                Label label2 = edge.successor;
                if (label2.nextListElement == null) {
                    label2.nextListElement = label;
                    label = label2;
                }
            }
        }
        return label;
    }

    /* access modifiers changed from: package-private */
    public final void accept(MethodVisitor methodVisitor, boolean z10) {
        methodVisitor.visitLabel(this);
        if (z10 && (this.flags & 128) != 0) {
            methodVisitor.visitLineNumber(this.lineNumber & 65535, this);
            if (this.otherLineNumbers != null) {
                int i10 = 1;
                while (true) {
                    int[] iArr = this.otherLineNumbers;
                    if (i10 <= iArr[0]) {
                        methodVisitor.visitLineNumber(iArr[i10], this);
                        i10++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void addLineNumber(int i10) {
        short s10 = this.flags;
        if ((s10 & 128) == 0) {
            this.flags = (short) (s10 | 128);
            this.lineNumber = (short) i10;
            return;
        }
        if (this.otherLineNumbers == null) {
            this.otherLineNumbers = new int[4];
        }
        int[] iArr = this.otherLineNumbers;
        int i11 = iArr[0] + 1;
        iArr[0] = i11;
        if (i11 >= iArr.length) {
            int[] iArr2 = new int[(iArr.length + 4)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.otherLineNumbers = iArr2;
        }
        this.otherLineNumbers[i11] = i10;
    }

    /* access modifiers changed from: package-private */
    public final void addSubroutineRetSuccessors(Label label) {
        Label label2 = EMPTY_LIST;
        this.nextListElement = label2;
        Label label3 = label2;
        Label label4 = this;
        while (label4 != EMPTY_LIST) {
            Label label5 = label4.nextListElement;
            label4.nextListElement = label3;
            if (!((label4.flags & 64) == 0 || label4.subroutineId == label.subroutineId)) {
                label4.outgoingEdges = new Edge(label4.outputStackSize, label.outgoingEdges.successor, label4.outgoingEdges);
            }
            label3 = label4;
            label4 = label4.pushSuccessors(label5);
        }
        while (label3 != EMPTY_LIST) {
            Label label6 = label3.nextListElement;
            label3.nextListElement = null;
            label3 = label6;
        }
    }

    /* access modifiers changed from: package-private */
    public final Label getCanonicalInstance() {
        Frame frame2 = this.frame;
        return frame2 == null ? this : frame2.owner;
    }

    public int getOffset() {
        if ((this.flags & 4) != 0) {
            return this.bytecodeOffset;
        }
        throw new IllegalStateException("Label offset position has not been resolved yet");
    }

    /* access modifiers changed from: package-private */
    public final void markSubroutine(short s10) {
        this.nextListElement = EMPTY_LIST;
        Label label = this;
        while (label != EMPTY_LIST) {
            Label label2 = label.nextListElement;
            label.nextListElement = null;
            if (label.subroutineId == 0) {
                label.subroutineId = s10;
                label = label.pushSuccessors(label2);
            } else {
                label = label2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void put(ByteVector byteVector, int i10, boolean z10) {
        if ((this.flags & 4) == 0) {
            if (z10) {
                addForwardReference(i10, FORWARD_REFERENCE_TYPE_WIDE, byteVector.length);
                byteVector.putInt(-1);
                return;
            }
            addForwardReference(i10, FORWARD_REFERENCE_TYPE_SHORT, byteVector.length);
            byteVector.putShort(-1);
        } else if (z10) {
            byteVector.putInt(this.bytecodeOffset - i10);
        } else {
            byteVector.putShort(this.bytecodeOffset - i10);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean resolve(byte[] bArr, int i10) {
        this.flags = (short) (this.flags | 4);
        this.bytecodeOffset = i10;
        int[] iArr = this.forwardReferences;
        boolean z10 = false;
        if (iArr == null) {
            return false;
        }
        for (int i11 = iArr[0]; i11 > 0; i11 -= 2) {
            int[] iArr2 = this.forwardReferences;
            int i12 = iArr2[i11 - 1];
            int i13 = iArr2[i11];
            int i14 = i10 - i12;
            int i15 = FORWARD_REFERENCE_HANDLE_MASK & i13;
            if ((i13 & FORWARD_REFERENCE_TYPE_MASK) == FORWARD_REFERENCE_TYPE_SHORT) {
                if (i14 < -32768 || i14 > 32767) {
                    byte b10 = bArr[i12] & 255;
                    if (b10 < 198) {
                        bArr[i12] = (byte) (b10 + Framer.STDOUT_FRAME_PREFIX);
                    } else {
                        bArr[i12] = (byte) (b10 + 20);
                    }
                    z10 = true;
                }
                bArr[i15] = (byte) (i14 >>> 8);
                bArr[i15 + 1] = (byte) i14;
            } else {
                int i16 = i15 + 1;
                bArr[i15] = (byte) (i14 >>> 24);
                int i17 = i16 + 1;
                bArr[i16] = (byte) (i14 >>> 16);
                bArr[i17] = (byte) (i14 >>> 8);
                bArr[i17 + 1] = (byte) i14;
            }
        }
        return z10;
    }

    public String toString() {
        return "L" + System.identityHashCode(this);
    }
}
