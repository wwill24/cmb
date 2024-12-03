package net.bytebuddy.jar.asm;

final class AnnotationWriter extends AnnotationVisitor {
    private final ByteVector annotation;
    private AnnotationWriter nextAnnotation;
    private int numElementValuePairs;
    private final int numElementValuePairsOffset;
    private final AnnotationWriter previousAnnotation;
    private final SymbolTable symbolTable;
    private final boolean useNamedValues;

    AnnotationWriter(SymbolTable symbolTable2, boolean z10, ByteVector byteVector, AnnotationWriter annotationWriter) {
        super(Opcodes.ASM9);
        int i10;
        this.symbolTable = symbolTable2;
        this.useNamedValues = z10;
        this.annotation = byteVector;
        int i11 = byteVector.length;
        if (i11 == 0) {
            i10 = -1;
        } else {
            i10 = i11 - 2;
        }
        this.numElementValuePairsOffset = i10;
        this.previousAnnotation = annotationWriter;
        if (annotationWriter != null) {
            annotationWriter.nextAnnotation = this;
        }
    }

    static int computeParameterAnnotationsSize(String str, AnnotationWriter[] annotationWriterArr, int i10) {
        int i11;
        int i12 = (i10 * 2) + 7;
        for (int i13 = 0; i13 < i10; i13++) {
            AnnotationWriter annotationWriter = annotationWriterArr[i13];
            if (annotationWriter == null) {
                i11 = 0;
            } else {
                i11 = annotationWriter.computeAnnotationsSize(str) - 8;
            }
            i12 += i11;
        }
        return i12;
    }

