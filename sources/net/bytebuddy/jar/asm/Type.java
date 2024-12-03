package net.bytebuddy.jar.asm;

import com.leanplum.internal.Constants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import net.bytebuddy.pool.TypePool;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.validator.Field;
import org.apache.commons.validator.Var;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

public final class Type {
    public static final int ARRAY = 9;
    public static final int BOOLEAN = 1;
    public static final Type BOOLEAN_TYPE = new Type(1, PRIMITIVE_DESCRIPTORS, 1, 2);
    public static final int BYTE = 3;
    public static final Type BYTE_TYPE = new Type(3, PRIMITIVE_DESCRIPTORS, 3, 4);
    public static final int CHAR = 2;
    public static final Type CHAR_TYPE = new Type(2, PRIMITIVE_DESCRIPTORS, 2, 3);
    public static final int DOUBLE = 8;
    public static final Type DOUBLE_TYPE = new Type(8, PRIMITIVE_DESCRIPTORS, 8, 9);
    public static final int FLOAT = 6;
    public static final Type FLOAT_TYPE = new Type(6, PRIMITIVE_DESCRIPTORS, 6, 7);
    public static final int INT = 5;
    private static final int INTERNAL = 12;
    public static final Type INT_TYPE = new Type(5, PRIMITIVE_DESCRIPTORS, 5, 6);
    public static final int LONG = 7;
    public static final Type LONG_TYPE = new Type(7, PRIMITIVE_DESCRIPTORS, 7, 8);
    public static final int METHOD = 11;
    public static final int OBJECT = 10;
    private static final String PRIMITIVE_DESCRIPTORS = "VZCBSIFJD";
    public static final int SHORT = 4;
    public static final Type SHORT_TYPE = new Type(4, PRIMITIVE_DESCRIPTORS, 4, 5);
    public static final int VOID = 0;
    public static final Type VOID_TYPE = new Type(0, PRIMITIVE_DESCRIPTORS, 0, 1);
    private final int sort;
    private final int valueBegin;
    private final String valueBuffer;
    private final int valueEnd;

    private Type(int i10, String str, int i11, int i12) {
        this.sort = i10;
        this.valueBuffer = str;
        this.valueBegin = i11;
        this.valueEnd = i12;
    }

    private void appendDescriptor(StringBuilder sb2) {
        int i10 = this.sort;
        if (i10 == 10) {
            sb2.append(this.valueBuffer, this.valueBegin - 1, this.valueEnd + 1);
        } else if (i10 == 12) {
            sb2.append(Matrix.MATRIX_TYPE_RANDOM_LT);
            sb2.append(this.valueBuffer, this.valueBegin, this.valueEnd);
            sb2.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
        } else {
            sb2.append(this.valueBuffer, this.valueBegin, this.valueEnd);
        }
    }

