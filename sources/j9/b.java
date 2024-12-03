package j9;

import f9.d;
import java.util.concurrent.TimeUnit;
import qj.q;
import qj.s;
import vj.j;

public class b implements j<q<? extends Throwable>, q<?>> {

    /* renamed from: a  reason: collision with root package name */
    private int f15640a;

    /* renamed from: b  reason: collision with root package name */
    private int f15641b = 0;

    public b(int i10) {
        this.f15640a = i10;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ s c(Throwable th2) throws Exception {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("retry called ");
        sb2.append(th2.getMessage());
        int i10 = this.f15641b + 1;
        this.f15641b = i10;
        if (i10 < this.f15640a) {
            return q.t0(d.a(i10), TimeUnit.MILLISECONDS);
        }
        return q.z(th2);
    }

    /* renamed from: b */
    public q<?> apply(q<? extends Throwable> qVar) throws Exception {
        return qVar.D(new a(this));
    }
}
