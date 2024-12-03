package net.bytebuddy.jar.asm;

import com.google.android.gms.common.api.a;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.jar.asm.Attribute;

final class MethodWriter extends MethodVisitor {
    static final int COMPUTE_ALL_FRAMES = 4;
    static final int COMPUTE_INSERTED_FRAMES = 3;
    static final int COMPUTE_MAX_STACK_AND_LOCAL = 1;
    static final int COMPUTE_MAX_STACK_AND_LOCAL_FROM_FRAMES = 2;
    static final int COMPUTE_NOTHING = 0;
    private static final int NA = 0;
    private static final int[] STACK_SIZE_DELTA = {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 0, 0, 1, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, -4, -3, -4, -3, -3, -3, -3, -1, -2, 1, 1, 1, 2, 2, 2, 0, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -2, -1, -2, -1, -2, 0, 1, 0, 1, -1, -1, 0, 0, 1, 1, -1, 0, -1, 0, 0, 0, -3, -1, -1, -3, -3, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2, -2, -2, 0, 1, 0, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, -1, -1, 0, 0};
    private final int accessFlags;
    private final ByteVector code = new ByteVector();
    private final int compute;
    private Label currentBasicBlock;
    private int[] currentFrame;
    private int currentLocals;
    private ByteVector defaultValue;
    private final String descriptor;
    private final int descriptorIndex;
    private final int[] exceptionIndexTable;
    private Attribute firstAttribute;
    private Label firstBasicBlock;
    private Attribute firstCodeAttribute;
    private Handler firstHandler;
    private boolean hasAsmInstructions;
    private boolean hasSubroutines;
    private int invisibleAnnotableParameterCount;
    private Label lastBasicBlock;
    private int lastBytecodeOffset;
    private AnnotationWriter lastCodeRuntimeInvisibleTypeAnnotation;
    private AnnotationWriter lastCodeRuntimeVisibleTypeAnnotation;
    private Handler lastHandler;
    private AnnotationWriter lastRuntimeInvisibleAnnotation;
    private AnnotationWriter[] lastRuntimeInvisibleParameterAnnotations;
    private AnnotationWriter lastRuntimeInvisibleTypeAnnotation;
    private AnnotationWriter lastRuntimeVisibleAnnotation;
    private AnnotationWriter[] lastRuntimeVisibleParameterAnnotations;
    private AnnotationWriter lastRuntimeVisibleTypeAnnotation;
    private ByteVector lineNumberTable;
    private int lineNumberTableLength;
    private ByteVector localVariableTable;
    private int localVariableTableLength;
    private ByteVector localVariableTypeTable;
    private int localVariableTypeTableLength;
    private int maxLocals;
    private int maxRelativeStackSize;
    private int maxStack;
    private final String name;
    private final int nameIndex;
    private final int numberOfExceptions;
    private ByteVector parameters;
    private int parametersCount;
    private int[] previousFrame;
    private int previousFrameOffset;
    private int relativeStackSize;
    private final int signatureIndex;
    private int sourceLength;
    private int sourceOffset;
    private ByteVector stackMapTableEntries;
    private int stackMapTableNumberOfEntries;
    private final SymbolTable symbolTable;
    private int visibleAnnotableParameterCount;

    MethodWriter(SymbolTable symbolTable2, int i10, String str, String str2, String str3, String[] strArr, int i11) {
        super(Opcodes.ASM9);
        int i12;
        int i13;
        this.symbolTable = symbolTable2;
        if (MethodDescription.CONSTRUCTOR_INTERNAL_NAME.equals(str)) {
            i12 = 262144 | i10;
        } else {
            i12 = i10;
        }
        this.accessFlags = i12;
        this.nameIndex = symbolTable2.addConstantUtf8(str);
        this.name = str;
        this.descriptorIndex = symbolTable2.addConstantUtf8(str2);
        this.descriptor = str2;
        if (str3 == null) {
            i13 = 0;
        } else {
            i13 = symbolTable2.addConstantUtf8(str3);
        }
        this.signatureIndex = i13;
        if (strArr == null || strArr.length <= 0) {
            this.numberOfExceptions = 0;
            this.exceptionIndexTable = null;
        } else {
            int length = strArr.length;
            this.numberOfExceptions = length;
            this.exceptionIndexTable = new int[length];
            for (int i14 = 0; i14 < this.numberOfExceptions; i14++) {
                this.exceptionIndexTable[i14] = symbolTable2.addConstantClass(strArr[i14]).index;
            }
        }
        this.compute = i11;
        if (i11 != 0) {
            int argumentsAndReturnSizes = Type.getArgumentsAndReturnSizes(str2) >> 2;
            argumentsAndReturnSizes = (i10 & 8) != 0 ? argumentsAndReturnSizes - 1 : argumentsAndReturnSizes;
            this.maxLocals = argumentsAndReturnSizes;
            this.currentLocals = argumentsAndReturnSizes;
            Label label = new Label();
            this.firstBasicBlock = label;
            visitLabel(label);
        }
    }

    private void addSuccessorToCurrentBasicBlock(int i10, Label label) {
        Label label2 = this.currentBasicBlock;
        label2.outgoingEdges = new Edge(i10, label, label2.outgoingEdges);
    }

    private void computeAllFrames() {
        String str;
        int i10;
        Handler handler = this.firstHandler;
        while (true) {
            str = "java/lang/Throwable";
            if (handler == null) {
                break;
            }
            String str2 = handler.catchTypeDescriptor;
            if (str2 != null) {
                str = str2;
            }
            int abstractTypeFromInternalName = Frame.getAbstractTypeFromInternalName(this.symbolTable, str);
            Label canonicalInstance = handler.handlerPc.getCanonicalInstance();
            canonicalInstance.flags = (short) (canonicalInstance.flags | 2);
            Label canonicalInstance2 = handler.endPc.getCanonicalInstance();
            for (Label canonicalInstance3 = handler.startPc.getCanonicalInstance(); canonicalInstance3 != canonicalInstance2; canonicalInstance3 = canonicalInstance3.nextBasicBlock) {
                canonicalInstance3.outgoingEdges = new Edge(abstractTypeFromInternalName, canonicalInstance, canonicalInstance3.outgoingEdges);
            }
            handler = handler.nextHandler;
        }
        Frame frame = this.firstBasicBlock.frame;
        frame.setInputFrameFromDescriptor(this.symbolTable, this.accessFlags, this.descriptor, this.maxLocals);
        frame.accept(this);
        Label label = this.firstBasicBlock;
        label.nextListElement = Label.EMPTY_LIST;
        int i11 = 0;
        while (label != Label.EMPTY_LIST) {
            Label label2 = label.nextListElement;
            label.nextListElement = null;
            label.flags = (short) (label.flags | 8);
            int inputStackSize = label.frame.getInputStackSize() + label.outputStackMax;
            if (inputStackSize > i11) {
                i11 = inputStackSize;
            }
            for (Edge edge = label.outgoingEdges; edge != null; edge = edge.nextEdge) {
                Label canonicalInstance4 = edge.successor.getCanonicalInstance();
                if (label.frame.merge(this.symbolTable, canonicalInstance4.frame, edge.info) && canonicalInstance4.nextListElement == null) {
                    canonicalInstance4.nextListElement = label2;
                    label2 = canonicalInstance4;
                }
            }
            label = label2;
        }
        for (Label label3 = this.firstBasicBlock; label3 != null; label3 = label3.nextBasicBlock) {
            if ((label3.flags & 10) == 10) {
                label3.frame.accept(this);
            }
            if ((label3.flags & 8) == 0) {
                Label label4 = label3.nextBasicBlock;
                int i12 = label3.bytecodeOffset;
                if (label4 == null) {
                    i10 = this.code.length;
                } else {
                    i10 = label4.bytecodeOffset;
                }
                int i13 = i10 - 1;
                if (i13 >= i12) {
                    for (int i14 = i12; i14 < i13; i14++) {
                        this.code.data[i14] = 0;
                    }
                    this.code.data[i13] = -65;
                    this.currentFrame[visitFrameStart(i12, 0, 1)] = Frame.getAbstractTypeFromInternalName(this.symbolTable, str);
                    visitFrameEnd();
                    this.firstHandler = Handler.removeRange(this.firstHandler, label3, label4);
                    i11 = Math.max(i11, 1);
                }
            }
        }
        this.maxStack = i11;
    }

