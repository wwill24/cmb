package com.coffeemeetsbagel.boost;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.i0;
import androidx.lifecycle.l0;
import androidx.lifecycle.m;
import androidx.lifecycle.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.dialogs.b0;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import com.coffeemeetsbagel.feature.purchase.AutoPurchase;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.shop.ShopComponentActivity;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import com.coffeemeetsbagel.util.RequestCode;
import com.mparticle.identity.IdentityHttpResponse;
import gk.c;
import gk.f;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.s1;
import r7.h;

public final class BoostDialogFragment extends com.google.android.material.bottomsheet.b {

    /* renamed from: q  reason: collision with root package name */
    public static final a f11414q = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f11415b = "BoostDialogFragment";

    /* renamed from: c  reason: collision with root package name */
    public a7.a f11416c;

    /* renamed from: d  reason: collision with root package name */
    public FirebaseContract.Analytics f11417d;

    /* renamed from: e  reason: collision with root package name */
    public BoostAnalytics f11418e;

    /* renamed from: f  reason: collision with root package name */
    public i f11419f;

    /* renamed from: g  reason: collision with root package name */
    public com.coffeemeetsbagel.store.alc.a f11420g;

    /* renamed from: h  reason: collision with root package name */
    private k5.a f11421h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public BoostViewModel f11422j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public AutoPurchase f11423k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public g f11424l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f11425m = true;

    /* renamed from: n  reason: collision with root package name */
    private final f f11426n = b.b(new BoostDialogFragment$insufficientBeansDialog$2(this));

