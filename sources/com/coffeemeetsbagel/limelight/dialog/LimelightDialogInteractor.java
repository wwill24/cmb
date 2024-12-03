package com.coffeemeetsbagel.limelight.dialog;

import b6.s;
import com.coffeemeetsbagel.cmbbottomnav.state.NavStateManager;
import com.coffeemeetsbagel.domain.repository.LikesYouMatchRepository;
import com.coffeemeetsbagel.likes_you.presentation.MainGroups;
import com.uber.autodispose.n;
import hb.c;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class LimelightDialogInteractor extends s<LimelightDialogPresenter, k> {

    /* renamed from: q  reason: collision with root package name */
    public static final a f34362q = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public static final String f34363t = LimelightDialogInteractor.class.getSimpleName();

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f34364f;

    /* renamed from: g  reason: collision with root package name */
    private final String f34365g;

    /* renamed from: h  reason: collision with root package name */
    private final String f34366h;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f34367j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f34368k;

    /* renamed from: l  reason: collision with root package name */
    public LikesYouMatchRepository f34369l;

    /* renamed from: m  reason: collision with root package name */
    public c f34370m;

    /* renamed from: n  reason: collision with root package name */
    public NavStateManager f34371n;

    /* renamed from: p  reason: collision with root package name */
    public s9.a f34372p;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LimelightDialogInteractor(List<String> list, String str, String str2, boolean z10, boolean z11) {
        j.g(list, "imageUrlList");
        j.g(str, "title");
        j.g(str2, "description");
        this.f34364f = list;
        this.f34365g = str;
        this.f34366h = str2;
        this.f34367j = z10;
        this.f34368k = z11;
    }

    /* access modifiers changed from: private */
    public static final void L1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void M1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void R1() {
        P1().f("SP_LIMELIGHT_DIALOG_SHOWN_KEY", true);
    }

    public final LikesYouMatchRepository N1() {
        LikesYouMatchRepository likesYouMatchRepository = this.f34369l;
        if (likesYouMatchRepository != null) {
            return likesYouMatchRepository;
        }
        j.y("likesYouRepository");
        return null;
    }

    public final NavStateManager O1() {
        NavStateManager navStateManager = this.f34371n;
        if (navStateManager != null) {
            return navStateManager;
        }
        j.y("navStateManager");
        return null;
    }

    public final c P1() {
        c cVar = this.f34370m;
        if (cVar != null) {
            return cVar;
        }
        j.y("spManager");
        return null;
    }

    public final void Q1() {
        R1();
    }

    public final void S1() {
        O1().c(NavStateManager.NavState.LIKES_YOU);
        R1();
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        if (this.f34368k) {
            if (this.f34367j) {
                ((LimelightDialogPresenter) this.f7875e).p(this.f34364f.get(0), this.f34365g, this.f34366h);
            } else {
                ((LimelightDialogPresenter) this.f7875e).r(this.f34364f, this.f34365g, this.f34366h);
            }
        } else if (!P1().n("SP_LIMELIGHT_DIALOG_SHOWN_KEY", false)) {
            ((n) N1().B(MainGroups.ALL.b()).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new f(new LimelightDialogInteractor$didBecomeActive$1(this)), new g(LimelightDialogInteractor$didBecomeActive$2.f34373a));
        }
    }
}
