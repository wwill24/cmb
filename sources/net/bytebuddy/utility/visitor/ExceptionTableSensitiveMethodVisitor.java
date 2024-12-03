package net.bytebuddy.utility.visitor;

import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;

public abstract class ExceptionTableSensitiveMethodVisitor extends MethodVisitor {
    private boolean trigger = true;

    protected ExceptionTableSensitiveMethodVisitor(int i10, MethodVisitor methodVisitor) {
        super(i10, methodVisitor);
    }

    private void considerEndOfExceptionTable() {
        if (this.trigger) {
            this.trigger = false;
            onAfterExceptionTable();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void onAfterExceptionTable();

    /* access modifiers changed from: protected */
    public void onVisitFieldInsn(int i10, String str, String str2, String str3) {
        super.visitFieldInsn(i10, str, str2, str3);
    }

    /* access modifiers changed from: protected */
    public void onVisitFrame(int i10, int i11, Object[] objArr, int i12, Object[] objArr2) {
        super.visitFrame(i10, i11, objArr, i12, objArr2);
    }

    /* access modifiers changed from: protected */
    public void onVisitIincInsn(int i10, int i11) {
        super.visitIincInsn(i10, i11);
    }

    /* access modifiers changed from: protected */
    public void onVisitInsn(int i10) {
        super.visitInsn(i10);
    }

    /* access modifiers changed from: protected */
    public void onVisitIntInsn(int i10, int i11) {
        super.visitIntInsn(i10, i11);
    }

    /* access modifiers changed from: protected */
    public void onVisitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        super.visitInvokeDynamicInsn(str, str2, handle, objArr);
    }

    /* access modifiers changed from: protected */
    public void onVisitJumpInsn(int i10, Label label) {
        super.visitJumpInsn(i10, label);
    }

    /* access modifiers changed from: protected */
    public void onVisitLabel(Label label) {
        super.visitLabel(label);
    }

    /* access modifiers changed from: protected */
    public void onVisitLdcInsn(Object obj) {
        super.visitLdcInsn(obj);
    }

    /* access modifiers changed from: protected */
    public void onVisitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        super.visitLookupSwitchInsn(label, iArr, labelArr);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onVisitMethodInsn(int i10, String str, String str2, String str3) {
        super.visitMethodInsn(i10, str, str2, str3);
    }

    /* access modifiers changed from: protected */
    public void onVisitMultiANewArrayInsn(String str, int i10) {
        super.visitMultiANewArrayInsn(str, i10);
    }

    /* access modifiers changed from: protected */
    public void onVisitTableSwitchInsn(int i10, int i11, Label label, Label... labelArr) {
        super.visitTableSwitchInsn(i10, i11, label, labelArr);
    }

    /* access modifiers changed from: protected */
    public void onVisitTypeInsn(int i10, String str) {
        super.visitTypeInsn(i10, str);
    }

    /* access modifiers changed from: protected */
    public void onVisitVarInsn(int i10, int i11) {
        super.visitVarInsn(i10, i11);
    }

    public final void visitFieldInsn(int i10, String str, String str2, String str3) {
        considerEndOfExceptionTable();
        onVisitFieldInsn(i10, str, str2, str3);
    }

    public final void visitFrame(int i10, int i11, Object[] objArr, int i12, Object[] objArr2) {
        considerEndOfExceptionTable();
        onVisitFrame(i10, i11, objArr, i12, objArr2);
    }

    public final void visitIincInsn(int i10, int i11) {
        considerEndOfExceptionTable();
        onVisitIincInsn(i10, i11);
    }

    public final void visitInsn(int i10) {
        considerEndOfExceptionTable();
        onVisitInsn(i10);
    }

    public final void visitIntInsn(int i10, int i11) {
        considerEndOfExceptionTable();
        onVisitIntInsn(i10, i11);
    }

    public final void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        considerEndOfExceptionTable();
        onVisitInvokeDynamicInsn(str, str2, handle, objArr);
    }

    public final void visitJumpInsn(int i10, Label label) {
        considerEndOfExceptionTable();
        onVisitJumpInsn(i10, label);
    }

    public final void visitLabel(Label label) {
        considerEndOfExceptionTable();
        onVisitLabel(label);
    }

    public final void visitLdcInsn(Object obj) {
        considerEndOfExceptionTable();
        onVisitLdcInsn(obj);
    }

    public final void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        considerEndOfExceptionTable();
        onVisitLookupSwitchInsn(label, iArr, labelArr);
    }

    public final void visitMethodInsn(int i10, String str, String str2, String str3) {
        considerEndOfExceptionTable();
        onVisitMethodInsn(i10, str, str2, str3);
    }

    public final void visitMultiANewArrayInsn(String str, int i10) {
        considerEndOfExceptionTable();
        onVisitMultiANewArrayInsn(str, i10);
    }

    public final void visitTableSwitchInsn(int i10, int i11, Label label, Label... labelArr) {
        considerEndOfExceptionTable();
        onVisitTableSwitchInsn(i10, i11, label, labelArr);
    }

    public final void visitTypeInsn(int i10, String str) {
        considerEndOfExceptionTable();
        onVisitTypeInsn(i10, str);
    }

    public final void visitVarInsn(int i10, int i11) {
        considerEndOfExceptionTable();
        onVisitVarInsn(i10, i11);
    }

    /* access modifiers changed from: protected */
    public void onVisitMethodInsn(int i10, String str, String str2, String str3, boolean z10) {
        super.visitMethodInsn(i10, str, str2, str3, z10);
    }

    public final void visitMethodInsn(int i10, String str, String str2, String str3, boolean z10) {
        considerEndOfExceptionTable();
        onVisitMethodInsn(i10, str, str2, str3, z10);
    }
}
