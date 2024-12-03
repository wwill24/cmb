package androidx.datastore.preferences.protobuf;

final class d0 implements z0 {

    /* renamed from: b  reason: collision with root package name */
    private static final j0 f5233b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final j0 f5234a;

    static class a implements j0 {
        a() {
        }

        public i0 a(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }

        public boolean b(Class<?> cls) {
            return false;
        }
    }

    private static class b implements j0 {

        /* renamed from: a  reason: collision with root package name */
        private j0[] f5235a;

        b(j0... j0VarArr) {
            this.f5235a = j0VarArr;
        }

        public i0 a(Class<?> cls) {
            for (j0 j0Var : this.f5235a) {
                if (j0Var.b(cls)) {
                    return j0Var.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        public boolean b(Class<?> cls) {
            for (j0 b10 : this.f5235a) {
                if (b10.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public d0() {
        this(b());
    }

    private static j0 b() {
        return new b(u.c(), c());
    }

    private static j0 c() {
        try {
            return (j0) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return f5233b;
        }
    }

    private static boolean d(i0 i0Var) {
        return i0Var.c() == ProtoSyntax.PROTO2;
    }

    private static <T> y0<T> e(Class<T> cls, i0 i0Var) {
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            if (d(i0Var)) {
                return n0.K(cls, i0Var, r0.b(), b0.b(), a1.M(), q.b(), h0.b());
            }
            return n0.K(cls, i0Var, r0.b(), b0.b(), a1.M(), (o<?>) null, h0.b());
        } else if (d(i0Var)) {
            return n0.K(cls, i0Var, r0.a(), b0.a(), a1.H(), q.a(), h0.a());
        } else {
            return n0.K(cls, i0Var, r0.a(), b0.a(), a1.I(), (o<?>) null, h0.a());
        }
    }

    public <T> y0<T> a(Class<T> cls) {
        a1.J(cls);
        i0 a10 = this.f5234a.a(cls);
        if (!a10.a()) {
            return e(cls, a10);
        }
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            return o0.i(a1.M(), q.b(), a10.b());
        }
        return o0.i(a1.H(), q.a(), a10.b());
    }

    private d0(j0 j0Var) {
        this.f5234a = (j0) w.b(j0Var, "messageInfoFactory");
    }
}
