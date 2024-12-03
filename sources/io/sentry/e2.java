package io.sentry;

import io.sentry.SentryOptions;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.j;
import io.sentry.protocol.x;
import io.sentry.util.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.ApiStatus;

public final class e2 {

    /* renamed from: a  reason: collision with root package name */
    private SentryLevel f31205a;

    /* renamed from: b  reason: collision with root package name */
    private n0 f31206b;

    /* renamed from: c  reason: collision with root package name */
    private String f31207c;

    /* renamed from: d  reason: collision with root package name */
    private x f31208d;

    /* renamed from: e  reason: collision with root package name */
    private j f31209e;

    /* renamed from: f  reason: collision with root package name */
    private List<String> f31210f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private Queue<d> f31211g;

    /* renamed from: h  reason: collision with root package name */
    private Map<String, String> f31212h = new ConcurrentHashMap();

    /* renamed from: i  reason: collision with root package name */
    private Map<String, Object> f31213i = new ConcurrentHashMap();

    /* renamed from: j  reason: collision with root package name */
    private List<t> f31214j = new CopyOnWriteArrayList();

    /* renamed from: k  reason: collision with root package name */
    private final SentryOptions f31215k;

    /* renamed from: l  reason: collision with root package name */
    private volatile Session f31216l;

    /* renamed from: m  reason: collision with root package name */
    private final Object f31217m = new Object();

    /* renamed from: n  reason: collision with root package name */
    private final Object f31218n = new Object();

    /* renamed from: o  reason: collision with root package name */
    private Contexts f31219o = new Contexts();

    /* renamed from: p  reason: collision with root package name */
    private List<b> f31220p = new CopyOnWriteArrayList();

    interface a {
        void a(Session session);
    }

    @ApiStatus.Internal
    public interface b {
        void a(n0 n0Var);
    }

    static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final Session f31221a;

        /* renamed from: b  reason: collision with root package name */
        private final Session f31222b;

        public c(Session session, Session session2) {
            this.f31222b = session;
            this.f31221a = session2;
        }

        public Session a() {
            return this.f31222b;
        }

