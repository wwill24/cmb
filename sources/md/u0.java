package md;

import android.content.Context;
import fk.a;
import gd.b;

public final class u0 implements b<t0> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f41247a;

    /* renamed from: b  reason: collision with root package name */
    private final a<String> f41248b;

    /* renamed from: c  reason: collision with root package name */
    private final a<Integer> f41249c;

    public u0(a<Context> aVar, a<String> aVar2, a<Integer> aVar3) {
        this.f41247a = aVar;
        this.f41248b = aVar2;
        this.f41249c = aVar3;
    }

    public static u0 a(a<Context> aVar, a<String> aVar2, a<Integer> aVar3) {
        return new u0(aVar, aVar2, aVar3);
    }

    public static t0 c(Context context, String str, int i10) {
        return new t0(context, str, i10);
    }

    /* renamed from: b */
    public t0 get() {
        return c(this.f41247a.get(), this.f41248b.get(), this.f41249c.get().intValue());
    }
}
