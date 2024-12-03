package okhttp3;

import bl.d;
import com.google.android.gms.common.api.a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.j;
import okhttp3.internal.connection.e;

@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b4\u00105J\u0016\u0010\u0006\u001a\b\u0018\u00010\u0004R\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J+\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\r2\n\u0010\f\u001a\u00060\u0004R\u00020\u0005H\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\r2\n\u0010\f\u001a\u00060\u0004R\u00020\u0005H\u0000¢\u0006\u0004\b\u0014\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0015\u0010\u0013J\u0006\u0010\u0017\u001a\u00020\u0016R*\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00168F@FX\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR*\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00168F@FX\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR.\u0010)\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010!8F@FX\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010+R\u001e\u0010/\u001a\f\u0012\b\u0012\u00060\u0004R\u00020\u00050-8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010.R\u001e\u00100\u001a\f\u0012\b\u0012\u00060\u0004R\u00020\u00050-8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010.R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u00050-8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010.R\u0011\u00103\u001a\u00020*8G¢\u0006\u0006\u001a\u0004\b#\u00102¨\u00066"}, d2 = {"Lokhttp3/o;", "", "", "host", "Lokhttp3/internal/connection/e$a;", "Lokhttp3/internal/connection/e;", "d", "", "k", "T", "Ljava/util/Deque;", "calls", "call", "", "e", "(Ljava/util/Deque;Ljava/lang/Object;)V", "a", "(Lokhttp3/internal/connection/e$a;)V", "b", "(Lokhttp3/internal/connection/e;)V", "f", "g", "", "l", "maxRequests", "I", "i", "()I", "setMaxRequests", "(I)V", "maxRequestsPerHost", "j", "setMaxRequestsPerHost", "Ljava/lang/Runnable;", "<set-?>", "c", "Ljava/lang/Runnable;", "h", "()Ljava/lang/Runnable;", "setIdleCallback", "(Ljava/lang/Runnable;)V", "idleCallback", "Ljava/util/concurrent/ExecutorService;", "Ljava/util/concurrent/ExecutorService;", "executorServiceOrNull", "Ljava/util/ArrayDeque;", "Ljava/util/ArrayDeque;", "readyAsyncCalls", "runningAsyncCalls", "runningSyncCalls", "()Ljava/util/concurrent/ExecutorService;", "executorService", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class o {

    /* renamed from: a  reason: collision with root package name */
    private int f33147a = 64;

    /* renamed from: b  reason: collision with root package name */
    private int f33148b = 5;

    /* renamed from: c  reason: collision with root package name */
    private Runnable f33149c;

    /* renamed from: d  reason: collision with root package name */
    private ExecutorService f33150d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayDeque<e.a> f33151e = new ArrayDeque<>();

    /* renamed from: f  reason: collision with root package name */
    private final ArrayDeque<e.a> f33152f = new ArrayDeque<>();

    /* renamed from: g  reason: collision with root package name */
    private final ArrayDeque<e> f33153g = new ArrayDeque<>();

    private final e.a d(String str) {
        Iterator<e.a> it = this.f33152f.iterator();
        while (it.hasNext()) {
            e.a next = it.next();
            if (j.b(next.d(), str)) {
                return next;
            }
        }
        Iterator<e.a> it2 = this.f33151e.iterator();
        while (it2.hasNext()) {
            e.a next2 = it2.next();
            if (j.b(next2.d(), str)) {
                return next2;
            }
        }
        return null;
    }

    private final <T> void e(Deque<T> deque, T t10) {
        Runnable h10;
        synchronized (this) {
            if (deque.remove(t10)) {
                h10 = h();
                Unit unit = Unit.f32013a;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!k() && h10 != null) {
            h10.run();
        }
    }

    private final boolean k() {
        int i10;
        boolean z10;
        if (!d.f24935h || !Thread.holdsLock(this)) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                Iterator<e.a> it = this.f33151e.iterator();
                j.f(it, "readyAsyncCalls.iterator()");
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    e.a next = it.next();
                    if (this.f33152f.size() >= i()) {
                        break;
                    } else if (next.c().get() < j()) {
                        it.remove();
                        next.c().incrementAndGet();
                        j.f(next, "asyncCall");
                        arrayList.add(next);
                        this.f33152f.add(next);
                    }
                }
                if (l() > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                Unit unit = Unit.f32013a;
            }
            int size = arrayList.size();
            for (i10 = 0; i10 < size; i10++) {
                ((e.a) arrayList.get(i10)).a(c());
            }
            return z10;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void a(e.a aVar) {
        e.a d10;
        j.g(aVar, "call");
        synchronized (this) {
            this.f33151e.add(aVar);
            if (!aVar.b().q() && (d10 = d(aVar.d())) != null) {
                aVar.e(d10);
            }
            Unit unit = Unit.f32013a;
        }
        k();
    }

    public final synchronized void b(e eVar) {
        j.g(eVar, "call");
        this.f33153g.add(eVar);
    }

    public final synchronized ExecutorService c() {
        ExecutorService executorService;
        if (this.f33150d == null) {
            this.f33150d = new ThreadPoolExecutor(0, a.e.API_PRIORITY_OTHER, 60, TimeUnit.SECONDS, new SynchronousQueue(), d.M(j.p(d.f24936i, " Dispatcher"), false));
        }
        executorService = this.f33150d;
        j.d(executorService);
        return executorService;
    }

    public final void f(e.a aVar) {
        j.g(aVar, "call");
        aVar.c().decrementAndGet();
        e(this.f33152f, aVar);
    }

    public final void g(e eVar) {
        j.g(eVar, "call");
        e(this.f33153g, eVar);
    }

    public final synchronized Runnable h() {
        return this.f33149c;
    }

    public final synchronized int i() {
        return this.f33147a;
    }

    public final synchronized int j() {
        return this.f33148b;
    }

    public final synchronized int l() {
        return this.f33152f.size() + this.f33153g.size();
    }
}
