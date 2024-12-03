package com.coffeemeetsbagel.limelight;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import androidx.lifecycle.i0;
import androidx.lifecycle.l0;
import androidx.lifecycle.u;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import c.i;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.dialogs.DialogPrimarySecondaryVertical;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.likes_you.LikesYouViewModel;
import com.coffeemeetsbagel.likes_you.g;
import com.coffeemeetsbagel.likes_you.m0;
import com.coffeemeetsbagel.likes_you.presentation.EmptyStateAction;
import com.coffeemeetsbagel.likes_you.s;
import com.coffeemeetsbagel.preferences.MatchPreferencesComponentActivity;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import com.google.android.material.tabs.TabLayout;
import com.mparticle.identity.IdentityHttpResponse;
import ea.f;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import lc.m;

public final class LikesYouFragment extends Fragment {

    /* renamed from: h  reason: collision with root package name */
    public static final a f34345h = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public FeatureFlagRepository f34346a;

    /* renamed from: b  reason: collision with root package name */
    public m0 f34347b;

    /* renamed from: c  reason: collision with root package name */
    public t f34348c;

    /* renamed from: d  reason: collision with root package name */
    public com.coffeemeetsbagel.likes_you.presentation.a f34349d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public da.a f34350e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public LikesYouViewModel f34351f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final androidx.activity.result.c<Intent> f34352g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LikesYouFragment f34353a;

        b(LikesYouFragment likesYouFragment) {
            this.f34353a = likesYouFragment;
        }

        public void a(ea.c cVar) {
            j.g(cVar, "gridItem");
            LikesYouViewModel E0 = this.f34353a.f34351f;
            j.d(E0);
            E0.c0(cVar);
        }

        public void b() {
            MatchPreferencesComponentActivity.a aVar = MatchPreferencesComponentActivity.f35786j;
            h requireActivity = this.f34353a.requireActivity();
            j.f(requireActivity, "requireActivity()");
            aVar.b(requireActivity);
        }

        public void c() {
            PremiumUpsellComponentActivity.a aVar = PremiumUpsellComponentActivity.f36846j;
            h requireActivity = this.f34353a.requireActivity();
            j.f(requireActivity, "requireActivity()");
            aVar.b(requireActivity, new PurchaseSource("likes you", "limelight subscription card"));
        }

