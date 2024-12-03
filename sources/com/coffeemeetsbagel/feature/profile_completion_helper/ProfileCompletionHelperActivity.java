package com.coffeemeetsbagel.feature.profile_completion_helper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.i0;
import androidx.lifecycle.l0;
import androidx.lifecycle.u;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.cmb_views.CmbLinearLayout;
import com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperViewModel;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.view.CmbToolbar;
import f8.n;
import h5.i;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

public final class ProfileCompletionHelperActivity extends c {

    /* renamed from: c  reason: collision with root package name */
    public e f13169c;

    /* renamed from: d  reason: collision with root package name */
    public ProfileCompletionHelperViewModel f13170d;

    /* renamed from: e  reason: collision with root package name */
    public k6.c f13171e;

    /* renamed from: f  reason: collision with root package name */
    public ViewPager2 f13172f;

    /* renamed from: g  reason: collision with root package name */
    public CmbToolbar f13173g;

    /* renamed from: h  reason: collision with root package name */
    public d f13174h;

    /* renamed from: j  reason: collision with root package name */
    private CmbLinearLayout f13175j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public ProgressBar f13176k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final float f13177l = 100.0f;

    /* renamed from: m  reason: collision with root package name */
    private final long f13178m = 300;

    /* renamed from: n  reason: collision with root package name */
    private boolean f13179n;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public boolean f13180p = true;

    static final class a implements u, f {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f13181a;

        a(Function1 function1) {
            j.g(function1, "function");
            this.f13181a = function1;
        }

        public final gk.c<?> a() {
            return this.f13181a;
        }

