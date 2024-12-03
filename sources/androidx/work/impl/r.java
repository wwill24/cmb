package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.work.WorkerParameters;
import b2.f;
import g2.m;
import g2.u;
import i2.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class r implements e, androidx.work.impl.foreground.a {

    /* renamed from: n  reason: collision with root package name */
    private static final String f7583n = f.i("Processor");

    /* renamed from: a  reason: collision with root package name */
    private PowerManager.WakeLock f7584a;

    /* renamed from: b  reason: collision with root package name */
    private Context f7585b;

    /* renamed from: c  reason: collision with root package name */
    private androidx.work.a f7586c;

    /* renamed from: d  reason: collision with root package name */
    private b f7587d;

    /* renamed from: e  reason: collision with root package name */
    private WorkDatabase f7588e;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, h0> f7589f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private Map<String, h0> f7590g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private Map<String, Set<v>> f7591h;

    /* renamed from: j  reason: collision with root package name */
    private List<t> f7592j;

    /* renamed from: k  reason: collision with root package name */
    private Set<String> f7593k;

    /* renamed from: l  reason: collision with root package name */
    private final List<e> f7594l;

    /* renamed from: m  reason: collision with root package name */
    private final Object f7595m;

    private static class a implements Runnable {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private e f7596a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final m f7597b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        private zf.a<Boolean> f7598c;

        a(@NonNull e eVar, @NonNull m mVar, @NonNull zf.a<Boolean> aVar) {
            this.f7596a = eVar;
            this.f7597b = mVar;
            this.f7598c = aVar;
        }

        public void run() {
            boolean z10;
            try {
                z10 = this.f7598c.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z10 = true;
            }
            this.f7596a.a(this.f7597b, z10);
        }
    }

    public r(@NonNull Context context, @NonNull androidx.work.a aVar, @NonNull b bVar, @NonNull WorkDatabase workDatabase, @NonNull List<t> list) {
        this.f7585b = context;
        this.f7586c = aVar;
        this.f7587d = bVar;
        this.f7588e = workDatabase;
        this.f7592j = list;
        this.f7593k = new HashSet();
        this.f7594l = new ArrayList();
        this.f7584a = null;
        this.f7595m = new Object();
        this.f7591h = new HashMap();
    }

    private static boolean i(@NonNull String str, h0 h0Var) {
        if (h0Var != null) {
            h0Var.g();
            f e10 = f.e();
            String str2 = f7583n;
            e10.a(str2, "WorkerWrapper interrupted for " + str);
            return true;
        }
        f e11 = f.e();
        String str3 = f7583n;
        e11.a(str3, "WorkerWrapper could not be found for " + str);
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ u m(ArrayList arrayList, String str) throws Exception {
        arrayList.addAll(this.f7588e.L().a(str));
        return this.f7588e.K().h(str);
    }

    private void o(@NonNull m mVar, boolean z10) {
        this.f7587d.a().execute(new q(this, mVar, z10));
    }

    private void s() {
        synchronized (this.f7595m) {
            if (!(!this.f7589f.isEmpty())) {
                try {
                    this.f7585b.startService(androidx.work.impl.foreground.b.g(this.f7585b));
                } catch (Throwable th2) {
                    f.e().d(f7583n, "Unable to stop foreground service", th2);
                }
                PowerManager.WakeLock wakeLock = this.f7584a;
                if (wakeLock != null) {
                    wakeLock.release();
                    this.f7584a = null;
                }
            }
        }
    }

    /* renamed from: a */
    public void l(@NonNull m mVar, boolean z10) {
        synchronized (this.f7595m) {
            h0 h0Var = this.f7590g.get(mVar.b());
            if (h0Var != null && mVar.equals(h0Var.d())) {
                this.f7590g.remove(mVar.b());
            }
            f e10 = f.e();
            String str = f7583n;
            e10.a(str, getClass().getSimpleName() + " " + mVar.b() + " executed; reschedule = " + z10);
            for (e a10 : this.f7594l) {
                a10.a(mVar, z10);
            }
        }
    }

    public void b(@NonNull String str) {
        synchronized (this.f7595m) {
            this.f7589f.remove(str);
            s();
        }
    }

    public boolean c(@NonNull String str) {
        boolean containsKey;
        synchronized (this.f7595m) {
            containsKey = this.f7589f.containsKey(str);
        }
        return containsKey;
    }

    public void d(@NonNull String str, @NonNull b2.b bVar) {
        synchronized (this.f7595m) {
            f e10 = f.e();
            String str2 = f7583n;
            e10.f(str2, "Moving WorkSpec (" + str + ") to the foreground");
            h0 remove = this.f7590g.remove(str);
            if (remove != null) {
                if (this.f7584a == null) {
                    PowerManager.WakeLock b10 = h2.u.b(this.f7585b, "ProcessorForegroundLck");
                    this.f7584a = b10;
                    b10.acquire();
                }
                this.f7589f.put(str, remove);
                androidx.core.content.a.startForegroundService(this.f7585b, androidx.work.impl.foreground.b.e(this.f7585b, remove.d(), bVar));
            }
        }
    }

    public void g(@NonNull e eVar) {
        synchronized (this.f7595m) {
            this.f7594l.add(eVar);
        }
    }

    public u h(@NonNull String str) {
        synchronized (this.f7595m) {
            h0 h0Var = this.f7589f.get(str);
            if (h0Var == null) {
                h0Var = this.f7590g.get(str);
            }
            if (h0Var == null) {
                return null;
            }
            u e10 = h0Var.e();
            return e10;
        }
    }

    public boolean j(@NonNull String str) {
        boolean contains;
        synchronized (this.f7595m) {
            contains = this.f7593k.contains(str);
        }
        return contains;
    }

    public boolean k(@NonNull String str) {
        boolean z10;
        synchronized (this.f7595m) {
            if (!this.f7590g.containsKey(str)) {
                if (!this.f7589f.containsKey(str)) {
                    z10 = false;
                }
            }
            z10 = true;
        }
        return z10;
    }

    public void n(@NonNull e eVar) {
        synchronized (this.f7595m) {
            this.f7594l.remove(eVar);
        }
    }

    public boolean p(@NonNull v vVar) {
        return q(vVar, (WorkerParameters.a) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x008c, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean q(@androidx.annotation.NonNull androidx.work.impl.v r13, androidx.work.WorkerParameters.a r14) {
        /*
            r12 = this;
            g2.m r0 = r13.a()
            java.lang.String r1 = r0.b()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            androidx.work.impl.WorkDatabase r2 = r12.f7588e
            androidx.work.impl.p r3 = new androidx.work.impl.p
            r3.<init>(r12, r9, r1)
            java.lang.Object r2 = r2.B(r3)
            r8 = r2
            g2.u r8 = (g2.u) r8
            r2 = 0
            if (r8 != 0) goto L_0x003c
            b2.f r13 = b2.f.e()
            java.lang.String r14 = f7583n
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Didn't find WorkSpec for id "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            r13.k(r14, r1)
            r12.o(r0, r2)
            return r2
        L_0x003c:
            java.lang.Object r10 = r12.f7595m
            monitor-enter(r10)
            boolean r3 = r12.k(r1)     // Catch:{ all -> 0x0112 }
            if (r3 == 0) goto L_0x008d
            java.util.Map<java.lang.String, java.util.Set<androidx.work.impl.v>> r14 = r12.f7591h     // Catch:{ all -> 0x0112 }
            java.lang.Object r14 = r14.get(r1)     // Catch:{ all -> 0x0112 }
            java.util.Set r14 = (java.util.Set) r14     // Catch:{ all -> 0x0112 }
            java.util.Iterator r1 = r14.iterator()     // Catch:{ all -> 0x0112 }
            java.lang.Object r1 = r1.next()     // Catch:{ all -> 0x0112 }
            androidx.work.impl.v r1 = (androidx.work.impl.v) r1     // Catch:{ all -> 0x0112 }
            g2.m r1 = r1.a()     // Catch:{ all -> 0x0112 }
            int r1 = r1.a()     // Catch:{ all -> 0x0112 }
            int r3 = r0.a()     // Catch:{ all -> 0x0112 }
            if (r1 != r3) goto L_0x0088
            r14.add(r13)     // Catch:{ all -> 0x0112 }
            b2.f r13 = b2.f.e()     // Catch:{ all -> 0x0112 }
            java.lang.String r14 = f7583n     // Catch:{ all -> 0x0112 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0112 }
            r1.<init>()     // Catch:{ all -> 0x0112 }
            java.lang.String r3 = "Work "
            r1.append(r3)     // Catch:{ all -> 0x0112 }
            r1.append(r0)     // Catch:{ all -> 0x0112 }
            java.lang.String r0 = " is already enqueued for processing"
            r1.append(r0)     // Catch:{ all -> 0x0112 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x0112 }
            r13.a(r14, r0)     // Catch:{ all -> 0x0112 }
            goto L_0x008b
        L_0x0088:
            r12.o(r0, r2)     // Catch:{ all -> 0x0112 }
        L_0x008b:
            monitor-exit(r10)     // Catch:{ all -> 0x0112 }
            return r2
        L_0x008d:
            int r3 = r8.f()     // Catch:{ all -> 0x0112 }
            int r4 = r0.a()     // Catch:{ all -> 0x0112 }
            if (r3 == r4) goto L_0x009c
            r12.o(r0, r2)     // Catch:{ all -> 0x0112 }
            monitor-exit(r10)     // Catch:{ all -> 0x0112 }
            return r2
        L_0x009c:
            androidx.work.impl.h0$c r11 = new androidx.work.impl.h0$c     // Catch:{ all -> 0x0112 }
            android.content.Context r3 = r12.f7585b     // Catch:{ all -> 0x0112 }
            androidx.work.a r4 = r12.f7586c     // Catch:{ all -> 0x0112 }
            i2.b r5 = r12.f7587d     // Catch:{ all -> 0x0112 }
            androidx.work.impl.WorkDatabase r7 = r12.f7588e     // Catch:{ all -> 0x0112 }
            r2 = r11
            r6 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0112 }
            java.util.List<androidx.work.impl.t> r2 = r12.f7592j     // Catch:{ all -> 0x0112 }
            androidx.work.impl.h0$c r2 = r11.d(r2)     // Catch:{ all -> 0x0112 }
            androidx.work.impl.h0$c r14 = r2.c(r14)     // Catch:{ all -> 0x0112 }
            androidx.work.impl.h0 r14 = r14.b()     // Catch:{ all -> 0x0112 }
            zf.a r2 = r14.c()     // Catch:{ all -> 0x0112 }
            androidx.work.impl.r$a r3 = new androidx.work.impl.r$a     // Catch:{ all -> 0x0112 }
            g2.m r4 = r13.a()     // Catch:{ all -> 0x0112 }
            r3.<init>(r12, r4, r2)     // Catch:{ all -> 0x0112 }
            i2.b r4 = r12.f7587d     // Catch:{ all -> 0x0112 }
            java.util.concurrent.Executor r4 = r4.a()     // Catch:{ all -> 0x0112 }
            r2.addListener(r3, r4)     // Catch:{ all -> 0x0112 }
            java.util.Map<java.lang.String, androidx.work.impl.h0> r2 = r12.f7590g     // Catch:{ all -> 0x0112 }
            r2.put(r1, r14)     // Catch:{ all -> 0x0112 }
            java.util.HashSet r2 = new java.util.HashSet     // Catch:{ all -> 0x0112 }
            r2.<init>()     // Catch:{ all -> 0x0112 }
            r2.add(r13)     // Catch:{ all -> 0x0112 }
            java.util.Map<java.lang.String, java.util.Set<androidx.work.impl.v>> r13 = r12.f7591h     // Catch:{ all -> 0x0112 }
            r13.put(r1, r2)     // Catch:{ all -> 0x0112 }
            monitor-exit(r10)     // Catch:{ all -> 0x0112 }
            i2.b r13 = r12.f7587d
            i2.a r13 = r13.b()
            r13.execute(r14)
            b2.f r13 = b2.f.e()
            java.lang.String r14 = f7583n
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.Class r2 = r12.getClass()
            java.lang.String r2 = r2.getSimpleName()
            r1.append(r2)
            java.lang.String r2 = ": processing "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r13.a(r14, r0)
            r13 = 1
            return r13
        L_0x0112:
            r13 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0112 }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.r.q(androidx.work.impl.v, androidx.work.WorkerParameters$a):boolean");
    }

    public boolean r(@NonNull String str) {
        h0 remove;
        boolean z10;
        synchronized (this.f7595m) {
            f e10 = f.e();
            String str2 = f7583n;
            e10.a(str2, "Processor cancelling " + str);
            this.f7593k.add(str);
            remove = this.f7589f.remove(str);
            if (remove != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (remove == null) {
                remove = this.f7590g.remove(str);
            }
            if (remove != null) {
                this.f7591h.remove(str);
            }
        }
        boolean i10 = i(str, remove);
        if (z10) {
            s();
        }
        return i10;
    }

    public boolean t(@NonNull v vVar) {
        h0 remove;
        String b10 = vVar.a().b();
        synchronized (this.f7595m) {
            f e10 = f.e();
            String str = f7583n;
            e10.a(str, "Processor stopping foreground work " + b10);
            remove = this.f7589f.remove(b10);
            if (remove != null) {
                this.f7591h.remove(b10);
            }
        }
        return i(b10, remove);
    }

    public boolean u(@NonNull v vVar) {
        String b10 = vVar.a().b();
        synchronized (this.f7595m) {
            h0 remove = this.f7590g.remove(b10);
            if (remove == null) {
                f e10 = f.e();
                String str = f7583n;
                e10.a(str, "WorkerWrapper could not be found for " + b10);
                return false;
            }
            Set set = this.f7591h.get(b10);
            if (set != null) {
                if (set.contains(vVar)) {
                    f e11 = f.e();
                    String str2 = f7583n;
                    e11.a(str2, "Processor stopping background work " + b10);
                    this.f7591h.remove(b10);
                    return i(b10, remove);
                }
            }
            return false;
        }
    }
}
