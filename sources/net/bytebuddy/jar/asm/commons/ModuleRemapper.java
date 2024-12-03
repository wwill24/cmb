package net.bytebuddy.jar.asm.commons;

import net.bytebuddy.jar.asm.ModuleVisitor;
import net.bytebuddy.jar.asm.Opcodes;

public class ModuleRemapper extends ModuleVisitor {
    protected final Remapper remapper;

    public ModuleRemapper(ModuleVisitor moduleVisitor, Remapper remapper2) {
        this(Opcodes.ASM9, moduleVisitor, remapper2);
    }

    public void visitExport(String str, int i10, String... strArr) {
        String[] strArr2;
        if (strArr != null) {
            strArr2 = new String[strArr.length];
            for (int i11 = 0; i11 < strArr.length; i11++) {
                strArr2[i11] = this.remapper.mapModuleName(strArr[i11]);
            }
        } else {
            strArr2 = null;
        }
        super.visitExport(this.remapper.mapPackageName(str), i10, strArr2);
    }

    public void visitMainClass(String str) {
        super.visitMainClass(this.remapper.mapType(str));
    }

    public void visitOpen(String str, int i10, String... strArr) {
        String[] strArr2;
        if (strArr != null) {
            strArr2 = new String[strArr.length];
            for (int i11 = 0; i11 < strArr.length; i11++) {
                strArr2[i11] = this.remapper.mapModuleName(strArr[i11]);
            }
        } else {
            strArr2 = null;
        }
        super.visitOpen(this.remapper.mapPackageName(str), i10, strArr2);
    }

    public void visitPackage(String str) {
        super.visitPackage(this.remapper.mapPackageName(str));
    }

    public void visitProvide(String str, String... strArr) {
        String[] strArr2 = new String[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            strArr2[i10] = this.remapper.mapType(strArr[i10]);
        }
        super.visitProvide(this.remapper.mapType(str), strArr2);
    }

    public void visitRequire(String str, int i10, String str2) {
        super.visitRequire(this.remapper.mapModuleName(str), i10, str2);
    }

    public void visitUse(String str) {
        super.visitUse(this.remapper.mapType(str));
    }

    protected ModuleRemapper(int i10, ModuleVisitor moduleVisitor, Remapper remapper2) {
        super(i10, moduleVisitor);
        this.remapper = remapper2;
    }
}
