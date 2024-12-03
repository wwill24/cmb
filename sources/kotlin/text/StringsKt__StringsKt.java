package kotlin.text;

import gk.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.b0;
import kotlin.jvm.internal.j;
import kotlin.ranges.IntRange;
import kotlin.ranges.a;
import kotlin.sequences.Sequence;

class StringsKt__StringsKt extends r {
    private static final List<String> A0(CharSequence charSequence, String str, boolean z10, int i10) {
        boolean z11;
        x0(i10);
        int i11 = 0;
        int X = X(charSequence, str, 0, z10);
        if (X == -1 || i10 == 1) {
            return p.e(charSequence.toString());
        }
        if (i10 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        int i12 = 10;
        if (z11) {
            i12 = j.g(i10, 10);
        }
        ArrayList arrayList = new ArrayList(i12);
        do {
            arrayList.add(charSequence.subSequence(i11, X).toString());
            i11 = str.length() + X;
            if ((z11 && arrayList.size() == i10 - 1) || (X = X(charSequence, str, i11, z10)) == -1) {
                arrayList.add(charSequence.subSequence(i11, charSequence.length()).toString());
            }
            arrayList.add(charSequence.subSequence(i11, X).toString());
            i11 = str.length() + X;
            break;
        } while ((X = X(charSequence, str, i11, z10)) == -1);
        arrayList.add(charSequence.subSequence(i11, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List B0(CharSequence charSequence, char[] cArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return y0(charSequence, cArr, z10, i10);
    }

    public static /* synthetic */ List C0(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return z0(charSequence, strArr, z10, i10);
    }

    public static final Sequence<String> D0(CharSequence charSequence, String[] strArr, boolean z10, int i10) {
        j.g(charSequence, "<this>");
        j.g(strArr, "delimiters");
        return SequencesKt___SequencesKt.q(s0(charSequence, strArr, 0, z10, i10, 2, (Object) null), new StringsKt__StringsKt$splitToSequence$1(charSequence));
    }

    public static /* synthetic */ Sequence E0(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return D0(charSequence, strArr, z10, i10);
    }

    public static final boolean F0(CharSequence charSequence, char c10, boolean z10) {
        j.g(charSequence, "<this>");
        return charSequence.length() > 0 && c.e(charSequence.charAt(0), c10, z10);
    }

    public static final boolean G0(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        j.g(charSequence, "<this>");
        j.g(charSequence2, "prefix");
        if (!z10 && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return r.J((String) charSequence, (String) charSequence2, false, 2, (Object) null);
        }
        return t0(charSequence, 0, charSequence2, 0, charSequence2.length(), z10);
    }

    public static /* synthetic */ boolean H0(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return F0(charSequence, c10, z10);
    }

    public static /* synthetic */ boolean I0(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return G0(charSequence, charSequence2, z10);
    }

    public static final String J0(CharSequence charSequence, IntRange intRange) {
        j.g(charSequence, "<this>");
        j.g(intRange, "range");
        return charSequence.subSequence(intRange.o().intValue(), intRange.n().intValue() + 1).toString();
    }

    public static final String K0(String str, char c10, String str2) {
        j.g(str, "<this>");
        j.g(str2, "missingDelimiterValue");
        int a02 = a0(str, c10, 0, false, 6, (Object) null);
        if (a02 == -1) {
            return str2;
        }
        String substring = str.substring(a02 + 1, str.length());
        j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean L(CharSequence charSequence, char c10, boolean z10) {
        j.g(charSequence, "<this>");
        return a0(charSequence, c10, 0, z10, 2, (Object) null) >= 0;
    }

    public static final String L0(String str, String str2, String str3) {
        j.g(str, "<this>");
        j.g(str2, "delimiter");
        j.g(str3, "missingDelimiterValue");
        int b02 = b0(str, str2, 0, false, 6, (Object) null);
        if (b02 == -1) {
            return str3;
        }
        String substring = str.substring(b02 + str2.length(), str.length());
        j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean M(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        j.g(charSequence, "<this>");
        j.g(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (b0(charSequence, (String) charSequence2, 0, z10, 2, (Object) null) >= 0) {
                return true;
            }
        } else {
            if (Z(charSequence, charSequence2, 0, charSequence.length(), z10, false, 16, (Object) null) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ String M0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return K0(str, c10, str2);
    }

    public static /* synthetic */ boolean N(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return L(charSequence, c10, z10);
    }

    public static /* synthetic */ String N0(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return L0(str, str2, str3);
    }

    public static /* synthetic */ boolean O(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return M(charSequence, charSequence2, z10);
    }

    public static String O0(String str, char c10, String str2) {
        j.g(str, "<this>");
        j.g(str2, "missingDelimiterValue");
        int f02 = f0(str, c10, 0, false, 6, (Object) null);
        if (f02 == -1) {
            return str2;
        }
        String substring = str.substring(f02 + 1, str.length());
        j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean P(CharSequence charSequence, char c10, boolean z10) {
        j.g(charSequence, "<this>");
        return charSequence.length() > 0 && c.e(charSequence.charAt(V(charSequence)), c10, z10);
    }

    public static /* synthetic */ String P0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return O0(str, c10, str2);
    }

    public static final boolean Q(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        j.g(charSequence, "<this>");
        j.g(charSequence2, "suffix");
        if (!z10 && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return r.s((String) charSequence, (String) charSequence2, false, 2, (Object) null);
        }
        return t0(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z10);
    }

    public static final String Q0(String str, char c10, String str2) {
        j.g(str, "<this>");
        j.g(str2, "missingDelimiterValue");
        int a02 = a0(str, c10, 0, false, 6, (Object) null);
        if (a02 == -1) {
            return str2;
        }
        String substring = str.substring(0, a02);
        j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ boolean R(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return P(charSequence, c10, z10);
    }

    public static final String R0(String str, String str2, String str3) {
        j.g(str, "<this>");
        j.g(str2, "delimiter");
        j.g(str3, "missingDelimiterValue");
        int b02 = b0(str, str2, 0, false, 6, (Object) null);
        if (b02 == -1) {
            return str3;
        }
        String substring = str.substring(0, b02);
        j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ boolean S(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return Q(charSequence, charSequence2, z10);
    }

    public static /* synthetic */ String S0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return Q0(str, c10, str2);
    }

    /* access modifiers changed from: private */
    public static final Pair<Integer, String> T(CharSequence charSequence, Collection<String> collection, int i10, boolean z10, boolean z11) {
        a aVar;
        T t10;
        T t11;
        int i11;
        if (z10 || collection.size() != 1) {
            if (!z11) {
                aVar = new IntRange(j.c(i10, 0), charSequence.length());
            } else {
                aVar = j.l(j.g(i10, V(charSequence)), 0);
            }
            if (charSequence instanceof String) {
                int b10 = aVar.b();
                int d10 = aVar.d();
                int f10 = aVar.f();
                if ((f10 > 0 && b10 <= d10) || (f10 < 0 && d10 <= b10)) {
                    while (true) {
                        Iterator<T> it = collection.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                t11 = null;
                                break;
                            }
                            t11 = it.next();
                            String str = (String) t11;
                            if (r.x(str, 0, (String) charSequence, b10, str.length(), z10)) {
                                break;
                            }
                        }
                        String str2 = (String) t11;
                        if (str2 == null) {
                            if (b10 == d10) {
                                break;
                            }
                            b10 += f10;
                        } else {
                            return h.a(Integer.valueOf(b10), str2);
                        }
                    }
                }
            } else {
                int b11 = aVar.b();
                int d11 = aVar.d();
                int f11 = aVar.f();
                if ((f11 > 0 && b11 <= d11) || (f11 < 0 && d11 <= b11)) {
                    while (true) {
                        Iterator<T> it2 = collection.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                t10 = null;
                                break;
                            }
                            t10 = it2.next();
                            String str3 = (String) t10;
                            if (t0(str3, 0, charSequence, b11, str3.length(), z10)) {
                                break;
                            }
                        }
                        String str4 = (String) t10;
                        if (str4 == null) {
                            if (b11 == d11) {
                                break;
                            }
                            b11 += f11;
                        } else {
                            return h.a(Integer.valueOf(b11), str4);
                        }
                    }
                }
            }
            return null;
        }
        String str5 = (String) CollectionsKt___CollectionsKt.l0(collection);
        CharSequence charSequence2 = charSequence;
        String str6 = str5;
        int i12 = i10;
        if (!z11) {
            i11 = b0(charSequence2, str6, i12, false, 4, (Object) null);
        } else {
            i11 = g0(charSequence2, str6, i12, false, 4, (Object) null);
        }
        if (i11 < 0) {
            return null;
        }
        return h.a(Integer.valueOf(i11), str5);
    }

    public static /* synthetic */ String T0(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return R0(str, str2, str3);
    }

    public static final IntRange U(CharSequence charSequence) {
        j.g(charSequence, "<this>");
        return new IntRange(0, charSequence.length() - 1);
    }

    public static final String U0(String str, char c10, String str2) {
        j.g(str, "<this>");
        j.g(str2, "missingDelimiterValue");
        int f02 = f0(str, c10, 0, false, 6, (Object) null);
        if (f02 == -1) {
            return str2;
        }
        String substring = str.substring(0, f02);
        j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static int V(CharSequence charSequence) {
        j.g(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static /* synthetic */ String V0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return U0(str, c10, str2);
    }

    public static final int W(CharSequence charSequence, char c10, int i10, boolean z10) {
        j.g(charSequence, "<this>");
        if (!z10 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c10, i10);
        }
        return c0(charSequence, new char[]{c10}, i10, z10);
    }

    public static CharSequence W0(CharSequence charSequence) {
        int i10;
        j.g(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i11 = 0;
        boolean z10 = false;
        while (i11 <= length) {
            if (!z10) {
                i10 = i11;
            } else {
                i10 = length;
            }
            boolean c10 = b.c(charSequence.charAt(i10));
            if (!z10) {
                if (!c10) {
                    z10 = true;
                } else {
                    i11++;
                }
            } else if (!c10) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i11, length + 1);
    }

    public static final int X(CharSequence charSequence, String str, int i10, boolean z10) {
        j.g(charSequence, "<this>");
        j.g(str, "string");
        if (!z10 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i10);
        }
        return Z(charSequence, str, i10, charSequence.length(), z10, false, 16, (Object) null);
    }

    public static String X0(String str, char... cArr) {
        int i10;
        j.g(str, "<this>");
        j.g(cArr, "chars");
        int length = str.length() - 1;
        int i11 = 0;
        boolean z10 = false;
        while (i11 <= length) {
            if (!z10) {
                i10 = i11;
            } else {
                i10 = length;
            }
            boolean s10 = l.s(cArr, str.charAt(i10));
            if (!z10) {
                if (!s10) {
                    z10 = true;
                } else {
                    i11++;
                }
            } else if (!s10) {
                break;
            } else {
                length--;
            }
        }
        return str.subSequence(i11, length + 1).toString();
    }

    private static final int Y(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11) {
        a aVar;
        if (!z11) {
            aVar = new IntRange(j.c(i10, 0), j.g(i11, charSequence.length()));
        } else {
            aVar = j.l(j.g(i10, V(charSequence)), j.c(i11, 0));
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int b10 = aVar.b();
            int d10 = aVar.d();
            int f10 = aVar.f();
            if ((f10 <= 0 || b10 > d10) && (f10 >= 0 || d10 > b10)) {
                return -1;
            }
            while (true) {
                if (t0(charSequence2, 0, charSequence, b10, charSequence2.length(), z10)) {
                    return b10;
                }
                if (b10 == d10) {
                    return -1;
                }
                b10 += f10;
            }
        } else {
            int b11 = aVar.b();
            int d11 = aVar.d();
            int f11 = aVar.f();
            if ((f11 <= 0 || b11 > d11) && (f11 >= 0 || d11 > b11)) {
                return -1;
            }
            while (true) {
                if (r.x((String) charSequence2, 0, (String) charSequence, b11, charSequence2.length(), z10)) {
                    return b11;
                }
                if (b11 == d11) {
                    return -1;
                }
                b11 += f11;
            }
        }
    }

    public static String Y0(String str, char... cArr) {
        Object obj;
        j.g(str, "<this>");
        j.g(cArr, "chars");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (!l.s(cArr, str.charAt(length))) {
                    obj = str.subSequence(0, length + 1);
                    break;
                } else if (i10 < 0) {
                    break;
                } else {
                    length = i10;
                }
            }
            return obj.toString();
        }
        obj = "";
        return obj.toString();
    }

    static /* synthetic */ int Z(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            z11 = false;
        }
        return Y(charSequence, charSequence2, i10, i11, z10, z11);
    }

    public static String Z0(String str, char... cArr) {
        Object obj;
        j.g(str, "<this>");
        j.g(cArr, "chars");
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                obj = "";
                break;
            } else if (!l.s(cArr, str.charAt(i10))) {
                obj = str.subSequence(i10, str.length());
                break;
            } else {
                i10++;
            }
        }
        return obj.toString();
    }

    public static /* synthetic */ int a0(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return W(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int b0(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return X(charSequence, str, i10, z10);
    }

    public static final int c0(CharSequence charSequence, char[] cArr, int i10, boolean z10) {
        boolean z11;
        j.g(charSequence, "<this>");
        j.g(cArr, "chars");
        if (z10 || cArr.length != 1 || !(charSequence instanceof String)) {
            b0 g10 = new IntRange(j.c(i10, 0), V(charSequence)).iterator();
            while (g10.hasNext()) {
                int nextInt = g10.nextInt();
                char charAt = charSequence.charAt(nextInt);
                int length = cArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        z11 = false;
                        continue;
                        break;
                    } else if (c.e(cArr[i11], charAt, z10)) {
                        z11 = true;
                        continue;
                        break;
                    } else {
                        i11++;
                    }
                }
                if (z11) {
                    return nextInt;
                }
            }
            return -1;
        }
        return ((String) charSequence).indexOf(l.e0(cArr), i10);
    }

    public static final int d0(CharSequence charSequence, char c10, int i10, boolean z10) {
        j.g(charSequence, "<this>");
        if (!z10 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c10, i10);
        }
        return h0(charSequence, new char[]{c10}, i10, z10);
    }

