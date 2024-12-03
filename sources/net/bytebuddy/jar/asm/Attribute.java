package net.bytebuddy.jar.asm;

public class Attribute {
    private byte[] content;
    Attribute nextAttribute;
    public final String type;

    static final class Set {
        private static final int SIZE_INCREMENT = 6;
        private Attribute[] data = new Attribute[6];
        private int size;

        Set() {
        }

        private void add(Attribute attribute) {
            int i10 = this.size;
            Attribute[] attributeArr = this.data;
            if (i10 >= attributeArr.length) {
                Attribute[] attributeArr2 = new Attribute[(attributeArr.length + 6)];
                System.arraycopy(attributeArr, 0, attributeArr2, 0, i10);
                this.data = attributeArr2;
            }
            Attribute[] attributeArr3 = this.data;
            int i11 = this.size;
            this.size = i11 + 1;
            attributeArr3[i11] = attribute;
        }

        private boolean contains(Attribute attribute) {
            for (int i10 = 0; i10 < this.size; i10++) {
                if (this.data[i10].type.equals(attribute.type)) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void addAttributes(Attribute attribute) {
            while (attribute != null) {
                if (!contains(attribute)) {
                    add(attribute);
                }
                attribute = attribute.nextAttribute;
            }
        }

        /* access modifiers changed from: package-private */
        public Attribute[] toArray() {
            int i10 = this.size;
            Attribute[] attributeArr = new Attribute[i10];
            System.arraycopy(this.data, 0, attributeArr, 0, i10);
            return attributeArr;
        }
    }

    protected Attribute(String str) {
        this.type = str;
    }

    /* access modifiers changed from: package-private */
    public final int computeAttributesSize(SymbolTable symbolTable) {
        return computeAttributesSize(symbolTable, (byte[]) null, 0, -1, -1);
    }

    /* access modifiers changed from: package-private */
    public final int getAttributeCount() {
        int i10 = 0;
        for (Attribute attribute = this; attribute != null; attribute = attribute.nextAttribute) {
            i10++;
        }
        return i10;
    }

    /* access modifiers changed from: protected */
    public Label[] getLabels() {
        return new Label[0];
    }

    public boolean isCodeAttribute() {
        return false;
    }

    public boolean isUnknown() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void putAttributes(SymbolTable symbolTable, ByteVector byteVector) {
        putAttributes(symbolTable, (byte[]) null, 0, -1, -1, byteVector);
    }

    /* access modifiers changed from: protected */
    public Attribute read(ClassReader classReader, int i10, int i11, char[] cArr, int i12, Label[] labelArr) {
        Attribute attribute = new Attribute(this.type);
        byte[] bArr = new byte[i11];
        attribute.content = bArr;
        System.arraycopy(classReader.classFileBuffer, i10, bArr, 0, i11);
        return attribute;
    }

    /* access modifiers changed from: protected */
    public ByteVector write(ClassWriter classWriter, byte[] bArr, int i10, int i11, int i12) {
        return new ByteVector(this.content);
    }

    /* access modifiers changed from: package-private */
    public final int computeAttributesSize(SymbolTable symbolTable, byte[] bArr, int i10, int i11, int i12) {
        ClassWriter classWriter = symbolTable.classWriter;
        int i13 = 0;
        for (Attribute attribute = this; attribute != null; attribute = attribute.nextAttribute) {
            symbolTable.addConstantUtf8(attribute.type);
            i13 += attribute.write(classWriter, bArr, i10, i11, i12).length + 6;
        }
        return i13;
    }

    /* access modifiers changed from: package-private */
    public final void putAttributes(SymbolTable symbolTable, byte[] bArr, int i10, int i11, int i12, ByteVector byteVector) {
        ClassWriter classWriter = symbolTable.classWriter;
        for (Attribute attribute = this; attribute != null; attribute = attribute.nextAttribute) {
            ByteVector write = attribute.write(classWriter, bArr, i10, i11, i12);
            byteVector.putShort(symbolTable.addConstantUtf8(attribute.type)).putInt(write.length);
            byteVector.putByteArray(write.data, 0, write.length);
        }
    }

    static int computeAttributesSize(SymbolTable symbolTable, int i10, int i11) {
        int i12;
        if ((i10 & Opcodes.ACC_SYNTHETIC) == 0 || symbolTable.getMajorVersion() >= 49) {
            i12 = 0;
        } else {
            symbolTable.addConstantUtf8("Synthetic");
            i12 = 6;
        }
        if (i11 != 0) {
            symbolTable.addConstantUtf8("Signature");
            i12 += 8;
        }
        if ((i10 & Opcodes.ACC_DEPRECATED) == 0) {
            return i12;
        }
        symbolTable.addConstantUtf8("Deprecated");
        return i12 + 6;
    }

    static void putAttributes(SymbolTable symbolTable, int i10, int i11, ByteVector byteVector) {
        if ((i10 & Opcodes.ACC_SYNTHETIC) != 0 && symbolTable.getMajorVersion() < 49) {
            byteVector.putShort(symbolTable.addConstantUtf8("Synthetic")).putInt(0);
        }
        if (i11 != 0) {
            byteVector.putShort(symbolTable.addConstantUtf8("Signature")).putInt(2).putShort(i11);
        }
        if ((i10 & Opcodes.ACC_DEPRECATED) != 0) {
            byteVector.putShort(symbolTable.addConstantUtf8("Deprecated")).putInt(0);
        }
    }
}
