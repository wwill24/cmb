package net.bytebuddy.jar.asm;

public abstract class MethodVisitor {
    private static final String REQUIRES_ASM5 = "This feature requires ASM5";
    protected final int api;
    protected MethodVisitor mv;

    protected MethodVisitor(int i10) {
        this(i10, (MethodVisitor) null);
    }

    public MethodVisitor getDelegate() {
        return this.mv;
    }

    public void visitAnnotableParameterCount(int i10, boolean z10) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitAnnotableParameterCount(i10, z10);
        }
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z10) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            return methodVisitor.visitAnnotation(str, z10);
        }
        return null;
    }

    public AnnotationVisitor visitAnnotationDefault() {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            return methodVisitor.visitAnnotationDefault();
        }
        return null;
    }

    public void visitAttribute(Attribute attribute) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitAttribute(attribute);
        }
    }

    public void visitCode() {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitCode();
        }
    }

    public void visitEnd() {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitEnd();
        }
    }

    public void visitFieldInsn(int i10, String str, String str2, String str3) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitFieldInsn(i10, str, str2, str3);
        }
    }

    public void visitFrame(int i10, int i11, Object[] objArr, int i12, Object[] objArr2) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitFrame(i10, i11, objArr, i12, objArr2);
        }
    }

    public void visitIincInsn(int i10, int i11) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitIincInsn(i10, i11);
        }
    }

    public void visitInsn(int i10) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitInsn(i10);
        }
    }

    public AnnotationVisitor visitInsnAnnotation(int i10, TypePath typePath, String str, boolean z10) {
        if (this.api >= 327680) {
            MethodVisitor methodVisitor = this.mv;
            if (methodVisitor != null) {
                return methodVisitor.visitInsnAnnotation(i10, typePath, str, z10);
            }
            return null;
        }
        throw new UnsupportedOperationException(REQUIRES_ASM5);
    }

    public void visitIntInsn(int i10, int i11) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitIntInsn(i10, i11);
        }
    }

    public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        if (this.api >= 327680) {
            MethodVisitor methodVisitor = this.mv;
            if (methodVisitor != null) {
                methodVisitor.visitInvokeDynamicInsn(str, str2, handle, objArr);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException(REQUIRES_ASM5);
    }

    public void visitJumpInsn(int i10, Label label) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitJumpInsn(i10, label);
        }
    }

    public void visitLabel(Label label) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitLabel(label);
        }
    }

    public void visitLdcInsn(Object obj) {
        if (this.api < 327680 && ((obj instanceof Handle) || ((obj instanceof Type) && ((Type) obj).getSort() == 11))) {
            throw new UnsupportedOperationException(REQUIRES_ASM5);
        } else if (this.api >= 458752 || !(obj instanceof ConstantDynamic)) {
            MethodVisitor methodVisitor = this.mv;
            if (methodVisitor != null) {
                methodVisitor.visitLdcInsn(obj);
            }
        } else {
            throw new UnsupportedOperationException("This feature requires ASM7");
        }
    }

    public void visitLineNumber(int i10, Label label) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitLineNumber(i10, label);
        }
    }

    public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i10) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitLocalVariable(str, str2, str3, label, label2, i10);
        }
    }

    public AnnotationVisitor visitLocalVariableAnnotation(int i10, TypePath typePath, Label[] labelArr, Label[] labelArr2, int[] iArr, String str, boolean z10) {
        if (this.api >= 327680) {
            MethodVisitor methodVisitor = this.mv;
            if (methodVisitor != null) {
                return methodVisitor.visitLocalVariableAnnotation(i10, typePath, labelArr, labelArr2, iArr, str, z10);
            }
            return null;
        }
        throw new UnsupportedOperationException(REQUIRES_ASM5);
    }

    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitLookupSwitchInsn(label, iArr, labelArr);
        }
    }

    public void visitMaxs(int i10, int i11) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitMaxs(i10, i11);
        }
    }

    @Deprecated
    public void visitMethodInsn(int i10, String str, String str2, String str3) {
        boolean z10 = false;
        int i11 = i10 | (this.api < 327680 ? 256 : 0);
        if (i10 == 185) {
            z10 = true;
        }
        visitMethodInsn(i11, str, str2, str3, z10);
    }

    public void visitMultiANewArrayInsn(String str, int i10) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitMultiANewArrayInsn(str, i10);
        }
    }

    public void visitParameter(String str, int i10) {
        if (this.api >= 327680) {
            MethodVisitor methodVisitor = this.mv;
            if (methodVisitor != null) {
                methodVisitor.visitParameter(str, i10);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException(REQUIRES_ASM5);
    }

    public AnnotationVisitor visitParameterAnnotation(int i10, String str, boolean z10) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            return methodVisitor.visitParameterAnnotation(i10, str, z10);
        }
        return null;
    }

    public void visitTableSwitchInsn(int i10, int i11, Label label, Label... labelArr) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitTableSwitchInsn(i10, i11, label, labelArr);
        }
    }

    public AnnotationVisitor visitTryCatchAnnotation(int i10, TypePath typePath, String str, boolean z10) {
        if (this.api >= 327680) {
            MethodVisitor methodVisitor = this.mv;
            if (methodVisitor != null) {
                return methodVisitor.visitTryCatchAnnotation(i10, typePath, str, z10);
            }
            return null;
        }
        throw new UnsupportedOperationException(REQUIRES_ASM5);
    }

    public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitTryCatchBlock(label, label2, label3, str);
        }
    }

    public AnnotationVisitor visitTypeAnnotation(int i10, TypePath typePath, String str, boolean z10) {
        if (this.api >= 327680) {
            MethodVisitor methodVisitor = this.mv;
            if (methodVisitor != null) {
                return methodVisitor.visitTypeAnnotation(i10, typePath, str, z10);
            }
            return null;
        }
        throw new UnsupportedOperationException(REQUIRES_ASM5);
    }

    public void visitTypeInsn(int i10, String str) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitTypeInsn(i10, str);
        }
    }

    public void visitVarInsn(int i10, int i11) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitVarInsn(i10, i11);
        }
    }

    protected MethodVisitor(int i10, MethodVisitor methodVisitor) {
        if (i10 == 589824 || i10 == 524288 || i10 == 458752 || i10 == 393216 || i10 == 327680 || i10 == 262144 || i10 == 17432576) {
            if (i10 == 17432576) {
                Constants.checkAsmExperimental(this);
            }
            this.api = i10;
            this.mv = methodVisitor;
            return;
        }
        throw new IllegalArgumentException("Unsupported api " + i10);
    }

    public void visitMethodInsn(int i10, String str, String str2, String str3, boolean z10) {
        if (this.api >= 327680 || (i10 & 256) != 0) {
            MethodVisitor methodVisitor = this.mv;
            if (methodVisitor != null) {
                methodVisitor.visitMethodInsn(i10 & -257, str, str2, str3, z10);
                return;
            }
            return;
        }
        if (z10 == (i10 == 185)) {
            visitMethodInsn(i10, str, str2, str3);
            return;
        }
        throw new UnsupportedOperationException("INVOKESPECIAL/STATIC on interfaces requires ASM5");
    }
}
