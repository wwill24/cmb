package org.apache.commons.beanutils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.List;
import java.util.Map;

public class DynaProperty implements Serializable {
    private static final int BOOLEAN_TYPE = 1;
    private static final int BYTE_TYPE = 2;
    private static final int CHAR_TYPE = 3;
    private static final int DOUBLE_TYPE = 4;
    private static final int FLOAT_TYPE = 5;
    private static final int INT_TYPE = 6;
    private static final int LONG_TYPE = 7;
    private static final int SHORT_TYPE = 8;
    protected transient Class<?> contentType;
    protected String name;
    protected transient Class<?> type;

    public DynaProperty(String str) {
        this(str, Object.class);
    }

    private Class<?> readAnyClass(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        if (!objectInputStream.readBoolean()) {
            return (Class) objectInputStream.readObject();
        }
        switch (objectInputStream.readInt()) {
            case 1:
                return Boolean.TYPE;
            case 2:
                return Byte.TYPE;
            case 3:
                return Character.TYPE;
            case 4:
                return Double.TYPE;
            case 5:
                return Float.TYPE;
            case 6:
                return Integer.TYPE;
            case 7:
                return Long.TYPE;
            case 8:
                return Short.TYPE;
            default:
                throw new StreamCorruptedException("Invalid primitive type. Check version of beanutils used to serialize is compatible.");
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.type = readAnyClass(objectInputStream);
        if (isMapped() || isIndexed()) {
            this.contentType = readAnyClass(objectInputStream);
        }
        objectInputStream.defaultReadObject();
    }

    private void writeAnyClass(Class<?> cls, ObjectOutputStream objectOutputStream) throws IOException {
        int i10;
        if (Boolean.TYPE.equals(cls)) {
            i10 = 1;
        } else if (Byte.TYPE.equals(cls)) {
            i10 = 2;
        } else if (Character.TYPE.equals(cls)) {
            i10 = 3;
        } else if (Double.TYPE.equals(cls)) {
            i10 = 4;
        } else if (Float.TYPE.equals(cls)) {
            i10 = 5;
        } else if (Integer.TYPE.equals(cls)) {
            i10 = 6;
        } else if (Long.TYPE.equals(cls)) {
            i10 = 7;
        } else if (Short.TYPE.equals(cls)) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        if (i10 == 0) {
            objectOutputStream.writeBoolean(false);
            objectOutputStream.writeObject(cls);
            return;
        }
        objectOutputStream.writeBoolean(true);
        objectOutputStream.writeInt(i10);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        writeAnyClass(this.type, objectOutputStream);
        if (isMapped() || isIndexed()) {
            writeAnyClass(this.contentType, objectOutputStream);
        }
        objectOutputStream.defaultWriteObject();
    }

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11 = true;
        if (obj == this) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 || !(obj instanceof DynaProperty)) {
            return z10;
        }
        DynaProperty dynaProperty = (DynaProperty) obj;
        String str = this.name;
        if (str != null ? str.equals(dynaProperty.name) : dynaProperty.name == null) {
            Class<?> cls = this.type;
            if (cls != null ? cls.equals(dynaProperty.type) : dynaProperty.type == null) {
                Class<?> cls2 = this.contentType;
                Class<?> cls3 = dynaProperty.contentType;
                if (cls2 != null) {
                }
            }
        }
        z11 = false;
        return z11;
    }

    public Class<?> getContentType() {
        return this.contentType;
    }

    public String getName() {
        return this.name;
    }

    public Class<?> getType() {
        return this.type;
    }

    public int hashCode() {
        int i10;
        int i11;
        String str = this.name;
        int i12 = 0;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        int i13 = (i10 + 31) * 31;
        Class<?> cls = this.type;
        if (cls == null) {
            i11 = 0;
        } else {
            i11 = cls.hashCode();
        }
        int i14 = (i13 + i11) * 31;
        Class<?> cls2 = this.contentType;
        if (cls2 != null) {
            i12 = cls2.hashCode();
        }
        return i14 + i12;
    }

    public boolean isIndexed() {
        Class<?> cls = this.type;
        if (cls == null) {
            return false;
        }
        if (!cls.isArray() && !List.class.isAssignableFrom(this.type)) {
            return false;
        }
        return true;
    }

    public boolean isMapped() {
        Class<?> cls = this.type;
        if (cls == null) {
            return false;
        }
        return Map.class.isAssignableFrom(cls);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("DynaProperty[name=");
        sb2.append(this.name);
        sb2.append(",type=");
        sb2.append(this.type);
        if (isMapped() || isIndexed()) {
            sb2.append(" <");
            sb2.append(this.contentType);
            sb2.append(">");
        }
        sb2.append("]");
        return sb2.toString();
    }

    public DynaProperty(String str, Class<?> cls) {
        this.name = str;
        this.type = cls;
        if (cls != null && cls.isArray()) {
            this.contentType = cls.getComponentType();
        }
    }

    public DynaProperty(String str, Class<?> cls, Class<?> cls2) {
        this.name = str;
        this.type = cls;
        this.contentType = cls2;
    }
}
