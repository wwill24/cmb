package com.coffeemeetsbagel.new_user_experience.relationship_goals;

import android.view.View;
import android.view.ViewGroup;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbImageButton;
import com.coffeemeetsbagel.new_user_experience.relationship_goals.RelationshipGoalsPageView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import x1.k;
import x1.m;

public final class RelationshipGoalsPresenter extends p<ViewGroup> {

    /* renamed from: e  reason: collision with root package name */
    private final a f35610e;

    /* renamed from: f  reason: collision with root package name */
    private ViewGroup f35611f;

    /* renamed from: g  reason: collision with root package name */
    private RelationshipGoalPage f35612g;

    /* renamed from: h  reason: collision with root package name */
    private RelationshipGoalPage f35613h;

    /* renamed from: j  reason: collision with root package name */
    private RelationshipGoalsPageView f35614j;

    public interface a {
        static /* synthetic */ void n1(a aVar, RelationshipGoalPage relationshipGoalPage, String str, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 2) != 0) {
                    str = "";
                }
                aVar.C0(relationshipGoalPage, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onNext");
        }

        void C0(RelationshipGoalPage relationshipGoalPage, String str);

        void M(RelationshipGoalPage relationshipGoalPage);

        void N();

        void g(boolean z10);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RelationshipGoalsPresenter(ViewGroup viewGroup, a aVar) {
        super(viewGroup);
        j.g(viewGroup, "view");
        j.g(aVar, "listener");
        this.f35610e = aVar;
    }

    private final void k(RelationshipGoalsPageView relationshipGoalsPageView, int i10) {
        RelationshipGoalsPageView relationshipGoalsPageView2 = this.f35614j;
        ViewGroup viewGroup = null;
        if (relationshipGoalsPageView2 != null) {
            ViewGroup viewGroup2 = this.f35611f;
            if (viewGroup2 == null) {
                j.y("container");
                viewGroup2 = null;
            }
            viewGroup2.removeView(relationshipGoalsPageView2.h());
        }
        ViewGroup viewGroup3 = this.f35611f;
        if (viewGroup3 == null) {
            j.y("container");
        } else {
            viewGroup = viewGroup3;
        }
        x1.p.e(new k(viewGroup, relationshipGoalsPageView.h()), new m(i10));
        this.f35614j = relationshipGoalsPageView;
    }

    /* access modifiers changed from: private */
    public static final void l(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final void A(int i10) {
        ViewGroup viewGroup = this.f35611f;
        if (viewGroup == null) {
            j.y("container");
            viewGroup = null;
        }
        RelationshipGoalsPageView.a aVar = new RelationshipGoalsPageView.a(viewGroup, this.f35610e, RelationshipGoalPage.MARRIAGE, false, 8, (DefaultConstructorMarker) null);
        String str = t9.a.onboardingGoalsQ2;
        j.f(str, "onboardingGoalsQ2");
        RelationshipGoalsPageView.a e10 = aVar.e(str);
        String str2 = t9.a.onboardingGoalsQ2C1;
        j.f(str2, "onboardingGoalsQ2C1");
        RelationshipGoalsPageView.a b10 = e10.b(str2, RelationshipGoalPage.READY_NOW);
        String str3 = t9.a.onboardingGoalsQ2C2;
        j.f(str3, "onboardingGoalsQ2C2");
        RelationshipGoalsPageView.a b11 = b10.b(str3, RelationshipGoalPage.WITHIN_TWO_YEARS);
        String str4 = t9.a.onboardingGoalsQ2C3;
        j.f(str4, "onboardingGoalsQ2C3");
        RelationshipGoalsPageView.a b12 = b11.b(str4, RelationshipGoalPage.AFTER_TWO_YEARS);
        String str5 = t9.a.onboardingGoalsQ2C4;
        j.f(str5, "onboardingGoalsQ2C4");
        k(b12.b(str5, RelationshipGoalPage.NOT_SURE_WHEN).h(this.f35613h).c(), i10);
        if (this.f35613h != null) {
            m(true);
        } else {
            m(false);
        }
    }

    public final String B() {
        RelationshipGoalPage g10;
        RelationshipGoalsPageView relationshipGoalsPageView = this.f35614j;
        if (relationshipGoalsPageView == null || (g10 = relationshipGoalsPageView.g()) == null) {
            return null;
        }
        return g10.d();
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        ((com.uber.autodispose.p) ((CmbImageButton) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_back_button)).a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new k(new RelationshipGoalsPresenter$didLoad$1(this)));
        View findViewById = ((ViewGroup) this.f7869c).findViewById(R.id.slide_container);
        j.f(findViewById, "view.findViewById(R.id.slide_container)");
        this.f35611f = (ViewGroup) findViewById;
        w(8388613);
        if (this.f35612g != null) {
            m(true);
        } else {
            m(false);
        }
    }

