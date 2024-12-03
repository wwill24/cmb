package net.bytebuddy.jar.asm.commons;

import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.TypePath;

public class FieldRemapper extends FieldVisitor {
    protected final Remapper remapper;

    public FieldRemapper(FieldVisitor fieldVisitor, Remapper remapper2) {
        this(Opcodes.ASM9, fieldVisitor, remapper2);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public AnnotationVisitor createAnnotationRemapper(AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.api, (String) null, annotationVisitor, this.remapper);
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z10) {
        AnnotationVisitor visitAnnotation = super.visitAnnotation(this.remapper.mapDesc(str), z10);
        if (visitAnnotation == null) {
            return null;
        }
        return createAnnotationRemapper(str, visitAnnotation);
    }

    public AnnotationVisitor visitTypeAnnotation(int i10, TypePath typePath, String str, boolean z10) {
        AnnotationVisitor visitTypeAnnotation = super.visitTypeAnnotation(i10, typePath, this.remapper.mapDesc(str), z10);
        if (visitTypeAnnotation == null) {
            return null;
        }
        return createAnnotationRemapper(str, visitTypeAnnotation);
    }

    protected FieldRemapper(int i10, FieldVisitor fieldVisitor, Remapper remapper2) {
        super(i10, fieldVisitor);
        this.remapper = remapper2;
    }

    /* access modifiers changed from: protected */
    public AnnotationVisitor createAnnotationRemapper(String str, AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.api, str, annotationVisitor, this.remapper).orDeprecatedValue(createAnnotationRemapper(annotationVisitor));
    }
}
