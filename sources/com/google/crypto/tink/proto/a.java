package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.m0;
import com.google.crypto.tink.shaded.protobuf.o;
import com.google.crypto.tink.shaded.protobuf.t0;
import com.google.crypto.tink.shaded.protobuf.x;
import java.util.Collections;
import java.util.List;

public final class a extends GeneratedMessageLite<a, b> implements m0 {
    /* access modifiers changed from: private */
    public static final a DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile t0<a> PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private x.i<c> key_ = GeneratedMessageLite.m();
    private int primaryKeyId_;

    /* renamed from: com.google.crypto.tink.proto.a$a  reason: collision with other inner class name */
    static /* synthetic */ class C0242a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f20614a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20614a = r0
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20614a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20614a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20614a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20614a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20614a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20614a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.a.C0242a.<clinit>():void");
        }
    }

    public static final class b extends GeneratedMessageLite.a<a, b> implements m0 {
        /* synthetic */ b(C0242a aVar) {
            this();
        }

        public b r(c cVar) {
            j();
            ((a) this.f20677b).F(cVar);
            return this;
        }

        public c s(int i10) {
            return ((a) this.f20677b).H(i10);
        }

        public int t() {
            return ((a) this.f20677b).I();
        }

        public List<c> u() {
            return Collections.unmodifiableList(((a) this.f20677b).J());
        }

        public b v(int i10) {
            j();
            ((a) this.f20677b).N(i10);
            return this;
        }

        private b() {
            super(a.DEFAULT_INSTANCE);
        }
    }

    public static final class c extends GeneratedMessageLite<c, C0243a> implements m0 {
        /* access modifiers changed from: private */
        public static final c DEFAULT_INSTANCE;
        public static final int KEY_DATA_FIELD_NUMBER = 1;
        public static final int KEY_ID_FIELD_NUMBER = 3;
        public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
        private static volatile t0<c> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 2;
        private KeyData keyData_;
        private int keyId_;
        private int outputPrefixType_;
        private int status_;

        /* renamed from: com.google.crypto.tink.proto.a$c$a  reason: collision with other inner class name */
        public static final class C0243a extends GeneratedMessageLite.a<c, C0243a> implements m0 {
            /* synthetic */ C0243a(C0242a aVar) {
                this();
            }

            public C0243a r(KeyData keyData) {
                j();
                ((c) this.f20677b).N(keyData);
                return this;
            }

            public C0243a s(int i10) {
                j();
                ((c) this.f20677b).O(i10);
                return this;
            }

            public C0243a t(OutputPrefixType outputPrefixType) {
                j();
                ((c) this.f20677b).P(outputPrefixType);
                return this;
            }

            public C0243a u(KeyStatusType keyStatusType) {
                j();
                ((c) this.f20677b).Q(keyStatusType);
                return this;
            }

            private C0243a() {
                super(c.DEFAULT_INSTANCE);
            }
        }

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            GeneratedMessageLite.A(c.class, cVar);
        }

        private c() {
        }

        public static C0243a M() {
            return (C0243a) DEFAULT_INSTANCE.i();
        }

        /* access modifiers changed from: private */
        public void N(KeyData keyData) {
            keyData.getClass();
            this.keyData_ = keyData;
        }

        /* access modifiers changed from: private */
        public void O(int i10) {
            this.keyId_ = i10;
        }

        /* access modifiers changed from: private */
        public void P(OutputPrefixType outputPrefixType) {
            this.outputPrefixType_ = outputPrefixType.getNumber();
        }

        /* access modifiers changed from: private */
        public void Q(KeyStatusType keyStatusType) {
            this.status_ = keyStatusType.getNumber();
        }

        public KeyData H() {
            KeyData keyData = this.keyData_;
            return keyData == null ? KeyData.G() : keyData;
        }

        public int I() {
            return this.keyId_;
        }

        public OutputPrefixType J() {
            OutputPrefixType a10 = OutputPrefixType.a(this.outputPrefixType_);
            if (a10 == null) {
                return OutputPrefixType.UNRECOGNIZED;
            }
            return a10;
        }

        public KeyStatusType K() {
            KeyStatusType a10 = KeyStatusType.a(this.status_);
            if (a10 == null) {
                return KeyStatusType.UNRECOGNIZED;
            }
            return a10;
        }

        public boolean L() {
            return this.keyData_ != null;
        }

        /* access modifiers changed from: protected */
        public final Object l(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (C0242a.f20614a[methodToInvoke.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new C0243a((C0242a) null);
                case 3:
                    return GeneratedMessageLite.u(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"keyData_", "status_", "keyId_", "outputPrefixType_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    t0<c> t0Var = PARSER;
                    if (t0Var == null) {
                        synchronized (c.class) {
                            t0Var = PARSER;
                            if (t0Var == null) {
                                t0Var = new GeneratedMessageLite.b<>(DEFAULT_INSTANCE);
                                PARSER = t0Var;
                            }
                        }
                    }
                    return t0Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        GeneratedMessageLite.A(a.class, aVar);
    }

    private a() {
    }

    /* access modifiers changed from: private */
    public void F(c cVar) {
        cVar.getClass();
        G();
        this.key_.add(cVar);
    }

    private void G() {
        if (!this.key_.h()) {
            this.key_ = GeneratedMessageLite.s(this.key_);
        }
    }

    public static b L() {
        return (b) DEFAULT_INSTANCE.i();
    }

    public static a M(byte[] bArr, o oVar) throws InvalidProtocolBufferException {
        return (a) GeneratedMessageLite.w(DEFAULT_INSTANCE, bArr, oVar);
    }

    /* access modifiers changed from: private */
    public void N(int i10) {
        this.primaryKeyId_ = i10;
    }

    public c H(int i10) {
        return this.key_.get(i10);
    }

    public int I() {
        return this.key_.size();
    }

    public List<c> J() {
        return this.key_;
    }

    public int K() {
        return this.primaryKeyId_;
    }

    /* access modifiers changed from: protected */
    public final Object l(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (C0242a.f20614a[methodToInvoke.ordinal()]) {
            case 1:
                return new a();
            case 2:
                return new b((C0242a) null);
            case 3:
                return GeneratedMessageLite.u(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "key_", c.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                t0<a> t0Var = PARSER;
                if (t0Var == null) {
                    synchronized (a.class) {
                        t0Var = PARSER;
                        if (t0Var == null) {
                            t0Var = new GeneratedMessageLite.b<>(DEFAULT_INSTANCE);
                            PARSER = t0Var;
                        }
                    }
                }
                return t0Var;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