    public final void m(boolean z10) {
        ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_next_button).setEnabled(z10);
    }

    public final RelationshipGoalsPageView n() {
        return this.f35614j;
    }

    public final a o() {
        return this.f35610e;
    }

    public final void p(RelationshipGoalPage relationshipGoalPage) {
        this.f35612g = relationshipGoalPage;
    }

    public final void q(RelationshipGoalPage relationshipGoalPage) {
        this.f35613h = relationshipGoalPage;
    }

    public final void r(int i10) {
        ViewGroup viewGroup = this.f35611f;
        if (viewGroup == null) {
            j.y("container");
            viewGroup = null;
        }
        RelationshipGoalsPageView.a aVar = new RelationshipGoalsPageView.a(viewGroup, this.f35610e, RelationshipGoalPage.CASUAL, false, 8, (DefaultConstructorMarker) null);
        String str = t9.a.onboardingGoalsCasual;
        j.f(str, "onboardingGoalsCasual");
        k(aVar.e(str).f(R.string.sounds_good).c(), i10);
    }

    public final void t(int i10) {
        ViewGroup viewGroup = this.f35611f;
        if (viewGroup == null) {
            j.y("container");
            viewGroup = null;
        }
        k(new RelationshipGoalsPageView.a(viewGroup, this.f35610e, RelationshipGoalPage.CASUAL, true).d(R.string.onboarding_goals_casual_message_swipe_right).f(R.string.continue_with_cmb).g(R.string.check_out_other_apps).c(), i10);
    }

    public final void u(int i10) {
        ViewGroup viewGroup = this.f35611f;
        if (viewGroup == null) {
            j.y("container");
            viewGroup = null;
        }
        k(new RelationshipGoalsPageView.a(viewGroup, this.f35610e, RelationshipGoalPage.CASUAL, true).d(R.string.onboarding_goals_casual_message_with_tinder).f(R.string.continue_with_cmb).g(R.string.check_out_tinder).c(), i10);
    }

    public final void v(int i10) {
        ViewGroup viewGroup = this.f35611f;
        if (viewGroup == null) {
            j.y("container");
            viewGroup = null;
        }
        RelationshipGoalsPageView.a aVar = new RelationshipGoalsPageView.a(viewGroup, this.f35610e, RelationshipGoalPage.COMMITTED, false, 8, (DefaultConstructorMarker) null);
        String str = t9.a.onboardingGoalsCommitted;
        j.f(str, "onboardingGoalsCommitted");
        k(aVar.e(str).c(), i10);
    }

    public final void w(int i10) {
        ViewGroup viewGroup = this.f35611f;
        if (viewGroup == null) {
            j.y("container");
            viewGroup = null;
        }
        RelationshipGoalsPageView.a aVar = new RelationshipGoalsPageView.a(viewGroup, this.f35610e, RelationshipGoalPage.FIRST_QUESTION, false, 8, (DefaultConstructorMarker) null);
        String str = t9.a.onboardingGoalsQ1;
        j.f(str, "onboardingGoalsQ1");
        k(aVar.e(str).a(R.string.relationship_goal_marriage, RelationshipGoalPage.MARRIAGE).a(R.string.relationship_goal_committed, RelationshipGoalPage.COMMITTED).a(R.string.relationship_goal_casual, RelationshipGoalPage.CASUAL).a(R.string.relationship_goal_unsure, RelationshipGoalPage.NOT_SURE).a(R.string.relationship_goal_prefer_not_to_say, RelationshipGoalPage.PREFER_NOT_TO_SAY).h(this.f35612g).c(), i10);
    }

    public final void y(int i10) {
        ViewGroup viewGroup = this.f35611f;
        if (viewGroup == null) {
            j.y("container");
            viewGroup = null;
        }
        RelationshipGoalsPageView.a aVar = new RelationshipGoalsPageView.a(viewGroup, this.f35610e, RelationshipGoalPage.NOT_SURE, false, 8, (DefaultConstructorMarker) null);
        String str = t9.a.onboardingGoalsNotSure;
        j.f(str, "onboardingGoalsNotSure");
        k(aVar.e(str).c(), i10);
    }

    public final void z(int i10) {
        ViewGroup viewGroup = this.f35611f;
        if (viewGroup == null) {
            j.y("container");
            viewGroup = null;
        }
        RelationshipGoalsPageView.a aVar = new RelationshipGoalsPageView.a(viewGroup, this.f35610e, RelationshipGoalPage.PREFER_NOT_TO_SAY, false, 8, (DefaultConstructorMarker) null);
        String str = t9.a.onboardingGoalsPreferNotToSay;
        j.f(str, "onboardingGoalsPreferNotToSay");
        k(aVar.e(str).c(), i10);
    }
}
