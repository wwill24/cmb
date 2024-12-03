package kd;

import fk.a;
import gd.b;
import java.util.concurrent.Executor;
import ld.u;

public final class d implements b<c> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Executor> f41084a;

    /* renamed from: b  reason: collision with root package name */
    private final a<fd.d> f41085b;

    /* renamed from: c  reason: collision with root package name */
    private final a<u> f41086c;

    /* renamed from: d  reason: collision with root package name */
    private final a<md.d> f41087d;

    /* renamed from: e  reason: collision with root package name */
    private final a<nd.a> f41088e;

    public d(a<Executor> aVar, a<fd.d> aVar2, a<u> aVar3, a<md.d> aVar4, a<nd.a> aVar5) {
        this.f41084a = aVar;
        this.f41085b = aVar2;
        this.f41086c = aVar3;
        this.f41087d = aVar4;
        this.f41088e = aVar5;
    }

    public static d a(a<Executor> aVar, a<fd.d> aVar2, a<u> aVar3, a<md.d> aVar4, a<nd.a> aVar5) {
        return new d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static c c(Executor executor, fd.d dVar, u uVar, md.d dVar2, nd.a aVar) {
        return new c(executor, dVar, uVar, dVar2, aVar);
    }

    /* renamed from: b */
    public c get() {
        return c(this.f41084a.get(), this.f41085b.get(), this.f41086c.get(), this.f41087d.get(), this.f41088e.get());
    }
}
