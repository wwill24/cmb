package net.bytebuddy.jar.asm.commons;

import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.jar.asm.Attribute;
import net.bytebuddy.jar.asm.ByteVector;
import net.bytebuddy.jar.asm.ClassReader;
import net.bytebuddy.jar.asm.ClassWriter;
import net.bytebuddy.jar.asm.Label;

public final class ModuleHashesAttribute extends Attribute {
    public String algorithm;
    public List<byte[]> hashes;
    public List<String> modules;

    public ModuleHashesAttribute(String str, List<String> list, List<byte[]> list2) {
        super("ModuleHashes");
        this.algorithm = str;
        this.modules = list;
        this.hashes = list2;
    }

    /* access modifiers changed from: protected */
    public Attribute read(ClassReader classReader, int i10, int i11, char[] cArr, int i12, Label[] labelArr) {
        String readUTF8 = classReader.readUTF8(i10, cArr);
        int i13 = i10 + 2;
        int readUnsignedShort = classReader.readUnsignedShort(i13);
        int i14 = i13 + 2;
        ArrayList arrayList = new ArrayList(readUnsignedShort);
        ArrayList arrayList2 = new ArrayList(readUnsignedShort);
        for (int i15 = 0; i15 < readUnsignedShort; i15++) {
            String readModule = classReader.readModule(i14, cArr);
            int i16 = i14 + 2;
            arrayList.add(readModule);
            int readUnsignedShort2 = classReader.readUnsignedShort(i16);
            i14 = i16 + 2;
            byte[] bArr = new byte[readUnsignedShort2];
            for (int i17 = 0; i17 < readUnsignedShort2; i17++) {
                bArr[i17] = (byte) classReader.readByte(i14);
                i14++;
            }
            arrayList2.add(bArr);
        }
        return new ModuleHashesAttribute(readUTF8, arrayList, arrayList2);
    }

    /* access modifiers changed from: protected */
    public ByteVector write(ClassWriter classWriter, byte[] bArr, int i10, int i11, int i12) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(classWriter.newUTF8(this.algorithm));
        List<String> list = this.modules;
        if (list == null) {
            byteVector.putShort(0);
        } else {
            int size = list.size();
            byteVector.putShort(size);
            for (int i13 = 0; i13 < size; i13++) {
                byte[] bArr2 = this.hashes.get(i13);
                byteVector.putShort(classWriter.newModule(this.modules.get(i13))).putShort(bArr2.length).putByteArray(bArr2, 0, bArr2.length);
            }
        }
        return byteVector;
    }

    public ModuleHashesAttribute() {
        this((String) null, (List<String>) null, (List<byte[]>) null);
    }
}
