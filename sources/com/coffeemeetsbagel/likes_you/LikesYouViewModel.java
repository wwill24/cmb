package com.coffeemeetsbagel.likes_you;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.t;
import com.coffeemeetsbagel.domain.repository.LikesYouMatchRepository;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.likes_you.presentation.EmptyStateAction;
import com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem;
import com.coffeemeetsbagel.likes_you.presentation.MainGroups;
import com.coffeemeetsbagel.likesyou.db.LikesYouGroupWithCards;
import com.coffeemeetsbagel.match.MatchIdAttribution;
import com.coffeemeetsbagel.models.entities.CapabilityType;
import com.coffeemeetsbagel.models.entities.LikesYouGroupEntity;
import com.coffeemeetsbagel.models.enums.PurchaseAttribution;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import fa.a;
import io.reactivex.BackpressureStrategy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.p;
import qj.b0;
import qj.h;
import qj.q;
import qj.w;

public final class LikesYouViewModel extends f0 {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final a7.a f34123d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final a6.a f34124e;

    /* renamed from: f  reason: collision with root package name */
    private final l5.a f34125f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final bb.a f34126g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final LikesYouMatchRepository f34127h;

    /* renamed from: i  reason: collision with root package name */
    private final FeatureFlagRepository f34128i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final t<List<s>> f34129j;

    /* renamed from: k  reason: collision with root package name */
    private final LiveData<List<s>> f34130k;

    /* renamed from: l  reason: collision with root package name */
    private final t<String> f34131l;

    /* renamed from: m  reason: collision with root package name */
    private final LiveData<String> f34132m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final t<a> f34133n;

    /* renamed from: o  reason: collision with root package name */
    private final LiveData<a> f34134o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final t<b> f34135p;

    /* renamed from: q  reason: collision with root package name */
    private final LiveData<b> f34136q;

    /* renamed from: r  reason: collision with root package name */
    private final com.jakewharton.rxrelay2.b<Triple<String, String, Integer>> f34137r;

    /* renamed from: s  reason: collision with root package name */
    private final io.reactivex.subjects.a<Boolean> f34138s;

    /* renamed from: t  reason: collision with root package name */
    private final q<Boolean> f34139t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public final String f34140u = "LikesYouViewModel";

    /* renamed from: v  reason: collision with root package name */
    private final tj.a f34141v;

    /* renamed from: w  reason: collision with root package name */
    private final tj.a f34142w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public boolean f34143x;

    public static abstract class a {

        /* renamed from: com.coffeemeetsbagel.likes_you.LikesYouViewModel$a$a  reason: collision with other inner class name */
        public static final class C0406a extends a {

            /* renamed from: a  reason: collision with root package name */
            private final PurchaseSource f34144a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0406a(PurchaseSource purchaseSource) {
                super((DefaultConstructorMarker) null);
                j.g(purchaseSource, "purchaseSource");
                this.f34144a = purchaseSource;
            }

            public final PurchaseSource a() {
                return this.f34144a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0406a) && j.b(this.f34144a, ((C0406a) obj).f34144a);
            }

            public int hashCode() {
                return this.f34144a.hashCode();
            }

            public String toString() {
                PurchaseSource purchaseSource = this.f34144a;
                return "EmptyStateUpsell(purchaseSource=" + purchaseSource + ")";
            }
        }

        public static final class b extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final b f34145a = new b();

