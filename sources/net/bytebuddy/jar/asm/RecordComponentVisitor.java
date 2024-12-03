package net.bytebuddy.jar.asm;

public abstract class RecordComponentVisitor {
    protected final int api;
    protected RecordComponentVisitor delegate;

    protected RecordComponentVisitor(int i10) {
        this(i10, (RecordComponentVisitor) null);
    }

    public RecordComponentVisitor getDelegate() {
        return this.delegate;
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z10) {
        RecordComponentVisitor recordComponentVisitor = this.delegate;
        if (recordComponentVisitor != null) {
            return recordComponentVisitor.visitAnnotation(str, z10);
        }
        return null;
    }

    public void visitAttribute(Attribute attribute) {
        RecordComponentVisitor recordComponentVisitor = this.delegate;
        if (recordComponentVisitor != null) {
            recordComponentVisitor.visitAttribute(attribute);
        }
    }

    public void visitEnd() {
        RecordComponentVisitor recordComponentVisitor = this.delegate;
        if (recordComponentVisitor != null) {
            recordComponentVisitor.visitEnd();
        }
    }

    public AnnotationVisitor visitTypeAnnotation(int i10, TypePath typePath, String str, boolean z10) {
        RecordComponentVisitor recordComponentVisitor = this.delegate;
        if (recordComponentVisitor != null) {
            return recordComponentVisitor.visitTypeAnnotation(i10, typePath, str, z10);
        }
        return null;
    }

    protected RecordComponentVisitor(int i10, RecordComponentVisitor recordComponentVisitor) {
        if (i10 == 589824 || i10 == 524288 || i10 == 458752 || i10 == 393216 || i10 == 327680 || i10 == 262144 || i10 == 17432576) {
            if (i10 == 17432576) {
                Constants.checkAsmExperimental(this);
            }
            this.api = i10;
            this.delegate = recordComponentVisitor;
            return;
        }
        throw new IllegalArgumentException("Unsupported api " + i10);
    }
}
