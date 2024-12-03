package net.bytebuddy.jar.asm;

import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.pool.TypePool;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

class Frame {
    static final int APPEND_FRAME = 252;
    private static final int ARRAY_OF = 67108864;
    private static final int BOOLEAN = 4194313;
    private static final int BYTE = 4194314;
    private static final int CHAR = 4194315;
    static final int CHOP_FRAME = 248;
    private static final int CONSTANT_KIND = 4194304;
    private static final int DIM_MASK = -67108864;
    private static final int DIM_SHIFT = 26;
    private static final int DIM_SIZE = 6;
    private static final int DOUBLE = 4194307;
    private static final int ELEMENT_OF = -67108864;
    private static final int FLAGS_SHIFT = 20;
    private static final int FLAGS_SIZE = 2;
    private static final int FLOAT = 4194306;
    static final int FULL_FRAME = 255;
    private static final int INTEGER = 4194305;
    private static final int ITEM_ASM_BOOLEAN = 9;
    private static final int ITEM_ASM_BYTE = 10;
    private static final int ITEM_ASM_CHAR = 11;
    private static final int ITEM_ASM_SHORT = 12;
    static final int ITEM_DOUBLE = 3;
    static final int ITEM_FLOAT = 2;
    static final int ITEM_INTEGER = 1;
    static final int ITEM_LONG = 4;
    static final int ITEM_NULL = 5;
    static final int ITEM_OBJECT = 7;
    static final int ITEM_TOP = 0;
    static final int ITEM_UNINITIALIZED = 8;
    static final int ITEM_UNINITIALIZED_THIS = 6;
    private static final int KIND_MASK = 62914560;
    private static final int KIND_SHIFT = 22;
    private static final int KIND_SIZE = 4;
    private static final int LOCAL_KIND = 16777216;
    private static final int LONG = 4194308;
    private static final int NULL = 4194309;
    private static final int REFERENCE_KIND = 8388608;
    static final int RESERVED = 128;
    static final int SAME_FRAME = 0;
    static final int SAME_FRAME_EXTENDED = 251;
    static final int SAME_LOCALS_1_STACK_ITEM_FRAME = 64;
    static final int SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED = 247;
    private static final int SHORT = 4194316;
    private static final int STACK_KIND = 20971520;
    private static final int TOP = 4194304;
    private static final int TOP_IF_LONG_OR_DOUBLE_FLAG = 1048576;
    private static final int UNINITIALIZED_KIND = 12582912;
    private static final int UNINITIALIZED_THIS = 4194310;
    private static final int VALUE_MASK = 1048575;
    private static final int VALUE_SIZE = 20;
    private int initializationCount;
    private int[] initializations;
    private int[] inputLocals;
    private int[] inputStack;
    private int[] outputLocals;
    private int[] outputStack;
    private short outputStackStart;
    private short outputStackTop;
    Label owner;

    Frame(Label label) {
        this.owner = label;
    }

    private void addInitializedType(int i10) {
        if (this.initializations == null) {
            this.initializations = new int[2];
        }
        int length = this.initializations.length;
        int i11 = this.initializationCount;
        if (i11 >= length) {
            int[] iArr = new int[Math.max(i11 + 1, length * 2)];
            System.arraycopy(this.initializations, 0, iArr, 0, length);
            this.initializations = iArr;
        }
        int[] iArr2 = this.initializations;
        int i12 = this.initializationCount;
        this.initializationCount = i12 + 1;
        iArr2[i12] = i10;
    }

    static int getAbstractTypeFromApiFormat(SymbolTable symbolTable, Object obj) {
        if (obj instanceof Integer) {
            return 4194304 | ((Integer) obj).intValue();
        }
        if (obj instanceof String) {
            return getAbstractTypeFromDescriptor(symbolTable, Type.getObjectType((String) obj).getDescriptor(), 0);
        }
        return symbolTable.addUninitializedType("", ((Label) obj).bytecodeOffset) | UNINITIALIZED_KIND;
    }

    private static int getAbstractTypeFromDescriptor(SymbolTable symbolTable, String str, int i10) {
        SymbolTable symbolTable2 = symbolTable;
        String str2 = str;
        char charAt = str.charAt(i10);
        int i11 = FLOAT;
        if (charAt == 'F') {
            return FLOAT;
        }
        if (charAt == 'L') {
            return symbolTable2.addType(str2.substring(i10 + 1, str.length() - 1)) | REFERENCE_KIND;
        }
        if (charAt != 'S') {
            if (charAt == 'V') {
                return 0;
            }
            if (charAt != 'I') {
                if (charAt == 'J') {
                    return LONG;
                }
                if (charAt != 'Z') {
                    if (charAt != '[') {
                        switch (charAt) {
                            case 'B':
                            case 'C':
                                break;
                            case 'D':
                                return DOUBLE;
                            default:
                                throw new IllegalArgumentException("Invalid descriptor: " + str.substring(i10));
                        }
                    } else {
                        int i12 = i10 + 1;
                        while (str2.charAt(i12) == '[') {
                            i12++;
                        }
                        char charAt2 = str2.charAt(i12);
                        if (charAt2 != 'F') {
                            if (charAt2 == 'L') {
                                i11 = symbolTable2.addType(str2.substring(i12 + 1, str.length() - 1)) | REFERENCE_KIND;
                            } else if (charAt2 == 'S') {
                                i11 = SHORT;
                            } else if (charAt2 == 'Z') {
                                i11 = BOOLEAN;
                            } else if (charAt2 == 'I') {
                                i11 = INTEGER;
                            } else if (charAt2 != 'J') {
                                switch (charAt2) {
                                    case 'B':
                                        i11 = BYTE;
                                        break;
                                    case 'C':
                                        i11 = CHAR;
                                        break;
                                    case 'D':
                                        i11 = DOUBLE;
                                        break;
                                    default:
                                        throw new IllegalArgumentException("Invalid descriptor fragment: " + str2.substring(i12));
                                }
                            } else {
                                i11 = LONG;
                            }
                        }
                        return ((i12 - i10) << 26) | i11;
                    }
                }
            }
        }
        return INTEGER;
    }

