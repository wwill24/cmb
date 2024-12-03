package net.bytebuddy.jar.asm;

import java.io.IOException;
import java.io.InputStream;
import net.bytebuddy.description.method.MethodDescription;
import org.jivesoftware.smack.datatypes.UInt32;

public class ClassReader {
    static final int EXPAND_ASM_INSNS = 256;
    public static final int EXPAND_FRAMES = 8;
    private static final int INPUT_STREAM_DATA_CHUNK_SIZE = 4096;
    private static final int MAX_BUFFER_SIZE = 1048576;
    public static final int SKIP_CODE = 1;
    public static final int SKIP_DEBUG = 2;
    public static final int SKIP_FRAMES = 4;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f32802b;
    private final int[] bootstrapMethodOffsets;
    final byte[] classFileBuffer;
    private final ConstantDynamic[] constantDynamicValues;
    private final String[] constantUtf8Values;
    private final int[] cpInfoOffsets;
    public final int header;
    private final int maxStringLength;

    public ClassReader(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    private static int computeBufferSize(InputStream inputStream) throws IOException {
        int available = inputStream.available();
        if (available < 256) {
            return 4096;
        }
        return Math.min(available, MAX_BUFFER_SIZE);
    }

    private void computeImplicitFrame(Context context) {
        int i10;
        int i11;
        String str = context.currentMethodDescriptor;
        Object[] objArr = context.currentFrameLocalTypes;
        int i12 = 0;
        if ((context.currentMethodAccessFlags & 8) == 0) {
            if (MethodDescription.CONSTRUCTOR_INTERNAL_NAME.equals(context.currentMethodName)) {
                objArr[0] = Opcodes.UNINITIALIZED_THIS;
            } else {
                objArr[0] = readClass(this.header + 2, context.charBuffer);
            }
            i12 = 1;
        }
        int i13 = 1;
        while (true) {
            int i14 = i13 + 1;
            char charAt = str.charAt(i13);
            if (charAt == 'F') {
                i11 = i10 + 1;
                objArr[i10] = Opcodes.FLOAT;
            } else if (charAt != 'L') {
                if (!(charAt == 'S' || charAt == 'I')) {
                    if (charAt == 'J') {
                        i11 = i10 + 1;
                        objArr[i10] = Opcodes.LONG;
                    } else if (charAt != 'Z') {
                        if (charAt != '[') {
                            switch (charAt) {
                                case 'B':
                                case 'C':
                                    break;
                                case 'D':
                                    i11 = i10 + 1;
                                    objArr[i10] = Opcodes.DOUBLE;
                                    break;
                                default:
                                    context.currentFrameLocalCount = i10;
                                    return;
                            }
                        } else {
                            while (str.charAt(i14) == '[') {
                                i14++;
                            }
                            if (str.charAt(i14) == 'L') {
                                do {
                                    i14++;
                                } while (str.charAt(i14) != ';');
                            }
                            int i15 = i14 + 1;
                            objArr[i10] = str.substring(i13, i15);
                            i13 = i15;
                            i10++;
                        }
                    }
                }
                i11 = i10 + 1;
                objArr[i10] = Opcodes.INTEGER;
            } else {
                int i16 = i14;
                while (str.charAt(i16) != ';') {
                    i16++;
                }
                objArr[i10] = str.substring(i14, i16);
                i10++;
                i13 = i16 + 1;
            }
            i10 = i11;
            i13 = i14;
        }
    }

    private void createDebugLabel(int i10, Label[] labelArr) {
        if (labelArr[i10] == null) {
            Label readLabel = readLabel(i10, labelArr);
            readLabel.flags = (short) (readLabel.flags | 1);
        }
    }

    private Label createLabel(int i10, Label[] labelArr) {
        Label readLabel = readLabel(i10, labelArr);
        readLabel.flags = (short) (readLabel.flags & -2);
        return readLabel;
    }

    private int getTypeAnnotationBytecodeOffset(int[] iArr, int i10) {
        if (iArr == null || i10 >= iArr.length || readByte(iArr[i10]) < 67) {
            return -1;
        }
        return readUnsignedShort(iArr[i10] + 1);
    }

    private Attribute readAttribute(Attribute[] attributeArr, String str, int i10, int i11, char[] cArr, int i12, Label[] labelArr) {
        String str2 = str;
        for (Attribute attribute : attributeArr) {
            if (attribute.type.equals(str)) {
                return attribute.read(this, i10, i11, cArr, i12, labelArr);
            }
        }
        return new Attribute(str).read(this, i10, i11, (char[]) null, -1, (Label[]) null);
    }

    private int[] readBootstrapMethodsAttribute(int i10) {
        char[] cArr = new char[i10];
        int firstAttributeOffset = getFirstAttributeOffset();
        for (int readUnsignedShort = readUnsignedShort(firstAttributeOffset - 2); readUnsignedShort > 0; readUnsignedShort--) {
            String readUTF8 = readUTF8(firstAttributeOffset, cArr);
            int readInt = readInt(firstAttributeOffset + 2);
            int i11 = firstAttributeOffset + 6;
            if ("BootstrapMethods".equals(readUTF8)) {
                int readUnsignedShort2 = readUnsignedShort(i11);
                int[] iArr = new int[readUnsignedShort2];
                int i12 = i11 + 2;
                for (int i13 = 0; i13 < readUnsignedShort2; i13++) {
                    iArr[i13] = i12;
                    i12 += (readUnsignedShort(i12 + 2) * 2) + 4;
                }
                return iArr;
            }
            firstAttributeOffset = i11 + readInt;
        }
        throw new IllegalArgumentException();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v103, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v113, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v115, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v116, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v119, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v120, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v121, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v95, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v63, resolved type: byte} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x04bd, code lost:
        r13 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x04bf, code lost:
        r34 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x04e0, code lost:
        r36 = r13;
        r0 = r19;
        r1 = r22;
        r13 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x052c, code lost:
        r33 = r3;
        r42 = r6;
        r34 = r9;
        r36 = r13;
        r1 = r22;
        r3 = r0;
        r13 = r4;
        r0 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0763, code lost:
        r3 = r15 + 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x077c, code lost:
        r3 = r15 + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0079, code lost:
        r0 = r0 + 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x0791, code lost:
        r3 = r15 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0793, code lost:
        r0 = r19;
        r1 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0797, code lost:
        r4 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x0799, code lost:
        r9 = r35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x079b, code lost:
        if (r35 == null) goto L_0x07c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x079e, code lost:
        if (r1 >= r9.length) goto L_0x07c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x07a0, code lost:
        if (r0 > r11) goto L_0x07c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x07a2, code lost:
        if (r0 != r11) goto L_0x07bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x07a4, code lost:
        r0 = readTypeAnnotationTarget(r10, r9[r1]);
        readElementValues(r14.visitInsnAnnotation(r10.currentTypeAnnotationTarget, r10.currentTypeAnnotationTargetPath, readUTF8(r0, r13), true), r0 + 2, true, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x07bc, code lost:
        r1 = r1 + 1;
        r0 = getTypeAnnotationBytecodeOffset(r9, r1);
        r35 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x07c5, code lost:
        r2 = r20;
        r5 = r27;
        r15 = r37;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x07cb, code lost:
        if (r15 == null) goto L_0x0808;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x07ce, code lost:
        if (r5 >= r15.length) goto L_0x0808;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x07d0, code lost:
        if (r2 > r11) goto L_0x0808;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x07d2, code lost:
        if (r2 != r11) goto L_0x07f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x07d4, code lost:
        r2 = readTypeAnnotationTarget(r10, r15[r5]);
        r19 = r0;
        r20 = r1;
        r22 = r11;
        readElementValues(r14.visitInsnAnnotation(r10.currentTypeAnnotationTarget, r10.currentTypeAnnotationTargetPath, readUTF8(r2, r13), false), r2 + 2, true, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x07f4, code lost:
        r19 = r0;
        r20 = r1;
        r22 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x07fb, code lost:
        r5 = r5 + 1;
        r2 = getTypeAnnotationBytecodeOffset(r15, r5);
        r0 = r19;
        r1 = r20;
        r11 = r22;
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00da, code lost:
        r0 = r0 + 3;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readCode(net.bytebuddy.jar.asm.MethodVisitor r40, net.bytebuddy.jar.asm.Context r41, int r42) {
        /*
            r39 = this;
            r8 = r39
            r9 = r40
            r10 = r41
            r11 = r42
            byte[] r12 = r8.classFileBuffer
            char[] r13 = r10.charBuffer
            int r14 = r8.readUnsignedShort(r11)
            int r0 = r11 + 2
            int r15 = r8.readUnsignedShort(r0)
            int r0 = r11 + 4
            int r7 = r8.readInt(r0)
            int r16 = r11 + 8
            byte[] r0 = r8.classFileBuffer
            int r0 = r0.length
            int r0 = r0 - r16
            if (r7 > r0) goto L_0x098b
            int r6 = r16 + r7
            int r0 = r7 + 1
            net.bytebuddy.jar.asm.Label[] r5 = new net.bytebuddy.jar.asm.Label[r0]
            r10.currentMethodLabels = r5
            r0 = r16
        L_0x002f:
            r4 = 132(0x84, float:1.85E-43)
            r3 = 8
            if (r0 >= r6) goto L_0x00e6
            int r1 = r0 - r16
            byte r2 = r12[r0]
            r2 = r2 & 255(0xff, float:3.57E-43)
            switch(r2) {
                case 0: goto L_0x00e2;
                case 1: goto L_0x00e2;
                case 2: goto L_0x00e2;
                case 3: goto L_0x00e2;
                case 4: goto L_0x00e2;
                case 5: goto L_0x00e2;
                case 6: goto L_0x00e2;
                case 7: goto L_0x00e2;
                case 8: goto L_0x00e2;
                case 9: goto L_0x00e2;
                case 10: goto L_0x00e2;
                case 11: goto L_0x00e2;
                case 12: goto L_0x00e2;
                case 13: goto L_0x00e2;
                case 14: goto L_0x00e2;
                case 15: goto L_0x00e2;
                case 16: goto L_0x00de;
                case 17: goto L_0x00da;
                case 18: goto L_0x00de;
                case 19: goto L_0x00da;
                case 20: goto L_0x00da;
                case 21: goto L_0x00de;
                case 22: goto L_0x00de;
                case 23: goto L_0x00de;
                case 24: goto L_0x00de;
                case 25: goto L_0x00de;
                case 26: goto L_0x00e2;
                case 27: goto L_0x00e2;
                case 28: goto L_0x00e2;
                case 29: goto L_0x00e2;
                case 30: goto L_0x00e2;
                case 31: goto L_0x00e2;
                case 32: goto L_0x00e2;
                case 33: goto L_0x00e2;
                case 34: goto L_0x00e2;
                case 35: goto L_0x00e2;
                case 36: goto L_0x00e2;
                case 37: goto L_0x00e2;
                case 38: goto L_0x00e2;
                case 39: goto L_0x00e2;
                case 40: goto L_0x00e2;
                case 41: goto L_0x00e2;
                case 42: goto L_0x00e2;
                case 43: goto L_0x00e2;
                case 44: goto L_0x00e2;
                case 45: goto L_0x00e2;
                case 46: goto L_0x00e2;
                case 47: goto L_0x00e2;
                case 48: goto L_0x00e2;
                case 49: goto L_0x00e2;
                case 50: goto L_0x00e2;
                case 51: goto L_0x00e2;
                case 52: goto L_0x00e2;
                case 53: goto L_0x00e2;
                case 54: goto L_0x00de;
                case 55: goto L_0x00de;
                case 56: goto L_0x00de;
                case 57: goto L_0x00de;
                case 58: goto L_0x00de;
                case 59: goto L_0x00e2;
                case 60: goto L_0x00e2;
                case 61: goto L_0x00e2;
                case 62: goto L_0x00e2;
                case 63: goto L_0x00e2;
                case 64: goto L_0x00e2;
                case 65: goto L_0x00e2;
                case 66: goto L_0x00e2;
                case 67: goto L_0x00e2;
                case 68: goto L_0x00e2;
                case 69: goto L_0x00e2;
                case 70: goto L_0x00e2;
                case 71: goto L_0x00e2;
                case 72: goto L_0x00e2;
                case 73: goto L_0x00e2;
                case 74: goto L_0x00e2;
                case 75: goto L_0x00e2;
                case 76: goto L_0x00e2;
                case 77: goto L_0x00e2;
                case 78: goto L_0x00e2;
                case 79: goto L_0x00e2;
                case 80: goto L_0x00e2;
                case 81: goto L_0x00e2;
                case 82: goto L_0x00e2;
                case 83: goto L_0x00e2;
                case 84: goto L_0x00e2;
                case 85: goto L_0x00e2;
                case 86: goto L_0x00e2;
                case 87: goto L_0x00e2;
                case 88: goto L_0x00e2;
                case 89: goto L_0x00e2;
                case 90: goto L_0x00e2;
                case 91: goto L_0x00e2;
                case 92: goto L_0x00e2;
                case 93: goto L_0x00e2;
                case 94: goto L_0x00e2;
                case 95: goto L_0x00e2;
                case 96: goto L_0x00e2;
                case 97: goto L_0x00e2;
                case 98: goto L_0x00e2;
                case 99: goto L_0x00e2;
                case 100: goto L_0x00e2;
                case 101: goto L_0x00e2;
                case 102: goto L_0x00e2;
                case 103: goto L_0x00e2;
                case 104: goto L_0x00e2;
                case 105: goto L_0x00e2;
                case 106: goto L_0x00e2;
                case 107: goto L_0x00e2;
                case 108: goto L_0x00e2;
                case 109: goto L_0x00e2;
                case 110: goto L_0x00e2;
                case 111: goto L_0x00e2;
                case 112: goto L_0x00e2;
                case 113: goto L_0x00e2;
                case 114: goto L_0x00e2;
                case 115: goto L_0x00e2;
                case 116: goto L_0x00e2;
                case 117: goto L_0x00e2;
                case 118: goto L_0x00e2;
                case 119: goto L_0x00e2;
                case 120: goto L_0x00e2;
                case 121: goto L_0x00e2;
                case 122: goto L_0x00e2;
                case 123: goto L_0x00e2;
                case 124: goto L_0x00e2;
                case 125: goto L_0x00e2;
                case 126: goto L_0x00e2;
                case 127: goto L_0x00e2;
                case 128: goto L_0x00e2;
                case 129: goto L_0x00e2;
                case 130: goto L_0x00e2;
                case 131: goto L_0x00e2;
                case 132: goto L_0x00da;
                case 133: goto L_0x00e2;
                case 134: goto L_0x00e2;
                case 135: goto L_0x00e2;
                case 136: goto L_0x00e2;
                case 137: goto L_0x00e2;
                case 138: goto L_0x00e2;
                case 139: goto L_0x00e2;
                case 140: goto L_0x00e2;
                case 141: goto L_0x00e2;
                case 142: goto L_0x00e2;
                case 143: goto L_0x00e2;
                case 144: goto L_0x00e2;
                case 145: goto L_0x00e2;
                case 146: goto L_0x00e2;
                case 147: goto L_0x00e2;
                case 148: goto L_0x00e2;
                case 149: goto L_0x00e2;
                case 150: goto L_0x00e2;
                case 151: goto L_0x00e2;
                case 152: goto L_0x00e2;
                case 153: goto L_0x00d0;
                case 154: goto L_0x00d0;
                case 155: goto L_0x00d0;
                case 156: goto L_0x00d0;
                case 157: goto L_0x00d0;
                case 158: goto L_0x00d0;
                case 159: goto L_0x00d0;
                case 160: goto L_0x00d0;
                case 161: goto L_0x00d0;
                case 162: goto L_0x00d0;
                case 163: goto L_0x00d0;
                case 164: goto L_0x00d0;
                case 165: goto L_0x00d0;
                case 166: goto L_0x00d0;
                case 167: goto L_0x00d0;
                case 168: goto L_0x00d0;
                case 169: goto L_0x00de;
                case 170: goto L_0x00a2;
                case 171: goto L_0x007c;
                case 172: goto L_0x00e2;
                case 173: goto L_0x00e2;
                case 174: goto L_0x00e2;
                case 175: goto L_0x00e2;
                case 176: goto L_0x00e2;
                case 177: goto L_0x00e2;
                case 178: goto L_0x00da;
                case 179: goto L_0x00da;
                case 180: goto L_0x00da;
                case 181: goto L_0x00da;
                case 182: goto L_0x00da;
                case 183: goto L_0x00da;
                case 184: goto L_0x00da;
                case 185: goto L_0x0079;
                case 186: goto L_0x0079;
                case 187: goto L_0x00da;
                case 188: goto L_0x00de;
                case 189: goto L_0x00da;
                case 190: goto L_0x00e2;
                case 191: goto L_0x00e2;
                case 192: goto L_0x00da;
                case 193: goto L_0x00da;
                case 194: goto L_0x00e2;
                case 195: goto L_0x00e2;
                case 196: goto L_0x005e;
                case 197: goto L_0x005b;
                case 198: goto L_0x00d0;
                case 199: goto L_0x00d0;
                case 200: goto L_0x0050;
                case 201: goto L_0x0050;
                case 202: goto L_0x0044;
                case 203: goto L_0x0044;
                case 204: goto L_0x0044;
                case 205: goto L_0x0044;
                case 206: goto L_0x0044;
                case 207: goto L_0x0044;
                case 208: goto L_0x0044;
                case 209: goto L_0x0044;
                case 210: goto L_0x0044;
                case 211: goto L_0x0044;
                case 212: goto L_0x0044;
                case 213: goto L_0x0044;
                case 214: goto L_0x0044;
                case 215: goto L_0x0044;
                case 216: goto L_0x0044;
                case 217: goto L_0x0044;
                case 218: goto L_0x0044;
                case 219: goto L_0x0044;
                case 220: goto L_0x0050;
                default: goto L_0x003e;
            }
        L_0x003e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x0044:
            int r2 = r0 + 1
            int r2 = r8.readUnsignedShort(r2)
            int r1 = r1 + r2
            r8.createLabel(r1, r5)
            goto L_0x00da
        L_0x0050:
            int r2 = r0 + 1
            int r2 = r8.readInt(r2)
            int r1 = r1 + r2
            r8.createLabel(r1, r5)
            goto L_0x0079
        L_0x005b:
            int r0 = r0 + 4
            goto L_0x002f
        L_0x005e:
            int r1 = r0 + 1
            byte r1 = r12[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            if (r1 == r4) goto L_0x0076
            r2 = 169(0xa9, float:2.37E-43)
            if (r1 == r2) goto L_0x005b
            switch(r1) {
                case 21: goto L_0x005b;
                case 22: goto L_0x005b;
                case 23: goto L_0x005b;
                case 24: goto L_0x005b;
                case 25: goto L_0x005b;
                default: goto L_0x006d;
            }
        L_0x006d:
            switch(r1) {
                case 54: goto L_0x005b;
                case 55: goto L_0x005b;
                case 56: goto L_0x005b;
                case 57: goto L_0x005b;
                case 58: goto L_0x005b;
                default: goto L_0x0070;
            }
        L_0x0070:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x0076:
            int r0 = r0 + 6
            goto L_0x002f
        L_0x0079:
            int r0 = r0 + 5
            goto L_0x002f
        L_0x007c:
            r2 = r1 & 3
            int r2 = 4 - r2
            int r0 = r0 + r2
            int r2 = r8.readInt(r0)
            int r2 = r2 + r1
            r8.createLabel(r2, r5)
            int r2 = r0 + 4
            int r2 = r8.readInt(r2)
            int r0 = r0 + r3
        L_0x0090:
            int r3 = r2 + -1
            if (r2 <= 0) goto L_0x002f
            int r2 = r0 + 4
            int r2 = r8.readInt(r2)
            int r2 = r2 + r1
            r8.createLabel(r2, r5)
            int r0 = r0 + 8
            r2 = r3
            goto L_0x0090
        L_0x00a2:
            r2 = r1 & 3
            int r2 = 4 - r2
            int r0 = r0 + r2
            int r2 = r8.readInt(r0)
            int r2 = r2 + r1
            r8.createLabel(r2, r5)
            int r2 = r0 + 8
            int r2 = r8.readInt(r2)
            int r3 = r0 + 4
            int r3 = r8.readInt(r3)
            int r2 = r2 - r3
            r3 = 1
            int r2 = r2 + r3
            int r0 = r0 + 12
        L_0x00c0:
            int r3 = r2 + -1
            if (r2 <= 0) goto L_0x002f
            int r2 = r8.readInt(r0)
            int r2 = r2 + r1
            r8.createLabel(r2, r5)
            int r0 = r0 + 4
            r2 = r3
            goto L_0x00c0
        L_0x00d0:
            int r2 = r0 + 1
            short r2 = r8.readShort(r2)
            int r1 = r1 + r2
            r8.createLabel(r1, r5)
        L_0x00da:
            int r0 = r0 + 3
            goto L_0x002f
        L_0x00de:
            int r0 = r0 + 2
            goto L_0x002f
        L_0x00e2:
            int r0 = r0 + 1
            goto L_0x002f
        L_0x00e6:
            int r1 = r8.readUnsignedShort(r0)
            int r0 = r0 + 2
        L_0x00ec:
            int r2 = r1 + -1
            if (r1 <= 0) goto L_0x012c
            int r1 = r8.readUnsignedShort(r0)
            net.bytebuddy.jar.asm.Label r1 = r8.createLabel(r1, r5)
            int r3 = r0 + 2
            int r3 = r8.readUnsignedShort(r3)
            net.bytebuddy.jar.asm.Label r3 = r8.createLabel(r3, r5)
            int r4 = r0 + 4
            int r4 = r8.readUnsignedShort(r4)
            net.bytebuddy.jar.asm.Label r4 = r8.createLabel(r4, r5)
            r20 = r2
            int[] r2 = r8.cpInfoOffsets
            r21 = r6
            int r6 = r0 + 6
            int r6 = r8.readUnsignedShort(r6)
            r2 = r2[r6]
            java.lang.String r2 = r8.readUTF8(r2, r13)
            int r0 = r0 + 8
            r9.visitTryCatchBlock(r1, r3, r4, r2)
            r1 = r20
            r6 = r21
            r3 = 8
            r4 = 132(0x84, float:1.85E-43)
            goto L_0x00ec
        L_0x012c:
            r21 = r6
            int r1 = r8.readUnsignedShort(r0)
            int r0 = r0 + 2
            r2 = 0
            r3 = 1
            r20 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
        L_0x0142:
            int r27 = r1 + -1
            if (r1 <= 0) goto L_0x0274
            java.lang.String r1 = r8.readUTF8(r0, r13)
            int r6 = r0 + 2
            int r29 = r8.readInt(r6)
            int r6 = r0 + 6
            java.lang.String r0 = "LocalVariableTable"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x018d
            int r0 = r10.parsingOptions
            r0 = r0 & 2
            if (r0 != 0) goto L_0x0187
            int r0 = r8.readUnsignedShort(r6)
            int r1 = r6 + 2
        L_0x0166:
            int r25 = r0 + -1
            if (r0 <= 0) goto L_0x0180
            int r0 = r8.readUnsignedShort(r1)
            r8.createDebugLabel(r0, r5)
            int r4 = r1 + 2
            int r4 = r8.readUnsignedShort(r4)
            int r0 = r0 + r4
            r8.createDebugLabel(r0, r5)
            int r1 = r1 + 10
            r0 = r25
            goto L_0x0166
        L_0x0180:
            r18 = r5
            r19 = r6
            r25 = r19
            goto L_0x019b
        L_0x0187:
            r31 = r2
            r2 = 1
            r4 = 0
            goto L_0x0228
        L_0x018d:
            java.lang.String r0 = "LocalVariableTypeTable"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01a1
            r18 = r5
            r19 = r6
            r26 = r19
        L_0x019b:
            r35 = r7
            r34 = r21
            goto L_0x0232
        L_0x01a1:
            java.lang.String r0 = "LineNumberTable"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01d3
            int r0 = r10.parsingOptions
            r0 = r0 & 2
            if (r0 != 0) goto L_0x0187
            int r0 = r8.readUnsignedShort(r6)
            int r1 = r6 + 2
        L_0x01b5:
            int r4 = r0 + -1
            if (r0 <= 0) goto L_0x0187
            int r0 = r8.readUnsignedShort(r1)
            r31 = r2
            int r2 = r1 + 2
            int r2 = r8.readUnsignedShort(r2)
            int r1 = r1 + 4
            r8.createDebugLabel(r0, r5)
            r0 = r5[r0]
            r0.addLineNumber(r2)
            r0 = r4
            r2 = r31
            goto L_0x01b5
        L_0x01d3:
            r31 = r2
            java.lang.String r0 = "RuntimeVisibleTypeAnnotations"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01e8
            r2 = 1
            int[] r0 = r8.readTypeAnnotations(r9, r10, r6, r2)
            r2 = r0
            r18 = r5
            r19 = r6
            goto L_0x019b
        L_0x01e8:
            r2 = 1
            java.lang.String r0 = "RuntimeInvisibleTypeAnnotations"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01f9
            r4 = 0
            int[] r0 = r8.readTypeAnnotations(r9, r10, r6, r4)
            r22 = r0
            goto L_0x0228
        L_0x01f9:
            r4 = 0
            java.lang.String r0 = "StackMapTable"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0211
            int r0 = r10.parsingOptions
            r0 = r0 & 4
            if (r0 != 0) goto L_0x0228
            int r0 = r6 + 2
            int r1 = r6 + r29
            r20 = r0
            r23 = r1
            goto L_0x0228
        L_0x0211:
            java.lang.String r0 = "StackMap"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0235
            int r0 = r10.parsingOptions
            r0 = r0 & 4
            if (r0 != 0) goto L_0x0228
            int r0 = r6 + 2
            int r1 = r6 + r29
            r20 = r0
            r23 = r1
            r3 = r4
        L_0x0228:
            r18 = r5
            r19 = r6
            r35 = r7
            r34 = r21
            r2 = r31
        L_0x0232:
            r9 = 8
            goto L_0x0264
        L_0x0235:
            net.bytebuddy.jar.asm.Attribute[] r0 = r10.attributePrototypes
            r17 = r0
            r0 = r39
            r30 = r1
            r1 = r17
            r11 = r31
            r2 = r30
            r32 = r3
            r9 = 8
            r3 = r6
            r4 = r29
            r18 = r5
            r5 = r13
            r19 = r6
            r34 = r21
            r6 = r42
            r35 = r7
            r7 = r18
            net.bytebuddy.jar.asm.Attribute r0 = r0.readAttribute(r1, r2, r3, r4, r5, r6, r7)
            r7 = r24
            r0.nextAttribute = r7
            r24 = r0
            r2 = r11
            r3 = r32
        L_0x0264:
            int r0 = r19 + r29
            r9 = r40
            r11 = r42
            r5 = r18
            r1 = r27
            r21 = r34
            r7 = r35
            goto L_0x0142
        L_0x0274:
            r11 = r2
            r32 = r3
            r18 = r5
            r35 = r7
            r34 = r21
            r7 = r24
            r9 = 8
            int r0 = r10.parsingOptions
            r0 = r0 & r9
            if (r0 == 0) goto L_0x0288
            r6 = 1
            goto L_0x0289
        L_0x0288:
            r6 = 0
        L_0x0289:
            r5 = -1
            if (r20 == 0) goto L_0x02e1
            r10.currentFrameOffset = r5
            r4 = 0
            r10.currentFrameType = r4
            r10.currentFrameLocalCount = r4
            r10.currentFrameLocalCountDelta = r4
            java.lang.Object[] r0 = new java.lang.Object[r15]
            r10.currentFrameLocalTypes = r0
            r10.currentFrameStackCount = r4
            java.lang.Object[] r0 = new java.lang.Object[r14]
            r10.currentFrameStackTypes = r0
            if (r6 == 0) goto L_0x02a4
            r8.computeImplicitFrame(r10)
        L_0x02a4:
            r0 = r20
        L_0x02a6:
            r3 = r23
            int r1 = r3 + -2
            if (r0 >= r1) goto L_0x02de
            byte r1 = r12[r0]
            if (r1 != r9) goto L_0x02cf
            int r1 = r0 + 1
            int r1 = r8.readUnsignedShort(r1)
            if (r1 < 0) goto L_0x02cf
            r2 = r35
            if (r1 >= r2) goto L_0x02cc
            int r19 = r16 + r1
            byte r4 = r12[r19]
            r4 = r4 & 255(0xff, float:3.57E-43)
            r5 = 187(0xbb, float:2.62E-43)
            if (r4 != r5) goto L_0x02cc
            r5 = r18
            r8.createLabel(r1, r5)
            goto L_0x02d3
        L_0x02cc:
            r5 = r18
            goto L_0x02d3
        L_0x02cf:
            r5 = r18
            r2 = r35
        L_0x02d3:
            int r0 = r0 + 1
            r35 = r2
            r23 = r3
            r18 = r5
            r4 = 0
            r5 = -1
            goto L_0x02a6
        L_0x02de:
            r5 = r18
            goto L_0x02e5
        L_0x02e1:
            r5 = r18
            r3 = r23
        L_0x02e5:
            r2 = r35
            if (r6 == 0) goto L_0x0309
            int r0 = r10.parsingOptions
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0309
            r1 = -1
            r4 = 0
            r18 = 0
            r19 = 0
            r0 = r40
            r21 = r2
            r2 = r15
            r9 = r3
            r3 = r4
            r24 = r7
            r7 = 0
            r4 = r18
            r36 = r5
            r5 = r19
            r0.visitFrame(r1, r2, r3, r4, r5)
            goto L_0x0311
        L_0x0309:
            r21 = r2
            r9 = r3
            r36 = r5
            r24 = r7
            r7 = 0
        L_0x0311:
            int r0 = r8.getTypeAnnotationBytecodeOffset(r11, r7)
            r5 = r22
            int r1 = r8.getTypeAnnotationBytecodeOffset(r5, r7)
            int r2 = r10.parsingOptions
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 != 0) goto L_0x0326
            r4 = 33
            r18 = r4
            goto L_0x0328
        L_0x0326:
            r18 = r7
        L_0x0328:
            r19 = r0
            r4 = r7
            r22 = r4
            r27 = r22
            r3 = r16
            r0 = r20
            r20 = r1
        L_0x0335:
            r2 = r34
            if (r3 >= r2) goto L_0x082a
            int r1 = r3 - r16
            r8.readBytecodeInstructionOffset(r1)
            r42 = r0
            r7 = r36
            r0 = r7[r1]
            r34 = r2
            if (r0 == 0) goto L_0x035b
            int r2 = r10.parsingOptions
            r2 = r2 & 2
            r23 = r14
            if (r2 != 0) goto L_0x0352
            r2 = 1
            goto L_0x0353
        L_0x0352:
            r2 = 0
        L_0x0353:
            r28 = 8
            r14 = r40
            r0.accept(r14, r2)
            goto L_0x0361
        L_0x035b:
            r23 = r14
            r28 = 8
            r14 = r40
        L_0x0361:
            r0 = r4
            r4 = r42
        L_0x0364:
            if (r4 == 0) goto L_0x03fc
            int r2 = r10.currentFrameOffset
            r29 = r15
            r15 = -1
            if (r2 == r1) goto L_0x0379
            if (r2 != r15) goto L_0x0370
            goto L_0x0379
        L_0x0370:
            r15 = r3
            r14 = r4
            r37 = r5
            r35 = r11
            r11 = r1
            goto L_0x0405
        L_0x0379:
            if (r2 == r15) goto L_0x03c7
            r2 = r32
            if (r2 == 0) goto L_0x03ab
            if (r6 == 0) goto L_0x0382
            goto L_0x03ab
        L_0x0382:
            int r0 = r10.currentFrameType
            int r15 = r10.currentFrameLocalCountDelta
            r30 = r3
            java.lang.Object[] r3 = r10.currentFrameLocalTypes
            r42 = r4
            int r4 = r10.currentFrameStackCount
            r31 = r5
            java.lang.Object[] r5 = r10.currentFrameStackTypes
            r32 = r0
            r0 = r40
            r35 = r11
            r11 = r1
            r1 = r32
            r32 = r34
            r34 = r13
            r13 = r2
            r2 = r15
            r15 = r30
            r14 = r42
            r37 = r31
            r0.visitFrame(r1, r2, r3, r4, r5)
            goto L_0x03c5
        L_0x03ab:
            r15 = r3
            r14 = r4
            r37 = r5
            r35 = r11
            r32 = r34
            r11 = r1
            r34 = r13
            r13 = r2
            r1 = -1
            int r2 = r10.currentFrameLocalCount
            java.lang.Object[] r3 = r10.currentFrameLocalTypes
            int r4 = r10.currentFrameStackCount
            java.lang.Object[] r5 = r10.currentFrameStackTypes
            r0 = r40
            r0.visitFrame(r1, r2, r3, r4, r5)
        L_0x03c5:
            r0 = 0
            goto L_0x03d6
        L_0x03c7:
            r15 = r3
            r14 = r4
            r37 = r5
            r35 = r11
            r11 = r1
            r38 = r34
            r34 = r13
            r13 = r32
            r32 = r38
        L_0x03d6:
            if (r14 >= r9) goto L_0x03e7
            int r4 = r8.readStackMapFrame(r14, r13, r6, r10)
            r14 = r40
            r1 = r11
            r3 = r15
            r15 = r29
            r11 = r35
            r5 = r37
            goto L_0x03f2
        L_0x03e7:
            r14 = r40
            r1 = r11
            r3 = r15
            r15 = r29
            r11 = r35
            r5 = r37
            r4 = 0
        L_0x03f2:
            r38 = r32
            r32 = r13
            r13 = r34
            r34 = r38
            goto L_0x0364
        L_0x03fc:
            r14 = r4
            r37 = r5
            r35 = r11
            r29 = r15
            r11 = r1
            r15 = r3
        L_0x0405:
            r38 = r34
            r34 = r13
            r13 = r32
            r32 = r38
            if (r0 == 0) goto L_0x0423
            int r0 = r10.parsingOptions
            r0 = r0 & 8
            if (r0 == 0) goto L_0x0420
            r1 = 256(0x100, float:3.59E-43)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r0 = r40
            r0.visitFrame(r1, r2, r3, r4, r5)
        L_0x0420:
            r30 = 0
            goto L_0x0425
        L_0x0423:
            r30 = r0
        L_0x0425:
            byte r0 = r12[r15]
            r5 = r0 & 255(0xff, float:3.57E-43)
            r0 = 200(0xc8, float:2.8E-43)
            switch(r5) {
                case 0: goto L_0x077f;
                case 1: goto L_0x077f;
                case 2: goto L_0x077f;
                case 3: goto L_0x077f;
                case 4: goto L_0x077f;
                case 5: goto L_0x077f;
                case 6: goto L_0x077f;
                case 7: goto L_0x077f;
                case 8: goto L_0x077f;
                case 9: goto L_0x077f;
                case 10: goto L_0x077f;
                case 11: goto L_0x077f;
                case 12: goto L_0x077f;
                case 13: goto L_0x077f;
                case 14: goto L_0x077f;
                case 15: goto L_0x077f;
                case 16: goto L_0x0766;
                case 17: goto L_0x074b;
                case 18: goto L_0x072f;
                case 19: goto L_0x0713;
                case 20: goto L_0x0713;
                case 21: goto L_0x06f9;
                case 22: goto L_0x06f9;
                case 23: goto L_0x06f9;
                case 24: goto L_0x06f9;
                case 25: goto L_0x06f9;
                case 26: goto L_0x06dd;
                case 27: goto L_0x06dd;
                case 28: goto L_0x06dd;
                case 29: goto L_0x06dd;
                case 30: goto L_0x06dd;
                case 31: goto L_0x06dd;
                case 32: goto L_0x06dd;
                case 33: goto L_0x06dd;
                case 34: goto L_0x06dd;
                case 35: goto L_0x06dd;
                case 36: goto L_0x06dd;
                case 37: goto L_0x06dd;
                case 38: goto L_0x06dd;
                case 39: goto L_0x06dd;
                case 40: goto L_0x06dd;
                case 41: goto L_0x06dd;
                case 42: goto L_0x06dd;
                case 43: goto L_0x06dd;
                case 44: goto L_0x06dd;
                case 45: goto L_0x06dd;
                case 46: goto L_0x077f;
                case 47: goto L_0x077f;
                case 48: goto L_0x077f;
                case 49: goto L_0x077f;
                case 50: goto L_0x077f;
                case 51: goto L_0x077f;
                case 52: goto L_0x077f;
                case 53: goto L_0x077f;
                case 54: goto L_0x06f9;
                case 55: goto L_0x06f9;
                case 56: goto L_0x06f9;
                case 57: goto L_0x06f9;
                case 58: goto L_0x06f9;
                case 59: goto L_0x06c1;
                case 60: goto L_0x06c1;
                case 61: goto L_0x06c1;
                case 62: goto L_0x06c1;
                case 63: goto L_0x06c1;
                case 64: goto L_0x06c1;
                case 65: goto L_0x06c1;
                case 66: goto L_0x06c1;
                case 67: goto L_0x06c1;
                case 68: goto L_0x06c1;
                case 69: goto L_0x06c1;
                case 70: goto L_0x06c1;
                case 71: goto L_0x06c1;
                case 72: goto L_0x06c1;
                case 73: goto L_0x06c1;
                case 74: goto L_0x06c1;
                case 75: goto L_0x06c1;
                case 76: goto L_0x06c1;
                case 77: goto L_0x06c1;
                case 78: goto L_0x06c1;
                case 79: goto L_0x077f;
                case 80: goto L_0x077f;
                case 81: goto L_0x077f;
                case 82: goto L_0x077f;
                case 83: goto L_0x077f;
                case 84: goto L_0x077f;
                case 85: goto L_0x077f;
                case 86: goto L_0x077f;
                case 87: goto L_0x077f;
                case 88: goto L_0x077f;
                case 89: goto L_0x077f;
                case 90: goto L_0x077f;
                case 91: goto L_0x077f;
                case 92: goto L_0x077f;
                case 93: goto L_0x077f;
                case 94: goto L_0x077f;
                case 95: goto L_0x077f;
                case 96: goto L_0x077f;
                case 97: goto L_0x077f;
                case 98: goto L_0x077f;
                case 99: goto L_0x077f;
                case 100: goto L_0x077f;
                case 101: goto L_0x077f;
                case 102: goto L_0x077f;
                case 103: goto L_0x077f;
                case 104: goto L_0x077f;
                case 105: goto L_0x077f;
                case 106: goto L_0x077f;
                case 107: goto L_0x077f;
                case 108: goto L_0x077f;
                case 109: goto L_0x077f;
                case 110: goto L_0x077f;
                case 111: goto L_0x077f;
                case 112: goto L_0x077f;
                case 113: goto L_0x077f;
                case 114: goto L_0x077f;
                case 115: goto L_0x077f;
                case 116: goto L_0x077f;
                case 117: goto L_0x077f;
                case 118: goto L_0x077f;
                case 119: goto L_0x077f;
                case 120: goto L_0x077f;
                case 121: goto L_0x077f;
                case 122: goto L_0x077f;
                case 123: goto L_0x077f;
                case 124: goto L_0x077f;
                case 125: goto L_0x077f;
                case 126: goto L_0x077f;
                case 127: goto L_0x077f;
                case 128: goto L_0x077f;
                case 129: goto L_0x077f;
                case 130: goto L_0x077f;
                case 131: goto L_0x077f;
                case 132: goto L_0x06a4;
                case 133: goto L_0x077f;
                case 134: goto L_0x077f;
                case 135: goto L_0x077f;
                case 136: goto L_0x077f;
                case 137: goto L_0x077f;
                case 138: goto L_0x077f;
                case 139: goto L_0x077f;
                case 140: goto L_0x077f;
                case 141: goto L_0x077f;
                case 142: goto L_0x077f;
                case 143: goto L_0x077f;
                case 144: goto L_0x077f;
                case 145: goto L_0x077f;
                case 146: goto L_0x077f;
                case 147: goto L_0x077f;
                case 148: goto L_0x077f;
                case 149: goto L_0x077f;
                case 150: goto L_0x077f;
                case 151: goto L_0x077f;
                case 152: goto L_0x077f;
                case 153: goto L_0x0686;
                case 154: goto L_0x0686;
                case 155: goto L_0x0686;
                case 156: goto L_0x0686;
                case 157: goto L_0x0686;
                case 158: goto L_0x0686;
                case 159: goto L_0x0686;
                case 160: goto L_0x0686;
                case 161: goto L_0x0686;
                case 162: goto L_0x0686;
                case 163: goto L_0x0686;
                case 164: goto L_0x0686;
                case 165: goto L_0x0686;
                case 166: goto L_0x0686;
                case 167: goto L_0x0686;
                case 168: goto L_0x0686;
                case 169: goto L_0x06f9;
                case 170: goto L_0x0640;
                case 171: goto L_0x05fa;
                case 172: goto L_0x077f;
                case 173: goto L_0x077f;
                case 174: goto L_0x077f;
                case 175: goto L_0x077f;
                case 176: goto L_0x077f;
                case 177: goto L_0x077f;
                case 178: goto L_0x059f;
                case 179: goto L_0x059f;
                case 180: goto L_0x059f;
                case 181: goto L_0x059f;
                case 182: goto L_0x059f;
                case 183: goto L_0x059f;
                case 184: goto L_0x059f;
                case 185: goto L_0x059f;
                case 186: goto L_0x053c;
                case 187: goto L_0x0519;
                case 188: goto L_0x0766;
                case 189: goto L_0x0519;
                case 190: goto L_0x077f;
                case 191: goto L_0x077f;
                case 192: goto L_0x0519;
                case 193: goto L_0x0519;
                case 194: goto L_0x077f;
                case 195: goto L_0x077f;
                case 196: goto L_0x04eb;
                case 197: goto L_0x04c5;
                case 198: goto L_0x0686;
                case 199: goto L_0x0686;
                case 200: goto L_0x049e;
                case 201: goto L_0x049e;
                case 202: goto L_0x0453;
                case 203: goto L_0x0453;
                case 204: goto L_0x0453;
                case 205: goto L_0x0453;
                case 206: goto L_0x0453;
                case 207: goto L_0x0453;
                case 208: goto L_0x0453;
                case 209: goto L_0x0453;
                case 210: goto L_0x0453;
                case 211: goto L_0x0453;
                case 212: goto L_0x0453;
                case 213: goto L_0x0453;
                case 214: goto L_0x0453;
                case 215: goto L_0x0453;
                case 216: goto L_0x0453;
                case 217: goto L_0x0453;
                case 218: goto L_0x0453;
                case 219: goto L_0x0453;
                case 220: goto L_0x0434;
                default: goto L_0x042e;
            }
        L_0x042e:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x0434:
            int r3 = r15 + 1
            int r1 = r8.readInt(r3)
            int r1 = r1 + r11
            r1 = r7[r1]
            r31 = r14
            r14 = r40
            r14.visitJumpInsn(r0, r1)
            int r3 = r15 + 5
            r42 = r6
            r36 = r13
            r0 = r19
            r1 = r22
            r13 = r34
            r4 = 1
            goto L_0x04bf
        L_0x0453:
            r31 = r14
            r14 = r40
            r1 = 218(0xda, float:3.05E-43)
            if (r5 >= r1) goto L_0x045e
            int r5 = r5 + -49
            goto L_0x0460
        L_0x045e:
            int r5 = r5 + -20
        L_0x0460:
            int r3 = r15 + 1
            int r1 = r8.readUnsignedShort(r3)
            int r1 = r1 + r11
            r1 = r7[r1]
            r2 = 167(0xa7, float:2.34E-43)
            if (r5 == r2) goto L_0x048b
            r3 = 168(0xa8, float:2.35E-43)
            if (r5 != r3) goto L_0x0472
            goto L_0x048b
        L_0x0472:
            if (r5 >= r2) goto L_0x047b
            int r5 = r5 + 1
            r2 = 1
            r3 = r5 ^ 1
            int r3 = r3 - r2
            goto L_0x047d
        L_0x047b:
            r3 = r5 ^ 1
        L_0x047d:
            int r2 = r11 + 3
            net.bytebuddy.jar.asm.Label r2 = r8.createLabel(r2, r7)
            r14.visitJumpInsn(r3, r2)
            r14.visitJumpInsn(r0, r1)
            r2 = 1
            goto L_0x0492
        L_0x048b:
            int r5 = r5 + 33
            r14.visitJumpInsn(r5, r1)
            r2 = r30
        L_0x0492:
            int r3 = r15 + 3
            r4 = r2
            r42 = r6
            r36 = r13
            r0 = r19
            r1 = r22
            goto L_0x04bd
        L_0x049e:
            r31 = r14
            r14 = r40
            int r5 = r5 - r18
            int r3 = r15 + 1
            int r0 = r8.readInt(r3)
            int r1 = r11 + r0
            r0 = r7[r1]
            r14.visitJumpInsn(r5, r0)
            int r3 = r15 + 5
            r42 = r6
            r36 = r13
            r0 = r19
            r1 = r22
            r4 = r30
        L_0x04bd:
            r13 = r34
        L_0x04bf:
            r33 = 132(0x84, float:1.85E-43)
            r34 = r9
            goto L_0x0799
        L_0x04c5:
            r31 = r14
            r14 = r40
            int r3 = r15 + 1
            r4 = r34
            java.lang.String r0 = r8.readClass(r3, r4)
            int r3 = r15 + 3
            byte r1 = r12[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r14.visitMultiANewArrayInsn(r0, r1)
            int r3 = r15 + 4
            r42 = r6
            r34 = r9
        L_0x04e0:
            r36 = r13
            r0 = r19
            r1 = r22
            r33 = 132(0x84, float:1.85E-43)
            r13 = r4
            goto L_0x0797
        L_0x04eb:
            r31 = r14
            r4 = r34
            r14 = r40
            int r3 = r15 + 1
            byte r0 = r12[r3]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r3 = 132(0x84, float:1.85E-43)
            if (r0 != r3) goto L_0x050d
            int r0 = r15 + 2
            int r0 = r8.readUnsignedShort(r0)
            int r1 = r15 + 4
            short r1 = r8.readShort(r1)
            r14.visitIincInsn(r0, r1)
            int r0 = r15 + 6
            goto L_0x052c
        L_0x050d:
            int r1 = r15 + 2
            int r1 = r8.readUnsignedShort(r1)
            r14.visitVarInsn(r0, r1)
            int r0 = r15 + 4
            goto L_0x052c
        L_0x0519:
            r31 = r14
            r4 = r34
            r3 = 132(0x84, float:1.85E-43)
            r14 = r40
            int r0 = r15 + 1
            java.lang.String r0 = r8.readClass(r0, r4)
            r14.visitTypeInsn(r5, r0)
            int r0 = r15 + 3
        L_0x052c:
            r33 = r3
            r42 = r6
            r34 = r9
            r36 = r13
            r1 = r22
            r3 = r0
            r13 = r4
            r0 = r19
            goto L_0x0797
        L_0x053c:
            r31 = r14
            r4 = r34
            r3 = 132(0x84, float:1.85E-43)
            r14 = r40
            int[] r0 = r8.cpInfoOffsets
            int r1 = r15 + 1
            int r1 = r8.readUnsignedShort(r1)
            r0 = r0[r1]
            int[] r1 = r8.cpInfoOffsets
            int r2 = r0 + 2
            int r2 = r8.readUnsignedShort(r2)
            r1 = r1[r2]
            java.lang.String r2 = r8.readUTF8(r1, r4)
            int r1 = r1 + 2
            java.lang.String r1 = r8.readUTF8(r1, r4)
            int[] r5 = r8.bootstrapMethodOffsets
            int r0 = r8.readUnsignedShort(r0)
            r0 = r5[r0]
            int r5 = r8.readUnsignedShort(r0)
            java.lang.Object r5 = r8.readConst(r5, r4)
            net.bytebuddy.jar.asm.Handle r5 = (net.bytebuddy.jar.asm.Handle) r5
            int r3 = r0 + 2
            int r3 = r8.readUnsignedShort(r3)
            r42 = r6
            java.lang.Object[] r6 = new java.lang.Object[r3]
            int r0 = r0 + 4
            r34 = r9
            r9 = 0
        L_0x0583:
            if (r9 >= r3) goto L_0x0598
            r36 = r3
            int r3 = r8.readUnsignedShort(r0)
            java.lang.Object r3 = r8.readConst(r3, r4)
            r6[r9] = r3
            int r0 = r0 + 2
            int r9 = r9 + 1
            r3 = r36
            goto L_0x0583
        L_0x0598:
            r14.visitInvokeDynamicInsn(r2, r1, r5, r6)
            int r3 = r15 + 5
            goto L_0x04e0
        L_0x059f:
            r42 = r6
            r31 = r14
            r4 = r34
            r14 = r40
            r34 = r9
            int[] r0 = r8.cpInfoOffsets
            int r3 = r15 + 1
            int r1 = r8.readUnsignedShort(r3)
            r0 = r0[r1]
            int[] r1 = r8.cpInfoOffsets
            int r2 = r0 + 2
            int r2 = r8.readUnsignedShort(r2)
            r1 = r1[r2]
            java.lang.String r2 = r8.readClass(r0, r4)
            java.lang.String r3 = r8.readUTF8(r1, r4)
            int r1 = r1 + 2
            java.lang.String r6 = r8.readUTF8(r1, r4)
            r1 = 182(0xb6, float:2.55E-43)
            if (r5 >= r1) goto L_0x05d9
            r14.visitFieldInsn(r5, r2, r3, r6)
            r6 = r5
            r36 = r13
            r33 = 132(0x84, float:1.85E-43)
            r13 = r4
            goto L_0x05f2
        L_0x05d9:
            int r0 = r0 + -1
            byte r0 = r12[r0]
            r1 = 11
            if (r0 != r1) goto L_0x05e3
            r9 = 1
            goto L_0x05e4
        L_0x05e3:
            r9 = 0
        L_0x05e4:
            r0 = r40
            r1 = r5
            r33 = 132(0x84, float:1.85E-43)
            r36 = r13
            r13 = r4
            r4 = r6
            r6 = r5
            r5 = r9
            r0.visitMethodInsn(r1, r2, r3, r4, r5)
        L_0x05f2:
            r0 = 185(0xb9, float:2.59E-43)
            if (r6 != r0) goto L_0x0763
            int r3 = r15 + 5
            goto L_0x0793
        L_0x05fa:
            r42 = r6
            r36 = r13
            r31 = r14
            r13 = r34
            r33 = 132(0x84, float:1.85E-43)
            r14 = r40
            r34 = r9
            r0 = r11 & 3
            int r0 = 4 - r0
            int r3 = r15 + r0
            int r0 = r8.readInt(r3)
            int r1 = r11 + r0
            r0 = r7[r1]
            int r1 = r3 + 4
            int r1 = r8.readInt(r1)
            int r3 = r3 + 8
            int[] r2 = new int[r1]
            net.bytebuddy.jar.asm.Label[] r4 = new net.bytebuddy.jar.asm.Label[r1]
            r5 = 0
        L_0x0623:
            if (r5 >= r1) goto L_0x063b
            int r6 = r8.readInt(r3)
            r2[r5] = r6
            int r6 = r3 + 4
            int r6 = r8.readInt(r6)
            int r6 = r6 + r11
            r6 = r7[r6]
            r4[r5] = r6
            int r3 = r3 + 8
            int r5 = r5 + 1
            goto L_0x0623
        L_0x063b:
            r14.visitLookupSwitchInsn(r0, r2, r4)
            goto L_0x0793
        L_0x0640:
            r42 = r6
            r36 = r13
            r31 = r14
            r13 = r34
            r33 = 132(0x84, float:1.85E-43)
            r14 = r40
            r34 = r9
            r0 = r11 & 3
            int r0 = 4 - r0
            int r3 = r15 + r0
            int r0 = r8.readInt(r3)
            int r1 = r11 + r0
            r0 = r7[r1]
            int r1 = r3 + 4
            int r1 = r8.readInt(r1)
            int r2 = r3 + 8
            int r2 = r8.readInt(r2)
            int r3 = r3 + 12
            int r4 = r2 - r1
            r5 = 1
            int r4 = r4 + r5
            net.bytebuddy.jar.asm.Label[] r5 = new net.bytebuddy.jar.asm.Label[r4]
            r6 = 0
        L_0x0671:
            if (r6 >= r4) goto L_0x0681
            int r9 = r8.readInt(r3)
            int r9 = r9 + r11
            r9 = r7[r9]
            r5[r6] = r9
            int r3 = r3 + 4
            int r6 = r6 + 1
            goto L_0x0671
        L_0x0681:
            r14.visitTableSwitchInsn(r1, r2, r0, r5)
            goto L_0x0793
        L_0x0686:
            r42 = r6
            r36 = r13
            r31 = r14
            r13 = r34
            r33 = 132(0x84, float:1.85E-43)
            r14 = r40
            r6 = r5
            r34 = r9
            int r3 = r15 + 1
            short r0 = r8.readShort(r3)
            int r1 = r11 + r0
            r0 = r7[r1]
            r14.visitJumpInsn(r6, r0)
            goto L_0x0763
        L_0x06a4:
            r42 = r6
            r36 = r13
            r31 = r14
            r13 = r34
            r33 = 132(0x84, float:1.85E-43)
            r14 = r40
            r34 = r9
            int r3 = r15 + 1
            byte r0 = r12[r3]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r3 = r15 + 2
            byte r1 = r12[r3]
            r14.visitIincInsn(r0, r1)
            goto L_0x0763
        L_0x06c1:
            r42 = r6
            r36 = r13
            r31 = r14
            r13 = r34
            r33 = 132(0x84, float:1.85E-43)
            r14 = r40
            r6 = r5
            r34 = r9
            int r5 = r6 + -59
            int r0 = r5 >> 2
            int r0 = r0 + 54
            r1 = r5 & 3
            r14.visitVarInsn(r0, r1)
            goto L_0x0791
        L_0x06dd:
            r42 = r6
            r36 = r13
            r31 = r14
            r13 = r34
            r33 = 132(0x84, float:1.85E-43)
            r14 = r40
            r6 = r5
            r34 = r9
            int r5 = r6 + -26
            int r0 = r5 >> 2
            int r0 = r0 + 21
            r1 = r5 & 3
            r14.visitVarInsn(r0, r1)
            goto L_0x0791
        L_0x06f9:
            r42 = r6
            r36 = r13
            r31 = r14
            r13 = r34
            r33 = 132(0x84, float:1.85E-43)
            r14 = r40
            r6 = r5
            r34 = r9
            int r3 = r15 + 1
            byte r0 = r12[r3]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r14.visitVarInsn(r6, r0)
            goto L_0x077c
        L_0x0713:
            r42 = r6
            r36 = r13
            r31 = r14
            r13 = r34
            r33 = 132(0x84, float:1.85E-43)
            r14 = r40
            r34 = r9
            int r3 = r15 + 1
            int r0 = r8.readUnsignedShort(r3)
            java.lang.Object r0 = r8.readConst(r0, r13)
            r14.visitLdcInsn(r0)
            goto L_0x0763
        L_0x072f:
            r42 = r6
            r36 = r13
            r31 = r14
            r13 = r34
            r33 = 132(0x84, float:1.85E-43)
            r14 = r40
            r34 = r9
            int r3 = r15 + 1
            byte r0 = r12[r3]
            r0 = r0 & 255(0xff, float:3.57E-43)
            java.lang.Object r0 = r8.readConst(r0, r13)
            r14.visitLdcInsn(r0)
            goto L_0x077c
        L_0x074b:
            r42 = r6
            r36 = r13
            r31 = r14
            r13 = r34
            r33 = 132(0x84, float:1.85E-43)
            r14 = r40
            r6 = r5
            r34 = r9
            int r3 = r15 + 1
            short r0 = r8.readShort(r3)
            r14.visitIntInsn(r6, r0)
        L_0x0763:
            int r3 = r15 + 3
            goto L_0x0793
        L_0x0766:
            r42 = r6
            r36 = r13
            r31 = r14
            r13 = r34
            r33 = 132(0x84, float:1.85E-43)
            r14 = r40
            r6 = r5
            r34 = r9
            int r3 = r15 + 1
            byte r0 = r12[r3]
            r14.visitIntInsn(r6, r0)
        L_0x077c:
            int r3 = r15 + 2
            goto L_0x0793
        L_0x077f:
            r42 = r6
            r36 = r13
            r31 = r14
            r13 = r34
            r33 = 132(0x84, float:1.85E-43)
            r14 = r40
            r6 = r5
            r34 = r9
            r14.visitInsn(r6)
        L_0x0791:
            int r3 = r15 + 1
        L_0x0793:
            r0 = r19
            r1 = r22
        L_0x0797:
            r4 = r30
        L_0x0799:
            r9 = r35
            if (r35 == 0) goto L_0x07c5
            int r2 = r9.length
            if (r1 >= r2) goto L_0x07c5
            if (r0 > r11) goto L_0x07c5
            if (r0 != r11) goto L_0x07bc
            r0 = r9[r1]
            int r0 = r8.readTypeAnnotationTarget(r10, r0)
            java.lang.String r2 = r8.readUTF8(r0, r13)
            int r0 = r0 + 2
            int r5 = r10.currentTypeAnnotationTarget
            net.bytebuddy.jar.asm.TypePath r6 = r10.currentTypeAnnotationTargetPath
            r15 = 1
            net.bytebuddy.jar.asm.AnnotationVisitor r2 = r14.visitInsnAnnotation(r5, r6, r2, r15)
            r8.readElementValues(r2, r0, r15, r13)
        L_0x07bc:
            int r1 = r1 + 1
            int r0 = r8.getTypeAnnotationBytecodeOffset(r9, r1)
            r35 = r9
            goto L_0x0799
        L_0x07c5:
            r2 = r20
            r5 = r27
            r15 = r37
        L_0x07cb:
            if (r15 == 0) goto L_0x0808
            int r6 = r15.length
            if (r5 >= r6) goto L_0x0808
            if (r2 > r11) goto L_0x0808
            if (r2 != r11) goto L_0x07f4
            r2 = r15[r5]
            int r2 = r8.readTypeAnnotationTarget(r10, r2)
            java.lang.String r6 = r8.readUTF8(r2, r13)
            int r2 = r2 + 2
            r19 = r0
            int r0 = r10.currentTypeAnnotationTarget
            r20 = r1
            net.bytebuddy.jar.asm.TypePath r1 = r10.currentTypeAnnotationTargetPath
            r22 = r11
            r11 = 0
            net.bytebuddy.jar.asm.AnnotationVisitor r0 = r14.visitInsnAnnotation(r0, r1, r6, r11)
            r1 = 1
            r8.readElementValues(r0, r2, r1, r13)
            goto L_0x07fb
        L_0x07f4:
            r19 = r0
            r20 = r1
            r22 = r11
            r11 = 0
        L_0x07fb:
            int r5 = r5 + 1
            int r2 = r8.getTypeAnnotationBytecodeOffset(r15, r5)
            r0 = r19
            r1 = r20
            r11 = r22
            goto L_0x07cb
        L_0x0808:
            r19 = r0
            r20 = r1
            r11 = 0
            r6 = r42
            r27 = r5
            r5 = r15
            r22 = r20
            r14 = r23
            r15 = r29
            r0 = r31
            r20 = r2
            r38 = r36
            r36 = r7
            r7 = r11
            r11 = r9
            r9 = r34
            r34 = r32
            r32 = r38
            goto L_0x0335
        L_0x082a:
            r9 = r11
            r23 = r14
            r29 = r15
            r14 = r40
            r15 = r5
            r11 = r7
            r7 = r36
            r0 = r7[r21]
            if (r0 == 0) goto L_0x083c
            r14.visitLabel(r0)
        L_0x083c:
            r4 = r25
            if (r4 == 0) goto L_0x08d3
            int r0 = r10.parsingOptions
            r0 = r0 & 2
            if (r0 != 0) goto L_0x08d3
            r0 = r26
            if (r0 == 0) goto L_0x0874
            int r1 = r8.readUnsignedShort(r0)
            int r1 = r1 * 3
            int[] r6 = new int[r1]
            int r26 = r0 + 2
            r0 = r26
        L_0x0856:
            if (r1 <= 0) goto L_0x0872
            int r1 = r1 + -1
            int r2 = r0 + 6
            r6[r1] = r2
            r2 = -1
            int r1 = r1 + r2
            int r3 = r0 + 8
            int r3 = r8.readUnsignedShort(r3)
            r6[r1] = r3
            int r1 = r1 + r2
            int r3 = r8.readUnsignedShort(r0)
            r6[r1] = r3
            int r0 = r0 + 10
            goto L_0x0856
        L_0x0872:
            r12 = r6
            goto L_0x0875
        L_0x0874:
            r12 = 0
        L_0x0875:
            int r0 = r8.readUnsignedShort(r4)
            int r25 = r4 + 2
            r1 = r25
        L_0x087d:
            int r16 = r0 + -1
            if (r0 <= 0) goto L_0x08d3
            int r0 = r8.readUnsignedShort(r1)
            int r2 = r1 + 2
            int r2 = r8.readUnsignedShort(r2)
            int r3 = r1 + 4
            java.lang.String r3 = r8.readUTF8(r3, r13)
            int r4 = r1 + 6
            java.lang.String r4 = r8.readUTF8(r4, r13)
            int r5 = r1 + 8
            int r6 = r8.readUnsignedShort(r5)
            int r18 = r1 + 10
            if (r12 == 0) goto L_0x08bc
            r1 = r11
        L_0x08a2:
            int r5 = r12.length
            if (r1 >= r5) goto L_0x08bc
            r5 = r12[r1]
            if (r5 != r0) goto L_0x08b9
            int r5 = r1 + 1
            r5 = r12[r5]
            if (r5 != r6) goto L_0x08b9
            int r1 = r1 + 2
            r1 = r12[r1]
            java.lang.String r1 = r8.readUTF8(r1, r13)
            r5 = r1
            goto L_0x08bd
        L_0x08b9:
            int r1 = r1 + 3
            goto L_0x08a2
        L_0x08bc:
            r5 = 0
        L_0x08bd:
            r19 = r7[r0]
            int r0 = r0 + r2
            r20 = r7[r0]
            r0 = r40
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r19
            r5 = r20
            r0.visitLocalVariable(r1, r2, r3, r4, r5, r6)
            r0 = r16
            r1 = r18
            goto L_0x087d
        L_0x08d3:
            r12 = 65
            r7 = 64
            if (r9 == 0) goto L_0x092c
            int r6 = r9.length
            r5 = r11
        L_0x08db:
            if (r5 >= r6) goto L_0x092c
            r0 = r9[r5]
            int r1 = r8.readByte(r0)
            if (r1 == r7) goto L_0x08f0
            if (r1 != r12) goto L_0x08e8
            goto L_0x08f0
        L_0x08e8:
            r19 = r5
            r20 = r6
            r12 = r7
            r16 = r11
            goto L_0x0922
        L_0x08f0:
            int r0 = r8.readTypeAnnotationTarget(r10, r0)
            java.lang.String r16 = r8.readUTF8(r0, r13)
            int r4 = r0 + 2
            int r1 = r10.currentTypeAnnotationTarget
            net.bytebuddy.jar.asm.TypePath r2 = r10.currentTypeAnnotationTargetPath
            net.bytebuddy.jar.asm.Label[] r3 = r10.currentLocalVariableAnnotationRangeStarts
            net.bytebuddy.jar.asm.Label[] r0 = r10.currentLocalVariableAnnotationRangeEnds
            int[] r7 = r10.currentLocalVariableAnnotationRangeIndices
            r18 = 1
            r19 = r0
            r0 = r40
            r11 = r4
            r4 = r19
            r19 = r5
            r5 = r7
            r20 = r6
            r6 = r16
            r12 = 64
            r16 = 0
            r7 = r18
            net.bytebuddy.jar.asm.AnnotationVisitor r0 = r0.visitLocalVariableAnnotation(r1, r2, r3, r4, r5, r6, r7)
            r1 = 1
            r8.readElementValues(r0, r11, r1, r13)
        L_0x0922:
            int r5 = r19 + 1
            r7 = r12
            r11 = r16
            r6 = r20
            r12 = 65
            goto L_0x08db
        L_0x092c:
            r12 = r7
            r16 = r11
            if (r15 == 0) goto L_0x0975
            int r9 = r15.length
            r11 = r16
        L_0x0934:
            if (r11 >= r9) goto L_0x0975
            r0 = r15[r11]
            int r1 = r8.readByte(r0)
            r7 = 65
            if (r1 == r12) goto L_0x0947
            if (r1 != r7) goto L_0x0943
            goto L_0x0947
        L_0x0943:
            r18 = r7
            r1 = 1
            goto L_0x0970
        L_0x0947:
            int r0 = r8.readTypeAnnotationTarget(r10, r0)
            java.lang.String r6 = r8.readUTF8(r0, r13)
            int r5 = r0 + 2
            int r1 = r10.currentTypeAnnotationTarget
            net.bytebuddy.jar.asm.TypePath r2 = r10.currentTypeAnnotationTargetPath
            net.bytebuddy.jar.asm.Label[] r3 = r10.currentLocalVariableAnnotationRangeStarts
            net.bytebuddy.jar.asm.Label[] r4 = r10.currentLocalVariableAnnotationRangeEnds
            int[] r0 = r10.currentLocalVariableAnnotationRangeIndices
            r16 = 0
            r18 = r0
            r0 = r40
            r12 = r5
            r5 = r18
            r18 = r7
            r7 = r16
            net.bytebuddy.jar.asm.AnnotationVisitor r0 = r0.visitLocalVariableAnnotation(r1, r2, r3, r4, r5, r6, r7)
            r1 = 1
            r8.readElementValues(r0, r12, r1, r13)
        L_0x0970:
            int r11 = r11 + 1
            r12 = 64
            goto L_0x0934
        L_0x0975:
            r0 = r24
        L_0x0977:
            if (r0 == 0) goto L_0x0983
            net.bytebuddy.jar.asm.Attribute r1 = r0.nextAttribute
            r2 = 0
            r0.nextAttribute = r2
            r14.visitAttribute(r0)
            r0 = r1
            goto L_0x0977
        L_0x0983:
            r0 = r23
            r1 = r29
            r14.visitMaxs(r0, r1)
            return
        L_0x098b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.ClassReader.readCode(net.bytebuddy.jar.asm.MethodVisitor, net.bytebuddy.jar.asm.Context, int):void");
    }

    private ConstantDynamic readConstantDynamic(int i10, char[] cArr) {
        ConstantDynamic constantDynamic = this.constantDynamicValues[i10];
        if (constantDynamic != null) {
            return constantDynamic;
        }
        int[] iArr = this.cpInfoOffsets;
        int i11 = iArr[i10];
        int i12 = iArr[readUnsignedShort(i11 + 2)];
        String readUTF8 = readUTF8(i12, cArr);
        String readUTF82 = readUTF8(i12 + 2, cArr);
        int i13 = this.bootstrapMethodOffsets[readUnsignedShort(i11)];
        Handle handle = (Handle) readConst(readUnsignedShort(i13), cArr);
        int readUnsignedShort = readUnsignedShort(i13 + 2);
        Object[] objArr = new Object[readUnsignedShort];
        int i14 = i13 + 4;
        for (int i15 = 0; i15 < readUnsignedShort; i15++) {
            objArr[i15] = readConst(readUnsignedShort(i14), cArr);
            i14 += 2;
        }
        ConstantDynamic[] constantDynamicArr = this.constantDynamicValues;
        ConstantDynamic constantDynamic2 = new ConstantDynamic(readUTF8, readUTF82, handle, objArr);
        constantDynamicArr[i10] = constantDynamic2;
        return constantDynamic2;
    }

    private int readElementValue(AnnotationVisitor annotationVisitor, int i10, String str, char[] cArr) {
        Boolean bool;
        boolean z10;
        int i11 = 0;
        if (annotationVisitor == null) {
            byte b10 = this.classFileBuffer[i10] & 255;
            if (b10 == 64) {
                return readElementValues((AnnotationVisitor) null, i10 + 3, true, cArr);
            }
            if (b10 == 91) {
                return readElementValues((AnnotationVisitor) null, i10 + 1, false, cArr);
            }
            if (b10 != 101) {
                return i10 + 3;
            }
            return i10 + 5;
        }
        int i12 = i10 + 1;
        byte b11 = this.classFileBuffer[i10] & 255;
        if (b11 == 64) {
            return readElementValues(annotationVisitor.visitAnnotation(str, readUTF8(i12, cArr)), i12 + 2, true, cArr);
        }
        if (b11 != 70) {
            if (b11 == 83) {
                annotationVisitor.visit(str, Short.valueOf((short) readInt(this.cpInfoOffsets[readUnsignedShort(i12)])));
            } else if (b11 == 99) {
                annotationVisitor.visit(str, Type.getType(readUTF8(i12, cArr)));
            } else if (b11 == 101) {
                annotationVisitor.visitEnum(str, readUTF8(i12, cArr), readUTF8(i12 + 2, cArr));
                return i12 + 4;
            } else if (b11 == 115) {
                annotationVisitor.visit(str, readUTF8(i12, cArr));
            } else if (!(b11 == 73 || b11 == 74)) {
                if (b11 == 90) {
                    if (readInt(this.cpInfoOffsets[readUnsignedShort(i12)]) == 0) {
                        bool = Boolean.FALSE;
                    } else {
                        bool = Boolean.TRUE;
                    }
                    annotationVisitor.visit(str, bool);
                } else if (b11 != 91) {
                    switch (b11) {
                        case 66:
                            annotationVisitor.visit(str, Byte.valueOf((byte) readInt(this.cpInfoOffsets[readUnsignedShort(i12)])));
                            break;
                        case 67:
                            annotationVisitor.visit(str, Character.valueOf((char) readInt(this.cpInfoOffsets[readUnsignedShort(i12)])));
                            break;
                        case 68:
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                } else {
                    int readUnsignedShort = readUnsignedShort(i12);
                    int i13 = i12 + 2;
                    if (readUnsignedShort == 0) {
                        return readElementValues(annotationVisitor.visitArray(str), i13 - 2, false, cArr);
                    }
                    byte b12 = this.classFileBuffer[i13] & 255;
                    if (b12 == 70) {
                        float[] fArr = new float[readUnsignedShort];
                        while (i11 < readUnsignedShort) {
                            fArr[i11] = Float.intBitsToFloat(readInt(this.cpInfoOffsets[readUnsignedShort(i13 + 1)]));
                            i13 += 3;
                            i11++;
                        }
                        annotationVisitor.visit(str, fArr);
                        return i13;
                    } else if (b12 == 83) {
                        short[] sArr = new short[readUnsignedShort];
                        while (i11 < readUnsignedShort) {
                            sArr[i11] = (short) readInt(this.cpInfoOffsets[readUnsignedShort(i13 + 1)]);
                            i13 += 3;
                            i11++;
                        }
                        annotationVisitor.visit(str, sArr);
                        return i13;
                    } else if (b12 == 90) {
                        boolean[] zArr = new boolean[readUnsignedShort];
                        for (int i14 = 0; i14 < readUnsignedShort; i14++) {
                            if (readInt(this.cpInfoOffsets[readUnsignedShort(i13 + 1)]) != 0) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            zArr[i14] = z10;
                            i13 += 3;
                        }
                        annotationVisitor.visit(str, zArr);
                        return i13;
                    } else if (b12 == 73) {
                        int[] iArr = new int[readUnsignedShort];
                        while (i11 < readUnsignedShort) {
                            iArr[i11] = readInt(this.cpInfoOffsets[readUnsignedShort(i13 + 1)]);
                            i13 += 3;
                            i11++;
                        }
                        annotationVisitor.visit(str, iArr);
                        return i13;
                    } else if (b12 != 74) {
                        switch (b12) {
                            case 66:
                                byte[] bArr = new byte[readUnsignedShort];
                                while (i11 < readUnsignedShort) {
                                    bArr[i11] = (byte) readInt(this.cpInfoOffsets[readUnsignedShort(i13 + 1)]);
                                    i13 += 3;
                                    i11++;
                                }
                                annotationVisitor.visit(str, bArr);
                                return i13;
                            case 67:
                                char[] cArr2 = new char[readUnsignedShort];
                                while (i11 < readUnsignedShort) {
                                    cArr2[i11] = (char) readInt(this.cpInfoOffsets[readUnsignedShort(i13 + 1)]);
                                    i13 += 3;
                                    i11++;
                                }
                                annotationVisitor.visit(str, cArr2);
                                return i13;
                            case 68:
                                double[] dArr = new double[readUnsignedShort];
                                while (i11 < readUnsignedShort) {
                                    dArr[i11] = Double.longBitsToDouble(readLong(this.cpInfoOffsets[readUnsignedShort(i13 + 1)]));
                                    i13 += 3;
                                    i11++;
                                }
                                annotationVisitor.visit(str, dArr);
                                return i13;
                            default:
                                return readElementValues(annotationVisitor.visitArray(str), i13 - 2, false, cArr);
                        }
                    } else {
                        long[] jArr = new long[readUnsignedShort];
                        while (i11 < readUnsignedShort) {
                            jArr[i11] = readLong(this.cpInfoOffsets[readUnsignedShort(i13 + 1)]);
                            i13 += 3;
                            i11++;
                        }
                        annotationVisitor.visit(str, jArr);
                        return i13;
                    }
                }
            }
            return i12 + 2;
        }
        annotationVisitor.visit(str, readConst(readUnsignedShort(i12), cArr));
        return i12 + 2;
    }

    private int readElementValues(AnnotationVisitor annotationVisitor, int i10, boolean z10, char[] cArr) {
        int readUnsignedShort = readUnsignedShort(i10);
        int i11 = i10 + 2;
        if (!z10) {
            while (true) {
                int i12 = readUnsignedShort - 1;
                if (readUnsignedShort <= 0) {
                    break;
                }
                i11 = readElementValue(annotationVisitor, i11, (String) null, cArr);
                readUnsignedShort = i12;
            }
        } else {
            while (true) {
                int i13 = readUnsignedShort - 1;
                if (readUnsignedShort <= 0) {
                    break;
                }
                i11 = readElementValue(annotationVisitor, i11 + 2, readUTF8(i11, cArr), cArr);
                readUnsignedShort = i13;
            }
        }
        if (annotationVisitor != null) {
            annotationVisitor.visitEnd();
        }
        return i11;
    }

    private int readField(ClassVisitor classVisitor, Context context, int i10) {
        int i11;
        int i12;
        Context context2 = context;
        int i13 = i10;
        char[] cArr = context2.charBuffer;
        int readUnsignedShort = readUnsignedShort(i13);
        String readUTF8 = readUTF8(i13 + 2, cArr);
        String readUTF82 = readUTF8(i13 + 4, cArr);
        int i14 = i13 + 6;
        int readUnsignedShort2 = readUnsignedShort(i14);
        int i15 = i14 + 2;
        int i16 = readUnsignedShort;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        Attribute attribute = null;
        String str = null;
        Object obj = null;
        while (true) {
            int i21 = readUnsignedShort2 - 1;
            if (readUnsignedShort2 <= 0) {
                break;
            }
            String readUTF83 = readUTF8(i15, cArr);
            int readInt = readInt(i15 + 2);
            int i22 = i15 + 6;
            if ("ConstantValue".equals(readUTF83)) {
                int readUnsignedShort3 = readUnsignedShort(i22);
                if (readUnsignedShort3 == 0) {
                    obj = null;
                } else {
                    obj = readConst(readUnsignedShort3, cArr);
                }
            } else if ("Signature".equals(readUTF83)) {
                str = readUTF8(i22, cArr);
            } else {
                if ("Deprecated".equals(readUTF83)) {
                    i12 = 131072 | i16;
                } else if ("Synthetic".equals(readUTF83)) {
                    i12 = i16 | 4096;
                } else {
                    if ("RuntimeVisibleAnnotations".equals(readUTF83)) {
                        i20 = i22;
                        i11 = i20;
                    } else if ("RuntimeVisibleTypeAnnotations".equals(readUTF83)) {
                        i18 = i22;
                        i11 = i18;
                    } else if ("RuntimeInvisibleAnnotations".equals(readUTF83)) {
                        i19 = i22;
                        i11 = i19;
                    } else if ("RuntimeInvisibleTypeAnnotations".equals(readUTF83)) {
                        i17 = i22;
                        i11 = i17;
                    } else {
                        i11 = i22;
                        Attribute attribute2 = attribute;
                        attribute = readAttribute(context2.attributePrototypes, readUTF83, i11, readInt, cArr, -1, (Label[]) null);
                        attribute.nextAttribute = attribute2;
                        i19 = i19;
                        i20 = i20;
                        i17 = i17;
                        i18 = i18;
                    }
                    i15 = i11 + readInt;
                    context2 = context;
                    readUnsignedShort2 = i21;
                }
                i16 = i12;
            }
            i11 = i22;
            i15 = i11 + readInt;
            context2 = context;
            readUnsignedShort2 = i21;
        }
        Attribute attribute3 = attribute;
        int i23 = i17;
        int i24 = i18;
        int i25 = i19;
        int i26 = i20;
        FieldVisitor visitField = classVisitor.visitField(i16, readUTF8, readUTF82, str, obj);
        if (visitField == null) {
            return i15;
        }
        if (i26 != 0) {
            int readUnsignedShort4 = readUnsignedShort(i26);
            int i27 = i26 + 2;
            while (true) {
                int i28 = readUnsignedShort4 - 1;
                if (readUnsignedShort4 <= 0) {
                    break;
                }
                i27 = readElementValues(visitField.visitAnnotation(readUTF8(i27, cArr), true), i27 + 2, true, cArr);
                readUnsignedShort4 = i28;
            }
        }
        if (i25 != 0) {
            int i29 = i25;
            int readUnsignedShort5 = readUnsignedShort(i29);
            int i30 = i29 + 2;
            while (true) {
                int i31 = readUnsignedShort5 - 1;
                if (readUnsignedShort5 <= 0) {
                    break;
                }
                i30 = readElementValues(visitField.visitAnnotation(readUTF8(i30, cArr), false), i30 + 2, true, cArr);
                readUnsignedShort5 = i31;
            }
        }
        int i32 = i24;
        if (i32 != 0) {
            int readUnsignedShort6 = readUnsignedShort(i32);
            int i33 = i32 + 2;
            while (true) {
                int i34 = readUnsignedShort6 - 1;
                if (readUnsignedShort6 <= 0) {
                    break;
                }
                Context context3 = context;
                int readTypeAnnotationTarget = readTypeAnnotationTarget(context3, i33);
                i33 = readElementValues(visitField.visitTypeAnnotation(context3.currentTypeAnnotationTarget, context3.currentTypeAnnotationTargetPath, readUTF8(readTypeAnnotationTarget, cArr), true), readTypeAnnotationTarget + 2, true, cArr);
                readUnsignedShort6 = i34;
            }
        }
        Context context4 = context;
        int i35 = i23;
        if (i35 != 0) {
            int readUnsignedShort7 = readUnsignedShort(i35);
            int i36 = i35 + 2;
            while (true) {
                int i37 = readUnsignedShort7 - 1;
                if (readUnsignedShort7 <= 0) {
                    break;
                }
                int readTypeAnnotationTarget2 = readTypeAnnotationTarget(context4, i36);
                i36 = readElementValues(visitField.visitTypeAnnotation(context4.currentTypeAnnotationTarget, context4.currentTypeAnnotationTargetPath, readUTF8(readTypeAnnotationTarget2, cArr), false), readTypeAnnotationTarget2 + 2, true, cArr);
                readUnsignedShort7 = i37;
            }
        }
        while (true) {
            Attribute attribute4 = attribute3;
            if (attribute4 != null) {
                attribute3 = attribute4.nextAttribute;
                attribute4.nextAttribute = null;
                visitField.visitAttribute(attribute4);
            } else {
                visitField.visitEnd();
                return i15;
            }
        }
    }

    private int readMethod(ClassVisitor classVisitor, Context context, int i10) {
        String str;
        boolean z10;
        int i11;
        int i12;
        int i13;
        Context context2 = context;
        int i14 = i10;
        char[] cArr = context2.charBuffer;
        context2.currentMethodAccessFlags = readUnsignedShort(i14);
        context2.currentMethodName = readUTF8(i14 + 2, cArr);
        int i15 = i14 + 4;
        context2.currentMethodDescriptor = readUTF8(i15, cArr);
        int i16 = i14 + 6;
        int readUnsignedShort = readUnsignedShort(i16);
        int i17 = i16 + 2;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        Attribute attribute = null;
        boolean z11 = false;
        int i24 = 0;
        String[] strArr = null;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        while (true) {
            int i29 = readUnsignedShort - 1;
            if (readUnsignedShort <= 0) {
                break;
            }
            String readUTF8 = readUTF8(i17, cArr);
            int readInt = readInt(i17 + 2);
            int i30 = i17 + 6;
            int i31 = i18;
            if (!"Code".equals(readUTF8)) {
                if ("Exceptions".equals(readUTF8)) {
                    int readUnsignedShort2 = readUnsignedShort(i30);
                    String[] strArr2 = new String[readUnsignedShort2];
                    int i32 = i19;
                    int i33 = i20;
                    int i34 = i30 + 2;
                    for (int i35 = 0; i35 < readUnsignedShort2; i35++) {
                        strArr2[i35] = readClass(i34, cArr);
                        i34 += 2;
                    }
                    strArr = strArr2;
                    i24 = i30;
                    i18 = i31;
                    i19 = i32;
                    i20 = i33;
                    i11 = i24;
                } else {
                    i13 = i19;
                    i12 = i20;
                    if ("Signature".equals(readUTF8)) {
                        i23 = readUnsignedShort(i30);
                    } else if ("Deprecated".equals(readUTF8)) {
                        context2.currentMethodAccessFlags |= Opcodes.ACC_DEPRECATED;
                    } else if ("RuntimeVisibleAnnotations".equals(readUTF8)) {
                        i20 = i30;
                        i18 = i31;
                        i19 = i13;
                        i11 = i20;
                    } else if ("RuntimeVisibleTypeAnnotations".equals(readUTF8)) {
                        i18 = i30;
                        i11 = i18;
                        i19 = i13;
                        i20 = i12;
                    } else if ("AnnotationDefault".equals(readUTF8)) {
                        i21 = i30;
                        i18 = i31;
                        i19 = i13;
                        i20 = i12;
                        i11 = i21;
                    } else if ("Synthetic".equals(readUTF8)) {
                        context2.currentMethodAccessFlags |= 4096;
                        i18 = i31;
                        i19 = i13;
                        i20 = i12;
                        z11 = true;
                        i11 = i30;
                    } else if ("RuntimeInvisibleAnnotations".equals(readUTF8)) {
                        i19 = i30;
                        i18 = i31;
                        i20 = i12;
                        i11 = i19;
                    } else if ("RuntimeInvisibleTypeAnnotations".equals(readUTF8)) {
                        i25 = i30;
                        i18 = i31;
                        i19 = i13;
                        i20 = i12;
                        i11 = i25;
                    } else if ("RuntimeVisibleParameterAnnotations".equals(readUTF8)) {
                        i26 = i30;
                        i18 = i31;
                        i19 = i13;
                        i20 = i12;
                        i11 = i26;
                    } else if ("RuntimeInvisibleParameterAnnotations".equals(readUTF8)) {
                        i27 = i30;
                        i18 = i31;
                        i19 = i13;
                        i20 = i12;
                        i11 = i27;
                    } else if ("MethodParameters".equals(readUTF8)) {
                        i22 = i30;
                        i18 = i31;
                        i19 = i13;
                        i20 = i12;
                        i11 = i22;
                    } else {
                        int i36 = i31;
                        i11 = i30;
                        Attribute readAttribute = readAttribute(context2.attributePrototypes, readUTF8, i30, readInt, cArr, -1, (Label[]) null);
                        readAttribute.nextAttribute = attribute;
                        attribute = readAttribute;
                        i23 = i23;
                        i19 = i13;
                        i20 = i12;
                        i18 = i36;
                        i21 = i21;
                        i22 = i22;
                    }
                }
                i17 = i11 + readInt;
                int i37 = i10;
                readUnsignedShort = i29;
            } else if ((context2.parsingOptions & 1) == 0) {
                i28 = i30;
                i18 = i31;
                i11 = i28;
                i17 = i11 + readInt;
                int i372 = i10;
                readUnsignedShort = i29;
            } else {
                i13 = i19;
                i12 = i20;
            }
            i18 = i31;
            i19 = i13;
            i20 = i12;
            i11 = i30;
            i17 = i11 + readInt;
            int i3722 = i10;
            readUnsignedShort = i29;
        }
        int i38 = i18;
        int i39 = i19;
        int i40 = i20;
        int i41 = i21;
        int i42 = i22;
        int i43 = i23;
        int i44 = context2.currentMethodAccessFlags;
        String str2 = context2.currentMethodName;
        String str3 = context2.currentMethodDescriptor;
        if (i43 == 0) {
            str = null;
        } else {
            str = readUtf(i43, cArr);
        }
        MethodVisitor visitMethod = classVisitor.visitMethod(i44, str2, str3, str, strArr);
        if (visitMethod == null) {
            return i17;
        }
        if (visitMethod instanceof MethodWriter) {
            MethodWriter methodWriter = (MethodWriter) visitMethod;
            if ((context2.currentMethodAccessFlags & Opcodes.ACC_DEPRECATED) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            int i45 = i43;
            MethodWriter methodWriter2 = methodWriter;
            if (methodWriter.canCopyMethodAttributes(this, z11, z10, readUnsignedShort(i15), i45, i24)) {
                int i46 = i10;
                methodWriter2.setMethodAttributesSource(i46, i17 - i46);
                return i17;
            }
        }
        int i47 = i42;
        if (i47 != 0 && (context2.parsingOptions & 2) == 0) {
            int readByte = readByte(i47);
            int i48 = i47 + 1;
            while (true) {
                int i49 = readByte - 1;
                if (readByte <= 0) {
                    break;
                }
                visitMethod.visitParameter(readUTF8(i48, cArr), readUnsignedShort(i48 + 2));
                i48 += 4;
                readByte = i49;
            }
        }
        int i50 = i41;
        if (i50 != 0) {
            AnnotationVisitor visitAnnotationDefault = visitMethod.visitAnnotationDefault();
            readElementValue(visitAnnotationDefault, i50, (String) null, cArr);
            if (visitAnnotationDefault != null) {
                visitAnnotationDefault.visitEnd();
            }
        }
        int i51 = i40;
        if (i51 != 0) {
            int readUnsignedShort3 = readUnsignedShort(i51);
            int i52 = i51 + 2;
            while (true) {
                int i53 = readUnsignedShort3 - 1;
                if (readUnsignedShort3 <= 0) {
                    break;
                }
                i52 = readElementValues(visitMethod.visitAnnotation(readUTF8(i52, cArr), true), i52 + 2, true, cArr);
                readUnsignedShort3 = i53;
            }
        }
        int i54 = i39;
        if (i54 != 0) {
            int readUnsignedShort4 = readUnsignedShort(i54);
            int i55 = i54 + 2;
            while (true) {
                int i56 = readUnsignedShort4 - 1;
                if (readUnsignedShort4 <= 0) {
                    break;
                }
                i55 = readElementValues(visitMethod.visitAnnotation(readUTF8(i55, cArr), false), i55 + 2, true, cArr);
                readUnsignedShort4 = i56;
            }
        }
        int i57 = i38;
        if (i57 != 0) {
            int readUnsignedShort5 = readUnsignedShort(i57);
            int i58 = i57 + 2;
            while (true) {
                int i59 = readUnsignedShort5 - 1;
                if (readUnsignedShort5 <= 0) {
                    break;
                }
                int readTypeAnnotationTarget = readTypeAnnotationTarget(context2, i58);
                i58 = readElementValues(visitMethod.visitTypeAnnotation(context2.currentTypeAnnotationTarget, context2.currentTypeAnnotationTargetPath, readUTF8(readTypeAnnotationTarget, cArr), true), readTypeAnnotationTarget + 2, true, cArr);
                readUnsignedShort5 = i59;
            }
        }
        int i60 = i25;
        if (i60 != 0) {
            int readUnsignedShort6 = readUnsignedShort(i60);
            int i61 = i60 + 2;
            while (true) {
                int i62 = readUnsignedShort6 - 1;
                if (readUnsignedShort6 <= 0) {
                    break;
                }
                int readTypeAnnotationTarget2 = readTypeAnnotationTarget(context2, i61);
                i61 = readElementValues(visitMethod.visitTypeAnnotation(context2.currentTypeAnnotationTarget, context2.currentTypeAnnotationTargetPath, readUTF8(readTypeAnnotationTarget2, cArr), false), readTypeAnnotationTarget2 + 2, true, cArr);
                readUnsignedShort6 = i62;
            }
        }
        int i63 = i26;
        if (i63 != 0) {
            readParameterAnnotations(visitMethod, context2, i63, true);
        }
        int i64 = i27;
        if (i64 != 0) {
            readParameterAnnotations(visitMethod, context2, i64, false);
        }
        while (attribute != null) {
            Attribute attribute2 = attribute.nextAttribute;
            attribute.nextAttribute = null;
            visitMethod.visitAttribute(attribute);
            attribute = attribute2;
        }
        int i65 = i28;
        if (i65 != 0) {
            visitMethod.visitCode();
            readCode(visitMethod, context2, i65);
        }
        visitMethod.visitEnd();
        return i17;
    }

    private void readModuleAttributes(ClassVisitor classVisitor, Context context, int i10, int i11, String str) {
        String[] strArr;
        char[] cArr = context.charBuffer;
        int i12 = i10 + 6;
        ModuleVisitor visitModule = classVisitor.visitModule(readModule(i10, cArr), readUnsignedShort(i10 + 2), readUTF8(i10 + 4, cArr));
        if (visitModule != null) {
            if (str != null) {
                visitModule.visitMainClass(str);
            }
            if (i11 != 0) {
                int readUnsignedShort = readUnsignedShort(i11);
                int i13 = i11 + 2;
                while (true) {
                    int i14 = readUnsignedShort - 1;
                    if (readUnsignedShort <= 0) {
                        break;
                    }
                    visitModule.visitPackage(readPackage(i13, cArr));
                    i13 += 2;
                    readUnsignedShort = i14;
                }
            }
            int readUnsignedShort2 = readUnsignedShort(i12);
            int i15 = i12 + 2;
            while (true) {
                int i16 = readUnsignedShort2 - 1;
                if (readUnsignedShort2 <= 0) {
                    break;
                }
                i15 += 6;
                visitModule.visitRequire(readModule(i15, cArr), readUnsignedShort(i15 + 2), readUTF8(i15 + 4, cArr));
                readUnsignedShort2 = i16;
            }
            int readUnsignedShort3 = readUnsignedShort(i15);
            int i17 = i15 + 2;
            while (true) {
                int i18 = readUnsignedShort3 - 1;
                String[] strArr2 = null;
                if (readUnsignedShort3 <= 0) {
                    break;
                }
                String readPackage = readPackage(i17, cArr);
                int readUnsignedShort4 = readUnsignedShort(i17 + 2);
                int readUnsignedShort5 = readUnsignedShort(i17 + 4);
                i17 += 6;
                if (readUnsignedShort5 != 0) {
                    strArr2 = new String[readUnsignedShort5];
                    for (int i19 = 0; i19 < readUnsignedShort5; i19++) {
                        strArr2[i19] = readModule(i17, cArr);
                        i17 += 2;
                    }
                }
                visitModule.visitExport(readPackage, readUnsignedShort4, strArr2);
                readUnsignedShort3 = i18;
            }
            int readUnsignedShort6 = readUnsignedShort(i17);
            int i20 = i17 + 2;
            while (true) {
                int i21 = readUnsignedShort6 - 1;
                if (readUnsignedShort6 <= 0) {
                    break;
                }
                String readPackage2 = readPackage(i20, cArr);
                int readUnsignedShort7 = readUnsignedShort(i20 + 2);
                int readUnsignedShort8 = readUnsignedShort(i20 + 4);
                i20 += 6;
                if (readUnsignedShort8 != 0) {
                    strArr = new String[readUnsignedShort8];
                    for (int i22 = 0; i22 < readUnsignedShort8; i22++) {
                        strArr[i22] = readModule(i20, cArr);
                        i20 += 2;
                    }
                } else {
                    strArr = null;
                }
                visitModule.visitOpen(readPackage2, readUnsignedShort7, strArr);
                readUnsignedShort6 = i21;
            }
            int readUnsignedShort9 = readUnsignedShort(i20);
            int i23 = i20 + 2;
            while (true) {
                int i24 = readUnsignedShort9 - 1;
                if (readUnsignedShort9 <= 0) {
                    break;
                }
                visitModule.visitUse(readClass(i23, cArr));
                i23 += 2;
                readUnsignedShort9 = i24;
            }
            int readUnsignedShort10 = readUnsignedShort(i23);
            int i25 = i23 + 2;
            while (true) {
                int i26 = readUnsignedShort10 - 1;
                if (readUnsignedShort10 > 0) {
                    String readClass = readClass(i25, cArr);
                    int readUnsignedShort11 = readUnsignedShort(i25 + 2);
                    i25 += 4;
                    String[] strArr3 = new String[readUnsignedShort11];
                    for (int i27 = 0; i27 < readUnsignedShort11; i27++) {
                        strArr3[i27] = readClass(i25, cArr);
                        i25 += 2;
                    }
                    visitModule.visitProvide(readClass, strArr3);
                    readUnsignedShort10 = i26;
                } else {
                    visitModule.visitEnd();
                    return;
                }
            }
        }
    }

    private void readParameterAnnotations(MethodVisitor methodVisitor, Context context, int i10, boolean z10) {
        int i11 = i10 + 1;
        byte b10 = this.classFileBuffer[i10] & 255;
        methodVisitor.visitAnnotableParameterCount(b10, z10);
        char[] cArr = context.charBuffer;
        for (int i12 = 0; i12 < b10; i12++) {
            int readUnsignedShort = readUnsignedShort(i11);
            i11 += 2;
            while (true) {
                int i13 = readUnsignedShort - 1;
                if (readUnsignedShort <= 0) {
                    break;
                }
                i11 = readElementValues(methodVisitor.visitParameterAnnotation(i12, readUTF8(i11, cArr), z10), i11 + 2, true, cArr);
                readUnsignedShort = i13;
            }
        }
    }

    private int readRecordComponent(ClassVisitor classVisitor, Context context, int i10) {
        int i11;
        Context context2 = context;
        int i12 = i10;
        char[] cArr = context2.charBuffer;
        String readUTF8 = readUTF8(i12, cArr);
        String readUTF82 = readUTF8(i12 + 2, cArr);
        int i13 = i12 + 4;
        int readUnsignedShort = readUnsignedShort(i13);
        int i14 = i13 + 2;
        int i15 = 0;
        Attribute attribute = null;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        String str = null;
        while (true) {
            int i19 = readUnsignedShort - 1;
            if (readUnsignedShort <= 0) {
                break;
            }
            String readUTF83 = readUTF8(i14, cArr);
            int readInt = readInt(i14 + 2);
            int i20 = i14 + 6;
            if ("Signature".equals(readUTF83)) {
                str = readUTF8(i20, cArr);
                i11 = i20;
            } else if ("RuntimeVisibleAnnotations".equals(readUTF83)) {
                i18 = i20;
                i11 = i18;
            } else if ("RuntimeVisibleTypeAnnotations".equals(readUTF83)) {
                i16 = i20;
                i11 = i16;
            } else if ("RuntimeInvisibleAnnotations".equals(readUTF83)) {
                i17 = i20;
                i11 = i17;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(readUTF83)) {
                i15 = i20;
                i11 = i15;
            } else {
                i11 = i20;
                Attribute attribute2 = attribute;
                attribute = readAttribute(context2.attributePrototypes, readUTF83, i11, readInt, cArr, -1, (Label[]) null);
                attribute.nextAttribute = attribute2;
                i18 = i18;
                i17 = i17;
                i16 = i16;
                i15 = i15;
            }
            i14 = i11 + readInt;
            context2 = context;
            readUnsignedShort = i19;
        }
        int i21 = i15;
        Attribute attribute3 = attribute;
        int i22 = i16;
        int i23 = i17;
        int i24 = i18;
        RecordComponentVisitor visitRecordComponent = classVisitor.visitRecordComponent(readUTF8, readUTF82, str);
        if (visitRecordComponent == null) {
            return i14;
        }
        if (i24 != 0) {
            int readUnsignedShort2 = readUnsignedShort(i24);
            int i25 = i24 + 2;
            while (true) {
                int i26 = readUnsignedShort2 - 1;
                if (readUnsignedShort2 <= 0) {
                    break;
                }
                i25 = readElementValues(visitRecordComponent.visitAnnotation(readUTF8(i25, cArr), true), i25 + 2, true, cArr);
                readUnsignedShort2 = i26;
            }
        }
        if (i23 != 0) {
            int readUnsignedShort3 = readUnsignedShort(i23);
            int i27 = i23 + 2;
            while (true) {
                int i28 = readUnsignedShort3 - 1;
                if (readUnsignedShort3 <= 0) {
                    break;
                }
                i27 = readElementValues(visitRecordComponent.visitAnnotation(readUTF8(i27, cArr), false), i27 + 2, true, cArr);
                readUnsignedShort3 = i28;
            }
        }
        int i29 = i22;
        if (i29 != 0) {
            int readUnsignedShort4 = readUnsignedShort(i29);
            int i30 = i29 + 2;
            while (true) {
                int i31 = readUnsignedShort4 - 1;
                if (readUnsignedShort4 <= 0) {
                    break;
                }
                Context context3 = context;
                int readTypeAnnotationTarget = readTypeAnnotationTarget(context3, i30);
                i30 = readElementValues(visitRecordComponent.visitTypeAnnotation(context3.currentTypeAnnotationTarget, context3.currentTypeAnnotationTargetPath, readUTF8(readTypeAnnotationTarget, cArr), true), readTypeAnnotationTarget + 2, true, cArr);
                readUnsignedShort4 = i31;
            }
        }
        Context context4 = context;
        if (i21 != 0) {
            int i32 = i21;
            int readUnsignedShort5 = readUnsignedShort(i32);
            int i33 = i32 + 2;
            while (true) {
                int i34 = readUnsignedShort5 - 1;
                if (readUnsignedShort5 <= 0) {
                    break;
                }
                int readTypeAnnotationTarget2 = readTypeAnnotationTarget(context4, i33);
                i33 = readElementValues(visitRecordComponent.visitTypeAnnotation(context4.currentTypeAnnotationTarget, context4.currentTypeAnnotationTargetPath, readUTF8(readTypeAnnotationTarget2, cArr), false), readTypeAnnotationTarget2 + 2, true, cArr);
                readUnsignedShort5 = i34;
            }
        }
        Attribute attribute4 = attribute3;
        while (attribute4 != null) {
            Attribute attribute5 = attribute4.nextAttribute;
            attribute4.nextAttribute = null;
            visitRecordComponent.visitAttribute(attribute4);
            attribute4 = attribute5;
        }
        visitRecordComponent.visitEnd();
        return i14;
    }

    private int readStackMapFrame(int i10, boolean z10, boolean z11, Context context) {
        int i11;
        int i12;
        int i13;
        char[] cArr = context.charBuffer;
        Label[] labelArr = context.currentMethodLabels;
        if (z10) {
            i12 = i10 + 1;
            i11 = this.classFileBuffer[i10] & 255;
        } else {
            context.currentFrameOffset = -1;
            i12 = i10;
            i11 = 255;
        }
        context.currentFrameLocalCountDelta = 0;
        if (i11 < 64) {
            context.currentFrameType = 3;
            context.currentFrameStackCount = 0;
        } else if (i11 < 128) {
            i11 -= 64;
            i12 = readVerificationTypeInfo(i12, context.currentFrameStackTypes, 0, cArr, labelArr);
            context.currentFrameType = 4;
            context.currentFrameStackCount = 1;
        } else if (i11 >= 247) {
            int readUnsignedShort = readUnsignedShort(i12);
            int i14 = i12 + 2;
            if (i11 == 247) {
                i14 = readVerificationTypeInfo(i14, context.currentFrameStackTypes, 0, cArr, labelArr);
                context.currentFrameType = 4;
                context.currentFrameStackCount = 1;
            } else if (i11 >= 248 && i11 < 251) {
                context.currentFrameType = 2;
                int i15 = 251 - i11;
                context.currentFrameLocalCountDelta = i15;
                context.currentFrameLocalCount -= i15;
                context.currentFrameStackCount = 0;
            } else if (i11 == 251) {
                context.currentFrameType = 3;
                context.currentFrameStackCount = 0;
            } else if (i11 < 255) {
                if (z11) {
                    i13 = context.currentFrameLocalCount;
                } else {
                    i13 = 0;
                }
                int i16 = i11 - 251;
                int i17 = i13;
                int i18 = i16;
                while (i18 > 0) {
                    i14 = readVerificationTypeInfo(i14, context.currentFrameLocalTypes, i17, cArr, labelArr);
                    i18--;
                    i17++;
                }
                context.currentFrameType = 1;
                context.currentFrameLocalCountDelta = i16;
                context.currentFrameLocalCount += i16;
                context.currentFrameStackCount = 0;
            } else {
                int readUnsignedShort2 = readUnsignedShort(i14);
                int i19 = i14 + 2;
                context.currentFrameType = 0;
                context.currentFrameLocalCountDelta = readUnsignedShort2;
                context.currentFrameLocalCount = readUnsignedShort2;
                for (int i20 = 0; i20 < readUnsignedShort2; i20++) {
                    i19 = readVerificationTypeInfo(i19, context.currentFrameLocalTypes, i20, cArr, labelArr);
                }
                int readUnsignedShort3 = readUnsignedShort(i19);
                i14 = i19 + 2;
                context.currentFrameStackCount = readUnsignedShort3;
                for (int i21 = 0; i21 < readUnsignedShort3; i21++) {
                    i14 = readVerificationTypeInfo(i14, context.currentFrameStackTypes, i21, cArr, labelArr);
                }
            }
            i11 = readUnsignedShort;
        } else {
            throw new IllegalArgumentException();
        }
        int i22 = context.currentFrameOffset + i11 + 1;
        context.currentFrameOffset = i22;
        createLabel(i22, labelArr);
        return i12;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x003c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] readStream(java.io.InputStream r7, boolean r8) throws java.io.IOException {
        /*
            if (r7 == 0) goto L_0x0044
            int r0 = computeBufferSize(r7)
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x003d }
            r1.<init>()     // Catch:{ all -> 0x003d }
            byte[] r2 = new byte[r0]     // Catch:{ all -> 0x0038 }
            r3 = 0
            r4 = r3
        L_0x000f:
            int r5 = r7.read(r2, r3, r0)     // Catch:{ all -> 0x0038 }
            r6 = -1
            if (r5 == r6) goto L_0x001c
            r1.write(r2, r3, r5)     // Catch:{ all -> 0x0038 }
            int r4 = r4 + 1
            goto L_0x000f
        L_0x001c:
            r1.flush()     // Catch:{ all -> 0x0038 }
            r0 = 1
            if (r4 != r0) goto L_0x002b
            r1.close()     // Catch:{ all -> 0x003d }
            if (r8 == 0) goto L_0x002a
            r7.close()
        L_0x002a:
            return r2
        L_0x002b:
            byte[] r0 = r1.toByteArray()     // Catch:{ all -> 0x0038 }
            r1.close()     // Catch:{ all -> 0x003d }
            if (r8 == 0) goto L_0x0037
            r7.close()
        L_0x0037:
            return r0
        L_0x0038:
            r0 = move-exception
            r1.close()     // Catch:{ all -> 0x003c }
        L_0x003c:
            throw r0     // Catch:{ all -> 0x003d }
        L_0x003d:
            r0 = move-exception
            if (r8 == 0) goto L_0x0043
            r7.close()
        L_0x0043:
            throw r0
        L_0x0044:
            java.io.IOException r7 = new java.io.IOException
            java.lang.String r8 = "Class not found"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.ClassReader.readStream(java.io.InputStream, boolean):byte[]");
    }

    private String readStringish(int i10, char[] cArr) {
        return readUTF8(this.cpInfoOffsets[readUnsignedShort(i10)], cArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006b, code lost:
        r0 = r0 & -256;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006d, code lost:
        r11 = r11 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int readTypeAnnotationTarget(net.bytebuddy.jar.asm.Context r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.readInt(r11)
            int r1 = r0 >>> 24
            r2 = 1
            if (r1 == 0) goto L_0x0070
            if (r1 == r2) goto L_0x0070
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            switch(r1) {
                case 16: goto L_0x006b;
                case 17: goto L_0x006b;
                case 18: goto L_0x006b;
                case 19: goto L_0x0068;
                case 20: goto L_0x0068;
                case 21: goto L_0x0068;
                case 22: goto L_0x0070;
                case 23: goto L_0x006b;
                default: goto L_0x0010;
            }
        L_0x0010:
            switch(r1) {
                case 64: goto L_0x0022;
                case 65: goto L_0x0022;
                case 66: goto L_0x006b;
                case 67: goto L_0x0020;
                case 68: goto L_0x0020;
                case 69: goto L_0x0020;
                case 70: goto L_0x0020;
                case 71: goto L_0x0019;
                case 72: goto L_0x0019;
                case 73: goto L_0x0019;
                case 74: goto L_0x0019;
                case 75: goto L_0x0019;
                default: goto L_0x0013;
            }
        L_0x0013:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            r10.<init>()
            throw r10
        L_0x0019:
            r1 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            r0 = r0 & r1
            int r11 = r11 + 4
            goto L_0x0075
        L_0x0020:
            r0 = r0 & r3
            goto L_0x006d
        L_0x0022:
            r0 = r0 & r3
            int r1 = r11 + 1
            int r1 = r9.readUnsignedShort(r1)
            int r11 = r11 + 3
            net.bytebuddy.jar.asm.Label[] r3 = new net.bytebuddy.jar.asm.Label[r1]
            r10.currentLocalVariableAnnotationRangeStarts = r3
            net.bytebuddy.jar.asm.Label[] r3 = new net.bytebuddy.jar.asm.Label[r1]
            r10.currentLocalVariableAnnotationRangeEnds = r3
            int[] r3 = new int[r1]
            r10.currentLocalVariableAnnotationRangeIndices = r3
            r3 = 0
        L_0x0038:
            if (r3 >= r1) goto L_0x0075
            int r4 = r9.readUnsignedShort(r11)
            int r5 = r11 + 2
            int r5 = r9.readUnsignedShort(r5)
            int r6 = r11 + 4
            int r6 = r9.readUnsignedShort(r6)
            int r11 = r11 + 6
            net.bytebuddy.jar.asm.Label[] r7 = r10.currentLocalVariableAnnotationRangeStarts
            net.bytebuddy.jar.asm.Label[] r8 = r10.currentMethodLabels
            net.bytebuddy.jar.asm.Label r8 = r9.createLabel(r4, r8)
            r7[r3] = r8
            net.bytebuddy.jar.asm.Label[] r7 = r10.currentLocalVariableAnnotationRangeEnds
            int r4 = r4 + r5
            net.bytebuddy.jar.asm.Label[] r5 = r10.currentMethodLabels
            net.bytebuddy.jar.asm.Label r4 = r9.createLabel(r4, r5)
            r7[r3] = r4
            int[] r4 = r10.currentLocalVariableAnnotationRangeIndices
            r4[r3] = r6
            int r3 = r3 + 1
            goto L_0x0038
        L_0x0068:
            r0 = r0 & r3
            int r11 = r11 + r2
            goto L_0x0075
        L_0x006b:
            r0 = r0 & -256(0xffffffffffffff00, float:NaN)
        L_0x006d:
            int r11 = r11 + 3
            goto L_0x0075
        L_0x0070:
            r1 = -65536(0xffffffffffff0000, float:NaN)
            r0 = r0 & r1
            int r11 = r11 + 2
        L_0x0075:
            r10.currentTypeAnnotationTarget = r0
            int r0 = r9.readByte(r11)
            if (r0 != 0) goto L_0x007f
            r1 = 0
            goto L_0x0086
        L_0x007f:
            net.bytebuddy.jar.asm.TypePath r1 = new net.bytebuddy.jar.asm.TypePath
            byte[] r3 = r9.classFileBuffer
            r1.<init>(r3, r11)
        L_0x0086:
            r10.currentTypeAnnotationTargetPath = r1
            int r11 = r11 + r2
            int r0 = r0 * 2
            int r11 = r11 + r0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.ClassReader.readTypeAnnotationTarget(net.bytebuddy.jar.asm.Context, int):int");
    }

    private int[] readTypeAnnotations(MethodVisitor methodVisitor, Context context, int i10, boolean z10) {
        int i11;
        char[] cArr = context.charBuffer;
        int readUnsignedShort = readUnsignedShort(i10);
        int[] iArr = new int[readUnsignedShort];
        int i12 = i10 + 2;
        for (int i13 = 0; i13 < readUnsignedShort; i13++) {
            iArr[i13] = i12;
            int readInt = readInt(i12);
            int i14 = readInt >>> 24;
            if (i14 != 23) {
                switch (i14) {
                    case 16:
                    case 17:
                    case 18:
                        break;
                    default:
                        switch (i14) {
                            case 64:
                            case 65:
                                int readUnsignedShort2 = readUnsignedShort(i12 + 1);
                                i11 = i12 + 3;
                                while (true) {
                                    int i15 = readUnsignedShort2 - 1;
                                    if (readUnsignedShort2 <= 0) {
                                        break;
                                    } else {
                                        int readUnsignedShort3 = readUnsignedShort(i11);
                                        int readUnsignedShort4 = readUnsignedShort(i11 + 2);
                                        i11 += 6;
                                        createLabel(readUnsignedShort3, context.currentMethodLabels);
                                        createLabel(readUnsignedShort3 + readUnsignedShort4, context.currentMethodLabels);
                                        readUnsignedShort2 = i15;
                                    }
                                }
                            case 66:
                            case 67:
                            case 68:
                            case 69:
                            case 70:
                                break;
                            case 71:
                            case 72:
                            case 73:
                            case 74:
                            case 75:
                                i11 = i12 + 4;
                                break;
                            default:
                                throw new IllegalArgumentException();
                        }
                        break;
                }
            }
            i11 = i12 + 3;
            int readByte = readByte(i11);
            TypePath typePath = null;
            if (i14 == 66) {
                if (readByte != 0) {
                    typePath = new TypePath(this.classFileBuffer, i11);
                }
                int i16 = i11 + (readByte * 2) + 1;
                i12 = readElementValues(methodVisitor.visitTryCatchAnnotation(readInt & -256, typePath, readUTF8(i16, cArr), z10), i16 + 2, true, cArr);
            } else {
                i12 = readElementValues((AnnotationVisitor) null, i11 + (readByte * 2) + 3, true, cArr);
            }
        }
        return iArr;
    }

    private int readVerificationTypeInfo(int i10, Object[] objArr, int i11, char[] cArr, Label[] labelArr) {
        int i12 = i10 + 1;
        switch (this.classFileBuffer[i10] & 255) {
            case 0:
                objArr[i11] = Opcodes.TOP;
                return i12;
            case 1:
                objArr[i11] = Opcodes.INTEGER;
                return i12;
            case 2:
                objArr[i11] = Opcodes.FLOAT;
                return i12;
            case 3:
                objArr[i11] = Opcodes.DOUBLE;
                return i12;
            case 4:
                objArr[i11] = Opcodes.LONG;
                return i12;
            case 5:
                objArr[i11] = Opcodes.NULL;
                return i12;
            case 6:
                objArr[i11] = Opcodes.UNINITIALIZED_THIS;
                return i12;
            case 7:
                objArr[i11] = readClass(i12, cArr);
                break;
            case 8:
                objArr[i11] = createLabel(readUnsignedShort(i12), labelArr);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return i12 + 2;
    }

    public void accept(ClassVisitor classVisitor, int i10) {
        accept(classVisitor, new Attribute[0], i10);
    }

    public int getAccess() {
        return readUnsignedShort(this.header);
    }

    public String getClassName() {
        return readClass(this.header + 2, new char[this.maxStringLength]);
    }

    /* access modifiers changed from: package-private */
    public final int getFirstAttributeOffset() {
        int i10 = this.header;
        int readUnsignedShort = i10 + 8 + (readUnsignedShort(i10 + 6) * 2);
        int readUnsignedShort2 = readUnsignedShort(readUnsignedShort);
        int i11 = readUnsignedShort + 2;
        while (true) {
            int i12 = readUnsignedShort2 - 1;
            if (readUnsignedShort2 <= 0) {
                break;
            }
            int readUnsignedShort3 = readUnsignedShort(i11 + 6);
            i11 += 8;
            while (true) {
                int i13 = readUnsignedShort3 - 1;
                if (readUnsignedShort3 <= 0) {
                    break;
                }
                i11 += readInt(i11 + 2) + 6;
                readUnsignedShort3 = i13;
            }
            readUnsignedShort2 = i12;
        }
        int readUnsignedShort4 = readUnsignedShort(i11);
        int i14 = i11 + 2;
        while (true) {
            int i15 = readUnsignedShort4 - 1;
            if (readUnsignedShort4 <= 0) {
                return i14 + 2;
            }
            int readUnsignedShort5 = readUnsignedShort(i14 + 6);
            i14 += 8;
            while (true) {
                int i16 = readUnsignedShort5 - 1;
                if (readUnsignedShort5 <= 0) {
                    break;
                }
                i14 += readInt(i14 + 2) + 6;
                readUnsignedShort5 = i16;
            }
            readUnsignedShort4 = i15;
        }
    }

    public String[] getInterfaces() {
        int i10 = this.header + 6;
        int readUnsignedShort = readUnsignedShort(i10);
        String[] strArr = new String[readUnsignedShort];
        if (readUnsignedShort > 0) {
            char[] cArr = new char[this.maxStringLength];
            for (int i11 = 0; i11 < readUnsignedShort; i11++) {
                i10 += 2;
                strArr[i11] = readClass(i10, cArr);
            }
        }
        return strArr;
    }

    public int getItem(int i10) {
        return this.cpInfoOffsets[i10];
    }

    public int getItemCount() {
        return this.cpInfoOffsets.length;
    }

    public int getMaxStringLength() {
        return this.maxStringLength;
    }

    public String getSuperName() {
        return readClass(this.header + 4, new char[this.maxStringLength]);
    }

    public int readByte(int i10) {
        return this.classFileBuffer[i10] & 255;
    }

    /* access modifiers changed from: protected */
    public void readBytecodeInstructionOffset(int i10) {
    }

    public String readClass(int i10, char[] cArr) {
        return readStringish(i10, cArr);
    }

    public Object readConst(int i10, char[] cArr) {
        boolean z10;
        int i11 = this.cpInfoOffsets[i10];
        byte b10 = this.classFileBuffer[i11 - 1];
        switch (b10) {
            case 3:
                return Integer.valueOf(readInt(i11));
            case 4:
                return Float.valueOf(Float.intBitsToFloat(readInt(i11)));
            case 5:
                return Long.valueOf(readLong(i11));
            case 6:
                return Double.valueOf(Double.longBitsToDouble(readLong(i11)));
            case 7:
                return Type.getObjectType(readUTF8(i11, cArr));
            case 8:
                return readUTF8(i11, cArr);
            default:
                switch (b10) {
                    case 15:
                        int readByte = readByte(i11);
                        int i12 = this.cpInfoOffsets[readUnsignedShort(i11 + 1)];
                        int i13 = this.cpInfoOffsets[readUnsignedShort(i12 + 2)];
                        String readClass = readClass(i12, cArr);
                        String readUTF8 = readUTF8(i13, cArr);
                        String readUTF82 = readUTF8(i13 + 2, cArr);
                        if (this.classFileBuffer[i12 - 1] == 11) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        return new Handle(readByte, readClass, readUTF8, readUTF82, z10);
                    case 16:
                        return Type.getMethodType(readUTF8(i11, cArr));
                    case 17:
                        return readConstantDynamic(i10, cArr);
                    default:
                        throw new IllegalArgumentException();
                }
        }
    }

    public int readInt(int i10) {
        byte[] bArr = this.classFileBuffer;
        return (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << Tnaf.POW_2_WIDTH) | ((bArr[i10 + 2] & 255) << 8);
    }

    /* access modifiers changed from: protected */
    public Label readLabel(int i10, Label[] labelArr) {
        if (labelArr[i10] == null) {
            labelArr[i10] = new Label();
        }
        return labelArr[i10];
    }

    public long readLong(int i10) {
        return (((long) readInt(i10)) << 32) | (((long) readInt(i10 + 4)) & UInt32.MAX_VALUE_LONG);
    }

    public String readModule(int i10, char[] cArr) {
        return readStringish(i10, cArr);
    }

    public String readPackage(int i10, char[] cArr) {
        return readStringish(i10, cArr);
    }

    public short readShort(int i10) {
        byte[] bArr = this.classFileBuffer;
        return (short) ((bArr[i10 + 1] & 255) | ((bArr[i10] & 255) << 8));
    }

    public String readUTF8(int i10, char[] cArr) {
        int readUnsignedShort = readUnsignedShort(i10);
        if (i10 == 0 || readUnsignedShort == 0) {
            return null;
        }
        return readUtf(readUnsignedShort, cArr);
    }

    public int readUnsignedShort(int i10) {
        byte[] bArr = this.classFileBuffer;
        return (bArr[i10 + 1] & 255) | ((bArr[i10] & 255) << 8);
    }

    /* access modifiers changed from: package-private */
    public final String readUtf(int i10, char[] cArr) {
        String[] strArr = this.constantUtf8Values;
        String str = strArr[i10];
        if (str != null) {
            return str;
        }
        int i11 = this.cpInfoOffsets[i10];
        String readUtf = readUtf(i11 + 2, readUnsignedShort(i11), cArr);
        strArr[i10] = readUtf;
        return readUtf;
    }

    public ClassReader(byte[] bArr, int i10, int i11) {
        this(bArr, i10, true);
    }

    public void accept(ClassVisitor classVisitor, Attribute[] attributeArr, int i10) {
        String str;
        String str2;
        int i11;
        int i12;
        String[] strArr;
        int i13;
        ClassVisitor classVisitor2 = classVisitor;
        int i14 = i10;
        Context context = new Context();
        context.attributePrototypes = attributeArr;
        context.parsingOptions = i14;
        char[] cArr = new char[this.maxStringLength];
        context.charBuffer = cArr;
        int i15 = this.header;
        int readUnsignedShort = readUnsignedShort(i15);
        String readClass = readClass(i15 + 2, cArr);
        String readClass2 = readClass(i15 + 4, cArr);
        int readUnsignedShort2 = readUnsignedShort(i15 + 6);
        String[] strArr2 = new String[readUnsignedShort2];
        int i16 = i15 + 8;
        for (int i17 = 0; i17 < readUnsignedShort2; i17++) {
            strArr2[i17] = readClass(i16, cArr);
            i16 += 2;
        }
        int firstAttributeOffset = getFirstAttributeOffset();
        int i18 = readUnsignedShort;
        int readUnsignedShort3 = readUnsignedShort(firstAttributeOffset - 2);
        String str3 = null;
        String str4 = null;
        int i19 = 0;
        String str5 = null;
        int i20 = 0;
        String str6 = null;
        String str7 = null;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        Attribute attribute = null;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        while (readUnsignedShort3 > 0) {
            String readUTF8 = readUTF8(firstAttributeOffset, cArr);
            int readInt = readInt(firstAttributeOffset + 2);
            int i30 = firstAttributeOffset + 6;
            String str8 = str3;
            if ("SourceFile".equals(readUTF8)) {
                i12 = i30;
                str4 = readUTF8(i30, cArr);
            } else if ("InnerClasses".equals(readUTF8)) {
                i28 = i30;
                i12 = i28;
            } else if ("EnclosingMethod".equals(readUTF8)) {
                i21 = i30;
                i12 = i21;
            } else if ("NestHost".equals(readUTF8)) {
                i12 = i30;
                str7 = readClass(i30, cArr);
            } else if ("NestMembers".equals(readUTF8)) {
                i26 = i30;
                i12 = i26;
            } else if ("PermittedSubclasses".equals(readUTF8)) {
                i27 = i30;
                i12 = i27;
            } else {
                if ("Signature".equals(readUTF8)) {
                    str5 = readUTF8(i30, cArr);
                } else if ("RuntimeVisibleAnnotations".equals(readUTF8)) {
                    i22 = i30;
                    i12 = i22;
                } else if ("RuntimeVisibleTypeAnnotations".equals(readUTF8)) {
                    i24 = i30;
                    i12 = i24;
                } else if ("Deprecated".equals(readUTF8)) {
                    i18 |= Opcodes.ACC_DEPRECATED;
                } else if ("Synthetic".equals(readUTF8)) {
                    i18 |= 4096;
                } else if ("SourceDebugExtension".equals(readUTF8)) {
                    if (readInt <= this.classFileBuffer.length - i30) {
                        str3 = readUtf(i30, readInt, new char[readInt]);
                        i12 = i30;
                        i11 = i16;
                        i13 = readInt;
                        strArr = strArr2;
                        firstAttributeOffset = i12 + i13;
                        readUnsignedShort3--;
                        Attribute[] attributeArr2 = attributeArr;
                        strArr2 = strArr;
                        i16 = i11;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else if ("RuntimeInvisibleAnnotations".equals(readUTF8)) {
                    i23 = i30;
                    i12 = i23;
                } else if ("RuntimeInvisibleTypeAnnotations".equals(readUTF8)) {
                    i25 = i30;
                    i12 = i25;
                } else if ("Record".equals(readUTF8)) {
                    i18 |= 65536;
                    i29 = i30;
                    i12 = i29;
                } else if ("Module".equals(readUTF8)) {
                    i19 = i30;
                    i12 = i19;
                } else if ("ModuleMainClass".equals(readUTF8)) {
                    str6 = readClass(i30, cArr);
                } else if ("ModulePackages".equals(readUTF8)) {
                    i20 = i30;
                    i12 = i20;
                } else {
                    if (!"BootstrapMethods".equals(readUTF8)) {
                        i12 = i30;
                        i11 = i16;
                        i13 = readInt;
                        strArr = strArr2;
                        Attribute readAttribute = readAttribute(attributeArr, readUTF8, i12, readInt, cArr, -1, (Label[]) null);
                        readAttribute.nextAttribute = attribute;
                        attribute = readAttribute;
                        i18 = i18;
                        str3 = str8;
                        str4 = str4;
                    } else {
                        i12 = i30;
                        String str9 = str4;
                        i11 = i16;
                        i13 = readInt;
                        strArr = strArr2;
                        Attribute attribute2 = attribute;
                        String str10 = str8;
                        int i31 = i18;
                        str3 = str10;
                    }
                    firstAttributeOffset = i12 + i13;
                    readUnsignedShort3--;
                    Attribute[] attributeArr22 = attributeArr;
                    strArr2 = strArr;
                    i16 = i11;
                }
                i12 = i30;
            }
            i11 = i16;
            i13 = readInt;
            strArr = strArr2;
            str3 = str8;
            firstAttributeOffset = i12 + i13;
            readUnsignedShort3--;
            Attribute[] attributeArr222 = attributeArr;
            strArr2 = strArr;
            i16 = i11;
        }
        String str11 = str3;
        String str12 = str4;
        int i32 = i16;
        String[] strArr3 = strArr2;
        Attribute attribute3 = attribute;
        classVisitor.visit(readInt(this.cpInfoOffsets[1] - 7), i18, readClass, str5, readClass2, strArr3);
        if ((i14 & 2) == 0) {
            String str13 = str12;
            String str14 = str11;
            if (!(str13 == null && str14 == null)) {
                classVisitor2.visitSource(str13, str14);
            }
        }
        if (i19 != 0) {
            readModuleAttributes(classVisitor, context, i19, i20, str6);
        }
        String str15 = str7;
        if (str15 != null) {
            classVisitor2.visitNestHost(str15);
        }
        int i33 = i21;
        if (i33 != 0) {
            String readClass3 = readClass(i33, cArr);
            int readUnsignedShort4 = readUnsignedShort(i33 + 2);
            if (readUnsignedShort4 == 0) {
                str = null;
            } else {
                str = readUTF8(this.cpInfoOffsets[readUnsignedShort4], cArr);
            }
            if (readUnsignedShort4 == 0) {
                str2 = null;
            } else {
                str2 = readUTF8(this.cpInfoOffsets[readUnsignedShort4] + 2, cArr);
            }
            classVisitor2.visitOuterClass(readClass3, str, str2);
        }
        int i34 = i22;
        if (i34 != 0) {
            int readUnsignedShort5 = readUnsignedShort(i34);
            int i35 = i34 + 2;
            while (true) {
                int i36 = readUnsignedShort5 - 1;
                if (readUnsignedShort5 <= 0) {
                    break;
                }
                i35 = readElementValues(classVisitor2.visitAnnotation(readUTF8(i35, cArr), true), i35 + 2, true, cArr);
                readUnsignedShort5 = i36;
            }
        }
        int i37 = i23;
        if (i37 != 0) {
            int readUnsignedShort6 = readUnsignedShort(i37);
            int i38 = i37 + 2;
            while (true) {
                int i39 = readUnsignedShort6 - 1;
                if (readUnsignedShort6 <= 0) {
                    break;
                }
                i38 = readElementValues(classVisitor2.visitAnnotation(readUTF8(i38, cArr), false), i38 + 2, true, cArr);
                readUnsignedShort6 = i39;
            }
        }
        int i40 = i24;
        if (i40 != 0) {
            int readUnsignedShort7 = readUnsignedShort(i40);
            int i41 = i40 + 2;
            while (true) {
                int i42 = readUnsignedShort7 - 1;
                if (readUnsignedShort7 <= 0) {
                    break;
                }
                int readTypeAnnotationTarget = readTypeAnnotationTarget(context, i41);
                i41 = readElementValues(classVisitor2.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, readUTF8(readTypeAnnotationTarget, cArr), true), readTypeAnnotationTarget + 2, true, cArr);
                readUnsignedShort7 = i42;
            }
        }
        int i43 = i25;
        if (i43 != 0) {
            int readUnsignedShort8 = readUnsignedShort(i43);
            int i44 = i43 + 2;
            while (true) {
                int i45 = readUnsignedShort8 - 1;
                if (readUnsignedShort8 <= 0) {
                    break;
                }
                int readTypeAnnotationTarget2 = readTypeAnnotationTarget(context, i44);
                i44 = readElementValues(classVisitor2.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, readUTF8(readTypeAnnotationTarget2, cArr), false), readTypeAnnotationTarget2 + 2, true, cArr);
                readUnsignedShort8 = i45;
            }
        }
        while (attribute3 != null) {
            Attribute attribute4 = attribute3.nextAttribute;
            attribute3.nextAttribute = null;
            classVisitor2.visitAttribute(attribute3);
            attribute3 = attribute4;
        }
        int i46 = i26;
        if (i46 != 0) {
            int readUnsignedShort9 = readUnsignedShort(i46);
            int i47 = i46 + 2;
            while (true) {
                int i48 = readUnsignedShort9 - 1;
                if (readUnsignedShort9 <= 0) {
                    break;
                }
                classVisitor2.visitNestMember(readClass(i47, cArr));
                i47 += 2;
                readUnsignedShort9 = i48;
            }
        }
        int i49 = i27;
        if (i49 != 0) {
            int readUnsignedShort10 = readUnsignedShort(i49);
            int i50 = i49 + 2;
            while (true) {
                int i51 = readUnsignedShort10 - 1;
                if (readUnsignedShort10 <= 0) {
                    break;
                }
                classVisitor2.visitPermittedSubclass(readClass(i50, cArr));
                i50 += 2;
                readUnsignedShort10 = i51;
            }
        }
        int i52 = i28;
        if (i52 != 0) {
            int readUnsignedShort11 = readUnsignedShort(i52);
            int i53 = i52 + 2;
            while (true) {
                int i54 = readUnsignedShort11 - 1;
                if (readUnsignedShort11 <= 0) {
                    break;
                }
                classVisitor2.visitInnerClass(readClass(i53, cArr), readClass(i53 + 2, cArr), readUTF8(i53 + 4, cArr), readUnsignedShort(i53 + 6));
                i53 += 8;
                readUnsignedShort11 = i54;
            }
        }
        int i55 = i29;
        if (i55 != 0) {
            int readUnsignedShort12 = readUnsignedShort(i55);
            int i56 = i55 + 2;
            while (true) {
                int i57 = readUnsignedShort12 - 1;
                if (readUnsignedShort12 <= 0) {
                    break;
                }
                i56 = readRecordComponent(classVisitor2, context, i56);
                readUnsignedShort12 = i57;
            }
        }
        int i58 = i32;
        int readUnsignedShort13 = readUnsignedShort(i58);
        int i59 = i58 + 2;
        while (true) {
            int i60 = readUnsignedShort13 - 1;
            if (readUnsignedShort13 <= 0) {
                break;
            }
            i59 = readField(classVisitor2, context, i59);
            readUnsignedShort13 = i60;
        }
        int readUnsignedShort14 = readUnsignedShort(i59);
        int i61 = i59 + 2;
        while (true) {
            int i62 = readUnsignedShort14 - 1;
            if (readUnsignedShort14 > 0) {
                i61 = readMethod(classVisitor2, context, i61);
                readUnsignedShort14 = i62;
            } else {
                classVisitor.visitEnd();
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0067, code lost:
        r4 = r6;
        r5 = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        r11 = r11 + r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    ClassReader(byte[] r10, int r11, boolean r12) {
        /*
            r9 = this;
            r9.<init>()
            r9.classFileBuffer = r10
            r9.f32802b = r10
            if (r12 == 0) goto L_0x002f
            int r12 = r11 + 6
            short r0 = r9.readShort(r12)
            r1 = 65
            if (r0 > r1) goto L_0x0014
            goto L_0x002f
        L_0x0014:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Unsupported class file major version "
            r11.append(r0)
            short r12 = r9.readShort(r12)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x002f:
            int r12 = r11 + 8
            int r12 = r9.readUnsignedShort(r12)
            int[] r0 = new int[r12]
            r9.cpInfoOffsets = r0
            java.lang.String[] r0 = new java.lang.String[r12]
            r9.constantUtf8Values = r0
            int r11 = r11 + 10
            r0 = 0
            r1 = 1
            r2 = r0
            r3 = r2
            r4 = r1
        L_0x0044:
            if (r4 >= r12) goto L_0x0075
            int[] r5 = r9.cpInfoOffsets
            int r6 = r4 + 1
            int r7 = r11 + 1
            r5[r4] = r7
            byte r4 = r10[r11]
            r5 = 3
            r8 = 5
            switch(r4) {
                case 1: goto L_0x006a;
                case 2: goto L_0x0055;
                case 3: goto L_0x0067;
                case 4: goto L_0x0067;
                case 5: goto L_0x0062;
                case 6: goto L_0x0062;
                case 7: goto L_0x0072;
                case 8: goto L_0x0072;
                case 9: goto L_0x0067;
                case 10: goto L_0x0067;
                case 11: goto L_0x0067;
                case 12: goto L_0x0067;
                case 13: goto L_0x0055;
                case 14: goto L_0x0055;
                case 15: goto L_0x0060;
                case 16: goto L_0x0072;
                case 17: goto L_0x005d;
                case 18: goto L_0x005b;
                case 19: goto L_0x0072;
                case 20: goto L_0x0072;
                default: goto L_0x0055;
            }
        L_0x0055:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            r10.<init>()
            throw r10
        L_0x005b:
            r3 = r1
            goto L_0x0067
        L_0x005d:
            r2 = r1
            r3 = r2
            goto L_0x0067
        L_0x0060:
            r5 = 4
            goto L_0x0072
        L_0x0062:
            r5 = 9
            int r6 = r6 + 1
            goto L_0x0072
        L_0x0067:
            r4 = r6
            r5 = r8
            goto L_0x0073
        L_0x006a:
            int r4 = r9.readUnsignedShort(r7)
            int r5 = r5 + r4
            if (r5 <= r0) goto L_0x0072
            r0 = r5
        L_0x0072:
            r4 = r6
        L_0x0073:
            int r11 = r11 + r5
            goto L_0x0044
        L_0x0075:
            r9.maxStringLength = r0
            r9.header = r11
            r10 = 0
            if (r2 == 0) goto L_0x007f
            net.bytebuddy.jar.asm.ConstantDynamic[] r11 = new net.bytebuddy.jar.asm.ConstantDynamic[r12]
            goto L_0x0080
        L_0x007f:
            r11 = r10
        L_0x0080:
            r9.constantDynamicValues = r11
            if (r3 == 0) goto L_0x0088
            int[] r10 = r9.readBootstrapMethodsAttribute(r0)
        L_0x0088:
            r9.bootstrapMethodOffsets = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.ClassReader.<init>(byte[], int, boolean):void");
    }

    private String readUtf(int i10, int i11, char[] cArr) {
        int i12;
        int i13 = i11 + i10;
        byte[] bArr = this.classFileBuffer;
        int i14 = 0;
        while (i10 < i13) {
            int i15 = i10 + 1;
            byte b10 = bArr[i10];
            if ((b10 & 128) == 0) {
                i12 = i14 + 1;
                cArr[i14] = (char) (b10 & Byte.MAX_VALUE);
            } else if ((b10 & 224) == 192) {
                cArr[i14] = (char) (((b10 & 31) << 6) + (bArr[i15] & 63));
                i14++;
                i10 = i15 + 1;
            } else {
                i12 = i14 + 1;
                int i16 = i15 + 1;
                int i17 = ((b10 & 15) << 12) + ((bArr[i15] & 63) << 6);
                i15 = i16 + 1;
                cArr[i14] = (char) (i17 + (bArr[i16] & 63));
            }
            i10 = i15;
            i14 = i12;
        }
        return new String(cArr, 0, i14);
    }

    public ClassReader(InputStream inputStream) throws IOException {
        this(readStream(inputStream, false));
    }

    public ClassReader(String str) throws IOException {
        this(readStream(ClassLoader.getSystemResourceAsStream(str.replace('.', '/') + ".class"), true));
    }
}
