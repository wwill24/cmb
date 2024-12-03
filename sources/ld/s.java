package ld;

import ed.p;
import java.util.concurrent.Executor;
import md.d;
import nd.a;

public class s {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f41168a;

    /* renamed from: b  reason: collision with root package name */
    private final d f41169b;

    /* renamed from: c  reason: collision with root package name */
    private final u f41170c;

    /* renamed from: d  reason: collision with root package name */
    private final a f41171d;

    s(Executor executor, d dVar, u uVar, a aVar) {
        this.f41168a = executor;
        this.f41169b = dVar;
        this.f41170c = uVar;
        this.f41171d = aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object d() {
        for (p a10 : this.f41169b.Q()) {
            this.f41170c.a(a10, 1);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f41171d.b(new r(this));
    }

    public void c() {
        this.f41168a.execute(new q(this));
    }
}
