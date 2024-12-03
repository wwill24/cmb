package com.coffeemeetsbagel.profile_me;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.l;
import androidx.browser.customtabs.d;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.h;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.i0;
import androidx.lifecycle.l0;
import androidx.lifecycle.u;
import b6.n;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.ActivitySettings;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.bagel_profile.BagelProfileComponentActivity;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.boost.BoostDialogFragment;
import com.coffeemeetsbagel.boost.g;
import com.coffeemeetsbagel.experiment.r;
import com.coffeemeetsbagel.external_links.CmbLinks;
import com.coffeemeetsbagel.external_links.LeanPlumCmbLinks;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.preferences.MatchPreferencesComponentActivity;
import com.coffeemeetsbagel.profile.ProfileMappersKt;
import com.coffeemeetsbagel.profile_me.MeProfileViewModel;
import com.coffeemeetsbagel.util.RequestCode;
import com.coffeemeetsbagel.view.CmbToolbar;
import com.mparticle.identity.IdentityHttpResponse;
import fa.a;
import java.util.List;
import java.util.Map;
import k6.a0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import w9.b;

public final class MeProfileFragment extends n {

    /* renamed from: h  reason: collision with root package name */
    public static final a f36150h = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    public a7.a f36151c;

    /* renamed from: d  reason: collision with root package name */
    public r f36152d;

    /* renamed from: e  reason: collision with root package name */
    public m f36153e;

    /* renamed from: f  reason: collision with root package name */
    private MeProfileViewModel f36154f;

    /* renamed from: g  reason: collision with root package name */
    public a0 f36155g;

    public enum ProfileElement {
        AVATAR,
        NAME
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36159a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f36160b;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0032 */
        static {
            /*
                com.coffeemeetsbagel.profile_me.MeProfileFragment$ProfileElement[] r0 = com.coffeemeetsbagel.profile_me.MeProfileFragment.ProfileElement.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.coffeemeetsbagel.profile_me.MeProfileFragment$ProfileElement r2 = com.coffeemeetsbagel.profile_me.MeProfileFragment.ProfileElement.AVATAR     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.coffeemeetsbagel.profile_me.MeProfileFragment$ProfileElement r3 = com.coffeemeetsbagel.profile_me.MeProfileFragment.ProfileElement.NAME     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f36159a = r0
                com.coffeemeetsbagel.profile_me.MeProfileViewModel$UpsellViewState[] r0 = com.coffeemeetsbagel.profile_me.MeProfileViewModel.UpsellViewState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.profile_me.MeProfileViewModel$UpsellViewState r3 = com.coffeemeetsbagel.profile_me.MeProfileViewModel.UpsellViewState.BOOST_AVAILABLE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.coffeemeetsbagel.profile_me.MeProfileViewModel$UpsellViewState r1 = com.coffeemeetsbagel.profile_me.MeProfileViewModel.UpsellViewState.BOOST_ACTIVE     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                com.coffeemeetsbagel.profile_me.MeProfileViewModel$UpsellViewState r1 = com.coffeemeetsbagel.profile_me.MeProfileViewModel.UpsellViewState.NONE     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                f36160b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.profile_me.MeProfileFragment.b.<clinit>():void");
        }
    }

    public static final class c implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MeProfileFragment f36161a;

        c(MeProfileFragment meProfileFragment) {
            this.f36161a = meProfileFragment;
        }

        public void a() {
        }

        public void b() {
            this.f36161a.i1();
        }

        public void onSuccess() {
        }
    }

    public static final class d implements u<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u<T> f36162a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LiveData<T> f36163b;

        d(u<T> uVar, LiveData<T> liveData) {
            this.f36162a = uVar;
            this.f36163b = liveData;
        }

        public void b(T t10) {
            this.f36162a.b(t10);
            this.f36163b.n(this);
        }
    }

    public static final class e extends l {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ MeProfileFragment f36164d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(MeProfileFragment meProfileFragment) {
            super(true);
            this.f36164d = meProfileFragment;
        }

        public void b() {
            this.f36164d.h1();
        }
    }

    static final class f implements u, kotlin.jvm.internal.f {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f36165a;

        f(Function1 function1) {
            j.g(function1, "function");
            this.f36165a = function1;
        }

        public final gk.c<?> a() {
            return this.f36165a;
        }

        public final /* synthetic */ void b(Object obj) {
            this.f36165a.invoke(obj);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof u) || !(obj instanceof kotlin.jvm.internal.f)) {
                return false;
            }
            return j.b(a(), ((kotlin.jvm.internal.f) obj).a());
        }

