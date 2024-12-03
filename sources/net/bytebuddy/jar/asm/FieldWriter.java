package net.bytebuddy.jar.asm;

import net.bytebuddy.jar.asm.Attribute;

final class FieldWriter extends FieldVisitor {
    private final int accessFlags;
    private int constantValueIndex;
    private final int descriptorIndex;
    private Attribute firstAttribute;
    private AnnotationWriter lastRuntimeInvisibleAnnotation;
    private AnnotationWriter lastRuntimeInvisibleTypeAnnotation;
    private AnnotationWriter lastRuntimeVisibleAnnotation;
    private AnnotationWriter lastRuntimeVisibleTypeAnnotation;
    private final int nameIndex;
    private int signatureIndex;
    private final SymbolTable symbolTable;

    FieldWriter(SymbolTable symbolTable2, int i10, String str, String str2, String str3, Object obj) {
        super(Opcodes.ASM9);
        this.symbolTable = symbolTable2;
        this.accessFlags = i10;
        this.nameIndex = symbolTable2.addConstantUtf8(str);
        this.descriptorIndex = symbolTable2.addConstantUtf8(str2);
        if (str3 != null) {
            this.signatureIndex = symbolTable2.addConstantUtf8(str3);
        }
        if (obj != null) {
            this.constantValueIndex = symbolTable2.addConstant(obj).index;
        }
    }

    /* access modifiers changed from: package-private */
    public final void collectAttributePrototypes(Attribute.Set set) {
        set.addAttributes(this.firstAttribute);
    }

    /* access modifiers changed from: package-private */
    public int computeFieldInfoSize() {
        int i10;
        if (this.constantValueIndex != 0) {
            this.symbolTable.addConstantUtf8("ConstantValue");
            i10 = 16;
        } else {
            i10 = 8;
        }
        int computeAttributesSize = i10 + Attribute.computeAttributesSize(this.symbolTable, this.accessFlags, this.signatureIndex) + AnnotationWriter.computeAnnotationsSize(this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation);
        Attribute attribute = this.firstAttribute;
        if (attribute != null) {
            return computeAttributesSize + attribute.computeAttributesSize(this.symbolTable);
        }
        return computeAttributesSize;
    }

    /* access modifiers changed from: package-private */
    public void putFieldInfo(ByteVector byteVector) {
        boolean z10;
        int i10;
        int i11 = 0;
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
        if (this.constantValueIndex != 0) {
            i11 = 1;
        }
        int i12 = this.accessFlags;
        if ((i12 & Opcodes.ACC_SYNTHETIC) != 0 && z10) {
            i11++;
        }
        if (this.signatureIndex != 0) {
            i11++;
        }
        if ((131072 & i12) != 0) {
            i11++;
        }
        if (this.lastRuntimeVisibleAnnotation != null) {
            i11++;
        }
        if (this.lastRuntimeInvisibleAnnotation != null) {
            i11++;
        }
        if (this.lastRuntimeVisibleTypeAnnotation != null) {
            i11++;
        }
        if (this.lastRuntimeInvisibleTypeAnnotation != null) {
            i11++;
        }
        Attribute attribute = this.firstAttribute;
        if (attribute != null) {
            i11 += attribute.getAttributeCount();
        }
        byteVector.putShort(i11);
        if (this.constantValueIndex != 0) {
            byteVector.putShort(this.symbolTable.addConstantUtf8("ConstantValue")).putInt(2).putShort(this.constantValueIndex);
        }
        Attribute.putAttributes(this.symbolTable, this.accessFlags, this.signatureIndex, byteVector);
        AnnotationWriter.putAnnotations(this.symbolTable, this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation, byteVector);
        Attribute attribute2 = this.firstAttribute;
        if (attribute2 != null) {
            attribute2.putAttributes(this.symbolTable, byteVector);
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

    public void visitAttribute(Attribute attribute) {
        attribute.nextAttribute = this.firstAttribute;
        this.firstAttribute = attribute;
    }

    public void visitEnd() {
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
}