    private void computeMaxStackAndLocal() {
        int i10;
        for (Handler handler = this.firstHandler; handler != null; handler = handler.nextHandler) {
            Label label = handler.handlerPc;
            Label label2 = handler.endPc;
            for (Label label3 = handler.startPc; label3 != label2; label3 = label3.nextBasicBlock) {
                if ((label3.flags & 16) == 0) {
                    label3.outgoingEdges = new Edge(a.e.API_PRIORITY_OTHER, label, label3.outgoingEdges);
                } else {
                    Edge edge = label3.outgoingEdges.nextEdge;
                    edge.nextEdge = new Edge(a.e.API_PRIORITY_OTHER, label, edge.nextEdge);
                }
            }
        }
        if (this.hasSubroutines) {
            this.firstBasicBlock.markSubroutine(1);
            short s10 = 1;
            for (short s11 = 1; s11 <= s10; s11 = (short) (s11 + 1)) {
                for (Label label4 = this.firstBasicBlock; label4 != null; label4 = label4.nextBasicBlock) {
                    if ((label4.flags & 16) != 0 && label4.subroutineId == s11) {
                        Label label5 = label4.outgoingEdges.nextEdge.successor;
                        if (label5.subroutineId == 0) {
                            s10 = (short) (s10 + 1);
                            label5.markSubroutine(s10);
                        }
                    }
                }
            }
            for (Label label6 = this.firstBasicBlock; label6 != null; label6 = label6.nextBasicBlock) {
                if ((label6.flags & 16) != 0) {
                    label6.outgoingEdges.nextEdge.successor.addSubroutineRetSuccessors(label6);
                }
            }
        }
        Label label7 = this.firstBasicBlock;
        label7.nextListElement = Label.EMPTY_LIST;
        int i11 = this.maxStack;
        while (label7 != Label.EMPTY_LIST) {
            Label label8 = label7.nextListElement;
            short s12 = label7.inputStackSize;
            int i12 = label7.outputStackMax + s12;
            if (i12 > i11) {
                i11 = i12;
            }
            Edge edge2 = label7.outgoingEdges;
            if ((label7.flags & 16) != 0) {
                edge2 = edge2.nextEdge;
            }
            label7 = label8;
            while (edge2 != null) {
                Label label9 = edge2.successor;
                if (label9.nextListElement == null) {
                    int i13 = edge2.info;
                    if (i13 == Integer.MAX_VALUE) {
                        i10 = 1;
                    } else {
                        i10 = i13 + s12;
                    }
                    label9.inputStackSize = (short) i10;
                    label9.nextListElement = label7;
                    label7 = label9;
                }
                edge2 = edge2.nextEdge;
            }
        }
        this.maxStack = i11;
    }

    private void endCurrentBasicBlockWithNoSuccessor() {
        int i10 = this.compute;
        if (i10 == 4) {
            Label label = new Label();
            label.frame = new Frame(label);
            ByteVector byteVector = this.code;
            label.resolve(byteVector.data, byteVector.length);
            this.lastBasicBlock.nextBasicBlock = label;
            this.lastBasicBlock = label;
            this.currentBasicBlock = null;
        } else if (i10 == 1) {
            this.currentBasicBlock.outputStackMax = (short) this.maxRelativeStackSize;
            this.currentBasicBlock = null;
        }
    }

