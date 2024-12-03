package com.coffeemeetsbagel.feature.chatlist;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import androidx.fragment.app.h;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.bagel_profile.BagelProfileComponentActivity;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.boost.BoostDialogFragment;
import com.coffeemeetsbagel.boost.g;
import com.coffeemeetsbagel.chat.details.ChatActivity;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.cmb_views.CmbLinearLayout;
import com.coffeemeetsbagel.cmb_views.CmbListView;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.feature.chatlist.BannerHolderUtil;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.dto.MatchContract;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.models.enums.PurchaseAttribution;
import com.coffeemeetsbagel.models.util.CollectionUtils;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.util.RequestCode;
import com.coffeemeetsbagel.view.CmbToolbar;
import com.coffeemeetsbagel.view.b;
import com.leanplum.internal.Clock;
import com.uber.autodispose.p;
import com.uber.autodispose.t;
import h5.i;
import j5.w;
import j5.x;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lc.n;
import qj.b0;
import z9.f;

public class g0 extends w implements f, a1, j {
    /* access modifiers changed from: private */
    public CmbTextView B;
    private FrameLayout C;
    private i D;
    /* access modifiers changed from: private */
    public com.coffeemeetsbagel.view.b E;
    /* access modifiers changed from: private */
    public final tj.a F = new tj.a();
    private tj.b G;

    /* renamed from: e  reason: collision with root package name */
    GetBagelUseCase f12924e;

    /* renamed from: f  reason: collision with root package name */
    GetBagelConnectionUseCase f12925f;

    /* renamed from: g  reason: collision with root package name */
    PurchaseManager f12926g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public c1 f12927h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public CmbListView f12928j;

    /* renamed from: k  reason: collision with root package name */
    private BannerHolder f12929k;

    /* renamed from: l  reason: collision with root package name */
    private final ArrayList<Bagel> f12930l = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final Set<Integer> f12931m = new HashSet();

    /* renamed from: n  reason: collision with root package name */
    private boolean f12932n;

    /* renamed from: p  reason: collision with root package name */
    private boolean f12933p;

    /* renamed from: q  reason: collision with root package name */
    private ImageView f12934q;

    /* renamed from: t  reason: collision with root package name */
    private TextView f12935t;

    /* renamed from: w  reason: collision with root package name */
    private TextView f12936w;

    /* renamed from: x  reason: collision with root package name */
    private View f12937x;

    /* renamed from: y  reason: collision with root package name */
    private ProgressBar f12938y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public CmbButton f12939z;

    class a implements AbsListView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f12940a;

        /* renamed from: b  reason: collision with root package name */
        private int f12941b;

        /* renamed from: c  reason: collision with root package name */
        private int f12942c;

        /* renamed from: d  reason: collision with root package name */
        private int f12943d;

        /* renamed from: e  reason: collision with root package name */
        private int f12944e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f12945f;

