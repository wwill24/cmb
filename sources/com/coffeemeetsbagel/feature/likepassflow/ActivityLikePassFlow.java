package com.coffeemeetsbagel.feature.likepassflow;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.cmb_views.CmbLinearLayout;
import com.coffeemeetsbagel.cmb_views.CustomViewPagerNonSwipeable;
import com.coffeemeetsbagel.dialogs.DialogPrimarySecondaryVertical;
import com.coffeemeetsbagel.feature.likepassflow.LikePassFlowAdapter;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.profile.SaveProfilesLocalUseCase;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.coffeemeetsbagel.view.CmbToolbar;
import com.uber.autodispose.p;
import f8.d;
import f8.e;
import f8.f;
import h5.i;
import h5.l;
import j5.h;
import j5.n;
import j5.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;

public class ActivityLikePassFlow extends h implements z9.h, ViewPager.j {
    /* access modifiers changed from: private */
    public jc.b<Void> B;
    private NetworkProfile C;
    private r7.h D;
    private ProgressBar E;
    private ModelProfileUpdateDelta F = new ModelProfileUpdateDelta();
    private List<n> G = new ArrayList();
    private boolean H;
    private boolean I;
    /* access modifiers changed from: private */
    public View J;
    CmbLinearLayout K;
    private LikePassFlowAdapter L;
    int M;
    int N;

    /* renamed from: w  reason: collision with root package name */
    SaveProfilesLocalUseCase f13035w;

    /* renamed from: x  reason: collision with root package name */
    a6.a f13036x;

    /* renamed from: y  reason: collision with root package name */
    CustomViewPagerNonSwipeable f13037y;

    /* renamed from: z  reason: collision with root package name */
    private jc.b<Void> f13038z;