    private void putAbstractTypes(int i10, int i11) {
        while (i10 < i11) {
            Frame.putAbstractType(this.symbolTable, this.currentFrame[i10], this.stackMapTableEntries);
            i10++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void putFrame() {
        /*
            r16 = this;
            r0 = r16
            int[] r1 = r0.currentFrame
            r2 = 1
            r3 = r1[r2]
            r4 = 2
            r1 = r1[r4]
            net.bytebuddy.jar.asm.SymbolTable r4 = r0.symbolTable
            int r4 = r4.getMajorVersion()
            r5 = 0
            r6 = 3
            r7 = 50
            if (r4 >= r7) goto L_0x0031
            net.bytebuddy.jar.asm.ByteVector r2 = r0.stackMapTableEntries
            int[] r4 = r0.currentFrame
            r4 = r4[r5]
            net.bytebuddy.jar.asm.ByteVector r2 = r2.putShort(r4)
            r2.putShort(r3)
            int r3 = r3 + r6
            r0.putAbstractTypes(r6, r3)
            net.bytebuddy.jar.asm.ByteVector r2 = r0.stackMapTableEntries
            r2.putShort(r1)
            int r1 = r1 + r3
            r0.putAbstractTypes(r3, r1)
            return
        L_0x0031:
            int r4 = r0.stackMapTableNumberOfEntries
            if (r4 != 0) goto L_0x003a
            int[] r4 = r0.currentFrame
            r4 = r4[r5]
            goto L_0x0044
        L_0x003a:
            int[] r4 = r0.currentFrame
            r4 = r4[r5]
            int[] r7 = r0.previousFrame
            r7 = r7[r5]
            int r4 = r4 - r7
            int r4 = r4 - r2
        L_0x0044:
            int[] r7 = r0.previousFrame
            r7 = r7[r2]
            int r8 = r3 - r7
            r9 = 252(0xfc, float:3.53E-43)
            r10 = 248(0xf8, float:3.48E-43)
            r11 = 247(0xf7, float:3.46E-43)
            r12 = 64
            r13 = 255(0xff, float:3.57E-43)
            r14 = 251(0xfb, float:3.52E-43)
            if (r1 != 0) goto L_0x0066
            switch(r8) {
                case -3: goto L_0x0064;
                case -2: goto L_0x0064;
                case -1: goto L_0x0064;
                case 0: goto L_0x005e;
                case 1: goto L_0x005c;
                case 2: goto L_0x005c;
                case 3: goto L_0x005c;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x0072
        L_0x005c:
            r2 = r9
            goto L_0x0073
        L_0x005e:
            if (r4 >= r12) goto L_0x0062
            r2 = r5
            goto L_0x0073
        L_0x0062:
            r2 = r14
            goto L_0x0073
        L_0x0064:
            r2 = r10
            goto L_0x0073
        L_0x0066:
            if (r8 != 0) goto L_0x0072
            if (r1 != r2) goto L_0x0072
            r2 = 63
            if (r4 >= r2) goto L_0x0070
            r2 = r12
            goto L_0x0073
        L_0x0070:
            r2 = r11
            goto L_0x0073
        L_0x0072:
            r2 = r13
        L_0x0073:
            if (r2 == r13) goto L_0x008f
            r15 = r6
        L_0x0076:
            if (r5 >= r7) goto L_0x008f
            if (r5 >= r3) goto L_0x008f
            int[] r6 = r0.currentFrame
            r6 = r6[r15]
            int[] r13 = r0.previousFrame
            r13 = r13[r15]
            if (r6 == r13) goto L_0x0087
            r2 = 255(0xff, float:3.57E-43)
            goto L_0x008f
        L_0x0087:
            int r15 = r15 + 1
            int r5 = r5 + 1
            r6 = 3
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x0076
        L_0x008f:
            if (r2 == 0) goto L_0x00fe
            if (r2 == r12) goto L_0x00f0
            if (r2 == r11) goto L_0x00df
            if (r2 == r10) goto L_0x00d4
            if (r2 == r14) goto L_0x00ca
            if (r2 == r9) goto L_0x00b9
            net.bytebuddy.jar.asm.ByteVector r2 = r0.stackMapTableEntries
            r5 = 255(0xff, float:3.57E-43)
            net.bytebuddy.jar.asm.ByteVector r2 = r2.putByte(r5)
            net.bytebuddy.jar.asm.ByteVector r2 = r2.putShort(r4)
            r2.putShort(r3)
            r2 = 3
            int r3 = r3 + r2
            r0.putAbstractTypes(r2, r3)
            net.bytebuddy.jar.asm.ByteVector r2 = r0.stackMapTableEntries
            r2.putShort(r1)
            int r1 = r1 + r3
            r0.putAbstractTypes(r3, r1)
            goto L_0x0103
        L_0x00b9:
            r2 = 3
            net.bytebuddy.jar.asm.ByteVector r1 = r0.stackMapTableEntries
            int r8 = r8 + r14
            net.bytebuddy.jar.asm.ByteVector r1 = r1.putByte(r8)
            r1.putShort(r4)
            int r7 = r7 + r2
            int r3 = r3 + r2
            r0.putAbstractTypes(r7, r3)
            goto L_0x0103
        L_0x00ca:
            net.bytebuddy.jar.asm.ByteVector r1 = r0.stackMapTableEntries
            net.bytebuddy.jar.asm.ByteVector r1 = r1.putByte(r14)
            r1.putShort(r4)
            goto L_0x0103
        L_0x00d4:
            net.bytebuddy.jar.asm.ByteVector r1 = r0.stackMapTableEntries
            int r8 = r8 + r14
            net.bytebuddy.jar.asm.ByteVector r1 = r1.putByte(r8)
            r1.putShort(r4)
            goto L_0x0103
        L_0x00df:
            net.bytebuddy.jar.asm.ByteVector r1 = r0.stackMapTableEntries
            net.bytebuddy.jar.asm.ByteVector r1 = r1.putByte(r11)
            r1.putShort(r4)
            int r1 = r3 + 3
            int r3 = r3 + 4
            r0.putAbstractTypes(r1, r3)
            goto L_0x0103
        L_0x00f0:
            net.bytebuddy.jar.asm.ByteVector r1 = r0.stackMapTableEntries
            int r4 = r4 + r12
            r1.putByte(r4)
            int r1 = r3 + 3
            int r3 = r3 + 4
            r0.putAbstractTypes(r1, r3)
            goto L_0x0103
        L_0x00fe:
            net.bytebuddy.jar.asm.ByteVector r1 = r0.stackMapTableEntries
            r1.putByte(r4)
        L_0x0103:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.MethodWriter.putFrame():void");
    }

    private void putFrameType(Object obj) {
        if (obj instanceof Integer) {
            this.stackMapTableEntries.putByte(((Integer) obj).intValue());
        } else if (obj instanceof String) {
            this.stackMapTableEntries.putByte(7).putShort(this.symbolTable.addConstantClass((String) obj).index);
        } else {
            this.stackMapTableEntries.putByte(8).putShort(((Label) obj).bytecodeOffset);
        }
    }

    private void visitSwitchInsn(Label label, Label[] labelArr) {
        Label label2 = this.currentBasicBlock;
        if (label2 != null) {
            int i10 = this.compute;
            if (i10 == 4) {
                label2.frame.execute(Opcodes.LOOKUPSWITCH, 0, (Symbol) null, (SymbolTable) null);
                addSuccessorToCurrentBasicBlock(0, label);
                Label canonicalInstance = label.getCanonicalInstance();
                canonicalInstance.flags = (short) (canonicalInstance.flags | 2);
                for (Label label3 : labelArr) {
                    addSuccessorToCurrentBasicBlock(0, label3);
                    Label canonicalInstance2 = label3.getCanonicalInstance();
                    canonicalInstance2.flags = (short) (canonicalInstance2.flags | 2);
                }
            } else if (i10 == 1) {
                int i11 = this.relativeStackSize - 1;
                this.relativeStackSize = i11;
                addSuccessorToCurrentBasicBlock(i11, label);
                for (Label addSuccessorToCurrentBasicBlock : labelArr) {
                    addSuccessorToCurrentBasicBlock(this.relativeStackSize, addSuccessorToCurrentBasicBlock);
                }
            }
            endCurrentBasicBlockWithNoSuccessor();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean canCopyMethodAttributes(ClassReader classReader, boolean z10, boolean z11, int i10, int i11, int i12) {
        boolean z12;
        boolean z13;
        if (classReader == this.symbolTable.getSource() && i10 == this.descriptorIndex && i11 == this.signatureIndex) {
            if ((this.accessFlags & Opcodes.ACC_DEPRECATED) != 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z11 == z12) {
                if (this.symbolTable.getMajorVersion() >= 49 || (this.accessFlags & Opcodes.ACC_SYNTHETIC) == 0) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                if (z10 != z13) {
                    return false;
                }
                if (i12 == 0) {
                    if (this.numberOfExceptions != 0) {
                        return false;
                    }
                } else if (classReader.readUnsignedShort(i12) == this.numberOfExceptions) {
                    int i13 = i12 + 2;
                    for (int i14 = 0; i14 < this.numberOfExceptions; i14++) {
                        if (classReader.readUnsignedShort(i13) != this.exceptionIndexTable[i14]) {
                            return false;
                        }
                        i13 += 2;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void collectAttributePrototypes(Attribute.Set set) {
        set.addAttributes(this.firstAttribute);
        set.addAttributes(this.firstCodeAttribute);
    }

    /* access modifiers changed from: package-private */
    public int computeMethodInfoSize() {
        int i10;
        boolean z10;
        String str;
        if (this.sourceOffset != 0) {
            return this.sourceLength + 6;
        }
        int i11 = this.code.length;
        if (i11 <= 0) {
            i10 = 8;
        } else if (i11 <= 65535) {
            this.symbolTable.addConstantUtf8("Code");
            i10 = this.code.length + 16 + Handler.getExceptionTableSize(this.firstHandler) + 8;
            if (this.stackMapTableEntries != null) {
                if (this.symbolTable.getMajorVersion() >= 50) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                SymbolTable symbolTable2 = this.symbolTable;
                if (z10) {
                    str = "StackMapTable";
                } else {
                    str = "StackMap";
                }
                symbolTable2.addConstantUtf8(str);
                i10 += this.stackMapTableEntries.length + 8;
            }
            if (this.lineNumberTable != null) {
                this.symbolTable.addConstantUtf8("LineNumberTable");
                i10 += this.lineNumberTable.length + 8;
            }
            if (this.localVariableTable != null) {
                this.symbolTable.addConstantUtf8("LocalVariableTable");
                i10 += this.localVariableTable.length + 8;
            }
            if (this.localVariableTypeTable != null) {
                this.symbolTable.addConstantUtf8("LocalVariableTypeTable");
                i10 += this.localVariableTypeTable.length + 8;
            }
            AnnotationWriter annotationWriter = this.lastCodeRuntimeVisibleTypeAnnotation;
            if (annotationWriter != null) {
                i10 += annotationWriter.computeAnnotationsSize("RuntimeVisibleTypeAnnotations");
            }
            AnnotationWriter annotationWriter2 = this.lastCodeRuntimeInvisibleTypeAnnotation;
            if (annotationWriter2 != null) {
                i10 += annotationWriter2.computeAnnotationsSize("RuntimeInvisibleTypeAnnotations");
            }
            Attribute attribute = this.firstCodeAttribute;
            if (attribute != null) {
                SymbolTable symbolTable3 = this.symbolTable;
                ByteVector byteVector = this.code;
                i10 += attribute.computeAttributesSize(symbolTable3, byteVector.data, byteVector.length, this.maxStack, this.maxLocals);
            }
        } else {
            throw new MethodTooLargeException(this.symbolTable.getClassName(), this.name, this.descriptor, this.code.length);
        }
        if (this.numberOfExceptions > 0) {
            this.symbolTable.addConstantUtf8("Exceptions");
            i10 += (this.numberOfExceptions * 2) + 8;
        }
        int computeAttributesSize = i10 + Attribute.computeAttributesSize(this.symbolTable, this.accessFlags, this.signatureIndex) + AnnotationWriter.computeAnnotationsSize(this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation);
        AnnotationWriter[] annotationWriterArr = this.lastRuntimeVisibleParameterAnnotations;
        if (annotationWriterArr != null) {
            int i12 = this.visibleAnnotableParameterCount;
            if (i12 == 0) {
                i12 = annotationWriterArr.length;
            }
            computeAttributesSize += AnnotationWriter.computeParameterAnnotationsSize("RuntimeVisibleParameterAnnotations", annotationWriterArr, i12);
        }
        AnnotationWriter[] annotationWriterArr2 = this.lastRuntimeInvisibleParameterAnnotations;
        if (annotationWriterArr2 != null) {
            int i13 = this.invisibleAnnotableParameterCount;
            if (i13 == 0) {
                i13 = annotationWriterArr2.length;
            }
            computeAttributesSize += AnnotationWriter.computeParameterAnnotationsSize("RuntimeInvisibleParameterAnnotations", annotationWriterArr2, i13);
        }
        if (this.defaultValue != null) {
            this.symbolTable.addConstantUtf8("AnnotationDefault");
            computeAttributesSize += this.defaultValue.length + 6;
        }
        if (this.parameters != null) {
            this.symbolTable.addConstantUtf8("MethodParameters");
            computeAttributesSize += this.parameters.length + 7;
        }
        Attribute attribute2 = this.firstAttribute;
        if (attribute2 != null) {
            return computeAttributesSize + attribute2.computeAttributesSize(this.symbolTable);
        }
        return computeAttributesSize;
    }

    /* access modifiers changed from: package-private */
    public boolean hasAsmInstructions() {
        return this.hasAsmInstructions;
    }

    /* access modifiers changed from: package-private */
    public boolean hasFrames() {
        return this.stackMapTableNumberOfEntries > 0;
    }

    /* access modifiers changed from: package-private */
    public void putMethodInfo(ByteVector byteVector) {
        boolean z10;
        int i10;
        int i11;
        int i12;
        boolean z11;
        String str;
        if (this.symbolTable.getMajorVersion() < 49) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i10 = Opcodes.ACC_SYNTHETIC;
        } else {
            i10 = 0;
        }
        byteVector.putShort((~i10) & this.accessFlags).putShort(this.nameIndex).putShort(this.descriptorIndex);
        if (this.sourceOffset != 0) {
            byteVector.putByteArray(this.symbolTable.getSource().classFileBuffer, this.sourceOffset, this.sourceLength);
            return;
        }
        if (this.code.length > 0) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        if (this.numberOfExceptions > 0) {
            i11++;
        }
        int i13 = this.accessFlags;
        if ((i13 & Opcodes.ACC_SYNTHETIC) != 0 && z10) {
            i11++;
        }
        if (this.signatureIndex != 0) {
            i11++;
        }
        if ((131072 & i13) != 0) {
            i11++;
        }
        if (this.lastRuntimeVisibleAnnotation != null) {
            i11++;
        }
        if (this.lastRuntimeInvisibleAnnotation != null) {
            i11++;
        }
        if (this.lastRuntimeVisibleParameterAnnotations != null) {
            i11++;
        }
        if (this.lastRuntimeInvisibleParameterAnnotations != null) {
            i11++;
        }
        if (this.lastRuntimeVisibleTypeAnnotation != null) {
            i11++;
        }
        if (this.lastRuntimeInvisibleTypeAnnotation != null) {
            i11++;
        }
        if (this.defaultValue != null) {
            i11++;
        }
        if (this.parameters != null) {
            i11++;
        }
        Attribute attribute = this.firstAttribute;
        if (attribute != null) {
            i11 += attribute.getAttributeCount();
        }
        byteVector.putShort(i11);
        int i14 = this.code.length;
        if (i14 > 0) {
            int exceptionTableSize = i14 + 10 + Handler.getExceptionTableSize(this.firstHandler);
            ByteVector byteVector2 = this.stackMapTableEntries;
            if (byteVector2 != null) {
                exceptionTableSize += byteVector2.length + 8;
                i12 = 1;
            } else {
                i12 = 0;
            }
            ByteVector byteVector3 = this.lineNumberTable;
            if (byteVector3 != null) {
                exceptionTableSize += byteVector3.length + 8;
                i12++;
            }
            ByteVector byteVector4 = this.localVariableTable;
            if (byteVector4 != null) {
                exceptionTableSize += byteVector4.length + 8;
                i12++;
            }
            ByteVector byteVector5 = this.localVariableTypeTable;
            if (byteVector5 != null) {
                exceptionTableSize += byteVector5.length + 8;
                i12++;
            }
            AnnotationWriter annotationWriter = this.lastCodeRuntimeVisibleTypeAnnotation;
            if (annotationWriter != null) {
                exceptionTableSize += annotationWriter.computeAnnotationsSize("RuntimeVisibleTypeAnnotations");
                i12++;
            }
            AnnotationWriter annotationWriter2 = this.lastCodeRuntimeInvisibleTypeAnnotation;
            if (annotationWriter2 != null) {
                exceptionTableSize += annotationWriter2.computeAnnotationsSize("RuntimeInvisibleTypeAnnotations");
                i12++;
            }
            Attribute attribute2 = this.firstCodeAttribute;
            if (attribute2 != null) {
                SymbolTable symbolTable2 = this.symbolTable;
                ByteVector byteVector6 = this.code;
                exceptionTableSize += attribute2.computeAttributesSize(symbolTable2, byteVector6.data, byteVector6.length, this.maxStack, this.maxLocals);
                i12 += this.firstCodeAttribute.getAttributeCount();
            }
            ByteVector putInt = byteVector.putShort(this.symbolTable.addConstantUtf8("Code")).putInt(exceptionTableSize).putShort(this.maxStack).putShort(this.maxLocals).putInt(this.code.length);
            ByteVector byteVector7 = this.code;
            putInt.putByteArray(byteVector7.data, 0, byteVector7.length);
            Handler.putExceptionTable(this.firstHandler, byteVector);
            byteVector.putShort(i12);
            if (this.stackMapTableEntries != null) {
                if (this.symbolTable.getMajorVersion() >= 50) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                SymbolTable symbolTable3 = this.symbolTable;
                if (z11) {
                    str = "StackMapTable";
                } else {
                    str = "StackMap";
                }
                ByteVector putShort = byteVector.putShort(symbolTable3.addConstantUtf8(str)).putInt(this.stackMapTableEntries.length + 2).putShort(this.stackMapTableNumberOfEntries);
                ByteVector byteVector8 = this.stackMapTableEntries;
                putShort.putByteArray(byteVector8.data, 0, byteVector8.length);
            }
            if (this.lineNumberTable != null) {
                ByteVector putShort2 = byteVector.putShort(this.symbolTable.addConstantUtf8("LineNumberTable")).putInt(this.lineNumberTable.length + 2).putShort(this.lineNumberTableLength);
                ByteVector byteVector9 = this.lineNumberTable;
                putShort2.putByteArray(byteVector9.data, 0, byteVector9.length);
            }
            if (this.localVariableTable != null) {
                ByteVector putShort3 = byteVector.putShort(this.symbolTable.addConstantUtf8("LocalVariableTable")).putInt(this.localVariableTable.length + 2).putShort(this.localVariableTableLength);
                ByteVector byteVector10 = this.localVariableTable;
                putShort3.putByteArray(byteVector10.data, 0, byteVector10.length);
            }
            if (this.localVariableTypeTable != null) {
                ByteVector putShort4 = byteVector.putShort(this.symbolTable.addConstantUtf8("LocalVariableTypeTable")).putInt(this.localVariableTypeTable.length + 2).putShort(this.localVariableTypeTableLength);
                ByteVector byteVector11 = this.localVariableTypeTable;
                putShort4.putByteArray(byteVector11.data, 0, byteVector11.length);
            }
            AnnotationWriter annotationWriter3 = this.lastCodeRuntimeVisibleTypeAnnotation;
            if (annotationWriter3 != null) {
                annotationWriter3.putAnnotations(this.symbolTable.addConstantUtf8("RuntimeVisibleTypeAnnotations"), byteVector);
            }
            AnnotationWriter annotationWriter4 = this.lastCodeRuntimeInvisibleTypeAnnotation;
            if (annotationWriter4 != null) {
                annotationWriter4.putAnnotations(this.symbolTable.addConstantUtf8("RuntimeInvisibleTypeAnnotations"), byteVector);
            }
            Attribute attribute3 = this.firstCodeAttribute;
            if (attribute3 != null) {
                SymbolTable symbolTable4 = this.symbolTable;
                ByteVector byteVector12 = this.code;
                attribute3.putAttributes(symbolTable4, byteVector12.data, byteVector12.length, this.maxStack, this.maxLocals, byteVector);
            }
        }
        if (this.numberOfExceptions > 0) {
            byteVector.putShort(this.symbolTable.addConstantUtf8("Exceptions")).putInt((this.numberOfExceptions * 2) + 2).putShort(this.numberOfExceptions);
            for (int putShort5 : this.exceptionIndexTable) {
                byteVector.putShort(putShort5);
            }
        }
        Attribute.putAttributes(this.symbolTable, this.accessFlags, this.signatureIndex, byteVector);
        AnnotationWriter.putAnnotations(this.symbolTable, this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation, byteVector);
        if (this.lastRuntimeVisibleParameterAnnotations != null) {
            int addConstantUtf8 = this.symbolTable.addConstantUtf8("RuntimeVisibleParameterAnnotations");
            AnnotationWriter[] annotationWriterArr = this.lastRuntimeVisibleParameterAnnotations;
            int i15 = this.visibleAnnotableParameterCount;
            if (i15 == 0) {
                i15 = annotationWriterArr.length;
            }
            AnnotationWriter.putParameterAnnotations(addConstantUtf8, annotationWriterArr, i15, byteVector);
        }
        if (this.lastRuntimeInvisibleParameterAnnotations != null) {
            int addConstantUtf82 = this.symbolTable.addConstantUtf8("RuntimeInvisibleParameterAnnotations");
            AnnotationWriter[] annotationWriterArr2 = this.lastRuntimeInvisibleParameterAnnotations;
            int i16 = this.invisibleAnnotableParameterCount;
            if (i16 == 0) {
                i16 = annotationWriterArr2.length;
            }
            AnnotationWriter.putParameterAnnotations(addConstantUtf82, annotationWriterArr2, i16, byteVector);
        }
        if (this.defaultValue != null) {
            ByteVector putInt2 = byteVector.putShort(this.symbolTable.addConstantUtf8("AnnotationDefault")).putInt(this.defaultValue.length);
            ByteVector byteVector13 = this.defaultValue;
            putInt2.putByteArray(byteVector13.data, 0, byteVector13.length);
        }
        if (this.parameters != null) {
            ByteVector putByte = byteVector.putShort(this.symbolTable.addConstantUtf8("MethodParameters")).putInt(this.parameters.length + 1).putByte(this.parametersCount);
            ByteVector byteVector14 = this.parameters;
            putByte.putByteArray(byteVector14.data, 0, byteVector14.length);
        }
        Attribute attribute4 = this.firstAttribute;
        if (attribute4 != null) {
            attribute4.putAttributes(this.symbolTable, byteVector);
        }
    }

    /* access modifiers changed from: package-private */
    public void setMethodAttributesSource(int i10, int i11) {
        this.sourceOffset = i10 + 6;
        this.sourceLength = i11 - 6;
    }

    /* access modifiers changed from: package-private */
    public void visitAbstractType(int i10, int i11) {
        this.currentFrame[i10] = i11;
    }

    public void visitAnnotableParameterCount(int i10, boolean z10) {
        if (z10) {
            this.visibleAnnotableParameterCount = i10;
        } else {
            this.invisibleAnnotableParameterCount = i10;
        }
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z10) {
        if (z10) {
            AnnotationWriter create = AnnotationWriter.create(this.symbolTable, str, this.lastRuntimeVisibleAnnotation);
            this.lastRuntimeVisibleAnnotation = create;
            return create;
        }
        AnnotationWriter create2 = AnnotationWriter.create(this.symbolTable, str, this.lastRuntimeInvisibleAnnotation);
        this.lastRuntimeInvisibleAnnotation = create2;
        return create2;
    }

    public AnnotationVisitor visitAnnotationDefault() {
        ByteVector byteVector = new ByteVector();
        this.defaultValue = byteVector;
        return new AnnotationWriter(this.symbolTable, false, byteVector, (AnnotationWriter) null);
    }

    public void visitAttribute(Attribute attribute) {
        if (attribute.isCodeAttribute()) {
            attribute.nextAttribute = this.firstCodeAttribute;
            this.firstCodeAttribute = attribute;
            return;
        }
        attribute.nextAttribute = this.firstAttribute;
        this.firstAttribute = attribute;
    }

    public void visitCode() {
    }

    public void visitEnd() {
    }

    public void visitFieldInsn(int i10, String str, String str2, String str3) {
        int i11;
        int i12;
        this.lastBytecodeOffset = this.code.length;
        Symbol addConstantFieldref = this.symbolTable.addConstantFieldref(str, str2, str3);
        this.code.put12(i10, addConstantFieldref.index);
        Label label = this.currentBasicBlock;
        if (label != null) {
            int i13 = this.compute;
            int i14 = 0;
            if (i13 == 4 || i13 == 3) {
                label.frame.execute(i10, 0, addConstantFieldref, this.symbolTable);
                return;
            }
            char charAt = str3.charAt(0);
            int i15 = 1;
            int i16 = -2;
            switch (i10) {
                case Opcodes.GETSTATIC:
                    int i17 = this.relativeStackSize;
                    if (charAt == 'D' || charAt == 'J') {
                        i15 = 2;
                    }
                    i11 = i17 + i15;
                    break;
                case Opcodes.PUTSTATIC:
                    i12 = this.relativeStackSize;
                    if (!(charAt == 'D' || charAt == 'J')) {
                        i16 = -1;
                        break;
                    }
                case Opcodes.GETFIELD:
                    int i18 = this.relativeStackSize;
                    if (charAt == 'D' || charAt == 'J') {
                        i14 = 1;
                    }
                    i11 = i18 + i14;
                    break;
                default:
                    i12 = this.relativeStackSize;
                    if (charAt == 'D' || charAt == 'J') {
                        i16 = -3;
                        break;
                    }
            }
            i11 = i12 + i16;
            if (i11 > this.maxRelativeStackSize) {
                this.maxRelativeStackSize = i11;
            }
            this.relativeStackSize = i11;
        }
    }

    public void visitFrame(int i10, int i11, Object[] objArr, int i12, Object[] objArr2) {
        int i13;
        int i14 = i10;
        int i15 = i11;
        int i16 = i12;
        int i17 = this.compute;
        if (i17 != 4) {
            if (i17 == 3) {
                Label label = this.currentBasicBlock;
                Frame frame = label.frame;
                if (frame == null) {
                    label.frame = new CurrentFrame(label);
                    this.currentBasicBlock.frame.setInputFrameFromDescriptor(this.symbolTable, this.accessFlags, this.descriptor, i11);
                    this.currentBasicBlock.frame.accept(this);
                } else {
                    if (i14 == -1) {
                        frame.setInputFrameFromApiFormat(this.symbolTable, i11, objArr, i12, objArr2);
                    }
                    this.currentBasicBlock.frame.accept(this);
                }
            } else if (i14 == -1) {
                if (this.previousFrame == null) {
                    Frame frame2 = new Frame(new Label());
                    frame2.setInputFrameFromDescriptor(this.symbolTable, this.accessFlags, this.descriptor, Type.getArgumentsAndReturnSizes(this.descriptor) >> 2);
                    frame2.accept(this);
                }
                this.currentLocals = i15;
                int visitFrameStart = visitFrameStart(this.code.length, i11, i16);
                int i18 = 0;
                while (i18 < i15) {
                    this.currentFrame[visitFrameStart] = Frame.getAbstractTypeFromApiFormat(this.symbolTable, objArr[i18]);
                    i18++;
                    visitFrameStart++;
                }
                int i19 = 0;
                while (i19 < i16) {
                    this.currentFrame[visitFrameStart] = Frame.getAbstractTypeFromApiFormat(this.symbolTable, objArr2[i19]);
                    i19++;
                    visitFrameStart++;
                }
                visitFrameEnd();
            } else if (this.symbolTable.getMajorVersion() >= 50) {
                if (this.stackMapTableEntries == null) {
                    this.stackMapTableEntries = new ByteVector();
                    i13 = this.code.length;
                } else {
                    i13 = (this.code.length - this.previousFrameOffset) - 1;
                    if (i13 < 0) {
                        if (i14 != 3) {
                            throw new IllegalStateException();
                        }
                        return;
                    }
                }
                if (i14 == 0) {
                    this.currentLocals = i15;
                    this.stackMapTableEntries.putByte(255).putShort(i13).putShort(i11);
                    for (int i20 = 0; i20 < i15; i20++) {
                        putFrameType(objArr[i20]);
                    }
                    this.stackMapTableEntries.putShort(i16);
                    for (int i21 = 0; i21 < i16; i21++) {
                        putFrameType(objArr2[i21]);
                    }
                } else if (i14 == 1) {
                    this.currentLocals += i15;
                    this.stackMapTableEntries.putByte(i15 + 251).putShort(i13);
                    for (int i22 = 0; i22 < i15; i22++) {
                        putFrameType(objArr[i22]);
                    }
                } else if (i14 == 2) {
                    this.currentLocals -= i15;
                    this.stackMapTableEntries.putByte(251 - i15).putShort(i13);
                } else if (i14 != 3) {
                    if (i14 == 4) {
                        if (i13 < 64) {
                            this.stackMapTableEntries.putByte(i13 + 64);
                        } else {
                            this.stackMapTableEntries.putByte(247).putShort(i13);
                        }
                        putFrameType(objArr2[0]);
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else if (i13 < 64) {
                    this.stackMapTableEntries.putByte(i13);
                } else {
                    this.stackMapTableEntries.putByte(251).putShort(i13);
                }
                this.previousFrameOffset = this.code.length;
                this.stackMapTableNumberOfEntries++;
            } else {
                throw new IllegalArgumentException("Class versions V1_5 or less must use F_NEW frames.");
            }
            if (this.compute == 2) {
                this.relativeStackSize = i16;
                for (int i23 = 0; i23 < i16; i23++) {
                    Integer num = objArr2[i23];
                    if (num == Opcodes.LONG || num == Opcodes.DOUBLE) {
                        this.relativeStackSize++;
                    }
                }
                int i24 = this.relativeStackSize;
                if (i24 > this.maxRelativeStackSize) {
                    this.maxRelativeStackSize = i24;
                }
            }
            this.maxStack = Math.max(this.maxStack, i16);
            this.maxLocals = Math.max(this.maxLocals, this.currentLocals);
        }
    }

    /* access modifiers changed from: package-private */
    public void visitFrameEnd() {
        if (this.previousFrame != null) {
            if (this.stackMapTableEntries == null) {
                this.stackMapTableEntries = new ByteVector();
            }
            putFrame();
            this.stackMapTableNumberOfEntries++;
        }
        this.previousFrame = this.currentFrame;
        this.currentFrame = null;
    }

    /* access modifiers changed from: package-private */
    public int visitFrameStart(int i10, int i11, int i12) {
        int i13 = i11 + 3 + i12;
        int[] iArr = this.currentFrame;
        if (iArr == null || iArr.length < i13) {
            this.currentFrame = new int[i13];
        }
        int[] iArr2 = this.currentFrame;
        iArr2[0] = i10;
        iArr2[1] = i11;
        iArr2[2] = i12;
        return 3;
    }

    public void visitIincInsn(int i10, int i11) {
        int i12;
        int i13;
        ByteVector byteVector = this.code;
        this.lastBytecodeOffset = byteVector.length;
        if (i10 > 255 || i11 > 127 || i11 < -128) {
            byteVector.putByte(196).put12(Opcodes.IINC, i10).putShort(i11);
        } else {
            byteVector.putByte(Opcodes.IINC).put11(i10, i11);
        }
        Label label = this.currentBasicBlock;
        if (label != null && ((i13 = this.compute) == 4 || i13 == 3)) {
            label.frame.execute(Opcodes.IINC, i10, (Symbol) null, (SymbolTable) null);
        }
        if (this.compute != 0 && (i12 = i10 + 1) > this.maxLocals) {
            this.maxLocals = i12;
        }
    }

    public void visitInsn(int i10) {
        ByteVector byteVector = this.code;
        this.lastBytecodeOffset = byteVector.length;
        byteVector.putByte(i10);
        Label label = this.currentBasicBlock;
        if (label != null) {
            int i11 = this.compute;
            if (i11 == 4 || i11 == 3) {
                label.frame.execute(i10, 0, (Symbol) null, (SymbolTable) null);
            } else {
                int i12 = this.relativeStackSize + STACK_SIZE_DELTA[i10];
                if (i12 > this.maxRelativeStackSize) {
                    this.maxRelativeStackSize = i12;
                }
                this.relativeStackSize = i12;
            }
            if ((i10 >= 172 && i10 <= 177) || i10 == 191) {
                endCurrentBasicBlockWithNoSuccessor();
            }
        }
    }

    public AnnotationVisitor visitInsnAnnotation(int i10, TypePath typePath, String str, boolean z10) {
        if (z10) {
            AnnotationWriter create = AnnotationWriter.create(this.symbolTable, (i10 & -16776961) | (this.lastBytecodeOffset << 8), typePath, str, this.lastCodeRuntimeVisibleTypeAnnotation);
            this.lastCodeRuntimeVisibleTypeAnnotation = create;
            return create;
        }
        AnnotationWriter create2 = AnnotationWriter.create(this.symbolTable, (i10 & -16776961) | (this.lastBytecodeOffset << 8), typePath, str, this.lastCodeRuntimeInvisibleTypeAnnotation);
        this.lastCodeRuntimeInvisibleTypeAnnotation = create2;
        return create2;
    }

    public void visitIntInsn(int i10, int i11) {
        ByteVector byteVector = this.code;
        this.lastBytecodeOffset = byteVector.length;
        if (i10 == 17) {
            byteVector.put12(i10, i11);
        } else {
            byteVector.put11(i10, i11);
        }
        Label label = this.currentBasicBlock;
        if (label != null) {
            int i12 = this.compute;
            if (i12 == 4 || i12 == 3) {
                label.frame.execute(i10, i11, (Symbol) null, (SymbolTable) null);
            } else if (i10 != 188) {
                int i13 = this.relativeStackSize + 1;
                if (i13 > this.maxRelativeStackSize) {
                    this.maxRelativeStackSize = i13;
                }
                this.relativeStackSize = i13;
            }
        }
    }

    public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        this.lastBytecodeOffset = this.code.length;
        Symbol addConstantInvokeDynamic = this.symbolTable.addConstantInvokeDynamic(str, str2, handle, objArr);
        this.code.put12(Opcodes.INVOKEDYNAMIC, addConstantInvokeDynamic.index);
        this.code.putShort(0);
        Label label = this.currentBasicBlock;
        if (label != null) {
            int i10 = this.compute;
            if (i10 == 4 || i10 == 3) {
                label.frame.execute(Opcodes.INVOKEDYNAMIC, 0, addConstantInvokeDynamic, this.symbolTable);
                return;
            }
            int argumentsAndReturnSizes = addConstantInvokeDynamic.getArgumentsAndReturnSizes();
            int i11 = this.relativeStackSize + ((argumentsAndReturnSizes & 3) - (argumentsAndReturnSizes >> 2)) + 1;
            if (i11 > this.maxRelativeStackSize) {
                this.maxRelativeStackSize = i11;
            }
            this.relativeStackSize = i11;
        }
    }

    public void visitJumpInsn(int i10, Label label) {
        int i11;
        boolean z10;
        int i12;
        ByteVector byteVector = this.code;
        int i13 = byteVector.length;
        this.lastBytecodeOffset = i13;
        if (i10 >= 200) {
            i11 = i10 - 33;
        } else {
            i11 = i10;
        }
        if ((label.flags & 4) == 0 || label.bytecodeOffset - i13 >= -32768) {
            if (i11 != i10) {
                byteVector.putByte(i10);
                ByteVector byteVector2 = this.code;
                label.put(byteVector2, byteVector2.length - 1, true);
            } else {
                byteVector.putByte(i11);
                ByteVector byteVector3 = this.code;
                label.put(byteVector3, byteVector3.length - 1, false);
            }
            z10 = false;
        } else {
            if (i11 == 167) {
                byteVector.putByte(200);
            } else if (i11 == 168) {
                byteVector.putByte(201);
            } else {
                if (i11 >= 198) {
                    i12 = i11 ^ 1;
                } else {
                    i12 = ((i11 + 1) ^ 1) - 1;
                }
                byteVector.putByte(i12);
                this.code.putShort(8);
                this.code.putByte(220);
                this.hasAsmInstructions = true;
                z10 = true;
                ByteVector byteVector4 = this.code;
                label.put(byteVector4, byteVector4.length - 1, true);
            }
            z10 = false;
            ByteVector byteVector42 = this.code;
            label.put(byteVector42, byteVector42.length - 1, true);
        }
        Label label2 = this.currentBasicBlock;
        if (label2 != null) {
            int i14 = this.compute;
            Label label3 = null;
            if (i14 == 4) {
                label2.frame.execute(i11, 0, (Symbol) null, (SymbolTable) null);
                Label canonicalInstance = label.getCanonicalInstance();
                canonicalInstance.flags = (short) (canonicalInstance.flags | 2);
                addSuccessorToCurrentBasicBlock(0, label);
                if (i11 != 167) {
                    label3 = new Label();
                }
            } else if (i14 == 3) {
                label2.frame.execute(i11, 0, (Symbol) null, (SymbolTable) null);
            } else if (i14 == 2) {
                this.relativeStackSize += STACK_SIZE_DELTA[i11];
            } else if (i11 == 168) {
                short s10 = label.flags;
                if ((s10 & 32) == 0) {
                    label.flags = (short) (s10 | 32);
                    this.hasSubroutines = true;
                }
                label2.flags = (short) (label2.flags | 16);
                addSuccessorToCurrentBasicBlock(this.relativeStackSize + 1, label);
                label3 = new Label();
            } else {
                int i15 = this.relativeStackSize + STACK_SIZE_DELTA[i11];
                this.relativeStackSize = i15;
                addSuccessorToCurrentBasicBlock(i15, label);
            }
            if (label3 != null) {
                if (z10) {
                    label3.flags = (short) (label3.flags | 2);
                }
                visitLabel(label3);
            }
            if (i11 == 167) {
                endCurrentBasicBlockWithNoSuccessor();
            }
        }
    }

    public void visitLabel(Label label) {
        boolean z10 = this.hasAsmInstructions;
        ByteVector byteVector = this.code;
        this.hasAsmInstructions = z10 | label.resolve(byteVector.data, byteVector.length);
        short s10 = label.flags;
        if ((s10 & 1) == 0) {
            int i10 = this.compute;
            if (i10 == 4) {
                Label label2 = this.currentBasicBlock;
                if (label2 != null) {
                    if (label.bytecodeOffset == label2.bytecodeOffset) {
                        label2.flags = (short) ((s10 & 2) | label2.flags);
                        label.frame = label2.frame;
                        return;
                    }
                    addSuccessorToCurrentBasicBlock(0, label);
                }
                Label label3 = this.lastBasicBlock;
                if (label3 != null) {
                    if (label.bytecodeOffset == label3.bytecodeOffset) {
                        label3.flags = (short) (label3.flags | (label.flags & 2));
                        label.frame = label3.frame;
                        this.currentBasicBlock = label3;
                        return;
                    }
                    label3.nextBasicBlock = label;
                }
                this.lastBasicBlock = label;
                this.currentBasicBlock = label;
                label.frame = new Frame(label);
            } else if (i10 == 3) {
                Label label4 = this.currentBasicBlock;
                if (label4 == null) {
                    this.currentBasicBlock = label;
                } else {
                    label4.frame.owner = label;
                }
            } else if (i10 == 1) {
                Label label5 = this.currentBasicBlock;
                if (label5 != null) {
                    label5.outputStackMax = (short) this.maxRelativeStackSize;
                    addSuccessorToCurrentBasicBlock(this.relativeStackSize, label);
                }
                this.currentBasicBlock = label;
                this.relativeStackSize = 0;
                this.maxRelativeStackSize = 0;
                Label label6 = this.lastBasicBlock;
                if (label6 != null) {
                    label6.nextBasicBlock = label;
                }
                this.lastBasicBlock = label;
            } else if (i10 == 2 && this.currentBasicBlock == null) {
                this.currentBasicBlock = label;
            }
        }
    }

    public void visitLdcInsn(Object obj) {
        boolean z10;
        char charAt;
        this.lastBytecodeOffset = this.code.length;
        Symbol addConstant = this.symbolTable.addConstant(obj);
        int i10 = addConstant.index;
        int i11 = addConstant.tag;
        int i12 = 1;
        if (i11 == 5 || i11 == 6 || (i11 == 17 && ((charAt = addConstant.value.charAt(0)) == 'J' || charAt == 'D'))) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.code.put12(20, i10);
        } else if (i10 >= 256) {
            this.code.put12(19, i10);
        } else {
            this.code.put11(18, i10);
        }
        Label label = this.currentBasicBlock;
        if (label != null) {
            int i13 = this.compute;
            if (i13 == 4 || i13 == 3) {
                label.frame.execute(18, 0, addConstant, this.symbolTable);
                return;
            }
            int i14 = this.relativeStackSize;
            if (z10) {
                i12 = 2;
            }
            int i15 = i14 + i12;
            if (i15 > this.maxRelativeStackSize) {
                this.maxRelativeStackSize = i15;
            }
            this.relativeStackSize = i15;
        }
    }

    public void visitLineNumber(int i10, Label label) {
        if (this.lineNumberTable == null) {
            this.lineNumberTable = new ByteVector();
        }
        this.lineNumberTableLength++;
        this.lineNumberTable.putShort(label.bytecodeOffset);
        this.lineNumberTable.putShort(i10);
    }

    public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i10) {
        int i11 = 1;
        if (str3 != null) {
            if (this.localVariableTypeTable == null) {
                this.localVariableTypeTable = new ByteVector();
            }
            this.localVariableTypeTableLength++;
            this.localVariableTypeTable.putShort(label.bytecodeOffset).putShort(label2.bytecodeOffset - label.bytecodeOffset).putShort(this.symbolTable.addConstantUtf8(str)).putShort(this.symbolTable.addConstantUtf8(str3)).putShort(i10);
        }
        if (this.localVariableTable == null) {
            this.localVariableTable = new ByteVector();
        }
        this.localVariableTableLength++;
        this.localVariableTable.putShort(label.bytecodeOffset).putShort(label2.bytecodeOffset - label.bytecodeOffset).putShort(this.symbolTable.addConstantUtf8(str)).putShort(this.symbolTable.addConstantUtf8(str2)).putShort(i10);
        if (this.compute != 0) {
            char charAt = str2.charAt(0);
            if (charAt == 'J' || charAt == 'D') {
                i11 = 2;
            }
            int i12 = i10 + i11;
            if (i12 > this.maxLocals) {
                this.maxLocals = i12;
            }
        }
    }

    public AnnotationVisitor visitLocalVariableAnnotation(int i10, TypePath typePath, Label[] labelArr, Label[] labelArr2, int[] iArr, String str, boolean z10) {
        ByteVector byteVector = new ByteVector();
        byteVector.putByte(i10 >>> 24).putShort(labelArr.length);
        for (int i11 = 0; i11 < labelArr.length; i11++) {
            byteVector.putShort(labelArr[i11].bytecodeOffset).putShort(labelArr2[i11].bytecodeOffset - labelArr[i11].bytecodeOffset).putShort(iArr[i11]);
        }
        TypePath.put(typePath, byteVector);
        byteVector.putShort(this.symbolTable.addConstantUtf8(str)).putShort(0);
        if (z10) {
            AnnotationWriter annotationWriter = new AnnotationWriter(this.symbolTable, true, byteVector, this.lastCodeRuntimeVisibleTypeAnnotation);
            this.lastCodeRuntimeVisibleTypeAnnotation = annotationWriter;
            return annotationWriter;
        }
        AnnotationWriter annotationWriter2 = new AnnotationWriter(this.symbolTable, true, byteVector, this.lastCodeRuntimeInvisibleTypeAnnotation);
        this.lastCodeRuntimeInvisibleTypeAnnotation = annotationWriter2;
        return annotationWriter2;
    }

    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        ByteVector byteVector = this.code;
        this.lastBytecodeOffset = byteVector.length;
        byteVector.putByte(Opcodes.LOOKUPSWITCH).putByteArray((byte[]) null, 0, (4 - (this.code.length % 4)) % 4);
        label.put(this.code, this.lastBytecodeOffset, true);
        this.code.putInt(labelArr.length);
        for (int i10 = 0; i10 < labelArr.length; i10++) {
            this.code.putInt(iArr[i10]);
            labelArr[i10].put(this.code, this.lastBytecodeOffset, true);
        }
        visitSwitchInsn(label, labelArr);
    }

