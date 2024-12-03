package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.collection.b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.j0;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import me.j;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public class g implements Handler.Callback {
    @NonNull

    /* renamed from: r  reason: collision with root package name */
    public static final Status f38604r = new Status(4, "Sign-out occurred while this API call was in progress.");
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public static final Status f38605s = new Status(4, "The user must be signed in to make this API call.");
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public static final Object f38606t = new Object();

    /* renamed from: u  reason: collision with root package name */
    private static g f38607u;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public long f38608a = 5000;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public long f38609b = 120000;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public long f38610c = 10000;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f38611d = false;

    /* renamed from: e  reason: collision with root package name */
    private TelemetryData f38612e;

    /* renamed from: f  reason: collision with root package name */
    private t f38613f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final Context f38614g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final c f38615h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final j0 f38616i;

    /* renamed from: j  reason: collision with root package name */
    private final AtomicInteger f38617j = new AtomicInteger(1);

    /* renamed from: k  reason: collision with root package name */
    private final AtomicInteger f38618k = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final Map f38619l = new ConcurrentHashMap(5, 0.75f, 1);
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public c0 f38620m = null;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final Set f38621n = new b();

    /* renamed from: o  reason: collision with root package name */
    private final Set f38622o = new b();
    /* access modifiers changed from: private */
    @NotOnlyInitialized

    /* renamed from: p  reason: collision with root package name */
    public final Handler f38623p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public volatile boolean f38624q = true;

    private g(Context context, Looper looper, c cVar) {
        this.f38614g = context;
        zau zau = new zau(looper, this);
        this.f38623p = zau;
        this.f38615h = cVar;
        this.f38616i = new j0(cVar);
        if (j.a(context)) {
            this.f38624q = false;
        }
        zau.sendMessage(zau.obtainMessage(6));
    }

    public static void a() {
        synchronized (f38606t) {
            g gVar = f38607u;
            if (gVar != null) {
                gVar.f38618k.incrementAndGet();
                Handler handler = gVar.f38623p;
                handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
            }
        }
    }

    /* access modifiers changed from: private */
    public static Status i(b bVar, ConnectionResult connectionResult) {
        String b10 = bVar.b();
        String valueOf = String.valueOf(connectionResult);
        return new Status(connectionResult, "API: " + b10 + " is not available on this device. Connection failed with: " + valueOf);
    }

    private final l1 j(com.google.android.gms.common.api.c cVar) {
        b apiKey = cVar.getApiKey();
        l1 l1Var = (l1) this.f38619l.get(apiKey);
        if (l1Var == null) {
            l1Var = new l1(this, cVar);
            this.f38619l.put(apiKey, l1Var);
        }
        if (l1Var.P()) {
            this.f38622o.add(apiKey);
        }
        l1Var.E();
        return l1Var;
    }

    private final t k() {
        if (this.f38613f == null) {
            this.f38613f = s.a(this.f38614g);
        }
        return this.f38613f;
    }

    private final void l() {
        TelemetryData telemetryData = this.f38612e;
        if (telemetryData != null) {
            if (telemetryData.S() > 0 || g()) {
                k().a(telemetryData);
            }
            this.f38612e = null;
        }
    }

    private final void m(TaskCompletionSource taskCompletionSource, int i10, com.google.android.gms.common.api.c cVar) {
        y1 a10;
        if (i10 != 0 && (a10 = y1.a(this, i10, cVar.getApiKey())) != null) {
            Task task = taskCompletionSource.getTask();
            Handler handler = this.f38623p;
            handler.getClass();
            task.addOnCompleteListener((Executor) new f1(handler), a10);
        }
    }

    @NonNull
    public static g y(@NonNull Context context) {
        g gVar;
        synchronized (f38606t) {
            if (f38607u == null) {
                f38607u = new g(context.getApplicationContext(), com.google.android.gms.common.internal.g.c().getLooper(), c.p());
            }
            gVar = f38607u;
        }
        return gVar;
    }

    @NonNull
    public final Task A(@NonNull com.google.android.gms.common.api.c cVar) {
        d0 d0Var = new d0(cVar.getApiKey());
        Handler handler = this.f38623p;
        handler.sendMessage(handler.obtainMessage(14, d0Var));
        return d0Var.b().getTask();
    }

    @NonNull
    public final Task B(@NonNull com.google.android.gms.common.api.c cVar, @NonNull o oVar, @NonNull x xVar, @NonNull Runnable runnable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        m(taskCompletionSource, oVar.e(), cVar);
        y2 y2Var = new y2(new d2(oVar, xVar, runnable), taskCompletionSource);
        Handler handler = this.f38623p;
        handler.sendMessage(handler.obtainMessage(8, new c2(y2Var, this.f38618k.get(), cVar)));
        return taskCompletionSource.getTask();
    }

    @NonNull
    public final Task C(@NonNull com.google.android.gms.common.api.c cVar, @NonNull k.a aVar, int i10) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        m(taskCompletionSource, i10, cVar);
        a3 a3Var = new a3(aVar, taskCompletionSource);
        Handler handler = this.f38623p;
        handler.sendMessage(handler.obtainMessage(13, new c2(a3Var, this.f38618k.get(), cVar)));
        return taskCompletionSource.getTask();
    }

    public final void H(@NonNull com.google.android.gms.common.api.c cVar, int i10, @NonNull d dVar) {
        x2 x2Var = new x2(i10, dVar);
        Handler handler = this.f38623p;
        handler.sendMessage(handler.obtainMessage(4, new c2(x2Var, this.f38618k.get(), cVar)));
    }

    public final void I(@NonNull com.google.android.gms.common.api.c cVar, int i10, @NonNull v vVar, @NonNull TaskCompletionSource taskCompletionSource, @NonNull t tVar) {
        m(taskCompletionSource, vVar.d(), cVar);
        z2 z2Var = new z2(i10, vVar, taskCompletionSource, tVar);
        Handler handler = this.f38623p;
        handler.sendMessage(handler.obtainMessage(4, new c2(z2Var, this.f38618k.get(), cVar)));
    }

    /* access modifiers changed from: package-private */
    public final void J(MethodInvocation methodInvocation, int i10, long j10, int i11) {
        Handler handler = this.f38623p;
        handler.sendMessage(handler.obtainMessage(18, new z1(methodInvocation, i10, j10, i11)));
    }

    public final void K(@NonNull ConnectionResult connectionResult, int i10) {
        if (!h(connectionResult, i10)) {
            Handler handler = this.f38623p;
            handler.sendMessage(handler.obtainMessage(5, i10, 0, connectionResult));
        }
    }

    public final void b() {
        Handler handler = this.f38623p;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void c(@NonNull com.google.android.gms.common.api.c cVar) {
        Handler handler = this.f38623p;
        handler.sendMessage(handler.obtainMessage(7, cVar));
    }

    public final void d(@NonNull c0 c0Var) {
        synchronized (f38606t) {
            if (this.f38620m != c0Var) {
                this.f38620m = c0Var;
                this.f38621n.clear();
            }
            this.f38621n.addAll(c0Var.i());
        }
    }

    /* access modifiers changed from: package-private */
    public final void e(@NonNull c0 c0Var) {
        synchronized (f38606t) {
            if (this.f38620m == c0Var) {
                this.f38620m = null;
                this.f38621n.clear();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean g() {
        if (this.f38611d) {
            return false;
        }
        RootTelemetryConfiguration a10 = q.b().a();
        if (a10 != null && !a10.c0()) {
            return false;
        }
        int a11 = this.f38616i.a(this.f38614g, 203400000);
        if (a11 == -1 || a11 == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean h(ConnectionResult connectionResult, int i10) {
        return this.f38615h.z(this.f38614g, connectionResult, i10);
    }

    public final boolean handleMessage(@NonNull Message message) {
        int i10 = message.what;
        long j10 = 300000;
        l1 l1Var = null;
        switch (i10) {
            case 1:
                if (true == ((Boolean) message.obj).booleanValue()) {
                    j10 = 10000;
                }
                this.f38610c = j10;
                this.f38623p.removeMessages(12);
                for (b obtainMessage : this.f38619l.keySet()) {
                    Handler handler = this.f38623p;
                    handler.sendMessageDelayed(handler.obtainMessage(12, obtainMessage), this.f38610c);
                }
                break;
            case 2:
                e3 e3Var = (e3) message.obj;
                Iterator it = e3Var.a().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        b bVar = (b) it.next();
                        l1 l1Var2 = (l1) this.f38619l.get(bVar);
                        if (l1Var2 == null) {
                            e3Var.b(bVar, new ConnectionResult(13), (String) null);
                            break;
                        } else if (l1Var2.O()) {
                            e3Var.b(bVar, ConnectionResult.f38485e, l1Var2.v().getEndpointPackageName());
                        } else {
                            ConnectionResult t10 = l1Var2.t();
                            if (t10 != null) {
                                e3Var.b(bVar, t10, (String) null);
                            } else {
                                l1Var2.J(e3Var);
                                l1Var2.E();
                            }
                        }
                    }
                }
            case 3:
                for (l1 l1Var3 : this.f38619l.values()) {
                    l1Var3.D();
                    l1Var3.E();
                }
                break;
            case 4:
            case 8:
            case 13:
                c2 c2Var = (c2) message.obj;
                l1 l1Var4 = (l1) this.f38619l.get(c2Var.f38565c.getApiKey());
                if (l1Var4 == null) {
                    l1Var4 = j(c2Var.f38565c);
                }
                if (l1Var4.P() && this.f38618k.get() != c2Var.f38564b) {
                    c2Var.f38563a.a(f38604r);
                    l1Var4.L();
                    break;
                } else {
                    l1Var4.F(c2Var.f38563a);
                    break;
                }
                break;
            case 5:
                int i11 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator it2 = this.f38619l.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        l1 l1Var5 = (l1) it2.next();
                        if (l1Var5.r() == i11) {
                            l1Var = l1Var5;
                        }
                    }
                }
                if (l1Var != null) {
                    if (connectionResult.S() != 13) {
                        l1Var.e(i(l1Var.f38661c, connectionResult));
                        break;
                    } else {
                        String g10 = this.f38615h.g(connectionResult.S());
                        String Y = connectionResult.Y();
                        l1Var.e(new Status(17, "Error resolution was canceled by the user, original error message: " + g10 + ": " + Y));
                        break;
                    }
                } else {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i11 + " while trying to fail enqueued calls.", new Exception());
                    break;
                }
            case 6:
                if (this.f38614g.getApplicationContext() instanceof Application) {
                    c.c((Application) this.f38614g.getApplicationContext());
                    c.b().a(new g1(this));
                    if (!c.b().e(true)) {
                        this.f38610c = 300000;
                        break;
                    }
                }
                break;
            case 7:
                j((com.google.android.gms.common.api.c) message.obj);
                break;
            case 9:
                if (this.f38619l.containsKey(message.obj)) {
                    ((l1) this.f38619l.get(message.obj)).K();
                    break;
                }
                break;
            case 10:
                for (b remove : this.f38622o) {
                    l1 l1Var6 = (l1) this.f38619l.remove(remove);
                    if (l1Var6 != null) {
                        l1Var6.L();
                    }
                }
                this.f38622o.clear();
                break;
            case 11:
                if (this.f38619l.containsKey(message.obj)) {
                    ((l1) this.f38619l.get(message.obj)).M();
                    break;
                }
                break;
            case 12:
                if (this.f38619l.containsKey(message.obj)) {
                    ((l1) this.f38619l.get(message.obj)).a();
                    break;
                }
                break;
            case 14:
                d0 d0Var = (d0) message.obj;
                b a10 = d0Var.a();
                if (this.f38619l.containsKey(a10)) {
                    d0Var.b().setResult(Boolean.valueOf(((l1) this.f38619l.get(a10)).q(false)));
                    break;
                } else {
                    d0Var.b().setResult(Boolean.FALSE);
                    break;
                }
            case 15:
                n1 n1Var = (n1) message.obj;
                if (this.f38619l.containsKey(n1Var.f38695a)) {
                    l1.B((l1) this.f38619l.get(n1Var.f38695a), n1Var);
                    break;
                }
                break;
            case 16:
                n1 n1Var2 = (n1) message.obj;
                if (this.f38619l.containsKey(n1Var2.f38695a)) {
                    l1.C((l1) this.f38619l.get(n1Var2.f38695a), n1Var2);
                    break;
                }
                break;
            case 17:
                l();
                break;
            case 18:
                z1 z1Var = (z1) message.obj;
                if (z1Var.f38855c != 0) {
                    TelemetryData telemetryData = this.f38612e;
                    if (telemetryData != null) {
                        List Y2 = telemetryData.Y();
                        if (telemetryData.S() != z1Var.f38854b || (Y2 != null && Y2.size() >= z1Var.f38856d)) {
                            this.f38623p.removeMessages(17);
                            l();
                        } else {
                            this.f38612e.c0(z1Var.f38853a);
                        }
                    }
                    if (this.f38612e == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(z1Var.f38853a);
                        this.f38612e = new TelemetryData(z1Var.f38854b, arrayList);
                        Handler handler2 = this.f38623p;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), z1Var.f38855c);
                        break;
                    }
                } else {
                    k().a(new TelemetryData(z1Var.f38854b, Arrays.asList(new MethodInvocation[]{z1Var.f38853a})));
                    break;
                }
                break;
            case 19:
                this.f38611d = false;
                break;
            default:
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unknown message id: ");
                sb2.append(i10);
                return false;
        }
        return true;
    }

    public final int n() {
        return this.f38617j.getAndIncrement();
    }

    /* access modifiers changed from: package-private */
    public final l1 x(b bVar) {
        return (l1) this.f38619l.get(bVar);
    }
}
