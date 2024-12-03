package wn;

import java.util.Locale;
import kotlin.jvm.internal.j;
import wn.m;

public final class b implements ml.b, m {

    /* renamed from: a  reason: collision with root package name */
    public static final b f42486a = new b();

    private b() {
    }

    public String a(Object obj) {
        return m.a.a(this, obj);
    }

    public Object f(Object obj, Object obj2) {
        String a10 = a(obj);
        if (a10 == null) {
            return null;
        }
        if (!(a10.length() > 0)) {
            return a10;
        }
        StringBuilder sb2 = new StringBuilder();
        String valueOf = String.valueOf(a10.charAt(0));
        j.e(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(Locale.ROOT);
        j.f(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        sb2.append(upperCase);
        String substring = a10.substring(1);
        j.f(substring, "this as java.lang.String).substring(startIndex)");
        sb2.append(substring);
        return sb2.toString();
    }
}
