package net.bytebuddy.jar.asm;

public abstract class FieldVisitor {
    protected final int api;
    protected FieldVisitor fv;

    protected FieldVisitor(int i10) {
        this(i10, (FieldVisitor) null);
    }

    public FieldVisitor getDelegate() {
        return this.fv;
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z10) {
        FieldVisitor fieldVisitor = this.fv;
        if (fieldVisitor != null) {
            return fieldVisitor.visitAnnotation(str, z10);
        }
        return null;
    }

    public void visitAttribute(Attribute attribute) {
        FieldVisitor fieldVisitor = this.fv;
        if (fieldVisitor != null) {
            fieldVisitor.visitAttribute(attribute);
        }
    }

    public void visitEnd() {
        FieldVisitor fieldVisitor = this.fv;
        if (fieldVisitor != null) {
            fieldVisitor.visitEnd();
        }
    }

    public AnnotationVisitor visitTypeAnnotation(int i10, TypePath typePath, String str, boolean z10) {
        if (this.api >= 327680) {
            FieldVisitor fieldVisitor = this.fv;
            if (fieldVisitor != null) {
                return fieldVisitor.visitTypeAnnotation(i10, typePath, str, z10);
            }
            return null;
        }
        throw new UnsupportedOperationException("This feature requires ASM5");
    }

    protected FieldVisitor(int i10, FieldVisitor fieldVisitor) {
        if (i10 == 589824 || i10 == 524288 || i10 == 458752 || i10 == 393216 || i10 == 327680 || i10 == 262144 || i10 == 17432576) {
            if (i10 == 17432576) {
                Constants.checkAsmExperimental(this);
            }
            this.api = i10;
            this.fv = fieldVisitor;
            return;
        }
        throw new IllegalArgumentException("Unsupported api " + i10);
    }
}
