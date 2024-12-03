package androidx.datastore.preferences;

import androidx.datastore.preferences.e;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.l0;
import androidx.datastore.preferences.protobuf.s0;

public final class PreferencesProto$Value extends GeneratedMessageLite<PreferencesProto$Value, a> implements l0 {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final PreferencesProto$Value DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile s0<PreferencesProto$Value> PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int bitField0_;
    private int valueCase_ = 0;
    private Object value_;

    public enum ValueCase {
        BOOLEAN(1),
        FLOAT(2),
        INTEGER(3),
        LONG(4),
        STRING(5),
        STRING_SET(6),
        DOUBLE(7),
        VALUE_NOT_SET(0);
        
        private final int value;

        private ValueCase(int i10) {
            this.value = i10;
        }

        public static ValueCase a(int i10) {
            switch (i10) {
                case 0:
                    return VALUE_NOT_SET;
                case 1:
                    return BOOLEAN;
                case 2:
                    return FLOAT;
                case 3:
                    return INTEGER;
                case 4:
                    return LONG;
                case 5:
                    return STRING;
                case 6:
                    return STRING_SET;
                case 7:
                    return DOUBLE;
                default:
                    return null;
            }
        }
    }

    public static final class a extends GeneratedMessageLite.a<PreferencesProto$Value, a> implements l0 {
        /* synthetic */ a(c cVar) {
            this();
        }

        public a s(boolean z10) {
            l();
            ((PreferencesProto$Value) this.f5131b).U(z10);
            return this;
        }

        public a t(double d10) {
            l();
            ((PreferencesProto$Value) this.f5131b).V(d10);
            return this;
        }

        public a u(float f10) {
            l();
            ((PreferencesProto$Value) this.f5131b).W(f10);
            return this;
        }

        public a v(int i10) {
            l();
            ((PreferencesProto$Value) this.f5131b).X(i10);
            return this;
        }

        public a w(long j10) {
            l();
            ((PreferencesProto$Value) this.f5131b).Y(j10);
            return this;
        }

        public a x(String str) {
            l();
            ((PreferencesProto$Value) this.f5131b).Z(str);
            return this;
        }

        public a y(e.a aVar) {
            l();
            ((PreferencesProto$Value) this.f5131b).a0(aVar);
            return this;
        }

        private a() {
            super(PreferencesProto$Value.DEFAULT_INSTANCE);
        }
    }

    static {
        PreferencesProto$Value preferencesProto$Value = new PreferencesProto$Value();
        DEFAULT_INSTANCE = preferencesProto$Value;
        GeneratedMessageLite.A(PreferencesProto$Value.class, preferencesProto$Value);
    }

    private PreferencesProto$Value() {
    }

    public static PreferencesProto$Value L() {
        return DEFAULT_INSTANCE;
    }

    public static a T() {
        return (a) DEFAULT_INSTANCE.k();
    }

    /* access modifiers changed from: private */
    public void U(boolean z10) {
        this.valueCase_ = 1;
        this.value_ = Boolean.valueOf(z10);
    }

    /* access modifiers changed from: private */
    public void V(double d10) {
        this.valueCase_ = 7;
        this.value_ = Double.valueOf(d10);
    }

    /* access modifiers changed from: private */
    public void W(float f10) {
        this.valueCase_ = 2;
        this.value_ = Float.valueOf(f10);
    }

    /* access modifiers changed from: private */
    public void X(int i10) {
        this.valueCase_ = 3;
        this.value_ = Integer.valueOf(i10);
    }

    /* access modifiers changed from: private */
    public void Y(long j10) {
        this.valueCase_ = 4;
        this.value_ = Long.valueOf(j10);
    }

    /* access modifiers changed from: private */
    public void Z(String str) {
        str.getClass();
        this.valueCase_ = 5;
        this.value_ = str;
    }

    /* access modifiers changed from: private */
    public void a0(e.a aVar) {
        this.value_ = aVar.build();
        this.valueCase_ = 6;
    }

    public boolean K() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public double M() {
        if (this.valueCase_ == 7) {
            return ((Double) this.value_).doubleValue();
        }
        return 0.0d;
    }

    public float N() {
        if (this.valueCase_ == 2) {
            return ((Float) this.value_).floatValue();
        }
        return 0.0f;
    }

    public int O() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }

    public long P() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0;
    }

    public String Q() {
        if (this.valueCase_ == 5) {
            return (String) this.value_;
        }
        return "";
    }

    public e R() {
        if (this.valueCase_ == 6) {
            return (e) this.value_;
        }
        return e.G();
    }

    public ValueCase S() {
        return ValueCase.a(this.valueCase_);
    }

    /* access modifiers changed from: protected */
    public final Object o(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (c.f5051a[methodToInvoke.ordinal()]) {
            case 1:
                return new PreferencesProto$Value();
            case 2:
                return new a((c) null);
            case 3:
                return GeneratedMessageLite.x(DEFAULT_INSTANCE, "\u0001\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000", new Object[]{"value_", "valueCase_", "bitField0_", e.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                s0<PreferencesProto$Value> s0Var = PARSER;
                if (s0Var == null) {
                    synchronized (PreferencesProto$Value.class) {
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
