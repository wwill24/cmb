package kotlin.text;

import com.leanplum.internal.Constants;
import java.util.Comparator;
import java.util.Locale;
import kotlin.collections.b;
import kotlin.collections.b0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import kotlin.ranges.IntRange;

class r extends q {
    public static final String A(String str, char c10, char c11, boolean z10) {
        j.g(str, "<this>");
        if (!z10) {
            String replace = str.replace(c10, c11);
            j.f(replace, "this as java.lang.String…replace(oldChar, newChar)");
            return replace;
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (c.e(charAt, c10, z10)) {
                charAt = c11;
            }
            sb2.append(charAt);
        }
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    public static final String B(String str, String str2, String str3, boolean z10) {
        j.g(str, "<this>");
        j.g(str2, "oldValue");
        j.g(str3, "newValue");
        int i10 = 0;
        int X = StringsKt__StringsKt.X(str, str2, 0, z10);
        if (X < 0) {
            return str;
        }
        int length = str2.length();
        int c10 = j.c(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 >= 0) {
            StringBuilder sb2 = new StringBuilder(length2);
            do {
                sb2.append(str, i10, X);
                sb2.append(str3);
                i10 = X + length;
                if (X >= str.length() || (X = StringsKt__StringsKt.X(str, str2, X + c10, z10)) <= 0) {
                    sb2.append(str, i10, str.length());
                    String sb3 = sb2.toString();
                    j.f(sb3, "stringBuilder.append(this, i, length).toString()");
                }
                sb2.append(str, i10, X);
                sb2.append(str3);
                i10 = X + length;
                break;
            } while ((X = StringsKt__StringsKt.X(str, str2, X + c10, z10)) <= 0);
            sb2.append(str, i10, str.length());
            String sb32 = sb2.toString();
            j.f(sb32, "stringBuilder.append(this, i, length).toString()");
            return sb32;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String C(String str, char c10, char c11, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return A(str, c10, c11, z10);
    }

    public static /* synthetic */ String D(String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return B(str, str2, str3, z10);
    }

    public static final String E(String str, String str2, String str3, boolean z10) {
        j.g(str, "<this>");
        j.g(str2, "oldValue");
        j.g(str3, "newValue");
        int b02 = StringsKt__StringsKt.b0(str, str2, 0, z10, 2, (Object) null);
        if (b02 < 0) {
            return str;
        }
        return StringsKt__StringsKt.w0(str, b02, str2.length() + b02, str3).toString();
    }

    public static /* synthetic */ String F(String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return E(str, str2, str3, z10);
    }

    public static boolean G(String str, String str2, int i10, boolean z10) {
        j.g(str, "<this>");
        j.g(str2, "prefix");
        if (!z10) {
            return str.startsWith(str2, i10);
        }
        return x(str, i10, str2, 0, str2.length(), z10);
    }

    public static boolean H(String str, String str2, boolean z10) {
        j.g(str, "<this>");
        j.g(str2, "prefix");
        if (!z10) {
            return str.startsWith(str2);
        }
        return x(str, 0, str2, 0, str2.length(), z10);
    }

    public static /* synthetic */ boolean I(String str, String str2, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return G(str, str2, i10, z10);
    }

    public static /* synthetic */ boolean J(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return H(str, str2, z10);
    }

    public static String n(String str) {
        j.g(str, "<this>");
        Locale locale = Locale.getDefault();
        j.f(locale, "getDefault()");
        return o(str, locale);
    }

    public static final String o(String str, Locale locale) {
        boolean z10;
        j.g(str, "<this>");
        j.g(locale, Constants.Keys.LOCALE);
        if (str.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return str;
        }
        char charAt = str.charAt(0);
        if (!Character.isLowerCase(charAt)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        char titleCase = Character.toTitleCase(charAt);
        if (titleCase != Character.toUpperCase(charAt)) {
            sb2.append(titleCase);
        } else {
            String substring = str.substring(0, 1);
            j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            j.e(substring, "null cannot be cast to non-null type java.lang.String");
            String upperCase = substring.toUpperCase(locale);
            j.f(upperCase, "this as java.lang.String).toUpperCase(locale)");
            sb2.append(upperCase);
        }
        String substring2 = str.substring(1);
        j.f(substring2, "this as java.lang.String).substring(startIndex)");
        sb2.append(substring2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public static String p(char[] cArr) {
        j.g(cArr, "<this>");
        return new String(cArr);
    }

    public static String q(char[] cArr, int i10, int i11) {
        j.g(cArr, "<this>");
        b.f32031a.a(i10, i11, cArr.length);
        return new String(cArr, i10, i11 - i10);
    }

    public static boolean r(String str, String str2, boolean z10) {
        j.g(str, "<this>");
        j.g(str2, "suffix");
        if (!z10) {
            return str.endsWith(str2);
        }
        return x(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean s(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return r(str, str2, z10);
    }

    public static boolean t(String str, String str2, boolean z10) {
        if (str == null) {
            if (str2 == null) {
                return true;
            }
            return false;
        } else if (!z10) {
            return str.equals(str2);
        } else {
            return str.equalsIgnoreCase(str2);
        }
    }

    public static /* synthetic */ boolean u(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return t(str, str2, z10);
    }

    public static Comparator<String> v(o oVar) {
        j.g(oVar, "<this>");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        j.f(comparator, "CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean w(java.lang.CharSequence r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.j.g(r4, r0)
            int r0 = r4.length()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x003e
            kotlin.ranges.IntRange r0 = kotlin.text.StringsKt__StringsKt.U(r4)
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L_0x0020
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0020
        L_0x001e:
            r4 = r2
            goto L_0x003c
        L_0x0020:
            java.util.Iterator r0 = r0.iterator()
        L_0x0024:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x001e
            r3 = r0
            kotlin.collections.b0 r3 = (kotlin.collections.b0) r3
            int r3 = r3.nextInt()
            char r3 = r4.charAt(r3)
            boolean r3 = kotlin.text.b.c(r3)
            if (r3 != 0) goto L_0x0024
            r4 = r1
        L_0x003c:
            if (r4 == 0) goto L_0x003f
        L_0x003e:
            r1 = r2
        L_0x003f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.r.w(java.lang.CharSequence):boolean");
    }

    public static final boolean x(String str, int i10, String str2, int i11, int i12, boolean z10) {
        j.g(str, "<this>");
        j.g(str2, "other");
        if (!z10) {
            return str.regionMatches(i10, str2, i11, i12);
        }
        return str.regionMatches(z10, i10, str2, i11, i12);
    }

    public static /* synthetic */ boolean y(String str, int i10, String str2, int i11, int i12, boolean z10, int i13, Object obj) {
        if ((i13 & 16) != 0) {
            z10 = false;
        }
        return x(str, i10, str2, i11, i12, z10);
    }

    public static String z(CharSequence charSequence, int i10) {
        boolean z10;
        j.g(charSequence, "<this>");
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i10 + '.').toString());
        } else if (i10 == 0) {
            return "";
        } else {
            if (i10 == 1) {
                return charSequence.toString();
            }
            int length = charSequence.length();
            if (length == 0) {
                return "";
            }
            if (length != 1) {
                StringBuilder sb2 = new StringBuilder(charSequence.length() * i10);
                b0 g10 = new IntRange(1, i10).iterator();
                while (g10.hasNext()) {
                    g10.nextInt();
                    sb2.append(charSequence);
                }
                String sb3 = sb2.toString();
                j.f(sb3, "{\n                    va…tring()\n                }");
                return sb3;
            }
            char charAt = charSequence.charAt(0);
            char[] cArr = new char[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                cArr[i11] = charAt;
            }
            return new String(cArr);
        }
    }
}
