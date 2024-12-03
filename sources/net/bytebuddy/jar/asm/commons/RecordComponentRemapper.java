package net.bytebuddy.jar.asm.commons;

import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.TypePath;

public class RecordComponentRemapper extends RecordComponentVisitor {
    protected final Remapper remapper;

    public RecordComponentRemapper(RecordComponentVisitor recordComponentVisitor, Remapper remapper2) {
        this(Opcodes.ASM9, recordComponentVisitor, remapper2);
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

    protected RecordComponentRemapper(int i10, RecordComponentVisitor recordComponentVisitor, Remapper remapper2) {
        super(i10, recordComponentVisitor);
        this.remapper = remapper2;
    }

    /* access modifiers changed from: protected */
    public AnnotationVisitor createAnnotationRemapper(String str, AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.api, str, annotationVisitor, this.remapper).orDeprecatedValue(createAnnotationRemapper(annotationVisitor));
    }
}