    static AnnotationWriter create(SymbolTable symbolTable2, String str, AnnotationWriter annotationWriter) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(symbolTable2.addConstantUtf8(str)).putShort(0);
        return new AnnotationWriter(symbolTable2, true, byteVector, annotationWriter);
    }

    static void putParameterAnnotations(int i10, AnnotationWriter[] annotationWriterArr, int i11, ByteVector byteVector) {
        int i12;
        int i13 = (i11 * 2) + 1;
        for (int i14 = 0; i14 < i11; i14++) {
            AnnotationWriter annotationWriter = annotationWriterArr[i14];
            if (annotationWriter == null) {
                i12 = 0;
            } else {
                i12 = annotationWriter.computeAnnotationsSize((String) null) - 8;
            }
            i13 += i12;
        }
        byteVector.putShort(i10);
        byteVector.putInt(i13);
        byteVector.putByte(i11);
        for (int i15 = 0; i15 < i11; i15++) {
            int i16 = 0;
            AnnotationWriter annotationWriter2 = null;
            for (AnnotationWriter annotationWriter3 = annotationWriterArr[i15]; annotationWriter3 != null; annotationWriter3 = annotationWriter3.previousAnnotation) {
                annotationWriter3.visitEnd();
                i16++;
                annotationWriter2 = annotationWriter3;
            }
            byteVector.putShort(i16);
            while (annotationWriter2 != null) {
                ByteVector byteVector2 = annotationWriter2.annotation;
                byteVector.putByteArray(byteVector2.data, 0, byteVector2.length);
                annotationWriter2 = annotationWriter2.nextAnnotation;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int computeAnnotationsSize(String str) {
        if (str != null) {
            this.symbolTable.addConstantUtf8(str);
        }
        int i10 = 8;
        for (AnnotationWriter annotationWriter = this; annotationWriter != null; annotationWriter = annotationWriter.previousAnnotation) {
            i10 += annotationWriter.annotation.length;
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public void putAnnotations(int i10, ByteVector byteVector) {
        int i11 = 2;
        int i12 = 0;
        AnnotationWriter annotationWriter = null;
        for (AnnotationWriter annotationWriter2 = this; annotationWriter2 != null; annotationWriter2 = annotationWriter2.previousAnnotation) {
            annotationWriter2.visitEnd();
            i11 += annotationWriter2.annotation.length;
            i12++;
            annotationWriter = annotationWriter2;
        }
        byteVector.putShort(i10);
        byteVector.putInt(i11);
        byteVector.putShort(i12);
        while (annotationWriter != null) {
            ByteVector byteVector2 = annotationWriter.annotation;
            byteVector.putByteArray(byteVector2.data, 0, byteVector2.length);
            annotationWriter = annotationWriter.nextAnnotation;
        }
    }

    public void visit(String str, Object obj) {
        this.numElementValuePairs++;
        if (this.useNamedValues) {
            this.annotation.putShort(this.symbolTable.addConstantUtf8(str));
        }
        if (obj instanceof String) {
            this.annotation.put12(115, this.symbolTable.addConstantUtf8((String) obj));
        } else if (obj instanceof Byte) {
            this.annotation.put12(66, this.symbolTable.addConstantInteger(((Byte) obj).byteValue()).index);
        } else if (obj instanceof Boolean) {
            this.annotation.put12(90, this.symbolTable.addConstantInteger(((Boolean) obj).booleanValue() ? 1 : 0).index);
        } else if (obj instanceof Character) {
            this.annotation.put12(67, this.symbolTable.addConstantInteger(((Character) obj).charValue()).index);
        } else if (obj instanceof Short) {
            this.annotation.put12(83, this.symbolTable.addConstantInteger(((Short) obj).shortValue()).index);
        } else if (obj instanceof Type) {
            this.annotation.put12(99, this.symbolTable.addConstantUtf8(((Type) obj).getDescriptor()));
        } else {
            int i10 = 0;
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                this.annotation.put12(91, bArr.length);
                int length = bArr.length;
                while (i10 < length) {
                    this.annotation.put12(66, this.symbolTable.addConstantInteger(bArr[i10]).index);
                    i10++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                this.annotation.put12(91, zArr.length);
                int length2 = zArr.length;
                while (i10 < length2) {
                    this.annotation.put12(90, this.symbolTable.addConstantInteger(zArr[i10] ? 1 : 0).index);
                    i10++;
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                this.annotation.put12(91, sArr.length);
                int length3 = sArr.length;
                while (i10 < length3) {
                    this.annotation.put12(83, this.symbolTable.addConstantInteger(sArr[i10]).index);
                    i10++;
                }
            } else if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                this.annotation.put12(91, cArr.length);
                int length4 = cArr.length;
                while (i10 < length4) {
                    this.annotation.put12(67, this.symbolTable.addConstantInteger(cArr[i10]).index);
                    i10++;
                }
            } else if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                this.annotation.put12(91, iArr.length);
                int length5 = iArr.length;
                while (i10 < length5) {
                    this.annotation.put12(73, this.symbolTable.addConstantInteger(iArr[i10]).index);
                    i10++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                this.annotation.put12(91, jArr.length);
                int length6 = jArr.length;
                while (i10 < length6) {
                    this.annotation.put12(74, this.symbolTable.addConstantLong(jArr[i10]).index);
                    i10++;
                }
            } else if (obj instanceof float[]) {
                float[] fArr = (float[]) obj;
                this.annotation.put12(91, fArr.length);
                int length7 = fArr.length;
                while (i10 < length7) {
                    this.annotation.put12(70, this.symbolTable.addConstantFloat(fArr[i10]).index);
                    i10++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                this.annotation.put12(91, dArr.length);
                int length8 = dArr.length;
                while (i10 < length8) {
                    this.annotation.put12(68, this.symbolTable.addConstantDouble(dArr[i10]).index);
                    i10++;
                }
            } else {
                Symbol addConstant = this.symbolTable.addConstant(obj);
                this.annotation.put12(".s.IFJDCS".charAt(addConstant.tag), addConstant.index);
            }
        }
    }

    public AnnotationVisitor visitAnnotation(String str, String str2) {
        this.numElementValuePairs++;
        if (this.useNamedValues) {
            this.annotation.putShort(this.symbolTable.addConstantUtf8(str));
        }
        this.annotation.put12(64, this.symbolTable.addConstantUtf8(str2)).putShort(0);
        return new AnnotationWriter(this.symbolTable, true, this.annotation, (AnnotationWriter) null);
    }

    public AnnotationVisitor visitArray(String str) {
        this.numElementValuePairs++;
        if (this.useNamedValues) {
            this.annotation.putShort(this.symbolTable.addConstantUtf8(str));
        }
        this.annotation.put12(91, 0);
        return new AnnotationWriter(this.symbolTable, false, this.annotation, (AnnotationWriter) null);
    }

    public void visitEnd() {
        int i10 = this.numElementValuePairsOffset;
        if (i10 != -1) {
            byte[] bArr = this.annotation.data;
            int i11 = this.numElementValuePairs;
            bArr[i10] = (byte) (i11 >>> 8);
            bArr[i10 + 1] = (byte) i11;
        }
    }

    public void visitEnum(String str, String str2, String str3) {
        this.numElementValuePairs++;
        if (this.useNamedValues) {
            this.annotation.putShort(this.symbolTable.addConstantUtf8(str));
        }
        this.annotation.put12(101, this.symbolTable.addConstantUtf8(str2)).putShort(this.symbolTable.addConstantUtf8(str3));
    }

    static int computeAnnotationsSize(AnnotationWriter annotationWriter, AnnotationWriter annotationWriter2, AnnotationWriter annotationWriter3, AnnotationWriter annotationWriter4) {
        int i10 = 0;
        if (annotationWriter != null) {
            i10 = 0 + annotationWriter.computeAnnotationsSize("RuntimeVisibleAnnotations");
        }
        if (annotationWriter2 != null) {
            i10 += annotationWriter2.computeAnnotationsSize("RuntimeInvisibleAnnotations");
        }
        if (annotationWriter3 != null) {
            i10 += annotationWriter3.computeAnnotationsSize("RuntimeVisibleTypeAnnotations");
        }
        return annotationWriter4 != null ? i10 + annotationWriter4.computeAnnotationsSize("RuntimeInvisibleTypeAnnotations") : i10;
    }

    static AnnotationWriter create(SymbolTable symbolTable2, int i10, TypePath typePath, String str, AnnotationWriter annotationWriter) {
        ByteVector byteVector = new ByteVector();
        TypeReference.putTarget(i10, byteVector);
        TypePath.put(typePath, byteVector);
        byteVector.putShort(symbolTable2.addConstantUtf8(str)).putShort(0);
        return new AnnotationWriter(symbolTable2, true, byteVector, annotationWriter);
    }

    static void putAnnotations(SymbolTable symbolTable2, AnnotationWriter annotationWriter, AnnotationWriter annotationWriter2, AnnotationWriter annotationWriter3, AnnotationWriter annotationWriter4, ByteVector byteVector) {
        if (annotationWriter != null) {
            annotationWriter.putAnnotations(symbolTable2.addConstantUtf8("RuntimeVisibleAnnotations"), byteVector);
        }
        if (annotationWriter2 != null) {
            annotationWriter2.putAnnotations(symbolTable2.addConstantUtf8("RuntimeInvisibleAnnotations"), byteVector);
        }
        if (annotationWriter3 != null) {
            annotationWriter3.putAnnotations(symbolTable2.addConstantUtf8("RuntimeVisibleTypeAnnotations"), byteVector);
        }
        if (annotationWriter4 != null) {
            annotationWriter4.putAnnotations(symbolTable2.addConstantUtf8("RuntimeInvisibleTypeAnnotations"), byteVector);
        }
    }
}
