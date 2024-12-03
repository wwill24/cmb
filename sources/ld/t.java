package ld;

import fk.a;
import gd.b;
import java.util.concurrent.Executor;
import md.d;

public final class t implements b<s> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Executor> f41172a;

    /* renamed from: b  reason: collision with root package name */
    private final a<d> f41173b;

    /* renamed from: c  reason: collision with root package name */
    private final a<u> f41174c;

    /* renamed from: d  reason: collision with root package name */
    private final a<nd.a> f41175d;

    public t(a<Executor> aVar, a<d> aVar2, a<u> aVar3, a<nd.a> aVar4) {
        this.f41172a = aVar;
        this.f41173b = aVar2;
        this.f41174c = aVar3;
        this.f41175d = aVar4;
    }

    public static t a(a<Executor> aVar, a<d> aVar2, a<u> aVar3, a<nd.a> aVar4) {
        return new t(aVar, aVar2, aVar3, aVar4);
    }

    public static s c(Executor executor, d dVar, u uVar, nd.a aVar) {
        return new s(executor, dVar, uVar, aVar);
    }

    /* renamed from: b */
    public s get() {
        return c(this.f41172a.get(), this.f41173b.get(), this.f41174c.get(), this.f41175d.get());
    }
}