    static int getAbstractTypeFromInternalName(SymbolTable symbolTable, String str) {
        return symbolTable.addType(str) | REFERENCE_KIND;
    }

    private int getConcreteOutputType(int i10, int i11) {
        int i12 = -67108864 & i10;
        int i13 = KIND_MASK & i10;
        if (i13 == LOCAL_KIND) {
            int i14 = i12 + this.inputLocals[i10 & VALUE_MASK];
            if ((i10 & TOP_IF_LONG_OR_DOUBLE_FLAG) == 0 || (i14 != LONG && i14 != DOUBLE)) {
                return i14;
            }
            return 4194304;
        } else if (i13 != STACK_KIND) {
            return i10;
        } else {
            int i15 = i12 + this.inputStack[i11 - (VALUE_MASK & i10)];
            if ((i10 & TOP_IF_LONG_OR_DOUBLE_FLAG) == 0 || (i15 != LONG && i15 != DOUBLE)) {
                return i15;
            }
            return 4194304;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051 A[LOOP:0: B:5:0x000d->B:21:0x0051, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0037 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getInitializedType(net.bytebuddy.jar.asm.SymbolTable r9, int r10) {
        /*
            r8 = this;
            r0 = 4194310(0x400006, float:5.87748E-39)
            if (r10 == r0) goto L_0x000c
            r1 = -4194304(0xffffffffffc00000, float:NaN)
            r1 = r1 & r10
            r2 = 12582912(0xc00000, float:1.7632415E-38)
            if (r1 != r2) goto L_0x0054
        L_0x000c:
            r1 = 0
        L_0x000d:
            int r2 = r8.initializationCount
            if (r1 >= r2) goto L_0x0054
            int[] r2 = r8.initializations
            r2 = r2[r1]
            r3 = -67108864(0xfffffffffc000000, float:-2.658456E36)
            r3 = r3 & r2
            r4 = 62914560(0x3c00000, float:1.1284746E-36)
            r4 = r4 & r2
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r2 & r5
            r7 = 16777216(0x1000000, float:2.3509887E-38)
            if (r4 != r7) goto L_0x002a
            int[] r2 = r8.inputLocals
            r2 = r2[r6]
        L_0x0028:
            int r2 = r2 + r3
            goto L_0x0035
        L_0x002a:
            r7 = 20971520(0x1400000, float:3.526483E-38)
            if (r4 != r7) goto L_0x0035
            int[] r2 = r8.inputStack
            int r4 = r2.length
            int r4 = r4 - r6
            r2 = r2[r4]
            goto L_0x0028
        L_0x0035:
            if (r10 != r2) goto L_0x0051
            r1 = 8388608(0x800000, float:1.17549435E-38)
            if (r10 != r0) goto L_0x0045
            java.lang.String r10 = r9.getClassName()
            int r9 = r9.addType(r10)
        L_0x0043:
            r9 = r9 | r1
            return r9
        L_0x0045:
            r10 = r10 & r5
            net.bytebuddy.jar.asm.Symbol r10 = r9.getType(r10)
            java.lang.String r10 = r10.value
            int r9 = r9.addType(r10)
            goto L_0x0043
        L_0x0051:
            int r1 = r1 + 1
            goto L_0x000d
        L_0x0054:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.Frame.getInitializedType(net.bytebuddy.jar.asm.SymbolTable, int):int");
    }

    private int getLocal(int i10) {
        int[] iArr = this.outputLocals;
        if (iArr == null || i10 >= iArr.length) {
            return i10 | LOCAL_KIND;
        }
        int i11 = iArr[i10];
        if (i11 != 0) {
            return i11;
        }
        int i12 = i10 | LOCAL_KIND;
        iArr[i10] = i12;
        return i12;
    }

    private int pop() {
        short s10 = this.outputStackTop;
        if (s10 > 0) {
            int[] iArr = this.outputStack;
            short s11 = (short) (s10 - 1);
            this.outputStackTop = s11;
            return iArr[s11];
        }
        short s12 = (short) (this.outputStackStart - 1);
        this.outputStackStart = s12;
        return STACK_KIND | (-s12);
    }

    private void push(int i10) {
        if (this.outputStack == null) {
            this.outputStack = new int[10];
        }
        int length = this.outputStack.length;
        short s10 = this.outputStackTop;
        if (s10 >= length) {
            int[] iArr = new int[Math.max(s10 + 1, length * 2)];
            System.arraycopy(this.outputStack, 0, iArr, 0, length);
            this.outputStack = iArr;
        }
        int[] iArr2 = this.outputStack;
        short s11 = this.outputStackTop;
        short s12 = (short) (s11 + 1);
        this.outputStackTop = s12;
        iArr2[s11] = i10;
        short s13 = (short) (this.outputStackStart + s12);
        Label label = this.owner;
        if (s13 > label.outputStackMax) {
            label.outputStackMax = s13;
        }
    }

    static void putAbstractType(SymbolTable symbolTable, int i10, ByteVector byteVector) {
        int i11 = (-67108864 & i10) >> 26;
        if (i11 == 0) {
            int i12 = i10 & VALUE_MASK;
            int i13 = i10 & KIND_MASK;
            if (i13 == 4194304) {
                byteVector.putByte(i12);
            } else if (i13 == REFERENCE_KIND) {
                byteVector.putByte(7).putShort(symbolTable.addConstantClass(symbolTable.getType(i12).value).index);
            } else if (i13 == UNINITIALIZED_KIND) {
                byteVector.putByte(8).putShort((int) symbolTable.getType(i12).data);
            } else {
                throw new AssertionError();
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                int i14 = i11 - 1;
                if (i11 <= 0) {
                    break;
                }
                sb2.append('[');
                i11 = i14;
            }
            if ((i10 & KIND_MASK) == REFERENCE_KIND) {
                sb2.append(Matrix.MATRIX_TYPE_RANDOM_LT);
                sb2.append(symbolTable.getType(i10 & VALUE_MASK).value);
                sb2.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
            } else {
                int i15 = i10 & VALUE_MASK;
                if (i15 == 1) {
                    sb2.append('I');
                } else if (i15 == 2) {
                    sb2.append('F');
                } else if (i15 == 3) {
                    sb2.append('D');
                } else if (i15 != 4) {
                    switch (i15) {
                        case 9:
                            sb2.append(Matrix.MATRIX_TYPE_ZERO);
                            break;
                        case 10:
                            sb2.append('B');
                            break;
                        case 11:
                            sb2.append('C');
                            break;
                        case 12:
                            sb2.append('S');
                            break;
                        default:
                            throw new AssertionError();
                    }
                } else {
                    sb2.append('J');
                }
            }
            byteVector.putByte(7).putShort(symbolTable.addConstantClass(sb2.toString()).index);
        }
    }

    private void setLocal(int i10, int i11) {
        if (this.outputLocals == null) {
            this.outputLocals = new int[10];
        }
        int length = this.outputLocals.length;
        if (i10 >= length) {
            int[] iArr = new int[Math.max(i10 + 1, length * 2)];
            System.arraycopy(this.outputLocals, 0, iArr, 0, length);
            this.outputLocals = iArr;
        }
        this.outputLocals[i10] = i11;
    }

    /* access modifiers changed from: package-private */
    public final void accept(MethodWriter methodWriter) {
        int i10;
        int i11;
        int i12;
        int[] iArr = this.inputLocals;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (true) {
            int i17 = 2;
            if (i14 >= iArr.length) {
                break;
            }
            int i18 = iArr[i14];
            if (!(i18 == LONG || i18 == DOUBLE)) {
                i17 = 1;
            }
            i14 += i17;
            if (i18 == 4194304) {
                i16++;
            } else {
                i15 += i16 + 1;
                i16 = 0;
            }
        }
        int[] iArr2 = this.inputStack;
        int i19 = 0;
        int i20 = 0;
        while (i19 < iArr2.length) {
            int i21 = iArr2[i19];
            if (i21 == LONG || i21 == DOUBLE) {
                i12 = 2;
            } else {
                i12 = 1;
            }
            i19 += i12;
            i20++;
        }
        int visitFrameStart = methodWriter.visitFrameStart(this.owner.bytecodeOffset, i15, i20);
        int i22 = 0;
        while (true) {
            int i23 = i15 - 1;
            if (i15 <= 0) {
                break;
            }
            int i24 = iArr[i22];
            if (i24 == LONG || i24 == DOUBLE) {
                i11 = 2;
            } else {
                i11 = 1;
            }
            i22 += i11;
            methodWriter.visitAbstractType(visitFrameStart, i24);
            i15 = i23;
            visitFrameStart++;
        }
        while (true) {
            int i25 = i20 - 1;
            if (i20 > 0) {
                int i26 = iArr2[i13];
                if (i26 == LONG || i26 == DOUBLE) {
                    i10 = 2;
                } else {
                    i10 = 1;
                }
                i13 += i10;
                methodWriter.visitAbstractType(visitFrameStart, i26);
                visitFrameStart++;
                i20 = i25;
            } else {
                methodWriter.visitFrameEnd();
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void copyFrom(Frame frame) {
        this.inputLocals = frame.inputLocals;
        this.inputStack = frame.inputStack;
        this.outputStackStart = 0;
        this.outputLocals = frame.outputLocals;
        this.outputStack = frame.outputStack;
        this.outputStackTop = frame.outputStackTop;
        this.initializationCount = frame.initializationCount;
        this.initializations = frame.initializations;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0344, code lost:
        push(DOUBLE);
        push(4194304);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x034b, code lost:
        push(FLOAT);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x034f, code lost:
        push(LONG);
        push(4194304);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0356, code lost:
        push(INTEGER);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0245, code lost:
        pop(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02bf, code lost:
        pop(2);
        push(DOUBLE);
        push(4194304);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02ca, code lost:
        pop(2);
        push(FLOAT);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02d2, code lost:
        pop(2);
        push(LONG);
        push(4194304);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02dd, code lost:
        pop(2);
        push(INTEGER);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void execute(int r17, int r18, net.bytebuddy.jar.asm.Symbol r19, net.bytebuddy.jar.asm.SymbolTable r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r6 = 4194306(0x400002, float:5.877475E-39)
            r7 = 8388608(0x800000, float:1.17549435E-38)
            r8 = 4194305(0x400001, float:5.877473E-39)
            r9 = 4194307(0x400003, float:5.877476E-39)
            r10 = 4194308(0x400004, float:5.877477E-39)
            r11 = 4194304(0x400000, float:5.877472E-39)
            switch(r1) {
                case 0: goto L_0x0360;
                case 1: goto L_0x035a;
                case 2: goto L_0x0356;
                case 3: goto L_0x0356;
                case 4: goto L_0x0356;
                case 5: goto L_0x0356;
                case 6: goto L_0x0356;
                case 7: goto L_0x0356;
                case 8: goto L_0x0356;
                case 9: goto L_0x034f;
                case 10: goto L_0x034f;
                case 11: goto L_0x034b;
                case 12: goto L_0x034b;
                case 13: goto L_0x034b;
                case 14: goto L_0x0344;
                case 15: goto L_0x0344;
                case 16: goto L_0x0356;
                case 17: goto L_0x0356;
                case 18: goto L_0x02ee;
                default: goto L_0x001d;
            }
        L_0x001d:
            switch(r1) {
                case 21: goto L_0x0356;
                case 22: goto L_0x034f;
                case 23: goto L_0x034b;
                case 24: goto L_0x0344;
                case 25: goto L_0x02e5;
                default: goto L_0x0020;
            }
        L_0x0020:
            r12 = 20971520(0x1400000, float:3.526483E-38)
            r14 = 16777216(0x1000000, float:2.3509887E-38)
            r15 = 62914560(0x3c00000, float:1.1284746E-36)
            r13 = 1
            switch(r1) {
                case 46: goto L_0x019c;
                case 47: goto L_0x0147;
                case 48: goto L_0x018e;
                case 49: goto L_0x0152;
                case 50: goto L_0x02aa;
                case 51: goto L_0x019c;
                case 52: goto L_0x019c;
                case 53: goto L_0x019c;
                case 54: goto L_0x0283;
                case 55: goto L_0x0254;
                case 56: goto L_0x0283;
                case 57: goto L_0x0254;
                case 58: goto L_0x0283;
                default: goto L_0x002a;
            }
        L_0x002a:
            r12 = 3
            r14 = 91
            r15 = 0
            r5 = 4
            switch(r1) {
                case 79: goto L_0x024f;
                case 80: goto L_0x024a;
                case 81: goto L_0x024f;
                case 82: goto L_0x024a;
                case 83: goto L_0x024f;
                case 84: goto L_0x024f;
                case 85: goto L_0x024f;
                case 86: goto L_0x024f;
                case 87: goto L_0x0245;
                case 88: goto L_0x023f;
                case 89: goto L_0x0233;
                case 90: goto L_0x0220;
                case 91: goto L_0x0206;
                case 92: goto L_0x01f0;
                case 93: goto L_0x01d3;
                case 94: goto L_0x01af;
                case 95: goto L_0x019f;
                case 96: goto L_0x019c;
                case 97: goto L_0x0191;
                case 98: goto L_0x018e;
                case 99: goto L_0x0183;
                case 100: goto L_0x019c;
                case 101: goto L_0x0191;
                case 102: goto L_0x018e;
                case 103: goto L_0x0183;
                case 104: goto L_0x019c;
                case 105: goto L_0x0191;
                case 106: goto L_0x018e;
                case 107: goto L_0x0183;
                case 108: goto L_0x019c;
                case 109: goto L_0x0191;
                case 110: goto L_0x018e;
                case 111: goto L_0x0183;
                case 112: goto L_0x019c;
                case 113: goto L_0x0191;
                case 114: goto L_0x018e;
                case 115: goto L_0x0183;
                case 116: goto L_0x0360;
                case 117: goto L_0x0360;
                case 118: goto L_0x0360;
                case 119: goto L_0x0360;
                case 120: goto L_0x019c;
                case 121: goto L_0x0178;
                case 122: goto L_0x019c;
                case 123: goto L_0x0178;
                case 124: goto L_0x019c;
                case 125: goto L_0x0178;
                case 126: goto L_0x019c;
                case 127: goto L_0x0191;
                case 128: goto L_0x019c;
                case 129: goto L_0x0191;
                case 130: goto L_0x019c;
                case 131: goto L_0x0191;
                case 132: goto L_0x0173;
                case 133: goto L_0x0168;
                case 134: goto L_0x0160;
                case 135: goto L_0x0155;
                case 136: goto L_0x019c;
                case 137: goto L_0x018e;
                case 138: goto L_0x0152;
                case 139: goto L_0x014a;
                case 140: goto L_0x0168;
                case 141: goto L_0x0155;
                case 142: goto L_0x019c;
                case 143: goto L_0x0147;
                case 144: goto L_0x018e;
                case 145: goto L_0x0360;
                case 146: goto L_0x0360;
                case 147: goto L_0x0360;
                case 148: goto L_0x013f;
                case 149: goto L_0x019c;
                case 150: goto L_0x019c;
                case 151: goto L_0x013f;
                case 152: goto L_0x013f;
                case 153: goto L_0x0245;
                case 154: goto L_0x0245;
                case 155: goto L_0x0245;
                case 156: goto L_0x0245;
                case 157: goto L_0x0245;
                case 158: goto L_0x0245;
                case 159: goto L_0x023f;
                case 160: goto L_0x023f;
                case 161: goto L_0x023f;
                case 162: goto L_0x023f;
                case 163: goto L_0x023f;
                case 164: goto L_0x023f;
                case 165: goto L_0x023f;
                case 166: goto L_0x023f;
                case 167: goto L_0x0360;
                case 168: goto L_0x0137;
                case 169: goto L_0x0137;
                case 170: goto L_0x0245;
                case 171: goto L_0x0245;
                case 172: goto L_0x0245;
                case 173: goto L_0x023f;
                case 174: goto L_0x0245;
                case 175: goto L_0x023f;
                case 176: goto L_0x0245;
                case 177: goto L_0x0360;
                case 178: goto L_0x0130;
                case 179: goto L_0x0129;
                case 180: goto L_0x011f;
                case 181: goto L_0x0115;
                case 182: goto L_0x00f0;
                case 183: goto L_0x00f0;
                case 184: goto L_0x00f0;
                case 185: goto L_0x00f0;
                case 186: goto L_0x00e4;
                case 187: goto L_0x00d6;
                case 188: goto L_0x008a;
                case 189: goto L_0x005f;
                case 190: goto L_0x014a;
                case 191: goto L_0x0245;
                case 192: goto L_0x0045;
                case 193: goto L_0x014a;
                case 194: goto L_0x0245;
                case 195: goto L_0x0245;
                default: goto L_0x0032;
            }
        L_0x0032:
            switch(r1) {
                case 197: goto L_0x003b;
                case 198: goto L_0x0245;
                case 199: goto L_0x0245;
                default: goto L_0x0035;
            }
        L_0x0035:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>()
            throw r1
        L_0x003b:
            r0.pop((int) r2)
            java.lang.String r1 = r3.value
            r0.push(r4, r1)
            goto L_0x0360
        L_0x0045:
            java.lang.String r1 = r3.value
            r16.pop()
            char r2 = r1.charAt(r15)
            if (r2 != r14) goto L_0x0055
            r0.push(r4, r1)
            goto L_0x0360
        L_0x0055:
            int r1 = r4.addType(r1)
            r1 = r1 | r7
            r0.push(r1)
            goto L_0x0360
        L_0x005f:
            java.lang.String r1 = r3.value
            r16.pop()
            char r2 = r1.charAt(r15)
            if (r2 != r14) goto L_0x007e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.push(r4, r1)
            goto L_0x0360
        L_0x007e:
            r2 = 75497472(0x4800000, float:3.0092655E-36)
            int r1 = r4.addType(r1)
            r1 = r1 | r2
            r0.push(r1)
            goto L_0x0360
        L_0x008a:
            r16.pop()
            switch(r2) {
                case 4: goto L_0x00ce;
                case 5: goto L_0x00c6;
                case 6: goto L_0x00be;
                case 7: goto L_0x00b6;
                case 8: goto L_0x00ae;
                case 9: goto L_0x00a6;
                case 10: goto L_0x009e;
                case 11: goto L_0x0096;
                default: goto L_0x0090;
            }
        L_0x0090:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>()
            throw r1
        L_0x0096:
            r1 = 71303172(0x4400004, float:2.2569499E-36)
            r0.push(r1)
            goto L_0x0360
        L_0x009e:
            r1 = 71303169(0x4400001, float:2.2569493E-36)
            r0.push(r1)
            goto L_0x0360
        L_0x00a6:
            r1 = 71303180(0x440000c, float:2.2569513E-36)
            r0.push(r1)
            goto L_0x0360
        L_0x00ae:
            r1 = 71303178(0x440000a, float:2.256951E-36)
            r0.push(r1)
            goto L_0x0360
        L_0x00b6:
            r1 = 71303171(0x4400003, float:2.2569497E-36)
            r0.push(r1)
            goto L_0x0360
        L_0x00be:
            r1 = 71303170(0x4400002, float:2.2569495E-36)
            r0.push(r1)
            goto L_0x0360
        L_0x00c6:
            r1 = 71303179(0x440000b, float:2.2569511E-36)
            r0.push(r1)
            goto L_0x0360
        L_0x00ce:
            r1 = 71303177(0x4400009, float:2.2569508E-36)
            r0.push(r1)
            goto L_0x0360
        L_0x00d6:
            r1 = 12582912(0xc00000, float:1.7632415E-38)
            java.lang.String r3 = r3.value
            int r2 = r4.addUninitializedType(r3, r2)
            r1 = r1 | r2
            r0.push(r1)
            goto L_0x0360
        L_0x00e4:
            java.lang.String r1 = r3.value
            r0.pop((java.lang.String) r1)
            java.lang.String r1 = r3.value
            r0.push(r4, r1)
            goto L_0x0360
        L_0x00f0:
            java.lang.String r2 = r3.value
            r0.pop((java.lang.String) r2)
            r2 = 184(0xb8, float:2.58E-43)
            if (r1 == r2) goto L_0x010e
            int r2 = r16.pop()
            r5 = 183(0xb7, float:2.56E-43)
            if (r1 != r5) goto L_0x010e
            java.lang.String r1 = r3.name
            char r1 = r1.charAt(r15)
            r5 = 60
            if (r1 != r5) goto L_0x010e
            r0.addInitializedType(r2)
        L_0x010e:
            java.lang.String r1 = r3.value
            r0.push(r4, r1)
            goto L_0x0360
        L_0x0115:
            java.lang.String r1 = r3.value
            r0.pop((java.lang.String) r1)
            r16.pop()
            goto L_0x0360
        L_0x011f:
            r0.pop((int) r13)
            java.lang.String r1 = r3.value
            r0.push(r4, r1)
            goto L_0x0360
        L_0x0129:
            java.lang.String r1 = r3.value
            r0.pop((java.lang.String) r1)
            goto L_0x0360
        L_0x0130:
            java.lang.String r1 = r3.value
            r0.push(r4, r1)
            goto L_0x0360
        L_0x0137:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "JSR/RET are not supported with computeFrames option"
            r1.<init>(r2)
            throw r1
        L_0x013f:
            r0.pop((int) r5)
            r0.push(r8)
            goto L_0x0360
        L_0x0147:
            r1 = 2
            goto L_0x02d2
        L_0x014a:
            r0.pop((int) r13)
            r0.push(r8)
            goto L_0x0360
        L_0x0152:
            r1 = 2
            goto L_0x02bf
        L_0x0155:
            r0.pop((int) r13)
            r0.push(r9)
            r0.push(r11)
            goto L_0x0360
        L_0x0160:
            r0.pop((int) r13)
            r0.push(r6)
            goto L_0x0360
        L_0x0168:
            r0.pop((int) r13)
            r0.push(r10)
            r0.push(r11)
            goto L_0x0360
        L_0x0173:
            r0.setLocal(r2, r8)
            goto L_0x0360
        L_0x0178:
            r0.pop((int) r12)
            r0.push(r10)
            r0.push(r11)
            goto L_0x0360
        L_0x0183:
            r0.pop((int) r5)
            r0.push(r9)
            r0.push(r11)
            goto L_0x0360
        L_0x018e:
            r1 = 2
            goto L_0x02ca
        L_0x0191:
            r0.pop((int) r5)
            r0.push(r10)
            r0.push(r11)
            goto L_0x0360
        L_0x019c:
            r1 = 2
            goto L_0x02dd
        L_0x019f:
            int r1 = r16.pop()
            int r2 = r16.pop()
            r0.push(r1)
            r0.push(r2)
            goto L_0x0360
        L_0x01af:
            int r1 = r16.pop()
            int r2 = r16.pop()
            int r3 = r16.pop()
            int r4 = r16.pop()
            r0.push(r2)
            r0.push(r1)
            r0.push(r4)
            r0.push(r3)
            r0.push(r2)
            r0.push(r1)
            goto L_0x0360
        L_0x01d3:
            int r1 = r16.pop()
            int r2 = r16.pop()
            int r3 = r16.pop()
            r0.push(r2)
            r0.push(r1)
            r0.push(r3)
            r0.push(r2)
            r0.push(r1)
            goto L_0x0360
        L_0x01f0:
            int r1 = r16.pop()
            int r2 = r16.pop()
            r0.push(r2)
            r0.push(r1)
            r0.push(r2)
            r0.push(r1)
            goto L_0x0360
        L_0x0206:
            int r1 = r16.pop()
            int r2 = r16.pop()
            int r3 = r16.pop()
            r0.push(r1)
            r0.push(r3)
            r0.push(r2)
            r0.push(r1)
            goto L_0x0360
        L_0x0220:
            int r1 = r16.pop()
            int r2 = r16.pop()
            r0.push(r1)
            r0.push(r2)
            r0.push(r1)
            goto L_0x0360
        L_0x0233:
            int r1 = r16.pop()
            r0.push(r1)
            r0.push(r1)
            goto L_0x0360
        L_0x023f:
            r1 = 2
            r0.pop((int) r1)
            goto L_0x0360
        L_0x0245:
            r0.pop((int) r13)
            goto L_0x0360
        L_0x024a:
            r0.pop((int) r5)
            goto L_0x0360
        L_0x024f:
            r0.pop((int) r12)
            goto L_0x0360
        L_0x0254:
            r0.pop((int) r13)
            int r1 = r16.pop()
            r0.setLocal(r2, r1)
            int r1 = r2 + 1
            r0.setLocal(r1, r11)
            if (r2 <= 0) goto L_0x0360
            int r1 = r2 + -1
            int r2 = r0.getLocal(r1)
            if (r2 == r10) goto L_0x027e
            if (r2 != r9) goto L_0x0270
            goto L_0x027e
        L_0x0270:
            r3 = r2 & r15
            if (r3 == r14) goto L_0x0276
            if (r3 != r12) goto L_0x0360
        L_0x0276:
            r3 = 1048576(0x100000, float:1.469368E-39)
            r2 = r2 | r3
            r0.setLocal(r1, r2)
            goto L_0x0360
        L_0x027e:
            r0.setLocal(r1, r11)
            goto L_0x0360
        L_0x0283:
            int r1 = r16.pop()
            r0.setLocal(r2, r1)
            if (r2 <= 0) goto L_0x0360
            int r1 = r2 + -1
            int r2 = r0.getLocal(r1)
            if (r2 == r10) goto L_0x02a5
            if (r2 != r9) goto L_0x0297
            goto L_0x02a5
        L_0x0297:
            r3 = r2 & r15
            if (r3 == r14) goto L_0x029d
            if (r3 != r12) goto L_0x0360
        L_0x029d:
            r3 = 1048576(0x100000, float:1.469368E-39)
            r2 = r2 | r3
            r0.setLocal(r1, r2)
            goto L_0x0360
        L_0x02a5:
            r0.setLocal(r1, r11)
            goto L_0x0360
        L_0x02aa:
            r0.pop((int) r13)
            int r1 = r16.pop()
            r2 = 4194309(0x400005, float:5.877479E-39)
            if (r1 != r2) goto L_0x02b7
            goto L_0x02ba
        L_0x02b7:
            r2 = -67108864(0xfffffffffc000000, float:-2.658456E36)
            int r1 = r1 + r2
        L_0x02ba:
            r0.push(r1)
            goto L_0x0360
        L_0x02bf:
            r0.pop((int) r1)
            r0.push(r9)
            r0.push(r11)
            goto L_0x0360
        L_0x02ca:
            r0.pop((int) r1)
            r0.push(r6)
            goto L_0x0360
        L_0x02d2:
            r0.pop((int) r1)
            r0.push(r10)
            r0.push(r11)
            goto L_0x0360
        L_0x02dd:
            r0.pop((int) r1)
            r0.push(r8)
            goto L_0x0360
        L_0x02e5:
            int r1 = r0.getLocal(r2)
            r0.push(r1)
            goto L_0x0360
        L_0x02ee:
            int r1 = r3.tag
            switch(r1) {
                case 3: goto L_0x0340;
                case 4: goto L_0x033c;
                case 5: goto L_0x0335;
                case 6: goto L_0x032e;
                case 7: goto L_0x0323;
                case 8: goto L_0x0318;
                default: goto L_0x02f3;
            }
        L_0x02f3:
            switch(r1) {
                case 15: goto L_0x030d;
                case 16: goto L_0x0302;
                case 17: goto L_0x02fc;
                default: goto L_0x02f6;
            }
        L_0x02f6:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x02fc:
            java.lang.String r1 = r3.value
            r0.push(r4, r1)
            goto L_0x0360
        L_0x0302:
            java.lang.String r1 = "java/lang/invoke/MethodType"
            int r1 = r4.addType(r1)
            r1 = r1 | r7
            r0.push(r1)
            goto L_0x0360
        L_0x030d:
            java.lang.String r1 = "java/lang/invoke/MethodHandle"
            int r1 = r4.addType(r1)
            r1 = r1 | r7
            r0.push(r1)
            goto L_0x0360
        L_0x0318:
            java.lang.String r1 = "java/lang/String"
            int r1 = r4.addType(r1)
            r1 = r1 | r7
            r0.push(r1)
            goto L_0x0360
        L_0x0323:
            java.lang.String r1 = "java/lang/Class"
            int r1 = r4.addType(r1)
            r1 = r1 | r7
            r0.push(r1)
            goto L_0x0360
        L_0x032e:
            r0.push(r9)
            r0.push(r11)
            goto L_0x0360
        L_0x0335:
            r0.push(r10)
            r0.push(r11)
            goto L_0x0360
        L_0x033c:
            r0.push(r6)
            goto L_0x0360
        L_0x0340:
            r0.push(r8)
            goto L_0x0360
        L_0x0344:
            r0.push(r9)
            r0.push(r11)
            goto L_0x0360
        L_0x034b:
            r0.push(r6)
            goto L_0x0360
        L_0x034f:
            r0.push(r10)
            r0.push(r11)
            goto L_0x0360
        L_0x0356:
            r0.push(r8)
            goto L_0x0360
        L_0x035a:
            r1 = 4194309(0x400005, float:5.877479E-39)
            r0.push(r1)
        L_0x0360:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.Frame.execute(int, int, net.bytebuddy.jar.asm.Symbol, net.bytebuddy.jar.asm.SymbolTable):void");
    }

    /* access modifiers changed from: package-private */
    public final int getInputStackSize() {
        return this.inputStack.length;
    }

    /* access modifiers changed from: package-private */
    public final boolean merge(SymbolTable symbolTable, Frame frame, int i10) {
        boolean z10;
        int i11;
        int length = this.inputLocals.length;
        int length2 = this.inputStack.length;
        boolean z11 = true;
        if (frame.inputLocals == null) {
            frame.inputLocals = new int[length];
            z10 = true;
        } else {
            z10 = false;
        }
        for (int i12 = 0; i12 < length; i12++) {
            int[] iArr = this.outputLocals;
            if (iArr == null || i12 >= iArr.length) {
                i11 = this.inputLocals[i12];
            } else {
                int i13 = iArr[i12];
                if (i13 == 0) {
                    i11 = this.inputLocals[i12];
                } else {
                    i11 = getConcreteOutputType(i13, length2);
                }
            }
            if (this.initializations != null) {
                i11 = getInitializedType(symbolTable, i11);
            }
            z10 |= merge(symbolTable, i11, frame.inputLocals, i12);
        }
        if (i10 > 0) {
            for (int i14 = 0; i14 < length; i14++) {
                z10 |= merge(symbolTable, this.inputLocals[i14], frame.inputLocals, i14);
            }
            if (frame.inputStack == null) {
                frame.inputStack = new int[1];
            } else {
                z11 = z10;
            }
            return merge(symbolTable, i10, frame.inputStack, 0) | z11;
        }
        int length3 = this.inputStack.length + this.outputStackStart;
        if (frame.inputStack == null) {
            frame.inputStack = new int[(this.outputStackTop + length3)];
        } else {
            z11 = z10;
        }
        for (int i15 = 0; i15 < length3; i15++) {
            int i16 = this.inputStack[i15];
            if (this.initializations != null) {
                i16 = getInitializedType(symbolTable, i16);
            }
            z11 |= merge(symbolTable, i16, frame.inputStack, i15);
        }
        for (int i17 = 0; i17 < this.outputStackTop; i17++) {
            int concreteOutputType = getConcreteOutputType(this.outputStack[i17], length2);
            if (this.initializations != null) {
                concreteOutputType = getInitializedType(symbolTable, concreteOutputType);
            }
            z11 |= merge(symbolTable, concreteOutputType, frame.inputStack, length3 + i17);
        }
        return z11;
    }

    /* access modifiers changed from: package-private */
    public final void setInputFrameFromApiFormat(SymbolTable symbolTable, int i10, Object[] objArr, int i11, Object[] objArr2) {
        int i12 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            int i14 = i12 + 1;
            this.inputLocals[i12] = getAbstractTypeFromApiFormat(symbolTable, objArr[i13]);
            Integer num = objArr[i13];
            if (num == Opcodes.LONG || num == Opcodes.DOUBLE) {
                this.inputLocals[i14] = 4194304;
                i12 = i14 + 1;
            } else {
                i12 = i14;
            }
        }
        while (true) {
            int[] iArr = this.inputLocals;
            if (i12 >= iArr.length) {
                break;
            }
            iArr[i12] = 4194304;
            i12++;
        }
        int i15 = 0;
        for (int i16 = 0; i16 < i11; i16++) {
            Integer num2 = objArr2[i16];
            if (num2 == Opcodes.LONG || num2 == Opcodes.DOUBLE) {
                i15++;
            }
        }
        this.inputStack = new int[(i15 + i11)];
        int i17 = 0;
        for (int i18 = 0; i18 < i11; i18++) {
            int i19 = i17 + 1;
            this.inputStack[i17] = getAbstractTypeFromApiFormat(symbolTable, objArr2[i18]);
            Integer num3 = objArr2[i18];
            if (num3 == Opcodes.LONG || num3 == Opcodes.DOUBLE) {
                this.inputStack[i19] = 4194304;
                i17 = i19 + 1;
            } else {
                i17 = i19;
            }
        }
        this.outputStackTop = 0;
        this.initializationCount = 0;
    }

    /* access modifiers changed from: package-private */
    public final void setInputFrameFromDescriptor(SymbolTable symbolTable, int i10, String str, int i11) {
        int i12;
        int[] iArr = new int[i11];
        this.inputLocals = iArr;
        this.inputStack = new int[0];
        int i13 = 1;
        if ((i10 & 8) != 0) {
            i13 = 0;
        } else if ((i10 & Opcodes.ASM4) == 0) {
            iArr[0] = REFERENCE_KIND | symbolTable.addType(symbolTable.getClassName());
        } else {
            iArr[0] = UNINITIALIZED_THIS;
        }
        for (Type descriptor : Type.getArgumentTypes(str)) {
            int abstractTypeFromDescriptor = getAbstractTypeFromDescriptor(symbolTable, descriptor.getDescriptor(), 0);
            int[] iArr2 = this.inputLocals;
            int i14 = i12 + 1;
            iArr2[i12] = abstractTypeFromDescriptor;
            if (abstractTypeFromDescriptor == LONG || abstractTypeFromDescriptor == DOUBLE) {
                i12 = i14 + 1;
                iArr2[i14] = 4194304;
            } else {
                i12 = i14;
            }
        }
        while (i12 < i11) {
            this.inputLocals[i12] = 4194304;
            i12++;
        }
    }

    private void pop(int i10) {
        short s10 = this.outputStackTop;
        if (s10 >= i10) {
            this.outputStackTop = (short) (s10 - i10);
            return;
        }
        this.outputStackStart = (short) (this.outputStackStart - (i10 - s10));
        this.outputStackTop = 0;
    }

    private void pop(String str) {
        char charAt = str.charAt(0);
        if (charAt == '(') {
            pop((Type.getArgumentsAndReturnSizes(str) >> 2) - 1);
        } else if (charAt == 'J' || charAt == 'D') {
            pop(2);
        } else {
            pop(1);
        }
    }

    private void push(SymbolTable symbolTable, String str) {
        int i10 = 0;
        if (str.charAt(0) == '(') {
            i10 = Type.getReturnTypeOffset(str);
        }
        int abstractTypeFromDescriptor = getAbstractTypeFromDescriptor(symbolTable, str, i10);
        if (abstractTypeFromDescriptor != 0) {
            push(abstractTypeFromDescriptor);
            if (abstractTypeFromDescriptor == LONG || abstractTypeFromDescriptor == DOUBLE) {
                push(4194304);
            }
        }
    }

    private static boolean merge(SymbolTable symbolTable, int i10, int[] iArr, int i11) {
        int min;
        int addType;
        int i12 = iArr[i11];
        if (i12 == i10) {
            return false;
        }
        if ((67108863 & i10) == NULL) {
            if (i12 == NULL) {
                return false;
            }
            i10 = NULL;
        }
        if (i12 == 0) {
            iArr[i11] = i10;
            return true;
        }
        int i13 = i12 & -67108864;
        int i14 = 4194304;
        if (i13 != 0 || (i12 & KIND_MASK) == REFERENCE_KIND) {
            if (i10 == NULL) {
                return false;
            }
            if ((i10 & -4194304) != (-4194304 & i12)) {
                int i15 = i10 & -67108864;
                if (i15 != 0 || (i10 & KIND_MASK) == REFERENCE_KIND) {
                    if (!(i15 == 0 || (i10 & KIND_MASK) == REFERENCE_KIND)) {
                        i15 -= 67108864;
                    }
                    if (!(i13 == 0 || (i12 & KIND_MASK) == REFERENCE_KIND)) {
                        i13 -= 67108864;
                    }
                    min = Math.min(i15, i13) | REFERENCE_KIND;
                    addType = symbolTable.addType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME);
                }
            } else if ((i12 & KIND_MASK) == REFERENCE_KIND) {
                i14 = (i10 & -67108864) | REFERENCE_KIND | symbolTable.addMergedType(i10 & VALUE_MASK, VALUE_MASK & i12);
            } else {
                min = ((i10 & -67108864) - 67108864) | REFERENCE_KIND;
                addType = symbolTable.addType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME);
            }
            i14 = min | addType;
        } else if (i12 == NULL) {
            if ((i10 & -67108864) == 0 && (i10 & KIND_MASK) != REFERENCE_KIND) {
                i10 = 4194304;
            }
            i14 = i10;
        }
        if (i14 == i12) {
            return false;
        }
        iArr[i11] = i14;
        return true;
    }
}
