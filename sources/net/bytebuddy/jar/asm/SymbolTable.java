package net.bytebuddy.jar.asm;

import com.google.android.gms.common.api.a;

final class SymbolTable {
    private int bootstrapMethodCount;
    private ByteVector bootstrapMethods;
    private String className;
    final ClassWriter classWriter;
    private ByteVector constantPool;
    private int constantPoolCount;
    private Entry[] entries;
    private int entryCount;
    private int majorVersion;
    private final ClassReader sourceClassReader;
    private int typeCount;
    private Entry[] typeTable;

    SymbolTable(ClassWriter classWriter2) {
        this.classWriter = classWriter2;
        this.sourceClassReader = null;
        this.entries = new Entry[256];
        this.constantPoolCount = 1;
        this.constantPool = new ByteVector();
    }

    private void add(Entry entry) {
        this.entryCount++;
        int i10 = entry.hashCode;
        Entry[] entryArr = this.entries;
        int length = i10 % entryArr.length;
        entry.next = entryArr[length];
        entryArr[length] = entry;
    }

    private Symbol addConstantDynamicOrInvokeDynamicReference(int i10, String str, String str2, int i11) {
        int hash = hash(i10, str, str2, i11);
        for (Entry entry = get(hash); entry != null; entry = entry.next) {
            if (entry.tag == i10 && entry.hashCode == hash && entry.data == ((long) i11) && entry.name.equals(str) && entry.value.equals(str2)) {
                return entry;
            }
        }
        this.constantPool.put122(i10, i11, addConstantNameAndType(str, str2));
        int i12 = this.constantPoolCount;
        this.constantPoolCount = i12 + 1;
        return put(new Entry(i12, i10, (String) null, str, str2, (long) i11, hash));
    }

    private Symbol addConstantIntegerOrFloat(int i10, int i11) {
        int hash = hash(i10, i11);
        for (Entry entry = get(hash); entry != null; entry = entry.next) {
            if (entry.tag == i10 && entry.hashCode == hash && entry.data == ((long) i11)) {
                return entry;
            }
        }
        this.constantPool.putByte(i10).putInt(i11);
        int i12 = this.constantPoolCount;
        this.constantPoolCount = i12 + 1;
        return put(new Entry(i12, i10, (long) i11, hash));
    }

    private Symbol addConstantLongOrDouble(int i10, long j10) {
        int hash = hash(i10, j10);
        for (Entry entry = get(hash); entry != null; entry = entry.next) {
            if (entry.tag == i10 && entry.hashCode == hash && entry.data == j10) {
                return entry;
            }
        }
        int i11 = this.constantPoolCount;
        this.constantPool.putByte(i10).putLong(j10);
        this.constantPoolCount += 2;
        return put(new Entry(i11, i10, j10, hash));
    }

    private Entry addConstantMemberReference(int i10, String str, String str2, String str3) {
        int hash = hash(i10, str, str2, str3);
        for (Entry entry = get(hash); entry != null; entry = entry.next) {
            if (entry.tag == i10 && entry.hashCode == hash && entry.owner.equals(str) && entry.name.equals(str2) && entry.value.equals(str3)) {
                return entry;
            }
        }
        this.constantPool.put122(i10, addConstantClass(str).index, addConstantNameAndType(str2, str3));
        int i11 = this.constantPoolCount;
        this.constantPoolCount = i11 + 1;
        return put(new Entry(i11, i10, str, str2, str3, 0, hash));
    }

    private Symbol addConstantUtf8Reference(int i10, String str) {
        int hash = hash(i10, str);
        for (Entry entry = get(hash); entry != null; entry = entry.next) {
            if (entry.tag == i10 && entry.hashCode == hash && entry.value.equals(str)) {
                return entry;
            }
        }
        this.constantPool.put12(i10, addConstantUtf8(str));
        int i11 = this.constantPoolCount;
        this.constantPoolCount = i11 + 1;
        return put(new Entry(i11, i10, str, hash));
    }

