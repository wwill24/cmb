package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.WorkerParameters;
import androidx.work.c;
import androidx.work.impl.e0;
import androidx.work.impl.utils.futures.a;
import b2.f;
import d2.e;
import f2.n;
import g2.u;
import g2.v;
import j2.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b&\u0010'J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0016\u0010\f\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0016\u0010\r\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R8\u0010\u001d\u001a&\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00060\u0006 \u001a*\u0012\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00190\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR(\u0010#\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u00018G@BX\u000e¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006("}, d2 = {"Landroidx/work/impl/workers/ConstraintTrackingWorker;", "Landroidx/work/c;", "Ld2/c;", "", "q", "Lzf/a;", "Landroidx/work/c$a;", "m", "k", "", "Lg2/u;", "workSpecs", "f", "b", "Landroidx/work/WorkerParameters;", "e", "Landroidx/work/WorkerParameters;", "workerParameters", "", "Ljava/lang/Object;", "lock", "", "g", "Z", "areConstraintsUnmet", "Landroidx/work/impl/utils/futures/a;", "kotlin.jvm.PlatformType", "h", "Landroidx/work/impl/utils/futures/a;", "future", "<set-?>", "j", "Landroidx/work/c;", "getDelegate", "()Landroidx/work/c;", "delegate", "Landroid/content/Context;", "appContext", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class ConstraintTrackingWorker extends c implements d2.c {

    /* renamed from: e  reason: collision with root package name */
    private final WorkerParameters f7640e;

    /* renamed from: f  reason: collision with root package name */
    private final Object f7641f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f7642g;

    /* renamed from: h  reason: collision with root package name */
    private final a<c.a> f7643h = a.s();

    /* renamed from: j  reason: collision with root package name */
    private c f7644j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        j.g(context, "appContext");
        j.g(workerParameters, "workerParameters");
        this.f7640e = workerParameters;
    }

    private final void q() {
        boolean z10;
        if (!this.f7643h.isCancelled()) {
            String i10 = g().i("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
            f e10 = f.e();
            j.f(e10, "get()");
            if (i10 == null || i10.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                e10.c(j2.c.f15550a, "No worker to delegate to.");
                a<c.a> aVar = this.f7643h;
                j.f(aVar, "future");
                boolean unused = j2.c.d(aVar);
                return;
            }
            c b10 = h().b(a(), i10, this.f7640e);
            this.f7644j = b10;
            if (b10 == null) {
                e10.a(j2.c.f15550a, "No worker to delegate to.");
                a<c.a> aVar2 = this.f7643h;
                j.f(aVar2, "future");
                boolean unused2 = j2.c.d(aVar2);
                return;
            }
            e0 j10 = e0.j(a());
            j.f(j10, "getInstance(applicationContext)");
            v K = j10.o().K();
            String uuid = e().toString();
            j.f(uuid, "id.toString()");
            u h10 = K.h(uuid);
            if (h10 == null) {
                a<c.a> aVar3 = this.f7643h;
                j.f(aVar3, "future");
                boolean unused3 = j2.c.d(aVar3);
                return;
            }
            n n10 = j10.n();
            j.f(n10, "workManagerImpl.trackers");
            e eVar = new e(n10, (d2.c) this);
            eVar.a(p.e(h10));
            String uuid2 = e().toString();
            j.f(uuid2, "id.toString()");
            if (eVar.d(uuid2)) {
                String a10 = j2.c.f15550a;
                e10.a(a10, "Constraints met for delegate " + i10);
                try {
                    c cVar = this.f7644j;
                    j.d(cVar);
                    zf.a<c.a> m10 = cVar.m();
                    j.f(m10, "delegate!!.startWork()");
                    m10.addListener(new b(this, m10), c());
                } catch (Throwable th2) {
                    String a11 = j2.c.f15550a;
                    e10.b(a11, "Delegated worker " + i10 + " threw exception in startWork.", th2);
                    synchronized (this.f7641f) {
                        if (this.f7642g) {
                            e10.a(j2.c.f15550a, "Constraints were unmet, Retrying.");
                            a<c.a> aVar4 = this.f7643h;
                            j.f(aVar4, "future");
                            boolean unused4 = j2.c.e(aVar4);
                        } else {
                            a<c.a> aVar5 = this.f7643h;
                            j.f(aVar5, "future");
                            boolean unused5 = j2.c.d(aVar5);
                        }
                    }
                }
            } else {
                String a12 = j2.c.f15550a;
                e10.a(a12, "Constraints not met for delegate " + i10 + ". Requesting retry.");
                a<c.a> aVar6 = this.f7643h;
                j.f(aVar6, "future");
                boolean unused6 = j2.c.e(aVar6);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void r(ConstraintTrackingWorker constraintTrackingWorker, zf.a aVar) {
        j.g(constraintTrackingWorker, "this$0");
        j.g(aVar, "$innerFuture");
        synchronized (constraintTrackingWorker.f7641f) {
            if (constraintTrackingWorker.f7642g) {
                a<c.a> aVar2 = constraintTrackingWorker.f7643h;
                j.f(aVar2, "future");
                boolean unused = j2.c.e(aVar2);
            } else {
                constraintTrackingWorker.f7643h.q(aVar);
            }
            Unit unit = Unit.f32013a;
        }
    }

    /* access modifiers changed from: private */
    public static final void s(ConstraintTrackingWorker constraintTrackingWorker) {
        j.g(constraintTrackingWorker, "this$0");
        constraintTrackingWorker.q();
    }

    public void b(List<u> list) {
        j.g(list, "workSpecs");
        f e10 = f.e();
        String a10 = j2.c.f15550a;
        e10.a(a10, "Constraints changed for " + list);
        synchronized (this.f7641f) {
            this.f7642g = true;
            Unit unit = Unit.f32013a;
        }
    }

    public void f(List<u> list) {
        j.g(list, "workSpecs");
    }

    public void k() {
        super.k();
        c cVar = this.f7644j;
        if (cVar != null && !cVar.i()) {
            cVar.n();
        }
    }

    public zf.a<c.a> m() {
        c().execute(new j2.a(this));
        a<c.a> aVar = this.f7643h;
        j.f(aVar, "future");
        return aVar;
    }
}