        a() {
        }

        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
            int i13;
            boolean z10;
            int i14;
            if (i12 != 0 && this.f12940a) {
                View childAt = absListView.getChildAt(0);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                int height = childAt.getHeight();
                int i15 = this.f12941b;
                if (i10 > i15) {
                    int i16 = this.f12943d + this.f12942c;
                    this.f12943d = i16;
                    i13 = top - i16;
                } else {
                    if (i10 < i15) {
                        i14 = this.f12944e - this.f12942c;
                        this.f12944e = i14;
                    } else {
                        i14 = this.f12944e;
                    }
                    i13 = bottom - i14;
                }
                this.f12943d = top;
                this.f12944e = bottom;
                this.f12942c = height;
                this.f12941b = i10;
                if (i10 + i11 >= i12 - i11) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.f12945f = z10;
                int i17 = i13 * -1;
                g0.this.f12928j.dispatchNestedPreScroll(0, i17, (int[]) null, (int[]) null);
                g0.this.f12928j.dispatchNestedScroll(0, i17, 0, 0, (int[]) null);
            }
        }

        public void onScrollStateChanged(AbsListView absListView, int i10) {
            if (absListView.getCount() != 0) {
                if (i10 == 0) {
                    this.f12940a = false;
                } else if (i10 == 1 || i10 == 2) {
                    View childAt = absListView.getChildAt(0);
                    this.f12941b = absListView.getFirstVisiblePosition();
                    this.f12943d = childAt.getTop();
                    this.f12944e = childAt.getBottom();
                    this.f12942c = childAt.getHeight();
                    this.f12940a = true;
                }
                if (this.f12945f) {
                    g0.this.Y1();
                }
            }
        }
    }

    class b implements g {
        b() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(View view) {
            g0.this.e2();
        }

        public void a() {
        }

        public void b() {
        }

        public void onSuccess() {
            h activity = g0.this.getActivity();
            if (activity instanceof ActivityMain) {
                ((ActivityMain) activity).U4(R.string.youre_being_boosted, 6000);
            }
            g0.this.f12939z.setText(R.string.explore_more_in_discover);
            g0.this.f12939z.setOnClickListener(new h0(this));
            lc.c.j(g0.this.f12939z, 0);
            g0.this.B.setOnClickListener((View.OnClickListener) null);
            lc.c.j(g0.this.B, 8);
        }
    }

    class c implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CmbToolbar f12948a;

        c(CmbToolbar cmbToolbar) {
            this.f12948a = cmbToolbar;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(com.coffeemeetsbagel.view.b bVar, x xVar) throws Exception {
            g0.this.z1();
            bVar.a();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f() {
            g0.this.f12927h.notifyDataSetChanged();
        }

        public void a(com.coffeemeetsbagel.view.b bVar) {
            g0.this.E = null;
            g0.this.f12931m.clear();
            g0.this.f12927h.k(false);
            g0.this.requireActivity().runOnUiThread(new j0(this));
        }

        public boolean b(com.coffeemeetsbagel.view.b bVar) {
            CmbLinearLayout cmbLinearLayout = (CmbLinearLayout) g0.this.requireActivity().getLayoutInflater().inflate(R.layout.delete_menu_item, this.f12948a, false);
            g0.this.F.a(cmbLinearLayout.a().a0(sj.a.a()).c(new i0(this, bVar)));
            n.a(g0.this.requireContext(), ((CmbImageView) cmbLinearLayout.findViewById(R.id.delete_menu_image)).getBackground(), R.color.main_color);
            this.f12948a.C(cmbLinearLayout);
            g0.this.f12927h.k(true);
            g0.this.f12927h.o(g0.this.f12931m);
            g0.this.f12927h.notifyDataSetChanged();
            return true;
        }
    }

    static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12950a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.coffeemeetsbagel.models.enums.EventType[] r0 = com.coffeemeetsbagel.models.enums.EventType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12950a = r0
                com.coffeemeetsbagel.models.enums.EventType r1 = com.coffeemeetsbagel.models.enums.EventType.CONNECTION_ADDED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12950a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.models.enums.EventType r1 = com.coffeemeetsbagel.models.enums.EventType.CONNECTION_DETAILS_UPDATED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f12950a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.coffeemeetsbagel.models.enums.EventType r1 = com.coffeemeetsbagel.models.enums.EventType.CHAT_EXTENDED_PUSH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f12950a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.coffeemeetsbagel.models.enums.EventType r1 = com.coffeemeetsbagel.models.enums.EventType.REMOTE_CONFIG_UPDATED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.feature.chatlist.g0.d.<clinit>():void");
        }
    }

    private void A1(int i10) {
        X1(i10, !this.f12931m.contains(Integer.valueOf(i10)));
        if (this.f12931m.size() == 0) {
            this.E.a();
        } else {
            this.E.d(String.valueOf(this.f12931m.size()));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean B1(Bagel bagel) throws Exception {
        return bagel.getCoupleId() != null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C1(Bagel bagel) throws Exception {
        n2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ b0 D1(Integer num) throws Exception {
        MatchContract g10 = this.f12927h.g(num.intValue());
        m2(num.intValue(), "profile detail");
        if (g10 != null) {
            return this.f12924e.e(g10.getId());
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E1(Optional optional) throws Exception {
        if (this.E != null || !optional.isPresent()) {
            fa.a.g("ChatListFragment", "CMB Action Mode null or failed to get bagel - ", new IllegalStateException("CMB Action Mode null or failed to get bagel - "));
            return;
        }
        Intent intent = new Intent(getActivity(), BagelProfileComponentActivity.class);
        intent.putExtra(Extra.BAGEL, (Serializable) optional.get());
        intent.putExtra("source", ModelDeeplinkData.VALUE_PAGE_CHAT);
        lc.a.d(requireActivity(), intent, RequestCode.GENERIC);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G1(EventType eventType) {
        if (isAdded()) {
            int i10 = d.f12950a[eventType.ordinal()];
            if (i10 == 1 || i10 == 2 || i10 == 3) {
                a2();
            } else if (i10 == 4 && getActivity() != null) {
                b2();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H1() {
        this.f12927h.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I1(boolean z10) {
        if (z10 && isAdded()) {
            a2();
        }
        this.f12932n = false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J1(MatchContract matchContract, Optional optional) throws Exception {
        if (optional.isPresent()) {
            lc.a.d(requireActivity(), ChatActivity.K1(requireActivity(), (Bagel) optional.get()), RequestCode.GENERIC);
            return;
        }
        String str = "failed to read bagel from db - " + matchContract.getId();
        fa.a.g("ChatListFragment", str, new IllegalStateException(str));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L1(x xVar) throws Exception {
        n2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M1(x xVar) throws Exception {
        n2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N1(AdapterView adapterView, View view, int i10, long j10) {
        if (this.f12927h.j(i10)) {
            f2();
        } else if (!this.f12927h.h(i10)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Clicked on a non-conversation item: ");
            sb2.append(i10);
        } else if (this.E != null) {
            A1(i10);
        } else {
            m2(i10, "chat_detail");
            Z1(i10);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean O1(AdapterView adapterView, View view, int i10, long j10) {
        CmbToolbar T0 = ((j5.h) requireActivity()).T0();
        if (T0 == null) {
            return true;
        }
        i2(i10, T0);
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P1(View view) {
        e2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q1(View view) {
        e2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R1(View view) {
        BoostDialogFragment.f11414q.a(new b()).show(getActivity().getSupportFragmentManager(), "BoostDialogFragment");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S1(List list) throws Exception {
        if (isAdded()) {
            k2(list);
            this.f12927h.q(list);
            this.f12927h.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U1(boolean z10) {
        if (z10 && isAdded()) {
            a2();
        }
        this.f12933p = false;
    }

    private void X1(int i10, boolean z10) {
        int headerViewsCount = i10 - this.f12928j.getHeaderViewsCount();
        if (this.f12927h.g(i10) != null) {
            if (!z10 || this.f12931m.contains(Integer.valueOf(headerViewsCount))) {
                this.f12931m.remove(Integer.valueOf(headerViewsCount));
            } else {
                this.f12931m.add(Integer.valueOf(headerViewsCount));
            }
            requireActivity().runOnUiThread(new x(this));
        }
    }

    /* access modifiers changed from: private */
    public void Y1() {
        if (!this.f12932n) {
            this.f12932n = true;
            E0().t(false, true, 2, new d0(this));
        }
    }

    private void Z1(int i10) {
        MatchContract g10 = this.f12927h.g(i10);
        if (g10 != null) {
            ((t) this.f12924e.e(g10.getId()).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new u(this, g10), new v(g10));
        }
    }

    private void a2() {
        this.D.x();
    }

    private void b2() {
        l2(new c0(this), Bakery.w().M().r("feedback_banner_first_action_taken"));
    }

    @SuppressLint({"AutoDispose"})
    private void c2() {
        this.F.a(E0().G().a0(sj.a.a()).c(new e0(this)));
        this.F.a(J0().p().a0(sj.a.a()).c(new f0(this)));
    }

    /* access modifiers changed from: private */
    public void d2() {
        BannerHolder bannerHolder = this.f12929k;
        if (bannerHolder != null) {
            bannerHolder.setVisibility(8);
            this.C.removeView(this.f12929k);
            this.f12929k = null;
        }
    }

    /* access modifiers changed from: private */
    public void e2() {
        if (getActivity() instanceof ActivityMain) {
            ((ActivityMain) getActivity()).X3();
            return;
        }
        Intent intent = new Intent(getActivity(), ActivityMain.class);
        intent.putExtra("deeplink_page_to_redirect_to", ModelDeeplinkData.VALUE_PAGE_DISCOVER);
        intent.putExtra(Extra.IS_FROM_PUSH, false);
        startActivity(intent);
    }

    private void f2() {
        if (getActivity() instanceof ActivityMain) {
            ((ActivityMain) getActivity()).D2();
            return;
        }
        Intent intent = new Intent(getActivity(), ActivityMain.class);
        intent.putExtra("deeplink_page_to_redirect_to", ModelDeeplinkData.VALUE_LIKES_YOU);
        intent.putExtra(Extra.IS_FROM_PUSH, false);
        startActivity(intent);
    }

    private void h2() {
        this.f12928j.setAdapter(this.f12927h);
        this.f12928j.setOnItemClickListener(new n(this));
        this.f12928j.setOnItemLongClickListener(new o(this));
    }

    private void i2(int i10, CmbToolbar cmbToolbar) {
        if (this.E == null) {
            this.E = cmbToolbar.f0(new c(cmbToolbar));
        }
        X1(i10, !this.f12931m.contains(Integer.valueOf(i10)));
        if (this.f12931m.size() == 0) {
            this.E.a();
        } else {
            this.E.d(String.valueOf(this.f12931m.size()));
        }
    }

    private boolean j2() {
        boolean z10;
        if (Bakery.w().M().p("has_acted_on_feedback_banner") || CollectionUtils.isEmpty((List) this.f12930l)) {
            return false;
        }
        if (Bakery.w().M().p("feedback_prompt_started")) {
            return true;
        }
        int l10 = Bakery.w().M().l("total_feedback_prompts");
        long t10 = Bakery.w().M().t("last_feedback_prompt");
        long currentTimeMillis = System.currentTimeMillis();
        if (l10 >= 3 || currentTimeMillis - t10 <= Clock.MONTH_MILLIS) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (this.f12930l.size() > 1) {
            return z10;
        }
        if (!z10 || this.f12930l.get(0).getConnectionDetails().getUnreadMessageCount() != 0 || DateUtils.getRemainingTime(this.f12930l.get(0).getDecouplingDate(), System.currentTimeMillis()) <= 0) {
            return false;
        }
        return true;
    }

    private void k2(List<ConnectionHolder> list) {
        boolean z10;
        this.f12938y.setVisibility(8);
        if (list == null || list.size() != 0) {
            lc.c.j(this.f12934q, 8);
            lc.c.j(this.f12935t, 8);
            lc.c.j(this.f12936w, 8);
            lc.c.j(this.f12939z, 8);
            lc.c.j(this.B, 8);
            lc.c.j(this.f12928j, 0);
            FrameLayout frameLayout = this.C;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
        } else {
            lc.c.j(this.f12934q, 0);
            lc.c.j(this.f12935t, 0);
            lc.c.j(this.f12936w, 0);
            lc.c.j(this.f12939z, 0);
            if (this.f12926g.getPrice(PurchaseType.BOOST) != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                this.f12939z.setText(R.string.explore_more_in_discover);
                this.f12939z.setOnClickListener(new r(this));
                lc.c.j(this.f12939z, 0);
                this.B.setOnClickListener((View.OnClickListener) null);
                lc.c.j(this.B, 8);
            } else {
                lc.c.j(this.B, 0);
                this.B.setText(R.string.explore_more_in_discover);
                this.B.setOnClickListener(new s(this));
                this.f12939z.setText(R.string.boost_for_more_views);
                this.f12939z.setOnClickListener(new t(this));
            }
            lc.c.j(this.f12928j, 8);
            FrameLayout frameLayout2 = this.C;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
        }
        if (this.f12929k == null) {
            b2();
        }
    }

    private void l2(BannerHolderUtil.b bVar, String str) {
        BannerHolder bannerHolder;
        boolean j22 = j2();
        if (j22 && this.f12929k == null) {
            BannerHolder bannerHolder2 = (BannerHolder) LayoutInflater.from(requireContext()).inflate(R.layout.banner_holder_v2, this.C, false);
            this.f12929k = bannerHolder2;
            if (bannerHolder2 != null) {
                bannerHolder2.setBannerDismissListener(bVar);
                this.f12929k.setFirebaseAnalytics(H0());
                this.C.addView(this.f12929k);
                if (str != null && str.equals("enjoying")) {
                    this.f12929k.setBannerPromptToAskForRate(this);
                } else if (str == null || !str.equals("not_enjoying")) {
                    this.f12929k.setBannerPromptToFirstQuestion(this);
                } else {
                    this.f12929k.setBannerPromptToAskForFeedback(this);
                }
            }
        } else if (!j22 && (bannerHolder = this.f12929k) != null) {
            bannerHolder.I();
        }
    }

    private void m2(int i10, String str) {
        PurchaseAttribution purchaseAttribution;
        HashMap hashMap = new HashMap();
        hashMap.put("is_expired", String.valueOf(this.f12927h.i(i10)));
        hashMap.put("is_date", "false");
        hashMap.put("total_item_count", String.valueOf(this.f12927h.t()));
        hashMap.put("item_index", String.valueOf(i10));
        hashMap.put("destination", str);
        MatchContract g10 = this.f12927h.g(i10);
        if (!(g10 == null || (purchaseAttribution = g10.getPurchaseAttribution()) == null)) {
            hashMap.put("purchase_attribution", purchaseAttribution.name());
        }
        C0().trackEvent("Chat List - Chat Tapped", hashMap);
    }

    private void n2() {
        tj.b bVar = this.G;
        if (bVar != null && !bVar.c()) {
            this.G.dispose();
        }
        this.G = ((t) this.f12925f.k().E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new p(this), new q());
    }

    private void o2() {
        if (!this.f12933p) {
            this.f12933p = true;
            E0().E(false, true, new m(this));
        }
    }

    /* access modifiers changed from: private */
    public void z1() {
        for (Integer intValue : this.f12931m) {
            MatchContract g10 = this.f12927h.g(intValue.intValue());
            if (g10 != null) {
                Bagel fromMatch = Bagel.fromMatch(g10);
                F0().a(fromMatch);
                this.D.E(fromMatch);
            }
        }
    }

    public void F(List<Bagel> list) {
        this.f12930l.clear();
        this.f12930l.addAll(list);
    }

    public void Q() {
        fa.a.f("ChatListFragment", "#ChatListFragment chat delete failed to post.");
        S0(this.f12937x, R.string.error_deleting_chat);
    }

    public void Q0() {
        CmbListView cmbListView = this.f12928j;
        if (cmbListView != null) {
            cmbListView.smoothScrollToPosition(0);
        }
    }

    public boolean V1() {
        com.coffeemeetsbagel.view.b bVar = this.E;
        if (bVar == null) {
            return false;
        }
        bVar.a();
        return true;
    }

    public void W1() {
        n2();
        i iVar = this.D;
        if (iVar != null) {
            iVar.f();
        }
    }

    public void a0() {
        a2();
    }

    /* renamed from: g2 */
    public void K(i iVar) {
        this.D = iVar;
    }

    public void n0(EventType eventType, Bundle bundle) {
        new Handler(Looper.getMainLooper()).post(new b0(this, eventType));
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i10 == 1610) {
            if (i11 == -1) {
                BannerHolderUtil.e();
                BannerHolder bannerHolder = this.f12929k;
                if (bannerHolder != null) {
                    bannerHolder.I();
                }
            } else {
                BannerHolderUtil.d((String) null);
                BannerHolder bannerHolder2 = this.f12929k;
                if (bannerHolder2 != null) {
                    bannerHolder2.I();
                }
            }
        }
        if (i10 == 435345 && i11 == -1) {
            n2();
        }
        super.onActivityResult(i10, i11, intent);
    }

    public void onCreate(Bundle bundle) {
        Bakery.j().v1(this);
        super.onCreate(bundle);
        this.f12927h = new c1(requireContext(), 0);
        n2();
        ((p) Bakery.w().i().a().B(new l()).s().m0(dk.a.c()).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new w(this));
        ((com.uber.autodispose.n) this.f12927h.b().S(new y(this)).o0(dk.a.c()).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new z(this), new a0());
        Bakery.w().A().z(this);
        i.a(this, EventType.CONNECTION_ADDED, EventType.CONNECTION_DETAILS_UPDATED, EventType.CHAT_EXTENDED_PUSH, EventType.REMOTE_CONFIG_UPDATED);
        new n0(this, E0(), new z0(E0()), C0()).start();
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_my_connections_dls, viewGroup, false);
        this.f12937x = inflate;
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        Bakery.w().A().P(this);
        i.d(this, EventType.CONNECTION_ADDED, EventType.CONNECTION_DETAILS_UPDATED, EventType.CHAT_EXTENDED_PUSH, EventType.REMOTE_CONFIG_UPDATED);
        this.D.stop();
        this.F.dispose();
        this.G.dispose();
    }

    public void onResume() {
        super.onResume();
        b2();
        this.D.a();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
        c2();
    }

    public void onStop() {
        super.onStop();
        this.F.e();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f12934q = (ImageView) view.findViewById(R.id.image_no_connections);
        this.f12935t = (TextView) view.findViewById(R.id.text_no_connections_title);
        this.f12936w = (TextView) view.findViewById(R.id.text_no_connections_body);
        this.f12938y = (ProgressBar) view.findViewById(R.id.spinner);
        this.C = (FrameLayout) view.findViewById(R.id.feedback_banner_holder);
        this.f12939z = (CmbButton) view.findViewById(R.id.main_button);
        this.B = (CmbTextView) view.findViewById(R.id.secondary_button);
        this.f12935t.setText(t9.a.chatListEmptyStateTitle);
        this.f12936w.setText(t9.a.chatListEmptyStateMessage);
        CmbListView cmbListView = (CmbListView) view.findViewById(R.id.listView_connections);
        this.f12928j = cmbListView;
        n0.G0(cmbListView, true);
        h2();
        this.f12928j.setOnScrollListener(new a());
        b2();
        Y1();
        o2();
        a2();
    }

    public void u0(Bagel bagel) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("connection=");
        sb2.append(bagel);
        n2();
    }
}
