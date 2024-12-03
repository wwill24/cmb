package kotlin.text;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

class StringsKt__IndentKt extends k {
    private static final Function1<String, String> b(String str) {
        boolean z10;
        if (str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return StringsKt__IndentKt$getIndentFunction$1.f32214a;
        }
        return new StringsKt__IndentKt$getIndentFunction$2(str);
    }

    private static final int c(String str) {
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            } else if (!b.c(str.charAt(i10))) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 == -1) {
            return str.length();
        }
        return i10;
    }

    public static final String d(String str, String str2) {
        int i10;
        String invoke;
        j.g(str, "<this>");
        j.g(str2, "newIndent");
        List<String> j02 = StringsKt__StringsKt.j0(str);
        ArrayList<String> arrayList = new ArrayList<>();
        for (T next : j02) {
            if (!r.w((String) next)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(r.t(arrayList, 10));
        for (String c10 : arrayList) {
            arrayList2.add(Integer.valueOf(c(c10)));
        }
        Integer num = (Integer) CollectionsKt___CollectionsKt.c0(arrayList2);
        int i11 = 0;
        if (num != null) {
            i10 = num.intValue();
        } else {
            i10 = 0;
        }
        int length = str.length() + (str2.length() * j02.size());
        Function1<String, String> b10 = b(str2);
        int l10 = q.l(j02);
        ArrayList arrayList3 = new ArrayList();
        for (T next2 : j02) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                q.s();
            }
            String str3 = (String) next2;
            if ((i11 == 0 || i11 == l10) && r.w(str3)) {
                str3 = null;
            } else {
                String b12 = t.b1(str3, i10);
                if (!(b12 == null || (invoke = b10.invoke(b12)) == null)) {
                    str3 = invoke;
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i11 = i12;
        }
        String sb2 = ((StringBuilder) CollectionsKt___CollectionsKt.U(arrayList3, new StringBuilder(length), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null)).toString();
        j.f(sb2, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb2;
    }

    public static final String e(String str, String str2, String str3) {
        int i10;
        String invoke;
        j.g(str, "<this>");
        j.g(str2, "newIndent");
        j.g(str3, "marginPrefix");
        if (!r.w(str3)) {
            List<String> j02 = StringsKt__StringsKt.j0(str);
            int length = str.length() + (str2.length() * j02.size());
            Function1<String, String> b10 = b(str2);
            int l10 = q.l(j02);
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            for (T next : j02) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    q.s();
                }
                String str4 = (String) next;
                String str5 = null;
                if ((i11 == 0 || i11 == l10) && r.w(str4)) {
                    str4 = null;
                } else {
                    int length2 = str4.length();
                    int i13 = 0;
                    while (true) {
                        if (i13 >= length2) {
                            i10 = -1;
                            break;
                        } else if (!b.c(str4.charAt(i13))) {
                            i10 = i13;
                            break;
                        } else {
                            i13++;
                        }
                    }
                    if (i10 != -1) {
                        int i14 = i10;
                        if (r.I(str4, str3, i10, false, 4, (Object) null)) {
                            j.e(str4, "null cannot be cast to non-null type java.lang.String");
                            str5 = str4.substring(i14 + str3.length());
                            j.f(str5, "this as java.lang.String).substring(startIndex)");
                        }
                    }
                    if (!(str5 == null || (invoke = b10.invoke(str5)) == null)) {
                        str4 = invoke;
                    }
                }
                if (str4 != null) {
                    arrayList.add(str4);
                }
                i11 = i12;
            }
            String sb2 = ((StringBuilder) CollectionsKt___CollectionsKt.U(arrayList, new StringBuilder(length), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null)).toString();
            j.f(sb2, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
            return sb2;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static String f(String str) {
        j.g(str, "<this>");
        return d(str, "");
    }

    public static final String g(String str, String str2) {
        j.g(str, "<this>");
        j.g(str2, "marginPrefix");
        return e(str, "", str2);
    }

    public static /* synthetic */ String h(String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str2 = "|";
        }
        return g(str, str2);
    }
}
