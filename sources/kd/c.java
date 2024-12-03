package kd;

import cd.g;
import ed.i;
import ed.p;
import ed.u;
import fd.d;
import fd.k;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import nd.a;

public class c implements e {

    /* renamed from: f  reason: collision with root package name */
    private static final Logger f41078f = Logger.getLogger(u.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final ld.u f41079a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f41080b;

    /* renamed from: c  reason: collision with root package name */
    private final d f41081c;

    /* renamed from: d  reason: collision with root package name */
    private final md.d f41082d;

    /* renamed from: e  reason: collision with root package name */
    private final a f41083e;

    public c(Executor executor, d dVar, ld.u uVar, md.d dVar2, a aVar) {
        this.f41080b = executor;
        this.f41081c = dVar;
        this.f41079a = uVar;
        this.f41082d = dVar2;
        this.f41083e = aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object d(p pVar, i iVar) {
        this.f41082d.Q1(pVar, iVar);
        this.f41079a.a(pVar, 1);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(p pVar, g gVar, i iVar) {
        try {
            k kVar = this.f41081c.get(pVar.b());
            if (kVar == null) {
                String format2 = String.format("Transport backend '%s' is not registered", new Object[]{pVar.b()});
                f41078f.warning(format2);
                gVar.a(new IllegalArgumentException(format2));
                return;
            }
            this.f41083e.b(new b(this, pVar, kVar.a(iVar)));
            gVar.a((Exception) null);
        } catch (Exception e10) {
            Logger logger = f41078f;
            logger.warning("Error scheduling event " + e10.getMessage());
            gVar.a(e10);
        }
    }

    public void a(p pVar, i iVar, g gVar) {
        this.f41080b.execute(new a(this, pVar, gVar, iVar));
    }
}
