package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.c;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.e0;
import b2.f;
import com.mparticle.identity.IdentityHttpResponse;
import g2.o;
import g2.u;
import g2.v;
import g2.z;
import j2.d;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Landroidx/work/impl/workers/DiagnosticsWorker;", "Landroidx/work/Worker;", "Landroidx/work/c$a;", "o", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "parameters", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class DiagnosticsWorker extends Worker {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(workerParameters, "parameters");
    }

    public c.a o() {
        e0 j10 = e0.j(a());
        j.f(j10, "getInstance(applicationContext)");
        WorkDatabase o10 = j10.o();
        j.f(o10, "workManager.workDatabase");
        v K = o10.K();
        o I = o10.I();
        z L = o10.L();
        g2.j H = o10.H();
        List<u> c10 = K.c(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1));
        List<u> r10 = K.r();
        List<u> k10 = K.k(200);
        if (!c10.isEmpty()) {
            f.e().f(d.f15551a, "Recently completed work:\n\n");
            f.e().f(d.f15551a, d.d(I, L, H, c10));
        }
        if (!r10.isEmpty()) {
            f.e().f(d.f15551a, "Running work:\n\n");
            f.e().f(d.f15551a, d.d(I, L, H, r10));
        }
        if (!k10.isEmpty()) {
            f.e().f(d.f15551a, "Enqueued work:\n\n");
            f.e().f(d.f15551a, d.d(I, L, H, k10));
        }
        c.a c11 = c.a.c();
        j.f(c11, "success()");
        return c11;
    }
}