    public static final int e0(CharSequence charSequence, String str, int i10, boolean z10) {
        j.g(charSequence, "<this>");
        j.g(str, "string");
        if (z10 || !(charSequence instanceof String)) {
            return Y(charSequence, str, i10, 0, z10, true);
        }
        return ((String) charSequence).lastIndexOf(str, i10);
    }

    public static /* synthetic */ int f0(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = V(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return d0(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int g0(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = V(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return e0(charSequence, str, i10, z10);
    }

    public static final int h0(CharSequence charSequence, char[] cArr, int i10, boolean z10) {
        j.g(charSequence, "<this>");
        j.g(cArr, "chars");
        if (z10 || cArr.length != 1 || !(charSequence instanceof String)) {
            for (int g10 = j.g(i10, V(charSequence)); -1 < g10; g10--) {
                char charAt = charSequence.charAt(g10);
                int length = cArr.length;
                boolean z11 = false;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    } else if (c.e(cArr[i11], charAt, z10)) {
                        z11 = true;
                        break;
                    } else {
                        i11++;
                    }
                }
                if (z11) {
                    return g10;
                }
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(l.e0(cArr), i10);
    }

    public static final Sequence<String> i0(CharSequence charSequence) {
        j.g(charSequence, "<this>");
        return E0(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, (Object) null);
    }

    public static final List<String> j0(CharSequence charSequence) {
        j.g(charSequence, "<this>");
        return SequencesKt___SequencesKt.t(i0(charSequence));
    }

    public static final CharSequence k0(CharSequence charSequence, int i10, char c10) {
        j.g(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException("Desired length " + i10 + " is less than zero.");
        } else if (i10 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb2 = new StringBuilder(i10);
            sb2.append(charSequence);
            b0 g10 = new IntRange(1, i10 - charSequence.length()).iterator();
            while (g10.hasNext()) {
                g10.nextInt();
                sb2.append(c10);
            }
            return sb2;
        }
    }

    public static final String l0(String str, int i10, char c10) {
        j.g(str, "<this>");
        return k0(str, i10, c10).toString();
    }

    public static /* synthetic */ String m0(String str, int i10, char c10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            c10 = ' ';
        }
        return l0(str, i10, c10);
    }

    public static final CharSequence n0(CharSequence charSequence, int i10, char c10) {
        j.g(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException("Desired length " + i10 + " is less than zero.");
        } else if (i10 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb2 = new StringBuilder(i10);
            b0 g10 = new IntRange(1, i10 - charSequence.length()).iterator();
            while (g10.hasNext()) {
                g10.nextInt();
                sb2.append(c10);
            }
            sb2.append(charSequence);
            return sb2;
        }
    }

    public static String o0(String str, int i10, char c10) {
        j.g(str, "<this>");
        return n0(str, i10, c10).toString();
    }

    private static final Sequence<IntRange> p0(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11) {
        x0(i11);
        return new e(charSequence, i10, i11, new StringsKt__StringsKt$rangesDelimitedBy$1(cArr, z10));
    }

    private static final Sequence<IntRange> q0(CharSequence charSequence, String[] strArr, int i10, boolean z10, int i11) {
        x0(i11);
        return new e(charSequence, i10, i11, new StringsKt__StringsKt$rangesDelimitedBy$2(k.e(strArr), z10));
    }

    static /* synthetic */ Sequence r0(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return p0(charSequence, cArr, i10, z10, i11);
    }

    static /* synthetic */ Sequence s0(CharSequence charSequence, String[] strArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return q0(charSequence, strArr, i10, z10, i11);
    }

    public static final boolean t0(CharSequence charSequence, int i10, CharSequence charSequence2, int i11, int i12, boolean z10) {
        j.g(charSequence, "<this>");
        j.g(charSequence2, "other");
        if (i11 < 0 || i10 < 0 || i10 > charSequence.length() - i12 || i11 > charSequence2.length() - i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (!c.e(charSequence.charAt(i10 + i13), charSequence2.charAt(i11 + i13), z10)) {
                return false;
            }
        }
        return true;
    }

    public static String u0(String str, CharSequence charSequence) {
        j.g(str, "<this>");
        j.g(charSequence, "prefix");
        if (!I0(str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length());
        j.f(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static String v0(String str, CharSequence charSequence) {
        j.g(str, "<this>");
        j.g(charSequence, "suffix");
        if (!S(str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(0, str.length() - charSequence.length());
        j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final CharSequence w0(CharSequence charSequence, int i10, int i11, CharSequence charSequence2) {
        j.g(charSequence, "<this>");
        j.g(charSequence2, "replacement");
        if (i11 >= i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(charSequence, 0, i10);
            j.f(sb2, "this.append(value, startIndex, endIndex)");
            sb2.append(charSequence2);
            sb2.append(charSequence, i11, charSequence.length());
            j.f(sb2, "this.append(value, startIndex, endIndex)");
            return sb2;
        }
        throw new IndexOutOfBoundsException("End index (" + i11 + ") is less than start index (" + i10 + ").");
    }

    public static final void x0(int i10) {
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i10).toString());
        }
    }

    public static final List<String> y0(CharSequence charSequence, char[] cArr, boolean z10, int i10) {
        j.g(charSequence, "<this>");
        j.g(cArr, "delimiters");
        if (cArr.length == 1) {
            return A0(charSequence, String.valueOf(cArr[0]), z10, i10);
        }
        Iterable<IntRange> g10 = SequencesKt___SequencesKt.g(r0(charSequence, cArr, 0, z10, i10, 2, (Object) null));
        ArrayList arrayList = new ArrayList(r.t(g10, 10));
        for (IntRange J0 : g10) {
            arrayList.add(J0(charSequence, J0));
        }
        return arrayList;
    }

    public static final List<String> z0(CharSequence charSequence, String[] strArr, boolean z10, int i10) {
        j.g(charSequence, "<this>");
        j.g(strArr, "delimiters");
        boolean z11 = true;
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                z11 = false;
            }
            if (!z11) {
                return A0(charSequence, str, z10, i10);
            }
        }
        Iterable<IntRange> g10 = SequencesKt___SequencesKt.g(s0(charSequence, strArr, 0, z10, i10, 2, (Object) null));
        ArrayList arrayList = new ArrayList(r.t(g10, 10));
        for (IntRange J0 : g10) {
            arrayList.add(J0(charSequence, J0));
        }
        return arrayList;
    }
}
