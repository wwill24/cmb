package h2;

import androidx.annotation.NonNull;
import b2.f;
import b2.k;
import g2.m;
import java.util.HashMap;
import java.util.Map;

public class a0 {

    /* renamed from: e  reason: collision with root package name */
    private static final String f15267e = f.i("WorkTimer");

    /* renamed from: a  reason: collision with root package name */
    final k f15268a;

    /* renamed from: b  reason: collision with root package name */
    final Map<m, b> f15269b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final Map<m, a> f15270c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    final Object f15271d = new Object();

    public interface a {
        void a(@NonNull m mVar);
    }

    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final a0 f15272a;

        /* renamed from: b  reason: collision with root package name */
        private final m f15273b;

        b(@NonNull a0 a0Var, @NonNull m mVar) {
            this.f15272a = a0Var;
            this.f15273b = mVar;
        }

        public void run() {
            synchronized (this.f15272a.f15271d) {
                if (this.f15272a.f15269b.remove(this.f15273b) != null) {
                    a remove = this.f15272a.f15270c.remove(this.f15273b);
                    if (remove != null) {
                        remove.a(this.f15273b);
                    }
                } else {
                    f.e().a("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", new Object[]{this.f15273b}));
                }
            }
        }
    }

    public a0(@NonNull k kVar) {
        this.f15268a = kVar;
    }

    public void a(@NonNull m mVar, long j10, @NonNull a aVar) {
        synchronized (this.f15271d) {
            f e10 = f.e();
            String str = f15267e;
            e10.a(str, "Starting timer for " + mVar);
            b(mVar);
            b bVar = new b(this, mVar);
            this.f15269b.put(mVar, bVar);
            this.f15270c.put(mVar, aVar);
            this.f15268a.b(j10, bVar);
        }
    }

    public void b(@NonNull m mVar) {
        synchronized (this.f15271d) {
            if (this.f15269b.remove(mVar) != null) {
                f e10 = f.e();
                String str = f15267e;
                e10.a(str, "Stopping timer for " + mVar);
                this.f15270c.remove(mVar);
            }
        }
    }
}