        public final /* synthetic */ void b(Object obj) {
            this.f13181a.invoke(obj);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof u) || !(obj instanceof f)) {
                return false;
            }
            return j.b(a(), ((f) obj).a());
        }

        public final int hashCode() {
            return a().hashCode();
        }
    }

    private final Fragment L0() {
        return M0(N0().getCurrentItem());
    }

    private final Fragment M0(int i10) {
        return I0().a0(i10);
    }

    private final void Q0() {
        if (L0() instanceof n) {
            Fragment L0 = L0();
            j.e(L0, "null cannot be cast to non-null type com.coffeemeetsbagel.feature.likepassflow.FragmentMyPhotos");
            ((n) L0).L1();
        }
    }

    private final void R0() {
        if (this.f13179n) {
            O0().n();
            i.b(EventType.HAS_COMPLETED_LIKE_FLOW);
            HashMap hashMap = new HashMap();
            hashMap.put("source", "Like Flow");
            hashMap.put("screen", "Complete");
            hashMap.put("state", "Complete");
            Bakery.w().z().j("Onboarding", hashMap);
        }
    }

    private final void S0() {
        if (N0().getCurrentItem() == 0) {
            finish();
            return;
        }
        if (this.f13176k != null) {
            com.coffeemeetsbagel.view.c cVar = new com.coffeemeetsbagel.view.c(this.f13176k, this.f13177l * ((float) N0().getCurrentItem()), this.f13177l * ((float) (N0().getCurrentItem() - 1)));
            cVar.setDuration(this.f13178m);
            ProgressBar progressBar = this.f13176k;
            j.d(progressBar);
            progressBar.startAnimation(cVar);
        }
        N0().setCurrentItem(N0().getCurrentItem() - 1);
    }

    private final void T0() {
        Fragment L0 = L0();
        j.e(L0, "null cannot be cast to non-null type com.coffeemeetsbagel.feature.profile_completion_helper.UserInteractionListener");
        ((f) L0).d();
    }

    /* access modifiers changed from: private */
    public final void Z0(List<ProfileCompletionHelperViewModel.a> list) {
        if (list.isEmpty()) {
            finish();
            return;
        }
        U0(new d(this, list));
        N0().setAdapter(I0());
    }

    private final void b1() {
        View findViewById = findViewById(R.id.toolbar);
        j.f(findViewById, "findViewById(R.id.toolbar)");
        Toolbar toolbar = (Toolbar) findViewById;
        toolbar.setTitle((CharSequence) null);
        toolbar.removeAllViews();
        View inflate = LayoutInflater.from(this).inflate(R.layout.cmb_toolbar, toolbar, false);
        j.e(inflate, "null cannot be cast to non-null type com.coffeemeetsbagel.view.CmbToolbar");
        W0((CmbToolbar) inflate);
        toolbar.addView(K0());
        toolbar.setPadding(0, 0, 0, 0);
        toolbar.J(0, 0);
        K0().X();
        K0().getLeftIcon().setOnClickListener(new a(this));
        View inflate2 = getLayoutInflater().inflate(R.layout.next_menu_item, K0(), false);
        j.e(inflate2, "null cannot be cast to non-null type com.coffeemeetsbagel.cmb_views.CmbLinearLayout");
        CmbLinearLayout cmbLinearLayout = (CmbLinearLayout) inflate2;
        this.f13175j = cmbLinearLayout;
        j.d(cmbLinearLayout);
        CmbImageView cmbImageView = (CmbImageView) cmbLinearLayout.findViewById(R.id.next_menu_icon);
        cmbImageView.setRotation(180.0f);
        cmbImageView.setOnClickListener(new b(this));
        K0().C(this.f13175j);
        View inflate3 = getLayoutInflater().inflate(R.layout.like_pass_progress, K0().getMainContentHolder(), false);
        j.e(inflate3, "null cannot be cast to non-null type android.widget.ProgressBar");
        ProgressBar progressBar = (ProgressBar) inflate3;
        this.f13176k = progressBar;
        j.d(progressBar);
        ViewGroup.LayoutParams layoutParams = progressBar.getLayoutParams();
        j.e(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.addRule(13, -1);
        ProgressBar progressBar2 = this.f13176k;
        j.d(progressBar2);
        progressBar2.setLayoutParams(layoutParams2);
        ProgressBar progressBar3 = this.f13176k;
        j.d(progressBar3);
        progressBar3.setProgress(0);
        K0().B(this.f13176k);
    }

    /* access modifiers changed from: private */
    public static final void c1(ProfileCompletionHelperActivity profileCompletionHelperActivity, View view) {
        j.g(profileCompletionHelperActivity, "this$0");
        profileCompletionHelperActivity.S0();
    }

    /* access modifiers changed from: private */
    public static final void d1(ProfileCompletionHelperActivity profileCompletionHelperActivity, View view) {
        j.g(profileCompletionHelperActivity, "this$0");
        profileCompletionHelperActivity.T0();
    }

    private final void e1() {
        this.f13179n = true;
        lc.c.a(this);
        O0().k().i(this, new a(new ProfileCompletionHelperActivity$showLikePassCompletion$1(this)));
        R0();
    }

    public final d I0() {
        d dVar = this.f13174h;
        if (dVar != null) {
            return dVar;
        }
        j.y("adapter");
        return null;
    }

    public final k6.c J0() {
        k6.c cVar = this.f13171e;
        if (cVar != null) {
            return cVar;
        }
        j.y("binding");
        return null;
    }

    public final CmbToolbar K0() {
        CmbToolbar cmbToolbar = this.f13173g;
        if (cmbToolbar != null) {
            return cmbToolbar;
        }
        j.y("cmbToolbar");
        return null;
    }

    public final ViewPager2 N0() {
        ViewPager2 viewPager2 = this.f13172f;
        if (viewPager2 != null) {
            return viewPager2;
        }
        j.y("mViewPager");
        return null;
    }

    public final ProfileCompletionHelperViewModel O0() {
        ProfileCompletionHelperViewModel profileCompletionHelperViewModel = this.f13170d;
        if (profileCompletionHelperViewModel != null) {
            return profileCompletionHelperViewModel;
        }
        j.y("viewModel");
        return null;
    }

    public final e P0() {
        e eVar = this.f13169c;
        if (eVar != null) {
            return eVar;
        }
        j.y("viewModelFactory");
        return null;
    }

    public final void U0(d dVar) {
        j.g(dVar, "<set-?>");
        this.f13174h = dVar;
    }

    public final void V0(k6.c cVar) {
        j.g(cVar, "<set-?>");
        this.f13171e = cVar;
    }

    public final void W0(CmbToolbar cmbToolbar) {
        j.g(cmbToolbar, "<set-?>");
        this.f13173g = cmbToolbar;
    }

    public final void X0(ViewPager2 viewPager2) {
        j.g(viewPager2, "<set-?>");
        this.f13172f = viewPager2;
    }

    public final void Y0(ProfileCompletionHelperViewModel profileCompletionHelperViewModel) {
        j.g(profileCompletionHelperViewModel, "<set-?>");
        this.f13170d = profileCompletionHelperViewModel;
    }

    public final void next() {
        boolean z10;
        if (this.f13176k != null) {
            com.coffeemeetsbagel.view.c cVar = new com.coffeemeetsbagel.view.c(this.f13176k, this.f13177l * ((float) N0().getCurrentItem()), this.f13177l * ((float) (N0().getCurrentItem() + 1)));
            cVar.setDuration(this.f13178m);
            ProgressBar progressBar = this.f13176k;
            j.d(progressBar);
            progressBar.startAnimation(cVar);
        }
        RecyclerView.Adapter adapter = N0().getAdapter();
        j.d(adapter);
        if (adapter.g() == N0().getCurrentItem() + 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            e1();
            return;
        }
        N0().setCurrentItem(N0().getCurrentItem() + 1);
        Q0();
    }

    public void onBackPressed() {
        S0();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bakery.j().X0(this);
        k6.c c10 = k6.c.c(LayoutInflater.from(this));
        j.f(c10, "inflate(LayoutInflater.from(this))");
        V0(c10);
        this.f13180p = getIntent().getBooleanExtra("EXTRA_IS_LIKE_FLOW_FIRST", true);
        setContentView((View) J0().getRoot());
        ViewPager2 viewPager2 = J0().f15709c;
        j.f(viewPager2, "binding.viewPager2");
        X0(viewPager2);
        b1();
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        Y0((ProfileCompletionHelperViewModel) new i0((l0) this, (i0.b) P0()).a(ProfileCompletionHelperViewModel.class));
        O0().j().i(this, new a(new ProfileCompletionHelperActivity$onPostCreate$1(this)));
    }
}