        public final int hashCode() {
            return a().hashCode();
        }
    }

    /* access modifiers changed from: private */
    public final void A1(List<Photo> list) {
        String str;
        boolean z10 = false;
        Photo photo = (Photo) CollectionsKt___CollectionsKt.Q(list, 0);
        if (photo != null) {
            str = photo.getUrl();
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            z10 = true;
        }
        if (z10) {
            D1();
        } else {
            f1(str);
        }
    }

    /* access modifiers changed from: private */
    public final void B1(com.coffeemeetsbagel.profile.l lVar) {
        S0().H.setText(lVar.g());
    }

    private final void C1(int i10) {
        h activity = getActivity();
        if (activity != null) {
            ((ActivityMain) activity).U4(i10, 6000);
        }
    }

    private final void D1() {
        S0().f15684k.setImageResource(R.drawable.icon_profile_placeholder);
    }

    private final void V0() {
        R0().d("Profile Me - Settings Tapped");
        h activity = getActivity();
        if (activity != null) {
            activity.startActivityForResult(new Intent(activity, ActivitySettings.class), RequestCode.APP_SETTINGS);
        }
    }

    private final void W0() {
        R0().d("Profile Me - Boost Me Tapped");
        c cVar = new c(this);
        h activity = getActivity();
        if (activity != null) {
            BoostDialogFragment.f11414q.a(cVar).show(activity.getSupportFragmentManager(), "BoostDialogFragment");
        }
    }

    private final void X0() {
        R0().d("Profile Me - Help & Support Tapped");
        h activity = getActivity();
        if (activity != null) {
            new d.a().a().a(activity, Uri.parse(getString(R.string.zendesk_url)));
        }
    }

    private final void Y0() {
        R0().d("Profile Me - Edit Preferences Tapped");
        h activity = getActivity();
        if (activity != null) {
            activity.startActivity(new Intent(getActivity(), MatchPreferencesComponentActivity.class));
        }
    }

    private final void Z0(NetworkProfile networkProfile) {
        h activity = getActivity();
        if (activity != null) {
            Intent intent = new Intent(getActivity(), BagelProfileComponentActivity.class);
            intent.putExtra("profile", networkProfile);
            intent.putExtra("source", "my profile");
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
        }
    }

    private final void b1() {
        R0().d("Profile Me - Tips Tapped");
        h activity = getActivity();
        if (activity != null) {
            CmbLinks.Companion.launchTips(activity);
        }
    }

    private final void c1() {
        R0().d("Profile Me - Whats New Tapped");
        h activity = getActivity();
        if (activity != null) {
            CmbLinks.Companion.launchWhatsNew(activity);
        }
    }

    private final void d1() {
        R0().d("Profile Me - Safety & Privacy Tapped");
        h activity = getActivity();
        if (activity != null) {
            new d.a().a().a(activity, Uri.parse(getString(R.string.safety_privacy_url)));
        }
    }

    private final void e1(ja.b bVar) {
        MeProfileViewModel meProfileViewModel = this.f36154f;
        if (meProfileViewModel == null) {
            j.y("viewModel");
            meProfileViewModel = null;
        }
        if (meProfileViewModel.n() != null) {
            W0();
        } else if (bVar.l()) {
            C1(R.string.you_are_boosted);
        } else {
            C1(R.string.something_went_wrong_boosting);
        }
    }

    private final void f1(String str) {
        a.C0491a aVar = fa.a.f40771d;
        aVar.a("MeProfileFragment", "loadAvatar(): " + str);
        Resources resources = S0().getRoot().getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.photo_size_large);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.two_dp);
        lc.j jVar = lc.j.f41113a;
        Context context = S0().getRoot().getContext();
        j.f(context, "binding.root.context");
        int a10 = jVar.a(context, R.attr.main_color);
        com.coffeemeetsbagel.image_loader.b bVar = com.coffeemeetsbagel.image_loader.b.f13967a;
        Context context2 = requireView().getContext();
        j.f(context2, "requireView().context");
        ImageLoaderContract.a.a(bVar, context2, str, S0().f15684k, Integer.valueOf(R.drawable.icon_profile_placeholder), (Integer) null, new ImageLoaderContract.b(dimensionPixelSize, dimensionPixelSize), q.m(b.a.f18329a, new b.d(dimensionPixelSize2, dimensionPixelSize2, a10)), (Map) null, (Function0) null, (Function1) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0], 3984, (Object) null);
    }

    private final <T> void g1(LiveData<T> liveData, androidx.lifecycle.l lVar, u<T> uVar) {
        liveData.i(lVar, new d(uVar, liveData));
    }

    /* access modifiers changed from: private */
    public static final void k1(MeProfileFragment meProfileFragment, View view) {
        j.g(meProfileFragment, "this$0");
        meProfileFragment.Y0();
    }

    /* access modifiers changed from: private */
    public static final void l1(MeProfileFragment meProfileFragment, View view) {
        j.g(meProfileFragment, "this$0");
        meProfileFragment.b1();
    }

    /* access modifiers changed from: private */
    public static final void m1(MeProfileFragment meProfileFragment, View view) {
        j.g(meProfileFragment, "this$0");
        meProfileFragment.X0();
    }

    /* access modifiers changed from: private */
    public static final void n1(MeProfileFragment meProfileFragment, View view) {
        j.g(meProfileFragment, "this$0");
        meProfileFragment.V0();
    }

    /* access modifiers changed from: private */
    public static final void o1(MeProfileFragment meProfileFragment, View view) {
        j.g(meProfileFragment, "this$0");
        meProfileFragment.d1();
    }

    /* access modifiers changed from: private */
    public static final void p1(MeProfileFragment meProfileFragment, View view) {
        j.g(meProfileFragment, "this$0");
        meProfileFragment.v1((ProfileElement) null);
    }

    /* access modifiers changed from: private */
    public static final void q1(MeProfileFragment meProfileFragment, View view) {
        j.g(meProfileFragment, "this$0");
        meProfileFragment.v1(ProfileElement.AVATAR);
    }

    /* access modifiers changed from: private */
    public static final void r1(MeProfileFragment meProfileFragment, View view) {
        j.g(meProfileFragment, "this$0");
        meProfileFragment.v1(ProfileElement.NAME);
    }

    /* access modifiers changed from: private */
    public static final void s1(MeProfileFragment meProfileFragment, View view) {
        j.g(meProfileFragment, "this$0");
        meProfileFragment.W0();
    }

    /* access modifiers changed from: private */
    public static final void t1(MeProfileFragment meProfileFragment, View view) {
        j.g(meProfileFragment, "this$0");
        meProfileFragment.c1();
    }

    private final void v1(ProfileElement profileElement) {
        int i10;
        if (profileElement == null) {
            i10 = -1;
        } else {
            i10 = b.f36159a[profileElement.ordinal()];
        }
        if (i10 == 1) {
            R0().d("Profile Me - Profile Icon Tapped");
        } else if (i10 == 2) {
            R0().d("Profile Me - First Name Tapped");
        }
        MeProfileViewModel meProfileViewModel = this.f36154f;
        MeProfileViewModel meProfileViewModel2 = null;
        if (meProfileViewModel == null) {
            j.y("viewModel");
            meProfileViewModel = null;
        }
        com.coffeemeetsbagel.profile.l f10 = meProfileViewModel.s().f();
        MeProfileViewModel meProfileViewModel3 = this.f36154f;
        if (meProfileViewModel3 == null) {
            j.y("viewModel");
        } else {
            meProfileViewModel2 = meProfileViewModel3;
        }
        ja.b f11 = meProfileViewModel2.t().f();
        if (f10 == null || f11 == null) {
            fa.a.f40771d.c("MeProfileFragment", "my profile cache not available", new IllegalStateException("my profile cache not available"));
        } else {
            Z0(ProfileMappersKt.g(f10, f11));
        }
    }

    private final void w1() {
        boolean z10;
        Bundle arguments = getArguments();
        boolean z11 = true;
        if (arguments == null || !arguments.getBoolean("BUY_BOOST")) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            requireArguments().remove("BUY_BOOST");
            MeProfileViewModel meProfileViewModel = this.f36154f;
            if (meProfileViewModel == null) {
                j.y("viewModel");
                meProfileViewModel = null;
            }
            g1(meProfileViewModel.t(), this, new b(this));
            return;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 == null || !arguments2.getBoolean("GO_TIPS")) {
            z11 = false;
        }
        if (z11) {
            requireArguments().remove("GO_TIPS");
            b1();
        }
    }

    /* access modifiers changed from: private */
    public static final void x1(MeProfileFragment meProfileFragment, ja.b bVar) {
        j.g(meProfileFragment, "this$0");
        j.g(bVar, "it");
        meProfileFragment.e1(bVar);
    }

    /* access modifiers changed from: private */
    public final void z1(MeProfileViewModel.UpsellViewState upsellViewState) {
        int i10 = b.f36160b[upsellViewState.ordinal()];
        if (i10 == 1) {
            S0().f15677c.setVisibility(0);
            S0().f15679e.setText(getString(R.string.lets_give_you_lift));
            S0().f15678d.setText(getString(R.string.get_more_views_with_boost));
            S0().f15680f.setVisibility(0);
        } else if (i10 == 2) {
            S0().f15677c.setVisibility(0);
            S0().f15679e.setText(getString(R.string.you_are_boosted));
            S0().f15678d.setText(getString(R.string.we_are_sharing_your_profile));
            S0().f15680f.setVisibility(8);
        } else if (i10 == 3) {
            S0().f15677c.setVisibility(8);
        }
    }

    public final a7.a R0() {
        a7.a aVar = this.f36151c;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }

    public final a0 S0() {
        a0 a0Var = this.f36155g;
        if (a0Var != null) {
            return a0Var;
        }
        j.y("binding");
        return null;
    }

    public final r T0() {
        r rVar = this.f36152d;
        if (rVar != null) {
            return rVar;
        }
        j.y("featureManager");
        return null;
    }

    public final m U0() {
        m mVar = this.f36153e;
        if (mVar != null) {
            return mVar;
        }
        j.y("viewModelFactory");
        return null;
    }

    public final void h1() {
        fa.a.f40771d.a("MeProfileFragment", "onBackButtonPressed()");
        R0().i("Profile Me - Back Button Tapped");
        requireActivity().onBackPressed();
    }

    public final void i1() {
        C1(R.string.something_went_wrong_boosting);
    }

    public final void j1() {
        fa.a.f40771d.a("MeProfileFragment", "onSelected()");
        h activity = getActivity();
        j.e(activity, "null cannot be cast to non-null type com.coffeemeetsbagel.activities.main.ActivityMain");
        CmbToolbar T0 = ((ActivityMain) activity).T0();
        if (T0 != null) {
            T0.setDisplayHomeAsUp(true);
        }
        if (T0 != null) {
            T0.J();
        }
        if (T0 != null) {
            T0.Y();
        }
        if (T0 != null) {
            T0.setTitle((int) R.string.f18840me);
        }
        MeProfileViewModel meProfileViewModel = this.f36154f;
        if (meProfileViewModel == null) {
            j.y("viewModel");
            meProfileViewModel = null;
        }
        meProfileViewModel.u();
    }

    public void onAttach(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        super.onAttach(context);
        fa.a.f40771d.a("MeProfileFragment", "onAttach()");
        Bakery.j().W1(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MeProfileViewModel meProfileViewModel = (MeProfileViewModel) new i0((l0) this, (i0.b) U0()).a(MeProfileViewModel.class);
        this.f36154f = meProfileViewModel;
        MeProfileViewModel meProfileViewModel2 = null;
        if (meProfileViewModel == null) {
            j.y("viewModel");
            meProfileViewModel = null;
        }
        meProfileViewModel.q().i(this, new f(new MeProfileFragment$onCreate$1(this)));
        MeProfileViewModel meProfileViewModel3 = this.f36154f;
        if (meProfileViewModel3 == null) {
            j.y("viewModel");
            meProfileViewModel3 = null;
        }
        meProfileViewModel3.r().i(this, new f(new MeProfileFragment$onCreate$2(this)));
        MeProfileViewModel meProfileViewModel4 = this.f36154f;
        if (meProfileViewModel4 == null) {
            j.y("viewModel");
        } else {
            meProfileViewModel2 = meProfileViewModel4;
        }
        meProfileViewModel2.s().i(this, new f(new MeProfileFragment$onCreate$3(this)));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.g(layoutInflater, "inflater");
        fa.a.f40771d.a("MeProfileFragment", "onCreateView");
        a0 c10 = a0.c(layoutInflater, viewGroup, false);
        j.f(c10, "inflate(inflater, container, false)");
        y1(c10);
        NestedScrollView b10 = S0().getRoot();
        j.f(b10, "binding.root");
        return b10;
    }

    public void onStart() {
        boolean z10;
        super.onStart();
        fa.a.f40771d.a("MeProfileFragment", "onStart()");
        w1();
        R0().g("Profile Me");
        S0().f15688p.setOnClickListener(new a(this));
        S0().f15692x.setOnClickListener(new c(this));
        S0().f15681g.setOnClickListener(new d(this));
        S0().E.setOnClickListener(new e(this));
        S0().B.setOnClickListener(new f(this));
        S0().f15676b.setOnClickListener(new g(this));
        S0().f15684k.setOnClickListener(new h(this));
        S0().H.setOnClickListener(new i(this));
        S0().f15680f.setOnClickListener(new j(this));
        if (T0().a("NewControl.Existing.Enabled.Android")) {
            String str = LeanPlumCmbLinks.whatsNewUrls;
            j.f(str, "whatsNewUrls");
            if (str.length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                S0().J.setVisibility(0);
                S0().J.setOnClickListener(new k(this));
                requireActivity().getOnBackPressedDispatcher().b(this, new e(this));
            }
        }
        S0().J.setVisibility(8);
        requireActivity().getOnBackPressedDispatcher().b(this, new e(this));
    }

    public final void u1() {
        MeProfileViewModel meProfileViewModel = this.f36154f;
        if (meProfileViewModel == null) {
            j.y("viewModel");
            meProfileViewModel = null;
        }
        meProfileViewModel.v();
    }

    public final void y1(a0 a0Var) {
        j.g(a0Var, "<set-?>");
        this.f36155g = a0Var;
    }
}