            private b() {
                super((DefaultConstructorMarker) null);
            }
        }

        public static final class c extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final c f34146a = new c();

            private c() {
                super((DefaultConstructorMarker) null);
            }
        }

        public static final class d extends a {

            /* renamed from: a  reason: collision with root package name */
            private final String f34147a;

            /* renamed from: b  reason: collision with root package name */
            private final ArrayList<MatchIdAttribution> f34148b;

            /* renamed from: c  reason: collision with root package name */
            private final String f34149c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(String str, ArrayList<MatchIdAttribution> arrayList, String str2) {
                super((DefaultConstructorMarker) null);
                j.g(str, "groupId");
                j.g(arrayList, "matchAttributionMap");
                j.g(str2, "matchId");
                this.f34147a = str;
                this.f34148b = arrayList;
                this.f34149c = str2;
            }

            public final String a() {
                return this.f34147a;
            }

            public final String b() {
                return this.f34149c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return false;
                }
                d dVar = (d) obj;
                return j.b(this.f34147a, dVar.f34147a) && j.b(this.f34148b, dVar.f34148b) && j.b(this.f34149c, dVar.f34149c);
            }

            public int hashCode() {
                return (((this.f34147a.hashCode() * 31) + this.f34148b.hashCode()) * 31) + this.f34149c.hashCode();
            }

            public String toString() {
                String str = this.f34147a;
                ArrayList<MatchIdAttribution> arrayList = this.f34148b;
                String str2 = this.f34149c;
                return "GoToMatchView(groupId=" + str + ", matchAttributionMap=" + arrayList + ", matchId=" + str2 + ")";
            }
        }

        public static final class e extends a {

            /* renamed from: a  reason: collision with root package name */
            private final boolean f34150a;

            /* renamed from: b  reason: collision with root package name */
            private final boolean f34151b;

            /* renamed from: c  reason: collision with root package name */
            private final String f34152c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public e(boolean z10, boolean z11, String str) {
                super((DefaultConstructorMarker) null);
                j.g(str, "groupName");
                this.f34150a = z10;
                this.f34151b = z11;
                this.f34152c = str;
            }

            public final String a() {
                return this.f34152c;
            }

            public final boolean b() {
                return this.f34150a;
            }

            public final boolean c() {
                return this.f34151b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof e)) {
                    return false;
                }
                e eVar = (e) obj;
                return this.f34150a == eVar.f34150a && this.f34151b == eVar.f34151b && j.b(this.f34152c, eVar.f34152c);
            }

            public int hashCode() {
                boolean z10 = this.f34150a;
                boolean z11 = true;
                if (z10) {
                    z10 = true;
                }
                int i10 = (z10 ? 1 : 0) * true;
                boolean z12 = this.f34151b;
                if (!z12) {
                    z11 = z12;
                }
                return ((i10 + (z11 ? 1 : 0)) * 31) + this.f34152c.hashCode();
            }

            public String toString() {
                boolean z10 = this.f34150a;
                boolean z11 = this.f34151b;
                String str = this.f34152c;
                return "GroupUpsell(seenOnce=" + z10 + ", seenTwice=" + z11 + ", groupName=" + str + ")";
            }
        }

        public static final class f extends a {

            /* renamed from: a  reason: collision with root package name */
            private final PurchaseSource f34153a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public f(PurchaseSource purchaseSource) {
                super((DefaultConstructorMarker) null);
                j.g(purchaseSource, "purchaseSource");
                this.f34153a = purchaseSource;
            }

            public final PurchaseSource a() {
                return this.f34153a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof f) && j.b(this.f34153a, ((f) obj).f34153a);
            }

            public int hashCode() {
                return this.f34153a.hashCode();
            }

            public String toString() {
                PurchaseSource purchaseSource = this.f34153a;
                return "PaidCardUpsell(purchaseSource=" + purchaseSource + ")";
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            private final g f34154a;

            /* renamed from: b  reason: collision with root package name */
            private final int f34155b;

            /* renamed from: c  reason: collision with root package name */
            private final int f34156c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(g gVar, int i10, int i11) {
                super((DefaultConstructorMarker) null);
                j.g(gVar, "emptyState");
                this.f34154a = gVar;
                this.f34155b = i10;
                this.f34156c = i11;
            }

            public final g a() {
                return this.f34154a;
            }

            public final int b() {
                return this.f34155b;
            }

            public final int c() {
                return this.f34156c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return j.b(this.f34154a, aVar.f34154a) && this.f34155b == aVar.f34155b && this.f34156c == aVar.f34156c;
            }

            public int hashCode() {
                return (((this.f34154a.hashCode() * 31) + Integer.hashCode(this.f34155b)) * 31) + Integer.hashCode(this.f34156c);
            }

            public String toString() {
                g gVar = this.f34154a;
                int i10 = this.f34155b;
                int i11 = this.f34156c;
                return "Empty(emptyState=" + gVar + ", fallbackImage=" + i10 + ", selectedTab=" + i11 + ")";
            }
        }

        /* renamed from: com.coffeemeetsbagel.likes_you.LikesYouViewModel$b$b  reason: collision with other inner class name */
        public static final class C0407b extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final C0407b f34157a = new C0407b();

            private C0407b() {
                super((DefaultConstructorMarker) null);
            }
        }

        public static final class c extends b {

            /* renamed from: a  reason: collision with root package name */
            private final boolean f34158a;

            /* renamed from: b  reason: collision with root package name */
            private final List<LikesYouGridUiItem> f34159b;

            /* renamed from: c  reason: collision with root package name */
            private final int f34160c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(boolean z10, List<? extends LikesYouGridUiItem> list, int i10) {
                super((DefaultConstructorMarker) null);
                j.g(list, "matches");
                this.f34158a = z10;
                this.f34159b = list;
                this.f34160c = i10;
            }

            public final boolean a() {
                return this.f34158a;
            }

            public final List<LikesYouGridUiItem> b() {
                return this.f34159b;
            }

            public final int c() {
                return this.f34160c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                return this.f34158a == cVar.f34158a && j.b(this.f34159b, cVar.f34159b) && this.f34160c == cVar.f34160c;
            }

            public int hashCode() {
                boolean z10 = this.f34158a;
                if (z10) {
                    z10 = true;
                }
                return ((((z10 ? 1 : 0) * true) + this.f34159b.hashCode()) * 31) + Integer.hashCode(this.f34160c);
            }

            public String toString() {
                boolean z10 = this.f34158a;
                List<LikesYouGridUiItem> list = this.f34159b;
                int i10 = this.f34160c;
                return "Success(hasLikesYouCapability=" + z10 + ", matches=" + list + ", selectedTab=" + i10 + ")";
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34161a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.coffeemeetsbagel.likes_you.presentation.EmptyStateAction[] r0 = com.coffeemeetsbagel.likes_you.presentation.EmptyStateAction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.likes_you.presentation.EmptyStateAction r1 = com.coffeemeetsbagel.likes_you.presentation.EmptyStateAction.DISCOVER     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.likes_you.presentation.EmptyStateAction r1 = com.coffeemeetsbagel.likes_you.presentation.EmptyStateAction.PREFERENCES     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.likes_you.presentation.EmptyStateAction r1 = com.coffeemeetsbagel.likes_you.presentation.EmptyStateAction.UPSELL     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f34161a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.likes_you.LikesYouViewModel.c.<clinit>():void");
        }
    }

    public LikesYouViewModel(a7.a aVar, a6.a aVar2, l5.a aVar3, bb.a aVar4, LikesYouMatchRepository likesYouMatchRepository, FeatureFlagRepository featureFlagRepository) {
        j.g(aVar, "analyticsManager");
        j.g(aVar2, "coachmarkManager");
        j.g(aVar3, "capabilityUseCase");
        j.g(aVar4, "stringProvider");
        j.g(likesYouMatchRepository, "repository");
        j.g(featureFlagRepository, "featureManager");
        this.f34123d = aVar;
        this.f34124e = aVar2;
        this.f34125f = aVar3;
        this.f34126g = aVar4;
        this.f34127h = likesYouMatchRepository;
        this.f34128i = featureFlagRepository;
        t<List<s>> tVar = new t<>();
        this.f34129j = tVar;
        this.f34130k = tVar;
        t<String> tVar2 = new t<>();
        this.f34131l = tVar2;
        this.f34132m = tVar2;
        t<a> tVar3 = new t<>();
        this.f34133n = tVar3;
        this.f34134o = tVar3;
        t<b> tVar4 = new t<>();
        this.f34135p = tVar4;
        this.f34136q = tVar4;
        MainGroups mainGroups = MainGroups.ALL;
        com.jakewharton.rxrelay2.b<Triple<String, String, Integer>> D0 = com.jakewharton.rxrelay2.b.D0(new Triple(mainGroups.b(), "", 0));
        j.f(D0, "createDefault(Triple(MainGroups.ALL.key, \"\", 0))");
        this.f34137r = D0;
        io.reactivex.subjects.a<Boolean> D02 = io.reactivex.subjects.a.D0(Boolean.FALSE);
        j.f(D02, "createDefault(false)");
        this.f34138s = D02;
        this.f34139t = D02.v0(BackpressureStrategy.BUFFER).t0();
        tj.a aVar5 = new tj.a();
        this.f34141v = aVar5;
        this.f34142w = new tj.a();
        aVar5.a(likesYouMatchRepository.M().a0(sj.a.a()).b(new i0(new Function1<List<? extends s>, Unit>(this) {
            final /* synthetic */ LikesYouViewModel this$0;

            /* renamed from: com.coffeemeetsbagel.likes_you.LikesYouViewModel$1$a */
            public static final class a<T> implements Comparator {
                public final int compare(T t10, T t11) {
                    return b.a(Integer.valueOf(((s) t10).e()), Integer.valueOf(((s) t11).e()));
                }
            }

            {
                this.this$0 = r1;
            }

            public final void a(List<s> list) {
                j.f(list, "tabsList");
                if (!list.isEmpty()) {
                    this.this$0.f34129j.o(CollectionsKt___CollectionsKt.q0(list, new a()));
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((List) obj);
                return Unit.f32013a;
            }
        }), new j0(new Function1<Throwable, Unit>(this) {
            final /* synthetic */ LikesYouViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void a(Throwable th2) {
                a.C0491a aVar = fa.a.f40771d;
                String I = this.this$0.f34140u;
                j.f(th2, "throwable");
                aVar.c(I, "Problem getting groups", th2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return Unit.f32013a;
            }
        })));
        aVar5.a(D0.c(new u(new Function1<Triple<? extends String, ? extends String, ? extends Integer>, Unit>(this) {
            final /* synthetic */ LikesYouViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void a(Triple<String, String, Integer> triple) {
                this.this$0.P(triple.a(), triple.b(), triple.c().intValue());
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Triple) obj);
                return Unit.f32013a;
            }
        })));
        aVar5.a(likesYouMatchRepository.B(mainGroups.b()).a0(sj.a.a()).c(new v(new Function1<Pair<? extends Integer, ? extends Integer>, Unit>(this) {
            final /* synthetic */ LikesYouViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void a(Pair<Integer, Integer> pair) {
                this.this$0.v0(pair.c().intValue(), pair.d().intValue());
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Pair) obj);
                return Unit.f32013a;
            }
        })));
    }

    /* access modifiers changed from: private */
    public final void P(String str, String str2, int i10) {
        a.C0491a aVar = fa.a.f40771d;
        String str3 = this.f34140u;
        aVar.a(str3, "fetchAndRenderLikesYouCards - group " + str);
        this.f34142w.e();
        long currentTimeMillis = System.currentTimeMillis();
        ck.a aVar2 = ck.a.f24943a;
        h<R> Y = this.f34127h.E(str).J(new w(LikesYouViewModel$fetchAndRenderLikesYouCards$disposable$1.f34162a)).Y(new x(LikesYouViewModel$fetchAndRenderLikesYouCards$disposable$2.f34163a));
        j.f(Y, "repository.getGroupWithC…resent }.map { it.get() }");
        h<Boolean> v10 = this.f34125f.a(CapabilityType.SEE_ALL_LIKES_YOU).v();
        j.f(v10, "capabilityUseCase.invoke…U).distinctUntilChanged()");
        this.f34142w.a(aVar2.a(Y, v10).D(new y(new LikesYouViewModel$fetchAndRenderLikesYouCards$disposable$3(this))).a0(sj.a.a()).b(new z(new LikesYouViewModel$fetchAndRenderLikesYouCards$disposable$4(currentTimeMillis, this, str, str2, i10)), new a0(new LikesYouViewModel$fetchAndRenderLikesYouCards$disposable$5(this))));
    }

    /* access modifiers changed from: private */
    public static final boolean Q(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final LikesYouGroupWithCards R(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (LikesYouGroupWithCards) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void S(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void T(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void U(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void f0(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void g0(String str, String str2, int i10) {
        this.f34141v.a(this.f34125f.a(CapabilityType.SEE_ALL_LIKES_YOU).L().E(sj.a.a()).c(new b0(new LikesYouViewModel$onFilteredGroupTabSelected$1(this, str, str2, i10))));
    }

    /* access modifiers changed from: private */
    public static final void h0(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void j0(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void k0(g gVar, boolean z10, String str, int i10) {
        boolean z11;
        String e10 = gVar.e();
        boolean z12 = true;
        if (e10 == null || e10.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            String c10 = gVar.c();
            if (!(c10 == null || c10.length() == 0)) {
                z12 = false;
            }
            if (!z12) {
                this.f34135p.o(new b.a(gVar, q0.ic_likes_you_circle_check, i10));
                return;
            }
        }
        if (!z10) {
            this.f34142w.a(this.f34127h.N(MainGroups.ALL.b()).E(sj.a.a()).c(new t(new LikesYouViewModel$setEmptyState$emptyStateDisposable$1(this, i10))));
        } else if (j.b(str, MainGroups.ALL.b())) {
            this.f34135p.o(new b.a(new g(EmptyStateAction.DISCOVER.b(), this.f34126g.a(t0.ly_check_discover, new Object[0]), this.f34126g.a(t0.youre_all_caught_up_subscribed_description, new Object[0]), (String) null, this.f34126g.a(t0.youre_all_caught_up, new Object[0]), 8, (DefaultConstructorMarker) null), q0.ic_likes_you_circle_check, i10));
        } else if (j.b(str, MainGroups.MY_TYPE.b())) {
            this.f34135p.o(new b.a(new g(EmptyStateAction.PREFERENCES.b(), this.f34126g.a(t0.likes_you_edit_prefs_card_cta, new Object[0]), this.f34126g.a(t0.likes_you_edit_prefs_card_text, new Object[0]), (String) null, this.f34126g.a(t0.likes_you_edit_prefs_card_title, new Object[0]), 8, (DefaultConstructorMarker) null), q0.ic_heart_with_checkmark_purple, i10));
        } else {
            this.f34135p.o(new b.a(new g((String) null, (String) null, this.f34126g.a(t0.likes_you_empty_subscribed_description_other, new Object[0]), (String) null, this.f34126g.a(t0.likes_you_empty_subscribed_title_other, new Object[0]), 8, (DefaultConstructorMarker) null), q0.ic_likes_you_binoculars, i10));
        }
    }

    /* access modifiers changed from: private */
    public static final void l0(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final boolean n0(PurchaseAttribution purchaseAttribution, int i10) {
        boolean z10;
        boolean A = this.f34128i.A("LYDF.Milestone4.Show.Android");
        boolean A2 = this.f34128i.A("LikesYouHardPaywall.Show.Android");
        boolean A3 = this.f34128i.A("UnblurPurchasedLikeAndroid.UnBlur.Android");
        if (purchaseAttribution == null || !purchaseAttribution.isPurchased()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!this.f34143x) {
            if (A) {
                if (!z10 && i10 > 0) {
                    return true;
                }
            } else if (A2) {
                if (!z10 || !A3) {
                    return true;
                }
            } else if (!z10 && i10 > 0) {
                return true;
            }
        }
        return false;
    }

    private final void o0(ea.c cVar) {
        String str;
        Pair[] pairArr = new Pair[5];
        pairArr[0] = gk.h.a("profile id", cVar.e());
        pairArr[1] = gk.h.a(FirebaseAnalytics.Param.INDEX, String.valueOf(cVar.d()));
        pairArr[2] = gk.h.a("max_index", String.valueOf(cVar.c()));
        boolean g10 = cVar.g();
        String str2 = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
        if (g10) {
            str = str2;
        } else {
            str = "false";
        }
        pairArr[3] = gk.h.a("is_blurred", str);
        if (cVar.f() != PurchaseAttribution.PAID_LIKE) {
            str2 = "false";
        }
        pairArr[4] = gk.h.a("received_paid_like", str2);
        Map l10 = h0.l(pairArr);
        j.e(l10, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
        Map c10 = p.c(l10);
        tj.a aVar = this.f34141v;
        ck.b bVar = ck.b.f24947a;
        w<List<String>> L = this.f34127h.G(cVar.e()).L();
        j.f(L, "repository.getGroupsFrom…profileId).firstOrError()");
        LikesYouMatchRepository likesYouMatchRepository = this.f34127h;
        Triple<String, String, Integer> E0 = this.f34137r.E0();
        j.d(E0);
        w<LikesYouGroupEntity> L2 = likesYouMatchRepository.A((String) E0.a()).L();
        j.f(L2, "repository.getGroupById(…e!!.first).firstOrError()");
        aVar.a(bVar.a(L, L2).v(new e0(new LikesYouViewModel$trackItemSelection$1(this))).c(new f0(new LikesYouViewModel$trackItemSelection$2(c10, this))));
    }

    /* access modifiers changed from: private */
    public static final b0 p0(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void q0(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void r0(String str, boolean z10, String str2) {
        String str3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("tab_type", str2);
        if (z10) {
            linkedHashMap.put("tab_type", str2);
        }
        String str4 = "yes";
        if (this.f34143x) {
            str3 = str4;
        } else {
            str3 = "no";
        }
        linkedHashMap.put("is_unlocked", str3);
        if (str != null) {
            linkedHashMap.put("landing_screen", str);
        }
        if (z10) {
            str4 = "no";
        }
        linkedHashMap.put("nav_bar_entry", str4);
        this.f34141v.a(this.f34127h.y().L().D(new c0(LikesYouViewModel$trackLimelight$2.f34164a)).c(new d0(new LikesYouViewModel$trackLimelight$3(linkedHashMap, this))));
    }

    static /* synthetic */ void s0(LikesYouViewModel likesYouViewModel, String str, boolean z10, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = likesYouViewModel.f34126g.a(t0.likes_you_all_my_likes, new Object[0]);
        }
        likesYouViewModel.r0(str, z10, str2);
    }

    /* access modifiers changed from: private */
    public static final Pair t0(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Pair) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void u0(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void v0(int i10, int i11) {
        if (i10 <= 0) {
            this.f34131l.o(null);
        } else if (i10 > i11) {
            t<String> tVar = this.f34131l;
            tVar.o(i11 + "+");
        } else {
            this.f34131l.o(String.valueOf(i10));
        }
    }

    /* access modifiers changed from: private */
    public static final void w(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void x(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void y(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void z(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final LiveData<String> V() {
        return this.f34132m;
    }

    public final io.reactivex.subjects.a<Boolean> W() {
        return this.f34138s;
    }

    public final com.jakewharton.rxrelay2.b<Triple<String, String, Integer>> X() {
        return this.f34137r;
    }

    public final LiveData<a> Y() {
        return this.f34134o;
    }

    public final LiveData<List<s>> Z() {
        return this.f34130k;
    }

    public final LiveData<b> a0() {
        return this.f34136q;
    }

    public final void b0(String str, String str2, int i10) {
        j.g(str, "tabId");
        j.g(str2, "tabName");
        if (this.f34128i.A("LYDF.Milestone3.Show.Android")) {
            this.f34137r.accept(new Triple(str, str2, Integer.valueOf(i10)));
            r0((String) null, true, str2);
        } else if (j.b(str, MainGroups.ALL.b())) {
            this.f34137r.accept(new Triple(str, "", 0));
        } else {
            g0(str, str2, i10);
        }
    }

    public final void c0(ea.c cVar) {
        Integer num;
        j.g(cVar, "gridItem");
        if (cVar.g()) {
            PurchaseSource purchaseSource = new PurchaseSource();
            purchaseSource.e("limelight blurred card");
            purchaseSource.d("Limelight Grid");
            this.f34133n.o(new a.f(purchaseSource));
        } else {
            ArrayList arrayList = new ArrayList();
            for (Triple triple : cVar.a()) {
                String str = (String) triple.a();
                String str2 = (String) triple.b();
                PurchaseAttribution purchaseAttribution = (PurchaseAttribution) triple.c();
                if (purchaseAttribution != null) {
                    num = Integer.valueOf(purchaseAttribution.getPurchaseAttributionInteger());
                } else {
                    num = null;
                }
                arrayList.add(new MatchIdAttribution(str2, str, num));
            }
            t<a> tVar = this.f34133n;
            Triple<String, String, Integer> E0 = this.f34137r.E0();
            j.d(E0);
            tVar.o(new a.d((String) E0.a(), arrayList, cVar.b()));
        }
        o0(cVar);
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        this.f34141v.dispose();
        this.f34142w.dispose();
    }

    public final void d0() {
        PurchaseSource purchaseSource = new PurchaseSource();
        purchaseSource.e("limelight paid blurred card");
        purchaseSource.d("Limelight Grid");
        this.f34133n.o(new a.f(purchaseSource));
    }

    public final void e0(EmptyStateAction emptyStateAction) {
        j.g(emptyStateAction, "action");
        int i10 = c.f34161a[emptyStateAction.ordinal()];
        if (i10 == 1) {
            this.f34133n.o(a.b.f34145a);
        } else if (i10 == 2) {
            this.f34133n.o(a.c.f34146a);
        } else if (i10 == 3) {
            this.f34141v.a(this.f34127h.N(MainGroups.ALL.b()).E(sj.a.a()).c(new g0(new LikesYouViewModel$onEmptyStateCta$1(this))));
        }
    }

    public final void i0() {
        s0(this, "Limelight - List", false, (String) null, 4, (Object) null);
        this.f34141v.a(this.f34139t.c(new h0(new LikesYouViewModel$onLimelightSelected$1(this))));
    }

    public final void m0(int i10) {
        if (i10 == 1) {
            this.f34124e.b("likes_you_curation_v2_dialog_once");
        } else if (i10 == 2) {
            this.f34124e.b("likes_you_curation_v2_dialog_twice");
        }
    }
}
