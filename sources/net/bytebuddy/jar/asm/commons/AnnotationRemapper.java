package net.bytebuddy.jar.asm.commons;

import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.Opcodes;

public class AnnotationRemapper extends AnnotationVisitor {
    protected final String descriptor;
    protected final Remapper remapper;

    @Deprecated
    public AnnotationRemapper(AnnotationVisitor annotationVisitor, Remapper remapper2) {
        this((String) null, annotationVisitor, remapper2);
    }

    private String mapAnnotationAttributeName(String str) {
        String str2 = this.descriptor;
        if (str2 == null) {
            return str;
        }
        return this.remapper.mapAnnotationAttributeName(str2, str);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public AnnotationVisitor createAnnotationRemapper(AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.api, (String) null, annotationVisitor, this.remapper);
    }

    /* access modifiers changed from: package-private */
    public final AnnotationVisitor orDeprecatedValue(AnnotationVisitor annotationVisitor) {
        if (annotationVisitor.getClass() == getClass()) {
            AnnotationRemapper annotationRemapper = (AnnotationRemapper) annotationVisitor;
            if (annotationRemapper.api == this.api && annotationRemapper.av == this.av && annotationRemapper.remapper == this.remapper) {
                return this;
            }
            return annotationVisitor;
        }
        return annotationVisitor;
    }

    public void visit(String str, Object obj) {
        super.visit(mapAnnotationAttributeName(str), this.remapper.mapValue(obj));
    }

    public AnnotationVisitor visitAnnotation(String str, String str2) {
        AnnotationVisitor visitAnnotation = super.visitAnnotation(mapAnnotationAttributeName(str), this.remapper.mapDesc(str2));
        if (visitAnnotation == null) {
            return null;
        }
        if (visitAnnotation == this.av) {
            return this;
        }
        return createAnnotationRemapper(str2, visitAnnotation);
    }

    public AnnotationVisitor visitArray(String str) {
        AnnotationVisitor visitArray = super.visitArray(mapAnnotationAttributeName(str));
        if (visitArray == null) {
            return null;
        }
        if (visitArray == this.av) {
            return this;
        }
        return createAnnotationRemapper((String) null, visitArray);
    }

    public void visitEnum(String str, String str2, String str3) {
        super.visitEnum(mapAnnotationAttributeName(str), this.remapper.mapDesc(str2), str3);
    }

    public AnnotationRemapper(String str, AnnotationVisitor annotationVisitor, Remapper remapper2) {
        this(Opcodes.ASM9, str, annotationVisitor, remapper2);
    }

    /* access modifiers changed from: protected */
    public AnnotationVisitor createAnnotationRemapper(String str, AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.api, str, annotationVisitor, this.remapper).orDeprecatedValue(createAnnotationRemapper(annotationVisitor));
    }

    @Deprecated
    protected AnnotationRemapper(int i10, AnnotationVisitor annotationVisitor, Remapper remapper2) {
        this(i10, (String) null, annotationVisitor, remapper2);
    }

    protected AnnotationRemapper(int i10, String str, AnnotationVisitor annotationVisitor, Remapper remapper2) {
        super(i10, annotationVisitor);
        this.descriptor = str;
        this.remapper = remapper2;
    }
}
