package com.coffeemeetsbagel.discoverV2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.h;
import androidx.lifecycle.i0;
import androidx.lifecycle.u;
import b6.n;
import b6.r;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.bagel_profile.BagelProfileComponentActivity;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.chat.details.ChatActivity;
import com.coffeemeetsbagel.dialogs.a0;
import com.coffeemeetsbagel.discoverV2.DiscoverViewModel;
import com.coffeemeetsbagel.discoverV2.empty.DiscoverFeedEmptyView;
import com.coffeemeetsbagel.discoverV2.filters.DiscoverFeedFiltersView;
import com.coffeemeetsbagel.discoverV2.list.DiscoverFeedListView;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.bagel.s;
import com.coffeemeetsbagel.feature.discover.search.DiscoverFilterActivity;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.GiveTake;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.RisingGiveTake;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.interfaces.GiveTakeBase;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.shop.ShopComponentActivity;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.SubscriptionBenefitAttribution;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import com.coffeemeetsbagel.subscription_dialog.dialog.e;
import com.coffeemeetsbagel.subscription_dialog.dialog.w;
import com.coffeemeetsbagel.subscription_dialog.dialog.y;
import com.coffeemeetsbagel.upsell_banner.g;
import com.coffeemeetsbagel.upsell_banner.i;
import com.coffeemeetsbagel.util.RequestCode;
import com.mparticle.identity.IdentityHttpResponse;
import fa.a;
import java.util.List;
import k6.i;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;

public final class DiscoverFragment extends n implements g.c, e.a {
    public static final a F = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public DiscoverFeedEmptyView B;
    /* access modifiers changed from: private */
    public DiscoverFeedFiltersView C;
    private com.coffeemeetsbagel.upsell_banner.n D;
    private w E;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public i f12182c;

    /* renamed from: d  reason: collision with root package name */
    public s f12183d;

    /* renamed from: e  reason: collision with root package name */
    public s9.a f12184e;

    /* renamed from: f  reason: collision with root package name */
    public PurchaseManager f12185f;

    /* renamed from: g  reason: collision with root package name */
    public ProfileManager f12186g;

    /* renamed from: h  reason: collision with root package name */
    public a6.a f12187h;

    /* renamed from: j  reason: collision with root package name */
    public k f12188j;

    /* renamed from: k  reason: collision with root package name */
    public SubscriptionRepository f12189k;

    /* renamed from: l  reason: collision with root package name */
    public BuySubscriptionUseCase f12190l;

    /* renamed from: m  reason: collision with root package name */
    public a7.a f12191m;

    /* renamed from: n  reason: collision with root package name */
    public UserRepository f12192n;

    /* renamed from: p  reason: collision with root package name */
    public cb.a f12193p;

    /* renamed from: q  reason: collision with root package name */
    public GetMyOwnProfileLocalUseCase f12194q;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public DiscoverViewModel f12195t;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public boolean f12196w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public com.coffeemeetsbagel.discoverV2.list.b f12197x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public DiscoverFeedListView f12198y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public View f12199z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static final class b implements u, f {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f12200a;

        b(Function1 function1) {
            j.g(function1, "function");
            this.f12200a = function1;
        }

        public final gk.c<?> a() {
            return this.f12200a;
        }

        public final /* synthetic */ void b(Object obj) {
            this.f12200a.invoke(obj);
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

    public static final class c implements a0.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DiscoverFragment f12201a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GiveTake f12202b;

        c(DiscoverFragment discoverFragment, GiveTake giveTake) {
            this.f12201a = discoverFragment;
            this.f12202b = giveTake;
        }

        public void a() {
        }

        public void d() {
        }

        public void e() {
            DiscoverViewModel O0 = this.f12201a.f12195t;
            if (O0 == null) {
                j.y("viewModel");
                O0 = null;
            }
            O0.o0(this.f12202b, this.f12201a.f12196w);
        }
    }

    public static final class d implements y {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DiscoverFragment f12203a;

        d(DiscoverFragment discoverFragment) {
            this.f12203a = discoverFragment;
        }

        public void onCancel() {
            this.f12203a.t1();
        }

        public void onFailure() {
            this.f12203a.t1();
        }

        public void onSuccess() {
            this.f12203a.t1();
        }
    }

    public static final class e implements i.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DiscoverFragment f12204a;

        e(DiscoverFragment discoverFragment) {
            this.f12204a = discoverFragment;
        }

        public void a() {
            this.f12204a.r1(new PurchaseSource("Give & Take", "Subscription Banner"));
        }

        public void b() {
            fa.a.f40771d.a("DiscoverFeedFragment", "onUpsellClosed callback.");
            DiscoverViewModel O0 = this.f12204a.f12195t;
            if (O0 == null) {
                j.y("viewModel");
                O0 = null;
            }
            O0.I0();
        }
    }

