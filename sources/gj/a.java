package gj;

import java.net.URLEncoder;
import kotlin.text.d;
import ml.b;
import wn.m;

public final class a implements b, m {

    /* renamed from: a  reason: collision with root package name */
    public static final a f29686a = new a();

    private a() {
    }

    public String a(Object obj) {
        return m.a.a(this, obj);
    }

    public Object f(Object obj, Object obj2) {
        String a10 = a(obj);
        if (a10 != null) {
            return URLEncoder.encode(a10, d.f32216b.name());
        }
        return null;
    }
}
