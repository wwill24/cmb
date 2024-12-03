package oc;

import java.util.concurrent.TimeUnit;
import qj.h;
import rn.a;
import vj.j;

public class e implements j<h<? extends Throwable>, a<?>> {

    /* renamed from: a  reason: collision with root package name */
    private final int f41328a;

    /* renamed from: b  reason: collision with root package name */
    private int f41329b = 0;

    public e(int i10) {
        this.f41328a = i10;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ a c(Throwable th2) throws Exception {
        int i10 = this.f41329b + 1;
        this.f41329b = i10;
        if (i10 < this.f41328a) {
            return h.q0((long) Math.pow(2.0d, (double) i10), TimeUnit.SECONDS);
        }
        return h.H(th2);
    }

    /* renamed from: b */
    public a<?> apply(h<? extends Throwable> hVar) throws Exception {
        return hVar.M(new d(this));
    }
}
