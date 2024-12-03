package com.google.android.play.integrity.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.integrity.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class z {

    /* renamed from: o  reason: collision with root package name */
    private static final Map f20529o = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f20530a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final n f20531b;

    /* renamed from: c  reason: collision with root package name */
    private final String f20532c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final List f20533d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final Set f20534e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private final Object f20535f = new Object();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f20536g;

    /* renamed from: h  reason: collision with root package name */
    private final Intent f20537h;

    /* renamed from: i  reason: collision with root package name */
    private final WeakReference f20538i;

    /* renamed from: j  reason: collision with root package name */
    private final IBinder.DeathRecipient f20539j = new q(this);

    /* renamed from: k  reason: collision with root package name */
    private final AtomicInteger f20540k = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public ServiceConnection f20541l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public IInterface f20542m;

    /* renamed from: n  reason: collision with root package name */
    private final q f20543n;

    public z(Context context, n nVar, String str, Intent intent, q qVar, t tVar, byte[] bArr) {
        this.f20530a = context;
        this.f20531b = nVar;
        this.f20532c = "IntegrityService";
        this.f20537h = intent;
        this.f20543n = qVar;
        this.f20538i = new WeakReference((Object) null);
    }

    public static /* synthetic */ void h(z zVar) {
        zVar.f20531b.d("reportBinderDeath", new Object[0]);
        t tVar = (t) zVar.f20538i.get();
        if (tVar != null) {
            zVar.f20531b.d("calling onBinderDied", new Object[0]);
            tVar.a();
        } else {
            zVar.f20531b.d("%s : Binder has died.", zVar.f20532c);
            for (o a10 : zVar.f20533d) {
                a10.a(zVar.s());
            }
            zVar.f20533d.clear();
        }
        zVar.t();
    }

    static /* bridge */ /* synthetic */ void m(z zVar, o oVar) {
        if (zVar.f20542m == null && !zVar.f20536g) {
            zVar.f20531b.d("Initiate binding to the service.", new Object[0]);
            zVar.f20533d.add(oVar);
            y yVar = new y(zVar, (x) null);
            zVar.f20541l = yVar;
            zVar.f20536g = true;
            if (!zVar.f20530a.bindService(zVar.f20537h, yVar, 1)) {
                zVar.f20531b.d("Failed to bind to the service.", new Object[0]);
                zVar.f20536g = false;
                for (o a10 : zVar.f20533d) {
                    a10.a(new w());
                }
                zVar.f20533d.clear();
            }
        } else if (zVar.f20536g) {
            zVar.f20531b.d("Waiting to bind to the service.", new Object[0]);
            zVar.f20533d.add(oVar);
        } else {
            oVar.run();
        }
    }

    static /* bridge */ /* synthetic */ void n(z zVar) {
        zVar.f20531b.d("linkToDeath", new Object[0]);
        try {
            zVar.f20542m.asBinder().linkToDeath(zVar.f20539j, 0);
        } catch (RemoteException e10) {
            zVar.f20531b.c(e10, "linkToDeath failed", new Object[0]);
        }
    }

    static /* bridge */ /* synthetic */ void o(z zVar) {
        zVar.f20531b.d("unlinkToDeath", new Object[0]);
        zVar.f20542m.asBinder().unlinkToDeath(zVar.f20539j, 0);
    }

    private final RemoteException s() {
        return new RemoteException(String.valueOf(this.f20532c).concat(" : Binder has died."));
    }

    /* access modifiers changed from: private */
    public final void t() {
        synchronized (this.f20535f) {
            for (TaskCompletionSource trySetException : this.f20534e) {
                trySetException.trySetException(s());
            }
            this.f20534e.clear();
        }
    }

    public final Handler c() {
        Handler handler;
        Map map = f20529o;
        synchronized (map) {
            if (!map.containsKey(this.f20532c)) {
                HandlerThread handlerThread = new HandlerThread(this.f20532c, 10);
                handlerThread.start();
                map.put(this.f20532c, new Handler(handlerThread.getLooper()));
            }
            handler = (Handler) map.get(this.f20532c);
        }
        return handler;
    }

    public final IInterface e() {
        return this.f20542m;
    }

    public final void p(o oVar, TaskCompletionSource taskCompletionSource) {
        synchronized (this.f20535f) {
            this.f20534e.add(taskCompletionSource);
            taskCompletionSource.getTask().addOnCompleteListener(new p(this, taskCompletionSource));
        }
        synchronized (this.f20535f) {
            if (this.f20540k.getAndIncrement() > 0) {
                this.f20531b.a("Already connected to the service.", new Object[0]);
            }
        }
        c().post(new r(this, oVar.c(), oVar));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void q(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.f20535f) {
            this.f20534e.remove(taskCompletionSource);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
        c().post(new com.google.android.play.integrity.internal.s(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void r(com.google.android.gms.tasks.TaskCompletionSource r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f20535f
            monitor-enter(r0)
            java.util.Set r1 = r3.f20534e     // Catch:{ all -> 0x0039 }
            r1.remove(r4)     // Catch:{ all -> 0x0039 }
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            java.lang.Object r4 = r3.f20535f
            monitor-enter(r4)
            java.util.concurrent.atomic.AtomicInteger r0 = r3.f20540k     // Catch:{ all -> 0x0036 }
            int r0 = r0.get()     // Catch:{ all -> 0x0036 }
            if (r0 <= 0) goto L_0x0028
            java.util.concurrent.atomic.AtomicInteger r0 = r3.f20540k     // Catch:{ all -> 0x0036 }
            int r0 = r0.decrementAndGet()     // Catch:{ all -> 0x0036 }
            if (r0 <= 0) goto L_0x0028
            com.google.android.play.integrity.internal.n r0 = r3.f20531b     // Catch:{ all -> 0x0036 }
            java.lang.String r1 = "Leaving the connection open for other ongoing calls."
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0036 }
            r0.d(r1, r2)     // Catch:{ all -> 0x0036 }
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            return
        L_0x0028:
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            com.google.android.play.integrity.internal.s r4 = new com.google.android.play.integrity.internal.s
            r4.<init>(r3)
            android.os.Handler r0 = r3.c()
            r0.post(r4)
            return
        L_0x0036:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            throw r0
        L_0x0039:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.integrity.internal.z.r(com.google.android.gms.tasks.TaskCompletionSource):void");
    }
}
