package com.coffeemeetsbagel.bakery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import c9.i;
import com.appsflyer.AppsFlyerLib;
import com.coffeemeetsbagel.bakery.h1;
import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.discover.DiscoverMatchRepository;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.SuggestedRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.feature.sync.SyncBillingUseCase;
import com.coffeemeetsbagel.feature.sync.SyncSubscriptionHistoryUseCase;
import com.coffeemeetsbagel.feature.sync.r;
import com.coffeemeetsbagel.likes_you.u0;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.profile.RefreshMyProfileUseCase;
import com.coffeemeetsbagel.profile.SaveProfilesLocalUseCase;
import com.coffeemeetsbagel.qna.QuestionGroupRefreshUseCase;
import com.coffeemeetsbagel.store.PriceRepository;
import com.coffeemeetsbagel.transport.OperationResultReceiver;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.uber.autodispose.m;
import com.uber.autodispose.p;
import d7.l;
import f6.a2;
import h5.a0;
import h5.b0;
import h5.c0;
import h5.n;
import h5.o;
import h5.q;
import h5.s;
import h5.u;
import h5.v;
import h5.w;
import h5.x;
import h5.y;
import h5.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.Executor;
import siftscience.android.Sift;

public class m1 implements h1.b, r {
    private boolean A;

    /* renamed from: a  reason: collision with root package name */
    private final Executor f11273a;

    /* renamed from: b  reason: collision with root package name */
    private final s9.a f11274b;

    /* renamed from: c  reason: collision with root package name */
    private final t f11275c;

    /* renamed from: d  reason: collision with root package name */
    private final j f11276d;

    /* renamed from: e  reason: collision with root package name */
    private final d7.c f11277e;

    /* renamed from: f  reason: collision with root package name */
    private final i f11278f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f11279g;

    /* renamed from: h  reason: collision with root package name */
    private final Queue<e> f11280h = new LinkedList();

    /* renamed from: i  reason: collision with root package name */
    private final a2 f11281i;

    /* renamed from: j  reason: collision with root package name */
    private final hb.c f11282j;

    /* renamed from: k  reason: collision with root package name */
    private final l f11283k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final ProfileContract$Manager f11284l;

    /* renamed from: m  reason: collision with root package name */
    private final UserRepository f11285m;

    /* renamed from: n  reason: collision with root package name */
    private final u0 f11286n;

    /* renamed from: o  reason: collision with root package name */
    private final QuestionGroupRefreshUseCase f11287o;

    /* renamed from: p  reason: collision with root package name */
    private final SyncBillingUseCase f11288p;

    /* renamed from: q  reason: collision with root package name */
    private final SyncSubscriptionHistoryUseCase f11289q;

    /* renamed from: r  reason: collision with root package name */
    private final SaveProfilesLocalUseCase f11290r;

    /* renamed from: s  reason: collision with root package name */
    private final FeatureFlagRepository f11291s;

    /* renamed from: t  reason: collision with root package name */
    private final DiscoverMatchRepository f11292t;

    /* renamed from: u  reason: collision with root package name */
    private final RefreshMyProfileUseCase f11293u;

    /* renamed from: v  reason: collision with root package name */
    private final AuthenticationScopeProvider f11294v;

    /* renamed from: w  reason: collision with root package name */
    private final PriceRepository f11295w;

    /* renamed from: x  reason: collision with root package name */
    private final SuggestedRepository f11296x;

    /* renamed from: y  reason: collision with root package name */
    private long f11297y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f11298z;

