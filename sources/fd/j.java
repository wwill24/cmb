package fd;

import android.content.Context;
import fk.a;
import gd.b;

public final class j implements b<i> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f40814a;

    /* renamed from: b  reason: collision with root package name */
    private final a<g> f40815b;

    public j(a<Context> aVar, a<g> aVar2) {
        this.f40814a = aVar;
        this.f40815b = aVar2;
    }

    public static j a(a<Context> aVar, a<g> aVar2) {
        return new j(aVar, aVar2);
    }

    public static i c(Context context, Object obj) {
        return new i(context, (g) obj);
    }

    /* renamed from: b */
    public i get() {
        return c(this.f40814a.get(), this.f40815b.get());
    }
}