    public void visitMaxs(int i10, int i11) {
        int i12 = this.compute;
        if (i12 == 4) {
            computeAllFrames();
        } else if (i12 == 1) {
            computeMaxStackAndLocal();
        } else if (i12 == 2) {
            this.maxStack = this.maxRelativeStackSize;
        } else {
            this.maxStack = i10;
            this.maxLocals = i11;
        }
    }

    public void visitMethodInsn(int i10, String str, String str2, String str3, boolean z10) {
        int i11;
        this.lastBytecodeOffset = this.code.length;
        Symbol addConstantMethodref = this.symbolTable.addConstantMethodref(str, str2, str3, z10);
        if (i10 == 185) {
            this.code.put12(Opcodes.INVOKEINTERFACE, addConstantMethodref.index).put11(addConstantMethodref.getArgumentsAndReturnSizes() >> 2, 0);
        } else {
            this.code.put12(i10, addConstantMethodref.index);
        }
        Label label = this.currentBasicBlock;
        if (label != null) {
            int i12 = this.compute;
            if (i12 == 4 || i12 == 3) {
                label.frame.execute(i10, 0, addConstantMethodref, this.symbolTable);
                return;
            }
            int argumentsAndReturnSizes = addConstantMethodref.getArgumentsAndReturnSizes();
            int i13 = (argumentsAndReturnSizes & 3) - (argumentsAndReturnSizes >> 2);
            if (i10 == 184) {
                i11 = this.relativeStackSize + i13 + 1;
            } else {
                i11 = this.relativeStackSize + i13;
            }
            if (i11 > this.maxRelativeStackSize) {
                this.maxRelativeStackSize = i11;
            }
            this.relativeStackSize = i11;
        }
    }

