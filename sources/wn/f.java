package wn;

import java.util.Locale;
import kotlin.jvm.internal.j;
import ml.b;
import wn.m;

public final class f implements b, m {

    /* renamed from: a  reason: collision with root package name */
    public static final f f42491a = new f();

    private f() {
    }

    public String a(Object obj) {
        return m.a.a(this, obj);
    }

    public Object f(Object obj, Object obj2) {
        String a10 = a(obj);
        if (a10 == null) {
            return null;
        }
        String lowerCase = a10.toLowerCase(Locale.ROOT);
        j.f(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }
}
