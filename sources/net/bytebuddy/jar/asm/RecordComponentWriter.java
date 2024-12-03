package net.bytebuddy.jar.asm;

import net.bytebuddy.jar.asm.Attribute;

final class RecordComponentWriter extends RecordComponentVisitor {
    private final int descriptorIndex;
    private Attribute firstAttribute;
    private AnnotationWriter lastRuntimeInvisibleAnnotation;
    private AnnotationWriter lastRuntimeInvisibleTypeAnnotation;
    private AnnotationWriter lastRuntimeVisibleAnnotation;
    private AnnotationWriter lastRuntimeVisibleTypeAnnotation;
    private final int nameIndex;
    private int signatureIndex;
    private final SymbolTable symbolTable;

    RecordComponentWriter(SymbolTable symbolTable2, String str, String str2, String str3) {
        super(Opcodes.ASM9);
        this.symbolTable = symbolTable2;
        this.nameIndex = symbolTable2.addConstantUtf8(str);
        this.descriptorIndex = symbolTable2.addConstantUtf8(str2);
        if (str3 != null) {
            this.signatureIndex = symbolTable2.addConstantUtf8(str3);
        }
    }

    /* access modifiers changed from: package-private */
    public final void collectAttributePrototypes(Attribute.Set set) {
        set.addAttributes(this.firstAttribute);
    }

    /* access modifiers changed from: package-private */
    public int computeRecordComponentInfoSize() {
        int computeAttributesSize = Attribute.computeAttributesSize(this.symbolTable, 0, this.signatureIndex) + 6 + AnnotationWriter.computeAnnotationsSize(this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation);
        Attribute attribute = this.firstAttribute;
        if (attribute != null) {
            return computeAttributesSize + attribute.computeAttributesSize(this.symbolTable);
        }
        return computeAttributesSize;
    }

    /* access modifiers changed from: package-private */
    public void putRecordComponentInfo(ByteVector byteVector) {
        int i10;
        byteVector.putShort(this.nameIndex).putShort(this.descriptorIndex);
        if (this.signatureIndex != 0) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        if (this.lastRuntimeVisibleAnnotation != null) {
            i10++;
        }
        if (this.lastRuntimeInvisibleAnnotation != null) {
            i10++;
        }
        if (this.lastRuntimeVisibleTypeAnnotation != null) {
            i10++;
        }
        if (this.lastRuntimeInvisibleTypeAnnotation != null) {
            i10++;
        }
        Attribute attribute = this.firstAttribute;
        if (attribute != null) {
            i10 += attribute.getAttributeCount();
        }
        byteVector.putShort(i10);
        Attribute.putAttributes(this.symbolTable, 0, this.signatureIndex, byteVector);
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
