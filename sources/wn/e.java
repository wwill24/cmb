package wn;

import ml.b;
import wn.m;

public final class e implements b, m {

    /* renamed from: a  reason: collision with root package name */
    public static final e f42490a = new e();

    private e() {
    }

    public String a(Object obj) {
        return m.a.a(this, obj);
    }

    public Object f(Object obj, Object obj2) {
        String a10 = a(obj);
        if (a10 != null) {
            return Integer.valueOf(a10.length());
        }
        return null;
    }
}