        public void d() {
            LikesYouViewModel E0 = this.f34353a.f34351f;
            j.d(E0);
            E0.d0();
        }
    }

    static final class c implements u, kotlin.jvm.internal.f {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f34354a;

        c(Function1 function1) {
            j.g(function1, "function");
            this.f34354a = function1;
        }

        public final gk.c<?> a() {
            return this.f34354a;
        }

        public final /* synthetic */ void b(Object obj) {
            this.f34354a.invoke(obj);
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

    public static final class d implements TabLayout.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LikesYouFragment f34355a;

        d(LikesYouFragment likesYouFragment) {
            this.f34355a = likesYouFragment;
        }

        public void a(TabLayout.g gVar) {
            j.g(gVar, "tab");
            Object i10 = gVar.i();
            j.e(i10, "null cannot be cast to non-null type kotlin.Triple<*, *, *>");
            Triple triple = (Triple) i10;
            LikesYouViewModel E0 = this.f34355a.f34351f;
            j.d(E0);
            Object a10 = triple.a();
            j.e(a10, "null cannot be cast to non-null type kotlin.String");
            Object b10 = triple.b();
            j.e(b10, "null cannot be cast to non-null type kotlin.String");
            E0.b0((String) a10, (String) b10, gVar.g());
        }

        public void b(TabLayout.g gVar) {
        }

        public void c(TabLayout.g gVar) {
        }
    }

    public LikesYouFragment() {
        androidx.activity.result.c<Intent> registerForActivityResult = registerForActivityResult(new i(), new b(this));
        j.f(registerForActivityResult, "registerForActivityResul…c_error2)\n        }\n    }");
        this.f34352g = registerForActivityResult;
    }

    /* access modifiers changed from: private */
    public static final void H0(LikesYouFragment likesYouFragment, ActivityResult activityResult) {
        j.g(likesYouFragment, "this$0");
        if (activityResult.c() == 70) {
            h activity = likesYouFragment.getActivity();
            j.e(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            new sb.b(activity).a(R.string.generic_error2);
        }
    }

    /* access modifiers changed from: private */
    public final void I0(g gVar, int i10) {
        boolean z10;
        da.a aVar = this.f34350e;
        j.d(aVar);
        String d10 = gVar.d();
        boolean z11 = true;
        if (d10 == null || d10.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            aVar.f40556e.setImageResource(i10);
        } else {
            int i11 = i10;
            com.coffeemeetsbagel.image_loader.b bVar = com.coffeemeetsbagel.image_loader.b.f13967a;
            Context requireContext = requireContext();
            j.f(requireContext, "requireContext()");
            String d11 = gVar.d();
            j.d(d11);
            ImageLoaderContract.a.a(bVar, requireContext, d11, aVar.f40556e, Integer.valueOf(i10), (Integer) null, (ImageLoaderContract.b) null, (List) null, (Map) null, (Function0) null, (Function1) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0], 4080, (Object) null);
        }
        aVar.f40557f.setText(gVar.e());
        aVar.f40555d.setText(gVar.c());
        String a10 = gVar.a();
        if (!(a10 == null || a10.length() == 0)) {
            z11 = false;
        }
        if (z11) {
            aVar.f40554c.setVisibility(8);
            return;
        }
        aVar.f40554c.setVisibility(0);
        aVar.f40554c.setText(gVar.b());
        aVar.f40554c.setOnClickListener(new c(gVar, this));
    }

    /* access modifiers changed from: private */
    public static final void J0(g gVar, LikesYouFragment likesYouFragment, View view) {
        j.g(gVar, "$emptyState");
        j.g(likesYouFragment, "this$0");
        EmptyStateAction.a aVar = EmptyStateAction.f34259a;
        String a10 = gVar.a();
        j.d(a10);
        EmptyStateAction a11 = aVar.a(a10);
        if (a11 != null) {
            LikesYouViewModel likesYouViewModel = likesYouFragment.f34351f;
            j.d(likesYouViewModel);
            likesYouViewModel.e0(a11);
        }
    }

    /* access modifiers changed from: private */
    public final void Q0(List<s> list, TabLayout tabLayout) {
        TabLayout.g gVar;
        View e10;
        int i10;
        String str;
        int tabCount = tabLayout.getTabCount();
        HashMap hashMap = new HashMap();
        if (tabCount >= 0) {
            int i11 = 0;
            while (true) {
                TabLayout.g B = tabLayout.B(i11);
                if (B != null) {
                    Object i12 = B.i();
                    j.e(i12, "null cannot be cast to non-null type kotlin.Triple<*, *, *>");
                    Object a10 = ((Triple) i12).a();
                    j.e(a10, "null cannot be cast to non-null type kotlin.String");
                    TabLayout.g gVar2 = (TabLayout.g) hashMap.put((String) a10, B);
                }
                if (i11 == tabCount) {
                    break;
                }
                i11++;
            }
        }
        for (s next : list) {
            if (hashMap.containsKey(next.b())) {
                gVar = (TabLayout.g) hashMap.get(next.b());
            } else {
                gVar = tabLayout.E().o(R.layout.likes_you_tabs_v2);
            }
            if (!(gVar == null || (e10 = gVar.e()) == null)) {
                da.c a11 = da.c.a(e10);
                j.f(a11, "bind(it)");
                a11.f40569c.setText(next.d());
                Integer c10 = next.c();
                if (c10 != null) {
                    i10 = c10.intValue();
                } else {
                    i10 = 99;
                }
                if (next.a() > i10) {
                    str = i10 + "+";
                } else {
                    str = String.valueOf(next.a());
                }
                a11.f40568b.setText(str);
                gVar.s(new Triple(next.b(), next.d(), str));
                if (!hashMap.containsKey(next.b())) {
                    tabLayout.i(gVar);
                }
            }
        }
        tabLayout.h(new d(this));
    }

    /* access modifiers changed from: private */
    public final void R0(boolean z10, boolean z11, String str) {
        String format2 = String.format("Limelight %s tab", Arrays.copyOf(new Object[]{str}, 1));
        j.f(format2, "format(this, *args)");
        PurchaseSource purchaseSource = new PurchaseSource(format2, "limelight tab");
        Integer valueOf = Integer.valueOf(R.drawable.ic_likes_you_circled_lock);
        if (!z10) {
            DialogPrimarySecondaryVertical.a aVar = DialogPrimarySecondaryVertical.f12065a;
            Context requireContext = requireContext();
            String string = getString(R.string.likes_you_groupings_upsell_dialog_title);
            String string2 = getString(R.string.likes_you_groupings_upsell_dialog_text);
            String string3 = getString(R.string.likes_you_go_premium);
            String string4 = getString(R.string.likes_you_not_now);
            j.f(requireContext, "requireContext()");
            j.f(string, "getString(R.string.likes…ings_upsell_dialog_title)");
            j.f(string2, "getString(R.string.likes…pings_upsell_dialog_text)");
            j.f(string3, "getString(R.string.likes_you_go_premium)");
            DialogPrimarySecondaryVertical.a.d(aVar, requireContext, (DialogPrimarySecondaryVertical.PrimaryCtaStyle) null, valueOf, string, string2, string3, new LikesYouFragment$showOtherGroupUpsell$1(this, purchaseSource), string4, (Function0) null, (Function0) null, 770, (Object) null);
            LikesYouViewModel likesYouViewModel = this.f34351f;
            j.d(likesYouViewModel);
            likesYouViewModel.m0(1);
        } else if (!z11) {
            DialogPrimarySecondaryVertical.a aVar2 = DialogPrimarySecondaryVertical.f12065a;
            Context requireContext2 = requireContext();
            String string5 = getString(R.string.likes_you_groupings_upsell_dialog_title);
            String string6 = getString(R.string.likes_you_groupings_upsell_dialog_text);
            String string7 = getString(R.string.likes_you_go_premium);
            String string8 = getString(R.string.likes_you_not_now);
            j.f(requireContext2, "requireContext()");
            j.f(string5, "getString(R.string.likes…ings_upsell_dialog_title)");
            j.f(string6, "getString(R.string.likes…pings_upsell_dialog_text)");
            j.f(string7, "getString(R.string.likes_you_go_premium)");
            DialogPrimarySecondaryVertical.a.d(aVar2, requireContext2, (DialogPrimarySecondaryVertical.PrimaryCtaStyle) null, valueOf, string5, string6, string7, new LikesYouFragment$showOtherGroupUpsell$2(this, purchaseSource), string8, (Function0) null, (Function0) null, 770, (Object) null);
            LikesYouViewModel likesYouViewModel2 = this.f34351f;
            j.d(likesYouViewModel2);
            likesYouViewModel2.m0(2);
        } else {
            PremiumUpsellComponentActivity.a aVar3 = PremiumUpsellComponentActivity.f36846j;
            h requireActivity = requireActivity();
            j.f(requireActivity, "requireActivity()");
            aVar3.b(requireActivity, purchaseSource);
        }
    }

    public final com.coffeemeetsbagel.likes_you.presentation.a L0() {
        com.coffeemeetsbagel.likes_you.presentation.a aVar = this.f34349d;
        if (aVar != null) {
            return aVar;
        }
        j.y("adapter");
        return null;
    }

    public final FeatureFlagRepository M0() {
        FeatureFlagRepository featureFlagRepository = this.f34346a;
        if (featureFlagRepository != null) {
            return featureFlagRepository;
        }
        j.y("featureManager");
        return null;
    }

    public final m0 N0() {
        m0 m0Var = this.f34347b;
        if (m0Var != null) {
            return m0Var;
        }
        j.y("viewModelFactory");
        return null;
    }

    public final void O0() {
        LikesYouViewModel likesYouViewModel = this.f34351f;
        j.d(likesYouViewModel);
        likesYouViewModel.i0();
    }

    public final void P0(com.coffeemeetsbagel.likes_you.presentation.a aVar) {
        j.g(aVar, "<set-?>");
        this.f34349d = aVar;
    }

    public void onAttach(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        Bakery.j().o1(this);
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.g(layoutInflater, "inflater");
        this.f34350e = da.a.c(layoutInflater, viewGroup, false);
        b bVar = new b(this);
        da.a aVar = this.f34350e;
        j.d(aVar);
        aVar.f40559h.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        P0(new com.coffeemeetsbagel.likes_you.presentation.a(bVar, com.coffeemeetsbagel.image_loader.b.f13967a, M0().A("LikesYouCuration.Pill.Android")));
        da.a aVar2 = this.f34350e;
        j.d(aVar2);
        aVar2.f40559h.setAdapter(L0());
        m mVar = m.f41114a;
        Context requireContext = requireContext();
        j.f(requireContext, "requireContext()");
        int a10 = mVar.a(requireContext, 16.0f);
        da.a aVar3 = this.f34350e;
        j.d(aVar3);
        aVar3.f40559h.h(new u5.a(a10));
        da.a aVar4 = this.f34350e;
        j.d(aVar4);
        ConstraintLayout b10 = aVar4.getRoot();
        j.f(b10, "binding!!.root");
        return b10;
    }

    public void onViewCreated(View view, Bundle bundle) {
        j.g(view, "view");
        super.onViewCreated(view, bundle);
        LikesYouViewModel likesYouViewModel = (LikesYouViewModel) new i0((l0) this, (i0.b) N0()).a(LikesYouViewModel.class);
        this.f34351f = likesYouViewModel;
        j.d(likesYouViewModel);
        likesYouViewModel.Z().i(getViewLifecycleOwner(), new c(new LikesYouFragment$onViewCreated$1(this)));
        LikesYouViewModel likesYouViewModel2 = this.f34351f;
        j.d(likesYouViewModel2);
        likesYouViewModel2.V().i(getViewLifecycleOwner(), new c(new LikesYouFragment$onViewCreated$2(this)));
        LikesYouViewModel likesYouViewModel3 = this.f34351f;
        j.d(likesYouViewModel3);
        likesYouViewModel3.Y().i(getViewLifecycleOwner(), new c(new LikesYouFragment$onViewCreated$3(this)));
        LikesYouViewModel likesYouViewModel4 = this.f34351f;
        j.d(likesYouViewModel4);
        likesYouViewModel4.a0().i(getViewLifecycleOwner(), new c(new LikesYouFragment$onViewCreated$4(this)));
    }
}
