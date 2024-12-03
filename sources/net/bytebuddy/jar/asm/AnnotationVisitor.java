package net.bytebuddy.jar.asm;

public abstract class AnnotationVisitor {
    protected final int api;
    protected AnnotationVisitor av;

    protected AnnotationVisitor(int i10) {
        this(i10, (AnnotationVisitor) null);
    }

    public AnnotationVisitor getDelegate() {
        return this.av;
    }

    public void visit(String str, Object obj) {
        AnnotationVisitor annotationVisitor = this.av;
        if (annotationVisitor != null) {
            annotationVisitor.visit(str, obj);
        }
    }

    public AnnotationVisitor visitAnnotation(String str, String str2) {
        AnnotationVisitor annotationVisitor = this.av;
        if (annotationVisitor != null) {
            return annotationVisitor.visitAnnotation(str, str2);
        }
        return null;
    }

    public AnnotationVisitor visitArray(String str) {
        AnnotationVisitor annotationVisitor = this.av;
        if (annotationVisitor != null) {
            return annotationVisitor.visitArray(str);
        }
        return null;
    }

    public void visitEnd() {
        AnnotationVisitor annotationVisitor = this.av;
        if (annotationVisitor != null) {
            annotationVisitor.visitEnd();
        }
    }

    public void visitEnum(String str, String str2, String str3) {
        AnnotationVisitor annotationVisitor = this.av;
        if (annotationVisitor != null) {
            annotationVisitor.visitEnum(str, str2, str3);
        }
    }

    protected AnnotationVisitor(int i10, AnnotationVisitor annotationVisitor) {
        if (i10 == 589824 || i10 == 524288 || i10 == 458752 || i10 == 393216 || i10 == 327680 || i10 == 262144 || i10 == 17432576) {
            if (i10 == 17432576) {
                Constants.checkAsmExperimental(this);
            }
            this.api = i10;
            this.av = annotationVisitor;
            return;
        }
        throw new IllegalArgumentException("Unsupported api " + i10);
    }
}
