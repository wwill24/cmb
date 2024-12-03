package md;

import android.content.Context;
import fk.a;
import gd.b;
import gd.d;

public final class h implements b<String> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f41201a;

    public h(a<Context> aVar) {
        this.f41201a = aVar;
    }

    public static h a(a<Context> aVar) {
        return new h(aVar);
    }

    public static String c(Context context) {
        return (String) d.c(f.b(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: b */
    public String get() {
        return c(this.f41201a.get());
    }
}
