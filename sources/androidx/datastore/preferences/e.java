package androidx.datastore.preferences;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.l0;
import androidx.datastore.preferences.protobuf.s0;
import androidx.datastore.preferences.protobuf.w;
import java.util.List;

public final class e extends GeneratedMessageLite<e, a> implements l0 {
    /* access modifiers changed from: private */
    public static final e DEFAULT_INSTANCE;
    private static volatile s0<e> PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private w.i<String> strings_ = GeneratedMessageLite.p();

    public static final class a extends GeneratedMessageLite.a<e, a> implements l0 {
        /* synthetic */ a(c cVar) {
            this();
        }

        public a s(Iterable<String> iterable) {
            l();
            ((e) this.f5131b).E(iterable);
            return this;
        }

        private a() {
            super(e.DEFAULT_INSTANCE);
        }
    }

    static {
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        GeneratedMessageLite.A(e.class, eVar);
    }

    private e() {
    }

    /* access modifiers changed from: private */
    public void E(Iterable<String> iterable) {
        F();
        androidx.datastore.preferences.protobuf.a.b(iterable, this.strings_);
    }

    private void F() {
        if (!this.strings_.h()) {
            this.strings_ = GeneratedMessageLite.v(this.strings_);
        }
    }

    public static e G() {
        return DEFAULT_INSTANCE;
    }

    public static a I() {
        return (a) DEFAULT_INSTANCE.k();
    }

    public List<String> H() {
        return this.strings_;
    }

    /* access modifiers changed from: protected */
    public final Object o(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (c.f5051a[methodToInvoke.ordinal()]) {
            case 1:
                return new e();
            case 2:
                return new a((c) null);
            case 3:
                return GeneratedMessageLite.x(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                s0<e> s0Var = PARSER;
                if (s0Var == null) {
                    synchronized (e.class) {
                        s0Var = PARSER;
                        if (s0Var == null) {
                            s0Var = new GeneratedMessageLite.b<>(DEFAULT_INSTANCE);
                            PARSER = s0Var;
                        }
                    }
                }
                return s0Var;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
