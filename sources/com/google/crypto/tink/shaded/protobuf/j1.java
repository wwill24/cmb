package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class j1 {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f20833a = Logger.getLogger(j1.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final Unsafe f20834b = B();

    /* renamed from: c  reason: collision with root package name */
    private static final Class<?> f20835c = d.b();

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f20836d = m(Long.TYPE);

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f20837e = m(Integer.TYPE);

    /* renamed from: f  reason: collision with root package name */
    private static final e f20838f = z();

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f20839g = Q();

    /* renamed from: h  reason: collision with root package name */
    private static final boolean f20840h = P();

    /* renamed from: i  reason: collision with root package name */
    static final long f20841i;

    /* renamed from: j  reason: collision with root package name */
    private static final long f20842j;

    /* renamed from: k  reason: collision with root package name */
    private static final long f20843k;

    /* renamed from: l  reason: collision with root package name */
    private static final long f20844l;

    /* renamed from: m  reason: collision with root package name */
    private static final long f20845m;

    /* renamed from: n  reason: collision with root package name */
    private static final long f20846n;

    /* renamed from: o  reason: collision with root package name */
    private static final long f20847o;

    /* renamed from: p  reason: collision with root package name */
    private static final long f20848p;

    /* renamed from: q  reason: collision with root package name */
    private static final long f20849q;

    /* renamed from: r  reason: collision with root package name */
    private static final long f20850r;

    /* renamed from: s  reason: collision with root package name */
    private static final long f20851s;

    /* renamed from: t  reason: collision with root package name */
    private static final long f20852t;

    /* renamed from: u  reason: collision with root package name */
    private static final long f20853u;

    /* renamed from: v  reason: collision with root package name */
    private static final long f20854v = o(l());

    /* renamed from: w  reason: collision with root package name */
    private static final int f20855w;

    /* renamed from: x  reason: collision with root package name */
    static final boolean f20856x;

    class a implements PrivilegedExceptionAction<Unsafe> {
        a() {
        }

        /* renamed from: a */
        public Unsafe run() throws Exception {
            Class<Unsafe> cls = Unsafe.class;
            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get((Object) null);
                if (cls.isInstance(obj)) {
                    return cls.cast(obj);
                }
            }
            return null;
        }
    }

    private static final class b extends e {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        public boolean c(Object obj, long j10) {
            if (j1.f20856x) {
                return j1.q(obj, j10);
            }
            return j1.r(obj, j10);
        }

        public byte d(Object obj, long j10) {
            if (j1.f20856x) {
                return j1.t(obj, j10);
            }
            return j1.u(obj, j10);
        }

        public double e(Object obj, long j10) {
            return Double.longBitsToDouble(h(obj, j10));
        }

        public float f(Object obj, long j10) {
            return Float.intBitsToFloat(g(obj, j10));
        }

        public void k(Object obj, long j10, boolean z10) {
            if (j1.f20856x) {
                j1.F(obj, j10, z10);
            } else {
                j1.G(obj, j10, z10);
            }
        }

        public void l(Object obj, long j10, byte b10) {
            if (j1.f20856x) {
                j1.I(obj, j10, b10);
            } else {
                j1.J(obj, j10, b10);
            }
        }

        public void m(Object obj, long j10, double d10) {
            p(obj, j10, Double.doubleToLongBits(d10));
        }

        public void n(Object obj, long j10, float f10) {
            o(obj, j10, Float.floatToIntBits(f10));
        }
    }

    private static final class c extends e {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        public boolean c(Object obj, long j10) {
            if (j1.f20856x) {
                return j1.q(obj, j10);
            }
            return j1.r(obj, j10);
        }

        public byte d(Object obj, long j10) {
            if (j1.f20856x) {
                return j1.t(obj, j10);
            }
            return j1.u(obj, j10);
        }

        public double e(Object obj, long j10) {
            return Double.longBitsToDouble(h(obj, j10));
        }

        public float f(Object obj, long j10) {
            return Float.intBitsToFloat(g(obj, j10));
        }

        public void k(Object obj, long j10, boolean z10) {
            if (j1.f20856x) {
                j1.F(obj, j10, z10);
            } else {
                j1.G(obj, j10, z10);
            }
        }

        public void l(Object obj, long j10, byte b10) {
            if (j1.f20856x) {
                j1.I(obj, j10, b10);
            } else {
                j1.J(obj, j10, b10);
            }
        }

        public void m(Object obj, long j10, double d10) {
            p(obj, j10, Double.doubleToLongBits(d10));
        }

        public void n(Object obj, long j10, float f10) {
            o(obj, j10, Float.floatToIntBits(f10));
        }
    }

    private static final class d extends e {
        d(Unsafe unsafe) {
            super(unsafe);
        }

        public boolean c(Object obj, long j10) {
            return this.f20857a.getBoolean(obj, j10);
        }

        public byte d(Object obj, long j10) {
            return this.f20857a.getByte(obj, j10);
        }

        public double e(Object obj, long j10) {
            return this.f20857a.getDouble(obj, j10);
        }

        public float f(Object obj, long j10) {
            return this.f20857a.getFloat(obj, j10);
        }

        public void k(Object obj, long j10, boolean z10) {
            this.f20857a.putBoolean(obj, j10, z10);
        }

        public void l(Object obj, long j10, byte b10) {
            this.f20857a.putByte(obj, j10, b10);
        }

        public void m(Object obj, long j10, double d10) {
            this.f20857a.putDouble(obj, j10, d10);
        }

        public void n(Object obj, long j10, float f10) {
            this.f20857a.putFloat(obj, j10, f10);
        }
    }

    private static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        Unsafe f20857a;

        e(Unsafe unsafe) {
            this.f20857a = unsafe;
        }

        public final int a(Class<?> cls) {
            return this.f20857a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.f20857a.arrayIndexScale(cls);
        }

        public abstract boolean c(Object obj, long j10);

        public abstract byte d(Object obj, long j10);

        public abstract double e(Object obj, long j10);

        public abstract float f(Object obj, long j10);

        public final int g(Object obj, long j10) {
            return this.f20857a.getInt(obj, j10);
        }

        public final long h(Object obj, long j10) {
            return this.f20857a.getLong(obj, j10);
        }

        public final Object i(Object obj, long j10) {
            return this.f20857a.getObject(obj, j10);
        }

        public final long j(Field field) {
            return this.f20857a.objectFieldOffset(field);
        }

        public abstract void k(Object obj, long j10, boolean z10);

        public abstract void l(Object obj, long j10, byte b10);

        public abstract void m(Object obj, long j10, double d10);

        public abstract void n(Object obj, long j10, float f10);

        public final void o(Object obj, long j10, int i10) {
            this.f20857a.putInt(obj, j10, i10);
        }

        public final void p(Object obj, long j10, long j11) {
            this.f20857a.putLong(obj, j10, j11);
        }

        public final void q(Object obj, long j10, Object obj2) {
            this.f20857a.putObject(obj, j10, obj2);
        }
    }

    static {
        boolean z10;
        Class<Object[]> cls = Object[].class;
        Class<double[]> cls2 = double[].class;
        Class<float[]> cls3 = float[].class;
        Class<long[]> cls4 = long[].class;
        Class<int[]> cls5 = int[].class;
        Class<boolean[]> cls6 = boolean[].class;
        long j10 = (long) j(byte[].class);
        f20841i = j10;
        f20842j = (long) j(cls6);
        f20843k = (long) k(cls6);
        f20844l = (long) j(cls5);
        f20845m = (long) k(cls5);
        f20846n = (long) j(cls4);
        f20847o = (long) k(cls4);
        f20848p = (long) j(cls3);
        f20849q = (long) k(cls3);
        f20850r = (long) j(cls2);
        f20851s = (long) k(cls2);
        f20852t = (long) j(cls);
        f20853u = (long) k(cls);
        f20855w = (int) (7 & j10);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z10 = true;
        } else {
            z10 = false;
        }
        f20856x = z10;
    }

    private j1() {
    }

    static Object A(Object obj, long j10) {
        return f20838f.i(obj, j10);
    }

    static Unsafe B() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean C() {
        return f20840h;
    }

    static boolean D() {
        return f20839g;
    }

    static void E(Object obj, long j10, boolean z10) {
        f20838f.k(obj, j10, z10);
    }

    /* access modifiers changed from: private */
    public static void F(Object obj, long j10, boolean z10) {
        I(obj, j10, z10 ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void G(Object obj, long j10, boolean z10) {
        J(obj, j10, z10 ? (byte) 1 : 0);
    }

    static void H(byte[] bArr, long j10, byte b10) {
        f20838f.l(bArr, f20841i + j10, b10);
    }

    /* access modifiers changed from: private */
    public static void I(Object obj, long j10, byte b10) {
        long j11 = -4 & j10;
        int x10 = x(obj, j11);
        int i10 = ((~((int) j10)) & 3) << 3;
        M(obj, j11, ((255 & b10) << i10) | (x10 & (~(255 << i10))));
    }

    /* access modifiers changed from: private */
    public static void J(Object obj, long j10, byte b10) {
        long j11 = -4 & j10;
        int i10 = (((int) j10) & 3) << 3;
        M(obj, j11, ((255 & b10) << i10) | (x(obj, j11) & (~(255 << i10))));
    }

    static void K(Object obj, long j10, double d10) {
        f20838f.m(obj, j10, d10);
    }

    static void L(Object obj, long j10, float f10) {
        f20838f.n(obj, j10, f10);
    }

    static void M(Object obj, long j10, int i10) {
        f20838f.o(obj, j10, i10);
    }

    static void N(Object obj, long j10, long j11) {
        f20838f.p(obj, j10, j11);
    }

    static void O(Object obj, long j10, Object obj2) {
        f20838f.q(obj, j10, obj2);
    }

    private static boolean P() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = f20834b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls2.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls2.getMethod("arrayIndexScale", new Class[]{Class.class});
            Class cls3 = Long.TYPE;
            cls2.getMethod("getInt", new Class[]{cls, cls3});
            cls2.getMethod("putInt", new Class[]{cls, cls3, Integer.TYPE});
            cls2.getMethod("getLong", new Class[]{cls, cls3});
            cls2.getMethod("putLong", new Class[]{cls, cls3, cls3});
            cls2.getMethod("getObject", new Class[]{cls, cls3});
            cls2.getMethod("putObject", new Class[]{cls, cls3, cls});
            if (d.c()) {
                return true;
            }
            cls2.getMethod("getByte", new Class[]{cls, cls3});
            cls2.getMethod("putByte", new Class[]{cls, cls3, Byte.TYPE});
            cls2.getMethod("getBoolean", new Class[]{cls, cls3});
            cls2.getMethod("putBoolean", new Class[]{cls, cls3, Boolean.TYPE});
            cls2.getMethod("getFloat", new Class[]{cls, cls3});
            cls2.getMethod("putFloat", new Class[]{cls, cls3, Float.TYPE});
            cls2.getMethod("getDouble", new Class[]{cls, cls3});
            cls2.getMethod("putDouble", new Class[]{cls, cls3, Double.TYPE});
            return true;
        } catch (Throwable th2) {
            Logger logger = f20833a;
            Level level = Level.WARNING;
            logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th2);
            return false;
        }
    }

    private static boolean Q() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = f20834b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            Class cls3 = Long.TYPE;
            cls2.getMethod("getLong", new Class[]{cls, cls3});
            if (l() == null) {
                return false;
            }
            if (d.c()) {
                return true;
            }
            cls2.getMethod("getByte", new Class[]{cls3});
            cls2.getMethod("putByte", new Class[]{cls3, Byte.TYPE});
            cls2.getMethod("getInt", new Class[]{cls3});
            cls2.getMethod("putInt", new Class[]{cls3, Integer.TYPE});
            cls2.getMethod("getLong", new Class[]{cls3});
            cls2.getMethod("putLong", new Class[]{cls3, cls3});
            cls2.getMethod("copyMemory", new Class[]{cls3, cls3, cls3});
            cls2.getMethod("copyMemory", new Class[]{cls, cls3, cls, cls3, cls3});
            return true;
        } catch (Throwable th2) {
            Logger logger = f20833a;
            Level level = Level.WARNING;
            logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th2);
            return false;
        }
    }

    static <T> T i(Class<T> cls) {
        try {
            return f20834b.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    private static int j(Class<?> cls) {
        if (f20840h) {
            return f20838f.a(cls);
        }
        return -1;
    }

    private static int k(Class<?> cls) {
        if (f20840h) {
            return f20838f.b(cls);
        }
        return -1;
    }

    private static Field l() {
        Field n10;
        if (d.c() && (n10 = n(Buffer.class, "effectiveDirectAddress")) != null) {
            return n10;
        }
        Field n11 = n(Buffer.class, "address");
        if (n11 == null || n11.getType() != Long.TYPE) {
            return null;
        }
        return n11;
    }

    private static boolean m(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!d.c()) {
            return false;
        }
        try {
            Class<?> cls3 = f20835c;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field n(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long o(Field field) {
        e eVar;
        if (field == null || (eVar = f20838f) == null) {
            return -1;
        }
        return eVar.j(field);
    }

    static boolean p(Object obj, long j10) {
        return f20838f.c(obj, j10);
    }

    /* access modifiers changed from: private */
    public static boolean q(Object obj, long j10) {
        return t(obj, j10) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean r(Object obj, long j10) {
        return u(obj, j10) != 0;
    }

    static byte s(byte[] bArr, long j10) {
        return f20838f.d(bArr, f20841i + j10);
    }

    /* access modifiers changed from: private */
    public static byte t(Object obj, long j10) {
        return (byte) ((x(obj, -4 & j10) >>> ((int) (((~j10) & 3) << 3))) & 255);
    }

    /* access modifiers changed from: private */
    public static byte u(Object obj, long j10) {
        return (byte) ((x(obj, -4 & j10) >>> ((int) ((j10 & 3) << 3))) & 255);
    }

    static double v(Object obj, long j10) {
        return f20838f.e(obj, j10);
    }

    static float w(Object obj, long j10) {
        return f20838f.f(obj, j10);
    }

    static int x(Object obj, long j10) {
        return f20838f.g(obj, j10);
    }

    static long y(Object obj, long j10) {
        return f20838f.h(obj, j10);
    }

    private static e z() {
        Unsafe unsafe = f20834b;
        if (unsafe == null) {
            return null;
        }
        if (!d.c()) {
            return new d(unsafe);
        }
        if (f20836d) {
            return new c(unsafe);
        }
        if (f20837e) {
            return new b(unsafe);
        }
        return null;
    }
}
