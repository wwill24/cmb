package com.coffeemeetsbagel.feature.sync;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import c9.i;
import com.coffeemeetsbagel.discover.DiscoverMatchRepository;
import com.coffeemeetsbagel.domain.repository.SuggestedRepository;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.likes_you.u0;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.profile.RefreshMyProfileUseCase;
import com.coffeemeetsbagel.profile.SaveProfilesLocalUseCase;
import com.coffeemeetsbagel.store.PriceRepository;
import com.coffeemeetsbagel.transport.OperationResultReceiver;
import com.coffeemeetsbagel.transport.SuccessStatus;
import hb.c;
import j5.v;
import java.io.Serializable;
import s9.a;
import siftscience.android.Sift;

public class e extends v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f13423a;

    /* renamed from: b  reason: collision with root package name */
    private final j f13424b;

    /* renamed from: c  reason: collision with root package name */
    private final i f13425c;

    /* renamed from: d  reason: collision with root package name */
    private final OperationResultReceiver f13426d;

    /* renamed from: e  reason: collision with root package name */
    private final q f13427e;

    /* renamed from: f  reason: collision with root package name */
    private final c f13428f;

    /* renamed from: g  reason: collision with root package name */
    private final ProfileContract$Manager f13429g;

    /* renamed from: h  reason: collision with root package name */
    private final u0 f13430h;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f13431j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f13432k;

    /* renamed from: l  reason: collision with root package name */
    private final SaveProfilesLocalUseCase f13433l;

    /* renamed from: m  reason: collision with root package name */
    private final FeatureFlagRepository f13434m;

    /* renamed from: n  reason: collision with root package name */
    private final DiscoverMatchRepository f13435n;

    /* renamed from: p  reason: collision with root package name */
    private final RefreshMyProfileUseCase f13436p;

    /* renamed from: q  reason: collision with root package name */
    private final PriceRepository f13437q;

    /* renamed from: t  reason: collision with root package name */
    private final SuggestedRepository f13438t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(Context context, DiscoverMatchRepository discoverMatchRepository, RefreshMyProfileUseCase refreshMyProfileUseCase, PriceRepository priceRepository, a aVar, FeatureFlagRepository featureFlagRepository, j jVar, i iVar, OperationResultReceiver operationResultReceiver, boolean z10, boolean z11, q qVar, c cVar, u0 u0Var, ProfileContract$Manager profileContract$Manager, SaveProfilesLocalUseCase saveProfilesLocalUseCase, SuggestedRepository suggestedRepository) {
        super(context);
        this.f13435n = discoverMatchRepository;
        this.f13436p = refreshMyProfileUseCase;
        this.f13437q = priceRepository;
        this.f13423a = aVar;
        this.f13434m = featureFlagRepository;
        this.f13424b = jVar;
        this.f13425c = iVar;
        this.f13431j = z10;
        this.f13432k = z11;
        this.f13426d = operationResultReceiver;
        this.f13427e = qVar;
        this.f13428f = cVar;
        this.f13429g = profileContract$Manager;
        this.f13430h = u0Var;
        this.f13433l = saveProfilesLocalUseCase;
        this.f13438t = suggestedRepository;
    }

    private void g(String str, String str2) {
        h(str, str2, (CmbErrorCode) null);
    }

    private void h(String str, String str2, CmbErrorCode cmbErrorCode) {
        if (cmbErrorCode == null) {
            cmbErrorCode = new CmbErrorCode(str + str2);
        }
        a(this.f13426d, cmbErrorCode);
        this.f13427e.a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(boolean z10) {
        this.f13424b.w();
        n();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(boolean z10) {
        this.f13424b.y(true, new c(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l() {
        if (this.f13432k) {
            o();
        } else {
            n();
        }
    }

    /* access modifiers changed from: package-private */
    public void m() {
        new Handler(Looper.getMainLooper()).post(new b());
    }

    /* access modifiers changed from: package-private */
    public void n() {
        b(this.f13426d, new SuccessStatus("Data Sync Completed"), (Serializable) null);
        m();
        this.f13427e.a();
    }

    /* access modifiers changed from: package-private */
    public void o() {
        this.f13424b.t(true, true, 0, new a(this));
    }

    /* access modifiers changed from: package-private */
    public void p() {
        new Handler(Looper.getMainLooper()).post(new d(this));
    }

    /* access modifiers changed from: package-private */
    public void q() {
        Sift.setUserId(this.f13429g.j().getId());
    }

    @SuppressLint({"CheckResult"})
    public void run() {
        try {
            this.f13434m.I(true).l();
            this.f13437q.n().l();
            this.f13436p.h().j();
            this.f13433l.e(this.f13435n.d().j()).j();
            this.f13428f.f("HAS_SYNCED", true);
            this.f13424b.n();
            this.f13430h.a().d();
            q();
            if (this.f13423a.a("SuggestedPaywall.Show.Android")) {
                this.f13438t.N().l();
            }
            if (this.f13431j) {
                this.f13425c.c();
            }
            p();
        } catch (Exception e10) {
            g("Failed to sync data...Unknown error", e10.toString());
            fa.a.g("CmbSyncRunnable", "Failed to sync data...Unknown error", e10);
        }
    }
}
