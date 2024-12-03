package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.b;
import kotlin.jvm.internal.j;

class l extends k {

    public static final class a implements Iterable<T>, qk.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object[] f32064a;

        public a(Object[] objArr) {
            this.f32064a = objArr;
        }

        public Iterator<T> iterator() {
            return b.a(this.f32064a);
        }
    }

    public static <T> T A(T[] tArr) {
        j.g(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static int B(int[] iArr) {
        j.g(iArr, "<this>");
        return iArr.length - 1;
    }

    public static <T> int C(T[] tArr) {
        j.g(tArr, "<this>");
        return tArr.length - 1;
    }

    public static final int D(byte[] bArr, byte b10) {
        j.g(bArr, "<this>");
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (b10 == bArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    public static final int E(char[] cArr, char c10) {
        j.g(cArr, "<this>");
        int length = cArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (c10 == cArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    public static final int F(int[] iArr, int i10) {
        j.g(iArr, "<this>");
        int length = iArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (i10 == iArr[i11]) {
                return i11;
            }
        }
        return -1;
    }

    public static final int G(long[] jArr, long j10) {
        j.g(jArr, "<this>");
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (j10 == jArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    public static <T> int H(T[] tArr, T t10) {
        j.g(tArr, "<this>");
        int i10 = 0;
        if (t10 == null) {
            int length = tArr.length;
            while (i10 < length) {
                if (tArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i10 < length2) {
            if (j.b(t10, tArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static final int I(short[] sArr, short s10) {
        j.g(sArr, "<this>");
        int length = sArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (s10 == sArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    public static final <A extends Appendable> A J(byte[] bArr, A a10, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1<? super Byte, ? extends CharSequence> function1) {
        j.g(bArr, "<this>");
        j.g(a10, "buffer");
        j.g(charSequence, "separator");
        j.g(charSequence2, "prefix");
        j.g(charSequence3, "postfix");
        j.g(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (byte b10 : bArr) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (function1 != null) {
                a10.append((CharSequence) function1.invoke(Byte.valueOf(b10)));
            } else {
                a10.append(String.valueOf(b10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    public static final <A extends Appendable> A K(double[] dArr, A a10, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1<? super Double, ? extends CharSequence> function1) {
        j.g(dArr, "<this>");
        j.g(a10, "buffer");
        j.g(charSequence, "separator");
        j.g(charSequence2, "prefix");
        j.g(charSequence3, "postfix");
        j.g(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (double d10 : dArr) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (function1 != null) {
                a10.append((CharSequence) function1.invoke(Double.valueOf(d10)));
            } else {
                a10.append(String.valueOf(d10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    public static final <A extends Appendable> A L(float[] fArr, A a10, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1<? super Float, ? extends CharSequence> function1) {
        j.g(fArr, "<this>");
        j.g(a10, "buffer");
        j.g(charSequence, "separator");
        j.g(charSequence2, "prefix");
        j.g(charSequence3, "postfix");
        j.g(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (float f10 : fArr) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (function1 != null) {
                a10.append((CharSequence) function1.invoke(Float.valueOf(f10)));
            } else {
                a10.append(String.valueOf(f10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    public static final <A extends Appendable> A M(int[] iArr, A a10, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1<? super Integer, ? extends CharSequence> function1) {
        j.g(iArr, "<this>");
        j.g(a10, "buffer");
        j.g(charSequence, "separator");
        j.g(charSequence2, "prefix");
        j.g(charSequence3, "postfix");
        j.g(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (int i12 : iArr) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (function1 != null) {
                a10.append((CharSequence) function1.invoke(Integer.valueOf(i12)));
            } else {
                a10.append(String.valueOf(i12));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    public static final <A extends Appendable> A N(long[] jArr, A a10, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1<? super Long, ? extends CharSequence> function1) {
        j.g(jArr, "<this>");
        j.g(a10, "buffer");
        j.g(charSequence, "separator");
        j.g(charSequence2, "prefix");
        j.g(charSequence3, "postfix");
        j.g(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (long j10 : jArr) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (function1 != null) {
                a10.append((CharSequence) function1.invoke(Long.valueOf(j10)));
            } else {
                a10.append(String.valueOf(j10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    public static final <T, A extends Appendable> A O(T[] tArr, A a10, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        j.g(tArr, "<this>");
        j.g(a10, "buffer");
        j.g(charSequence, "separator");
        j.g(charSequence2, "prefix");
        j.g(charSequence3, "postfix");
        j.g(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (T t10 : tArr) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            k.a(a10, t10, function1);
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    public static final <A extends Appendable> A P(short[] sArr, A a10, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1<? super Short, ? extends CharSequence> function1) {
        j.g(sArr, "<this>");
        j.g(a10, "buffer");
        j.g(charSequence, "separator");
        j.g(charSequence2, "prefix");
        j.g(charSequence3, "postfix");
        j.g(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (short s10 : sArr) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (function1 != null) {
                a10.append((CharSequence) function1.invoke(Short.valueOf(s10)));
            } else {
                a10.append(String.valueOf(s10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    public static final String Q(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1<? super Byte, ? extends CharSequence> function1) {
        j.g(bArr, "<this>");
        j.g(charSequence, "separator");
        j.g(charSequence2, "prefix");
        j.g(charSequence3, "postfix");
        j.g(charSequence4, "truncated");
        String sb2 = ((StringBuilder) J(bArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, function1)).toString();
        j.f(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static final String R(double[] dArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1<? super Double, ? extends CharSequence> function1) {
        j.g(dArr, "<this>");
        j.g(charSequence, "separator");
        j.g(charSequence2, "prefix");
        j.g(charSequence3, "postfix");
        j.g(charSequence4, "truncated");
        String sb2 = ((StringBuilder) K(dArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, function1)).toString();
        j.f(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static final String S(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1<? super Float, ? extends CharSequence> function1) {
        j.g(fArr, "<this>");
        j.g(charSequence, "separator");
        j.g(charSequence2, "prefix");
        j.g(charSequence3, "postfix");
        j.g(charSequence4, "truncated");
        String sb2 = ((StringBuilder) L(fArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, function1)).toString();
        j.f(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static final String T(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1<? super Integer, ? extends CharSequence> function1) {
        j.g(iArr, "<this>");
        j.g(charSequence, "separator");
        j.g(charSequence2, "prefix");
        j.g(charSequence3, "postfix");
        j.g(charSequence4, "truncated");
        String sb2 = ((StringBuilder) M(iArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, function1)).toString();
        j.f(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static final String U(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1<? super Long, ? extends CharSequence> function1) {
        j.g(jArr, "<this>");
        j.g(charSequence, "separator");
        j.g(charSequence2, "prefix");
        j.g(charSequence3, "postfix");
        j.g(charSequence4, "truncated");
        String sb2 = ((StringBuilder) N(jArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, function1)).toString();
        j.f(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static final <T> String V(T[] tArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        j.g(tArr, "<this>");
        j.g(charSequence, "separator");
        j.g(charSequence2, "prefix");
        j.g(charSequence3, "postfix");
        j.g(charSequence4, "truncated");
        String sb2 = ((StringBuilder) O(tArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, function1)).toString();
        j.f(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static final String W(short[] sArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1<? super Short, ? extends CharSequence> function1) {
        j.g(sArr, "<this>");
        j.g(charSequence, "separator");
        j.g(charSequence2, "prefix");
        j.g(charSequence3, "postfix");
        j.g(charSequence4, "truncated");
        String sb2 = ((StringBuilder) P(sArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, function1)).toString();
        j.f(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static /* synthetic */ String X(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i11 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i11 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            function1 = null;
        }
        return Q(bArr, charSequence, charSequence6, charSequence5, i12, charSequence7, function1);
    }

    public static /* synthetic */ String Y(double[] dArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i11 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i11 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            function1 = null;
        }
        return R(dArr, charSequence, charSequence6, charSequence5, i12, charSequence7, function1);
    }

    public static /* synthetic */ String Z(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i11 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i11 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            function1 = null;
        }
        return S(fArr, charSequence, charSequence6, charSequence5, i12, charSequence7, function1);
    }

    public static /* synthetic */ String a0(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i11 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i11 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            function1 = null;
        }
        return T(iArr, charSequence, charSequence6, charSequence5, i12, charSequence7, function1);
    }

    public static /* synthetic */ String b0(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i11 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i11 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            function1 = null;
        }
        return U(jArr, charSequence, charSequence6, charSequence5, i12, charSequence7, function1);
    }

    public static /* synthetic */ String c0(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i11 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i11 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            function1 = null;
        }
        return V(objArr, charSequence, charSequence6, charSequence5, i12, charSequence7, function1);
    }

    public static /* synthetic */ String d0(short[] sArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i11 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i11 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            function1 = null;
        }
        return W(sArr, charSequence, charSequence6, charSequence5, i12, charSequence7, function1);
    }

    public static char e0(char[] cArr) {
        j.g(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static <T> T f0(T[] tArr) {
        j.g(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static int g0(int[] iArr) {
        j.g(iArr, "<this>");
        int i10 = 0;
        for (int i11 : iArr) {
            i10 += i11;
        }
        return i10;
    }

    public static final <T> List<T> h0(T[] tArr, int i10) {
        boolean z10;
        j.g(tArr, "<this>");
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        } else if (i10 == 0) {
            return q.j();
        } else {
            int length = tArr.length;
            if (i10 >= length) {
                return p0(tArr);
            }
            if (i10 == 1) {
                return p.e(tArr[length - 1]);
            }
            ArrayList arrayList = new ArrayList(i10);
            for (int i11 = length - i10; i11 < length; i11++) {
                arrayList.add(tArr[i11]);
            }
            return arrayList;
        }
    }

    public static final <T, C extends Collection<? super T>> C i0(T[] tArr, C c10) {
        j.g(tArr, "<this>");
        j.g(c10, "destination");
        for (T add : tArr) {
            c10.add(add);
        }
        return c10;
    }

    public static <T> HashSet<T> j0(T[] tArr) {
        j.g(tArr, "<this>");
        return (HashSet) i0(tArr, new HashSet(g0.e(tArr.length)));
    }

    public static List<Byte> k0(byte[] bArr) {
        j.g(bArr, "<this>");
        int length = bArr.length;
        if (length == 0) {
            return q.j();
        }
        if (length != 1) {
            return r0(bArr);
        }
        return p.e(Byte.valueOf(bArr[0]));
    }

    public static List<Double> l0(double[] dArr) {
        j.g(dArr, "<this>");
        int length = dArr.length;
        if (length == 0) {
            return q.j();
        }
        if (length != 1) {
            return s0(dArr);
        }
        return p.e(Double.valueOf(dArr[0]));
    }

    public static List<Float> m0(float[] fArr) {
        j.g(fArr, "<this>");
        int length = fArr.length;
        if (length == 0) {
            return q.j();
        }
        if (length != 1) {
            return t0(fArr);
        }
        return p.e(Float.valueOf(fArr[0]));
    }

    public static List<Integer> n0(int[] iArr) {
        j.g(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            return q.j();
        }
        if (length != 1) {
            return u0(iArr);
        }
        return p.e(Integer.valueOf(iArr[0]));
    }

    public static List<Long> o0(long[] jArr) {
        j.g(jArr, "<this>");
        int length = jArr.length;
        if (length == 0) {
            return q.j();
        }
        if (length != 1) {
            return v0(jArr);
        }
        return p.e(Long.valueOf(jArr[0]));
    }

    public static <T> List<T> p0(T[] tArr) {
        j.g(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            return q.j();
        }
        if (length != 1) {
            return w0(tArr);
        }
        return p.e(tArr[0]);
    }

    public static <T> Iterable<T> q(T[] tArr) {
        boolean z10;
        j.g(tArr, "<this>");
        if (tArr.length == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return q.j();
        }
        return new a(tArr);
    }

    public static List<Short> q0(short[] sArr) {
        j.g(sArr, "<this>");
        int length = sArr.length;
        if (length == 0) {
            return q.j();
        }
        if (length != 1) {
            return x0(sArr);
        }
        return p.e(Short.valueOf(sArr[0]));
    }

    public static boolean r(byte[] bArr, byte b10) {
        j.g(bArr, "<this>");
        return D(bArr, b10) >= 0;
    }

    public static final List<Byte> r0(byte[] bArr) {
        j.g(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte valueOf : bArr) {
            arrayList.add(Byte.valueOf(valueOf));
        }
        return arrayList;
    }

    public static boolean s(char[] cArr, char c10) {
        j.g(cArr, "<this>");
        return E(cArr, c10) >= 0;
    }

    public static final List<Double> s0(double[] dArr) {
        j.g(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double valueOf : dArr) {
            arrayList.add(Double.valueOf(valueOf));
        }
        return arrayList;
    }

    public static boolean t(int[] iArr, int i10) {
        j.g(iArr, "<this>");
        return F(iArr, i10) >= 0;
    }

    public static final List<Float> t0(float[] fArr) {
        j.g(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float valueOf : fArr) {
            arrayList.add(Float.valueOf(valueOf));
        }
        return arrayList;
    }

    public static boolean u(long[] jArr, long j10) {
        j.g(jArr, "<this>");
        return G(jArr, j10) >= 0;
    }

    public static final List<Integer> u0(int[] iArr) {
        j.g(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        return arrayList;
    }

    public static <T> boolean v(T[] tArr, T t10) {
        j.g(tArr, "<this>");
        return H(tArr, t10) >= 0;
    }

    public static final List<Long> v0(long[] jArr) {
        j.g(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long valueOf : jArr) {
            arrayList.add(Long.valueOf(valueOf));
        }
        return arrayList;
    }

    public static boolean w(short[] sArr, short s10) {
        j.g(sArr, "<this>");
        return I(sArr, s10) >= 0;
    }

    public static <T> List<T> w0(T[] tArr) {
        j.g(tArr, "<this>");
        return new ArrayList(q.g(tArr));
    }

    public static <T> List<T> x(T[] tArr, int i10) {
        boolean z10;
        j.g(tArr, "<this>");
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return h0(tArr, j.c(tArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static final List<Short> x0(short[] sArr) {
        j.g(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short valueOf : sArr) {
            arrayList.add(Short.valueOf(valueOf));
        }
        return arrayList;
    }

    public static <T> List<T> y(T[] tArr) {
        j.g(tArr, "<this>");
        return (List) z(tArr, new ArrayList());
    }

    public static final <T> Set<T> y0(T[] tArr) {
        j.g(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            return n0.e();
        }
        if (length != 1) {
            return (Set) i0(tArr, new LinkedHashSet(g0.e(tArr.length)));
        }
        return m0.d(tArr[0]);
    }

    public static final <C extends Collection<? super T>, T> C z(T[] tArr, C c10) {
        j.g(tArr, "<this>");
        j.g(c10, "destination");
        for (T t10 : tArr) {
            if (t10 != null) {
                c10.add(t10);
            }
        }
        return c10;
    }
}
