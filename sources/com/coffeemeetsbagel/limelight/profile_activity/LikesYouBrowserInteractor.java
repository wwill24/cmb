package com.coffeemeetsbagel.limelight.profile_activity;

import b6.i;
import b6.u;
import com.coffeemeetsbagel.domain.repository.LikesYouMatchRepository;
import com.coffeemeetsbagel.likesyou.db.LikesYouGroupWithCards;
import com.coffeemeetsbagel.limelight.profile_activity.LikesYouMatchContainerInteractor;
import com.coffeemeetsbagel.match.MatchIdAttribution;
import com.uber.autodispose.t;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class LikesYouBrowserInteractor extends i<q> {

    /* renamed from: m  reason: collision with root package name */
    public static final a f34390m = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final String f34391e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f34392f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final String f34393g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final b f34394h = new b(this);

    /* renamed from: j  reason: collision with root package name */
    public LikesYouMatchRepository f34395j;

    /* renamed from: k  reason: collision with root package name */
    public List<String> f34396k;

    /* renamed from: l  reason: collision with root package name */
    private com.coffeemeetsbagel.likes_you.a<MatchIdAttribution> f34397l;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements LikesYouMatchContainerInteractor.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LikesYouBrowserInteractor f34398a;

        b(LikesYouBrowserInteractor likesYouBrowserInteractor) {
            this.f34398a = likesYouBrowserInteractor;
        }

        public void a(u<?, ?, ?> uVar) {
            j.g(uVar, "childRouter");
            this.f34398a.W1(uVar);
        }
    }

    public LikesYouBrowserInteractor(String str, String str2, String str3) {
        j.g(str, "screenSource");
        j.g(str2, "groupId");
        j.g(str3, "selectedMatchId");
        this.f34391e = str;
        this.f34392f = str2;
        this.f34393g = str3;
    }

    /* access modifiers changed from: private */
    public static final boolean P1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final LikesYouGroupWithCards Q1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (LikesYouGroupWithCards) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void R1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void S1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void W1(u<?, ?, ?> uVar) {
        Unit unit;
        com.coffeemeetsbagel.likes_you.a<MatchIdAttribution> aVar = this.f34397l;
        if (aVar != null) {
            MatchIdAttribution d10 = aVar.d();
            if (d10 == null) {
                ((q) B1()).m();
            } else {
                ((q) B1()).n(this.f34391e, U1(), d10, this.f34394h, uVar);
            }
            unit = Unit.f32013a;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IllegalStateException("queue is null");
        }
    }

    public final LikesYouMatchRepository T1() {
        LikesYouMatchRepository likesYouMatchRepository = this.f34395j;
        if (likesYouMatchRepository != null) {
            return likesYouMatchRepository;
        }
        j.y("likesYouMatchRepository");
        return null;
    }

    public final List<String> U1() {
        List<String> list = this.f34396k;
        if (list != null) {
            return list;
        }
        j.y("profileIds");
        return null;
    }

    public final com.coffeemeetsbagel.likes_you.a<MatchIdAttribution> V1() {
        return this.f34397l;
    }

    public final void X1(List<String> list) {
        j.g(list, "<set-?>");
        this.f34396k = list;
    }

    public final void Y1(com.coffeemeetsbagel.likes_you.a<MatchIdAttribution> aVar) {
        this.f34397l = aVar;
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((t) T1().E(this.f34392f).J(new k(LikesYouBrowserInteractor$didBecomeActive$1.f34399a)).Y(new l(LikesYouBrowserInteractor$didBecomeActive$2.f34400a)).L().E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new m(new LikesYouBrowserInteractor$didBecomeActive$3(this)), new n(new LikesYouBrowserInteractor$didBecomeActive$4(this)));
    }
}
