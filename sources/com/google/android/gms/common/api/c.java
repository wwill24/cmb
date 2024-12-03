package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.b;
import com.google.android.gms.common.api.internal.c0;
import com.google.android.gms.common.api.internal.g;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.common.api.internal.l1;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.api.internal.o;
import com.google.android.gms.common.api.internal.o2;
import com.google.android.gms.common.api.internal.q1;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.api.internal.x;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public abstract class c<O extends a.d> {
    @NonNull
    protected final g zaa;
    private final Context zab;
    private final String zac;
    private final a zad;
    private final a.d zae;
    private final b zaf;
    private final Looper zag;
    private final int zah;
    @NotOnlyInitialized
    private final d zai;
    private final t zaj;

    public static class a {
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public static final a f38516c = new C0482a().a();
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final t f38517a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final Looper f38518b;

        /* renamed from: com.google.android.gms.common.api.c$a$a  reason: collision with other inner class name */
        public static class C0482a {

            /* renamed from: a  reason: collision with root package name */
            private t f38519a;

            /* renamed from: b  reason: collision with root package name */
            private Looper f38520b;

            @NonNull
            public a a() {
                if (this.f38519a == null) {
                    this.f38519a = new com.google.android.gms.common.api.internal.a();
                }
                if (this.f38520b == null) {
                    this.f38520b = Looper.getMainLooper();
                }
                return new a(this.f38519a, this.f38520b);
            }

            @NonNull
            public C0482a b(@NonNull Looper looper) {
                p.l(looper, "Looper must not be null.");
                this.f38520b = looper;
                return this;
            }

            @NonNull
            public C0482a c(@NonNull t tVar) {
                p.l(tVar, "StatusExceptionMapper must not be null.");
                this.f38519a = tVar;
                return this;
            }
        }

        private a(t tVar, Account account, Looper looper) {
            this.f38517a = tVar;
            this.f38518b = looper;
        }
    }

    public c(@NonNull Activity activity, @NonNull a<O> aVar, @NonNull O o10, @NonNull a aVar2) {
        this((Context) activity, activity, (a) aVar, (a.d) o10, aVar2);
    }

    private final com.google.android.gms.common.api.internal.d zad(int i10, @NonNull com.google.android.gms.common.api.internal.d dVar) {
        dVar.zak();
        this.zaa.H(this, i10, dVar);
        return dVar;
    }

    private final Task zae(int i10, @NonNull v vVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaa.I(this, i10, vVar, taskCompletionSource, this.zaj);
        return taskCompletionSource.getTask();
    }

    @NonNull
    public d asGoogleApiClient() {
        return this.zai;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public e.a createClientSettingsBuilder() {
        Account account;
        Set<Scope> set;
        GoogleSignInAccount F;
        e.a aVar = new e.a();
        a.d dVar = this.zae;
        if (!(dVar instanceof a.d.b) || (F = ((a.d.b) dVar).F()) == null) {
            a.d dVar2 = this.zae;
            if (dVar2 instanceof a.d.C0481a) {
                account = ((a.d.C0481a) dVar2).O();
            } else {
                account = null;
            }
        } else {
            account = F.O();
        }
        aVar.d(account);
        a.d dVar3 = this.zae;
        if (dVar3 instanceof a.d.b) {
            GoogleSignInAccount F2 = ((a.d.b) dVar3).F();
            if (F2 == null) {
                set = Collections.emptySet();
            } else {
                set = F2.f0();
            }
        } else {
            set = Collections.emptySet();
        }
        aVar.c(set);
        aVar.e(this.zab.getClass().getName());
        aVar.b(this.zab.getPackageName());
        return aVar;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Task<Boolean> disconnectService() {
        return this.zaa.A(this);
    }

    @NonNull
    public <A extends a.b, T extends com.google.android.gms.common.api.internal.d<? extends j, A>> T doBestEffortWrite(@NonNull T t10) {
        zad(2, t10);
        return t10;
    }

    @NonNull
    public <A extends a.b, T extends com.google.android.gms.common.api.internal.d<? extends j, A>> T doRead(@NonNull T t10) {
        zad(0, t10);
        return t10;
    }

    @NonNull
    @Deprecated
    public <A extends a.b, T extends o<A, ?>, U extends x<A, ?>> Task<Void> doRegisterEventListener(@NonNull T t10, @NonNull U u10) {
        p.k(t10);
        p.k(u10);
        p.l(t10.b(), "Listener has already been released.");
        p.l(u10.a(), "Listener has already been released.");
        p.b(n.b(t10.b(), u10.a()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.zaa.B(this, t10, u10, p.f38860a);
    }

    @NonNull
    public Task<Boolean> doUnregisterEventListener(@NonNull k.a<?> aVar) {
        return doUnregisterEventListener(aVar, 0);
    }

    @NonNull
    public <A extends a.b, T extends com.google.android.gms.common.api.internal.d<? extends j, A>> T doWrite(@NonNull T t10) {
        zad(1, t10);
        return t10;
    }

    @NonNull
    public final b<O> getApiKey() {
        return this.zaf;
    }

    @NonNull
    public O getApiOptions() {
        return this.zae;
    }

    @NonNull
    public Context getApplicationContext() {
        return this.zab;
    }

    /* access modifiers changed from: protected */
    public String getContextAttributionTag() {
        return this.zac;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public String getContextFeatureId() {
        return this.zac;
    }

    @NonNull
    public Looper getLooper() {
        return this.zag;
    }

    @NonNull
    public <L> k<L> registerListener(@NonNull L l10, @NonNull String str) {
        return l.a(l10, this.zag, str);
    }

    public final int zaa() {
        return this.zah;
    }

    public final a.f zab(Looper looper, l1 l1Var) {
        Looper looper2 = looper;
        a.f buildClient = ((a.C0480a) p.k(this.zad.a())).buildClient(this.zab, looper2, createClientSettingsBuilder().a(), this.zae, (d.b) l1Var, (d.c) l1Var);
        String contextAttributionTag = getContextAttributionTag();
        if (contextAttributionTag != null && (buildClient instanceof com.google.android.gms.common.internal.d)) {
            ((com.google.android.gms.common.internal.d) buildClient).setAttributionTag(contextAttributionTag);
        }
        if (contextAttributionTag != null && (buildClient instanceof m)) {
            ((m) buildClient).f(contextAttributionTag);
        }
        return buildClient;
    }

    public final o2 zac(Context context, Handler handler) {
        return new o2(context, handler, createClientSettingsBuilder().a());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public c(@androidx.annotation.NonNull android.app.Activity r2, @androidx.annotation.NonNull com.google.android.gms.common.api.a<O> r3, @androidx.annotation.NonNull O r4, @androidx.annotation.NonNull com.google.android.gms.common.api.internal.t r5) {
        /*
            r1 = this;
            com.google.android.gms.common.api.c$a$a r0 = new com.google.android.gms.common.api.c$a$a
            r0.<init>()
            r0.c(r5)
            android.os.Looper r5 = r2.getMainLooper()
            r0.b(r5)
            com.google.android.gms.common.api.c$a r5 = r0.a()
            r1.<init>((android.app.Activity) r2, r3, r4, (com.google.android.gms.common.api.c.a) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.c.<init>(android.app.Activity, com.google.android.gms.common.api.a, com.google.android.gms.common.api.a$d, com.google.android.gms.common.api.internal.t):void");
    }

    @NonNull
    public <TResult, A extends a.b> Task<TResult> doBestEffortWrite(@NonNull v<A, TResult> vVar) {
        return zae(2, vVar);
    }

    @NonNull
    public <TResult, A extends a.b> Task<TResult> doRead(@NonNull v<A, TResult> vVar) {
        return zae(0, vVar);
    }

    @NonNull
    public Task<Boolean> doUnregisterEventListener(@NonNull k.a<?> aVar, int i10) {
        p.l(aVar, "Listener key cannot be null.");
        return this.zaa.C(this, aVar, i10);
    }

    @NonNull
    public <TResult, A extends a.b> Task<TResult> doWrite(@NonNull v<A, TResult> vVar) {
        return zae(1, vVar);
    }

    private c(@NonNull Context context, Activity activity, a aVar, a.d dVar, a aVar2) {
        p.l(context, "Null context is not permitted.");
        p.l(aVar, "Api must not be null.");
        p.l(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.zab = context.getApplicationContext();
        String str = null;
        if (me.p.k()) {
            try {
                str = (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(context, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        this.zac = str;
        this.zad = aVar;
        this.zae = dVar;
        this.zag = aVar2.f38518b;
        b a10 = b.a(aVar, dVar, str);
        this.zaf = a10;
        this.zai = new q1(this);
        g y10 = g.y(this.zab);
        this.zaa = y10;
        this.zah = y10.n();
        this.zaj = aVar2.f38517a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            c0.j(activity, y10, a10);
        }
        y10.c(this);
    }

    @NonNull
    public <A extends a.b> Task<Void> doRegisterEventListener(@NonNull com.google.android.gms.common.api.internal.p<A, ?> pVar) {
        p.k(pVar);
        p.l(pVar.f38714a.b(), "Listener has already been released.");
        p.l(pVar.f38715b.a(), "Listener has already been released.");
        return this.zaa.B(this, pVar.f38714a, pVar.f38715b, pVar.f38716c);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public c(@androidx.annotation.NonNull android.content.Context r2, @androidx.annotation.NonNull com.google.android.gms.common.api.a<O> r3, @androidx.annotation.NonNull O r4, @androidx.annotation.NonNull android.os.Looper r5, @androidx.annotation.NonNull com.google.android.gms.common.api.internal.t r6) {
        /*
            r1 = this;
            com.google.android.gms.common.api.c$a$a r0 = new com.google.android.gms.common.api.c$a$a
            r0.<init>()
            r0.b(r5)
            r0.c(r6)
            com.google.android.gms.common.api.c$a r5 = r0.a()
            r1.<init>((android.content.Context) r2, r3, r4, (com.google.android.gms.common.api.c.a) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.c.<init>(android.content.Context, com.google.android.gms.common.api.a, com.google.android.gms.common.api.a$d, android.os.Looper, com.google.android.gms.common.api.internal.t):void");
    }

    public c(@NonNull Context context, @NonNull a<O> aVar, @NonNull O o10, @NonNull a aVar2) {
        this(context, (Activity) null, (a) aVar, (a.d) o10, aVar2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public c(@androidx.annotation.NonNull android.content.Context r2, @androidx.annotation.NonNull com.google.android.gms.common.api.a<O> r3, @androidx.annotation.NonNull O r4, @androidx.annotation.NonNull com.google.android.gms.common.api.internal.t r5) {
        /*
            r1 = this;
            com.google.android.gms.common.api.c$a$a r0 = new com.google.android.gms.common.api.c$a$a
            r0.<init>()
            r0.c(r5)
            com.google.android.gms.common.api.c$a r5 = r0.a()
            r1.<init>((android.content.Context) r2, r3, r4, (com.google.android.gms.common.api.c.a) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.c.<init>(android.content.Context, com.google.android.gms.common.api.a, com.google.android.gms.common.api.a$d, com.google.android.gms.common.api.internal.t):void");
    }
}
