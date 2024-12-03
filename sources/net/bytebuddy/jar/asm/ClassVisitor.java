package net.bytebuddy.jar.asm;

public abstract class ClassVisitor {
    protected final int api;
    /* access modifiers changed from: protected */
    public ClassVisitor cv;

    protected ClassVisitor(int i10) {
        this(i10, (ClassVisitor) null);
    }

    public ClassVisitor getDelegate() {
        return this.cv;
    }

    public void visit(int i10, int i11, String str, String str2, String str3, String[] strArr) {
        if (this.api >= 524288 || (65536 & i11) == 0) {
            ClassVisitor classVisitor = this.cv;
            if (classVisitor != null) {
                classVisitor.visit(i10, i11, str, str2, str3, strArr);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("Records requires ASM8");
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z10) {
        ClassVisitor classVisitor = this.cv;
        if (classVisitor != null) {
            return classVisitor.visitAnnotation(str, z10);
        }
        return null;
    }

    public void visitAttribute(Attribute attribute) {
        ClassVisitor classVisitor = this.cv;
        if (classVisitor != null) {
            classVisitor.visitAttribute(attribute);
        }
    }

    public void visitEnd() {
        ClassVisitor classVisitor = this.cv;
        if (classVisitor != null) {
            classVisitor.visitEnd();
        }
    }

    public FieldVisitor visitField(int i10, String str, String str2, String str3, Object obj) {
        ClassVisitor classVisitor = this.cv;
        if (classVisitor != null) {
            return classVisitor.visitField(i10, str, str2, str3, obj);
        }
        return null;
    }

    public void visitInnerClass(String str, String str2, String str3, int i10) {
        ClassVisitor classVisitor = this.cv;
        if (classVisitor != null) {
            classVisitor.visitInnerClass(str, str2, str3, i10);
        }
    }

    public MethodVisitor visitMethod(int i10, String str, String str2, String str3, String[] strArr) {
        ClassVisitor classVisitor = this.cv;
        if (classVisitor != null) {
            return classVisitor.visitMethod(i10, str, str2, str3, strArr);
        }
        return null;
    }

    public ModuleVisitor visitModule(String str, int i10, String str2) {
        if (this.api >= 393216) {
            ClassVisitor classVisitor = this.cv;
            if (classVisitor != null) {
                return classVisitor.visitModule(str, i10, str2);
            }
            return null;
        }
        throw new UnsupportedOperationException("Module requires ASM6");
    }

    public void visitNestHost(String str) {
        if (this.api >= 458752) {
            ClassVisitor classVisitor = this.cv;
            if (classVisitor != null) {
                classVisitor.visitNestHost(str);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("NestHost requires ASM7");
    }

    public void visitNestMember(String str) {
        if (this.api >= 458752) {
            ClassVisitor classVisitor = this.cv;
            if (classVisitor != null) {
                classVisitor.visitNestMember(str);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("NestMember requires ASM7");
    }

    public void visitOuterClass(String str, String str2, String str3) {
        ClassVisitor classVisitor = this.cv;
        if (classVisitor != null) {
            classVisitor.visitOuterClass(str, str2, str3);
        }
    }

    public void visitPermittedSubclass(String str) {
        if (this.api >= 589824) {
            ClassVisitor classVisitor = this.cv;
            if (classVisitor != null) {
                classVisitor.visitPermittedSubclass(str);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("PermittedSubclasses requires ASM9");
    }

    public RecordComponentVisitor visitRecordComponent(String str, String str2, String str3) {
        if (this.api >= 524288) {
            ClassVisitor classVisitor = this.cv;
            if (classVisitor != null) {
                return classVisitor.visitRecordComponent(str, str2, str3);
            }
            return null;
        }
        throw new UnsupportedOperationException("Record requires ASM8");
    }

    public void visitSource(String str, String str2) {
        ClassVisitor classVisitor = this.cv;
        if (classVisitor != null) {
            classVisitor.visitSource(str, str2);
        }
    }

    public AnnotationVisitor visitTypeAnnotation(int i10, TypePath typePath, String str, boolean z10) {
        if (this.api >= 327680) {
            ClassVisitor classVisitor = this.cv;
            if (classVisitor != null) {
                return classVisitor.visitTypeAnnotation(i10, typePath, str, z10);
            }
            return null;
        }
        throw new UnsupportedOperationException("TypeAnnotation requires ASM5");
    }

    protected ClassVisitor(int i10, ClassVisitor classVisitor) {
        if (i10 == 589824 || i10 == 524288 || i10 == 458752 || i10 == 393216 || i10 == 327680 || i10 == 262144 || i10 == 17432576) {
            if (i10 == 17432576) {
                Constants.checkAsmExperimental(this);
            }
            this.api = i10;
            this.cv = classVisitor;
            return;
        }
        throw new IllegalArgumentException("Unsupported api " + i10);
    }
}
