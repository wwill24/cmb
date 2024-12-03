package kotlin.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.j;

class k extends j {
    public static <T> List<T> e(T[] tArr) {
        j.g(tArr, "<this>");
        List<T> a10 = m.a(tArr);
        j.f(a10, "asList(this)");
        return a10;
    }

    public static byte[] f(byte[] bArr, byte[] bArr2, int i10, int i11, int i12) {
        j.g(bArr, "<this>");
        j.g(bArr2, "destination");
        System.arraycopy(bArr, i11, bArr2, i10, i12 - i11);
        return bArr2;
    }

    public static <T> T[] g(T[] tArr, T[] tArr2, int i10, int i11, int i12) {
        j.g(tArr, "<this>");
        j.g(tArr2, "destination");
        System.arraycopy(tArr, i11, tArr2, i10, i12 - i11);
        return tArr2;
    }

    public static /* synthetic */ byte[] h(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = bArr.length;
        }
        return f(bArr, bArr2, i10, i11, i12);
    }

    public static /* synthetic */ Object[] i(Object[] objArr, Object[] objArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = objArr.length;
        }
        return g(objArr, objArr2, i10, i11, i12);
    }

    public static byte[] j(byte[] bArr, int i10, int i11) {
        j.g(bArr, "<this>");
        i.b(i11, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i10, i11);
        j.f(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static <T> T[] k(T[] tArr, int i10, int i11) {
        j.g(tArr, "<this>");
        i.b(i11, tArr.length);
        T[] copyOfRange = Arrays.copyOfRange(tArr, i10, i11);
        j.f(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static void l(int[] iArr, int i10, int i11, int i12) {
        j.g(iArr, "<this>");
        Arrays.fill(iArr, i11, i12, i10);
    }

    public static <T> void m(T[] tArr, T t10, int i10, int i11) {
        j.g(tArr, "<this>");
        Arrays.fill(tArr, i10, i11, t10);
    }

    public static /* synthetic */ void n(Object[] objArr, Object obj, int i10, int i11, int i12, Object obj2) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = objArr.length;
        }
        m(objArr, obj, i10, i11);
    }

    public static <T> void o(T[] tArr) {
        j.g(tArr, "<this>");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static final <T> void p(T[] tArr, Comparator<? super T> comparator) {
        j.g(tArr, "<this>");
        j.g(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }
}