    public void visitMultiANewArrayInsn(String str, int i10) {
        this.lastBytecodeOffset = this.code.length;
        Symbol addConstantClass = this.symbolTable.addConstantClass(str);
        this.code.put12(Opcodes.MULTIANEWARRAY, addConstantClass.index).putByte(i10);
        Label label = this.currentBasicBlock;
        if (label != null) {
            int i11 = this.compute;
            if (i11 == 4 || i11 == 3) {
                label.frame.execute(Opcodes.MULTIANEWARRAY, i10, addConstantClass, this.symbolTable);
            } else {
                this.relativeStackSize += 1 - i10;
            }
        }
    }

    public void visitParameter(String str, int i10) {
        int i11;
        if (this.parameters == null) {
            this.parameters = new ByteVector();
        }
        this.parametersCount++;
        ByteVector byteVector = this.parameters;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = this.symbolTable.addConstantUtf8(str);
        }
        byteVector.putShort(i11).putShort(i10);
    }

    public AnnotationVisitor visitParameterAnnotation(int i10, String str, boolean z10) {
        if (z10) {
            if (this.lastRuntimeVisibleParameterAnnotations == null) {
                this.lastRuntimeVisibleParameterAnnotations = new AnnotationWriter[Type.getArgumentTypes(this.descriptor).length];
            }
            AnnotationWriter[] annotationWriterArr = this.lastRuntimeVisibleParameterAnnotations;
            AnnotationWriter create = AnnotationWriter.create(this.symbolTable, str, annotationWriterArr[i10]);
            annotationWriterArr[i10] = create;
            return create;
        }
        if (this.lastRuntimeInvisibleParameterAnnotations == null) {
            this.lastRuntimeInvisibleParameterAnnotations = new AnnotationWriter[Type.getArgumentTypes(this.descriptor).length];
        }
        AnnotationWriter[] annotationWriterArr2 = this.lastRuntimeInvisibleParameterAnnotations;
        AnnotationWriter create2 = AnnotationWriter.create(this.symbolTable, str, annotationWriterArr2[i10]);
        annotationWriterArr2[i10] = create2;
        return create2;
    }

    public void visitTableSwitchInsn(int i10, int i11, Label label, Label... labelArr) {
        ByteVector byteVector = this.code;
        this.lastBytecodeOffset = byteVector.length;
        byteVector.putByte(Opcodes.TABLESWITCH).putByteArray((byte[]) null, 0, (4 - (this.code.length % 4)) % 4);
        label.put(this.code, this.lastBytecodeOffset, true);
        this.code.putInt(i10).putInt(i11);
        for (Label put : labelArr) {
            put.put(this.code, this.lastBytecodeOffset, true);
        }
        visitSwitchInsn(label, labelArr);
    }

    public AnnotationVisitor visitTryCatchAnnotation(int i10, TypePath typePath, String str, boolean z10) {
        if (z10) {
            AnnotationWriter create = AnnotationWriter.create(this.symbolTable, i10, typePath, str, this.lastCodeRuntimeVisibleTypeAnnotation);
            this.lastCodeRuntimeVisibleTypeAnnotation = create;
            return create;
        }
        AnnotationWriter create2 = AnnotationWriter.create(this.symbolTable, i10, typePath, str, this.lastCodeRuntimeInvisibleTypeAnnotation);
        this.lastCodeRuntimeInvisibleTypeAnnotation = create2;
        return create2;
    }

    public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
        int i10;
        if (str != null) {
            i10 = this.symbolTable.addConstantClass(str).index;
        } else {
            i10 = 0;
        }
        Handler handler = new Handler(label, label2, label3, i10, str);
        if (this.firstHandler == null) {
            this.firstHandler = handler;
        } else {
            this.lastHandler.nextHandler = handler;
        }
        this.lastHandler = handler;
    }

    public AnnotationVisitor visitTypeAnnotation(int i10, TypePath typePath, String str, boolean z10) {
        if (z10) {
            AnnotationWriter create = AnnotationWriter.create(this.symbolTable, i10, typePath, str, this.lastRuntimeVisibleTypeAnnotation);
            this.lastRuntimeVisibleTypeAnnotation = create;
            return create;
        }
        AnnotationWriter create2 = AnnotationWriter.create(this.symbolTable, i10, typePath, str, this.lastRuntimeInvisibleTypeAnnotation);
        this.lastRuntimeInvisibleTypeAnnotation = create2;
        return create2;
    }

    public void visitTypeInsn(int i10, String str) {
        this.lastBytecodeOffset = this.code.length;
        Symbol addConstantClass = this.symbolTable.addConstantClass(str);
        this.code.put12(i10, addConstantClass.index);
        Label label = this.currentBasicBlock;
        if (label != null) {
            int i11 = this.compute;
            if (i11 == 4 || i11 == 3) {
                label.frame.execute(i10, this.lastBytecodeOffset, addConstantClass, this.symbolTable);
            } else if (i10 == 187) {
                int i12 = this.relativeStackSize + 1;
                if (i12 > this.maxRelativeStackSize) {
                    this.maxRelativeStackSize = i12;
                }
                this.relativeStackSize = i12;
            }
        }
    }

    public void visitVarInsn(int i10, int i11) {
        int i12;
        int i13;
        ByteVector byteVector = this.code;
        this.lastBytecodeOffset = byteVector.length;
        if (i11 < 4 && i10 != 169) {
            if (i10 < 54) {
                i13 = ((i10 - 21) << 2) + 26;
            } else {
                i13 = ((i10 - 54) << 2) + 59;
            }
            byteVector.putByte(i13 + i11);
        } else if (i11 >= 256) {
            byteVector.putByte(196).put12(i10, i11);
        } else {
            byteVector.put11(i10, i11);
        }
        Label label = this.currentBasicBlock;
        if (label != null) {
            int i14 = this.compute;
            if (i14 == 4 || i14 == 3) {
                label.frame.execute(i10, i11, (Symbol) null, (SymbolTable) null);
            } else if (i10 == 169) {
                label.flags = (short) (label.flags | 64);
                label.outputStackSize = (short) this.relativeStackSize;
                endCurrentBasicBlockWithNoSuccessor();
            } else {
                int i15 = this.relativeStackSize + STACK_SIZE_DELTA[i10];
                if (i15 > this.maxRelativeStackSize) {
                    this.maxRelativeStackSize = i15;
                }
                this.relativeStackSize = i15;
            }
        }
        int i16 = this.compute;
        if (i16 != 0) {
            if (i10 == 22 || i10 == 24 || i10 == 55 || i10 == 57) {
                i12 = i11 + 2;
            } else {
                i12 = i11 + 1;
            }
            if (i12 > this.maxLocals) {
                this.maxLocals = i12;
            }
        }
        if (i10 >= 54 && i16 == 4 && this.firstHandler != null) {
            visitLabel(new Label());
        }
    }
}
