package net.bytebuddy.jar.asm;

final class ModuleWriter extends ModuleVisitor {
    private final ByteVector exports = new ByteVector();
    private int exportsCount;
    private int mainClassIndex;
    private final int moduleFlags;
    private final int moduleNameIndex;
    private final int moduleVersionIndex;
    private final ByteVector opens = new ByteVector();
    private int opensCount;
    private int packageCount;
    private final ByteVector packageIndex = new ByteVector();
    private final ByteVector provides = new ByteVector();
    private int providesCount;
    private final ByteVector requires = new ByteVector();
    private int requiresCount;
    private final SymbolTable symbolTable;
    private int usesCount;
    private final ByteVector usesIndex = new ByteVector();

    ModuleWriter(SymbolTable symbolTable2, int i10, int i11, int i12) {
        super(Opcodes.ASM9);
        this.symbolTable = symbolTable2;
        this.moduleNameIndex = i10;
        this.moduleFlags = i11;
        this.moduleVersionIndex = i12;
    }

    /* access modifiers changed from: package-private */
    public int computeAttributesSize() {
        this.symbolTable.addConstantUtf8("Module");
        int i10 = this.requires.length + 22 + this.exports.length + this.opens.length + this.usesIndex.length + this.provides.length;
        if (this.packageCount > 0) {
            this.symbolTable.addConstantUtf8("ModulePackages");
            i10 += this.packageIndex.length + 8;
        }
        if (this.mainClassIndex <= 0) {
            return i10;
        }
        this.symbolTable.addConstantUtf8("ModuleMainClass");
        return i10 + 8;
    }

    /* access modifiers changed from: package-private */
    public int getAttributeCount() {
        int i10 = 0;
        int i11 = (this.packageCount > 0 ? 1 : 0) + 1;
        if (this.mainClassIndex > 0) {
            i10 = 1;
        }
        return i11 + i10;
    }

    /* access modifiers changed from: package-private */
    public void putAttributes(ByteVector byteVector) {
        ByteVector putShort = byteVector.putShort(this.symbolTable.addConstantUtf8("Module")).putInt(this.requires.length + 16 + this.exports.length + this.opens.length + this.usesIndex.length + this.provides.length).putShort(this.moduleNameIndex).putShort(this.moduleFlags).putShort(this.moduleVersionIndex).putShort(this.requiresCount);
        ByteVector byteVector2 = this.requires;
        ByteVector putShort2 = putShort.putByteArray(byteVector2.data, 0, byteVector2.length).putShort(this.exportsCount);
        ByteVector byteVector3 = this.exports;
        ByteVector putShort3 = putShort2.putByteArray(byteVector3.data, 0, byteVector3.length).putShort(this.opensCount);
        ByteVector byteVector4 = this.opens;
        ByteVector putShort4 = putShort3.putByteArray(byteVector4.data, 0, byteVector4.length).putShort(this.usesCount);
        ByteVector byteVector5 = this.usesIndex;
        ByteVector putShort5 = putShort4.putByteArray(byteVector5.data, 0, byteVector5.length).putShort(this.providesCount);
        ByteVector byteVector6 = this.provides;
        putShort5.putByteArray(byteVector6.data, 0, byteVector6.length);
        if (this.packageCount > 0) {
            ByteVector putShort6 = byteVector.putShort(this.symbolTable.addConstantUtf8("ModulePackages")).putInt(this.packageIndex.length + 2).putShort(this.packageCount);
            ByteVector byteVector7 = this.packageIndex;
            putShort6.putByteArray(byteVector7.data, 0, byteVector7.length);
        }
        if (this.mainClassIndex > 0) {
            byteVector.putShort(this.symbolTable.addConstantUtf8("ModuleMainClass")).putInt(2).putShort(this.mainClassIndex);
        }
    }

    public void visitEnd() {
    }

    public void visitExport(String str, int i10, String... strArr) {
        this.exports.putShort(this.symbolTable.addConstantPackage(str).index).putShort(i10);
        if (strArr == null) {
            this.exports.putShort(0);
        } else {
            this.exports.putShort(strArr.length);
            for (String addConstantModule : strArr) {
                this.exports.putShort(this.symbolTable.addConstantModule(addConstantModule).index);
            }
        }
        this.exportsCount++;
    }

    public void visitMainClass(String str) {
        this.mainClassIndex = this.symbolTable.addConstantClass(str).index;
    }

    public void visitOpen(String str, int i10, String... strArr) {
        this.opens.putShort(this.symbolTable.addConstantPackage(str).index).putShort(i10);
        if (strArr == null) {
            this.opens.putShort(0);
        } else {
            this.opens.putShort(strArr.length);
            for (String addConstantModule : strArr) {
                this.opens.putShort(this.symbolTable.addConstantModule(addConstantModule).index);
            }
        }
        this.opensCount++;
    }

    public void visitPackage(String str) {
        this.packageIndex.putShort(this.symbolTable.addConstantPackage(str).index);
        this.packageCount++;
    }

    public void visitProvide(String str, String... strArr) {
        this.provides.putShort(this.symbolTable.addConstantClass(str).index);
        this.provides.putShort(strArr.length);
        for (String addConstantClass : strArr) {
            this.provides.putShort(this.symbolTable.addConstantClass(addConstantClass).index);
        }
        this.providesCount++;
    }

    public void visitRequire(String str, int i10, String str2) {
        int i11;
        ByteVector putShort = this.requires.putShort(this.symbolTable.addConstantModule(str).index).putShort(i10);
        if (str2 == null) {
            i11 = 0;
        } else {
            i11 = this.symbolTable.addConstantUtf8(str2);
        }
        putShort.putShort(i11);
        this.requiresCount++;
    }

    public void visitUse(String str) {
        this.usesIndex.putShort(this.symbolTable.addConstantClass(str).index);
        this.usesCount++;
    }
}
