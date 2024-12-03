package net.bytebuddy.jar.asm;

public abstract class ModuleVisitor {
    protected final int api;
    protected ModuleVisitor mv;

    protected ModuleVisitor(int i10) {
        this(i10, (ModuleVisitor) null);
    }

    public ModuleVisitor getDelegate() {
        return this.mv;
    }

    public void visitEnd() {
        ModuleVisitor moduleVisitor = this.mv;
        if (moduleVisitor != null) {
            moduleVisitor.visitEnd();
        }
    }

    public void visitExport(String str, int i10, String... strArr) {
        ModuleVisitor moduleVisitor = this.mv;
        if (moduleVisitor != null) {
            moduleVisitor.visitExport(str, i10, strArr);
        }
    }

    public void visitMainClass(String str) {
        ModuleVisitor moduleVisitor = this.mv;
        if (moduleVisitor != null) {
            moduleVisitor.visitMainClass(str);
        }
    }

    public void visitOpen(String str, int i10, String... strArr) {
        ModuleVisitor moduleVisitor = this.mv;
        if (moduleVisitor != null) {
            moduleVisitor.visitOpen(str, i10, strArr);
        }
    }

    public void visitPackage(String str) {
        ModuleVisitor moduleVisitor = this.mv;
        if (moduleVisitor != null) {
            moduleVisitor.visitPackage(str);
        }
    }

    public void visitProvide(String str, String... strArr) {
        ModuleVisitor moduleVisitor = this.mv;
        if (moduleVisitor != null) {
            moduleVisitor.visitProvide(str, strArr);
        }
    }

    public void visitRequire(String str, int i10, String str2) {
        ModuleVisitor moduleVisitor = this.mv;
        if (moduleVisitor != null) {
            moduleVisitor.visitRequire(str, i10, str2);
        }
    }

    public void visitUse(String str) {
        ModuleVisitor moduleVisitor = this.mv;
        if (moduleVisitor != null) {
            moduleVisitor.visitUse(str);
        }
    }

    protected ModuleVisitor(int i10, ModuleVisitor moduleVisitor) {
        if (i10 == 589824 || i10 == 524288 || i10 == 458752 || i10 == 393216 || i10 == 327680 || i10 == 262144 || i10 == 17432576) {
            if (i10 == 17432576) {
                Constants.checkAsmExperimental(this);
            }
            this.api = i10;
            this.mv = moduleVisitor;
            return;
        }
        throw new IllegalArgumentException("Unsupported api " + i10);
    }
}
