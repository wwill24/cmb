package androidx.datastore.preferences;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.MapFieldLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.e0;
import androidx.datastore.preferences.protobuf.l0;
import androidx.datastore.preferences.protobuf.s0;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

public final class d extends GeneratedMessageLite<d, a> implements l0 {
    /* access modifiers changed from: private */
    public static final d DEFAULT_INSTANCE;
    private static volatile s0<d> PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private MapFieldLite<String, PreferencesProto$Value> preferences_ = MapFieldLite.d();

    public static final class a extends GeneratedMessageLite.a<d, a> implements l0 {
        /* synthetic */ a(c cVar) {
            this();
        }

        public a s(String str, PreferencesProto$Value preferencesProto$Value) {
            str.getClass();
            preferencesProto$Value.getClass();
            l();
            ((d) this.f5131b).E().put(str, preferencesProto$Value);
            return this;
        }

        private a() {
            super(d.DEFAULT_INSTANCE);
        }
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final e0<String, PreferencesProto$Value> f5063a = e0.d(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, PreferencesProto$Value.L());
    }

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        GeneratedMessageLite.A(d.class, dVar);
    }

    private d() {
    }

    /* access modifiers changed from: private */
    public Map<String, PreferencesProto$Value> E() {
        return G();
    }

    private MapFieldLite<String, PreferencesProto$Value> G() {
        if (!this.preferences_.k()) {
            this.preferences_ = this.preferences_.p();
        }
        return this.preferences_;
    }

    private MapFieldLite<String, PreferencesProto$Value> H() {
        return this.preferences_;
    }

    public static a I() {
        return (a) DEFAULT_INSTANCE.k();
    }

    public static d J(InputStream inputStream) throws IOException {
        return (d) GeneratedMessageLite.y(DEFAULT_INSTANCE, inputStream);
    }

    public Map<String, PreferencesProto$Value> F() {
        return Collections.unmodifiableMap(H());
    }

    /* access modifiers changed from: protected */
    public final Object o(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (c.f5051a[methodToInvoke.ordinal()]) {
            case 1:
                return new d();
            case 2:
                return new a((c) null);
            case 3:
                return GeneratedMessageLite.x(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", b.f5063a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                s0<d> s0Var = PARSER;
                if (s0Var == null) {
                    synchronized (d.class) {
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
