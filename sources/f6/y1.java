package f6;

import android.content.Context;
import fj.d;
import fk.a;
import tb.b;

public final class y1 implements d<x1> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f14858a;

    /* renamed from: b  reason: collision with root package name */
    private final a<b> f14859b;

    public y1(a<Context> aVar, a<b> aVar2) {
        this.f14858a = aVar;
        this.f14859b = aVar2;
    }

    public static y1 a(a<Context> aVar, a<b> aVar2) {
        return new y1(aVar, aVar2);
    }

    public static x1 c(Context context, b bVar) {
        return new x1(context, bVar);
    }

    /* renamed from: b */
    public x1 get() {
        return c(this.f14858a.get(), this.f14859b.get());
    }
}
