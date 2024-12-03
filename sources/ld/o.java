package ld;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import cd.b;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import ed.h;
import ed.i;
import ed.p;
import fd.d;
import fd.e;
import fd.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import md.c;
import nd.a;

public class o {

    /* renamed from: a  reason: collision with root package name */
    private final Context f41148a;

    /* renamed from: b  reason: collision with root package name */
    private final d f41149b;

    /* renamed from: c  reason: collision with root package name */
    private final md.d f41150c;

    /* renamed from: d  reason: collision with root package name */
    private final u f41151d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f41152e;

    /* renamed from: f  reason: collision with root package name */
    private final a f41153f;

    /* renamed from: g  reason: collision with root package name */
    private final od.a f41154g;

    /* renamed from: h  reason: collision with root package name */
    private final od.a f41155h;

    /* renamed from: i  reason: collision with root package name */
    private final c f41156i;

    public o(Context context, d dVar, md.d dVar2, u uVar, Executor executor, a aVar, od.a aVar2, od.a aVar3, c cVar) {
        this.f41148a = context;
        this.f41149b = dVar;
        this.f41150c = dVar2;
        this.f41151d = uVar;
        this.f41152e = executor;
        this.f41153f = aVar;
        this.f41154g = aVar2;
        this.f41155h = aVar3;
        this.f41156i = cVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean l(p pVar) {
        return Boolean.valueOf(this.f41150c.S1(pVar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Iterable m(p pVar) {
        return this.f41150c.J1(pVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object n(Iterable iterable, p pVar, long j10) {
        this.f41150c.F0(iterable);
        this.f41150c.Z(pVar, this.f41154g.a() + j10);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object o(Iterable iterable) {
        this.f41150c.z(iterable);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object p() {
        this.f41156i.a();
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object q(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.f41156i.e((long) ((Integer) entry.getValue()).intValue(), LogEventDropped.Reason.INVALID_PAYLOD, (String) entry.getKey());
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object r(p pVar, long j10) {
        this.f41150c.Z(pVar, this.f41154g.a() + j10);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object s(p pVar, int i10) {
        this.f41151d.a(pVar, i10 + 1);
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        r6.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0024, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r3.f41151d.a(r4, r5 + 1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0026 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void t(ed.p r4, int r5, java.lang.Runnable r6) {
        /*
            r3 = this;
            nd.a r0 = r3.f41153f     // Catch:{ SynchronizationException -> 0x0026 }
            md.d r1 = r3.f41150c     // Catch:{ SynchronizationException -> 0x0026 }
            java.util.Objects.requireNonNull(r1)     // Catch:{ SynchronizationException -> 0x0026 }
            ld.n r2 = new ld.n     // Catch:{ SynchronizationException -> 0x0026 }
            r2.<init>(r1)     // Catch:{ SynchronizationException -> 0x0026 }
            r0.b(r2)     // Catch:{ SynchronizationException -> 0x0026 }
            boolean r0 = r3.k()     // Catch:{ SynchronizationException -> 0x0026 }
            if (r0 != 0) goto L_0x0020
            nd.a r0 = r3.f41153f     // Catch:{ SynchronizationException -> 0x0026 }
            ld.e r1 = new ld.e     // Catch:{ SynchronizationException -> 0x0026 }
            r1.<init>(r3, r4, r5)     // Catch:{ SynchronizationException -> 0x0026 }
            r0.b(r1)     // Catch:{ SynchronizationException -> 0x0026 }
            goto L_0x002d
        L_0x0020:
            r3.u(r4, r5)     // Catch:{ SynchronizationException -> 0x0026 }
            goto L_0x002d
        L_0x0024:
            r4 = move-exception
            goto L_0x0031
        L_0x0026:
            ld.u r0 = r3.f41151d     // Catch:{ all -> 0x0024 }
            int r5 = r5 + 1
            r0.a(r4, r5)     // Catch:{ all -> 0x0024 }
        L_0x002d:
            r6.run()
            return
        L_0x0031:
            r6.run()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ld.o.t(ed.p, int, java.lang.Runnable):void");
    }

    public i j(k kVar) {
        a aVar = this.f41153f;
        c cVar = this.f41156i;
        Objects.requireNonNull(cVar);
        return kVar.a(i.a().i(this.f41154g.a()).k(this.f41155h.a()).j("GDT_CLIENT_METRICS").h(new h(b.b("proto"), ((hd.a) aVar.b(new l(cVar))).f())).d());
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f41148a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public BackendResponse u(p pVar, int i10) {
        BackendResponse b10;
        k kVar = this.f41149b.get(pVar.b());
        long j10 = 0;
        BackendResponse e10 = BackendResponse.e(0);
        while (true) {
            long j11 = j10;
            while (((Boolean) this.f41153f.b(new d(this, pVar))).booleanValue()) {
                Iterable<md.k> iterable = (Iterable) this.f41153f.b(new f(this, pVar));
                if (!iterable.iterator().hasNext()) {
                    return e10;
                }
                if (kVar == null) {
                    id.a.b("Uploader", "Unknown backend for %s, deleting event batch for it...", pVar);
                    b10 = BackendResponse.a();
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (md.k b11 : iterable) {
                        arrayList.add(b11.b());
                    }
                    if (pVar.e()) {
                        arrayList.add(j(kVar));
                    }
                    b10 = kVar.b(e.a().b(arrayList).c(pVar.c()).a());
                }
                e10 = b10;
                if (e10.c() == BackendResponse.Status.TRANSIENT_ERROR) {
                    this.f41153f.b(new g(this, iterable, pVar, j11));
                    this.f41151d.b(pVar, i10 + 1, true);
                    return e10;
                }
                this.f41153f.b(new h(this, iterable));
                if (e10.c() == BackendResponse.Status.f38132a) {
                    j10 = Math.max(j11, e10.b());
                    if (pVar.e()) {
                        this.f41153f.b(new i(this));
                    }
                } else if (e10.c() == BackendResponse.Status.INVALID_PAYLOAD) {
                    HashMap hashMap = new HashMap();
                    for (md.k b12 : iterable) {
                        String j12 = b12.b().j();
                        if (!hashMap.containsKey(j12)) {
                            hashMap.put(j12, 1);
                        } else {
                            hashMap.put(j12, Integer.valueOf(((Integer) hashMap.get(j12)).intValue() + 1));
                        }
                    }
                    this.f41153f.b(new j(this, hashMap));
                }
            }
            this.f41153f.b(new k(this, pVar, j11));
            return e10;
        }
    }

    public void v(p pVar, int i10, Runnable runnable) {
        this.f41152e.execute(new m(this, pVar, i10, runnable));
    }
}
