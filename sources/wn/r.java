package wn;

import java.util.Locale;
import kotlin.jvm.internal.j;
import ml.b;
import wn.m;

public final class r implements b, m {

    /* renamed from: a  reason: collision with root package name */
    public static final r f42509a = new r();

    private r() {
    }

    public String a(Object obj) {
        return m.a.a(this, obj);
    }

    public Object f(Object obj, Object obj2) {
        String a10 = a(obj);
        if (a10 == null) {
            return null;
        }
        String upperCase = a10.toUpperCase(Locale.ROOT);
        j.f(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase;
    }
}