    public static String getConstructorDescriptor(Constructor<?> constructor) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(PropertyUtils.MAPPED_DELIM);
        for (Class appendDescriptor : constructor.getParameterTypes()) {
            appendDescriptor(appendDescriptor, sb2);
        }
        sb2.append(")V");
        return sb2.toString();
    }

    public static String getMethodDescriptor(Type type, Type... typeArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(PropertyUtils.MAPPED_DELIM);
        for (Type appendDescriptor : typeArr) {
            appendDescriptor.appendDescriptor(sb2);
        }
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        type.appendDescriptor(sb2);
        return sb2.toString();
    }

    public static Type getMethodType(String str) {
        return new Type(11, str, 0, str.length());
    }

    public static Type getObjectType(String str) {
        int i10;
        if (str.charAt(0) == '[') {
            i10 = 9;
        } else {
            i10 = 12;
        }
        return new Type(i10, str, 0, str.length());
    }

    static int getReturnTypeOffset(String str) {
        int i10 = 1;
        while (str.charAt(i10) != ')') {
            while (str.charAt(i10) == '[') {
                i10++;
            }
            int i11 = i10 + 1;
            if (str.charAt(i10) == 'L') {
                i10 = Math.max(i11, str.indexOf(59, i11) + 1);
            } else {
                i10 = i11;
            }
        }
        return i10 + 1;
    }

    public static Type getType(String str) {
        return getTypeInternal(str, 0, str.length());
    }

    private static Type getTypeInternal(String str, int i10, int i11) {
        char charAt = str.charAt(i10);
        if (charAt == '(') {
            return new Type(11, str, i10, i11);
        }
        if (charAt == 'F') {
            return FLOAT_TYPE;
        }
        if (charAt == 'L') {
            return new Type(10, str, i10 + 1, i11 - 1);
        }
        if (charAt == 'S') {
            return SHORT_TYPE;
        }
        if (charAt == 'V') {
            return VOID_TYPE;
        }
        if (charAt == 'I') {
            return INT_TYPE;
        }
        if (charAt == 'J') {
            return LONG_TYPE;
        }
        if (charAt == 'Z') {
            return BOOLEAN_TYPE;
        }
        if (charAt == '[') {
            return new Type(9, str, i10, i11);
        }
        switch (charAt) {
            case 'B':
                return BYTE_TYPE;
            case 'C':
                return CHAR_TYPE;
            case 'D':
                return DOUBLE_TYPE;
            default:
                throw new IllegalArgumentException("Invalid descriptor: " + str);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Type)) {
            return false;
        }
        Type type = (Type) obj;
        int i10 = this.sort;
        int i11 = 10;
        if (i10 == 12) {
            i10 = 10;
        }
        int i12 = type.sort;
        if (i12 != 12) {
            i11 = i12;
        }
        if (i10 != i11) {
            return false;
        }
        int i13 = this.valueBegin;
        int i14 = this.valueEnd;
        int i15 = type.valueBegin;
        if (i14 - i13 != type.valueEnd - i15) {
            return false;
        }
        while (i13 < i14) {
            if (this.valueBuffer.charAt(i13) != type.valueBuffer.charAt(i15)) {
                return false;
            }
            i13++;
            i15++;
        }
        return true;
    }

    public Type[] getArgumentTypes() {
        return getArgumentTypes(getDescriptor());
    }

    public int getArgumentsAndReturnSizes() {
        return getArgumentsAndReturnSizes(getDescriptor());
    }

    public String getClassName() {
        switch (this.sort) {
            case 0:
                return "void";
            case 1:
                return "boolean";
            case 2:
                return "char";
            case 3:
                return "byte";
            case 4:
                return "short";
            case 5:
                return Var.JSTYPE_INT;
            case 6:
                return Constants.Kinds.FLOAT;
            case 7:
                return "long";
            case 8:
                return "double";
            case 9:
                StringBuilder sb2 = new StringBuilder(getElementType().getClassName());
                for (int dimensions = getDimensions(); dimensions > 0; dimensions--) {
                    sb2.append(Field.TOKEN_INDEXED);
                }
                return sb2.toString();
            case 10:
            case 12:
                return this.valueBuffer.substring(this.valueBegin, this.valueEnd).replace('/', '.');
            default:
                throw new AssertionError();
        }
    }

    public String getDescriptor() {
        int i10 = this.sort;
        if (i10 == 10) {
            return this.valueBuffer.substring(this.valueBegin - 1, this.valueEnd + 1);
        }
        if (i10 != 12) {
            return this.valueBuffer.substring(this.valueBegin, this.valueEnd);
        }
        return Matrix.MATRIX_TYPE_RANDOM_LT + this.valueBuffer.substring(this.valueBegin, this.valueEnd) + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER;
    }

    public int getDimensions() {
        int i10 = 1;
        while (this.valueBuffer.charAt(this.valueBegin + i10) == '[') {
            i10++;
        }
        return i10;
    }

    public Type getElementType() {
        return getTypeInternal(this.valueBuffer, this.valueBegin + getDimensions(), this.valueEnd);
    }

    public String getInternalName() {
        return this.valueBuffer.substring(this.valueBegin, this.valueEnd);
    }

    public int getOpcode(int i10) {
        if (i10 == 46 || i10 == 79) {
            switch (this.sort) {
                case 0:
                case 11:
                    throw new UnsupportedOperationException();
                case 1:
                case 3:
                    return i10 + 5;
                case 2:
                    return i10 + 6;
                case 4:
                    return i10 + 7;
                case 5:
                    return i10;
                case 6:
                    return i10 + 2;
                case 7:
                    return i10 + 1;
                case 8:
                    return i10 + 3;
                case 9:
                case 10:
                case 12:
                    return i10 + 4;
                default:
                    throw new AssertionError();
            }
        } else {
            switch (this.sort) {
                case 0:
                    if (i10 == 172) {
                        return Opcodes.RETURN;
                    }
                    throw new UnsupportedOperationException();
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    return i10;
                case 6:
                    return i10 + 2;
                case 7:
                    return i10 + 1;
                case 8:
                    return i10 + 3;
                case 9:
                case 10:
                case 12:
                    if (i10 == 21 || i10 == 54 || i10 == 172) {
                        return i10 + 4;
                    }
                    throw new UnsupportedOperationException();
                case 11:
                    throw new UnsupportedOperationException();
                default:
                    throw new AssertionError();
            }
        }
    }

    public Type getReturnType() {
        return getReturnType(getDescriptor());
    }

    public int getSize() {
        switch (this.sort) {
            case 0:
                return 0;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 10:
            case 12:
                return 1;
            case 7:
            case 8:
                return 2;
            default:
                throw new AssertionError();
        }
    }

    public int getSort() {
        int i10 = this.sort;
        if (i10 == 12) {
            return 10;
        }
        return i10;
    }

    public int hashCode() {
        int i10;
        int i11 = this.sort;
        if (i11 == 12) {
            i10 = 10;
        } else {
            i10 = i11;
        }
        int i12 = i10 * 13;
        if (i11 >= 9) {
            int i13 = this.valueEnd;
            for (int i14 = this.valueBegin; i14 < i13; i14++) {
                i12 = (i12 + this.valueBuffer.charAt(i14)) * 17;
            }
        }
        return i12;
    }

    public String toString() {
        return getDescriptor();
    }

    public static Type[] getArgumentTypes(String str) {
        int i10 = 0;
        int i11 = 0;
        int i12 = 1;
        while (str.charAt(i12) != ')') {
            while (str.charAt(i12) == '[') {
                i12++;
            }
            int i13 = i12 + 1;
            i12 = str.charAt(i12) == 'L' ? Math.max(i13, str.indexOf(59, i13) + 1) : i13;
            i11++;
        }
        Type[] typeArr = new Type[i11];
        int i14 = 1;
        while (str.charAt(i14) != ')') {
            int i15 = i14;
            while (str.charAt(i15) == '[') {
                i15++;
            }
            int i16 = i15 + 1;
            if (str.charAt(i15) == 'L') {
                i16 = Math.max(i16, str.indexOf(59, i16) + 1);
            }
            typeArr[i10] = getTypeInternal(str, i14, i16);
            i10++;
            i14 = i16;
        }
        return typeArr;
    }

    public static int getArgumentsAndReturnSizes(String str) {
        int i10 = 1;
        char charAt = str.charAt(1);
        int i11 = 1;
        int i12 = 1;
        while (charAt != ')') {
            if (charAt == 'J' || charAt == 'D') {
                i11++;
                i12 += 2;
            } else {
                while (str.charAt(i11) == '[') {
                    i11++;
                }
                int i13 = i11 + 1;
                if (str.charAt(i11) == 'L') {
                    i13 = Math.max(i13, str.indexOf(59, i13) + 1);
                }
                i12++;
                i11 = i13;
            }
            charAt = str.charAt(i11);
        }
        char charAt2 = str.charAt(i11 + 1);
        if (charAt2 == 'V') {
            return i12 << 2;
        }
        if (charAt2 == 'J' || charAt2 == 'D') {
            i10 = 2;
        }
        return (i12 << 2) | i10;
    }

    public static String getInternalName(Class<?> cls) {
        return cls.getName().replace('.', '/');
    }

    public static Type getMethodType(Type type, Type... typeArr) {
        return getType(getMethodDescriptor(type, typeArr));
    }

    public static Type getReturnType(String str) {
        return getTypeInternal(str, getReturnTypeOffset(str), str.length());
    }

    public static Type getType(Class<?> cls) {
        if (!cls.isPrimitive()) {
            return getType(getDescriptor(cls));
        }
        if (cls == Integer.TYPE) {
            return INT_TYPE;
        }
        if (cls == Void.TYPE) {
            return VOID_TYPE;
        }
        if (cls == Boolean.TYPE) {
            return BOOLEAN_TYPE;
        }
        if (cls == Byte.TYPE) {
            return BYTE_TYPE;
        }
        if (cls == Character.TYPE) {
            return CHAR_TYPE;
        }
        if (cls == Short.TYPE) {
            return SHORT_TYPE;
        }
        if (cls == Double.TYPE) {
            return DOUBLE_TYPE;
        }
        if (cls == Float.TYPE) {
            return FLOAT_TYPE;
        }
        if (cls == Long.TYPE) {
            return LONG_TYPE;
        }
        throw new AssertionError();
    }

    public static Type getReturnType(Method method) {
        return getType(method.getReturnType());
    }

    private static void appendDescriptor(Class<?> cls, StringBuilder sb2) {
        char c10;
        while (cls.isArray()) {
            sb2.append('[');
            cls = cls.getComponentType();
        }
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                c10 = 'I';
            } else if (cls == Void.TYPE) {
                c10 = 'V';
            } else if (cls == Boolean.TYPE) {
                c10 = Matrix.MATRIX_TYPE_ZERO;
            } else if (cls == Byte.TYPE) {
                c10 = 'B';
            } else if (cls == Character.TYPE) {
                c10 = 'C';
            } else if (cls == Short.TYPE) {
                c10 = 'S';
            } else if (cls == Double.TYPE) {
                c10 = 'D';
            } else if (cls == Float.TYPE) {
                c10 = 'F';
            } else if (cls == Long.TYPE) {
                c10 = 'J';
            } else {
                throw new AssertionError();
            }
            sb2.append(c10);
            return;
        }
        sb2.append(Matrix.MATRIX_TYPE_RANDOM_LT);
        sb2.append(getInternalName(cls));
        sb2.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
    }

    public static String getDescriptor(Class<?> cls) {
        StringBuilder sb2 = new StringBuilder();
        appendDescriptor(cls, sb2);
        return sb2.toString();
    }

    public static String getMethodDescriptor(Method method) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(PropertyUtils.MAPPED_DELIM);
        for (Class appendDescriptor : method.getParameterTypes()) {
            appendDescriptor(appendDescriptor, sb2);
        }
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        appendDescriptor(method.getReturnType(), sb2);
        return sb2.toString();
    }

    public static Type[] getArgumentTypes(Method method) {
        Class[] parameterTypes = method.getParameterTypes();
        Type[] typeArr = new Type[parameterTypes.length];
        for (int length = parameterTypes.length - 1; length >= 0; length--) {
            typeArr[length] = getType((Class<?>) parameterTypes[length]);
        }
        return typeArr;
    }

    public static Type getType(Constructor<?> constructor) {
        return getType(getConstructorDescriptor(constructor));
    }

    public static Type getType(Method method) {
        return getType(getMethodDescriptor(method));
    }
}