        public Session b() {
            return this.f31221a;
        }
    }

    public e2(SentryOptions sentryOptions) {
        SentryOptions sentryOptions2 = (SentryOptions) l.c(sentryOptions, "SentryOptions is required.");
        this.f31215k = sentryOptions2;
        this.f31211g = c(sentryOptions2.getMaxBreadcrumbs());
    }

    private Queue<d> c(int i10) {
        return SynchronizedQueue.f(new CircularFifoQueue(i10));
    }

    private d e(SentryOptions.a aVar, d dVar, w wVar) {
        try {
            return aVar.a(dVar, wVar);
        } catch (Throwable th2) {
            this.f31215k.getLogger().b(SentryLevel.ERROR, "The BeforeBreadcrumbCallback callback threw an exception. Exception details will be added to the breadcrumb.", th2);
            if (th2.getMessage() == null) {
                return dVar;
            }
            dVar.m("sentry:message", th2.getMessage());
            return dVar;
        }
    }

    public void a(d dVar, w wVar) {
        if (dVar != null) {
            if (wVar == null) {
                wVar = new w();
            }
            SentryOptions.a beforeBreadcrumb = this.f31215k.getBeforeBreadcrumb();
            if (beforeBreadcrumb != null) {
                dVar = e(beforeBreadcrumb, dVar, wVar);
            }
            if (dVar != null) {
                this.f31211g.add(dVar);
                if (this.f31215k.isEnableScopeSync()) {
                    for (i0 q10 : this.f31215k.getScopeObservers()) {
                        q10.q(dVar);
                    }
                    return;
                }
                return;
            }
            this.f31215k.getLogger().c(SentryLevel.INFO, "Breadcrumb was dropped by beforeBreadcrumb", new Object[0]);
        }
    }

    public void b() {
        synchronized (this.f31218n) {
            this.f31206b = null;
        }
        this.f31207c = null;
    }

    /* access modifiers changed from: package-private */
    public Session d() {
        Session session;
        synchronized (this.f31217m) {
            session = null;
            if (this.f31216l != null) {
                this.f31216l.c();
                Session b10 = this.f31216l.clone();
                this.f31216l = null;
                session = b10;
            }
        }
        return session;
    }

    /* access modifiers changed from: package-private */
    public List<b> f() {
        return new CopyOnWriteArrayList(this.f31220p);
    }

    /* access modifiers changed from: package-private */
    public Queue<d> g() {
        return this.f31211g;
    }

    public Contexts h() {
        return this.f31219o;
    }

    /* access modifiers changed from: package-private */
    public List<t> i() {
        return this.f31214j;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> j() {
        return this.f31213i;
    }

    /* access modifiers changed from: package-private */
    public List<String> k() {
        return this.f31210f;
    }

    public SentryLevel l() {
        return this.f31205a;
    }

    public j m() {
        return this.f31209e;
    }

    @ApiStatus.Internal
    public Session n() {
        return this.f31216l;
    }

    public m0 o() {
        i4 k10;
        n0 n0Var = this.f31206b;
        if (n0Var == null || (k10 = n0Var.k()) == null) {
            return n0Var;
        }
        return k10;
    }

    @ApiStatus.Internal
    public Map<String, String> p() {
        return io.sentry.util.b.b(this.f31212h);
    }

    public n0 q() {
        return this.f31206b;
    }

    public String r() {
        n0 n0Var = this.f31206b;
        if (n0Var != null) {
            return n0Var.getName();
        }
        return this.f31207c;
    }

    public x s() {
        return this.f31208d;
    }

    public void t(String str, String str2) {
        this.f31213i.put(str, str2);
        if (this.f31215k.isEnableScopeSync()) {
            for (i0 a10 : this.f31215k.getScopeObservers()) {
                a10.a(str, str2);
            }
        }
    }

    public void u(n0 n0Var) {
        synchronized (this.f31218n) {
            this.f31206b = n0Var;
        }
    }

    public void v(x xVar) {
        this.f31208d = xVar;
        if (this.f31215k.isEnableScopeSync()) {
            for (i0 p10 : this.f31215k.getScopeObservers()) {
                p10.p(xVar);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: io.sentry.e2$c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: io.sentry.Session} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.sentry.e2.c w() {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f31217m
            monitor-enter(r0)
            io.sentry.Session r1 = r8.f31216l     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x000c
            io.sentry.Session r1 = r8.f31216l     // Catch:{ all -> 0x0057 }
            r1.c()     // Catch:{ all -> 0x0057 }
        L_0x000c:
            io.sentry.Session r1 = r8.f31216l     // Catch:{ all -> 0x0057 }
            io.sentry.SentryOptions r2 = r8.f31215k     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = r2.getRelease()     // Catch:{ all -> 0x0057 }
            r3 = 0
            if (r2 == 0) goto L_0x0045
            io.sentry.Session r2 = new io.sentry.Session     // Catch:{ all -> 0x0057 }
            io.sentry.SentryOptions r4 = r8.f31215k     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = r4.getDistinctId()     // Catch:{ all -> 0x0057 }
            io.sentry.protocol.x r5 = r8.f31208d     // Catch:{ all -> 0x0057 }
            io.sentry.SentryOptions r6 = r8.f31215k     // Catch:{ all -> 0x0057 }
            java.lang.String r6 = r6.getEnvironment()     // Catch:{ all -> 0x0057 }
            io.sentry.SentryOptions r7 = r8.f31215k     // Catch:{ all -> 0x0057 }
            java.lang.String r7 = r7.getRelease()     // Catch:{ all -> 0x0057 }
            r2.<init>(r4, r5, r6, r7)     // Catch:{ all -> 0x0057 }
            r8.f31216l = r2     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x0038
            io.sentry.Session r3 = r1.clone()     // Catch:{ all -> 0x0057 }
        L_0x0038:
            io.sentry.e2$c r1 = new io.sentry.e2$c     // Catch:{ all -> 0x0057 }
            io.sentry.Session r2 = r8.f31216l     // Catch:{ all -> 0x0057 }
            io.sentry.Session r2 = r2.clone()     // Catch:{ all -> 0x0057 }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0057 }
            r3 = r1
            goto L_0x0055
        L_0x0045:
            io.sentry.SentryOptions r1 = r8.f31215k     // Catch:{ all -> 0x0057 }
            io.sentry.h0 r1 = r1.getLogger()     // Catch:{ all -> 0x0057 }
            io.sentry.SentryLevel r2 = io.sentry.SentryLevel.WARNING     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = "Release is not set on SentryOptions. Session could not be started"
            r5 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0057 }
            r1.c(r2, r4, r5)     // Catch:{ all -> 0x0057 }
        L_0x0055:
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            return r3
        L_0x0057:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.e2.w():io.sentry.e2$c");
    }

    /* access modifiers changed from: package-private */
    public Session x(a aVar) {
        Session session;
        synchronized (this.f31217m) {
            aVar.a(this.f31216l);
            if (this.f31216l != null) {
                session = this.f31216l.clone();
            } else {
                session = null;
            }
        }
        return session;
    }

    @ApiStatus.Internal
    public void y(b bVar) {
        synchronized (this.f31218n) {
            bVar.a(this.f31206b);
        }
    }

    e2(e2 e2Var) {
        this.f31206b = e2Var.f31206b;
        this.f31207c = e2Var.f31207c;
        this.f31216l = e2Var.f31216l;
        this.f31215k = e2Var.f31215k;
        this.f31205a = e2Var.f31205a;
        x xVar = e2Var.f31208d;
        j jVar = null;
        this.f31208d = xVar != null ? new x(xVar) : null;
        j jVar2 = e2Var.f31209e;
        this.f31209e = jVar2 != null ? new j(jVar2) : jVar;
        this.f31210f = new ArrayList(e2Var.f31210f);
        this.f31214j = new CopyOnWriteArrayList(e2Var.f31214j);
        d[] dVarArr = (d[]) e2Var.f31211g.toArray(new d[0]);
        Queue<d> c10 = c(e2Var.f31215k.getMaxBreadcrumbs());
        for (d dVar : dVarArr) {
            c10.add(new d(dVar));
        }
        this.f31211g = c10;
        Map<String, String> map = e2Var.f31212h;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (next != null) {
                concurrentHashMap.put((String) next.getKey(), (String) next.getValue());
            }
        }
        this.f31212h = concurrentHashMap;
        Map<String, Object> map2 = e2Var.f31213i;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        for (Map.Entry next2 : map2.entrySet()) {
            if (next2 != null) {
                concurrentHashMap2.put((String) next2.getKey(), next2.getValue());
            }
        }
        this.f31213i = concurrentHashMap2;
        this.f31219o = new Contexts(e2Var.f31219o);
        this.f31220p = new CopyOnWriteArrayList(e2Var.f31220p);
    }
}
