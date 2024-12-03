package androidx.work.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.WorkerParameters;
import androidx.work.a;
import androidx.work.impl.background.systemjob.g;
import androidx.work.impl.utils.ForceStopRunnable;
import b2.f;
import b2.h;
import b2.j;
import b2.m;
import f2.n;
import h2.o;
import h2.r;
import h2.s;
import i2.b;
import i2.c;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class e0 extends m {

    /* renamed from: k  reason: collision with root package name */
    private static final String f7488k = f.i("WorkManagerImpl");

    /* renamed from: l  reason: collision with root package name */
    private static e0 f7489l = null;

    /* renamed from: m  reason: collision with root package name */
    private static e0 f7490m = null;

    /* renamed from: n  reason: collision with root package name */
    private static final Object f7491n = new Object();

    /* renamed from: a  reason: collision with root package name */
    private Context f7492a;

    /* renamed from: b  reason: collision with root package name */
    private androidx.work.a f7493b;

    /* renamed from: c  reason: collision with root package name */
    private WorkDatabase f7494c;

    /* renamed from: d  reason: collision with root package name */
    private b f7495d;

    /* renamed from: e  reason: collision with root package name */
    private List<t> f7496e;

    /* renamed from: f  reason: collision with root package name */
    private r f7497f;

    /* renamed from: g  reason: collision with root package name */
    private o f7498g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f7499h;

    /* renamed from: i  reason: collision with root package name */
    private BroadcastReceiver.PendingResult f7500i;

    /* renamed from: j  reason: collision with root package name */
    private final n f7501j;

    static class a {
        static boolean a(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    public e0(@NonNull Context context, @NonNull androidx.work.a aVar, @NonNull b bVar) {
        this(context, aVar, bVar, context.getResources().getBoolean(j.workmanager_test_configuration));
    }

    public static void d(@NonNull Context context, @NonNull androidx.work.a aVar) {
        synchronized (f7491n) {
            e0 e0Var = f7489l;
            if (e0Var != null) {
                if (f7490m != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
            }
            if (e0Var == null) {
                Context applicationContext = context.getApplicationContext();
                if (f7490m == null) {
                    f7490m = new e0(applicationContext, aVar, new c(aVar.m()));
                }
                f7489l = f7490m;
            }
        }
    }

    @Deprecated
    public static e0 i() {
        synchronized (f7491n) {
            e0 e0Var = f7489l;
            if (e0Var != null) {
                return e0Var;
            }
            e0 e0Var2 = f7490m;
            return e0Var2;
        }
    }

    @NonNull
    public static e0 j(@NonNull Context context) {
        e0 i10;
        synchronized (f7491n) {
            i10 = i();
            if (i10 == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext instanceof a.c) {
                    d(applicationContext, ((a.c) applicationContext).a());
                    i10 = j(applicationContext);
                } else {
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            }
        }
        return i10;
    }

    private void q(@NonNull Context context, @NonNull androidx.work.a aVar, @NonNull b bVar, @NonNull WorkDatabase workDatabase, @NonNull List<t> list, @NonNull r rVar) {
        Context applicationContext = context.getApplicationContext();
        this.f7492a = applicationContext;
        this.f7493b = aVar;
        this.f7495d = bVar;
        this.f7494c = workDatabase;
        this.f7496e = list;
        this.f7497f = rVar;
        this.f7498g = new o(workDatabase);
        this.f7499h = false;
        if (!a.a(applicationContext)) {
            this.f7495d.c(new ForceStopRunnable(applicationContext, this));
            return;
        }
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }

    @NonNull
    public h b(@NonNull List<? extends b2.n> list) {
        if (!list.isEmpty()) {
            return new x(this, list).a();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    @NonNull
    public h e(@NonNull UUID uuid) {
        h2.c b10 = h2.c.b(uuid, this);
        this.f7495d.c(b10);
        return b10.d();
    }

    @NonNull
    public List<t> f(@NonNull Context context, @NonNull androidx.work.a aVar, @NonNull n nVar) {
        return Arrays.asList(new t[]{u.a(context, this), new c2.b(context, aVar, nVar, this)});
    }

    @NonNull
    public Context g() {
        return this.f7492a;
    }

    @NonNull
    public androidx.work.a h() {
        return this.f7493b;
    }

    @NonNull
    public o k() {
        return this.f7498g;
    }

    @NonNull
    public r l() {
        return this.f7497f;
    }

    @NonNull
    public List<t> m() {
        return this.f7496e;
    }

    @NonNull
    public n n() {
        return this.f7501j;
    }

    @NonNull
    public WorkDatabase o() {
        return this.f7494c;
    }

    @NonNull
    public b p() {
        return this.f7495d;
    }

    public void r() {
        synchronized (f7491n) {
            this.f7499h = true;
            BroadcastReceiver.PendingResult pendingResult = this.f7500i;
            if (pendingResult != null) {
                pendingResult.finish();
                this.f7500i = null;
            }
        }
    }

    public void s() {
        g.a(g());
        o().K().l();
        u.b(h(), o(), m());
    }

    public void t(@NonNull BroadcastReceiver.PendingResult pendingResult) {
        synchronized (f7491n) {
            BroadcastReceiver.PendingResult pendingResult2 = this.f7500i;
            if (pendingResult2 != null) {
                pendingResult2.finish();
            }
            this.f7500i = pendingResult;
            if (this.f7499h) {
                pendingResult.finish();
                this.f7500i = null;
            }
        }
    }

    public void u(@NonNull v vVar) {
        v(vVar, (WorkerParameters.a) null);
    }

    public void v(@NonNull v vVar, WorkerParameters.a aVar) {
        this.f7495d.c(new r(this, vVar, aVar));
    }

    public void w(@NonNull g2.m mVar) {
        this.f7495d.c(new s(this, new v(mVar), true));
    }

    public void x(@NonNull v vVar) {
        this.f7495d.c(new s(this, vVar, false));
    }

    public e0(@NonNull Context context, @NonNull androidx.work.a aVar, @NonNull b bVar, boolean z10) {
        this(context, aVar, bVar, WorkDatabase.E(context.getApplicationContext(), bVar.b(), z10));
    }

    public e0(@NonNull Context context, @NonNull androidx.work.a aVar, @NonNull b bVar, @NonNull WorkDatabase workDatabase) {
        Context applicationContext = context.getApplicationContext();
        f.h(new f.a(aVar.j()));
        n nVar = new n(applicationContext, bVar);
        this.f7501j = nVar;
        Context context2 = context;
        androidx.work.a aVar2 = aVar;
        b bVar2 = bVar;
        WorkDatabase workDatabase2 = workDatabase;
        List<t> f10 = f(applicationContext, aVar, nVar);
        q(context2, aVar2, bVar2, workDatabase2, f10, new r(context2, aVar2, bVar2, workDatabase2, f10));
    }
}
