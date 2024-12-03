package com.google.protobuf;

public final class WireFormat {

    /* renamed from: a  reason: collision with root package name */
    static final int f21702a = c(1, 3);

    /* renamed from: b  reason: collision with root package name */
    static final int f21703b = c(1, 4);

    /* renamed from: c  reason: collision with root package name */
    static final int f21704c = c(2, 0);

    /* renamed from: d  reason: collision with root package name */
    static final int f21705d = c(3, 2);

    public enum FieldType {
        DOUBLE(JavaType.DOUBLE, 1),
        FLOAT(JavaType.FLOAT, 5),
        INT64(r1, 0),
        UINT64(r1, 0),
        INT32(r2, 0),
        FIXED64(r1, 1),
        FIXED32(r2, 5),
        BOOL(JavaType.BOOLEAN, 0),
        STRING(JavaType.STRING, 2) {
        },
        GROUP(r8, 3) {
        },
        MESSAGE(r8, 2) {
        },
        BYTES(JavaType.BYTE_STRING, 2) {
        },
        UINT32(r2, 0),
        ENUM(JavaType.ENUM, 0),
        SFIXED32(r2, 5),
        SFIXED64(r1, 1),
        SINT32(r2, 0),
        SINT64(r1, 0);
        
        private final JavaType javaType;
        private final int wireType;

        public JavaType b() {
            return this.javaType;
        }

        public int c() {
            return this.wireType;
        }

        private FieldType(JavaType javaType2, int i10) {
            this.javaType = javaType2;
            this.wireType = i10;
        }
    }

    public enum JavaType {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(ByteString.f21603a),
        ENUM((String) null),
        MESSAGE((String) null);
        
        private final Object defaultDefault;

        private JavaType(Object obj) {
            this.defaultDefault = obj;
        }
    }

    public static int a(int i10) {
        return i10 >>> 3;
    }

    public static int b(int i10) {
        return i10 & 7;
    }

    static int c(int i10, int i11) {
        return (i10 << 3) | i11;
    }
}
