package ld;

import android.content.Context;
import fd.d;
import fk.a;
import gd.b;
import java.util.concurrent.Executor;
import md.c;

public final class p implements b<o> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f41157a;

    /* renamed from: b  reason: collision with root package name */
    private final a<d> f41158b;

    /* renamed from: c  reason: collision with root package name */
    private final a<md.d> f41159c;

    /* renamed from: d  reason: collision with root package name */
    private final a<u> f41160d;

    /* renamed from: e  reason: collision with root package name */
    private final a<Executor> f41161e;

    /* renamed from: f  reason: collision with root package name */
    private final a<nd.a> f41162f;

    /* renamed from: g  reason: collision with root package name */
    private final a<od.a> f41163g;

    /* renamed from: h  reason: collision with root package name */
    private final a<od.a> f41164h;

    /* renamed from: i  reason: collision with root package name */
    private final a<c> f41165i;

    public p(a<Context> aVar, a<d> aVar2, a<md.d> aVar3, a<u> aVar4, a<Executor> aVar5, a<nd.a> aVar6, a<od.a> aVar7, a<od.a> aVar8, a<c> aVar9) {
        this.f41157a = aVar;
        this.f41158b = aVar2;
        this.f41159c = aVar3;
        this.f41160d = aVar4;
        this.f41161e = aVar5;
        this.f41162f = aVar6;
        this.f41163g = aVar7;
        this.f41164h = aVar8;
        this.f41165i = aVar9;
    }

    public static p a(a<Context> aVar, a<d> aVar2, a<md.d> aVar3, a<u> aVar4, a<Executor> aVar5, a<nd.a> aVar6, a<od.a> aVar7, a<od.a> aVar8, a<c> aVar9) {
        return new p(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static o c(Context context, d dVar, md.d dVar2, u uVar, Executor executor, nd.a aVar, od.a aVar2, od.a aVar3, c cVar) {
        return new o(context, dVar, dVar2, uVar, executor, aVar, aVar2, aVar3, cVar);
    }

    /* renamed from: b */
    public o get() {
        return c(this.f41157a.get(), this.f41158b.get(), this.f41159c.get(), this.f41160d.get(), this.f41161e.get(), this.f41162f.get(), this.f41163g.get(), this.f41164h.get(), this.f41165i.get());
    }
}