    /* renamed from: p  reason: collision with root package name */
    private final f f11427p = b.b(new BoostDialogFragment$processDialog$2(this));

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BoostDialogFragment a(g gVar) {
            j.g(gVar, "listener");
            BoostDialogFragment boostDialogFragment = new BoostDialogFragment();
            boostDialogFragment.f11424l = gVar;
            return boostDialogFragment;
        }
    }

    static final class b implements u, kotlin.jvm.internal.f {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f11428a;

        b(Function1 function1) {
            j.g(function1, "function");
            this.f11428a = function1;
        }

        public final c<?> a() {
            return this.f11428a;
        }

        public final /* synthetic */ void b(Object obj) {
            this.f11428a.invoke(obj);
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

    private final CharSequence T0(Integer num) {
        ImageSpan imageSpan;
        String str = "(" + num + "  )";
        k5.a aVar = this.f11421h;
        k5.a aVar2 = null;
        if (aVar == null) {
            j.y("binding");
            aVar = null;
        }
        String str2 = aVar.getRoot().getResources().getString(R.string.boost_me) + " " + str;
        SpannableString spannableString = new SpannableString(str2);
        int g02 = (StringsKt__StringsKt.g0(str2, str, 0, false, 6, (Object) null) + str.length()) - 2;
        k5.a aVar3 = this.f11421h;
        if (aVar3 == null) {
            j.y("binding");
        } else {
            aVar2 = aVar3;
        }
        Drawable drawable = androidx.core.content.a.getDrawable(aVar2.getRoot().getContext(), R.drawable.ic_single_bean);
        j.d(drawable);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.mutate().setTint(-1);
        if (Build.VERSION.SDK_INT >= 29) {
            imageSpan = new ImageSpan(drawable, 2);
        } else {
            imageSpan = new ImageSpan(drawable);
        }
        spannableString.setSpan(imageSpan, g02, g02 + 1, 0);
        return spannableString;
    }

    private final b0 V0() {
        return (b0) this.f11426n.getValue();
    }

    /* access modifiers changed from: private */
    public final h W0() {
        return (h) this.f11427p.getValue();
    }

    /* access modifiers changed from: private */
    public final void b1() {
        BoostViewModel boostViewModel = this.f11422j;
        if (boostViewModel == null) {
            j.y("viewModel");
            boostViewModel = null;
        }
        Price s10 = boostViewModel.s();
        if (s10 != null) {
            this.f11423k = new AutoPurchase(PurchaseType.BOOST, 1, s10, s10.getBeans(), "");
            j1(s10);
        }
    }

    /* access modifiers changed from: private */
    public final void c1() {
        fa.a.f40771d.a(this.f11415b, "handlePurchaseFailure");
        com.coffeemeetsbagel.store.alc.a X0 = X0();
        String a10 = PurchaseType.BOOST.a();
        j.f(a10, "BOOST.analyticsItemName");
        BoostViewModel boostViewModel = this.f11422j;
        BoostViewModel boostViewModel2 = null;
        if (boostViewModel == null) {
            j.y("viewModel");
            boostViewModel = null;
        }
        Price s10 = boostViewModel.s();
        j.d(s10);
        X0.a(a10, 1, s10.getBeans());
        BoostAnalytics Y0 = Y0();
        BoostViewModel boostViewModel3 = this.f11422j;
        if (boostViewModel3 == null) {
            j.y("viewModel");
        } else {
            boostViewModel2 = boostViewModel3;
        }
        Y0.e(boostViewModel2.q());
        g gVar = this.f11424l;
        if (gVar != null) {
            gVar.b();
        }
    }

    /* access modifiers changed from: private */
    public final void d1() {
        fa.a.f40771d.a(this.f11415b, "handlePurchaseSuccess");
        com.coffeemeetsbagel.store.alc.a X0 = X0();
        String a10 = PurchaseType.BOOST.a();
        j.f(a10, "BOOST.analyticsItemName");
        BoostViewModel boostViewModel = this.f11422j;
        BoostViewModel boostViewModel2 = null;
        if (boostViewModel == null) {
            j.y("viewModel");
            boostViewModel = null;
        }
        X0.b(a10, 1, boostViewModel.n());
        BoostAnalytics Y0 = Y0();
        BoostViewModel boostViewModel3 = this.f11422j;
        if (boostViewModel3 == null) {
            j.y("viewModel");
        } else {
            boostViewModel2 = boostViewModel3;
        }
        Y0.d(boostViewModel2.q());
        this.f11425m = false;
        g gVar = this.f11424l;
        if (gVar != null) {
            gVar.onSuccess();
        }
        dismiss();
    }

    private final void e1() {
        fa.a.f40771d.a(this.f11415b, "onBottomSheetDismissed");
        if (this.f11425m) {
            BoostAnalytics Y0 = Y0();
            BoostViewModel boostViewModel = this.f11422j;
            if (boostViewModel == null) {
                j.y("viewModel");
                boostViewModel = null;
            }
            Y0.c(Boolean.valueOf(boostViewModel.z()));
            g gVar = this.f11424l;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void f1(BoostDialogFragment boostDialogFragment, View view) {
        j.g(boostDialogFragment, "this$0");
        boostDialogFragment.f11423k = null;
        PremiumUpsellComponentActivity.a.e(PremiumUpsellComponentActivity.f36846j, boostDialogFragment, new PurchaseSource(ModelDeeplinkData.VALUE_PAGE_BOOST, "Boost"), false, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void g1(BoostDialogFragment boostDialogFragment, View view) {
        j.g(boostDialogFragment, "this$0");
        boostDialogFragment.Y0().a();
        s1 unused = j.d(m.a(boostDialogFragment), (CoroutineContext) null, (CoroutineStart) null, new BoostDialogFragment$onCreateView$2$1(boostDialogFragment, (kotlin.coroutines.c<? super BoostDialogFragment$onCreateView$2$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void h1(BoostDialogFragment boostDialogFragment, View view) {
        j.g(boostDialogFragment, "this$0");
        boostDialogFragment.Y0().f();
        boostDialogFragment.dismiss();
    }

    private final void j1(Price price) {
        Y0().h();
        b0 V0 = V0();
        V0.b(new e(this, price));
        V0.show();
    }

    /* access modifiers changed from: private */
    public static final void k1(BoostDialogFragment boostDialogFragment, Price price, View view) {
        j.g(boostDialogFragment, "this$0");
        j.g(price, "$price");
        boostDialogFragment.Y0().g();
        boostDialogFragment.startActivityForResult(ShopComponentActivity.U0(boostDialogFragment.requireContext(), PurchaseType.BOOST, 1, price, (long) price.getBeans(), new PurchaseSource(ModelDeeplinkData.VALUE_PAGE_BOOST, "Boost")), RequestCode.BEAN_SHOP);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0178  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l1() {
        /*
            r13 = this;
            com.coffeemeetsbagel.boost.BoostViewModel r0 = r13.f11422j
            java.lang.String r1 = "viewModel"
            r2 = 0
            if (r0 != 0) goto L_0x000b
            kotlin.jvm.internal.j.y(r1)
            r0 = r2
        L_0x000b:
            com.coffeemeetsbagel.models.Price r0 = r0.s()
            fa.a$a r3 = fa.a.f40771d
            java.lang.String r4 = r13.f11415b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "updateViews(): "
            r5.append(r6)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            r3.a(r4, r5)
            com.coffeemeetsbagel.boost.BoostViewModel r3 = r13.f11422j
            if (r3 != 0) goto L_0x002f
            kotlin.jvm.internal.j.y(r1)
            r3 = r2
        L_0x002f:
            int r3 = r3.o()
            r4 = 1
            r5 = 0
            if (r3 > 0) goto L_0x0048
            com.coffeemeetsbagel.boost.BoostViewModel r3 = r13.f11422j
            if (r3 != 0) goto L_0x003f
            kotlin.jvm.internal.j.y(r1)
            r3 = r2
        L_0x003f:
            boolean r3 = r3.y()
            if (r3 == 0) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r3 = r5
            goto L_0x0049
        L_0x0048:
            r3 = r4
        L_0x0049:
            com.coffeemeetsbagel.boost.BoostViewModel r6 = r13.f11422j
            if (r6 != 0) goto L_0x0051
            kotlin.jvm.internal.j.y(r1)
            r6 = r2
        L_0x0051:
            boolean r6 = r6.y()
            if (r6 != 0) goto L_0x0067
            com.coffeemeetsbagel.boost.BoostViewModel r6 = r13.f11422j
            if (r6 != 0) goto L_0x005f
            kotlin.jvm.internal.j.y(r1)
            r6 = r2
        L_0x005f:
            int r6 = r6.o()
            if (r6 != 0) goto L_0x0067
            r6 = r4
            goto L_0x0068
        L_0x0067:
            r6 = r5
        L_0x0068:
            com.coffeemeetsbagel.boost.BoostViewModel r7 = r13.f11422j
            if (r7 != 0) goto L_0x0070
            kotlin.jvm.internal.j.y(r1)
            r7 = r2
        L_0x0070:
            int r1 = r7.o()
            k5.a r7 = r13.f11421h
            java.lang.String r8 = "binding"
            if (r7 != 0) goto L_0x007e
            kotlin.jvm.internal.j.y(r8)
            r7 = r2
        L_0x007e:
            com.coffeemeetsbagel.cmb_views.CmbTextView r7 = r7.f15666g
            r7.setVisibility(r5)
            k5.a r7 = r13.f11421h
            if (r7 != 0) goto L_0x008b
            kotlin.jvm.internal.j.y(r8)
            r7 = r2
        L_0x008b:
            com.coffeemeetsbagel.cmb_views.CmbTextView r7 = r7.f15666g
            k5.a r9 = r13.f11421h
            if (r9 != 0) goto L_0x0095
            kotlin.jvm.internal.j.y(r8)
            r9 = r2
        L_0x0095:
            androidx.constraintlayout.widget.ConstraintLayout r9 = r9.getRoot()
            android.content.Context r9 = r9.getContext()
            r10 = 2131886198(0x7f120076, float:1.9406968E38)
            java.lang.Object[] r11 = new java.lang.Object[r4]
            java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
            r11[r5] = r12
            java.lang.String r9 = r9.getString(r10, r11)
            r7.setText(r9)
            if (r1 <= 0) goto L_0x00fa
            k5.a r0 = r13.f11421h
            if (r0 != 0) goto L_0x00b9
            kotlin.jvm.internal.j.y(r8)
            r0 = r2
        L_0x00b9:
            com.coffeemeetsbagel.cmb_views.CmbTextView r0 = r0.f15666g
            r1 = 2131231283(0x7f080233, float:1.8078643E38)
            r0.setBackgroundResource(r1)
            k5.a r0 = r13.f11421h
            if (r0 != 0) goto L_0x00c9
            kotlin.jvm.internal.j.y(r8)
            r0 = r2
        L_0x00c9:
            com.coffeemeetsbagel.cmb_views.CmbTextView r0 = r0.f15666g
            k5.a r1 = r13.f11421h
            if (r1 != 0) goto L_0x00d3
            kotlin.jvm.internal.j.y(r8)
            r1 = r2
        L_0x00d3:
            androidx.constraintlayout.widget.ConstraintLayout r1 = r1.getRoot()
            android.content.Context r1 = r1.getContext()
            r7 = 2131100166(0x7f060206, float:1.7812706E38)
            int r1 = androidx.core.content.a.getColor(r1, r7)
            r0.setTextColor(r1)
            k5.a r0 = r13.f11421h
            if (r0 != 0) goto L_0x00ed
            kotlin.jvm.internal.j.y(r8)
            r0 = r2
        L_0x00ed:
            com.coffeemeetsbagel.cmb_views.CmbButton r0 = r0.f15661b
            r1 = 2131886199(0x7f120077, float:1.940697E38)
            java.lang.String r1 = r13.getString(r1)
            r0.setText(r1)
            goto L_0x014b
        L_0x00fa:
            k5.a r1 = r13.f11421h
            if (r1 != 0) goto L_0x0102
            kotlin.jvm.internal.j.y(r8)
            r1 = r2
        L_0x0102:
            com.coffeemeetsbagel.cmb_views.CmbTextView r1 = r1.f15666g
            r7 = 2131231286(0x7f080236, float:1.8078649E38)
            r1.setBackgroundResource(r7)
            k5.a r1 = r13.f11421h
            if (r1 != 0) goto L_0x0112
            kotlin.jvm.internal.j.y(r8)
            r1 = r2
        L_0x0112:
            com.coffeemeetsbagel.cmb_views.CmbTextView r1 = r1.f15666g
            k5.a r7 = r13.f11421h
            if (r7 != 0) goto L_0x011c
            kotlin.jvm.internal.j.y(r8)
            r7 = r2
        L_0x011c:
            androidx.constraintlayout.widget.ConstraintLayout r7 = r7.getRoot()
            android.content.Context r7 = r7.getContext()
            r9 = 2131099755(0x7f06006b, float:1.7811872E38)
            int r7 = androidx.core.content.a.getColor(r7, r9)
            r1.setTextColor(r7)
            k5.a r1 = r13.f11421h
            if (r1 != 0) goto L_0x0136
            kotlin.jvm.internal.j.y(r8)
            r1 = r2
        L_0x0136:
            com.coffeemeetsbagel.cmb_views.CmbButton r1 = r1.f15661b
            if (r0 == 0) goto L_0x0143
            int r0 = r0.getBeans()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0144
        L_0x0143:
            r0 = r2
        L_0x0144:
            java.lang.CharSequence r0 = r13.T0(r0)
            r1.setText(r0)
        L_0x014b:
            k5.a r0 = r13.f11421h
            if (r0 != 0) goto L_0x0153
            kotlin.jvm.internal.j.y(r8)
            r0 = r2
        L_0x0153:
            com.coffeemeetsbagel.cmb_views.CmbTextView r0 = r0.f15666g
            r1 = 8
            if (r3 == 0) goto L_0x015b
            r3 = r5
            goto L_0x015c
        L_0x015b:
            r3 = r1
        L_0x015c:
            r0.setVisibility(r3)
            k5.a r0 = r13.f11421h
            if (r0 != 0) goto L_0x0167
            kotlin.jvm.internal.j.y(r8)
            r0 = r2
        L_0x0167:
            com.coffeemeetsbagel.cmb_views.CmbButton r0 = r0.f15663d
            if (r6 == 0) goto L_0x016c
            goto L_0x016d
        L_0x016c:
            r5 = r1
        L_0x016d:
            r0.setVisibility(r5)
            k5.a r0 = r13.f11421h
            if (r0 != 0) goto L_0x0178
            kotlin.jvm.internal.j.y(r8)
            goto L_0x0179
        L_0x0178:
            r2 = r0
        L_0x0179:
            com.coffeemeetsbagel.cmb_views.CmbButton r0 = r2.f15661b
            r0.setEnabled(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.boost.BoostDialogFragment.l1():void");
    }

    public final a7.a S0() {
        a7.a aVar = this.f11416c;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }

    public final FirebaseContract.Analytics U0() {
        FirebaseContract.Analytics analytics = this.f11417d;
        if (analytics != null) {
            return analytics;
        }
        j.y("firebaseContract");
        return null;
    }

    public final com.coffeemeetsbagel.store.alc.a X0() {
        com.coffeemeetsbagel.store.alc.a aVar = this.f11420g;
        if (aVar != null) {
            return aVar;
        }
        j.y("purchaseAnalytics");
        return null;
    }

    public final BoostAnalytics Y0() {
        BoostAnalytics boostAnalytics = this.f11418e;
        if (boostAnalytics != null) {
            return boostAnalytics;
        }
        j.y("tracker");
        return null;
    }

    public final i Z0() {
        i iVar = this.f11419f;
        if (iVar != null) {
            return iVar;
        }
        j.y("viewModelFactory");
        return null;
    }

    public final void i1(com.coffeemeetsbagel.store.alc.a aVar) {
        j.g(aVar, "<set-?>");
        this.f11420g = aVar;
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        fa.a.f40771d.a(this.f11415b, "onActivityResult: request=" + i10 + " result=" + i11);
        super.onActivityResult(i10, i11, intent);
        if (i10 == 5400) {
            BoostViewModel boostViewModel = this.f11422j;
            if (boostViewModel == null) {
                j.y("viewModel");
                boostViewModel = null;
            }
            boostViewModel.C();
        }
        if (i10 == 435345) {
            s1 unused = j.d(m.a(this), (CoroutineContext) null, (CoroutineStart) null, new BoostDialogFragment$onActivityResult$1(this, (kotlin.coroutines.c<? super BoostDialogFragment$onActivityResult$1>) null), 3, (Object) null);
        }
    }

    public void onAttach(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        super.onAttach(context);
        fa.a.f40771d.a(this.f11415b, "onAttach()");
        Bakery.j().J1(this);
        i1(new com.coffeemeetsbagel.store.alc.a(S0(), U0()));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BoostViewModel boostViewModel = (BoostViewModel) new i0((l0) this, (i0.b) Z0()).a(BoostViewModel.class);
        this.f11422j = boostViewModel;
        if (boostViewModel == null) {
            j.y("viewModel");
            boostViewModel = null;
        }
        boostViewModel.x().i(this, new b(new BoostDialogFragment$onCreate$1(this)));
        BoostViewModel boostViewModel2 = this.f11422j;
        if (boostViewModel2 == null) {
            j.y("viewModel");
            boostViewModel2 = null;
        }
        boostViewModel2.r().i(this, new b(new BoostDialogFragment$onCreate$2(this)));
        BoostViewModel boostViewModel3 = this.f11422j;
        if (boostViewModel3 == null) {
            j.y("viewModel");
            boostViewModel3 = null;
        }
        boostViewModel3.p().i(this, new b(new BoostDialogFragment$onCreate$3(this)));
        BoostViewModel boostViewModel4 = this.f11422j;
        if (boostViewModel4 == null) {
            j.y("viewModel");
            boostViewModel4 = null;
        }
        boostViewModel4.m().i(this, new b(new BoostDialogFragment$onCreate$4(this)));
        s1 unused = j.d(m.a(this), (CoroutineContext) null, (CoroutineStart) null, new BoostDialogFragment$onCreate$5(this, (kotlin.coroutines.c<? super BoostDialogFragment$onCreate$5>) null), 3, (Object) null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.g(layoutInflater, "inflater");
        fa.a.f40771d.a(this.f11415b, "onCreateView()");
        k5.a c10 = k5.a.c(getLayoutInflater());
        j.f(c10, "inflate(layoutInflater)");
        this.f11421h = c10;
        k5.a aVar = null;
        if (c10 == null) {
            j.y("binding");
            c10 = null;
        }
        c10.f15663d.setOnClickListener(new b(this));
        k5.a aVar2 = this.f11421h;
        if (aVar2 == null) {
            j.y("binding");
            aVar2 = null;
        }
        aVar2.f15661b.setOnClickListener(new c(this));
        k5.a aVar3 = this.f11421h;
        if (aVar3 == null) {
            j.y("binding");
            aVar3 = null;
        }
        aVar3.f15662c.setOnClickListener(new d(this));
        k5.a aVar4 = this.f11421h;
        if (aVar4 == null) {
            j.y("binding");
        } else {
            aVar = aVar4;
        }
        ConstraintLayout b10 = aVar.getRoot();
        j.f(b10, "binding.root");
        return b10;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        j.g(dialogInterface, "dialog");
        fa.a.f40771d.a(this.f11415b, "onDismiss");
        super.onDismiss(dialogInterface);
        if (V0().isShowing()) {
            V0().hide();
        }
        if (W0().isShowing()) {
            W0().hide();
        }
        e1();
    }
}
