package ed;

import android.content.Context;
import cd.b;
import cd.f;
import cd.g;
import java.util.Collections;
import java.util.Set;
import kd.e;
import ld.o;
import ld.s;
import od.a;

public class u implements t {

    /* renamed from: e  reason: collision with root package name */
    private static volatile v f40759e;

    /* renamed from: a  reason: collision with root package name */
    private final a f40760a;

    /* renamed from: b  reason: collision with root package name */
    private final a f40761b;

    /* renamed from: c  reason: collision with root package name */
    private final e f40762c;

    /* renamed from: d  reason: collision with root package name */
    private final o f40763d;

    u(a aVar, a aVar2, e eVar, o oVar, s sVar) {
        this.f40760a = aVar;
        this.f40761b = aVar2;
        this.f40762c = eVar;
        this.f40763d = oVar;
        sVar.c();
    }

    private i b(o oVar) {
        return i.a().i(this.f40760a.a()).k(this.f40761b.a()).j(oVar.g()).h(new h(oVar.b(), oVar.d())).g(oVar.c().a()).d();
    }

    public static u c() {
        v vVar = f40759e;
        if (vVar != null) {
            return vVar.b();
        }
        throw new IllegalStateException("Not initialized!");
    }

    private static Set<b> d(f fVar) {
        if (fVar instanceof g) {
            return Collections.unmodifiableSet(((g) fVar).a());
        }
        return Collections.singleton(b.b("proto"));
    }

    public static void f(Context context) {
        if (f40759e == null) {
            synchronized (u.class) {
                if (f40759e == null) {
                    f40759e = e.c().a(context).build();
                }
            }
        }
    }

    public void a(o oVar, g gVar) {
        this.f40762c.a(oVar.f().f(oVar.c().c()), b(oVar), gVar);
    }

    public o e() {
        return this.f40763d;
    }

    public f g(f fVar) {
        return new q(d(fVar), p.a().b(fVar.getName()).c(fVar.getExtras()).a(), this);
    }
}
