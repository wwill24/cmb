package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.t;
import com.google.crypto.tink.shaded.protobuf.x;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class b1 {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f20743a = B();

    /* renamed from: b  reason: collision with root package name */
    private static final f1<?, ?> f20744b = C(false);

    /* renamed from: c  reason: collision with root package name */
    private static final f1<?, ?> f20745c = C(true);

    /* renamed from: d  reason: collision with root package name */
    private static final f1<?, ?> f20746d = new h1();

    static <UT, UB> UB A(int i10, List<Integer> list, x.e eVar, UB ub2, f1<UT, UB> f1Var) {
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
                    ub2 = L(i10, intValue, ub2, f1Var);
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
                    ub2 = L(i10, intValue2, ub2, f1Var);
                    it.remove();
                }
            }
        }
        return ub2;
    }

    private static Class<?> B() {
        try {
            return Class.forName("com.google.crypto.tink.shaded.protobuf.GeneratedMessageV3");
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
            return Class.forName("com.google.crypto.tink.shaded.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static <T, FT extends t.b<FT>> void E(p<FT> pVar, T t10, T t11) {
        t<FT> c10 = pVar.c(t11);
        if (!c10.m()) {
            pVar.d(t10).t(c10);
        }
    }

    static <T> void F(g0 g0Var, T t10, T t11, long j10) {
        j1.O(t10, j10, g0Var.a(j1.A(t10, j10), j1.A(t11, j10)));
    }

    static <T, UT, UB> void G(f1<UT, UB> f1Var, T t10, T t11) {
        f1Var.p(t10, f1Var.k(f1Var.g(t10), f1Var.g(t11)));
    }

    public static f1<?, ?> H() {
        return f20744b;
    }

    public static f1<?, ?> I() {
        return f20745c;
    }

    public static void J(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = f20743a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean K(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <UT, UB> UB L(int i10, int i11, UB ub2, f1<UT, UB> f1Var) {
        if (ub2 == null) {
            ub2 = f1Var.n();
        }
        f1Var.e(ub2, i10, (long) i11);
        return ub2;
    }

    public static f1<?, ?> M() {
        return f20746d;
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
            writer.O(i10, list, z0Var);
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
            writer.L(i10, list, z0Var);
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
            return CodedOutputStream.U(i10) + CodedOutputStream.C(size);
        }
        return size * CodedOutputStream.d(i10, true);
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
        int U = size * CodedOutputStream.U(i10);
        for (int i11 = 0; i11 < list.size(); i11++) {
            U += CodedOutputStream.h(list.get(i11));
        }
        return U;
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
            return CodedOutputStream.U(i10) + CodedOutputStream.C(e10);
        }
        return e10 + (size * CodedOutputStream.U(i10));
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
        if (list instanceof w) {
            w wVar = (w) list;
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.l(wVar.getInt(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + CodedOutputStream.l(list.get(i11).intValue());
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
            return CodedOutputStream.U(i10) + CodedOutputStream.C(size * 4);
        }
        return size * CodedOutputStream.m(i10, 0);
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
            return CodedOutputStream.U(i10) + CodedOutputStream.C(size * 8);
        }
        return size * CodedOutputStream.o(i10, 0);
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
            i11 += CodedOutputStream.s(i10, list.get(i12), z0Var);
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
            return CodedOutputStream.U(i10) + CodedOutputStream.C(l10);
        }
        return l10 + (size * CodedOutputStream.U(i10));
    }

    static int l(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof w) {
            w wVar = (w) list;
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.w(wVar.getInt(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + CodedOutputStream.w(list.get(i11).intValue());
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
            return CodedOutputStream.U(i10) + CodedOutputStream.C(n10);
        }
        return n10 + (list.size() * CodedOutputStream.U(i10));
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
                i10 += CodedOutputStream.y(d0Var.n(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + CodedOutputStream.y(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    static int o(int i10, Object obj, z0 z0Var) {
        if (obj instanceof z) {
            return CodedOutputStream.A(i10, (z) obj);
        }
        return CodedOutputStream.F(i10, (l0) obj, z0Var);
    }

    static int p(int i10, List<?> list, z0 z0Var) {
        int i11;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int U = CodedOutputStream.U(i10) * size;
        for (int i12 = 0; i12 < size; i12++) {
            Object obj = list.get(i12);
            if (obj instanceof z) {
                i11 = CodedOutputStream.B((z) obj);
            } else {
                i11 = CodedOutputStream.H((l0) obj, z0Var);
            }
            U += i11;
        }
        return U;
    }

    static int q(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int r10 = r(list);
        if (z10) {
            return CodedOutputStream.U(i10) + CodedOutputStream.C(r10);
        }
        return r10 + (size * CodedOutputStream.U(i10));
    }

    static int r(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof w) {
            w wVar = (w) list;
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.P(wVar.getInt(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + CodedOutputStream.P(list.get(i11).intValue());
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
            return CodedOutputStream.U(i10) + CodedOutputStream.C(t10);
        }
        return t10 + (size * CodedOutputStream.U(i10));
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
                i10 += CodedOutputStream.R(d0Var.n(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + CodedOutputStream.R(list.get(i11).longValue());
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
        int U = CodedOutputStream.U(i10) * size;
        if (list instanceof b0) {
            b0 b0Var = (b0) list;
            while (i13 < size) {
                Object l10 = b0Var.l(i13);
                if (l10 instanceof ByteString) {
                    i12 = CodedOutputStream.h((ByteString) l10);
                } else {
                    i12 = CodedOutputStream.T((String) l10);
                }
                U += i12;
                i13++;
            }
        } else {
            while (i13 < size) {
                Object obj = list.get(i13);
                if (obj instanceof ByteString) {
                    i11 = CodedOutputStream.h((ByteString) obj);
                } else {
                    i11 = CodedOutputStream.T((String) obj);
                }
                U += i11;
                i13++;
            }
        }
        return U;
    }

    static int v(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int w10 = w(list);
        if (z10) {
            return CodedOutputStream.U(i10) + CodedOutputStream.C(w10);
        }
        return w10 + (size * CodedOutputStream.U(i10));
    }

    static int w(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof w) {
            w wVar = (w) list;
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.W(wVar.getInt(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + CodedOutputStream.W(list.get(i11).intValue());
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
            return CodedOutputStream.U(i10) + CodedOutputStream.C(y10);
        }
        return y10 + (size * CodedOutputStream.U(i10));
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
                i10 += CodedOutputStream.Y(d0Var.n(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + CodedOutputStream.Y(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    static <UT, UB> UB z(int i10, List<Integer> list, x.d<?> dVar, UB ub2, f1<UT, UB> f1Var) {
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
                    ub2 = L(i10, intValue, ub2, f1Var);
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
                    ub2 = L(i10, intValue2, ub2, f1Var);
                    it.remove();
                }
            }
        }
        return ub2;
    }
}
