package el;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u001a\u001a\u00020\u0010¢\u0006\u0004\b.\u0010/J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J'\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006J\u000f\u0010\u000e\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u001a\u0010\u0016\u001a\u00020\u00128\u0000X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00108\u0000X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010 \u001a\u00020\b8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u001fR$\u0010&\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\u001b\u0010#\"\u0004\b$\u0010%R \u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020'8\u0000X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b(\u0010*R\"\u0010-\u001a\u00020\b8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u001c\u001a\u0004\b!\u0010\u000f\"\u0004\b,\u0010\u001f¨\u00060"}, d2 = {"Lel/d;", "", "Lel/a;", "task", "", "delayNanos", "", "i", "", "recurrence", "k", "(Lel/a;JZ)Z", "a", "o", "b", "()Z", "", "toString", "Lel/e;", "Lel/e;", "h", "()Lel/e;", "taskRunner", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "name", "c", "Z", "g", "n", "(Z)V", "shutdown", "d", "Lel/a;", "()Lel/a;", "l", "(Lel/a;)V", "activeTask", "", "e", "Ljava/util/List;", "()Ljava/util/List;", "futureTasks", "m", "cancelActiveTask", "<init>", "(Lel/e;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final e f29623a;

    /* renamed from: b  reason: collision with root package name */
    private final String f29624b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f29625c;

    /* renamed from: d  reason: collision with root package name */
    private a f29626d;

    /* renamed from: e  reason: collision with root package name */
    private final List<a> f29627e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private boolean f29628f;

    public d(e eVar, String str) {
        j.g(eVar, "taskRunner");
        j.g(str, "name");
        this.f29623a = eVar;
        this.f29624b = str;
    }

    public static /* synthetic */ void j(d dVar, a aVar, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        dVar.i(aVar, j10);
    }

    public final void a() {
        if (!bl.d.f24935h || !Thread.holdsLock(this)) {
            synchronized (this.f29623a) {
                if (b()) {
                    h().h(this);
                }
                Unit unit = Unit.f32013a;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final boolean b() {
        a aVar = this.f29626d;
        if (aVar != null) {
            j.d(aVar);
            if (aVar.a()) {
                this.f29628f = true;
            }
        }
        boolean z10 = false;
        int size = this.f29627e.size() - 1;
        if (size >= 0) {
            while (true) {
                int i10 = size - 1;
                if (this.f29627e.get(size).a()) {
                    a aVar2 = this.f29627e.get(size);
                    if (e.f29629h.a().isLoggable(Level.FINE)) {
                        b.c(aVar2, this, "canceled");
                    }
                    this.f29627e.remove(size);
                    z10 = true;
                }
                if (i10 < 0) {
                    break;
                }
                size = i10;
            }
        }
        return z10;
    }

    public final a c() {
        return this.f29626d;
    }

    public final boolean d() {
        return this.f29628f;
    }

    public final List<a> e() {
        return this.f29627e;
    }

    public final String f() {
        return this.f29624b;
    }

    public final boolean g() {
        return this.f29625c;
    }

    public final e h() {
        return this.f29623a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(el.a r3, long r4) {
        /*
            r2 = this;
            java.lang.String r0 = "task"
            kotlin.jvm.internal.j.g(r3, r0)
            el.e r0 = r2.f29623a
            monitor-enter(r0)
            boolean r1 = r2.g()     // Catch:{ all -> 0x0054 }
            if (r1 == 0) goto L_0x0042
            boolean r4 = r3.a()     // Catch:{ all -> 0x0054 }
            if (r4 == 0) goto L_0x0029
            el.e$b r4 = el.e.f29629h     // Catch:{ all -> 0x0054 }
            java.util.logging.Logger r4 = r4.a()     // Catch:{ all -> 0x0054 }
            java.util.logging.Level r5 = java.util.logging.Level.FINE     // Catch:{ all -> 0x0054 }
            boolean r4 = r4.isLoggable(r5)     // Catch:{ all -> 0x0054 }
            if (r4 == 0) goto L_0x0027
            java.lang.String r4 = "schedule canceled (queue is shutdown)"
            el.b.c(r3, r2, r4)     // Catch:{ all -> 0x0054 }
        L_0x0027:
            monitor-exit(r0)
            return
        L_0x0029:
            el.e$b r4 = el.e.f29629h     // Catch:{ all -> 0x0054 }
            java.util.logging.Logger r4 = r4.a()     // Catch:{ all -> 0x0054 }
            java.util.logging.Level r5 = java.util.logging.Level.FINE     // Catch:{ all -> 0x0054 }
            boolean r4 = r4.isLoggable(r5)     // Catch:{ all -> 0x0054 }
            if (r4 == 0) goto L_0x003c
            java.lang.String r4 = "schedule failed (queue is shutdown)"
            el.b.c(r3, r2, r4)     // Catch:{ all -> 0x0054 }
        L_0x003c:
            java.util.concurrent.RejectedExecutionException r3 = new java.util.concurrent.RejectedExecutionException     // Catch:{ all -> 0x0054 }
            r3.<init>()     // Catch:{ all -> 0x0054 }
            throw r3     // Catch:{ all -> 0x0054 }
        L_0x0042:
            r1 = 0
            boolean r3 = r2.k(r3, r4, r1)     // Catch:{ all -> 0x0054 }
            if (r3 == 0) goto L_0x0050
            el.e r3 = r2.h()     // Catch:{ all -> 0x0054 }
            r3.h(r2)     // Catch:{ all -> 0x0054 }
        L_0x0050:
            kotlin.Unit r3 = kotlin.Unit.f32013a     // Catch:{ all -> 0x0054 }
            monitor-exit(r0)
            return
        L_0x0054:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: el.d.i(el.a, long):void");
    }

    public final boolean k(a aVar, long j10, boolean z10) {
        boolean z11;
        String str;
        j.g(aVar, "task");
        aVar.e(this);
        long a10 = this.f29623a.g().a();
        long j11 = a10 + j10;
        int indexOf = this.f29627e.indexOf(aVar);
        if (indexOf != -1) {
            if (aVar.c() <= j11) {
                if (e.f29629h.a().isLoggable(Level.FINE)) {
                    b.c(aVar, this, "already scheduled");
                }
                return false;
            }
            this.f29627e.remove(indexOf);
        }
        aVar.g(j11);
        if (e.f29629h.a().isLoggable(Level.FINE)) {
            if (z10) {
                str = j.p("run again after ", b.b(j11 - a10));
            } else {
                str = j.p("scheduled after ", b.b(j11 - a10));
            }
            b.c(aVar, this, str);
        }
        Iterator<a> it = this.f29627e.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            if (it.next().c() - a10 > j10) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                break;
            }
            i10++;
        }
        if (i10 == -1) {
            i10 = this.f29627e.size();
        }
        this.f29627e.add(i10, aVar);
        if (i10 == 0) {
            return true;
        }
        return false;
    }

    public final void l(a aVar) {
        this.f29626d = aVar;
    }

    public final void m(boolean z10) {
        this.f29628f = z10;
    }

    public final void n(boolean z10) {
        this.f29625c = z10;
    }

    public final void o() {
        if (!bl.d.f24935h || !Thread.holdsLock(this)) {
            synchronized (this.f29623a) {
                n(true);
                if (b()) {
                    h().h(this);
                }
                Unit unit = Unit.f32013a;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public String toString() {
        return this.f29624b;
    }
}