    private int addTypeInternal(Entry entry) {
        if (this.typeTable == null) {
            this.typeTable = new Entry[16];
        }
        int i10 = this.typeCount;
        Entry[] entryArr = this.typeTable;
        if (i10 == entryArr.length) {
            Entry[] entryArr2 = new Entry[(entryArr.length * 2)];
            System.arraycopy(entryArr, 0, entryArr2, 0, entryArr.length);
            this.typeTable = entryArr2;
        }
        Entry[] entryArr3 = this.typeTable;
        int i11 = this.typeCount;
        this.typeCount = i11 + 1;
        entryArr3[i11] = entry;
        return put(entry).index;
    }

    private void copyBootstrapMethods(ClassReader classReader, char[] cArr) {
        byte[] bArr = classReader.classFileBuffer;
        int firstAttributeOffset = classReader.getFirstAttributeOffset();
        int readUnsignedShort = classReader.readUnsignedShort(firstAttributeOffset - 2);
        while (true) {
            if (readUnsignedShort <= 0) {
                break;
            } else if ("BootstrapMethods".equals(classReader.readUTF8(firstAttributeOffset, cArr))) {
                this.bootstrapMethodCount = classReader.readUnsignedShort(firstAttributeOffset + 6);
                break;
            } else {
                firstAttributeOffset += classReader.readInt(firstAttributeOffset + 2) + 6;
                readUnsignedShort--;
            }
        }
        if (this.bootstrapMethodCount > 0) {
            int i10 = firstAttributeOffset + 8;
            int readInt = classReader.readInt(firstAttributeOffset + 2) - 2;
            ByteVector byteVector = new ByteVector(readInt);
            this.bootstrapMethods = byteVector;
            byteVector.putByteArray(bArr, i10, readInt);
            int i11 = i10;
            for (int i12 = 0; i12 < this.bootstrapMethodCount; i12++) {
                int i13 = i11 - i10;
                int readUnsignedShort2 = classReader.readUnsignedShort(i11);
                int i14 = i11 + 2;
                int readUnsignedShort3 = classReader.readUnsignedShort(i14);
                i11 = i14 + 2;
                int hashCode = classReader.readConst(readUnsignedShort2, cArr).hashCode();
                while (true) {
                    int i15 = readUnsignedShort3 - 1;
                    if (readUnsignedShort3 <= 0) {
                        break;
                    }
                    int readUnsignedShort4 = classReader.readUnsignedShort(i11);
                    i11 += 2;
                    hashCode ^= classReader.readConst(readUnsignedShort4, cArr).hashCode();
                    readUnsignedShort3 = i15;
                }
                add(new Entry(i12, 64, (long) i13, hashCode & a.e.API_PRIORITY_OTHER));
            }
        }
    }

    private Entry get(int i10) {
        Entry[] entryArr = this.entries;
        return entryArr[i10 % entryArr.length];
    }

    private static int hash(int i10, int i11) {
        return (i10 + i11) & a.e.API_PRIORITY_OTHER;
    }

    private static int hash(int i10, long j10) {
        return (i10 + ((int) j10) + ((int) (j10 >>> 32))) & a.e.API_PRIORITY_OTHER;
    }

    private static int hash(int i10, String str) {
        return (i10 + str.hashCode()) & a.e.API_PRIORITY_OTHER;
    }

    private Entry put(Entry entry) {
        int i10 = this.entryCount;
        Entry[] entryArr = this.entries;
        if (i10 > (entryArr.length * 3) / 4) {
            int length = entryArr.length;
            int i11 = (length * 2) + 1;
            Entry[] entryArr2 = new Entry[i11];
            for (int i12 = length - 1; i12 >= 0; i12--) {
                Entry entry2 = this.entries[i12];
                while (entry2 != null) {
                    int i13 = entry2.hashCode % i11;
                    Entry entry3 = entry2.next;
                    entry2.next = entryArr2[i13];
                    entryArr2[i13] = entry2;
                    entry2 = entry3;
                }
            }
            this.entries = entryArr2;
        }
        this.entryCount++;
        int i14 = entry.hashCode;
        Entry[] entryArr3 = this.entries;
        int length2 = i14 % entryArr3.length;
        entry.next = entryArr3[length2];
        entryArr3[length2] = entry;
        return entry;
    }