    class a implements jc.b<Void> {
        a() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
        }
    }

    class b implements qj.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f11300a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f11301b;

        b(long j10, e eVar) {
            this.f11300a = j10;
            this.f11301b = eVar;
        }

        public void a(tj.b bVar) {
        }

        public void onComplete() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("time taken to sync billing: ");
            sb2.append(System.currentTimeMillis() - this.f11300a);
            m1.this.c0(this.f11301b);
            m1.this.f11284l.e(new Bundle(), (v8.a) null);
        }

        public void onError(Throwable th2) {
            fa.a.g("ManagerSync", "failed to sync billing", th2);
            m1.this.c0(this.f11301b);
            fa.a.g("ManagerSync", "failed to sync billing", th2);
        }
    }

    class c implements jc.b<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f11303a;

        c(e eVar) {
            this.f11303a = eVar;
        }

        public void b(CmbErrorCode cmbErrorCode) {
            m1.this.C(this.f11303a.f11306a, cmbErrorCode);
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            m1.this.D(this.f11303a.f11306a, voidR, successStatus);
        }
    }

    class d implements jc.b<Void> {
        d() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("resultStatus=");
            sb2.append(cmbErrorCode);
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("status=");
            sb2.append(successStatus);
        }
    }

    static class e {

        /* renamed from: a  reason: collision with root package name */
        final jc.b<Void> f11306a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f11307b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f11308c;

        e(jc.b<Void> bVar, boolean z10, boolean z11) {
            this.f11306a = bVar;
            this.f11307b = z10;
            this.f11308c = z11;
        }
    }

    m1(Context context, DiscoverMatchRepository discoverMatchRepository, RefreshMyProfileUseCase refreshMyProfileUseCase, PriceRepository priceRepository, s9.a aVar, FeatureFlagRepository featureFlagRepository, t tVar, j jVar, d7.c cVar, i iVar, Executor executor, a2 a2Var, hb.c cVar2, h1 h1Var, l lVar, u0 u0Var, ProfileContract$Manager profileContract$Manager, UserRepository userRepository, SubscriptionRepository subscriptionRepository, QuestionGroupRefreshUseCase questionGroupRefreshUseCase, SyncBillingUseCase syncBillingUseCase, SyncSubscriptionHistoryUseCase syncSubscriptionHistoryUseCase, SaveProfilesLocalUseCase saveProfilesLocalUseCase, AuthenticationScopeProvider authenticationScopeProvider, SuggestedRepository suggestedRepository) {
        this.f11279g = context;
        this.f11292t = discoverMatchRepository;
        this.f11293u = refreshMyProfileUseCase;
        this.f11295w = priceRepository;
        this.f11274b = aVar;
        this.f11291s = featureFlagRepository;
        this.f11275c = tVar;
        this.f11276d = jVar;
        this.f11277e = cVar;
        this.f11278f = iVar;
        this.f11273a = executor;
        this.f11281i = a2Var;
        this.f11282j = cVar2;
        this.f11283k = lVar;
        this.f11284l = profileContract$Manager;
        this.f11285m = userRepository;
        this.f11286n = u0Var;
        this.f11287o = questionGroupRefreshUseCase;
        this.f11288p = syncBillingUseCase;
        this.f11289q = syncSubscriptionHistoryUseCase;
        this.f11290r = saveProfilesLocalUseCase;
        this.f11294v = authenticationScopeProvider;
        this.f11296x = suggestedRepository;
        h1Var.f(this);
        ((p) subscriptionRepository.t0().m0(dk.a.c()).g(com.uber.autodispose.a.a(authenticationScopeProvider))).b(new x(this, new a(), aVar), new y());
    }

    private void A() {
        if (!this.f11280h.isEmpty()) {
            e poll = this.f11280h.poll();
            a(poll.f11306a, poll.f11307b, poll.f11308c);
        }
    }

    /* access modifiers changed from: private */
    public void C(jc.b<Void> bVar, CmbErrorCode cmbErrorCode) {
        if (bVar == null) {
            fa.a.i(new Throwable("ManagerSync callback is null onReceiveError"));
        } else {
            bVar.b(cmbErrorCode);
        }
    }

    /* access modifiers changed from: private */
    public void D(jc.b<Void> bVar, Void voidR, SuccessStatus successStatus) {
        if (bVar == null) {
            fa.a.i(new Throwable("ManagerSync callback is null onReceiveSuccess"));
        } else {
            bVar.a(voidR, successStatus);
        }
        this.f11289q.e();
        String B = B();
        ((com.uber.autodispose.t) this.f11285m.z(B).K(dk.a.c()).g(com.uber.autodispose.a.a(this.f11294v))).b(new u(this, B, System.currentTimeMillis()), new v());
        this.f11283k.d();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E(String str, long j10, Integer num) throws Exception {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Appsflyer Id successfully updated: ");
        sb2.append(str);
        sb2.append(" time taken: ");
        sb2.append(System.currentTimeMillis() - j10);
        if (num.intValue() > 0) {
            this.f11284l.f();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G(jc.b bVar, s9.a aVar, String str) throws Exception {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Observed a new subscription: ");
        sb2.append(str);
        a(bVar, false, aVar.a("ForceLikesYouUpdate.OnSubscription.Android"));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void J(tj.b bVar) throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(qj.c cVar) throws Exception {
        try {
            this.f11276d.t(true, true, 0, new w(cVar));
        } catch (Exception e10) {
            cVar.onError(e10);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(qj.c cVar) throws Exception {
        try {
            this.f11276d.y(true, new h5.t(cVar));
        } catch (Exception e10) {
            cVar.onError(e10);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O() throws Exception {
        this.A = false;
        A();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void Q() throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T(long j10, e eVar) throws Exception {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("time taken to download resources: ");
        sb2.append(System.currentTimeMillis() - j10);
        this.f11282j.f("HAS_SYNCED", true);
        this.f11276d.n();
        b0();
        if (eVar.f11307b) {
            this.f11278f.c();
        }
        this.f11286n.a().f(new h5.p(), new q());
        this.f11287o.i().d();
        X();
        D(eVar.f11306a, (Void) null, new SuccessStatus("Data Sync Completed"));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U(e eVar, Throwable th2) throws Exception {
        fa.a.g("ManagerSync", "problem getting Suggested, Likes You, Discover or Chat resources", th2);
        th2.printStackTrace();
        C(eVar.f11306a, new CmbErrorCode(th2.getMessage()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V() {
        this.A = false;
        A();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W(e eVar) throws Exception {
        e eVar2 = eVar;
        if (this.f11291s.A("FasterAppStart.Android.Enabled.Android")) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f11295w.n());
            arrayList.add(this.f11293u.h().B());
            if (!this.f11298z) {
                arrayList.add(Z().B());
            }
            arrayList.add(a0());
            arrayList.add(Y());
            qj.a.y(arrayList).u(new z(this)).f(new k1(this, currentTimeMillis, eVar2), new l1(this, eVar2));
        } else {
            OperationResultReceiver operationResultReceiver = new OperationResultReceiver(new c(eVar2));
            Context context = this.f11279g;
            DiscoverMatchRepository discoverMatchRepository = this.f11292t;
            RefreshMyProfileUseCase refreshMyProfileUseCase = this.f11293u;
            PriceRepository priceRepository = this.f11295w;
            s9.a aVar = this.f11274b;
            FeatureFlagRepository featureFlagRepository = this.f11291s;
            j jVar = this.f11276d;
            i iVar = this.f11278f;
            boolean z10 = eVar2.f11307b;
            boolean z11 = !this.f11298z;
            a0 a0Var = r3;
            a0 a0Var2 = new a0(this);
            this.f11273a.execute(new com.coffeemeetsbagel.feature.sync.e(context, discoverMatchRepository, refreshMyProfileUseCase, priceRepository, aVar, featureFlagRepository, jVar, iVar, operationResultReceiver, z10, z11, a0Var, this.f11282j, this.f11286n, this.f11284l, this.f11290r, this.f11296x));
        }
        this.f11287o.i().d();
    }

    private qj.w<List<Long>> Z() {
        qj.w<List<NetworkProfile>> d10 = this.f11292t.d();
        SaveProfilesLocalUseCase saveProfilesLocalUseCase = this.f11290r;
        Objects.requireNonNull(saveProfilesLocalUseCase);
        return d10.v(new h5.r(saveProfilesLocalUseCase));
    }

    private qj.a a0() {
        if (this.f11274b.a("SuggestedPaywall.Show.Android")) {
            return this.f11296x.N();
        }
        return qj.a.m();
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public void c0(e eVar) {
        this.f11291s.I(true).g(new j1(this, eVar));
    }

    private void z() {
        b(new d(), false);
    }

    /* access modifiers changed from: package-private */
    public String B() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getAppsFlyerId on thread ");
        sb2.append(Thread.currentThread().getName());
        return AppsFlyerLib.getInstance().getAppsFlyerUID(Bakery.w());
    }

    public void P() {
        this.f11297y = System.currentTimeMillis();
    }

    public void S() {
        if (this.f11277e.isLoggedIn()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j10 = currentTimeMillis - this.f11297y;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("mTimeForeground=");
            sb2.append(currentTimeMillis);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("mTimeBackground=");
            sb3.append(this.f11297y);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("timeBackgrounded=");
            sb4.append(j10);
            if (j10 > DateUtils.MILLIS_IN_MINUTE && this.f11297y != 0) {
                z();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void X() {
        new Handler(Looper.getMainLooper()).post(new s());
    }

    /* access modifiers changed from: package-private */
    public qj.a Y() {
        boolean z10 = !this.f11298z;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("refreshBagels - should get bagels? ");
        sb2.append(z10);
        if (!z10) {
            return qj.a.m();
        }
        qj.a b10 = qj.a.n(new b0(this)).b(qj.a.n(new c0(this)));
        j jVar = this.f11276d;
        Objects.requireNonNull(jVar);
        return b10.q(new o(jVar));
    }

    public void a(jc.b<Void> bVar, boolean z10, boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("performSync - is this onboarding? ");
        sb2.append(this.f11298z);
        e eVar = new e(bVar, z10, z11);
        if (!this.A) {
            this.A = true;
            y();
            ((m) this.f11288p.x().t(new n()).j(com.uber.autodispose.a.a(this.f11294v))).e(new b(System.currentTimeMillis(), eVar));
        } else {
            this.f11280h.add(eVar);
        }
        this.f11275c.o();
    }

    public void b(jc.b<Void> bVar, boolean z10) {
        a(bVar, z10, false);
    }

    /* access modifiers changed from: package-private */
    public void b0() {
        Sift.setUserId(this.f11284l.j().getId());
    }

    public void c(boolean z10) {
        this.f11298z = z10;
    }

    /* access modifiers changed from: package-private */
    public void y() {
        if (!this.f11281i.u().isEmpty()) {
            for (String remove : this.f11281i.u()) {
                this.f11282j.remove(remove);
            }
            this.f11281i.b();
        }
    }
}
