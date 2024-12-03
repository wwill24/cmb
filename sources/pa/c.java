package pa;

import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.transport.SuccessStatus;
import j5.x;
import jc.b;
import kotlin.jvm.internal.j;
import qj.w;
import qj.y;

public final class c {

    public static final class a implements b<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y<x> f41785a;

        a(y<x> yVar) {
            this.f41785a = yVar;
        }

        public void b(CmbErrorCode cmbErrorCode) {
            this.f41785a.onError(new Throwable(cmbErrorCode != null ? cmbErrorCode.toString() : null));
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            this.f41785a.onSuccess(x.a());
        }
    }

    public static final w<x> b(m1 m1Var) {
        j.g(m1Var, "manager");
        w<x> k10 = w.k(new b(m1Var));
        j.f(k10, "create { singleSubscribe…nc(callback, false)\n    }");
        return k10;
    }

    /* access modifiers changed from: private */
    public static final void c(m1 m1Var, y yVar) {
        j.g(m1Var, "$manager");
        j.g(yVar, "singleSubscriber");
        m1Var.b(new a(yVar), false);
    }
}