    class a implements jc.b<Void> {
        a() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
        }
    }

    class b implements jc.b<Void> {
        b() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
            Bakery.w().D().b(ActivityLikePassFlow.this.B, false);
            sb.a.i(ActivityLikePassFlow.this.J, R.string.error_updating_profile);
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            Bakery.w().D().b(ActivityLikePassFlow.this.B, false);
        }
    }

    class c implements jc.b<Void> {
        c() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
            ActivityLikePassFlow.this.V1();
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            ActivityLikePassFlow.this.V1();
        }
    }

    private n J1() {
        return K1(this.f13037y.getCurrentItem());
    }

    private n K1(int i10) {
        for (n next : this.G) {
            if (this.L.y(i10, next)) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O1() {
        this.f13037y.setCurrentItem(this.L.x());
        U1();
        q(this.L.x());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P1(x xVar) throws Exception {
        W1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q1(x xVar) throws Exception {
        X1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit R1() {
        setResult(-1);
        finish();
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit S1() {
        finish();
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit T1() {
        finish();
        return null;
    }

    private void U1() {
        if (J1() instanceof f8.n) {
            ((f8.n) J1()).L1();
        }
    }

    /* access modifiers changed from: private */
    public void V1() {
        String str;
        if (this.H) {
            U0().b("has_completed_like_flow");
            i.b(EventType.HAS_COMPLETED_LIKE_FLOW);
            HashMap hashMap = new HashMap();
            if (this.I) {
                str = "Like Flow";
            } else {
                str = "Pass Flow";
            }
            hashMap.put("source", str);
            hashMap.put("screen", "Complete");
            hashMap.put("state", "Complete");
            Bakery.w().z().j("Onboarding", hashMap);
        }
    }

    private void W1() {
        CmbToolbar cmbToolbar;
        boolean booleanExtra = getIntent().getBooleanExtra("is_from_onboarding", false);
        if (this.f13037y.getCurrentItem() == 0 && !booleanExtra) {
            finish();
        }
        if (this.f13037y.getCurrentItem() > 0) {
            if (this.E != null) {
                com.coffeemeetsbagel.view.c cVar = new com.coffeemeetsbagel.view.c(this.E, (float) (this.f13037y.getCurrentItem() * 100), (float) ((this.f13037y.getCurrentItem() - 1) * 100));
                cVar.setDuration(300);
                this.E.startAnimation(cVar);
            }
            CustomViewPagerNonSwipeable customViewPagerNonSwipeable = this.f13037y;
            customViewPagerNonSwipeable.setCurrentItem(customViewPagerNonSwipeable.getCurrentItem() - 1);
            n K1 = K1(this.f13037y.getCurrentItem());
            if (K1 != null) {
                K1.V0();
            }
            supportInvalidateOptionsMenu();
        }
        if (booleanExtra && this.f13037y.getCurrentItem() == 0 && (cmbToolbar = this.f15597h) != null) {
            cmbToolbar.K();
        }
    }

    private void X1() {
        n J1 = J1();
        if (J1 == null) {
            finish();
            return;
        }
        if (J1.b0(true)) {
            J1.d();
        }
        CmbToolbar cmbToolbar = this.f15597h;
        if (cmbToolbar != null) {
            cmbToolbar.L();
        }
    }

    private void Y1() {
        d1().p(new a(), this.F, true);
    }

    private void Z1() {
        this.H = true;
        lc.c.a(this);
        DialogPrimarySecondaryVertical.f12065a.a(this, DialogPrimarySecondaryVertical.PrimaryCtaStyle.NORMAL, (Integer) null, this.N, this.M, R.string.review_my_profile, new d(this), Integer.valueOf(R.string.not_now), new e(this), new f(this));
        V1();
    }

    private void a2() {
    }

    /* access modifiers changed from: protected */
    public LikePassFlowAdapter L1(FragmentManager fragmentManager, b bVar) {
        return new LikePassFlowAdapter(fragmentManager, bVar);
    }

    /* access modifiers changed from: protected */
    public b M1(c cVar) {
        return new b(cVar);
    }

    /* access modifiers changed from: protected */
    public c N1(LikePassFlowAdapter.LikePassFlowType likePassFlowType) {
        return new c(likePassFlowType, X0());
    }

    /* access modifiers changed from: protected */
    public Fragment O0() {
        return null;
    }

    public void Q(n nVar) {
        this.G.add(nVar);
        if (this.G.size() == this.L.e() && !this.G.isEmpty()) {
            new Handler().post(new f8.a(this));
        }
    }

    public void S(int i10, float f10, int i11) {
    }

    public void X(boolean z10, n nVar) {
        if (J1() == nVar) {
            supportInvalidateOptionsMenu();
        }
    }

    public ModelProfileUpdateDelta Y() {
        if (this.F == null) {
            this.F = new ModelProfileUpdateDelta();
        }
        return this.F;
    }

    /* access modifiers changed from: protected */
    public String Z0() {
        return null;
    }

    public int b1() {
        return R.layout.activity_with_viewpager_non_swipeable_no_shadow;
    }

    public void m0(int i10) {
    }

    public void next() {
        boolean z10;
        int currentItem = this.f13037y.getCurrentItem();
        if (this.E != null) {
            com.coffeemeetsbagel.view.c cVar = new com.coffeemeetsbagel.view.c(this.E, (float) (currentItem * 100), (float) ((currentItem + 1) * 100));
            cVar.setDuration(300);
            this.E.startAnimation(cVar);
        }
        if (this.f13037y.getAdapter() == null || this.f13037y.getAdapter().e() != currentItem + 1) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            i1().c(false);
        }
        if (z10 || this.F.hasAtLeastOneFieldExcept(ProfileConstants.Field.HAS_SEEN_LIKE_FLOW)) {
            Bakery.w().G().p(this.f13038z, this.F, false);
        }
        if (z10) {
            Z1();
            return;
        }
        this.f13037y.setCurrentItem(currentItem + 1);
        U1();
        supportInvalidateOptionsMenu();
    }

    public String o() {
        return this.I ? "Like Flow" : "Pass Flow";
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        l.h().onActivityResult(i10, i11, intent);
        if (i10 == 1003 || i10 == 6600 || i10 == 6500 || i10 == 6501) {
            c1().i(this, i10, i11, intent);
        }
    }

    public void onBackPressed() {
        W1();
    }

    public void onCreate(Bundle bundle) {
        LikePassFlowAdapter.LikePassFlowType likePassFlowType;
        Bakery.j().h1(this);
        super.onCreate(bundle);
        CmbToolbar cmbToolbar = this.f15597h;
        if (cmbToolbar != null) {
            cmbToolbar.X();
            ((p) this.f15597h.T().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new f8.b(this));
            CmbLinearLayout cmbLinearLayout = (CmbLinearLayout) getLayoutInflater().inflate(R.layout.next_menu_item, this.f15597h, false);
            this.K = cmbLinearLayout;
            ((CmbImageView) cmbLinearLayout.findViewById(R.id.next_menu_icon)).setRotation(180.0f);
            ((p) this.K.a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new f8.c(this));
            this.f15597h.C(this.K);
            ProgressBar progressBar = (ProgressBar) getLayoutInflater().inflate(R.layout.like_pass_progress, this.f15597h.getMainContentHolder(), false);
            this.E = progressBar;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) progressBar.getLayoutParams();
            layoutParams.addRule(13, -1);
            this.E.setLayoutParams(layoutParams);
            this.E.setProgress(0);
            this.f15597h.B(this.E);
        }
        this.J = getWindow().getDecorView().findViewById(16908290);
        if (this.F == null) {
            this.F = new ModelProfileUpdateDelta();
        }
        CustomViewPagerNonSwipeable customViewPagerNonSwipeable = (CustomViewPagerNonSwipeable) findViewById(R.id.viewPager_non_swipeable);
        this.f13037y = customViewPagerNonSwipeable;
        customViewPagerNonSwipeable.setSwipeable(false);
        if (bundle == null) {
            this.C = d1().j();
        } else {
            this.C = (NetworkProfile) bundle.getSerializable("profile");
        }
        this.I = getIntent().getBooleanExtra("EXTRA_IS_LIKE_FLOW_FIRST", true);
        NetworkProfile networkProfile = this.C;
        if (networkProfile == null || networkProfile.getId() == null) {
            setResult(704);
            finish();
        } else {
            if (getIntent().getBooleanExtra("is_from_onboarding", false)) {
                this.f15597h.K();
            }
            if (this.I) {
                likePassFlowType = LikePassFlowAdapter.LikePassFlowType.LIKE_FLOW_FIRST;
            } else {
                likePassFlowType = LikePassFlowAdapter.LikePassFlowType.PASS_FLOW_FIRST;
            }
            b M1 = M1(N1(likePassFlowType));
            M1.d();
            ProgressBar progressBar2 = this.E;
            if (progressBar2 != null) {
                progressBar2.setMax(M1.e() * 100);
            }
            this.L = L1(getSupportFragmentManager(), M1);
            if (M1.e() == 0) {
                finish();
                return;
            }
            this.F.updateHasSeenLikeFlow(true);
            this.F.updateHasSeenPassFlow(true);
            this.f13036x.a("has_seen_like_flow");
            this.f13036x.b("has_seen_pass_flow");
            Y1();
        }
        this.f13037y.setAdapter(this.L);
        a2();
        this.f13037y.setOffscreenPageLimit(this.L.e() - 1);
        this.f13037y.c(this);
        this.L.k();
    }

    public void onDestroy() {
        super.onDestroy();
        this.G.clear();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f13038z = null;
        this.B = null;
        lc.c.i(this.D);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.D = new r7.h(this);
        this.f13038z = new b();
        this.B = new c();
        if (!this.C.isMale() || !this.C.isStraight()) {
            this.M = R.string.profile_complete_prompt_new_model_test_female;
            this.N = R.string.profile_complete_title_new_modle_test_female;
        } else {
            this.M = R.string.profile_complete_prompt_new_model_test_male;
            this.N = R.string.profile_complete_title_id_normal;
        }
        supportInvalidateOptionsMenu();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("profile", this.C);
        bundle.putInt("current_fragment", this.f13037y.getCurrentItem());
    }

    public void q(int i10) {
        n K1 = K1(i10);
        if (K1 != null) {
            K1.T0();
            K1.V0();
        }
        this.L.z(i10);
        supportInvalidateOptionsMenu();
    }

    public boolean x1() {
        return false;
    }
}
