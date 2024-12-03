package net.bytebuddy.jar.asm.commons;

import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.TypePath;

public class MethodRemapper extends MethodVisitor {
    protected final Remapper remapper;

    public MethodRemapper(MethodVisitor methodVisitor, Remapper remapper2) {
        this(Opcodes.ASM9, methodVisitor, remapper2);
    }

    private Object[] remapFrameTypes(int i10, Object[] objArr) {
        if (objArr == null) {
            return objArr;
        }
        Object[] objArr2 = null;
        for (int i11 = 0; i11 < i10; i11++) {
            if (objArr[i11] instanceof String) {
                if (objArr2 == null) {
                    objArr2 = new Object[i10];
                    System.arraycopy(objArr, 0, objArr2, 0, i10);
                }
                objArr2[i11] = this.remapper.mapType(objArr[i11]);
            }
        }
        if (objArr2 == null) {
            return objArr;
        }
        return objArr2;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public AnnotationVisitor createAnnotationRemapper(AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.api, (String) null, annotationVisitor, this.remapper);
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z10) {
        AnnotationVisitor visitAnnotation = super.visitAnnotation(this.remapper.mapDesc(str), z10);
        if (visitAnnotation == null) {
            return visitAnnotation;
        }
        return createAnnotationRemapper(str, visitAnnotation);
    }

    public AnnotationVisitor visitAnnotationDefault() {
        AnnotationVisitor visitAnnotationDefault = super.visitAnnotationDefault();
        if (visitAnnotationDefault == null) {
            return visitAnnotationDefault;
        }
        return createAnnotationRemapper((String) null, visitAnnotationDefault);
    }

    public void visitFieldInsn(int i10, String str, String str2, String str3) {
        super.visitFieldInsn(i10, this.remapper.mapType(str), this.remapper.mapFieldName(str, str2, str3), this.remapper.mapDesc(str3));
    }

    public void visitFrame(int i10, int i11, Object[] objArr, int i12, Object[] objArr2) {
        super.visitFrame(i10, i11, remapFrameTypes(i11, objArr), i12, remapFrameTypes(i12, objArr2));
    }

    public AnnotationVisitor visitInsnAnnotation(int i10, TypePath typePath, String str, boolean z10) {
        AnnotationVisitor visitInsnAnnotation = super.visitInsnAnnotation(i10, typePath, this.remapper.mapDesc(str), z10);
        if (visitInsnAnnotation == null) {
            return visitInsnAnnotation;
        }
        return createAnnotationRemapper(str, visitInsnAnnotation);
    }

    public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        Object[] objArr2 = new Object[objArr.length];
        for (int i10 = 0; i10 < objArr.length; i10++) {
            objArr2[i10] = this.remapper.mapValue(objArr[i10]);
        }
        super.visitInvokeDynamicInsn(this.remapper.mapInvokeDynamicMethodName(str, str2), this.remapper.mapMethodDesc(str2), (Handle) this.remapper.mapValue(handle), objArr2);
    }

    public void visitLdcInsn(Object obj) {
        super.visitLdcInsn(this.remapper.mapValue(obj));
    }

    public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i10) {
        super.visitLocalVariable(str, this.remapper.mapDesc(str2), this.remapper.mapSignature(str3, true), label, label2, i10);
    }

    public AnnotationVisitor visitLocalVariableAnnotation(int i10, TypePath typePath, Label[] labelArr, Label[] labelArr2, int[] iArr, String str, boolean z10) {
        String str2 = str;
        AnnotationVisitor visitLocalVariableAnnotation = super.visitLocalVariableAnnotation(i10, typePath, labelArr, labelArr2, iArr, this.remapper.mapDesc(str2), z10);
        if (visitLocalVariableAnnotation == null) {
            return visitLocalVariableAnnotation;
        }
        return createAnnotationRemapper(str2, visitLocalVariableAnnotation);
    }

    public void visitMethodInsn(int i10, String str, String str2, String str3, boolean z10) {
        if (this.api >= 327680 || (i10 & 256) != 0) {
            super.visitMethodInsn(i10, this.remapper.mapType(str), this.remapper.mapMethodName(str, str2, str3), this.remapper.mapMethodDesc(str3), z10);
            return;
        }
        super.visitMethodInsn(i10, str, str2, str3, z10);
    }

    public void visitMultiANewArrayInsn(String str, int i10) {
        super.visitMultiANewArrayInsn(this.remapper.mapDesc(str), i10);
    }

    public AnnotationVisitor visitParameterAnnotation(int i10, String str, boolean z10) {
        AnnotationVisitor visitParameterAnnotation = super.visitParameterAnnotation(i10, this.remapper.mapDesc(str), z10);
        if (visitParameterAnnotation == null) {
            return visitParameterAnnotation;
        }
        return createAnnotationRemapper(str, visitParameterAnnotation);
    }

    public AnnotationVisitor visitTryCatchAnnotation(int i10, TypePath typePath, String str, boolean z10) {
        AnnotationVisitor visitTryCatchAnnotation = super.visitTryCatchAnnotation(i10, typePath, this.remapper.mapDesc(str), z10);
        if (visitTryCatchAnnotation == null) {
            return visitTryCatchAnnotation;
        }
        return createAnnotationRemapper(str, visitTryCatchAnnotation);
    }

    public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
        super.visitTryCatchBlock(label, label2, label3, str == null ? null : this.remapper.mapType(str));
    }

    public AnnotationVisitor visitTypeAnnotation(int i10, TypePath typePath, String str, boolean z10) {
        AnnotationVisitor visitTypeAnnotation = super.visitTypeAnnotation(i10, typePath, this.remapper.mapDesc(str), z10);
        if (visitTypeAnnotation == null) {
            return visitTypeAnnotation;
        }
        return createAnnotationRemapper(str, visitTypeAnnotation);
    }

    public void visitTypeInsn(int i10, String str) {
        super.visitTypeInsn(i10, this.remapper.mapType(str));
    }

    protected MethodRemapper(int i10, MethodVisitor methodVisitor, Remapper remapper2) {
        super(i10, methodVisitor);
        this.remapper = remapper2;
    }

    /* access modifiers changed from: protected */
    public AnnotationVisitor createAnnotationRemapper(String str, AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.api, str, annotationVisitor, this.remapper).orDeprecatedValue(createAnnotationRemapper(annotationVisitor));
    }
}
