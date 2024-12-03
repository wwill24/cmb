package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.room.i;
import androidx.room.j;
import androidx.room.m;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010C\u001a\u00020\u0014\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\bF\u0010GR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00188\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u000f\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R$\u0010,\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0017\u00101\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b(\u0010.\u001a\u0004\b/\u00100R\u0017\u00107\u001a\u0002028\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0017\u0010<\u001a\u0002088\u0006¢\u0006\f\n\u0004\b5\u00109\u001a\u0004\b:\u0010;R\u0017\u0010A\u001a\u00020=8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b3\u0010@R\u0017\u0010B\u001a\u00020=8\u0006¢\u0006\f\n\u0004\b\"\u0010?\u001a\u0004\b&\u0010@¨\u0006H"}, d2 = {"Landroidx/room/p;", "", "", "a", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "Landroidx/room/m;", "b", "Landroidx/room/m;", "e", "()Landroidx/room/m;", "invalidationTracker", "Ljava/util/concurrent/Executor;", "c", "Ljava/util/concurrent/Executor;", "d", "()Ljava/util/concurrent/Executor;", "executor", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "Landroid/content/Context;", "appContext", "", "I", "()I", "setClientId", "(I)V", "clientId", "Landroidx/room/m$c;", "f", "Landroidx/room/m$c;", "()Landroidx/room/m$c;", "l", "(Landroidx/room/m$c;)V", "observer", "Landroidx/room/j;", "g", "Landroidx/room/j;", "h", "()Landroidx/room/j;", "m", "(Landroidx/room/j;)V", "service", "Landroidx/room/i;", "Landroidx/room/i;", "getCallback", "()Landroidx/room/i;", "callback", "Ljava/util/concurrent/atomic/AtomicBoolean;", "i", "Ljava/util/concurrent/atomic/AtomicBoolean;", "j", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "stopped", "Landroid/content/ServiceConnection;", "Landroid/content/ServiceConnection;", "getServiceConnection", "()Landroid/content/ServiceConnection;", "serviceConnection", "Ljava/lang/Runnable;", "k", "Ljava/lang/Runnable;", "()Ljava/lang/Runnable;", "setUpRunnable", "removeObserverRunnable", "context", "Landroid/content/Intent;", "serviceIntent", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroidx/room/m;Ljava/util/concurrent/Executor;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private final String f6934a;

    /* renamed from: b  reason: collision with root package name */
    private final m f6935b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f6936c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f6937d;

    /* renamed from: e  reason: collision with root package name */
    private int f6938e;

    /* renamed from: f  reason: collision with root package name */
    public m.c f6939f;

    /* renamed from: g  reason: collision with root package name */
    private j f6940g;

    /* renamed from: h  reason: collision with root package name */
    private final i f6941h = new b(this);

    /* renamed from: i  reason: collision with root package name */
    private final AtomicBoolean f6942i = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    private final ServiceConnection f6943j;

    /* renamed from: k  reason: collision with root package name */
    private final Runnable f6944k;

    /* renamed from: l  reason: collision with root package name */
    private final Runnable f6945l;

    @Metadata(bv = {}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u0014\u0010\n\u001a\u00020\u00078PX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"androidx/room/p$a", "Landroidx/room/m$c;", "", "", "tables", "", "c", "", "b", "()Z", "isRemote", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class a extends m.c {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f6946b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(p pVar, String[] strArr) {
            super(strArr);
            this.f6946b = pVar;
        }

        public boolean b() {
            return true;
        }

        public void c(Set<String> set) {
            j.g(set, "tables");
            if (!this.f6946b.j().get()) {
                try {
                    j h10 = this.f6946b.h();
                    if (h10 != null) {
                        int c10 = this.f6946b.c();
                        Object[] array2 = set.toArray(new String[0]);
                        j.e(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        h10.D(c10, (String[]) array2);
                    }
                } catch (RemoteException unused) {
                }
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"androidx/room/p$b", "Landroidx/room/i$a;", "", "", "tables", "", "l", "([Ljava/lang/String;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class b extends i.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f6947a;

        b(p pVar) {
            this.f6947a = pVar;
        }

        /* access modifiers changed from: private */
        public static final void g(p pVar, String[] strArr) {
            j.g(pVar, "this$0");
            j.g(strArr, "$tables");
            pVar.e().k((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public void l(String[] strArr) {
            j.g(strArr, "tables");
            this.f6947a.d().execute(new q(this.f6947a, strArr));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"androidx/room/p$c", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "service", "", "onServiceConnected", "onServiceDisconnected", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class c implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f6948a;

        c(p pVar) {
            this.f6948a = pVar;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            j.g(componentName, "name");
            j.g(iBinder, "service");
            this.f6948a.m(j.a.c(iBinder));
            this.f6948a.d().execute(this.f6948a.i());
        }

        public void onServiceDisconnected(ComponentName componentName) {
            kotlin.jvm.internal.j.g(componentName, "name");
            this.f6948a.d().execute(this.f6948a.g());
            this.f6948a.m((j) null);
        }
    }

    public p(Context context, String str, Intent intent, m mVar, Executor executor) {
        kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
        kotlin.jvm.internal.j.g(str, "name");
        kotlin.jvm.internal.j.g(intent, "serviceIntent");
        kotlin.jvm.internal.j.g(mVar, "invalidationTracker");
        kotlin.jvm.internal.j.g(executor, "executor");
        this.f6934a = str;
        this.f6935b = mVar;
        this.f6936c = executor;
        Context applicationContext = context.getApplicationContext();
        this.f6937d = applicationContext;
        c cVar = new c(this);
        this.f6943j = cVar;
        this.f6944k = new n(this);
        this.f6945l = new o(this);
        Object[] array2 = mVar.i().keySet().toArray(new String[0]);
        kotlin.jvm.internal.j.e(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        l(new a(this, (String[]) array2));
        applicationContext.bindService(intent, cVar, 1);
    }

    /* access modifiers changed from: private */
    public static final void k(p pVar) {
        kotlin.jvm.internal.j.g(pVar, "this$0");
        pVar.f6935b.n(pVar.f());
    }

    /* access modifiers changed from: private */
    public static final void n(p pVar) {
        kotlin.jvm.internal.j.g(pVar, "this$0");
        try {
            j jVar = pVar.f6940g;
            if (jVar != null) {
                pVar.f6938e = jVar.Q(pVar.f6941h, pVar.f6934a);
                pVar.f6935b.c(pVar.f());
            }
        } catch (RemoteException unused) {
        }
    }

    public final int c() {
        return this.f6938e;
    }

    public final Executor d() {
        return this.f6936c;
    }

    public final m e() {
        return this.f6935b;
    }

    public final m.c f() {
        m.c cVar = this.f6939f;
        if (cVar != null) {
            return cVar;
        }
        kotlin.jvm.internal.j.y("observer");
        return null;
    }

    public final Runnable g() {
        return this.f6945l;
    }

    public final j h() {
        return this.f6940g;
    }

    public final Runnable i() {
        return this.f6944k;
    }

    public final AtomicBoolean j() {
        return this.f6942i;
    }

    public final void l(m.c cVar) {
        kotlin.jvm.internal.j.g(cVar, "<set-?>");
        this.f6939f = cVar;
    }

    public final void m(j jVar) {
        this.f6940g = jVar;
    }
}
