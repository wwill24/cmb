package com.google.protobuf;

final class e0 implements a1 {

    /* renamed from: b  reason: collision with root package name */
    private static final k0 f21788b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final k0 f21789a;

    class a implements k0 {
        a() {
        }

        public j0 a(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }

        public boolean b(Class<?> cls) {
            return false;
        }
    }

    private static class b implements k0 {

        /* renamed from: a  reason: collision with root package name */
        private k0[] f21790a;

        b(k0... k0VarArr) {
            this.f21790a = k0VarArr;
        }

        public j0 a(Class<?> cls) {
            for (k0 k0Var : this.f21790a) {
                if (k0Var.b(cls)) {
                    return k0Var.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        public boolean b(Class<?> cls) {
            for (k0 b10 : this.f21790a) {
                if (b10.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public e0() {
        this(b());
    }

    private static k0 b() {
        return new b(u.c(), c());
    }

    private static k0 c() {
        try {
            return (k0) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return f21788b;
        }
    }

    private static boolean d(j0 j0Var) {
        return j0Var.c() == ProtoSyntax.PROTO2;
    }

    private static <T> z0<T> e(Class<T> cls, j0 j0Var) {
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            if (d(j0Var)) {
                return o0.S(cls, j0Var, s0.b(), c0.b(), b1.M(), q.b(), i0.b());
            }
            return o0.S(cls, j0Var, s0.b(), c0.b(), b1.M(), (o<?>) null, i0.b());
        } else if (d(j0Var)) {
            return o0.S(cls, j0Var, s0.a(), c0.a(), b1.H(), q.a(), i0.a());
        } else {
            return o0.S(cls, j0Var, s0.a(), c0.a(), b1.I(), (o<?>) null, i0.a());
        }
    }

    public <T> z0<T> a(Class<T> cls) {
        b1.J(cls);
        j0 a10 = this.f21789a.a(cls);
        if (!a10.a()) {
            return e(cls, a10);
        }
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            return p0.j(b1.M(), q.b(), a10.b());
        }
        return p0.j(b1.H(), q.a(), a10.b());
    }

    private e0(k0 k0Var) {
        this.f21789a = (k0) w.b(k0Var, "messageInfoFactory");
    }
}