    /* access modifiers changed from: private */
    public final void A1(int i10) {
        DiscoverViewModel discoverViewModel = this.f12195t;
        DiscoverViewModel discoverViewModel2 = null;
        if (discoverViewModel == null) {
            j.y("viewModel");
            discoverViewModel = null;
        }
        if (discoverViewModel.S().f() != null) {
            DiscoverViewModel discoverViewModel3 = this.f12195t;
            if (discoverViewModel3 == null) {
                j.y("viewModel");
                discoverViewModel3 = null;
            }
            List<GiveTakeBase> f10 = discoverViewModel3.S().f();
            j.d(f10);
            if (f10.size() > i10) {
                DiscoverViewModel discoverViewModel4 = this.f12195t;
                if (discoverViewModel4 == null) {
                    j.y("viewModel");
                    discoverViewModel4 = null;
                }
                List<GiveTakeBase> f11 = discoverViewModel4.S().f();
                j.d(f11);
                GiveTakeBase giveTakeBase = (GiveTakeBase) f11.get(i10);
                if (giveTakeBase instanceof GiveTake) {
                    z1((GiveTake) giveTakeBase);
                } else if (giveTakeBase instanceof RisingGiveTake) {
                    DiscoverViewModel discoverViewModel5 = this.f12195t;
                    if (discoverViewModel5 == null) {
                        j.y("viewModel");
                    } else {
                        discoverViewModel2 = discoverViewModel5;
                    }
                    discoverViewModel2.w0((RisingGiveTake) giveTakeBase);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void B1(NetworkProfile networkProfile, int i10, boolean z10, Integer num) {
        String str;
        fa.a.f40771d.a("DiscoverFeedFragment", "Profile Picture Clicked");
        DiscoverFeedListView discoverFeedListView = this.f12198y;
        DiscoverViewModel discoverViewModel = null;
        if (discoverFeedListView == null) {
            j.y("discoverListView");
            discoverFeedListView = null;
        }
        discoverFeedListView.p(i10);
        DiscoverViewModel discoverViewModel2 = this.f12195t;
        if (discoverViewModel2 == null) {
            j.y("viewModel");
            discoverViewModel2 = null;
        }
        if (discoverViewModel2.Q().f() == DiscoverViewModel.FilterStateViewState.ON) {
            str = "discover_search_item";
        } else if (z10) {
            str = "rising_give_take";
        } else {
            str = "give_take";
        }
        DiscoverViewModel discoverViewModel3 = this.f12195t;
        if (discoverViewModel3 == null) {
            j.y("viewModel");
        } else {
            discoverViewModel = discoverViewModel3;
        }
        List<GiveTakeBase> f10 = discoverViewModel.S().f();
        j.d(f10);
        GiveTakeBase giveTakeBase = (GiveTakeBase) f10.get(i10);
        boolean z11 = true;
        if (giveTakeBase instanceof GiveTake) {
            z11 = ((GiveTake) giveTakeBase).isLiked();
        } else {
            j.e(giveTakeBase, "null cannot be cast to non-null type com.coffeemeetsbagel.models.RisingGiveTake");
            if (((RisingGiveTake) giveTakeBase).getAction() != 1) {
                z11 = false;
            }
        }
        Intent intent = new Intent(getActivity(), BagelProfileComponentActivity.class);
        intent.putExtra("profile", networkProfile);
        intent.putExtra("source", "discover feed");
        intent.putExtra(Extra.SHOULD_SHOW_GIVE_OVERLAY, false);
        intent.putExtra(Extra.GIVE_TAKE_POSITION, i10);
        intent.putExtra(Extra.IS_RISING_GIVE_TAKE, z10);
        intent.putExtra(Extra.HAS_BEEN_ACTED_ON, z11);
        intent.putExtra(Extra.MATCH_TYPE, str);
        if (num != null) {
            intent.putExtra(Extra.VIEW_PAGER_POSITION, num.intValue());
        }
        startActivityForResult(intent, RequestCode.PROFILE_DETAIL_VIEW);
    }

    /* access modifiers changed from: private */
    public final void E1(Bagel bagel) {
        Intent intent = new Intent(getActivity(), ChatActivity.class);
        intent.putExtra(Extra.BAGEL, bagel);
        lc.a.e(this, intent, RequestCode.GENERIC);
    }

    /* access modifiers changed from: private */
    public final void G1() {
        lc.a.e(this, new Intent(getContext(), DiscoverFilterActivity.class), RequestCode.CHOOSE_FILTERS);
        h activity = getActivity();
        j.e(activity, "null cannot be cast to non-null type com.coffeemeetsbagel.activities.main.ActivityMain");
        ((ActivityMain) activity).V2();
    }

    private final void H1(GiveTake giveTake) {
        CharSequence charSequence;
        DiscoverFeedListView discoverFeedListView;
        DiscoverViewModel discoverViewModel = this.f12195t;
        if (discoverViewModel == null) {
            j.y("viewModel");
            discoverViewModel = null;
        }
        Price W = discoverViewModel.W();
        if (W == null) {
            fa.a.f40771d.c("DiscoverFeedFragment", "No price data for flower fetched", new IllegalStateException("Could not fetch price flower"));
            return;
        }
        int beanCost = W.getBeanCost(1);
        c cVar = new c(this, giveTake);
        if (beanCost == 0) {
            DiscoverFeedListView discoverFeedListView2 = this.f12198y;
            if (discoverFeedListView2 == null) {
                j.y("discoverListView");
                discoverFeedListView2 = null;
            }
            Context context = discoverFeedListView2.getContext();
            Object[] objArr = new Object[1];
            DiscoverFeedListView discoverFeedListView3 = this.f12198y;
            if (discoverFeedListView3 == null) {
                j.y("discoverListView");
                discoverFeedListView3 = null;
            }
            objArr[0] = discoverFeedListView3.getContext().getString(R.string.free_caps);
            charSequence = context.getString(R.string.skip_the_line_primary_cta, objArr);
            j.f(charSequence, "{\n            discoverLi…)\n            )\n        }");
        } else {
            DiscoverFeedListView discoverFeedListView4 = this.f12198y;
            if (discoverFeedListView4 == null) {
                j.y("discoverListView");
                discoverFeedListView4 = null;
            }
            charSequence = discoverFeedListView4.o(beanCost);
        }
        CharSequence charSequence2 = charSequence;
        DiscoverFeedListView discoverFeedListView5 = this.f12198y;
        if (discoverFeedListView5 == null) {
            j.y("discoverListView");
            discoverFeedListView = null;
        } else {
            discoverFeedListView = discoverFeedListView5;
        }
        discoverFeedListView.H(R.string.stand_out_with_flowers, R.string.send_flowers_description, charSequence2, R.string.cancel, cVar);
        g1().b("discover_send_flowers_ftue");
    }

    /* access modifiers changed from: private */
    public final void I1(List<? extends GiveTakeBase> list) {
        a.C0491a aVar = fa.a.f40771d;
        int size = list.size();
        aVar.a("DiscoverFeedFragment", "showGiveTakes: " + size);
        DiscoverFeedListView discoverFeedListView = this.f12198y;
        if (discoverFeedListView == null) {
            j.y("discoverListView");
            discoverFeedListView = null;
        }
        discoverFeedListView.post(new c(this, list));
    }

    /* access modifiers changed from: private */
    public static final void J1(DiscoverFragment discoverFragment, List list) {
        j.g(discoverFragment, "this$0");
        j.g(list, "$giveTakeBases");
        com.coffeemeetsbagel.discoverV2.list.b bVar = discoverFragment.f12197x;
        if (bVar == null) {
            j.y("discoverFeedAdapter");
            bVar = null;
        }
        bVar.R(list);
    }

    /* access modifiers changed from: private */
    public final void K1(PurchaseSource purchaseSource, PurchaseType purchaseType, Price price) {
        fa.a.f40771d.a("DiscoverFeedFragment", "showPremiumDialog()");
        if (this.E == null) {
            d dVar = new d(this);
            com.coffeemeetsbagel.subscription_dialog.dialog.e eVar = new com.coffeemeetsbagel.subscription_dialog.dialog.e(this);
            Context requireContext = requireContext();
            j.f(requireContext, "requireContext()");
            w b10 = eVar.b(requireContext, dVar);
            this.E = b10;
            r.a(b10);
            w wVar = this.E;
            j.d(wVar);
            wVar.r(SubscriptionBenefitAttribution.f36723a.a(purchaseSource), purchaseSource, purchaseType, true, price);
        }
    }

    /* access modifiers changed from: private */
    public final void L1(boolean z10) {
        String str;
        String str2;
        View view = null;
        if (this.D == null) {
            if (z10) {
                str = t9.a.discoverBannerFreeTrialCta;
            } else {
                str = t9.a.discoverBannerSubscriptionCta;
            }
            String str3 = str;
            if (z10) {
                str2 = t9.a.discoverBannerFreeTrialText;
            } else {
                str2 = t9.a.discoverBannerSubscriptionText;
            }
            String str4 = str2;
            e eVar = new e(this);
            g gVar = new g(this);
            k6.i iVar = this.f12182c;
            if (iVar == null) {
                j.y("binding");
                iVar = null;
            }
            RelativeLayout b10 = iVar.getRoot();
            j.f(b10, "binding.root");
            k6.i iVar2 = this.f12182c;
            if (iVar2 == null) {
                j.y("binding");
                iVar2 = null;
            }
            kc.a aVar = iVar2.f15766t;
            j.f(str3, "ctaText");
            j.f(str4, "description");
            com.coffeemeetsbagel.upsell_banner.n b11 = gVar.b(b10, aVar, eVar, z10, str3, str4, "Limelight");
            this.D = b11;
            r.a(b11);
        }
        View view2 = this.f12199z;
        if (view2 == null) {
            j.y("upsellBannerView");
        } else {
            view = view2;
        }
        view.setVisibility(0);
    }

    private final void M1(Price price) {
        Intent intent = new Intent(getContext(), ShopComponentActivity.class);
        intent.putExtra(Extra.PURCHASE_TYPE, PurchaseType.DISCOVER_LIKES);
        intent.putExtra(Extra.PRICE, price);
        intent.putExtra(Extra.ITEM_COUNT, 1);
        lc.a.e(this, intent, RequestCode.BEAN_SHOP);
    }

    /* access modifiers changed from: private */
    public final void N1(PurchaseType purchaseType) {
        Price price;
        DiscoverViewModel discoverViewModel = null;
        if (purchaseType == PurchaseType.PAID_LIKE) {
            DiscoverViewModel discoverViewModel2 = this.f12195t;
            if (discoverViewModel2 == null) {
                j.y("viewModel");
                discoverViewModel2 = null;
            }
            price = discoverViewModel2.W();
        } else {
            DiscoverViewModel discoverViewModel3 = this.f12195t;
            if (discoverViewModel3 == null) {
                j.y("viewModel");
                discoverViewModel3 = null;
            }
            price = discoverViewModel3.O();
        }
        DiscoverViewModel discoverViewModel4 = this.f12195t;
        if (discoverViewModel4 == null) {
            j.y("viewModel");
            discoverViewModel4 = null;
        }
        if (discoverViewModel4.g0()) {
            DiscoverFeedListView discoverFeedListView = this.f12198y;
            if (discoverFeedListView == null) {
                j.y("discoverListView");
                discoverFeedListView = null;
            }
            j.d(price);
            discoverFeedListView.E(price);
            DiscoverViewModel discoverViewModel5 = this.f12195t;
            if (discoverViewModel5 == null) {
                j.y("viewModel");
            } else {
                discoverViewModel = discoverViewModel5;
            }
            discoverViewModel.P0(price, this.f12196w);
            this.f12196w = false;
            return;
        }
        PurchaseSource purchaseSource = new PurchaseSource();
        j.d(purchaseType);
        j.d(price);
        K1(purchaseSource, purchaseType, price);
    }

    /* access modifiers changed from: private */
    public final void O1() {
        DiscoverViewModel discoverViewModel = this.f12195t;
        DiscoverViewModel discoverViewModel2 = null;
        if (discoverViewModel == null) {
            j.y("viewModel");
            discoverViewModel = null;
        }
        if (discoverViewModel.S().f() != null) {
            int i10 = 0;
            DiscoverViewModel discoverViewModel3 = this.f12195t;
            if (discoverViewModel3 == null) {
                j.y("viewModel");
            } else {
                discoverViewModel2 = discoverViewModel3;
            }
            List<GiveTakeBase> f10 = discoverViewModel2.S().f();
            j.d(f10);
            for (GiveTakeBase giveTakeBase : f10) {
                if ((giveTakeBase instanceof RisingGiveTake) && !((RisingGiveTake) giveTakeBase).isShown()) {
                    i10++;
                }
            }
            h activity = getActivity();
            if (activity != null) {
                ((ActivityMain) activity).i5(i10);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void c1(GiveTake giveTake, PurchaseType purchaseType) {
        DiscoverFeedListView discoverFeedListView = this.f12198y;
        DiscoverViewModel discoverViewModel = null;
        if (discoverFeedListView == null) {
            j.y("discoverListView");
            discoverFeedListView = null;
        }
        discoverFeedListView.G();
        DiscoverFeedListView discoverFeedListView2 = this.f12198y;
        if (discoverFeedListView2 == null) {
            j.y("discoverListView");
            discoverFeedListView2 = null;
        }
        discoverFeedListView2.k();
        DiscoverViewModel discoverViewModel2 = this.f12195t;
        if (discoverViewModel2 == null) {
            j.y("viewModel");
        } else {
            discoverViewModel = discoverViewModel2;
        }
        discoverViewModel.l0(giveTake, purchaseType);
    }

    /* access modifiers changed from: private */
    public final int j1(GiveTakeBase giveTakeBase) {
        DiscoverViewModel discoverViewModel = this.f12195t;
        if (discoverViewModel == null) {
            j.y("viewModel");
            discoverViewModel = null;
        }
        List<GiveTakeBase> f10 = discoverViewModel.S().f();
        if (f10 == null) {
            return -1;
        }
        int i10 = 0;
        for (GiveTakeBase id2 : f10) {
            if (j.b(id2.getId(), giveTakeBase.getId())) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final void s1(Price price) {
        DiscoverFeedListView discoverFeedListView = this.f12198y;
        DiscoverViewModel discoverViewModel = null;
        if (discoverFeedListView == null) {
            j.y("discoverListView");
            discoverFeedListView = null;
        }
        discoverFeedListView.l();
        M1(price);
        DiscoverViewModel discoverViewModel2 = this.f12195t;
        if (discoverViewModel2 == null) {
            j.y("viewModel");
        } else {
            discoverViewModel = discoverViewModel2;
        }
        discoverViewModel.P0(price, this.f12196w);
    }

    /* access modifiers changed from: private */
    public final void t1() {
        fa.a.f40771d.a("DiscoverFeedFragment", "hidePremiumDialog()");
        w wVar = this.E;
        if (wVar != null) {
            r.b(wVar);
            this.E = null;
        }
    }

    /* access modifiers changed from: private */
    public final void u1() {
        DiscoverFeedListView discoverFeedListView = this.f12198y;
        DiscoverViewModel discoverViewModel = null;
        if (discoverFeedListView == null) {
            j.y("discoverListView");
            discoverFeedListView = null;
        }
        int firstVisibleCard = discoverFeedListView.getFirstVisibleCard();
        DiscoverFeedListView discoverFeedListView2 = this.f12198y;
        if (discoverFeedListView2 == null) {
            j.y("discoverListView");
            discoverFeedListView2 = null;
        }
        Integer lastVisibleCard = discoverFeedListView2.getLastVisibleCard();
        DiscoverViewModel discoverViewModel2 = this.f12195t;
        if (discoverViewModel2 == null) {
            j.y("viewModel");
            discoverViewModel2 = null;
        }
        discoverViewModel2.i0(firstVisibleCard);
        if (lastVisibleCard != null) {
            DiscoverViewModel discoverViewModel3 = this.f12195t;
            if (discoverViewModel3 == null) {
                j.y("viewModel");
            } else {
                discoverViewModel = discoverViewModel3;
            }
            discoverViewModel.i0(lastVisibleCard.intValue());
        }
        O1();
    }

    private final void v1() {
        DiscoverFeedListView discoverFeedListView = this.f12198y;
        if (discoverFeedListView == null) {
            j.y("discoverListView");
            discoverFeedListView = null;
        }
        discoverFeedListView.i();
        DiscoverFeedFiltersView discoverFeedFiltersView = this.C;
        if (discoverFeedFiltersView == null) {
            j.y("discoverFeedFiltersView");
            discoverFeedFiltersView = null;
        }
        discoverFeedFiltersView.setOnClickListener(new b(this));
        s1 unused = j.d(l0.a(x1.b((s1) null, 1, (Object) null).e0(x0.c())), (CoroutineContext) null, (CoroutineStart) null, new DiscoverFragment$observeUserInteractions$2(this, (kotlin.coroutines.c<? super DiscoverFragment$observeUserInteractions$2>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void w1(DiscoverFragment discoverFragment, View view) {
        j.g(discoverFragment, "this$0");
        discoverFragment.G1();
    }

    private final void x1() {
        DiscoverViewModel discoverViewModel = this.f12195t;
        DiscoverViewModel discoverViewModel2 = null;
        if (discoverViewModel == null) {
            j.y("viewModel");
            discoverViewModel = null;
        }
        discoverViewModel.S().i(this, new b(new DiscoverFragment$observeViewModel$1(this)));
        DiscoverViewModel discoverViewModel3 = this.f12195t;
        if (discoverViewModel3 == null) {
            j.y("viewModel");
            discoverViewModel3 = null;
        }
        discoverViewModel3.c0().i(this, new b(new DiscoverFragment$observeViewModel$2(this)));
        DiscoverViewModel discoverViewModel4 = this.f12195t;
        if (discoverViewModel4 == null) {
            j.y("viewModel");
            discoverViewModel4 = null;
        }
        discoverViewModel4.V().i(this, new b(new DiscoverFragment$observeViewModel$3(this)));
        DiscoverViewModel discoverViewModel5 = this.f12195t;
        if (discoverViewModel5 == null) {
            j.y("viewModel");
            discoverViewModel5 = null;
        }
        discoverViewModel5.X().i(this, new b(new DiscoverFragment$observeViewModel$4(this)));
        DiscoverViewModel discoverViewModel6 = this.f12195t;
        if (discoverViewModel6 == null) {
            j.y("viewModel");
            discoverViewModel6 = null;
        }
        discoverViewModel6.Q().i(this, new b(new DiscoverFragment$observeViewModel$5(this)));
        DiscoverViewModel discoverViewModel7 = this.f12195t;
        if (discoverViewModel7 == null) {
            j.y("viewModel");
            discoverViewModel7 = null;
        }
        discoverViewModel7.a0().i(this, new b(new DiscoverFragment$observeViewModel$6(this)));
        DiscoverViewModel discoverViewModel8 = this.f12195t;
        if (discoverViewModel8 == null) {
            j.y("viewModel");
            discoverViewModel8 = null;
        }
        discoverViewModel8.d0().i(this, new b(new DiscoverFragment$observeViewModel$7(this)));
        DiscoverViewModel discoverViewModel9 = this.f12195t;
        if (discoverViewModel9 == null) {
            j.y("viewModel");
            discoverViewModel9 = null;
        }
        discoverViewModel9.K().i(this, new b(new DiscoverFragment$observeViewModel$8(this)));
        DiscoverViewModel discoverViewModel10 = this.f12195t;
        if (discoverViewModel10 == null) {
            j.y("viewModel");
        } else {
            discoverViewModel2 = discoverViewModel10;
        }
        discoverViewModel2.M().i(this, new b(new DiscoverFragment$observeViewModel$9(this)));
    }

    private final void z1(GiveTake giveTake) {
        boolean z10;
        String str;
        int i10;
        int i11;
        DiscoverViewModel discoverViewModel = this.f12195t;
        DiscoverFeedListView discoverFeedListView = null;
        if (discoverViewModel == null) {
            j.y("viewModel");
            discoverViewModel = null;
        }
        Price O = discoverViewModel.O();
        if (giveTake.isLiked()) {
            fa.a.f40771d.b("DiscoverFeedFragment", "GiveTake already taken");
        } else if (O == null) {
            fa.a.f40771d.b("DiscoverFeedFragment", "No price data for take fetched");
        } else {
            if (O.getBeanCost(1) == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                k6.i iVar = this.f12182c;
                if (iVar == null) {
                    j.y("binding");
                    iVar = null;
                }
                str = iVar.getRoot().getContext().getResources().getString(R.string.confirm_sending_discover_like, new Object[]{Integer.valueOf(O.getBeanCost(1))});
            } else if (!e1().m().booleanValue()) {
                k6.i iVar2 = this.f12182c;
                if (iVar2 == null) {
                    j.y("binding");
                    iVar2 = null;
                }
                str = iVar2.getRoot().getContext().getString(R.string.dialog_confirm_discover_like_free_bagel);
            } else if (O.isUnlimited()) {
                k6.i iVar3 = this.f12182c;
                if (iVar3 == null) {
                    j.y("binding");
                    iVar3 = null;
                }
                str = iVar3.getRoot().getContext().getString(R.string.you_have_unlimited_discover_likes);
            } else {
                k6.i iVar4 = this.f12182c;
                if (iVar4 == null) {
                    j.y("binding");
                    iVar4 = null;
                }
                str = iVar4.getRoot().getContext().getResources().getQuantityString(R.plurals.dialog_confirm_free_discover_like, O.getFreeItemCount(), new Object[]{Integer.valueOf(O.getFreeItemCount())});
            }
            j.f(str, "if (hasFree) {\n         …          )\n            }");
            NetworkProfile j10 = k1().j();
            j.d(j10);
            if (j10.isOnHold()) {
                k6.i iVar5 = this.f12182c;
                if (iVar5 == null) {
                    j.y("binding");
                    iVar5 = null;
                }
                str = iVar5.getRoot().getContext().getString(R.string.paused_account_discover_like_pop_up_message);
                j.f(str, "binding.root.context.get…over_like_pop_up_message)");
                i11 = R.string.paused_account_discover_like_pop_up_cta;
                i10 = R.string.paused_account_discover_like_pop_up_title;
            } else {
                i11 = R.string.continue_lc;
                i10 = R.string.discover_like;
            }
            DiscoverFeedListView discoverFeedListView2 = this.f12198y;
            if (discoverFeedListView2 == null) {
                j.y("discoverListView");
            } else {
                discoverFeedListView = discoverFeedListView2;
            }
            discoverFeedListView.r(i10, str, i11, giveTake);
        }
    }

    public final void C1() {
        if (getArguments() == null || !requireArguments().containsKey(Extra.ROUTE_TO_DISCOVER_FILTERS)) {
            DiscoverViewModel discoverViewModel = this.f12195t;
            if (discoverViewModel == null) {
                j.y("viewModel");
                discoverViewModel = null;
            }
            discoverViewModel.i0(0);
            return;
        }
        requireArguments().remove(Extra.ROUTE_TO_DISCOVER_FILTERS);
        G1();
    }

    public final void D1() {
    }

    public final void F1(com.coffeemeetsbagel.upsell_banner.n nVar) {
        this.D = nVar;
    }

    public s9.a b() {
        return h1();
    }

    public a7.a c() {
        return d1();
    }

    public final a7.a d1() {
        a7.a aVar = this.f12191m;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }

    public UserRepository e() {
        return p1();
    }

    public final s e1() {
        s sVar = this.f12183d;
        if (sVar != null) {
            return sVar;
        }
        j.y("bagelManager");
        return null;
    }

    public cb.a f() {
        return m1();
    }

    public final BuySubscriptionUseCase f1() {
        BuySubscriptionUseCase buySubscriptionUseCase = this.f12190l;
        if (buySubscriptionUseCase != null) {
            return buySubscriptionUseCase;
        }
        j.y("buySubscriptionUseCase");
        return null;
    }

    public BuySubscriptionUseCase g() {
        return f1();
    }

    public final a6.a g1() {
        a6.a aVar = this.f12187h;
        if (aVar != null) {
            return aVar;
        }
        j.y("coachmarkManager");
        return null;
    }

    public GetMyOwnProfileLocalUseCase h() {
        return i1();
    }

    public final s9.a h1() {
        s9.a aVar = this.f12184e;
        if (aVar != null) {
            return aVar;
        }
        j.y("featureManagerv2");
        return null;
    }

    public final GetMyOwnProfileLocalUseCase i1() {
        GetMyOwnProfileLocalUseCase getMyOwnProfileLocalUseCase = this.f12194q;
        if (getMyOwnProfileLocalUseCase != null) {
            return getMyOwnProfileLocalUseCase;
        }
        j.y("getMyOwnProfileUseCase");
        return null;
    }

    public final ProfileManager k1() {
        ProfileManager profileManager = this.f12186g;
        if (profileManager != null) {
            return profileManager;
        }
        j.y("profileManager");
        return null;
    }

    public final PurchaseManager l1() {
        PurchaseManager purchaseManager = this.f12185f;
        if (purchaseManager != null) {
            return purchaseManager;
        }
        j.y("purchaseManager");
        return null;
    }

    public SubscriptionRepository m() {
        return n1();
    }

    public final cb.a m1() {
        cb.a aVar = this.f12193p;
        if (aVar != null) {
            return aVar;
        }
        j.y("schedulerProvider");
        return null;
    }

    public androidx.appcompat.app.c n() {
        h activity = getActivity();
        j.e(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        return (androidx.appcompat.app.c) activity;
    }

    public final SubscriptionRepository n1() {
        SubscriptionRepository subscriptionRepository = this.f12189k;
        if (subscriptionRepository != null) {
            return subscriptionRepository;
        }
        j.y("subscriptionRepository");
        return null;
    }

    public final com.coffeemeetsbagel.upsell_banner.n o1() {
        return this.D;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.coffeemeetsbagel.discoverV2.DiscoverViewModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.coffeemeetsbagel.discoverV2.DiscoverViewModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.coffeemeetsbagel.discoverV2.list.DiscoverFeedListView} */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r5, int r6, android.content.Intent r7) {
        /*
            r4 = this;
            super.onActivityResult(r5, r6, r7)
            fa.a$a r0 = fa.a.f40771d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onActivityResult() req= $"
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = " res="
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "DiscoverFeedFragment"
            r0.a(r2, r1)
            c6.a r0 = new c6.a
            r0.<init>(r5, r6, r7)
            r6 = 5400(0x1518, float:7.567E-42)
            java.lang.String r7 = "viewModel"
            r1 = 0
            if (r5 == r6) goto L_0x00ef
            r6 = 9280(0x2440, float:1.3004E-41)
            if (r5 == r6) goto L_0x00e2
            r6 = 9292(0x244c, float:1.3021E-41)
            if (r5 == r6) goto L_0x0039
            goto L_0x0101
        L_0x0039:
            java.lang.Integer r5 = lc.b.b(r0)
            java.lang.Integer r6 = lc.b.a(r0)
            if (r6 == 0) goto L_0x00a2
            com.coffeemeetsbagel.discoverV2.DiscoverViewModel r2 = r4.f12195t
            if (r2 != 0) goto L_0x004b
            kotlin.jvm.internal.j.y(r7)
            r2 = r1
        L_0x004b:
            androidx.lifecycle.LiveData r2 = r2.S()
            java.lang.Object r2 = r2.f()
            if (r2 == 0) goto L_0x00a2
            com.coffeemeetsbagel.discoverV2.DiscoverViewModel r2 = r4.f12195t
            if (r2 != 0) goto L_0x005d
            kotlin.jvm.internal.j.y(r7)
            r2 = r1
        L_0x005d:
            androidx.lifecycle.LiveData r2 = r2.S()
            java.lang.Object r2 = r2.f()
            kotlin.jvm.internal.j.d(r2)
            java.util.List r2 = (java.util.List) r2
            int r2 = r2.size()
            int r3 = r6.intValue()
            if (r2 <= r3) goto L_0x00a2
            com.coffeemeetsbagel.discoverV2.DiscoverViewModel r2 = r4.f12195t
            if (r2 != 0) goto L_0x007c
            kotlin.jvm.internal.j.y(r7)
            r2 = r1
        L_0x007c:
            com.coffeemeetsbagel.discoverV2.DiscoverViewModel r3 = r4.f12195t
            if (r3 != 0) goto L_0x0084
            kotlin.jvm.internal.j.y(r7)
            r3 = r1
        L_0x0084:
            androidx.lifecycle.LiveData r7 = r3.S()
            java.lang.Object r7 = r7.f()
            kotlin.jvm.internal.j.d(r7)
            java.util.List r7 = (java.util.List) r7
            int r3 = r6.intValue()
            java.lang.Object r7 = r7.get(r3)
            com.coffeemeetsbagel.models.interfaces.GiveTakeBase r7 = (com.coffeemeetsbagel.models.interfaces.GiveTakeBase) r7
            java.lang.String r7 = r7.getProfileId()
            r2.G0(r7)
        L_0x00a2:
            if (r6 == 0) goto L_0x00bc
            if (r5 == 0) goto L_0x00bc
            com.coffeemeetsbagel.discoverV2.list.DiscoverFeedListView r7 = r4.f12198y
            if (r7 != 0) goto L_0x00b0
            java.lang.String r7 = "discoverListView"
            kotlin.jvm.internal.j.y(r7)
            goto L_0x00b1
        L_0x00b0:
            r1 = r7
        L_0x00b1:
            int r7 = r6.intValue()
            int r5 = r5.intValue()
            r1.x(r7, r5)
        L_0x00bc:
            if (r6 == 0) goto L_0x00cd
            int r5 = r0.c()
            r7 = 64
            if (r5 != r7) goto L_0x00cd
            int r5 = r6.intValue()
            r4.A1(r5)
        L_0x00cd:
            if (r6 == 0) goto L_0x0101
            int r5 = r0.c()
            r7 = 68
            if (r5 != r7) goto L_0x0101
            r5 = 1
            r4.f12196w = r5
            int r6 = r6.intValue()
            r4.y1(r6, r5)
            goto L_0x0101
        L_0x00e2:
            com.coffeemeetsbagel.discoverV2.DiscoverViewModel r5 = r4.f12195t
            if (r5 != 0) goto L_0x00ea
            kotlin.jvm.internal.j.y(r7)
            goto L_0x00eb
        L_0x00ea:
            r1 = r5
        L_0x00eb:
            r1.m0()
            goto L_0x0101
        L_0x00ef:
            boolean r5 = lc.b.c(r0)
            if (r5 == 0) goto L_0x0101
            com.coffeemeetsbagel.discoverV2.DiscoverViewModel r5 = r4.f12195t
            if (r5 != 0) goto L_0x00fd
            kotlin.jvm.internal.j.y(r7)
            goto L_0x00fe
        L_0x00fd:
            r1 = r5
        L_0x00fe:
            r1.k0(r0)
        L_0x0101:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.discoverV2.DiscoverFragment.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onAttach(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        super.onAttach(context);
        Bakery.j().S0(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f12195t = (DiscoverViewModel) new i0((androidx.lifecycle.l0) this, (i0.b) q1()).a(DiscoverViewModel.class);
        x1();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.g(layoutInflater, "inflater");
        fa.a.f40771d.a("DiscoverFeedFragment", "onCreateView()");
        k6.i c10 = k6.i.c(getLayoutInflater());
        j.f(c10, "inflate(layoutInflater)");
        this.f12182c = c10;
        k6.i iVar = null;
        if (c10 == null) {
            j.y("binding");
            c10 = null;
        }
        DiscoverFeedListView discoverFeedListView = c10.f15757g;
        j.f(discoverFeedListView, "binding.discoverListView");
        this.f12198y = discoverFeedListView;
        k6.i iVar2 = this.f12182c;
        if (iVar2 == null) {
            j.y("binding");
            iVar2 = null;
        }
        ConstraintLayout b10 = iVar2.f15766t.getRoot();
        j.f(b10, "binding.upsellBanner.root");
        this.f12199z = b10;
        k6.i iVar3 = this.f12182c;
        if (iVar3 == null) {
            j.y("binding");
            iVar3 = null;
        }
        DiscoverFeedFiltersView discoverFeedFiltersView = iVar3.f15756f;
        j.f(discoverFeedFiltersView, "binding.discoverFilters");
        this.C = discoverFeedFiltersView;
        k6.i iVar4 = this.f12182c;
        if (iVar4 == null) {
            j.y("binding");
            iVar4 = null;
        }
        DiscoverFeedEmptyView discoverFeedEmptyView = iVar4.f15764p;
        j.f(discoverFeedEmptyView, "binding.giveTakeNoItems");
        this.B = discoverFeedEmptyView;
        k6.i iVar5 = this.f12182c;
        if (iVar5 == null) {
            j.y("binding");
        } else {
            iVar = iVar5;
        }
        RelativeLayout b11 = iVar.getRoot();
        j.f(b11, "binding.root");
        return b11;
    }

    public void onStart() {
        super.onStart();
        h activity = getActivity();
        j.e(activity, "null cannot be cast to non-null type com.coffeemeetsbagel.activities.main.ActivityMain");
        ((ActivityMain) activity).X2();
        DiscoverViewModel discoverViewModel = this.f12195t;
        if (discoverViewModel == null) {
            j.y("viewModel");
            discoverViewModel = null;
        }
        discoverViewModel.J();
    }

    public void onStop() {
        super.onStop();
        DiscoverViewModel discoverViewModel = this.f12195t;
        DiscoverFeedListView discoverFeedListView = null;
        if (discoverViewModel == null) {
            j.y("viewModel");
            discoverViewModel = null;
        }
        discoverViewModel.R0();
        DiscoverFeedListView discoverFeedListView2 = this.f12198y;
        if (discoverFeedListView2 == null) {
            j.y("discoverListView");
        } else {
            discoverFeedListView = discoverFeedListView2;
        }
        discoverFeedListView.j();
    }

    public void onViewCreated(View view, Bundle bundle) {
        j.g(view, "view");
        super.onViewCreated(view, bundle);
        this.f12197x = new com.coffeemeetsbagel.discoverV2.list.b(k1(), l1(), h1(), g1());
        DiscoverFeedListView discoverFeedListView = this.f12198y;
        com.coffeemeetsbagel.discoverV2.list.b bVar = null;
        if (discoverFeedListView == null) {
            j.y("discoverListView");
            discoverFeedListView = null;
        }
        com.coffeemeetsbagel.discoverV2.list.b bVar2 = this.f12197x;
        if (bVar2 == null) {
            j.y("discoverFeedAdapter");
        } else {
            bVar = bVar2;
        }
        discoverFeedListView.setAdapter(bVar);
        v1();
    }

    public final UserRepository p1() {
        UserRepository userRepository = this.f12192n;
        if (userRepository != null) {
            return userRepository;
        }
        j.y("userRepository");
        return null;
    }

    public final k q1() {
        k kVar = this.f12188j;
        if (kVar != null) {
            return kVar;
        }
        j.y("viewModelFactory");
        return null;
    }

    public final void r1(PurchaseSource purchaseSource) {
        j.g(purchaseSource, "purchaseSource");
        PremiumUpsellComponentActivity.a.e(PremiumUpsellComponentActivity.f36846j, this, purchaseSource, false, 4, (Object) null);
    }

    public final void y1(int i10, boolean z10) {
        DiscoverViewModel discoverViewModel = this.f12195t;
        DiscoverViewModel discoverViewModel2 = null;
        if (discoverViewModel == null) {
            j.y("viewModel");
            discoverViewModel = null;
        }
        if (discoverViewModel.S().f() != null) {
            DiscoverViewModel discoverViewModel3 = this.f12195t;
            if (discoverViewModel3 == null) {
                j.y("viewModel");
                discoverViewModel3 = null;
            }
            List<GiveTakeBase> f10 = discoverViewModel3.S().f();
            j.d(f10);
            if (f10.size() > i10) {
                boolean a10 = g1().a("discover_send_flowers_ftue");
                DiscoverViewModel discoverViewModel4 = this.f12195t;
                if (discoverViewModel4 == null) {
                    j.y("viewModel");
                    discoverViewModel4 = null;
                }
                List<GiveTakeBase> f11 = discoverViewModel4.S().f();
                j.d(f11);
                GiveTakeBase giveTakeBase = (GiveTakeBase) f11.get(i10);
                if (giveTakeBase instanceof GiveTake) {
                    if (!a10) {
                        H1((GiveTake) giveTakeBase);
                        return;
                    }
                    DiscoverViewModel discoverViewModel5 = this.f12195t;
                    if (discoverViewModel5 == null) {
                        j.y("viewModel");
                    } else {
                        discoverViewModel2 = discoverViewModel5;
                    }
                    discoverViewModel2.o0((GiveTake) giveTakeBase, z10);
                } else if (giveTakeBase instanceof RisingGiveTake) {
                    DiscoverViewModel discoverViewModel6 = this.f12195t;
                    if (discoverViewModel6 == null) {
                        j.y("viewModel");
                    } else {
                        discoverViewModel2 = discoverViewModel6;
                    }
                    discoverViewModel2.w0((RisingGiveTake) giveTakeBase);
                }
            }
        }
    }
}
