package com.google.protobuf;

import com.google.protobuf.s;
import com.google.protobuf.w;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class b1 {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f21743a = B();

    /* renamed from: b  reason: collision with root package name */
    private static final f1<?, ?> f21744b = C(false);

    /* renamed from: c  reason: collision with root package name */
    private static final f1<?, ?> f21745c = C(true);

    /* renamed from: d  reason: collision with root package name */
    private static final f1<?, ?> f21746d = new h1();

    static <UT, UB> UB A(Object obj, int i10, List<Integer> list, w.e eVar, UB ub2, f1<UT, UB> f1Var) {
        if (eVar == null) {
            return ub2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                int intValue = list.get(i12).intValue();
                if (eVar.isInRange(intValue)) {
                    if (i12 != i11) {
                        list.set(i11, Integer.valueOf(intValue));
                    }
                    i11++;
                } else {
                    ub2 = L(obj, i10, intValue, ub2, f1Var);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!eVar.isInRange(intValue2)) {
                    ub2 = L(obj, i10, intValue2, ub2, f1Var);
                    it.remove();
                }
            }
        }
        return ub2;
    }

    private static Class<?> B() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static f1<?, ?> C(boolean z10) {
        try {
            Class<?> D = D();
            if (D == null) {
                return null;
            }
            return (f1) D.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z10)});
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> D() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static <T, FT extends s.b<FT>> void E(o<FT> oVar, T t10, T t11) {
        s<FT> c10 = oVar.c(t11);
        if (!c10.n()) {
            oVar.d(t10).v(c10);
        }
    }

    static <T> void F(g0 g0Var, T t10, T t11, long j10) {
        j1.V(t10, j10, g0Var.a(j1.G(t10, j10), j1.G(t11, j10)));
    }

    static <T, UT, UB> void G(f1<UT, UB> f1Var, T t10, T t11) {
        f1Var.p(t10, f1Var.k(f1Var.g(t10), f1Var.g(t11)));
    }

    public static f1<?, ?> H() {
        return f21744b;
    }

    public static f1<?, ?> I() {
        return f21745c;
    }

    public static void J(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = f21743a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
        }
    }

    static boolean K(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <UT, UB> UB L(Object obj, int i10, int i11, UB ub2, f1<UT, UB> f1Var) {
        if (ub2 == null) {
            ub2 = f1Var.f(obj);
        }
        f1Var.e(ub2, i10, (long) i11);
        return ub2;
    }

    public static f1<?, ?> M() {
        return f21746d;
    }

    public static void N(int i10, List<Boolean> list, Writer writer, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.A(i10, list, z10);
        }
    }

    public static void O(int i10, List<ByteString> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.I(i10, list);
        }
    }

    public static void P(int i10, List<Double> list, Writer writer, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.G(i10, list, z10);
        }
    }

    public static void Q(int i10, List<Integer> list, Writer writer, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.n(i10, list, z10);
        }
    }

    public static void R(int i10, List<Integer> list, Writer writer, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.j(i10, list, z10);
        }
    }

    public static void S(int i10, List<Long> list, Writer writer, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.y(i10, list, z10);
        }
    }

    public static void T(int i10, List<Float> list, Writer writer, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.a(i10, list, z10);
        }
    }

    public static void U(int i10, List<?> list, Writer writer, z0 z0Var) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.M(i10, list, z0Var);
        }
    }

    public static void V(int i10, List<Integer> list, Writer writer, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.g(i10, list, z10);
        }
    }

    public static void W(int i10, List<Long> list, Writer writer, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.F(i10, list, z10);
        }
    }

    public static void X(int i10, List<?> list, Writer writer, z0 z0Var) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.J(i10, list, z0Var);
        }
    }

    public static void Y(int i10, List<Integer> list, Writer writer, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.z(i10, list, z10);
        }
    }

    public static void Z(int i10, List<Long> list, Writer writer, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.q(i10, list, z10);
        }
    }

    static int a(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z10) {
            return CodedOutputStream.V(i10) + CodedOutputStream.D(size);
        }
        return size * CodedOutputStream.e(i10, true);
    }

    public static void a0(int i10, List<Integer> list, Writer writer, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.D(i10, list, z10);
        }
    }

    static int b(List<?> list) {
        return list.size();
    }

    public static void b0(int i10, List<Long> list, Writer writer, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.l(i10, list, z10);
        }
    }

    static int c(int i10, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int V = size * CodedOutputStream.V(i10);
        for (int i11 = 0; i11 < list.size(); i11++) {
            V += CodedOutputStream.i(list.get(i11));
        }
        return V;
    }

    public static void c0(int i10, List<String> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.d(i10, list);
        }
    }

    static int d(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e10 = e(list);
        if (z10) {
            return CodedOutputStream.V(i10) + CodedOutputStream.D(e10);
        }
        return e10 + (size * CodedOutputStream.V(i10));
    }

    public static void d0(int i10, List<Integer> list, Writer writer, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.k(i10, list, z10);
        }
    }

    static int e(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v) {
            v vVar = (v) list;
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.m(vVar.getInt(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + CodedOutputStream.m(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static void e0(int i10, List<Long> list, Writer writer, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.r(i10, list, z10);
        }
    }

    static int f(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z10) {
            return CodedOutputStream.V(i10) + CodedOutputStream.D(size * 4);
        }
        return size * CodedOutputStream.n(i10, 0);
    }

    static int g(List<?> list) {
        return list.size() * 4;
    }

    static int h(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z10) {
            return CodedOutputStream.V(i10) + CodedOutputStream.D(size * 8);
        }
        return size * CodedOutputStream.p(i10, 0);
    }

    static int i(List<?> list) {
        return list.size() * 8;
    }

    static int j(int i10, List<l0> list, z0 z0Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += CodedOutputStream.t(i10, list.get(i12), z0Var);
        }
        return i11;
    }

    static int k(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l10 = l(list);
        if (z10) {
            return CodedOutputStream.V(i10) + CodedOutputStream.D(l10);
        }
        return l10 + (size * CodedOutputStream.V(i10));
    }

    static int l(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v) {
            v vVar = (v) list;
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.x(vVar.getInt(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + CodedOutputStream.x(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    static int m(int i10, List<Long> list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        int n10 = n(list);
        if (z10) {
            return CodedOutputStream.V(i10) + CodedOutputStream.D(n10);
        }
        return n10 + (list.size() * CodedOutputStream.V(i10));
    }

    static int n(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof d0) {
            d0 d0Var = (d0) list;
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.z(d0Var.o(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + CodedOutputStream.z(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    static int o(int i10, Object obj, z0 z0Var) {
        if (obj instanceof z) {
            return CodedOutputStream.B(i10, (z) obj);
        }
        return CodedOutputStream.G(i10, (l0) obj, z0Var);
    }

    static int p(int i10, List<?> list, z0 z0Var) {
        int i11;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int V = CodedOutputStream.V(i10) * size;
        for (int i12 = 0; i12 < size; i12++) {
            Object obj = list.get(i12);
            if (obj instanceof z) {
                i11 = CodedOutputStream.C((z) obj);
            } else {
                i11 = CodedOutputStream.I((l0) obj, z0Var);
            }
            V += i11;
        }
        return V;
    }

    static int q(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int r10 = r(list);
        if (z10) {
            return CodedOutputStream.V(i10) + CodedOutputStream.D(r10);
        }
        return r10 + (size * CodedOutputStream.V(i10));
    }

    static int r(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v) {
            v vVar = (v) list;
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.Q(vVar.getInt(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + CodedOutputStream.Q(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    static int s(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int t10 = t(list);
        if (z10) {
            return CodedOutputStream.V(i10) + CodedOutputStream.D(t10);
        }
        return t10 + (size * CodedOutputStream.V(i10));
    }

    static int t(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof d0) {
            d0 d0Var = (d0) list;
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.S(d0Var.o(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + CodedOutputStream.S(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    static int u(int i10, List<?> list) {
        int i11;
        int i12;
        int size = list.size();
        int i13 = 0;
        if (size == 0) {
            return 0;
        }
        int V = CodedOutputStream.V(i10) * size;
        if (list instanceof b0) {
            b0 b0Var = (b0) list;
            while (i13 < size) {
                Object l10 = b0Var.l(i13);
                if (l10 instanceof ByteString) {
                    i12 = CodedOutputStream.i((ByteString) l10);
                } else {
                    i12 = CodedOutputStream.U((String) l10);
                }
                V += i12;
                i13++;
            }
        } else {
            while (i13 < size) {
                Object obj = list.get(i13);
                if (obj instanceof ByteString) {
                    i11 = CodedOutputStream.i((ByteString) obj);
                } else {
                    i11 = CodedOutputStream.U((String) obj);
                }
                V += i11;
                i13++;
            }
        }
        return V;
    }

    static int v(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int w10 = w(list);
        if (z10) {
            return CodedOutputStream.V(i10) + CodedOutputStream.D(w10);
        }
        return w10 + (size * CodedOutputStream.V(i10));
    }

    static int w(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v) {
            v vVar = (v) list;
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.X(vVar.getInt(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + CodedOutputStream.X(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    static int x(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int y10 = y(list);
        if (z10) {
            return CodedOutputStream.V(i10) + CodedOutputStream.D(y10);
        }
        return y10 + (size * CodedOutputStream.V(i10));
    }

    static int y(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof d0) {
            d0 d0Var = (d0) list;
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.Z(d0Var.o(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + CodedOutputStream.Z(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    static <UT, UB> UB z(Object obj, int i10, List<Integer> list, w.d<?> dVar, UB ub2, f1<UT, UB> f1Var) {
        if (dVar == null) {
            return ub2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                int intValue = list.get(i12).intValue();
                if (dVar.findValueByNumber(intValue) != null) {
                    if (i12 != i11) {
                        list.set(i11, Integer.valueOf(intValue));
                    }
                    i11++;
                } else {
                    ub2 = L(obj, i10, intValue, ub2, f1Var);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (dVar.findValueByNumber(intValue2) == null) {
                    ub2 = L(obj, i10, intValue2, ub2, f1Var);
                    it.remove();
                }
            }
        }
        return ub2;
    }
}
