package com.withpersona.sdk2.inquiry.governmentid;

import kotlin.jvm.internal.j;

public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    public static final g0 f25778a = new g0();

    private g0() {
    }

    public final String a(String str) {
        boolean z10;
        j.g(str, "passportNumber");
        for (int V = StringsKt__StringsKt.V(str); -1 < V; V--) {
            if (str.charAt(V) == '<') {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                String substring = str.substring(0, V + 1);
                j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return "";
    }
}
