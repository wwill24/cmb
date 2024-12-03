package com.coffeemeetsbagel.match_view;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.b0;
import androidx.fragment.app.c;
import b6.u;
import com.coffeemeetsbagel.fragments.u0;
import com.coffeemeetsbagel.match_view.m;
import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.products.my_answers.presentation.j0;
import com.coffeemeetsbagel.products.prompts.selection.presentation.PromptSelectionComponentActivity;
import com.coffeemeetsbagel.profile.ProfileView;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.UpsellErrorDialog;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import com.coffeemeetsbagel.util.RequestCode;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class u0 extends u<ProfileView, m.a, MatchViewInteractor> {

    /* renamed from: g  reason: collision with root package name */
    public static final a f34696g = new a((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    private j0 f34697f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements u0.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u0 f34698a;

        b(u0 u0Var) {
            this.f34698a = u0Var;
        }

        public void a(int i10) {
            ((MatchViewInteractor) this.f34698a.f()).b3(i10);
        }

        public void b() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u0(ProfileView profileView, m.a aVar, MatchViewInteractor matchViewInteractor) {
        super(profileView, aVar, matchViewInteractor);
        j.g(profileView, "view");
        j.g(aVar, "component");
        j.g(matchViewInteractor, "interactor");
    }

    /* access modifiers changed from: protected */
    public void k() {
        super.k();
        j0 j0Var = this.f34697f;
        if (j0Var != null) {
            b(j0Var);
        }
    }

    public final void m() {
        ((m.a) e()).n().startActivityForResult(PromptSelectionComponentActivity.f35960m.a(((m.a) e()).n()), RequestCode.ADD_PROMPT);
    }

    public final void n() {
        ((MatchViewInteractor) f()).k3();
    }

    public final void o() {
        UpsellErrorDialog.f36742a.a(((m.a) e()).n());
    }

    public final void p() {
        ((MatchViewInteractor) f()).m3();
    }

    public final void q(boolean z10) {
        ((MatchViewInteractor) f()).n3(z10);
    }

    public final void r(List<Photo> list, int i10) {
        j.g(list, "photos");
        c N0 = com.coffeemeetsbagel.fragments.u0.N0(new ArrayList(list), i10, new b(this));
        FragmentManager supportFragmentManager = ((m.a) e()).n().getSupportFragmentManager();
        j.f(supportFragmentManager, "component.appCompatActiv…().supportFragmentManager");
        b0 p10 = supportFragmentManager.p();
        j.f(p10, "fragmentManager.beginTransaction()");
        p10.e(N0, "MatchViewRouter");
        p10.j();
    }

    public final void s() {
        ((MatchViewInteractor) f()).o3();
    }

    public final void t(boolean z10) {
        ((MatchViewInteractor) f()).p3(z10);
    }

    public final void u() {
        ((MatchViewInteractor) f()).r3();
    }

    public final void v(PurchaseSource purchaseSource) {
        j.g(purchaseSource, "purchaseSource");
        PremiumUpsellComponentActivity.f36846j.b(((m.a) e()).n(), purchaseSource);
    }

    public final void w(int i10) {
        ((MatchViewInteractor) f()).t3(i10);
    }
}