    /* access modifiers changed from: package-private */
    public Symbol addBootstrapMethod(Handle handle, Object... objArr) {
        ByteVector byteVector = this.bootstrapMethods;
        if (byteVector == null) {
            byteVector = new ByteVector();
            this.bootstrapMethods = byteVector;
        }
        int length = objArr.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = addConstant(objArr[i10]).index;
        }
        int i11 = byteVector.length;
        byteVector.putShort(addConstantMethodHandle(handle.getTag(), handle.getOwner(), handle.getName(), handle.getDesc(), handle.isInterface()).index);
        byteVector.putShort(length);
        for (int i12 = 0; i12 < length; i12++) {
            byteVector.putShort(iArr[i12]);
        }
        int i13 = byteVector.length - i11;
        int hashCode = handle.hashCode();
        for (Object hashCode2 : objArr) {
            hashCode ^= hashCode2.hashCode();
        }
        return addBootstrapMethod(i11, i13, hashCode & a.e.API_PRIORITY_OTHER);
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstant(Object obj) {
        if (obj instanceof Integer) {
            return addConstantInteger(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return addConstantInteger(((Byte) obj).intValue());
        }
        if (obj instanceof Character) {
            return addConstantInteger(((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return addConstantInteger(((Short) obj).intValue());
        }
        if (obj instanceof Boolean) {
            return addConstantInteger(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Float) {
            return addConstantFloat(((Float) obj).floatValue());
        }
        if (obj instanceof Long) {
            return addConstantLong(((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return addConstantDouble(((Double) obj).doubleValue());
        }
        if (obj instanceof String) {
            return addConstantString((String) obj);
        }
        if (obj instanceof Type) {
            Type type = (Type) obj;
            int sort = type.getSort();
            if (sort == 10) {
                return addConstantClass(type.getInternalName());
            }
            if (sort == 11) {
                return addConstantMethodType(type.getDescriptor());
            }
            return addConstantClass(type.getDescriptor());
        } else if (obj instanceof Handle) {
            Handle handle = (Handle) obj;
            return addConstantMethodHandle(handle.getTag(), handle.getOwner(), handle.getName(), handle.getDesc(), handle.isInterface());
        } else if (obj instanceof ConstantDynamic) {
            ConstantDynamic constantDynamic = (ConstantDynamic) obj;
            return addConstantDynamic(constantDynamic.getName(), constantDynamic.getDescriptor(), constantDynamic.getBootstrapMethod(), constantDynamic.getBootstrapMethodArgumentsUnsafe());
        } else {
            throw new IllegalArgumentException("value " + obj);
        }
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantClass(String str) {
        return addConstantUtf8Reference(7, str);
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantDouble(double d10) {
        return addConstantLongOrDouble(6, Double.doubleToRawLongBits(d10));
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantDynamic(String str, String str2, Handle handle, Object... objArr) {
        return addConstantDynamicOrInvokeDynamicReference(17, str, str2, addBootstrapMethod(handle, objArr).index);
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantFieldref(String str, String str2, String str3) {
        return addConstantMemberReference(9, str, str2, str3);
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantFloat(float f10) {
        return addConstantIntegerOrFloat(4, Float.floatToRawIntBits(f10));
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantInteger(int i10) {
        return addConstantIntegerOrFloat(3, i10);
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantInvokeDynamic(String str, String str2, Handle handle, Object... objArr) {
        return addConstantDynamicOrInvokeDynamicReference(18, str, str2, addBootstrapMethod(handle, objArr).index);
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantLong(long j10) {
        return addConstantLongOrDouble(5, j10);
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantMethodHandle(int i10, String str, String str2, String str3, boolean z10) {
        int hash = hash(15, str, str2, str3, i10);
        for (Entry entry = get(hash); entry != null; entry = entry.next) {
            if (entry.tag == 15 && entry.hashCode == hash && entry.data == ((long) i10) && entry.owner.equals(str) && entry.name.equals(str2) && entry.value.equals(str3)) {
                return entry;
            }
        }
        if (i10 <= 4) {
            this.constantPool.put112(15, i10, addConstantFieldref(str, str2, str3).index);
        } else {
            this.constantPool.put112(15, i10, addConstantMethodref(str, str2, str3, z10).index);
        }
        int i11 = this.constantPoolCount;
        this.constantPoolCount = i11 + 1;
        return put(new Entry(i11, 15, str, str2, str3, (long) i10, hash));
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantMethodType(String str) {
        return addConstantUtf8Reference(16, str);
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantMethodref(String str, String str2, String str3, boolean z10) {
        return addConstantMemberReference(z10 ? 11 : 10, str, str2, str3);
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantModule(String str) {
        return addConstantUtf8Reference(19, str);
    }

    /* access modifiers changed from: package-private */
    public int addConstantNameAndType(String str, String str2) {
        int hash = hash(12, str, str2);
        for (Entry entry = get(hash); entry != null; entry = entry.next) {
            if (entry.tag == 12 && entry.hashCode == hash && entry.name.equals(str) && entry.value.equals(str2)) {
                return entry.index;
            }
        }
        this.constantPool.put122(12, addConstantUtf8(str), addConstantUtf8(str2));
        int i10 = this.constantPoolCount;
        this.constantPoolCount = i10 + 1;
        return put(new Entry(i10, 12, str, str2, hash)).index;
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantPackage(String str) {
        return addConstantUtf8Reference(20, str);
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantString(String str) {
        return addConstantUtf8Reference(8, str);
    }

    /* access modifiers changed from: package-private */
    public int addConstantUtf8(String str) {
        int hash = hash(1, str);
        for (Entry entry = get(hash); entry != null; entry = entry.next) {
            if (entry.tag == 1 && entry.hashCode == hash && entry.value.equals(str)) {
                return entry.index;
            }
        }
        this.constantPool.putByte(1).putUTF8(str);
        int i10 = this.constantPoolCount;
        this.constantPoolCount = i10 + 1;
        return put(new Entry(i10, 1, str, hash)).index;
    }

    /* access modifiers changed from: package-private */
    public int addMergedType(int i10, int i11) {
        long j10;
        long j11;
        if (i10 < i11) {
            j11 = (long) i10;
            j10 = (long) i11;
        } else {
            j11 = (long) i11;
            j10 = (long) i10;
        }
        long j12 = j11 | (j10 << 32);
        int hash = hash((int) Opcodes.IXOR, i10 + i11);
        for (Entry entry = get(hash); entry != null; entry = entry.next) {
            if (entry.tag == 130 && entry.hashCode == hash && entry.data == j12) {
                return entry.info;
            }
        }
        Entry[] entryArr = this.typeTable;
        int addType = addType(this.classWriter.getCommonSuperClass(entryArr[i10].value, entryArr[i11].value));
        put(new Entry(this.typeCount, (int) Opcodes.IXOR, j12, hash)).info = addType;
        return addType;
    }

    /* access modifiers changed from: package-private */
    public int addType(String str) {
        int hash = hash(128, str);
        for (Entry entry = get(hash); entry != null; entry = entry.next) {
            if (entry.tag == 128 && entry.hashCode == hash && entry.value.equals(str)) {
                return entry.index;
            }
        }
        return addTypeInternal(new Entry(this.typeCount, 128, str, hash));
    }

    /* access modifiers changed from: package-private */
    public int addUninitializedType(String str, int i10) {
        int hash = hash(129, str, i10);
        for (Entry entry = get(hash); entry != null; entry = entry.next) {
            if (entry.tag == 129 && entry.hashCode == hash && entry.data == ((long) i10) && entry.value.equals(str)) {
                return entry.index;
            }
        }
        return addTypeInternal(new Entry(this.typeCount, 129, str, (long) i10, hash));
    }

    /* access modifiers changed from: package-private */
    public int computeBootstrapMethodsSize() {
        if (this.bootstrapMethods == null) {
            return 0;
        }
        addConstantUtf8("BootstrapMethods");
        return this.bootstrapMethods.length + 8;
    }

    /* access modifiers changed from: package-private */
    public String getClassName() {
        return this.className;
    }

    /* access modifiers changed from: package-private */
    public int getConstantPoolCount() {
        return this.constantPoolCount;
    }

    /* access modifiers changed from: package-private */
    public int getConstantPoolLength() {
        return this.constantPool.length;
    }

    /* access modifiers changed from: package-private */
    public int getMajorVersion() {
        return this.majorVersion;
    }

    /* access modifiers changed from: package-private */
    public ClassReader getSource() {
        return this.sourceClassReader;
    }

    /* access modifiers changed from: package-private */
    public Symbol getType(int i10) {
        return this.typeTable[i10];
    }

    /* access modifiers changed from: package-private */
    public void putBootstrapMethods(ByteVector byteVector) {
        if (this.bootstrapMethods != null) {
            ByteVector putShort = byteVector.putShort(addConstantUtf8("BootstrapMethods")).putInt(this.bootstrapMethods.length + 2).putShort(this.bootstrapMethodCount);
            ByteVector byteVector2 = this.bootstrapMethods;
            putShort.putByteArray(byteVector2.data, 0, byteVector2.length);
        }
    }

    /* access modifiers changed from: package-private */
    public void putConstantPool(ByteVector byteVector) {
        ByteVector putShort = byteVector.putShort(this.constantPoolCount);
        ByteVector byteVector2 = this.constantPool;
        putShort.putByteArray(byteVector2.data, 0, byteVector2.length);
    }

    /* access modifiers changed from: package-private */
    public int setMajorVersionAndClassName(int i10, String str) {
        this.majorVersion = i10;
        this.className = str;
        return addConstantClass(str).index;
    }

    private static class Entry extends Symbol {
        final int hashCode;
        Entry next;

        Entry(int i10, int i11, String str, String str2, String str3, long j10, int i12) {
            super(i10, i11, str, str2, str3, j10);
            this.hashCode = i12;
        }

        Entry(int i10, int i11, String str, int i12) {
            super(i10, i11, (String) null, (String) null, str, 0);
            this.hashCode = i12;
        }

        Entry(int i10, int i11, String str, long j10, int i12) {
            super(i10, i11, (String) null, (String) null, str, j10);
            this.hashCode = i12;
        }

        Entry(int i10, int i11, String str, String str2, int i12) {
            super(i10, i11, (String) null, str, str2, 0);
            this.hashCode = i12;
        }

        Entry(int i10, int i11, long j10, int i12) {
            super(i10, i11, (String) null, (String) null, (String) null, j10);
            this.hashCode = i12;
        }
    }

    private static int hash(int i10, String str, int i11) {
        return (i10 + str.hashCode() + i11) & a.e.API_PRIORITY_OTHER;
    }

    private static int hash(int i10, String str, String str2) {
        return (i10 + (str.hashCode() * str2.hashCode())) & a.e.API_PRIORITY_OTHER;
    }

    private static int hash(int i10, String str, String str2, int i11) {
        return (i10 + (str.hashCode() * str2.hashCode() * (i11 + 1))) & a.e.API_PRIORITY_OTHER;
    }

    private static int hash(int i10, String str, String str2, String str3) {
        return (i10 + (str.hashCode() * str2.hashCode() * str3.hashCode())) & a.e.API_PRIORITY_OTHER;
    }

    private static int hash(int i10, String str, String str2, String str3, int i11) {
        return (i10 + (str.hashCode() * str2.hashCode() * str3.hashCode() * i11)) & a.e.API_PRIORITY_OTHER;
    }

    SymbolTable(ClassWriter classWriter2, ClassReader classReader) {
        this.classWriter = classWriter2;
        this.sourceClassReader = classReader;
        byte[] bArr = classReader.classFileBuffer;
        int item = classReader.getItem(1) - 1;
        int i10 = classReader.header - item;
        this.constantPoolCount = classReader.getItemCount();
        ByteVector byteVector = new ByteVector(i10);
        this.constantPool = byteVector;
        byteVector.putByteArray(bArr, item, i10);
        this.entries = new Entry[(this.constantPoolCount * 2)];
        char[] cArr = new char[classReader.getMaxStringLength()];
        boolean z10 = false;
        int i11 = 1;
        while (i11 < this.constantPoolCount) {
            int item2 = classReader.getItem(i11);
            byte b10 = bArr[item2 - 1];
            switch (b10) {
                case 1:
                    addConstantUtf8(i11, classReader.readUtf(i11, cArr));
                    break;
                case 3:
                case 4:
                    addConstantIntegerOrFloat(i11, b10, classReader.readInt(item2));
                    break;
                case 5:
                case 6:
                    addConstantLongOrDouble(i11, b10, classReader.readLong(item2));
                    break;
                case 7:
                case 8:
                case 16:
                case 19:
                case 20:
                    addConstantUtf8Reference(i11, b10, classReader.readUTF8(item2, cArr));
                    break;
                case 9:
                case 10:
                case 11:
                    int item3 = classReader.getItem(classReader.readUnsignedShort(item2 + 2));
                    addConstantMemberReference(i11, b10, classReader.readClass(item2, cArr), classReader.readUTF8(item3, cArr), classReader.readUTF8(item3 + 2, cArr));
                    break;
                case 12:
                    addConstantNameAndType(i11, classReader.readUTF8(item2, cArr), classReader.readUTF8(item2 + 2, cArr));
                    break;
                case 15:
                    int item4 = classReader.getItem(classReader.readUnsignedShort(item2 + 1));
                    int item5 = classReader.getItem(classReader.readUnsignedShort(item4 + 2));
                    addConstantMethodHandle(i11, classReader.readByte(item2), classReader.readClass(item4, cArr), classReader.readUTF8(item5, cArr), classReader.readUTF8(item5 + 2, cArr));
                    break;
                case 17:
                case 18:
                    int item6 = classReader.getItem(classReader.readUnsignedShort(item2 + 2));
                    addConstantDynamicOrInvokeDynamicReference(b10, i11, classReader.readUTF8(item6, cArr), classReader.readUTF8(item6 + 2, cArr), classReader.readUnsignedShort(item2));
                    z10 = true;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            i11 += (b10 == 5 || b10 == 6) ? 2 : 1;
        }
        if (z10) {
            copyBootstrapMethods(classReader, cArr);
        }
    }

    private void addConstantIntegerOrFloat(int i10, int i11, int i12) {
        add(new Entry(i10, i11, (long) i12, hash(i11, i12)));
    }

    private void addConstantUtf8Reference(int i10, int i11, String str) {
        add(new Entry(i10, i11, str, hash(i11, str)));
    }

    private void addConstantDynamicOrInvokeDynamicReference(int i10, int i11, String str, String str2, int i12) {
        int i13 = i11;
        int i14 = i10;
        String str3 = str;
        String str4 = str2;
        add(new Entry(i13, i14, (String) null, str3, str4, (long) i12, hash(i10, str, str2, i12)));
    }

    private void addConstantLongOrDouble(int i10, int i11, long j10) {
        add(new Entry(i10, i11, j10, hash(i11, j10)));
    }

    private void addConstantUtf8(int i10, String str) {
        add(new Entry(i10, 1, str, hash(1, str)));
    }

    private void addConstantNameAndType(int i10, String str, String str2) {
        add(new Entry(i10, 12, str, str2, hash(12, str, str2)));
    }

    private void addConstantMemberReference(int i10, int i11, String str, String str2, String str3) {
        add(new Entry(i10, i11, str, str2, str3, 0, hash(i11, str, str2, str3)));
    }

    private void addConstantMethodHandle(int i10, int i11, String str, String str2, String str3) {
        int i12 = i10;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        add(new Entry(i12, 15, str4, str5, str6, (long) i11, hash(15, str, str2, str3, i11)));
    }

    private Symbol addBootstrapMethod(int i10, int i11, int i12) {
        byte[] bArr = this.bootstrapMethods.data;
        for (Entry entry = get(i12); entry != null; entry = entry.next) {
            if (entry.tag == 64 && entry.hashCode == i12) {
                int i13 = (int) entry.data;
                boolean z10 = false;
                int i14 = 0;
                while (true) {
                    if (i14 >= i11) {
                        z10 = true;
                        break;
                    } else if (bArr[i10 + i14] != bArr[i13 + i14]) {
                        break;
                    } else {
                        i14++;
                    }
                }
                if (z10) {
                    this.bootstrapMethods.length = i10;
                    return entry;
                }
            }
        }
        int i15 = this.bootstrapMethodCount;
        this.bootstrapMethodCount = i15 + 1;
        return put(new Entry(i15, 64, (long) i10, i12));
    }
}
