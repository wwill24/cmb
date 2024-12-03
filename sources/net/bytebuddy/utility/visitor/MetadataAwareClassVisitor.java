package net.bytebuddy.utility.visitor;

import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.Attribute;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.TypePath;
import net.bytebuddy.utility.nullability.MaybeNull;

public abstract class MetadataAwareClassVisitor extends ClassVisitor {
    private boolean triggerAttributes = true;
    private boolean triggerNestHost = true;
    private boolean triggerOuterClass = true;

    protected MetadataAwareClassVisitor(int i10, ClassVisitor classVisitor) {
        super(i10, classVisitor);
    }

    private void considerTriggerAfterAttributes() {
        if (this.triggerAttributes) {
            this.triggerAttributes = false;
            onAfterAttributes();
        }
    }

    private void considerTriggerNestHost() {
        if (this.triggerNestHost) {
            this.triggerNestHost = false;
            onNestHost();
        }
    }

    private void considerTriggerOuterClass() {
        if (this.triggerOuterClass) {
            this.triggerOuterClass = false;
            onOuterType();
        }
    }

    /* access modifiers changed from: protected */
    public void onAfterAttributes() {
    }

    /* access modifiers changed from: protected */
    public void onNestHost() {
    }

    /* access modifiers changed from: protected */
    public void onOuterType() {
    }

    /* access modifiers changed from: protected */
    @MaybeNull
    public AnnotationVisitor onVisitAnnotation(String str, boolean z10) {
        return super.visitAnnotation(str, z10);
    }

    /* access modifiers changed from: protected */
    public void onVisitAttribute(Attribute attribute) {
        super.visitAttribute(attribute);
    }

    /* access modifiers changed from: protected */
    public void onVisitEnd() {
        super.visitEnd();
    }

    /* access modifiers changed from: protected */
    @MaybeNull
    public FieldVisitor onVisitField(int i10, String str, String str2, @MaybeNull String str3, @MaybeNull Object obj) {
        return super.visitField(i10, str, str2, str3, obj);
    }

    /* access modifiers changed from: protected */
    public void onVisitInnerClass(String str, @MaybeNull String str2, @MaybeNull String str3, int i10) {
        super.visitInnerClass(str, str2, str3, i10);
    }

    /* access modifiers changed from: protected */
    @MaybeNull
    public MethodVisitor onVisitMethod(int i10, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
        return super.visitMethod(i10, str, str2, str3, strArr);
    }

    /* access modifiers changed from: protected */
    public void onVisitNestHost(String str) {
        super.visitNestHost(str);
    }

    /* access modifiers changed from: protected */
    public void onVisitNestMember(String str) {
        super.visitNestMember(str);
    }

    /* access modifiers changed from: protected */
    public void onVisitOuterClass(String str, @MaybeNull String str2, @MaybeNull String str3) {
        super.visitOuterClass(str, str2, str3);
    }

    /* access modifiers changed from: protected */
    public void onVisitPermittedSubclass(String str) {
        super.visitPermittedSubclass(str);
    }

    /* access modifiers changed from: protected */
    @MaybeNull
    public RecordComponentVisitor onVisitRecordComponent(String str, String str2, @MaybeNull String str3) {
        return super.visitRecordComponent(str, str2, str3);
    }

    /* access modifiers changed from: protected */
    @MaybeNull
    public AnnotationVisitor onVisitTypeAnnotation(int i10, TypePath typePath, String str, boolean z10) {
        return super.visitTypeAnnotation(i10, typePath, str, z10);
    }

    @MaybeNull
    public final AnnotationVisitor visitAnnotation(String str, boolean z10) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        return onVisitAnnotation(str, z10);
    }

    public final void visitAttribute(Attribute attribute) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        onVisitAttribute(attribute);
    }

    public final void visitEnd() {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        onVisitEnd();
    }

    @MaybeNull
    public final FieldVisitor visitField(int i10, String str, String str2, @MaybeNull String str3, @MaybeNull Object obj) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        return onVisitField(i10, str, str2, str3, obj);
    }

    public final void visitInnerClass(String str, @MaybeNull String str2, @MaybeNull String str3, int i10) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        onVisitInnerClass(str, str2, str3, i10);
    }

    @MaybeNull
    public final MethodVisitor visitMethod(int i10, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        return onVisitMethod(i10, str, str2, str3, strArr);
    }

    public final void visitNestHost(String str) {
        this.triggerNestHost = false;
        onVisitNestHost(str);
    }

    public final void visitNestMember(String str) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        onVisitNestMember(str);
    }

    public final void visitOuterClass(String str, @MaybeNull String str2, @MaybeNull String str3) {
        considerTriggerNestHost();
        this.triggerOuterClass = false;
        onVisitOuterClass(str, str2, str3);
    }

    public final void visitPermittedSubclass(String str) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        onVisitPermittedSubclass(str);
    }

    @MaybeNull
    public RecordComponentVisitor visitRecordComponent(String str, String str2, @MaybeNull String str3) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        return onVisitRecordComponent(str, str2, str3);
    }

    @MaybeNull
    public final AnnotationVisitor visitTypeAnnotation(int i10, TypePath typePath, String str, boolean z10) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        return onVisitTypeAnnotation(i10, typePath, str, z10);
    }
}
