package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Type;

public enum FieldType {
    DOUBLE(0, r4, r8),
    FLOAT(1, r4, r10),
    INT64(2, r4, r5),
    UINT64(3, r4, r5),
    INT32(4, r4, r15),
    FIXED64(5, r4, r12),
    FIXED32(6, r4, r15),
    BOOL(7, r4, r19),
    STRING(8, r4, r21),
    MESSAGE(9, r4, r23),
    BYTES(10, r4, r25),
    UINT32(11, r4, r15),
    ENUM(12, r4, r28),
    SFIXED32(13, r4, r15),
    SFIXED64(14, r4, r12),
    SINT32(15, r4, r15),
    SINT64(16, r4, r12),
    GROUP(17, r4, r23),
    DOUBLE_LIST(18, r4, r8),
    FLOAT_LIST(19, r4, r10),
    INT64_LIST(20, r4, r5),
    UINT64_LIST(21, r4, r5),
    INT32_LIST(22, r4, r15),
    FIXED64_LIST(23, r4, r12),
    FIXED32_LIST(24, r4, r15),
    BOOL_LIST(25, r4, r19),
    STRING_LIST(26, r4, r21),
    MESSAGE_LIST(27, r4, r23),
    BYTES_LIST(28, r4, r25),
    UINT32_LIST(29, r4, r15),
    ENUM_LIST(30, r4, r28),
    SFIXED32_LIST(31, r4, r15),
    SFIXED64_LIST(32, r4, r12),
    SINT32_LIST(33, r4, r15),
    SINT64_LIST(34, r4, r12),
    DOUBLE_LIST_PACKED(35, r4, r8),
    FLOAT_LIST_PACKED(36, r4, r10),
    INT64_LIST_PACKED(37, r4, r5),
    UINT64_LIST_PACKED(38, r4, r5),
    INT32_LIST_PACKED(39, r4, r15),
    FIXED64_LIST_PACKED(40, r4, r12),
    FIXED32_LIST_PACKED(41, r4, r15),
    BOOL_LIST_PACKED(42, r4, r19),
    UINT32_LIST_PACKED(43, r4, r15),
    ENUM_LIST_PACKED(44, r4, r28),
    SFIXED32_LIST_PACKED(45, r4, r15),
    SFIXED64_LIST_PACKED(46, r4, r12),
    SINT32_LIST_PACKED(47, r4, r15),
    SINT64_LIST_PACKED(48, r4, r12),
    GROUP_LIST(49, r34, r23),
    MAP(50, Collection.MAP, JavaType.VOID);
    

    /* renamed from: g0  reason: collision with root package name */
    private static final FieldType[] f5098g0 = null;

    /* renamed from: h0  reason: collision with root package name */
    private static final Type[] f5100h0 = null;
    private final Collection collection;
    private final Class<?> elementType;

    /* renamed from: id  reason: collision with root package name */
    private final int f5114id;
    private final JavaType javaType;
    private final boolean primitiveScalar;

    enum Collection {
        SCALAR(false),
        VECTOR(true),
        PACKED_VECTOR(true),
        MAP(false);
        
        private final boolean isList;

        private Collection(boolean z10) {
            this.isList = z10;
        }
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5120a = null;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f5121b = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            /*
                androidx.datastore.preferences.protobuf.JavaType[] r0 = androidx.datastore.preferences.protobuf.JavaType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5121b = r0
                r1 = 1
                androidx.datastore.preferences.protobuf.JavaType r2 = androidx.datastore.preferences.protobuf.JavaType.BYTE_STRING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f5121b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.JavaType r3 = androidx.datastore.preferences.protobuf.JavaType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f5121b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.JavaType r4 = androidx.datastore.preferences.protobuf.JavaType.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                androidx.datastore.preferences.protobuf.FieldType$Collection[] r3 = androidx.datastore.preferences.protobuf.FieldType.Collection.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f5120a = r3
                androidx.datastore.preferences.protobuf.FieldType$Collection r4 = androidx.datastore.preferences.protobuf.FieldType.Collection.MAP     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f5120a     // Catch:{ NoSuchFieldError -> 0x0043 }
                androidx.datastore.preferences.protobuf.FieldType$Collection r3 = androidx.datastore.preferences.protobuf.FieldType.Collection.VECTOR     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f5120a     // Catch:{ NoSuchFieldError -> 0x004d }
                androidx.datastore.preferences.protobuf.FieldType$Collection r1 = androidx.datastore.preferences.protobuf.FieldType.Collection.SCALAR     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.FieldType.a.<clinit>():void");
        }
    }

    static {
        int i10;
        f5100h0 = new Type[0];
        FieldType[] values = values();
        f5098g0 = new FieldType[values.length];
        for (FieldType fieldType : values) {
            f5098g0[fieldType.f5114id] = fieldType;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
        r5 = androidx.datastore.preferences.protobuf.FieldType.a.f5121b[r6.ordinal()];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private FieldType(int r4, androidx.datastore.preferences.protobuf.FieldType.Collection r5, androidx.datastore.preferences.protobuf.JavaType r6) {
        /*
            r1 = this;
            r1.<init>(r2, r3)
            r1.f5114id = r4
            r1.collection = r5
            r1.javaType = r6
            int[] r2 = androidx.datastore.preferences.protobuf.FieldType.a.f5120a
            int r3 = r5.ordinal()
            r2 = r2[r3]
            r3 = 2
            r4 = 1
            if (r2 == r4) goto L_0x0022
            if (r2 == r3) goto L_0x001b
            r2 = 0
            r1.elementType = r2
            goto L_0x0028
        L_0x001b:
            java.lang.Class r2 = r6.a()
            r1.elementType = r2
            goto L_0x0028
        L_0x0022:
            java.lang.Class r2 = r6.a()
            r1.elementType = r2
        L_0x0028:
            r2 = 0
            androidx.datastore.preferences.protobuf.FieldType$Collection r0 = androidx.datastore.preferences.protobuf.FieldType.Collection.SCALAR
            if (r5 != r0) goto L_0x003d
            int[] r5 = androidx.datastore.preferences.protobuf.FieldType.a.f5121b
            int r6 = r6.ordinal()
            r5 = r5[r6]
            if (r5 == r4) goto L_0x003d
            if (r5 == r3) goto L_0x003d
            r3 = 3
            if (r5 == r3) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r4 = r2
        L_0x003e:
            r1.primitiveScalar = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.FieldType.<init>(java.lang.String, int, int, androidx.datastore.preferences.protobuf.FieldType$Collection, androidx.datastore.preferences.protobuf.JavaType):void");
    }

    public int a() {
        return this.f5114id;
    }
}
